
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class updatedReport extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession s = request.getSession();
            String username = s.getAttribute("username").toString();
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/COVID-19","gov","gov");
            
            PreparedStatement ps = con.prepareStatement("select * from record");
            ResultSet rs = ps.executeQuery();
                  
            out.println("<table border='1px'>");
            out.println("<th>UID</th>");
            out.println("<th>Name</th>");
            out.println("<th>Aadhaar No</th>");
            out.println("<th>Address</th>");
            out.println("<th>Mobile No</th>"); 
            out.println("<th>Report Result</th>");
            out.println("<th>Edit</th>");
                
            while(rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getString("uid")+"</td>");
                out.println("<td>"+rs.getString("name")+"</td>");
                out.println("<td>"+rs.getString("aadhaar")+"</td>");
                out.println("<td>"+rs.getString("address")+"</td>");
                out.println("<td>"+rs.getString("mobileno")+"</td>");
                out.println("<td>"+rs.getString("report_result")+"</td>");
                out.println("<td>"+"<a class='edit' href='edit?uid=" + rs.getString("uid")+"'>Edit</a>"+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br><a href='index.html'>Log out</a>");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updatedReport.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(updatedReport.class.getName()).log(Level.SEVERE, null, ex);
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
