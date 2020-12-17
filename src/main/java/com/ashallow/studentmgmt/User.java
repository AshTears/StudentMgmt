
package com.ashallow.studentmgmt;

import entities.Administrator;
import java.io.Serializable;
import java.sql.*;
import java.sql.Connection;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author Ashika Shallow
 */
@ManagedBean
@SessionScoped
public class User implements Serializable{
    private String userId;
    private String password;
    private boolean status = false;

    /**
     * Creates a new instance of User
     */
    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   public String login(){
       this.status = isAdmin();
       if (status)
           return "students";
       else
           return "";
   }
   
   public boolean getStatus(){
       return status;
   }
    
    /**
     * Checks the database for the user and compares the password.
     * @return True if the user and password is correct
     */
    private boolean isAdmin(){
        boolean registered = false;
        Connection con = Database.getConnection();
        Administrator admin = new Administrator(userId, password);
        String passwordHash = admin.getPassword();
        
        try {
            String query = "SELECT * FROM administrators WHERE adminId = '" + userId + "'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                if (passwordHash.equals(rs.getString("password")))
                    registered = true;
            }
            con.close();
        }catch(SQLException ex){
            System.out.println("Bad SQL: " + ex.getMessage());
        }
        return registered;
    }
}
