package cs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListBookServlet
 */
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("Text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		Collection<Book>books=BookDB.getAll();
		out.print("本站提供的图书有：<br>");
		for(Book book :books) {
			String url="/JSPFive/PurchaseServlet?id="+book.getId();
			out.write(book.getName()+"<a href='"+url+"'>点击购买</a><br>");
		}
	}
}
