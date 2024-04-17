package system;
import java.util.ArrayList;

import branch.Branch;
import staff.Manager;
import staff.Staff;
import staff.Staff.Gender;

public class Database {
    Admin admin;
    ArrayList<Branch> branchList = new ArrayList<Branch>();
    ArrayList<User> accountList = new ArrayList<User>();

    public Database() {
        this.admin = new Admin("boss", "Boss", Gender.F, 62);
        this.accountList.add(this.admin);
        
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
    }
    
    public Admin getAdmin() {
        return admin;
    }

    public ArrayList<Branch> getBranchList() {
        return branchList;
    }

    public ArrayList<User> getAccountList() {
        return accountList;
    }
}
