package calculator;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/calculate")
public class Calci  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		int x=Integer.parseInt(req.getParameter("x"));
		int y=Integer.parseInt(req.getParameter("y"));
		String operation=req.getParameter("operation");
		
		switch(operation) {
		case "add":{
		    
		    int result = x + y;

		    if(result % 2 == 0)
		        resp.getWriter().println(
		        "<h1>"+result+" is Even</h1>");
		    else
		        resp.getWriter().println(
		        "<h1>"+result+" is Odd</h1>");

		    break;
		}
//		case "add":{
//			if((x+y)%2==0)
//				req.getRequestDispatcher("even.html").forward(req, resp);
//			else
//				req.getRequestDispatcher("odd.html").forward(req, resp);
//			break;
//		}
		case "sub":{
			resp.getWriter().println("<h1 style='color:red' align='center'>The Difference of "+x+" and "+ y +"is" + (x-y)+ "</h1>");
			break;
			}
		case "mul":{
			resp.getWriter().println("<h1 style='color:red' align='center'>The multiplication of "+x+" and "+ y +"is" + (x*y)+ "</h1>");
			break;
			}
		case "div":{
			resp.getWriter().println("<h1 style='color:red' align='center'>The Division of "+x+" and "+ y +"is" + (x/(double)y)+ "</h1>");
			break;
			}
		default:
			throw new IllegalArgumentException("Unexpected value: "+operation);
		}
		
	}

}
