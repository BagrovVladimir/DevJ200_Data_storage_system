/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import Models.Address;
import Models.Client;
import static Models.Client.listAddress;
import static Models.Client.listClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
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
    List <Address> addresses;
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
        
        Address address1 = new Address(1, "Питер", "Первая", 1, 1, 1, "Тест1");
        Address address2 = new Address(2, "Москва", "Вторая", 2, 2, 2, "Тест2");
        addresses = new ArrayList<>();
        clients = new ArrayList<>();
        addresses.add(address1);
        addresses.add(address2);
        
        Client client1 = new Client(1, "Note", "Lenovo", "192.168.000.001");
         Client client2 = new Client(2, "Smart", "Samsung", "192.168.000.002");
         clients.add(client1);
        clients.add(client2); 
//        
//        adresses = Address.listAddress;
//        addresses = Client.listAddress;
//        clients = Client.listClient;
        
        filterStreet();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Viewlist</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<div>");
//            out.println("<h1>List of all records</h1>");
//            out.println("<form action=\"Viewlist\" method=\"GET\">");
//            out.println("<table border = \"1\">");
//            out.println("<tr>");
//            out.println("<th>idAddress</th>");
//            out.println("<th>Город</th>");
//            out.println("<th>Улица</th>");
//            out.println("<th>Номер дома</th>");
//            out.println("<th>Корпус</th>");
//            out.println("<th>Номер квартиры</th>");
//            out.println("<th>Дополнительно</th>");
//            out.println("</tr>");
//            if(addresses!=null && !addresses.isEmpty()){
//                for (Address a : addresses) {
//                    out.println("<tr>");
//                    out.println("<td>" + a.getIdAddress() + "</td>");
//                    out.println("<td>" + a.getCity() + "</td>");
//                    out.println("<td>" + a.getStreet()  + "</td>");
//                    out.println("<td>" + a.getNum()  + "</td>");
//                    out.println("<td>" + a.getSubnum()  + "</td>");
//                    out.println("<td>" + a.getFlat() + "</td>");
//                    out.println("<td>" + a.getExtra() + "</td>");
//                    out.println("</tr>");
//                }
//            }
//            out.println("</table>");
//            
//            out.println("<p></p>");
//            
//            out.println("<table border = \"1\">");
//            out.println("<tr>");
//            out.println("<th>idClient</th>");
//            out.println("<th>Тип устройства</th>");
//            out.println("<th>Модель устройства</th>");
//            out.println("<th>Сетевой адрес устройства</th>");
//            out.println("</tr>");
//            if(clients!=null && !clients.isEmpty()){
//                for (Client c : clients) {   
//                out.println("<tr>");
//                out.println("<td>" + c.getIdClient() + "</td>");
//                out.println("<td>" + c.getType() + "</td>");
//                out.println("<td>" + c.getModel() + "</td>");
//                out.println("<td>" + c.getIp() + "</td>");
//                out.println("</tr>");
//                }
//            } 
//            out.println("</table>");
//            out.println("</form>");
//            out.println("</div>");
//            out.println("</body>");
//            out.println("</html>");
            

                    
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Viewlist</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<h1>List of all records</h1>");
            out.println("<form action=\"Viewlist\" method=\"GET\">");
            out.println("<h2>Фильтр по улице</h2>");
            out.println("<p><input type=\"text\" name=\"streetFilter\"/></p>");
            out.println("<p><input type=\"submit\" value=\"Фильтровать\"/></p>");

            out.println("<table border = \"1\">");
            out.println("<tr>");
            out.println("<th>idAddress</th>");
            out.println("<th>Город</th>");
            out.println("<th>Улица</th>");
            out.println("<th>Номер дома</th>");
            out.println("<th>Корпус</th>");
            out.println("<th>Номер квартиры</th>");
            out.println("<th>Дополнительно</th>");
            out.println("<th>idClient</th>");
            out.println("<th>Тип устройства</th>");
            out.println("<th>Модель устройства</th>");
            out.println("<th>Сетевой адрес устройства</th>");
            out.println("</tr>");
            if(clients!=null && !clients.isEmpty()){
                for (Client c : clients) { 
                    if(addresses!=null && !addresses.isEmpty()){
                        for (Address a : addresses) {
                            if(c.getIdClient()!=a.getIdAddress()) 
                                continue;
                            
                            out.println("<tr>");
                            out.println("<td>" + a.getIdAddress() + "</td>");
                            out.println("<td>" + a.getCity() + "</td>");
                            out.println("<td>" + a.getStreet()  + "</td>");
                            out.println("<td>" + a.getNum()  + "</td>");
                            out.println("<td>" + a.getSubnum()  + "</td>");
                            out.println("<td>" + a.getFlat() + "</td>");
                            out.println("<td>" + a.getExtra() + "</td>");
                            out.println("<td>" + c.getIdClient() + "</td>");
                            out.println("<td>" + c.getType() + "</td>");
                            out.println("<td>" + c.getModel() + "</td>");
                            out.println("<td>" + c.getIp() + "</td>");
                            out.println("</tr>");
                        }
                    }
                }
            } 
            out.println("</table>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");      
        }
        for (Address a : addresses) {
                System.out.println("!!!!!!!! " + a.getIdAddress() + " !!!!!!!!" + a.getCity());
            }
            for (Client c : clients) {
                System.out.println("!!!!!!!! " + c.getModel() + " !!!!!!!!" + c.getType());
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

    private List<Address> filterStreet() {
        String street = Objects.toString(request.getParameter("streetFilter"), "");
        List<Address> temp = new LinkedList<>();
        for (Address address : addresses) {
            if (address.getStreet().contains(street)) 
                temp.add(address);
        }
//        if(!temp.isEmpty()) 
//            addresses = new ArrayList<>();
        
        return temp;
    }
    
    
    

}
