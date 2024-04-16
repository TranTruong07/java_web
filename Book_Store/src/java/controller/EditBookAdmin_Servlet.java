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
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import models.Book;
import models.Category;
import service.BookService;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class EditBookAdmin_Servlet extends HttpServlet {
   
    

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
            BookService bookService = BookService.getInstance();
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("book", bookService.getBookById(id, bookService.getAllBook()));
            request.setAttribute("listc", bookService.getAllCategory());
            request.getRequestDispatcher("Views/editBookManagement.jsp").forward(request, response);
        } catch (NumberFormatException e) {
        }
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
            BookService bookService = BookService.getInstance();
            int bookid = Integer.parseInt(request.getParameter("bookid"));
            String bookName = request.getParameter("name");
            String author = request.getParameter("author");
            double price = Double.parseDouble(request.getParameter("price"));
            String selectCategory = request.getParameter("selectCategory");
            int categoryid = Integer.parseInt(selectCategory);
            Category c = new Category();
            c.setId(categoryid);
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            String imgnameold = request.getParameter("imgnameold");
            Part filePart = request.getPart("imgname");
            // Lấy tên tệp
            String fileName = filePart.getSubmittedFileName();
            if (!fileName.equals("") && !fileName.equals(imgnameold)) {
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
            }else if(fileName.equals(imgnameold)&&!fileName.equals("")){
                fileName = imgnameold;
            }else{
                fileName = "default.jpg";
            }
            Book b = new Book();
            b.setId(bookid);
            b.setName(bookName);
            b.setAuthor(author);
            b.setPrice(price);
            b.setC(c);
            b.setQuantity(quantity);
            b.setImgname(fileName);
            if (bookService.updateBook(bookid, b)) {
                request.setAttribute("msg_s", "Update Book successful");
                request.setAttribute("listc", bookService.getAllCategory());
                request.setAttribute("book", b);
                request.getRequestDispatcher("Views/editBookManagement.jsp").forward(request, response);
            } else {
                request.setAttribute("msg_f", "Update Book fail, check database");
                request.setAttribute("listc", bookService.getAllCategory());
                request.setAttribute("book", b);
                request.getRequestDispatcher("Views/editBookManagement.jsp").forward(request, response);
            }
        } catch (ServletException | IOException | NumberFormatException e) {
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
