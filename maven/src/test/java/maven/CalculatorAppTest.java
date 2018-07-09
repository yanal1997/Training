package maven;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CalculatorAppTest {
	String[] test = new String[15];
	String[] result = new String[15];
	CalculatorApp calcutator = new CalculatorApp();
	@BeforeTest
	public void setUp() {
		//System.out.println("yanal");
		test[0] = "5+2";
		result[0] = "7.0";
		test[1] = "3*6";
		result[1] = "18.0";
		test[2] = "6/2";
		result[2] = "3.0";
		test[3] = "5-3";
		result[3] = "2.0";
		test[4] = "2-10";
		result[4] = "-8.0";
		test[5] = "3*2=";
		result[5] = "6.0";
		test[6] = "55.0";
		result[6] = "55.0";
		test[7] = "5/2";
		result[7] = "2.5";
		test[8] = "9/0";
		result[8] = "The process is not allowed";
		test[9] = "5t+3";
		result[9] = "erorr";
		test[10]="8-2==";
		result[10]="6.0";
		test[11]="*";
		result[11]="*";
		test[12]="55**10";
		result[12]="error";
		

	}

	@Test(groups={"positive"})
	public void addTwoNumber() {

	   Assert. assertEquals( result[0], calcutator.operation(test[0]),"add two number  ");
	}
	@Test(groups={"positive"})
	public void multiplyTwoNumber(){
		Assert.assertEquals( result[1], calcutator.operation(test[1]),"multiply two number (5*2)");
	}
	@Test(groups={"positive"})
	public void divideTwoNumber() {
		Assert.assertEquals( result[2],calcutator.operation(test[2]),"dived two number (6/3)");//Dived 
	}
	@Test(groups={"positive"})
	public void subtractTwoNumber() {
		Assert.assertEquals( result[3],calcutator.operation(test[3]),"Subtract two number (10-3)");
	}
	@Test(groups={"positive"})
	public void subtractTwoNumberSecondNumberTheBiggest() {
		Assert.assertEquals( result[4],calcutator.operation(test[4]),"Subtraction two number second number grater than first (5-2)");
	}
	@Test(groups={"negative"})
	public void enterEquationWithError(){//enter % or 5t+3
		Assert.assertEquals( result[5], calcutator.operation(test[5]),"enter equation with equale sign ( 5+3= )");
	}
	@Test(groups={"positive"},dependsOnMethods={"setUp"})
	public void enterNumber(){
		Assert.assertEquals(result[6], calcutator.operation(test[6]),"enter just enter number (55)");
	}
	@Test(groups={"positive"})
	public void divideOddByEven(){
		Assert.assertEquals(result[7],calcutator.operation(test[7]),"dived odd by even number (5/2)");
	}
	@Test(groups={"positive"})
	public void divideByZero(){
		Assert.assertEquals(result[8],calcutator.operation(test[8]),"dived by zero (9/0)");
	}
	@Test(groups={"negative"})
	public void enterEquationWithoutNumber(){
		AssertJUnit.assertEquals(result[9],calcutator.operation(test[9]),"enter equation with error (5eew+3) ");
	}
	@Test(groups={"negative"}) 
	public void enterDoubleEqualSign(){
		Assert.assertEquals(result[10],calcutator.operation(test[10]),"enter  double equal sign(5+3==)");
	}
	@Test(groups={"negative"})
	public void enterOneOpretor(){
		Assert.assertEquals(result[11],calcutator.operation(test[11]),"enter one opretor (*)");
	}
	@Test(groups={"negative"})
	public void enterDoubleOpretor(){
		Assert.assertEquals(result[12],calcutator.operation(test[12]),"enter double  opretor (5**5)");
	}
	
	
	

}
