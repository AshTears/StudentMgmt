
package entities;

/**
 * The Program class
 * @author Ashika Shallow
 */
public class Program {
    private String progCode;
    private String progName;
    
    /**
     * Creates an instance of the Program class
     * @param code
     * @param name 
     */
    public Program(String code, String name){
        this.progCode = code;
        this.progName = name;
    }

    public String getProgCode() {
        return progCode;
    }

    public void setProgCode(String progCode) {
        this.progCode = progCode;
    }

    public String getProgName() {
        return progName;
    }

    public void setProgName(String progName) {
        this.progName = progName;
    }
    
    
}
