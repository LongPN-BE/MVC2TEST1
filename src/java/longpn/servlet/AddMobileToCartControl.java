/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpn.servlet;

import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import longpn.cart.CartObject;


/**
 *
 * @author tunbe
 */
@WebServlet(name = "AddMobileToCartControl", urlPatterns = {"/AddMobileToCartControl"})
public class AddMobileToCartControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String valueSearch = request.getParameter("txtSearchValue");
         try {
            HttpSession session = request.getSession();
            CartObject cart = (CartObject) session.getAttribute("CARTMOBILE");
            if (cart == null) {
                cart = new CartObject();
            }
            String name = request.getParameter("txtMobileID");
            cart.addItemToCart(name);

            session.setAttribute("CARTMOBILE", cart);

        } finally {
            ServletContext context = this.getServletContext();
            Properties properties = (Properties) context.getAttribute("SITEMAP");
            String url = properties.getProperty("searchMobileControl");
            url += "?txtSearchValue=" +valueSearch;
            response.sendRedirect(url);
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
