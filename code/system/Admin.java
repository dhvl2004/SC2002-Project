package system;

public class Admin implements User {
    private String adminId = "default";
    private String password = "password";

    public String getId() {
        return this.adminId;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean setPassword(String password) {
        if (password == this.password) return false;
        this.password = password;
        return true;
    }
}
