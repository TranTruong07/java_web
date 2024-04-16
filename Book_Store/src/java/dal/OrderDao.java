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
import models.Order;
import models.OrderDetails;
import models.User;

/**
 *
 * @author Admin
 */
public class OrderDao extends DBContext {
    private UserDao userDao = new UserDao();
    private BookDao bookDao = new BookDao();

    public boolean addOrder(Order o) {
        try {
            String sql = "insert into [Order](userid, orderdate, summoneyorder)\n"
                    + "values(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, o.getCustomer().getId());
            ps.setDate(2, o.getDate());
            ps.setDouble(3, o.getTotalCart());
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

    public boolean updateOrder(Order o, int oid) {
        try {
            String sql = "update [Order] set userid = ?, orderdate = ?, summoneyorder = ? where [Order].id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, o.getCustomer().getId());
            ps.setDate(2, o.getDate());
            ps.setDouble(3, o.getTotalCart());
            ps.setInt(4, oid);
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
    
    public boolean addOrderDetails(OrderDetails od) {
        try {
            String sql = "insert into OrderDetails(oid, pid, quantity, totalprice)\n"
                    + "values(?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, od.getOid());
            ps.setInt(2, od.getB().getId());
            ps.setInt(3, od.getQuantity());
            ps.setDouble(4, od.getTotalPrice());
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
    
    public int getOrderId() {
        try {
            String sql = "select TOP 1 o.id from [Order] o Order by o.id desc";
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                return id;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    public List<Order> getAllOrders() {
        List<Order> list = new ArrayList<>();
        try {
            String sql = "select * from [Order]";
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
                int oid = rs.getInt("id");
                int userid = rs.getInt("userid");
                User u = userDao.getUserById(userid);
                java.sql.Date date = rs.getDate("orderdate");
                double summoneyorder = rs.getDouble("summoneyorder");
                Order o = new Order(oid, date, u, summoneyorder);
                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<OrderDetails> getAllOrdersDetails() {
        List<OrderDetails> list = new ArrayList<>();
        try {
            String sql = "select * from OrderDetails";
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
                int oid = rs.getInt("oid");
                int pid = rs.getInt("pid");
                Book b = bookDao.getBookById(pid);
                int quantity = rs.getInt("quantity");
                double totalprice = rs.getDouble("totalprice");
                OrderDetails od = new OrderDetails(oid, b, quantity, totalprice);
                list.add(od);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public boolean deleteOrderDetailsByOidAndPid(int oid, int pid) {
        try {
            String sql = "delete OrderDetails where OrderDetails.oid = ? and OrderDetails.pid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, oid);
            ps.setInt(2, pid);
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

    public Order getOrderById(int oid) {
        try {
            String sql = "select * from [Order] where [Order].id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, oid);
            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int userid = rs.getInt("userid");
                User u = userDao.getUserById(userid);
                java.sql.Date date = rs.getDate("orderdate");
                double summoneyorder = rs.getDouble("summoneyorder");
                Order o = new Order(id, date, u, summoneyorder);
                return o;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean deleteOrderById(int oid) {
        try {
            String sql = "delete [Order] where [Order].id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, oid);
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
}
