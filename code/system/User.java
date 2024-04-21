package system;

public abstract class User {
    public enum UserType {ADMINISTRATOR, MANAGER, STAFF};
    public enum Gender {MALE, FEMALE};

    protected UserType userType;
    protected String userId;
    protected String password = "password";
    protected String name;
    protected Gender gender;
    protected int age;
    protected String branchName;

    public User(UserType userType, String accountId, String password, String name, Gender gender, int age, String branchName) {
        this.userType = userType;
        this.userId = accountId;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.branchName = branchName;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
    
    public String getBranchName() {
    	return branchName;
    }
    
    public void setUserType(UserType userType) {
    	this.userType = userType;
    }

    public void setUserId(String accountId) {
        this.userId = accountId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void setBranchName(String branchName) {
    	this.branchName = branchName;
    }
}
