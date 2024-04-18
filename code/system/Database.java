package system;
import java.util.ArrayList;

import admin.Admin;
import branch.Branch;
import branch.ItemManagement;
import item.Item;
import item.Item.Category;
import staff.Manager;
import staff.Staff;
import staff.Staff.Gender;

public class Database {
    ArrayList<Branch> branchList = new ArrayList<Branch>();
    ArrayList<User> accountList = new ArrayList<User>();

    public Database() {
        Admin boss = new Admin("boss", "Boss", Gender.F, 62);
        this.accountList.add(boss);
        
        Branch NTU = new Branch("NTU", "North Spine Plaza", 8);
        Branch JP = new Branch("JP", "Jurong Point", 15);
        Branch JE = new Branch("JE", "Jurong East", 11);
        this.branchList.add(NTU);
        this.branchList.add(JP);
        this.branchList.add(JE);

        Staff kumarB = new Staff(NTU, "kumarB", "Kumar Blackmore", Gender.M, 32);
        Manager Alexei = new Manager(NTU, "Alexei", "Alexei", Gender.M, 25);
        Manager TomC = new Manager(JP, "TomC", "Tom Chan", Gender.M, 56);
        Manager AlicaA = new Manager(JE, "AliciaA", "Alicia Ang", Gender.F, 27);
        Staff MaryL = new Staff(JE, "MaryL", "Mary Lee", Gender.F, 44);
        Staff JustinL = new Staff(JP, "JustinL", "Justin Loh", Gender.M, 49);
        this.accountList.add(kumarB);
        this.accountList.add(Alexei);
        this.accountList.add(TomC);
        this.accountList.add(AlicaA);
        this.accountList.add(MaryL);
        this.accountList.add(JustinL);

        ItemManagement ntuItemManagement = new ItemManagement(NTU);
        ItemManagement jpItemManagement = new ItemManagement(JP);
        ItemManagement jeItemManagement = new ItemManagement(JE);

        ntuItemManagement.addItem(new Item("fries", "FRIES", 3.2, Category.SIDE));
        ntuItemManagement.addItem(new Item("set", "3PC set meal", 9.9, Category.SET_MEAL));
        jpItemManagement.addItem(new Item("fish", "CAIJUN FISH", 5.6, Category.BURGER));
        jeItemManagement.addItem(new Item("salad", "COLE SLAW", 2.7, Category.SIDE));
        jeItemManagement.addItem(new Item("set", "3PC set meal", 10.4, Category.SET_MEAL));
        jpItemManagement.addItem(new Item("nugget", "CHICKEN NUGGET", 6.9, Category.SIDE));
        ntuItemManagement.addItem(new Item("nugget", "CHICKEN NUGGET", 6.9, Category.SIDE));
        jeItemManagement.addItem(new Item("pepsi", "PEPSI", 2.1, Category.DRINK));
    }

    public ArrayList<Branch> getBranchList() {
        return branchList;
    }

    public ArrayList<User> getAccountList() {
        return accountList;
    }
}
