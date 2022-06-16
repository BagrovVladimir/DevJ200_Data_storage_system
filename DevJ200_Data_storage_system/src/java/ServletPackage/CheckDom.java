/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import BeanPackage.TransformerLocal;
import Entity.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Владимир
 */
@WebServlet(name = "CheckDom", urlPatterns = {"/checkdom"})
public class CheckDom extends HttpServlet {
    
     @EJB
            TransformerLocal transformerLocal;
    
    HttpServletRequest request;
    List<Client> clients;

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
        this.request = request;
        clients = transformerLocal.getClientListDOM();
        
        clients = transformerLocal.filterModel(request, clients);
        if (clients == null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error");
            dispatcher.forward(request, response);
        } else{
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet CheckDom</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<div>");
                out.println("<form action=\"checksax\" method=\"GET\">");
                out.println("<h2>Фильтр по модели устройства</h2>");
                out.println("<h3>Внимание! Название модели вводится маленькими буквами</h3>");
                out.println("<p><input type=\"text\" name=\"modelFilter\"/></p>");
                out.println("<p><input type=\"submit\" value=\"Фильтровать\"/></p>");
                out.println("</form>");
                out.println("</div>");
                out.println("<div>");
                out.println("<table border = \"1\">");
                out.println("<tr>");
                out.println("<th>idClient</th>");
                out.println("<th>Тип устройства</th>");
                out.println("<th>Модель устройства</th>");
                out.println("<th>Сетевой адрес устройства</th>");
                out.println("</tr>");
                if (clients != null && !clients.isEmpty()) {
    //                for (ClientXML c : clients)
                    for (Client c : clients) {
                        out.println("<tr>");
                                out.println("<td>" + c.getIdclient() + "</td>");
                                out.println("<td>" + c.getType() + "</td>");
                                out.println("<td>" + c.getModel() + "</td>");
                                out.println("<td>" + c.getIp() + "</td>");
                                out.println("</tr>"); 
                    } 
                }
                out.println("</table>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
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
