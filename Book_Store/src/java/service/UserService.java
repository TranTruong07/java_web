/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dal.UserDao;
import java.util.List;
import models.Order;
import models.Role;
import models.User;

/**
 *
 * @author Admin
 */
public class UserService {

    private static UserService instance = new UserService();
    private UserDao userDao;
    private List<User> listu;

    private UserService() {
        userDao = new UserDao();
    }

    public static UserService getInstance() {
        return instance;
    }

    public List<User> getListUser() {
        if (listu == null) {
            listu = userDao.getUsers();
        }
        return listu;
    }

    public int getQuantityUser() {
        return getListUser().size();
    }

    public List<Role> getAllRole() {
        return userDao.getAllRole();
    }

    public boolean addUser(User user) {
        if (userDao.addUser(user)) {
            listu = userDao.getUsers();
            return true;
        }
        return false;
    }

    public boolean removeUser(int id) {
        BookService bookService = BookService.getInstance();
        OrderService orderService = OrderService.getInstance();
        List<Order> listo = orderService.getOrdersByCustomID(id);
        boolean check1 = bookService.deleteBooksByUserId(id);
        boolean check2 = true;
        if(!listo.isEmpty()){
            for(Order o: listo){
                if(!orderService.deleteOrder(o.getOid())){
                    check2 = false;
                }
            }
        }
        if (check1&&check2) {
            if (userDao.removeUser(id)) {
                if (listu != null) {
                    listu.removeIf(user -> user.getId() == id);
                }
                return true;
            }
        }
        return false;
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public boolean updateUser(User user, int id) {
        if (userDao.updateUser(user, id)) {
            listu = userDao.getUsers();
            return true;
        }
        return false;
    }

    public boolean addRole(Role role) {
        return userDao.addRole(role);
    }

    public boolean removeRole(int roleid) {
        return userDao.removeRole(roleid);
    }
}
