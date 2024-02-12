/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DAO_Users extends DBContext {

    public boolean regisUser(User u) {
        boolean f = false;
        try {
            String sql = "insert into Users(name, email, password)\n"
                    + "values(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            int regis = ps.executeUpdate();
            if (regis == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return f;
    }

    public User getUser(String email, String pass) {
        User u = null;
        try {
            String sql = "select * from Users u where u.email = ? and u.password = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name_s = rs.getString("name");
                String email_s = rs.getString("email");
                String pass_s = rs.getString("password");
                User uu = new User(name_s, email, pass_s);
                uu.setId(id);
                return uu;
            }
        } catch (SQLException e) {
        }
        return u;
    }
    public User getUser(int id) {
        User u = null;
        try {
            String sql = "select * from Users u where u.id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name_s = rs.getString("name");
                String email_s = rs.getString("email");
                String pass_s = rs.getString("password");
                User uu = new User(name_s, email_s, pass_s);
                uu.setId(id);
                return uu;
            }
        } catch (SQLException e) {
        }
        return u;
    }
}
