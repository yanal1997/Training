package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotation2 {
	@BeforeSuite
	public void beforSuite(){
		System.out.println("befor suite");
	}
	@BeforeTest
	public void beforMethod(){
		System.out.println("befor test");
		
	}
	@BeforeClass
	public void beforCalss(){
		System.out.println("befor class");
	}
@Test
public void test3(){
	System.out.println("test 3");
}
@AfterTest
public void afterTest(){
	System.out.println("after test");
}
@AfterClass
public void afterCalss(){
	 System.out.println("after class 2");
}
@AfterSuite
public void aftersuite(){
	System.out.println("after suite");
}
}
