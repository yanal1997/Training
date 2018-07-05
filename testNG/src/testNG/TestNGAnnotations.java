package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	@BeforeClass
	public void beforCalss(){
		System.out.println("befor class");
	}
	@BeforeMethod
	public void beformethod(){
		System.out.println("befor method");
	}
 @Test
 public void test1(){
	 System.out.println("test1");
 }
 @Test
 public void test2(){
	 System.out.println("test2");
 }
 @AfterMethod 
 public void afterMethod(){
	 System.out.println("after method");
 }
 @AfterClass
 public void afterCalss(){
	 System.out.println("after class");
 }
 
}
