/*;
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Role;
import models.User;

/**
 *
 * @author Admin
 */
public class UserDao extends DBContext {

    public User getUser(String email, String pass) {
        User u = null;
        try {
            String sql = "select * from Users u where u.email = ? and u.password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role r = getRoleById(rs.getInt(5));
                u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), r);
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return u;
    }

    public List<User> getUsers() {
        List<User> listu = new ArrayList<>();
        User u;
        try {
            String sql = "select * from Users";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role r = getRoleById(rs.getInt(5));
                u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), r);
                listu.add(u);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listu;
    }

    public User getUserById(int id) {
        User u = null;
        try {
            String sql = "select * from Users u where u.id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role r = getRoleById(rs.getInt(5));
                u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), r);
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return u;
    }

    public boolean addUser(User u) {
        try {
            String sql = "insert into Users(name, email, password, roleid)\n"
                    + "values(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setInt(4, u.getR().getRoleid());
            int check = ps.executeUpdate();
            if (check == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    private Role getRoleById(int roleid) {
        Role r = null;
        try {
            String sql = "select * from Role r where r.roleid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, roleid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                r = new Role(rs.getInt(1), rs.getString(2));
                return r;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return r;
    }

    public List<Role> getAllRole() {
        List<Role> listr = new ArrayList<>();
        try {
            String sql = "select * from Role";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role r = new Role(rs.getInt(1), rs.getString(2));
                listr.add(r);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listr;
    }

    public boolean removeUser(int id) {
        try {
            String sql = "delete Users where Users.id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int check = ps.executeUpdate();
            if (check == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updateUser(User user, int id) {
        try {
            String sql = "update Users set name = ?, email = ?, password = ?, roleid = ? where Users.id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getR().getRoleid());
            ps.setInt(5, id);
            int check = ps.executeUpdate();
            if (check == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean addRole(Role role) {
        try {
            String sql = "insert into [Role](roleid, rolename)\n"
                    + "values(?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, role.getRoleid());
            ps.setString(2, role.getRolename());
            int check = ps.executeUpdate();
            if (check == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean removeRole(int roleid) {
        try {
            String sql = "delete [Role] where [Role].roleid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, roleid);
            int check = ps.executeUpdate();
            if (check == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
