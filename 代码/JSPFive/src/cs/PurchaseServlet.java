package cs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PurchaseServlet
 */
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html;charset=utf-8");
		String id=request.getParameter("id");
		if(id==null) {
			String url="/JSPFive/ListBookServlet";
			response.sendRedirect(url);
			return;
		}
		Book book=BookDB.getBook(id);
		HttpSession session=request.getSession();
		List<Book>cart=(List)session.getAttribute("cart");
		if(cart==null) {
			cart=new ArrayList<Book>();
			session.setAttribute("cart", cart);
		}
		
		cart.add(book);
		
		Cookie cookie=new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60 * 30);
		cookie.setPath("/JSPFive");
		response.addCookie(cookie);
		String url="/JSPFive/CartServlet";
		response.sendRedirect(url);
		
	}

}
