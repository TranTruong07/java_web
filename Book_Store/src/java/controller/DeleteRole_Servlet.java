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
import service.UserService;

/**
 *
 * @author Admin
 */
public class DeleteRole_Servlet extends HttpServlet {
   

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
        try {
            int roleid = Integer.parseInt(request.getParameter("roleid"));
            UserService userService = UserService.getInstance();
            if (userService.removeRole(roleid)) {
                response.sendRedirect("RoleManagement");
            } else {
                request.setAttribute("msg_f", "Remove Role fail, Please delete data related to this role");
                request.setAttribute("listRole", userService.getAllRole());
                request.getRequestDispatcher("Views/RoleManagement.jsp").forward(request, response);
            }
        } catch (ServletException | IOException | NumberFormatException e) {
            System.out.println(e);
        }
    } 

    
}
