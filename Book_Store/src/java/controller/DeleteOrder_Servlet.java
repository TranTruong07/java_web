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
import service.OrderService;

/**
 *
 * @author Admin
 */
public class DeleteOrder_Servlet extends HttpServlet {

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
            int oid = Integer.parseInt(request.getParameter("id"));
            OrderService orderService = OrderService.getInstance();
            if (orderService.deleteOrder(oid)) {
                request.setAttribute("msg_s", "Remove Order Successful...");
                request.setAttribute("listOrder", orderService.getAllOrders());
                request.getRequestDispatcher("Views/OrderManagement.jsp").forward(request, response);
            } else {
                request.setAttribute("msg_f", "Remove Order fail, check database...");
                request.setAttribute("listOrder", orderService.getAllOrders());
                request.getRequestDispatcher("Views/OrderManagement.jsp").forward(request, response);
            }
        } catch (ServletException | IOException | NumberFormatException e) {
            System.out.println(e);
        }
    }

}
