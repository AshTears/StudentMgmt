
package entities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The Administrator class
 * @author Ashika Shallow
 */
public class Administrator {
    private String adminId;
    private String firstName;
    private String lastName;
    private String password;
    
    public Administrator(String id, String pword){
        this.adminId = id;
        this.password = generateSecurePassword(pword);
    }
    /**
     * Creates an instance of the Administrator class
     * @param id
     * @param fName
     * @param lName
     * @param pword 
     */
    public Administrator(String id, String fName, String lName, String pword){
        this.adminId = id;
        this.firstName = fName;
        this.lastName = lName;
        this.password = generateSecurePassword(pword);
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = generateSecurePassword(password);
    }
    
    /**
     * This method generates a hashed password to store in the database
     * @param pword The original password
     * @return A hash of the password
     */
    private String generateSecurePassword(String pword){
        String passwordHash = null;
        byte[] salt = {52, -101, 64, -39};
        
        try {
            MessageDigest   md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(pword.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            passwordHash = sb.toString();
        } catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return passwordHash;
    }
}
