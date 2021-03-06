import static org.junit.Assert.*;

import org.junit.Test;

public class SpreadsheetTest {
    
	Spreadsheet test = new Spreadsheet();
	
	@Test
	public void test1() {
		test.set("A1", "1");
	    assertTrue(test.get("A1").equals("1"));	
	}
	
	@Test
	public void test2() {
		test.set("A2", "-1");
	    assertTrue(test.evaluate("A2").equals("-1"));	
	}
	@Test
	public void test3() {
		test.set("A3", "5A");
	    assertTrue(test.evaluate("A3").equals("#Error"));	
	}
	@Test
	public void test4() {
		test.set("A4", "�an animal�");
	    assertTrue(test.evaluate("A4").equals("an animal"));	
	}
	@Test
	public void test5() {
		test.set("A1", "�a string");
	    assertTrue(test.evaluate("A1").equals("#Error"));	
	}@Test
	public void test6() {
		test.set("A5", "=�a string�");
	    assertTrue(test.evaluate("A5").equals("a string"));	
	}@Test
	public void test7() {
		test.set("B1", "=�a string");
	    assertTrue(test.evaluate("B1").equals("#Error"));	
	}
	@Test
	public void test8() {
		test.set("A4", "wizard");
		test.set("B2", "=A4");
	    assertTrue(test.evaluate("B2").equals("wizard"));	
	}
	@Test
	public void test9() {
		test.set("A6", "5A");
		test.set("C6", "=A6");
	    assertTrue(test.evaluate("C6").equals("#Error"));	
	}
	@Test
	public void test10() {
		test.set("O6", "=P6");
		test.set("P6", "=O6");
	    assertTrue(test.evaluate("P6").equals("#Circular"));	
	}
	@Test
	public void test11() {
		test.set("A1", "=1+1*2");
		assertTrue(test.evaluate("A1").equals("4"));	
	}
	@Test
	public void test12(){
		test.set("A2", "=1+A1");
		assertTrue(test.evaluate("A2").equals("#Error"));
	}
	
	@Test
	public void test13(){
		test.set("A5", "=�a�&�String�");
		assertTrue(test.evaluate("A5").equals("aString"));
	}
	@Test
	public void test14(){
		test.set("A6", "=�a&�String�");
		assertTrue(test.evaluate("A6").equals("#Error"));
	}
	@Test
	public void test15(){
		test.set("A9", "=1+(1*2)");
		assertTrue(test.evaluate("A9").equals("3"));
	}
	@Test
	public void test16(){
		test.set("G1", "=1+(1*2");
		assertTrue(test.evaluate("G1").equals("#Error"));
	}
	@Test
	public void test17(){
		test.set("A9", "=1  +  (   1   *   2)");
		assertEquals(test.evaluate("A9"),"3");
	}

}