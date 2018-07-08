package testNG;

import org.testng.annotations.Test;

public class TestDependencTest {

	@Test(dependsOnMethods={"test2"}, dependsOnGroups={"first"})
	public void test1(){
		System.out.println("test 1 after test 2");
	}
	@Test(dependsOnGroups={"first"})
	public void test2(){
		System.out.println("test 2");
	}
	@Test(groups={"first"})
	public void test0(){
		System.out.println("test0 befor second group");
	}
	@Test(enabled=false,groups={"first"})
	public void test4(){
		System.out.println("test4 ");
	}

}
