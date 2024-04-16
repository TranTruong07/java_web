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
import models.Cart;
import service.BookService;
import service.OrderService;

/**
 *
 * @author Admin
 */
public class Buy_Servlet extends HttpServlet {

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
            int id = Integer.parseInt(request.getParameter("id"));
            OrderService orderService = OrderService.getInstance();
            //cookie
            Cookie[] cookies = request.getCookies();
            String txt = "";
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("cart")) {
                        txt += c.getValue();
                        c.setMaxAge(0);
                        response.addCookie(c);
                    }
                }
            }
            if (txt.isEmpty()) {
                txt += id + ":" + 1;
            } else {
                if (orderService.isAcceptedBuy(id, txt)) {
                    txt += "/" + id + ":" + 1;
                } else {
                    request.setAttribute("msg_f", "You can only buy these " + orderService.quantityItemUserCanBuy + " Books");
                }
            }
            Cookie c = new Cookie("cart", txt);
            c.setMaxAge(2 * 24 * 60 * 60);
            response.addCookie(c);
            //end cookie
            BookService bookService = BookService.getInstance();
            request.setAttribute("listc", bookService.getAllCategory());
            request.setAttribute("listb", bookService.getAllBook());
            HttpSession session = request.getSession();
            // cookie
            
            Cart cart = new Cart(txt, bookService.getAllBook());
            int n = cart.getNumberItem();
            session.removeAttribute("n");
            session.setAttribute("n", n);
            //end cookie
            request.getRequestDispatcher("Views/Home.jsp").forward(request, response);

        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }

    }

}
