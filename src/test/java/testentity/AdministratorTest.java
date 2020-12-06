/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testentity;

import entities.Administrator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ashika Shallow
 */
public class AdministratorTest {
    
    public AdministratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    @Test
    public void testGetAdminId(){
        System.out.println("GetAdminId");
        String id = "B115";
        String password = "ball47P";
        Administrator instance = new Administrator(id,password);
        String expResult = "B115";
        String result = instance.getAdminId();
        assertEquals(expResult,result);
    }
    
    @Test
    public void testGetPassword(){
        System.out.println("GetPassword");
        String id = "B115";
        String password = "ball47P";
        Administrator instance = new Administrator(id,password);
        String expResult = "8392ef47c691e883d22ae431f84ef072c979848c8a3d51ac5e24bf03b296580b";
        String result = instance.getPassword();
        assertEquals(expResult,result);
    }
}
