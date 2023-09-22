package cs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("Text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		List<Book>cart=null;
		
		boolean purFlag=true;
		
		HttpSession session=request.getSession(false);
		
		if(session==null) {
			purFlag=false;
		}else {
			cart=(List)session.getAttribute("cart");
			
			if(cart==null) {
				purFlag=false;
			}
		}
		
		if(!purFlag) {
			out.print("对不起!您还没有购买任何商品!<br>");
		}else {
			out.write("您购买的图书有：<br>");
			double price=0;
			for(Book book: cart) {
				out.write(book.getName()+"<br>");
			}
		}
	}

}
