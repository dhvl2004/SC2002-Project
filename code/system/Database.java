package system;
import java.util.ArrayList;

import admin.Admin;
import branch.Branch;
import branch.ItemManagement;
import item.Item;
import item.Item.Category;
import staff.Manager;
import staff.Staff;
import system.User.Gender;

public class Database {
    ArrayList<Branch> branchList = new ArrayList<Branch>();
    ArrayList<User> accountList = new ArrayList<User>();

    public Database() {
        Admin boss = new Admin("boss", "Boss", Gender.FEMALE, 62);
        this.accountList.add(boss);
        
        Branch NTU = new Branch("NTU", "North Spine Plaza", 8);
        Branch JP = new Branch("JP", "Jurong Point", 15);
        Branch JE = new Branch("JE", "Jurong East", 11);
        this.branchList.add(NTU);
        this.branchList.add(JP);
        this.branchList.add(JE);

        this.accountList.add(new Staff(NTU, "kumarB", "Kumar Blackmore", Gender.MALE, 32));
        this.accountList.add(new Manager(NTU, "Alexei", "Alexei", Gender.MALE, 25));
        this.accountList.add(new Manager(JP, "TomC", "Tom Chan", Gender.MALE, 56));
        this.accountList.add(new Manager(JE, "AliciaA", "Alicia Ang", Gender.FEMALE, 27));
        this.accountList.add(new Manager(JE, "AliciaA", "Alicia Ang", Gender.FEMALE, 27));
        this.accountList.add(new Staff(JP, "JustinL", "Justin Loh", Gender.MALE, 49));

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
