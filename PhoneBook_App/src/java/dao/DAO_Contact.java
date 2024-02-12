/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Contact;

/**
 *
 * @author Admin
 */
public class DAO_Contact extends DBContext {

    public boolean addContact(Contact c) {
        try {
            String sql = "insert into Contacts(id, phoneNo, name, email, about)\n"
                    + "values(?,?,?,?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, c.getU().getId());
            ps.setString(2, c.getPhoneNo());
            ps.setString(3, c.getName());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getAbout());
            int add_f = ps.executeUpdate();
            if (add_f == 1) {
                return true;
            }
        } catch (SQLException e) {
        }
        return false;
    }

    public boolean removeContact(int id, String phoneNo) {
        try {
            String sql = "delete from Contacts where id = ? and phoneNo = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, phoneNo);

            int add_f = ps.executeUpdate();
            if (add_f == 1) {
                return true;
            }
        } catch (SQLException e) {
        }
        return false;
    }

    public boolean updateContact(int id, String phoneNo, Contact c) {
        try {
            String sql = "UPDATE Contacts\n"
                    + "SET phoneNo = ?, name = ?, email = ?, about = ?\n"
                    + "WHERE id = ? and phoneNo = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, c.getPhoneNo());
            ps.setString(2, c.getName());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getAbout());
            ps.setInt(5, id);
            ps.setString(6, phoneNo);
            int add_f = ps.executeUpdate();
            if (add_f == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public List<Contact> getListContacts(int id) {
        List<Contact> list = new ArrayList<>();
        try {
            String sql = "select * from Contacts where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Contact c = new Contact();
                c.setName(rs.getString("name"));
                c.setEmail(rs.getString("email"));
                c.setPhoneNo(rs.getString("phoneNo"));
                c.setAbout(rs.getString("about"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
