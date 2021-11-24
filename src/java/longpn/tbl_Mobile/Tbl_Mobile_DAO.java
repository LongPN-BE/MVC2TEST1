/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpn.tbl_Mobile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import longpn.DBUtils.DBUtils;

/**
 *
 * @author tunbe
 */
public class Tbl_Mobile_DAO {

    Connection conn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    private List<Tbl_Mobile_DTO> list;

    public List<Tbl_Mobile_DTO> getList() {
        return list;
    }

    public void searchMobileName(String keyword) throws SQLException, NamingException {
        String sql = "Select mobileID,mobilename,ProductDescription,Price "
                + "From tbl_Mobile"
                + " where mobilename like ? ";
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + keyword + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String mobileID = rs.getNString("mobileID");
                    String mobilename = rs.getNString("mobilename");
                    String desciption = rs.getNString("ProductDescription");
                    int price = rs.getInt("Price");
                    Tbl_Mobile_DTO dto = new Tbl_Mobile_DTO(mobileID, mobilename, desciption, price);
                    if (list == null) {
                        this.list = new ArrayList<>();
                    }
                    this.list.add(dto);
                }
            }
        } catch (SQLException ex) {

        } catch (NamingException ex) {

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

    public int getNewCheckID() throws SQLException, NamingException {
        
        String sql = "SELECT TOP 1 checkoutID FROM tbl_Checkout ORDER BY checkoutID DESC";
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int lastCheckOutID = rs.getInt("checkoutID");
                    return ++lastCheckOutID;
                }
            }
        } catch (SQLException ex) {
            
        } catch (NamingException ex) {
            
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
        return 0;
    }

    public boolean checkOut(int Id, String keyword, int quanity) throws SQLException, NamingException {
        String sql = "insert into tbl_Checkout(checkoutID,mobileID,quantity,times) values ( ?, ?, ?, GETDATE() )";
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                stm = conn.prepareStatement(sql);
                stm.setInt(1, Id);
                stm.setString(2, keyword);
                stm.setInt(3, quanity);
                int affectedRow = stm.executeUpdate();

                if (affectedRow > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {

        } catch (NamingException ex) {

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
