
package ServletPackage;

import BeanPackage.TransformerLocal;
import Entity.Client;
import Entity.ClientXML;
import Services.CreaterXML;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

@WebServlet(name = "CheckSAX", urlPatterns = {"/checksax"})
public class CheckSAX extends HttpServlet {
    
    @EJB
            TransformerLocal transformerLocal;
    
    HttpServletRequest request;
    List<Client> clients;
//    List <ClientXML> clients;
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParserConfigurationException, SAXException {
        this.request = request;
        
//        SAXParserFactory factory = SAXParserFactory.newInstance();
//        SAXParser parser = factory.newSAXParser();
//        
//        parser.parse("Clients.xml", new DemoSAX());
        System.out.println("SIZE CLIENTS XML: " + ClientXML.listClient.size());
        clients = transformerLocal.getClientListSAX();
//        clients = ClientXML.listClient;
        clients.forEach(System.out::println);
        
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
                out.println("<title>Servlet CheckSAX</title>");            
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
        try {
            processRequest(request, response);
        } catch (ParserConfigurationException ex) {
            System.out.println("Error ParserConfigurationException: " + ex.getMessage());
        } catch (SAXException ex) {
            System.out.println("Error SAXException: " + ex.getMessage());
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
        try {
            processRequest(request, response);
        } catch (ParserConfigurationException ex) {
            System.out.println("Error ParserConfigurationException: " + ex.getMessage());
        } catch (SAXException ex) {
            System.out.println("Error SAXException: " + ex.getMessage());
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

}
