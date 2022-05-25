/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import BeanPackage.UpdateBeanLocal;
import Models.Address;
import Models.Client;
import Models.Storage;
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
@WebServlet(name = "сreate", urlPatterns = {"/create"})
public class Create extends HttpServlet {
    
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Create</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<h1>Create new record</h1>");
            out.println("<form action=\"create\" method=\"POST\">");
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        this.request = request;
        request.setCharacterEncoding("UTF-8");
        
        int idAddress = updateBeanLocal.toInt(request.getParameter("idAddress"));
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        int num = updateBeanLocal.toInt(request.getParameter("num"));
        int subnum = updateBeanLocal.toInt(request.getParameter("subnum"));
        int flat = updateBeanLocal.toInt(request.getParameter("flat"));
        String extra = request.getParameter("extra");
        
        int idClient = updateBeanLocal.toInt(request.getParameter("idClient"));
        String type = request.getParameter("type");
        String model = request.getParameter("model");
        String ip = request.getParameter("ip");
        
//        boolean paramAddress = checkParametersAddress(idAddress, city, street, num, extra);
//        boolean paramClient = checkParametersClient(idClient, type, model, ip);
        
        boolean paramAddress = updateBeanLocal.checkParametersAddress(idAddress, city, street, num, extra, request);
        boolean paramClient = updateBeanLocal.checkParametersClient(idClient, type, model, ip, request);
        
        if(!paramAddress || !paramClient){
           RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error");
           dispatcher.forward(request, response);
        } else{
            updateBeanLocal.addressList(idAddress, city, street, num, subnum, flat, extra);
            updateBeanLocal.clientList(idClient, type, model, ip);
//            Address address = new Address(idAddress, city, street, num, subnum, flat, extra);
////            addresses = Address.listAddress;
////            addresses.add(address);
            
//            Client client = new Client(idClient, type, model, ip);
////            Storage.addresses.add(address);
////            Storage.clients.add(client);
//            addresses = Client.listAddress;
//            addresses.add(address);
////            Client.listAddress.add(address);//разберись
//            clients = Client.listClient;
//            clients.add(client);
// 
            
//            for (Address a : addresses) {
//                System.out.println("!!!!!!!! " + a.getIdAddress() + " !!!!!!!!" + a.getCity());
//            }
//            for (Client c : clients) {
//                System.out.println("!!!!!!!! " + c.getModel() + " !!!!!!!!" + c.getType());
//            }
            

            response.sendRedirect("http://localhost:8080/datasystem/viewlist");
        }
        
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
    
//    public boolean checkParametersAddress(int idAddress, String city, String street, int num, String extra){
//        boolean rez = false;
//        String regex = "[А-Яа-я0-9 -]*";
//        
//        if (idAddress == 0 || idAddress <=0) {
//            request.setAttribute("msg", "Поле \"idAddress\" не должно равняться нулю/быть меньше нуля");
//            return rez;
//        }
//        
//        if (city.trim().isEmpty()) {
//            request.setAttribute("msg", "Поле \"city\" должно быть заполнено");
//            return rez;
//        }
//        if (!city.matches(regex)) {
//                    request.setAttribute("msg", "В поле \"city\" должны быть символы только русского алфавита");
//                    return rez;
//        }
//        if (city.length()>100) {
//                    request.setAttribute("msg", "В поле \"city\" не должно быть больше 100 символов");
//                    return rez; 
//        }
//         
//        if (street.trim().isEmpty()) {
//           request.setAttribute("msg", "Поле \"street\" должно быть заполнено");
//           return rez;
//        } 
//        if (!street.matches(regex)) {
//           request.setAttribute("msg", "В поле \"street\" должны быть символы только русского алфавита");
//           return rez;
//        }
//        if (street.length()>100) {
//           request.setAttribute("msg", "В поле \"street\" не должно быть больше 100 символов");
//           return rez; 
//        }
// 
//        if (num == 0 || num <=0 ) {
//            request.setAttribute("msg", "Поле \"num\" не должно равняться нулю/быть меньше нуля");
//            return rez;
//        }
//        
//        if (!extra.matches(regex)) {
//           request.setAttribute("msg", "В поле \"extra\" должны быть символы только русского алфавита");
//           return rez;
//        }
//        if (extra.length()>200) {
//           request.setAttribute("msg", "В поле \"extra\" не должно быть больше 200 символов");
//           return rez;
//        }
//        
//        return rez = true;
//    }
//    
//    public boolean checkParametersClient(int idClient, String type, String model, String ip){
//    boolean rez = false;
//    String regex = "[A-Za-z0-9 -/.]*";
//    
//    if (idClient == 0 || idClient <=0) {
//            request.setAttribute("msg", "Поле \"idClient\" не должно равняться нулю/быть меньше нуля");
//            return rez;
//    }
//    
//    if (type.trim().isEmpty()) {
//            request.setAttribute("msg", "Поле \"type\" должно быть заполнено");
//            return rez;
//    }
//    if (!type.matches(regex)) {
//             request.setAttribute("msg", "В поле \"type\" должны быть символы только латинского алфавита");
//             return rez;
//    }
//    if (type.length()>100) {
//             request.setAttribute("msg", "В поле \"type\" не должно быть больше 100 символов");
//             return rez; 
//    }
//    
//    if (model.trim().isEmpty()) {
//            request.setAttribute("msg", "Поле \"model\" должно быть заполнено");
//            return rez;
//    }
//    if (!model.matches(regex)) {
//             request.setAttribute("msg", "В поле \"model\" должны быть символы только латинского алфавита");
//             return rez;
//    }
//    if (model.length()>100) {
//             request.setAttribute("msg", "В поле \"model\" не должно быть больше 100 символов");
//             return rez; 
//    }
//    
//    if (ip.trim().isEmpty()) {
//            request.setAttribute("msg", "Поле \"ip\" должно быть заполнено");
//            return rez;
//    }
//    String regexIp = "^(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[0-9]{2}|[0-9])(\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[0-9]{2}|[0-9])){3}$";
//    if (!ip.matches(regexIp)) {
//             request.setAttribute("msg", "Некорректно введён IP");
//             return rez;
//    }
//    if (ip.length()>25) {
//             request.setAttribute("msg", "В поле \"ip\" не должно быть больше 25 символов");
//             return rez; 
//    }
//    
//    return rez = true;
//    }

}
