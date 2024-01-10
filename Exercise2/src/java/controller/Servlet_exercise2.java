/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
public class Servlet_exercise2 extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet_exercise2</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet_exercise2 at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String zip = request.getParameter("zip");
        String choose1 = request.getParameter("choose1");
        String select = request.getParameter("select");
        String choose2 = request.getParameter("choose2");
        String cmt = request.getParameter("cmt");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Servlet_exercise1</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Information: </h2>\n"
                + "        <h4>First Name:  "+fname +"</h4>\n"
                + "        <h4>Last Name:  "+lname +"</h4>\n"
                + "        <h4>Email Address:  "+email +"</h4>\n"
                + "        <h4>Address:  "+address +"</h4>\n"
                + "        <h4>City:  "+city +"</h4>\n"
                + "        <h4>Country:  "+country +"</h4>\n"
                + "        <h4>Zip:  "+zip +"</h4>\n"
                + "        <h4>Have purchased books in campus bookstore? "+ choose1 +"</h4>\n"
                + "        <h4>Which bookstore do you shop in? "+ select +"</h4>\n"
                + "        <h4>Have you ever purchased books on the internet? "+ choose2 +"</h4>\n"
                + "        <h4>How does shopping on the internet compared to shopping in a campus bookstore? "+ cmt +"</h4>");
        out.println("</body>");
        out.println("</html>");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
