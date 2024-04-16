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
import java.util.List;
import models.Book;
import service.BookService;

/**
 *
 * @author Admin
 */
public class FindProductByPrice_Servlet extends HttpServlet {

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
        BookService bookService = BookService.getInstance();
        try {
            int price = Integer.parseInt(request.getParameter("price"));
            if (price == 1000) {
                response.sendRedirect("Home");
                return;
            }
            List<Book> listb = bookService.getBooksByPrice(price);
            request.setAttribute("select", price + "");
            request.setAttribute("listc", bookService.getAllCategory());
            request.setAttribute("listb", listb);
            request.getRequestDispatcher("Views/Home.jsp").forward(request, response);
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }
    }

}