package system;


/**
 * 
 * <li>Class for "User" represents the 3 types of users that can access Fast-Food Ordering Management with a password</li>
 * <li>This includes: Admin ,Manager and Staff</li>
 * <li> The main purpose of User Class is to store important information regarding the Users</li>
 * <li>Stereotype: Entity</li>
 * @author FDAB 2
 * @version 1.0 
 * @since 23-4-2024

 */
public abstract class User {
	
	/**
	 * enumeration Class declaration  that representing Admin, Manager and Staff 
	 */
    public enum UserType {ADMINISTRATOR, MANAGER, STAFF};
    
    /**
     * enumeration Class declaration representing Gender
     */
    public enum Gender {MALE, FEMALE};

    protected UserType userType;
    protected String userId;
    protected String password = "password";
    protected String name;
    protected Gender gender;
    protected int age;
    protected String branchName;
    
    /**
     * <li>Constructor for User Class. Creates an object representing the user, along with it's features</li>
     * @param userType Defines whether object is Administrator, Manager or staff
     * @param accountId String for Id of the user
     * @param name Name of the User
     * @param gender Gender of the User
     * @param age Age of the User
     */

    public User(UserType userType, String accountId, String password, String name, Gender gender, int age, String branchName) {
        this.userType = userType;
        this.userId = accountId;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.branchName = branchName;
    }

    
    /**
     * Getter method for UserType Attribute
     * @return Returns the type of current User object
     */
    public UserType getUserType() {
        return userType;
    }

    /**
     * Getter method for UserID Attribute
     * @return Returns the ID of current User object
     */
    public String getUserId() {
        return userId;
    }

    
    /**
     * Getter method for Password Attribute
     * @return Returns the Password of current User object
     */
    public String getPassword() {
        return password;
    }

    
    /**
     * Getter method for Name Attribute
     * @return Returns the Name of current User object
     */
    public String getName() {
        return name;
    }

    
    /**
     * Getter method for gender Attribute
     * @return Returns the Gender of current User object
     */
    public Gender getGender() {
        return gender;
    }

    
    /**
     * Getter method for Age Attribute
     * @return Returns the Age of current User object
     */
    public int getAge() {
        return age;
    }
    
    public String getBranchName() {
    	return branchName;
    }
    
    public void setUserType(UserType userType) {
    	this.userType = userType;
    }

    /**
     * Setter method for Account ID
     * @param accountId Takes in new Account ID to change to
     */
    public void setUserId(String accountId) {
        this.userId = accountId;
    }

    /**
     * Setter method for updating object's password
     * @param password Takes in new Password to update
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Setter method to define name of the user object
     * @param name Takes in the name of user object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter Method for Gender of the User Object
     * @param gender Takes in Gender of the user
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Setter method for age of User Object
     * @param age Takes in new Age of the User
     */
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setBranchName(String branchName) {
    	this.branchName = branchName;
    }
}
