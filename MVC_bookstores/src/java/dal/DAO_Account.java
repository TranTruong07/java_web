/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import models.Human;
import models.HumanList;
import models.HumanType;

/**
 *
 * @author Admin
 */
public class DAO_Human extends DBContext {

    public boolean getHumans() {
        HumanList hl = HumanList.getInstance();
        //List<Human> list = hl.getHlist();.
        boolean check = true;
        try {
            String sql = "select h.*, ht.typename from Human h join HumanType ht \n"
                    + "on h.typeid = ht.typeid";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("humanid");
                String humanname = rs.getString("humanname");
                Date humandob = rs.getDate("humandob");
                boolean humangender = rs.getBoolean("humangender");
                HumanType ht = new HumanType();
                ht.setTypeiD(rs.getInt("typeid"));
                ht.setName(rs.getString("typename"));
                Human h = new Human(id, humanname, humandob, humangender, ht);
                hl.add(h);
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return check;
    }

    public List<HumanType> getHumanTye() {
        List<HumanType> list = new ArrayList<>();
        try {
            String sql = "select * from HumanType";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int typeid = rs.getInt("typeid");
                String typename = rs.getString("typename");

                HumanType ht = new HumanType();
                ht.setTypeiD(typeid);
                ht.setName(typename);
                list.add(ht);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public boolean deleteHuman(int id) {
        boolean check = false;
        try {
            HumanList hl = HumanList.getInstance();
            String sql = "delete from Human where Human.humanid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            int f = ps.executeUpdate();
            if (f == 1) {
                hl.getHlist().removeIf(human -> human.getId()==id);
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return check;
    }

    public boolean insertHuman(Human h) {
        boolean check = false;
        try {
            HumanList hl = HumanList.getInstance();
            String sql = "insert into Human(humanid, humanname, humandob, humangender, typeid)\n"
                    + "values(?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, h.getId());
            ps.setString(2, h.getName());
            ps.setDate(3, h.getDob());
            ps.setBoolean(4, h.isGender());
            ps.setInt(5, h.getType().getTypeiD());
            int f = ps.executeUpdate();
            if (f == 1) {
                hl.add(h);
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return check;
    }

    public boolean updateHuman(Human h, int oldid) {
        boolean check = false;
        try {
            HumanList hl = HumanList.getInstance();
            String sql = "update Human\n"
                    + "set humanid = ?, humanname = ?, humandob = ?, humangender = ?, typeid = ?\n"
                    + "where humanid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, h.getId());
            ps.setString(2, h.getName());
            ps.setDate(3, h.getDob());
            ps.setBoolean(4, h.isGender());
            ps.setInt(5, h.getType().getTypeiD());
            ps.setInt(6, oldid);
            int f = ps.executeUpdate();
            if (f == 1) {
                hl.getHlist().removeIf(human -> human.getId() == oldid);
                hl.add(h);
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return check;
    }

    public static void main(String[] args) {
//        DAO_Human dao = new DAO_Human();
//        HumanList hlist = HumanList.getInstance();
//        List<Human> list = dao.getHumans();
//        for (Human human : list) {
//            hlist.add(human);
//        }
//        
//        
//        HumanList hlist2 = HumanList.getInstance();
//        List<Human> list2 = dao.getHumans();
//        for (Human human : list2) {
//            hlist2.add(human);
//        }
//        
//        for (Human human : hlist.getHlist()) {
//            System.out.println(human.getName());
//        }
        
    }
}
