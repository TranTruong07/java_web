/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dal.BookDao;
import dal.OrderDao;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import models.Cart;
import models.Item;
import models.Order;
import models.OrderDetails;
import models.User;

/**
 *
 * @author Admin
 */
public class OrderService {

    private static OrderService orderservice = new OrderService();
    private BookDao bookd;
    private OrderDao orderd;
    public int quantityItemUserCanBuy;

    public static OrderService getInstance() {
        return orderservice;
    }

    private OrderService() {
        orderd = new OrderDao();
        bookd = new BookDao();
    }

    public List<Order> getAllOrders() {
        return orderd.getAllOrders();
    }

    public int getQuantityOrder() {
        return getAllOrders().size();
    }

    public boolean isAcceptedBuy(int id, String txt) {
        Cart c = new Cart(txt, bookd.getAllBook());
        List<Item> list = c.getListItem();
        boolean check = false;
        for (Item i : list) {
            if (i.getB().getId() == id) {
                if (i.getQuantity() < i.getB().getQuantity()) {
                    check = true;
                }
                quantityItemUserCanBuy = i.getQuantity();
                break;
            }
            check = true;
        }
        return check;
    }

    public boolean orderItems(User u, String txt) {
        boolean order = addOrder(u, txt);
        if (order) {
            int oid = orderd.getOrderId();
            boolean orderdetails = addOrderDetails(oid, txt);
            if (orderdetails) {
                return true;
            }
        }
        return false;
    }

    private boolean addOrder(User u, String txt) {
        LocalDate localDate = LocalDate.now();
        Cart c = new Cart(txt, bookd.getAllBook());
        java.sql.Date date = java.sql.Date.valueOf(localDate);
        Order o = new Order(0, date, u, c.getTotalMoney());
        return orderd.addOrder(o);
    }

    private boolean addOrderDetails(int oid, String txt) {
        boolean check = true;
        Cart c = new Cart(txt, bookd.getAllBook());
        List<Item> listitem = c.getListItem();
        OrderDetails od;
        for (Item i : listitem) {
            od = new OrderDetails(oid, bookd.getBookById(i.getB().getId()), i.getQuantity(), i.getTotalPrice());
            boolean orderdetails = orderd.addOrderDetails(od);
            if (!orderdetails) {
                check = false;
            }
        }
        return check;
    }

    public List<OrderDetails> getAllOrderDetails() {
        return orderd.getAllOrdersDetails();
    }

    public boolean deleteOrderDetails(int oid, int pid) {
        if (orderd.deleteOrderDetailsByOidAndPid(oid, pid)) {
            List<OrderDetails> list = getAllOrderDetails().stream().filter(od -> od.getOid() == oid).collect(Collectors.toList());
            if (!list.isEmpty()) {
                Order order = orderd.getOrderById(oid);
                double total = 0;
                for (OrderDetails od : list) {
                    total += od.getTotalPrice();
                }
                Order o = new Order(oid, order.getDate(), order.getCustomer(), total);
                orderd.updateOrder(o, oid);
            } else {
                orderd.deleteOrderById(oid);
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteOrder(int oid) {
        List<OrderDetails> list = getAllOrderDetails().stream().filter(od -> od.getOid() == oid).collect(Collectors.toList());
        if (list.isEmpty()) {
            return orderd.deleteOrderById(oid);
        } else {
            for (OrderDetails od : list) {
                orderd.deleteOrderDetailsByOidAndPid(oid, od.getB().getId());
            }
            return orderd.deleteOrderById(oid);
        }
    }

    public List<Order> getOrdersByCustomID(int id) {
        return getAllOrders().stream().filter(order -> order.getCustomer().getId() == id).collect(Collectors.toList());
    }
}
