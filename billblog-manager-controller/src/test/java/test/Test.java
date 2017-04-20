package test;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class Test {
	public static void path(HttpServletRequest request){
		System.out.println(request.getSession().getServletContext().getRealPath("Test.java"));
		String s = "改进了转发功能，能够显示转发次数（但不能查看具体的转发链），被转发时会在“@我“”那里有提示。";
		String [] t = StringUtils.split(s,"@_@");
		System.out.println(t[0]+"  "+t[1]);
		
	}
	public static void main(String [] args){
		long d = (Long)null;
		System.out.println(d);
		System.out.println("-------");
	}
}
