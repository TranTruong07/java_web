/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HumanList {

    private static HumanList instance = new HumanList();
    private List<Human> hlist;

    public static HumanList getInstance() {
        return instance;
    }

    private HumanList() {
        this.hlist = new ArrayList<>();
    }

    public void add(Human h) {
        hlist.add(h);
    }

    public List<Human> getHlist() {
        return hlist;
    }

}
