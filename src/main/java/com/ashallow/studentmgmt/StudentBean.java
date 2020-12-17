/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ashallow.studentmgmt;

import entities.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Ashika Shallow
 */
@ManagedBean
public class StudentBean {  
    private List<Student> studList;
    
    public StudentBean(){  }
    
    public List<Student> getStudList(){
        studList = makeList();
        
        return studList;
    }
    
    private List<Student> makeList(){
        List<Student> studentList = new ArrayList<>();
        Connection con = Database.getConnection();
        
        try {
            String query = "SELECT * FROM students";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                Student person = new Student(rs.getString(1),rs.getString(2),rs.getString(3),
                rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                studentList.add(person);
            }
            con.close();
        }catch(SQLException ex){
            System.out.println("Bad SQL: " + ex.getMessage());
        }
        
        return studentList;
    }
}
