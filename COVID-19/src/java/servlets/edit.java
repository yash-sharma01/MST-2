
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

public class edit extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                        
            String uid = request.getParameter("uid");
               
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/COVID-19","gov","gov");

            PreparedStatement st = con.prepareStatement("select * from record where uid = ?");
            st.setString(1, uid);
            ResultSet rs = st.executeQuery();
                
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Edit Report</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Edit Report</h3>");            
            
            while(rs.next())
            {
                out.println("<form action='updateq' method='post'>");
                out.println("<table>");
                out.println("<tr>");
                out.println("<td>UID</td>");
                out.println("<td><input type='text' name='uid' value='" +rs.getString("uid")+ "' readonly/></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Name</td>");
                out.println("<td><input type='text' name='pname' value='" +rs.getString("name")+ "' readonly/></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Aadhaar no:</td>");
                out.println("<td><input type='number' name='ano' value='" +rs.getString("aadhaar")+ "' readonly/></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Address:</td>");
                out.println("<td><input type='text' name='add'  value='" +rs.getString("address")+ "' readonly/></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Mobile no:</td>");
                out.println("<td><input type='number' name='mno'  value='" +rs.getString("mobileno")+ "' readonly/></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Report Result:</td>");
                out.println("<td><input type='text' name='report'  value='" +rs.getString("report_result")+ "'/></td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td></td>");
                out.println("<td><input type='submit' value='UPDATE'></td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</form>");
            }
            out.println("</html>");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(edit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(edit.class.getName()).log(Level.SEVERE, null, ex);
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
