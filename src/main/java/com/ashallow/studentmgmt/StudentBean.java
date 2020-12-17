
package com.ashallow.studentmgmt;

import entities.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;

/**
 * StudentBean
 * @author Ashika Shallow
 */
@ManagedBean
public class StudentBean {  
    private List<Student> studList;
    private Map<String,String> programList;
    private String program;
    
    /**
     * No arguments constructor
     */
    public StudentBean(){  }
    
    /**
     * Retrieves a program name given its code
     * @param code the program code
     * @return the program name
     */
    public String getProgram(String code){
        this.programList = buildProgramList();
        program = programList.get(code);
        return program;
    }
    
    /**
     * Retrieves a list of students.
     * @return a student list
     */
    public List<Student> getStudList(){
        studList = buildStudentList();       
        return studList;
    }
    
    /**
     * Builds an ArrayList of students.
     * @return a list of students
     */
    private List<Student> buildStudentList(){
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
    
    /**
     * Creates a map of programs offered with code,name pairs
     * @return A map of the programs offered
     */
    private Map<String,String> buildProgramList(){
        Map<String,String> programList = new HashMap<>();
        Connection con = Database.getConnection();
        
        try {
            String query = "SELECT * FROM programs";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                programList.put(rs.getString("progCode"), rs.getString("progName"));
            }
            con.close();
        }catch(SQLException ex){
            System.out.println("Bad SQL: " + ex.getMessage());
        }
        return programList;
    }
}
