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
import service.BookService;
import service.OrderService;
import service.UserService;

/**
 *
 * @author Admin
 */
public class HomeAdmin_Servlet extends HttpServlet {
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
        BookService bookService = BookService.getInstance();
        OrderService orderService = OrderService.getInstance();
        request.setAttribute("quantityuser", userService.getQuantityUser()+"");
        request.setAttribute("quantitybook", bookService.getQuantityBook()+"");
        request.setAttribute("quantitycategory", bookService.getQuantityCategory()+"");
        request.setAttribute("quantityOrder", orderService.getQuantityOrder()+"");
        request.getRequestDispatcher("Views/HomeAdmin.jsp").forward(request, response);
    } 

    
}
