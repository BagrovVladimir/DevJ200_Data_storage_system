/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import BeanPackage.UpdateBeanLocal;
import Entity.Address;
import Entity.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Владимир
 */
@WebServlet(name = "Delete", urlPatterns = {"/delete"})
public class Delete extends HttpServlet {
    
    @EJB
            UpdateBeanLocal updateBeanLocal;
    
//    HttpServletRequest request;
//    List <Address> addresses;
//    List <Client> clients;

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
//            out.println("<title>Servlet Delete</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Delete at " + request.getContextPath() + "</h1>");
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
            out.println("<title>Servlet Delete</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<h1>Delete record</h1>");
            out.println("<form action=\"delete\" method=\"POST\">");
            out.println("<h3>Введите id объекта для его удаления</h3>");
            out.println("<input type=\"text\" name=\"id\"/>");
            out.println("<p><input type=\"submit\" name=\"delete\" value=\"Delete record\" /></p>");
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = updateBeanLocal.toInt(request.getParameter("id"));
//        updateBeanLocal.removeAddress(id);
        updateBeanLocal.removeClient(id);
        

//        
////        addresses = new ArrayList<>();
////        clients = new ArrayList<>();
        
//        addresses = Client.listAddress;
//        clients = Client.listClient;
//        
//        Address temp = null;
//        for (Address address : addresses) {
//            if(address.getIdAddress()==id)
//                temp = address;
//        }
//       addresses.remove(temp);
//       
//       Client temp2 = null;
//        for (Client client : clients) {
//            if(client.getIdClient()==id)
//                temp2 = client;  
//        }
//       clients.remove(temp2);
       
////       Client.listAddress = addresses;
////       Client.listClient = clients;

        
        response.sendRedirect("http://localhost:8080/datasystem/viewlist");
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
    
//    public int toInt(String s){
//        try{
//            int i = Integer.parseInt(s);
//            return i;
//        } catch (NumberFormatException nfe) { 
//            System.out.println("NumberFormatException" + nfe.getMessage());
//            return 0;
//        }
//    }

}
