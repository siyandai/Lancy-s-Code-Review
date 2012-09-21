/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Distributed.System.Project1.Task3.test;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Lancy
 */
public class ValidCharacterTest {
    
    public ValidCharacterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testValidCharacter() {
         String test = "Madam I'm Adam";
         test = test.toLowerCase();
         test = test.replaceAll("[^\\p{Alnum}]", "");
         System.out.println (test);
     }
}
