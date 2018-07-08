package test_dependency;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Negative {
	@BeforeTest
	public void beforMethod(){
		System.out.println("befor testing2");
	}
	@Test
	public void test(){
		System.out.println("test2");
	}
	
	@AfterTest
	public void aftertest(){
		System.out.println("after test2 ");
	}
}
