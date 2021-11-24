/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import longpn.DBUtils.MyApplicationConstant.DispactchFeature;

/**
 *
 * @author tunbe
 */
@WebServlet(name = "DispatcherServlet", urlPatterns = {"/DispatcherServlet"})
public class DispatcherServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        ServletContext context = this.getServletContext();
        Properties properties = (Properties) context.getAttribute("SITEMAP");

        String url = properties.getProperty("");
        String button = request.getParameter("btnAction");
        DispactchFeature dispatch = null;
        try {
            if (button == null) {

            } else if ("Login".equals(button)) {
                url = properties.getProperty(dispatch.LOGIN_CONTROL);
            } else if ("Search".equals(button)) {
                url = properties.getProperty(dispatch.SEARCH_CONTROL);
            } else if ("Delete".equals(button)) {
                url = properties.getProperty(dispatch.DELETE_CONTROL);
            } else if ("Update".equals(button)) {
                url = properties.getProperty(dispatch.UPDATE_CONTROL);
            } else if ("Add to Cart".equals(button)) {
                url = properties.getProperty(dispatch.ADDTOCART_CONTROL);
            } else if ("View cart".equals(button)) {
                url = properties.getProperty("cartPage");
            } else if ("Remove Book".equals(button)) {
                url = properties.getProperty(dispatch.REMOVEFROMBOOK_CONTROL);
            } else if ("Sign Up".equals(button)) {
                url = properties.getProperty(dispatch.SIGNUP_CONTROL);
            } else if ("Log out".equals(button)) {
                url = properties.getProperty(dispatch.LOGOUT_CONTROL);
            } else if ("Add Mobile To Cart".equals(button)) {
                url = properties.getProperty(dispatch.ADDMOBILETOCART_CONTROL);
            } else if ("Search Mobile".equals(button)) {
                url = properties.getProperty("searchMobileControl");
            } else if ("Remove Mobile From Cart".equals(button)) {
                url = properties.getProperty("removeMobileFromCartControl");
            } else if ("Check Out".equals(button)) {
                url = properties.getProperty("checkOutMobile");
            }

        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            out.close();
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
