/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAO_Human;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import models.Human;
import models.HumanList;
import models.HumanType;

/**
 *
 * @author Admin
 */
@WebServlet(name="Edit_servlet", urlPatterns={"/edit_servlet"})
public class Edit_servlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Edit_servlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Edit_servlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

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
        processRequest(request, response);
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
            
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dob = simpleDateFormat.parse(request.getParameter("dob"));
            java.sql.Date dobsql = new java.sql.Date(dob.getTime());
            String gender_s = request.getParameter("gender");
            boolean gender;
                        System.out.println("abc");

            if(gender_s.equals("1")){
                gender = true;
            }else{
                gender = false;
            }
            
            String type = request.getParameter("type");
            int typeid = Integer.parseInt(request.getParameter("typeid"));
            HumanType ht = new HumanType();
            ht.setName(type);
            ht.setTypeiD(typeid);
            Human h = new Human(id, name, dobsql, gender, ht);
            int oldid = Integer.parseInt(request.getParameter("oldid"));
            DAO_Human dao = new DAO_Human();
            boolean checkupdate = dao.updateHuman(h, oldid);
            HumanList hl = HumanList.getInstance();
            if(checkupdate){
                request.setAttribute("listH", hl.getHlist());
                request.setAttribute("msg_s", "Edit successfull..");
                request.getRequestDispatcher("Views/index.jsp").forward(request, response);
            }else{
                request.setAttribute("listH", hl.getHlist());
                request.setAttribute("msg_f", "Can't update error in update data..");
                request.getRequestDispatcher("Views/index.jsp").forward(request, response);
            }
        } catch (NumberFormatException | ParseException e) {
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
