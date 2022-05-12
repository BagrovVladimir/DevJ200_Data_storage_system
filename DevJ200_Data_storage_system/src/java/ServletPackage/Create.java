/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Владимир
 */
@WebServlet(name = "Create", urlPatterns = {"/create"})
public class Create extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Create</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Create at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Create</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<h1>Create new record</h1>");
            out.println("<form action=\"viewlist\" method=\"GET\">");
            out.println("<h2>Address: </h2>");
            out.println("<h3>idAddress: </h3>");
            out.println("<input type=\"text\" name=\"idAddress\"  />");
            out.println("<h4>city: </h4>");
            out.println(" <input type=\"text\" name=\"city\" />");
            out.println("<h4>street: </h4>");
            out.println("<input type=\"text\" name=\"street\" />");
            out.println("<h4>num: </h4>");
            out.println("<input type=\"text\" name=\"num\" />");
            out.println("<h4>subnum: </h4>");
            out.println("<input type=\"text\" name=\"subnum\" />");
            out.println("<h4>flat: </h4>");
            out.println("<input type=\"text\" name=\"flat\" />");
            out.println("<h4>extra: </h4>");
            out.println("<input type=\"text\" name=\"extra\" />");
            out.println("<h2>Client: </h2>");
            out.println("<h4>idClient: </h4>");
            out.println("<input type=\"text\" name=\"idClient\" />");
            out.println("<h4>type: </h4>");
            out.println("<input type=\"text\" name=\"city\" />");
            out.println("<h4>street: </h4>");
            out.println("<input type=\"text\" name=\"type\" />");
            out.println("<h4>model: </h4>");
            out.println("<input type=\"text\" name=\"model\" />");
            out.println("<h4>ip: </h4>");
            out.println("<input type=\"text\" name=\"ip\" />");
            out.println("<p><input type=\"submit\" name=\"create\" value=\"Create\" /></p>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

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
