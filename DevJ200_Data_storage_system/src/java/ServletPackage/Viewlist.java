/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import Models.Address;
import Models.Client;
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
@WebServlet(name = "Viewlist", urlPatterns = {"/viewlist"})
public class Viewlist extends HttpServlet {
    
    HttpServletRequest request;
    List <Address> adresses;
    List <Client> clients;

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
        request.setCharacterEncoding("UTF-8");
        this.request = request;
        adresses = Address.listAddress;
        clients = Client.listClient;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Viewlist</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<h1>List of all records</h1>");
            out.println("<form action=\"Viewlist\" method=\"GET\">");
            out.println("<table border = \"1\">");
            out.println("<tr>");
            out.println("<th>idAddress=idClient</th>");
            out.println("<th>Город</th>");
            out.println("<th>Улица</th>");
            out.println("<th>Номер дома</th>");
            out.println("<th>Корпус</th>");
            out.println("<th>Номер квартиры</th>");
            out.println("<th>Дополнительно</th>");
            out.println("<th>Тип устройства</th>");
            out.println("<th>Модель устройства</th>");
            out.println("<th>Сетевой адрес устройства</th>");
            out.println("</tr>");
            if(adresses!=null && !adresses.isEmpty()){
                for (Address a : adresses) {
                out.println("<tr>");
                out.println("<td>" + "a.getIdAddress()" + "</td>");
                out.println("<td>" + "a.getCity()" + "</td>");
                out.println("<td>" + "a.getStreet()"  + "</td>");
                out.println("<td>" + "a.getNum()"  + "</td>");
                out.println("<td>" + "a.getSubnum()"  + "</td>");
                out.println("<td>" + "a.getFlat()" + "</td>");
                out.println("<td>" + "a.getExtra()" + "</td>");
                }
            }
            if(clients!=null && !clients.isEmpty()){
                for (Client c : clients) {
                out.println("<td>" + "c.getType()" + "</td>");
                out.println("<td>" + "c.getModel()" + "</td>");
                out.println("<td>" + "c.getIp()" + "</td>");
                out.println("</tr>");
                }
            } 
            out.println("</table>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
