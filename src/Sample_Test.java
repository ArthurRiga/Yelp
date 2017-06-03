import org.testng.annotations.Test;




public class Sample_Test {
	
	@Test //TestApp is our test case.
		//Test is in-built class in TestNG. Test is rep
	public void testApp(){
		System.out.println("Testing app");
	}
	
	@Test
	public void testLogin(){
		System.out.println("Testing login");
	}
}
