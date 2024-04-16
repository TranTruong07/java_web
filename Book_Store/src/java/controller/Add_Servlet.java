/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import models.Book;
import service.BookService;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class Add_Servlet extends HttpServlet {

   
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
        if (session.getAttribute("user") == null) {
            response.sendRedirect("login");
        } else {
            BookService bookService = BookService.getInstance();
            request.setAttribute("listc", bookService.getAllCategory());
            request.getRequestDispatcher("Views/AddBook.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int userid = Integer.parseInt(request.getParameter("userid"));
            String bookName = request.getParameter("name");
            String author = request.getParameter("author");
            double price = Double.parseDouble(request.getParameter("price"));
            String selectCategory = request.getParameter("selectCategory");
            int categoryid;
            if (!selectCategory.equals("undefined")) {
                categoryid = Integer.parseInt(selectCategory);
            } else {
                categoryid = 0;
            }
            int quantity;
            String quantity_s = request.getParameter("quantity");
            if (quantity_s == null) {
                quantity = 1;
            } else {
                quantity = Integer.parseInt(request.getParameter("quantity"));
            }

            //get img
            Part filePart = request.getPart("imgname");

            // Lấy tên tệp
            String fileName = filePart.getSubmittedFileName();
            String uploadDirectory = "D:\\Workspase\\Java_Web\\Book_Store\\web\\img\\" + fileName;
            try {
                OutputStream out = new FileOutputStream(uploadDirectory);
                InputStream in = filePart.getInputStream();
                byte[] bytes = new byte[in.available()];
                in.read(bytes);
                out.write(bytes);
                out.close();
            } catch (IOException e) {
                fileName = "default.jpg";
            }

            Book b = new Book();
            b.setName(bookName);
            b.setAuthor(author);
            b.setPrice(price);
            b.setQuantity(quantity);
            b.setImgname(fileName);
            BookService bookService = BookService.getInstance();
            if (bookService.addBook(userid, categoryid, b)) {
                request.setAttribute("msg_s", "Add Book successful");
                request.setAttribute("listc", bookService.getAllCategory());
                request.getRequestDispatcher("Views/AddBook.jsp").forward(request, response);
            } else {
                request.setAttribute("msg_f", "Add Book fail, check database");
                request.setAttribute("listc", bookService.getAllCategory());
                request.getRequestDispatcher("Views/AddBook.jsp").forward(request, response);
            }
        } catch (ServletException | IOException | NumberFormatException e) {
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
