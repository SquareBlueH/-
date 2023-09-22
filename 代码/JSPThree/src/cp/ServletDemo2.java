package cp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo2
 */
@WebServlet("/ServletDemo2")
public class ServletDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("get方法提交");
						for (int i = 1; i <= 9; i++) {
							response.getWriter().println("</br>");//换行
							for (int j = 1; j <= i; j++) {
								response.getWriter().print(j + "*" + i + "=" + j * i+" ");
								}		
							}response.getWriter().println();
							}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("post方法提交");
						for (int i = 1; i <= 9; i++) {
							response.getWriter().println("</br>");//换行
							for (int j = 1; j <= i; j++) {
								response.getWriter().print(j + "*" + i + "=" + j * i+" ");
								}		
							}response.getWriter().println();
	}
}
