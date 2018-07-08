package test_dependency;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Positive {
	@BeforeTest
	public void beforMethod(){
		System.out.println("befor testing");
	}
	@Test
	public void test(){
		System.out.println("test");
	}
	
	@AfterTest
	public void aftertest(){
		System.out.println("after test ");
	}

}
