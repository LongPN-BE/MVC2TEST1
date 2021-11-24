/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpn.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import longpn.DBUtils.MyApplicationConstant.LoginFeature;
import longpn.registration.RegistrationDAO;

/**
 *
 * @author tunbe
 */
@WebServlet(name = "StratupApplicationServlet", urlPatterns = {"/StratupApplicationServlet"})
public class StratupApplicationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = this.getServletContext();
        Properties properties = (Properties) context.getAttribute("SITEMAP");
        LoginFeature login = null;
        String url = properties.getProperty(login.LOGIN_PAGE);
        try {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                Cookie lastCookie = cookies[0];
                for (Cookie cookie : cookies) {
                    if (!cookie.getName().equals("JSESSIONID")) {
                        lastCookie = cookie;
                    }
                }

                String username = lastCookie.getName();
                String password = lastCookie.getValue();

                RegistrationDAO dao = new RegistrationDAO();
                String result = dao.login(username, password);

                if (result != null) {
                    url = properties.getProperty(login.LOGIN_CONTROL);
                    url += "?btnAction=Login"
                            + "&txtUsername=" + lastCookie.getName()
                            + "&txtPassword=" + lastCookie.getValue();
                }
            }
        } catch (SQLException ex) {
            log("StarupApplicationServlet SQL :" + ex.getMessage());
        } catch (NamingException ex) {
            log("StarupApplicationServlet Naming :" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
