/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpn.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import longpn.DBUtils.DBUtils;

/**
 *
 * @author tunbe
 */
public class RegistrationDAO {

    Connection conn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public String login(String user, String password) throws SQLException, NamingException{
        String sql = "Select lastname from registration"
                + " Where username = ? "
                + "and password = ?";
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                stm = conn.prepareStatement(sql);
                stm.setString(1, user);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String a = rs.getString(1);
                    return a;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    private List<RegistrationDTO> accountlist;

    public List<RegistrationDTO> getAccountList() {
        return this.accountlist;
    }

    public void searchLastName(String keyword) throws SQLException, NamingException {
        String sql = "Select username, password, lastname, isAdmin"
                + " from registration"
                + " where lastname like ?";
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + keyword + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    RegistrationDTO dto = new RegistrationDTO(username, password, lastname, role);
                    if (this.accountlist == null) {
                        this.accountlist = new ArrayList<>();
                    }
                    this.accountlist.add(dto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public boolean deleteAccount(String username) throws SQLException, NamingException {
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "Delete From registration "
                        + "Where username = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                int affectedRow = stm.executeUpdate();

                if (affectedRow > 0) {
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public boolean updateAccount(String username, String lastname, String password, String isAdmin) throws SQLException, NamingException {
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "update registration "
                        + "set password = ? , lastname = ?, isAdmin = ? "
                        + " Where username = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, password);
                stm.setString(2, lastname);
                stm.setString(3, isAdmin);
                stm.setString(4, username);

                int affectedRow = stm.executeUpdate();

                if (affectedRow > 0) {
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public boolean createrNewAccount(RegistrationDTO dto) throws NamingException, SQLException {
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                String sql = "insert into registration(username, password, lastname, isAdmin)"
                        + "Values(?, ?, ?, ?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, dto.getUsername());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getLastname());
                stm.setBoolean(4, dto.isRole());

                int affectedRow = stm.executeUpdate();

                if (affectedRow > 0) {
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }
}
