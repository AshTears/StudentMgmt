
package entities;

/**
 * The Student class
 * @author Ashika Shallow
 */
public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String program = null;
    
    /**
     * Creates an instance of a student
     * @param id
     * @param fName
     * @param lName
     * @param address
     * @param email
     * @param phone
     * @param prog 
     */
    public Student(String id, String fName, String lName, String address, String email, String phone, String prog){
        this.studentId = id;
        this.firstName = fName;
        this.lastName = lName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.program = prog;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
    
    
}
