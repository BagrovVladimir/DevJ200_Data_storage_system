/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import Entity.ClientXML;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Владимир
 */
@WebServlet(name = "MainPage", urlPatterns = {"/*"})
public class MainPage extends HttpServlet {
    


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MainPage</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<h1>Welcome to Network Clients Data Storage System</h1>");
            out.println("<h3>Create by BagrovVV</h3>");
            out.println("<form action=\"create\" method=\"GET\">");
            out.println("<p><input type=\"submit\" name=\"create\" value=\"Go to Create new record\" /></p>");
            out.println("</form>");
            out.println("<form action=\"update\" method=\"GET\">");
            out.println("<p><input type=\"submit\" name=\"update\" value=\"Go to Update record\" /></p>");
            out.println("</form>");
            out.println("<form action=\"delete\" method=\"GET\">");
            out.println("<p><input type=\"submit\" name=\"delete\" value=\"Go to Delete record\" /></p>");
            out.println("</form>");
            out.println("<form  action=\"viewlist\" method=\"GET\">");
            out.println("<p><input type=\"submit\" name=\"viewlist\" value=\"Go to View the List of all records\" /></p>");
            out.println("</form>");
            out.println("<form  action=\"checksax\" method=\"GET\">");
            out.println("<p><input type=\"submit\" name=\"checksax\" value=\"Go to View the List of Clients From XML with SAX\" /></p>");
            out.println("</form>");
            out.println("<form  action=\"checkdom\" method=\"GET\">");
            out.println("<p><input type=\"submit\" name=\"checkdom\" value=\"Go to View the List of Clients From XML with DOM\" /></p>");
            out.println("</form>");
            out.println("<form  action=\"test\" method=\"GET\">");
            out.println("<p><input type=\"submit\" name=\"test\" value=\"Test\" /></p>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
       System.out.println("Test"); 
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
