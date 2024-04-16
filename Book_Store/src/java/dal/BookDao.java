/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Book;
import models.Category;
import models.User;

/**
 *
 * @author Admin
 */
public class BookDao extends DBContext {

    public boolean updateBook(int id, Book b) {
        try {
            String sql = "update Products set name = ?, price = ?, author = ?, categoryid = ?, quantity = ?, imgname = ? where Products.productId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, b.getName());
            ps.setDouble(2, b.getPrice());
            ps.setString(3, b.getAuthor());
            if (b.getC().getId() == 0) {
                ps.setNull(4, java.sql.Types.INTEGER);
            } else {
                ps.setInt(4, b.getC().getId());
            }
            ps.setInt(5, b.getQuantity());
            ps.setString(6, b.getImgname());
            ps.setInt(7, id);

            int check = ps.executeUpdate();
            if (check == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    public boolean deleteBookById(int id) {
        try {
            String sql = "delete Products where Products.productId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int a = ps.executeUpdate();
            if (a == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

   
    
    public List<Book> getBooksByUserId(int userid) {
        List<Book> listb = new ArrayList<>();
        try {
            String sql = "select * from Products p where p.userId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userid);
            ResultSet rs = ps.executeQuery();
            UserDao ud = new UserDao();
            while (rs.next()) {
                int id = rs.getInt("productId");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String author = rs.getString("author");
                User u = ud.getUserById(rs.getInt("userId"));
                Category c = getCategoryById(rs.getInt("categoryid"));
                int quantity = rs.getInt("quantity");
                String imgname = rs.getString("imgname");
                Book b = new Book(id, name, price, author, u, quantity, imgname, c);
                listb.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listb;
    }

    public List<Book> getAllBook() {
        List<Book> listb = new ArrayList<>();
        try {
            String sql = "select * from Products";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            UserDao ud = new UserDao();
            while (rs.next()) {
                int id = rs.getInt("productId");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String author = rs.getString("author");
                User u = ud.getUserById(rs.getInt("userId"));
                Category c = getCategoryById(rs.getInt("categoryid"));
                int quantity = rs.getInt("quantity");
                String imgname = rs.getString("imgname");
                Book b = new Book(id, name, price, author, u, quantity, imgname, c);
                listb.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listb;
    }

    public boolean addBook(int userid, int categoryid, Book b) {
        try {
            String sql = "insert into Products(name, price, author, userId, categoryid, quantity, imgname)\n"
                    + "values(?,?,?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, b.getName());
            ps.setDouble(2, b.getPrice());
            ps.setString(3, b.getAuthor());
            ps.setInt(4, userid);
            if (categoryid == 0) {
                ps.setNull(5, java.sql.Types.INTEGER);
            } else {
                ps.setInt(5, categoryid);
            }
            ps.setInt(6, b.getQuantity());
            ps.setString(7, b.getImgname());
            int check = ps.executeUpdate();
            if (check == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    public List<Category> getAllCategory() {
        List<Category> listc = new ArrayList<>();
        try {
            String sql = "select * from Category";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Category c = new Category(id, name);
                listc.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listc;
    }

    public Category getCategoryById(int categoryId) {
        Category c = null;
        try {
            String sql = "select * from Category c where c.cid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c = new Category(rs.getInt("cid"), rs.getString("cName"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return c;
    }

    public List<Book> getBookByCategoryId(int id) {
        List<Book> listb = new ArrayList<>();
        try {
            String sql = "select * from Products p where p.categoryid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            UserDao ud = new UserDao();
            while (rs.next()) {
                int pid = rs.getInt("productId");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String author = rs.getString("author");
                User u = ud.getUserById(rs.getInt("userId"));
                Category c = getCategoryById(rs.getInt("categoryid"));
                int quantity = rs.getInt("quantity");
                String imgname = rs.getString("imgname");
                Book b = new Book(pid, name, price, author, u, quantity, imgname, c);
                listb.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listb;
    }

    public boolean addCategory(String categoryname) {
        try {
            String sql = "insert into Category(cName)\n"
                    + "values(?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, categoryname);
            int check = ps.executeUpdate();
            if (check == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    public boolean deleteCategoryById(int id) {
        try {
            String sql = "delete Category where Category.cid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int check = ps.executeUpdate();
            if(check == 1){
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public Book getBookById(int bid) {
        try {
            String sql = "select * from Products p where p.productId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, bid);
            ResultSet rs = ps.executeQuery();
            UserDao ud = new UserDao();
            while (rs.next()) {
                int pid = rs.getInt("productId");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String author = rs.getString("author");
                User u = ud.getUserById(rs.getInt("userId"));
                Category c = getCategoryById(rs.getInt("categoryid"));
                int quantity = rs.getInt("quantity");
                String imgname = rs.getString("imgname");
                Book b = new Book(pid, name, price, author, u, quantity, imgname, c);
                return b;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
