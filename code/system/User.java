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

    public User(UserType userType, String accountId, String name, Gender gender, int age) {
        this.userType = userType;
        this.userId = accountId;
        this.name = name;
        this.gender = gender;
        this.age = age;
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
}
