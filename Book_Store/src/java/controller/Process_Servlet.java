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
import java.util.List;
import models.Book;
import models.Cart;
import models.Item;
import service.BookService;

/**
 *
 * @author Admin
 */
public class Process_Servlet extends HttpServlet {

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
            BookService bookService = BookService.getInstance();
            String action = request.getParameter("action");
            int id = Integer.parseInt(request.getParameter("id"));

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
            Cart c = new Cart(txt, bookService.getAllBook());

            //end cookie
            switch (action) {
                case "plus" -> {
                    if (c.getItemById(id).getQuantity() < c.getItemById(id).getB().getQuantity()) {
                        Book b = bookService.getBookById(id, bookService.getAllBook());
                        c.addItem(new Item(b, 1, b.getPrice()));
                    }
                }
                case "minus" -> {
                    if (c.getItemById(id).getQuantity() <= 1) {
                        c.deleteItem(id);
                    } else {
                        c.getItemById(id).setQuantity(c.getItemById(id).getQuantity() - 1);
                    }
                }
                case "delete" -> {
                    c.deleteItem(id);
                }
            }

            List<Item> listitem = c.getListItem();
            txt = "";
            if (!listitem.isEmpty()) {
                txt += listitem.get(0).getB().getId()+":"+listitem.get(0).getQuantity();
                for(int i = 1; i< listitem.size(); i++){
                    txt+="/"+listitem.get(i).getB().getId()+":"+listitem.get(i).getQuantity();
                }

            }
            Cookie c2 = new Cookie("cart", txt);
            c2.setMaxAge(2*24*60*60);
            response.addCookie(c2);
            response.sendRedirect("cart");
        } catch (NumberFormatException e) {
        }
    }

}
