/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletPackage;

import BeanPackage.UpdateBeanLocal;
import Models.Address;
import Models.Client;
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
@WebServlet(name = "Update", urlPatterns = {"/update"})
public class Update extends HttpServlet {
    
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
//            out.println("<title>Servlet Update</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Update at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
                response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Update</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<h1>Update record</h1>");
            out.println("<h1>Insert data for update</h1>");
            out.println("<form action=\"update\" method=\"POST\">");
            out.println("<h2>Address: </h2>");
            out.println("<h3>idAddress: </h3>");
            out.println("<input type=\"text\" name=\"idAddressUpdate\"  />");
            out.println("<h4>city: </h4>");
            out.println(" <input type=\"text\" name=\"cityUpdate\" />");
            out.println("<h4>street: </h4>");
            out.println("<input type=\"text\" name=\"streetUpdate\" />");
            out.println("<h4>num: </h4>");
            out.println("<input type=\"text\" name=\"numUpdate\" />");
            out.println("<h4>subnum: </h4>");
            out.println("<input type=\"text\" name=\"subnumUpdate\" />");
            out.println("<h4>flat: </h4>");
            out.println("<input type=\"text\" name=\"flatUpdate\" />");
            out.println("<h4>extra: </h4>");
            out.println("<input type=\"text\" name=\"extraUpdate\" />");
            out.println("<h2>Client: </h2>");
            out.println("<h4>idClient: </h4>");
            out.println("<input type=\"text\" name=\"idClientUpdate\" />");
            out.println("<h4>type: </h4>");
            out.println("<input type=\"text\" name=\"typeUpdate\" />");
            out.println("<h4>model: </h4>");
            out.println("<input type=\"text\" name=\"modelUpdate\" />");
            out.println("<h4>ip: </h4>");
            out.println("<input type=\"text\" name=\"ipUpdate\" />");
            out.println("<p><input type=\"submit\" name=\"update\" value=\"Update\" /></p>");
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
//        processRequest(request, response);
//        this.request = request;
        request.setCharacterEncoding("UTF-8");
        
        int idAddress = updateBeanLocal.toInt(request.getParameter("idAddressUpdate"));
        String city = request.getParameter("cityUpdate");
        String street = request.getParameter("streetUpdate");
        int num = updateBeanLocal.toInt(request.getParameter("numUpdate"));
        int subnum = updateBeanLocal.toInt(request.getParameter("subnumUpdate"));
        int flat = updateBeanLocal.toInt(request.getParameter("flatUpdate"));
        String extra = request.getParameter("extraUpdate");
        
        int idClient = updateBeanLocal.toInt(request.getParameter("idClientUpdate"));
        String type = request.getParameter("typeUpdate");
        String model = request.getParameter("modelUpdate");
        String ip = request.getParameter("ipUpdate");
        
        boolean paramAddress = updateBeanLocal.checkParametersAddressUpdate(idAddress, city, street, num, extra, request);
        boolean paramClient = updateBeanLocal.checkParametersClientUpdate(idClient, type, model, ip, request);
        
        if(!paramAddress || !paramClient){
           RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error");
           dispatcher.forward(request, response);
        } else{
            updateBeanLocal.updateAddress(idAddress, city, street, num, subnum, flat, extra);
            updateBeanLocal.updateClient(idClient, type, model, ip);
//            addresses = Client.listAddress;
//            clients = Client.listClient;
            
//        Address tempAddress = null;
//        for (Address address : addresses) {
//            if(address.getIdAddress()==idAddress)
//                tempAddress = address;
//            }
//                if(!city.trim().isEmpty()){
//                  tempAddress.setCity(city);  
//                }
//                if(!street.trim().isEmpty()){
//                  tempAddress.setStreet(street); 
//                }
//                if(num!=0){
//                  tempAddress.setNum(num); 
//                }
//                if(subnum!=0){
//                  tempAddress.setSubnum(subnum);
//                }
//                if(flat!=0){
//                  tempAddress.setFlat(flat);
//                }
//                if(!extra.trim().isEmpty()){
//                  tempAddress.setExtra(extra);
//                }
//        Address addressUpdate = tempAddress;
//        addresses.add(addressUpdate);
//        addresses.remove(tempAddress);
        
//        Client tempClient = null;
//        for (Client client : clients) {
//            if(client.getIdClient()==idClient)//или client.getIdClient()==idClient ?
//                tempClient = client;
//            }
//                if(!type.trim().isEmpty()){
//                  tempClient.setType(type);  
//                }
//                if(!model.trim().isEmpty()){
//                  tempClient.setModel(model); 
//                }
//                if(!ip.trim().isEmpty()){
//                  tempClient.setIp(ip); 
//                }
//        Client clientUpdate = tempClient;
//        clients.add(clientUpdate);
//        clients.remove(tempClient);
        
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
    
//        public boolean checkParametersAddress(int idAddress, String city, String street, int num, String extra){
//        boolean rez = false;
//        String regex = "[А-Яа-я0-9 -]*";
//        
//        if (idAddress == 0 || idAddress <=0) {
//            request.setAttribute("msg", "Поле \"idAddress\" не должно равняться нулю/быть меньше нуля");
//            return rez;
//        }
//        
//        if (!city.matches(regex)) {
//                    request.setAttribute("msg", "В поле \"city\" должны быть символы только русского алфавита");
//                    return rez;
//        }
//        if (city.length()>100) {
//                    request.setAttribute("msg", "В поле \"city\" не должно быть больше 100 символов");
//                    return rez; 
//        }
//         
//        if (!street.matches(regex)) {
//           request.setAttribute("msg", "В поле \"street\" должны быть символы только русского алфавита");
//           return rez;
//        }
//        if (street.length()>100) {
//           request.setAttribute("msg", "В поле \"street\" не должно быть больше 100 символов");
//           return rez; 
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
        
//        public boolean checkParametersClient(int idClient, String type, String model, String ip){
//        boolean rez = false;
//        String regex = "[A-Za-z0-9 -/.]*";
//
//        if (idClient == 0 || idClient <=0) {
//                request.setAttribute("msg", "Поле \"idClient\" не должно равняться нулю/быть меньше нуля");
//                return rez;
//        }
//
//        if (!type.matches(regex)) {
//                 request.setAttribute("msg", "В поле \"type\" должны быть символы только латинского алфавита");
//                 return rez;
//        }
//        if (type.length()>100) {
//                 request.setAttribute("msg", "В поле \"type\" не должно быть больше 100 символов");
//                 return rez; 
//        }
//
//        if (!model.matches(regex)) {
//                 request.setAttribute("msg", "В поле \"model\" должны быть символы только латинского алфавита");
//                 return rez;
//        }
//        if (model.length()>100) {
//                 request.setAttribute("msg", "В поле \"model\" не должно быть больше 100 символов");
//                 return rez; 
//        }
//
//        String regexIp = "^(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[0-9]{2}|[0-9])(\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[0-9]{2}|[0-9])){3}$";
//        if (!ip.matches(regexIp)) {
//                 request.setAttribute("msg", "Некорректно введён IP");
//                 return rez;
//        }
//        if (ip.length()>25) {
//                 request.setAttribute("msg", "В поле \"ip\" не должно быть больше 25 символов");
//                 return rez; 
//        }
//
//        return rez = true;
//    }    

}
