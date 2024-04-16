/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Cart;
import service.BookService;

/**
 *
 * @author Admin
 */
public class Home_Servlet extends HttpServlet {

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
        request.setAttribute("listc", bookService.getAllCategory());
        request.setAttribute("listb", bookService.getAllBook());
        HttpSession session = request.getSession();
        // cookie
        Cookie[] cookies = request.getCookies();
        String txt = "";
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("cart")) {
                    txt += c.getValue();
                    
                }
            }
        }
        Cart c = new Cart(txt, bookService.getAllBook());
        int n = c.getNumberItem();
        session.setAttribute("n", n);
        //end cookie
        request.getRequestDispatcher("Views/Home.jsp").forward(request, response);
    }

}
