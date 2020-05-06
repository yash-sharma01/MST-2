
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class medicalhome extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                        
            out.println("<html>");
            out.println("<head><title>Home</title></head>");
            out.println("<h3>Add Patient's Details</h3>");
            out.println("<form action='showPatient' method='post'>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>Name</td>");
            out.println("<td><input type='text' name='pname' placeholder='Enter patient name' required></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Aadhaar no:</td>");
            out.println("<td><input type='number' name='ano' placeholder='Enter aadhaar no' required></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Address:</td>");
            out.println("<td><input type='text' name='add' placeholder='Enter patient address' required></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Mobile no:</td>");
            out.println("<td><input type='number' name='mno' placeholder='Enter patient address' required></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td></td>");
            out.println("<td><input type='submit' value='Submit'></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("<a href='index.html'>Log out</a>");
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
