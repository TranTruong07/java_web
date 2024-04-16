/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.UserDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Role;
import models.User;
import service.BookService;

/**
 *
 * @author Admin
 */
public class RegisterServlet extends HttpServlet {
   
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
        BookService bookService = BookService.getInstance();
        request.setAttribute("listc", bookService.getAllCategory());
        request.getRequestDispatcher("Views/Register.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        UserDao ud = new UserDao();
        boolean check = ud.addUser(new User(0, name, email, pass, new Role(1, "")));
        BookService bookService = BookService.getInstance();
        request.setAttribute("listc", bookService.getAllCategory());
        if(check){
            request.setAttribute("msg_s", "Regist successful");
            request.getRequestDispatcher("Views/Register.jsp").forward(request, response);
        }else{
            request.setAttribute("msg_f", "Regist fail, maybe duplicate email");
            request.getRequestDispatcher("Views/Register.jsp").forward(request, response);
        }
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
