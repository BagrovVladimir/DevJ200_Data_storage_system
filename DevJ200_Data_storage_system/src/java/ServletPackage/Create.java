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
@WebServlet(name = "сreate", urlPatterns = {"/create"})
public class Create extends HttpServlet {
    
    HttpServletRequest request;

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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.request = request;
        
        int idAddress = toInt(request.getParameter("idAddress"));
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        int num = toInt(request.getParameter("num"));
        int subnum = toInt(request.getParameter("subnum"));
        int flat = toInt(request.getParameter("flat"));
        String extra = request.getParameter("extra");
        
        checkParametersAddress(city, street, num, extra);
        
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
    
    public int toInt(String s){
        try{
            int i = Integer.parseInt(s);
            return i;
        } catch (NumberFormatException nfe) { 
            System.out.println("NumberFormatException" + nfe.getMessage());
            return 0;
        }
    }
    
    public boolean checkParametersAddress(String city, String street, int num, String extra){
        boolean rez = false;
        String regex = "А-Яа-я0-9 -";
        
        if (city.trim().isEmpty()) {
            request.setAttribute("msg", "Поле \"city\" должно быть заполнено");
            return rez;
        } else{
                if (!city.replaceAll("[" + regex + "]", "").isEmpty()) {
                    request.setAttribute("msg", "В поле \"city\" должны быть символы только русского алфавита");
                    return rez;
                } else {
                   if (city.length()>100) {
                    request.setAttribute("msg", "В поле \"city\" не должно быть больше 100 символов");
                    return rez; 
                }
            }
        }
        
        if (street.trim().isEmpty()) {
           request.setAttribute("msg", "Поле \"street\" должно быть заполнено");
           return rez;
        } else{
                if (!street.replaceAll("[" + regex + "]", "").isEmpty()) {
                    request.setAttribute("msg", "В поле \"street\" должны быть символы только русского алфавита");
                    return rez;
                } else {
                   if (street.length()>100) {
                    request.setAttribute("msg", "В поле \"street\" не должно быть больше 100 символов");
                    return rez; 
                }
            }
        }

        if (num == 0) {
            request.setAttribute("msg", "Поле \"num\" не должно равняться нулю");
            return rez;
        }
        
        if (!extra.replaceAll("[" + regex + "]", "").isEmpty()) {
            request.setAttribute("msg", "В поле \"extra\" должны быть символы только русского алфавита");
            return rez;
        } else {
                if (extra.length()>100) {
                request.setAttribute("msg", "В поле \"extra\" не должно быть больше 100 символов");
                return rez; 
                }
        }
 
        return rez = true;
    }

}
