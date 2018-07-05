package maven;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculatorAppTest {
	String[] test = new String[15];
	String[] result = new String[15];
	CalculatorApp calcutator = new CalculatorApp();

	@Before
	public void setUp() {
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

	@Test
	public void addTwoNumber() {
	    assertEquals("add two number (5+3) ", result[0], calcutator.operation(test[0]));
	}
	@Test 
	public void multiplyTwoNumber(){
		assertEquals("multiply two number (5*2)", result[1], calcutator.operation(test[1]));
	}
	@Test
	public void divideTwoNumber() {
		assertEquals("dived two number (6/3)", result[2],calcutator.operation(test[2]));//Dived 
	}
	@Test
	public void subtractTwoNumber() {
		assertEquals("Subtract two number (10-3)", result[3],calcutator.operation(test[3]));
	}
	@Test
	public void subtractTwoNumberSecondNumberTheBiggest() {
		assertEquals("Subtraction two number second number grater than first (5-2)", result[4],calcutator.operation(test[4]));
	}
	@Test
	public void enterEquationWithError(){//enter % or 5t+3
		assertEquals("enter equation with equale sign ( 5+3= )", result[5], calcutator.operation(test[5]));
	}
	@Test
	public void enterNumber(){
		assertEquals("enter just enter number (55)",result[6], calcutator.operation(test[6]));
	}
	@Test 
	public void divideOddByEven(){
		assertEquals("dived odd by even number (5/2)",result[7],calcutator.operation(test[7]));
	}
	@Test
	public void divideByZero(){
		assertEquals("dived by zero (9/0)",result[8],calcutator.operation(test[8]));
	}
	@Test
	public void enterEquationWithoutNumber(){
		assertEquals("enter equation with error (5eew+3) ",result[9],calcutator.operation(test[9]));
	}
	@Test 
	public void enterDoubleEqualSign(){
		assertEquals("enter  double equal sign(5+3==)",result[10],calcutator.operation(test[10]));
	}
	@Test
	public void enterOneOpretor(){
		assertEquals("enter one opretor (*)",result[11],calcutator.operation(test[11]));
	}
	@Test
	public void enterDoubleOpretor(){
		
		assertEquals("enter double  opretor (5**5)",result[12],calcutator.operation(test[12]));
	}
	
	
	

}
