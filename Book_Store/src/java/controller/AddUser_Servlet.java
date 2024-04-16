/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Role;
import models.User;
import service.UserService;

/**
 *
 * @author Admin
 */
public class AddUser_Servlet extends HttpServlet {
   
   

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
        UserService userService = UserService.getInstance();
        request.setAttribute("listrole", userService.getAllRole());
        request.getRequestDispatcher("Views/AddUser.jsp").forward(request, response);
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
        try {
            UserService userService = UserService.getInstance();
            request.setAttribute("listrole", userService.getAllRole());
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            int roleid = Integer.parseInt(request.getParameter("roleid"));
            System.out.println(email);
            if(userService.addUser(new User(roleid, name, email, password, new Role(roleid, "")))){
                request.setAttribute("msg_s", "Add User Successful...");
                request.getRequestDispatcher("Views/AddUser.jsp").forward(request, response);
            }else{
                request.setAttribute("msg_f", "Add User fail...");
                request.getRequestDispatcher("Views/AddUser.jsp").forward(request, response);
            }
            
        } catch (ServletException | IOException | NumberFormatException e) {
            System.out.println(e);
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
