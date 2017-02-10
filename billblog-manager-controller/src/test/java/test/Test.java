package test;
import javax.servlet.http.HttpServletRequest;

public class Test {
	public static void path(HttpServletRequest request){
		System.out.println(request.getSession().getServletContext().getRealPath("Test.java"));
	}
}
