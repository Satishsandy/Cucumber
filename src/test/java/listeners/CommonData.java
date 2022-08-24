package listeners;

import org.testng.annotations.Test;

public class CommonData {
	 @Test
	  public void testmethod1() {
		 int  x= 10;
	    throw new RuntimeException("Test not implemented"+x);
	  }

	  @Test
	  public void testmethod2() {
		  String s="Satish";
	    throw new RuntimeException("Test not implemented"+s);
	  }

	  @Test
	  public void testmethod3() {
		  int k=90;
	    throw new RuntimeException("Test not implemented"+k);
	  }

	  @Test
	  public void testmethod4() {
		  String j="Sandhya";
	    throw new RuntimeException("Test not implemented"+j);
	  }

}
