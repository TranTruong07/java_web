/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;
import service.OrderService;

/**
 *
 * @author Admin
 */
public class Order_Servlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        // cookie
        Cookie[] cookies = request.getCookies();
        String txt = "";
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("cart")) {
                    txt += c.getValue();
                    OrderService orderService = OrderService.getInstance();
                    if (orderService.orderItems(u, txt)) {
                        c.setMaxAge(0);
                        response.addCookie(c);
                        response.sendRedirect("Home");
                    }
                }
            }
        }

    }

    

}
