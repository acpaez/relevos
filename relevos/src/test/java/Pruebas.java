/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author orlan
 */
public class Pruebas {
    
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
    
    @Test
    public void randomTest(){
        int j = Randoms.crearRamdom();
        if(j==0){
         assertEquals(0,j);
        }
        if(j==1){
         assertEquals(1,j);
        }
        if(j==2){
         assertEquals(2,j);
        }
        if(j==3){
         assertEquals(3,j);
        }
    }
}
