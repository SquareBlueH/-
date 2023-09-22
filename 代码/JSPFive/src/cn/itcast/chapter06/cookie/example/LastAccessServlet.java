package cn.itcast.chapter06.cookie.example;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class LastAccessServlet
 */
public class LastAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LastAccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String lastAccessTime=null;
		Cookie[] cookies=request.getCookies();
		for(int i=0;cookies !=null&&i<cookies.length;i++) {
			if("lastAccess".equals(cookies[i].getName())) {
				lastAccessTime=cookies[i].getValue();
				break;
			}
		}
		if(lastAccessTime==null) {
			response.getWriter().print("首次访问该网站");
		}else {
			response.getWriter().print("上次访问的网站时间"+lastAccessTime);
		}
		
		String currenttime=new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss").format(new Date());
		Cookie cookie=new Cookie("lastAccess",currenttime);
		//cookie.setMaxAge(10);
		cookie.setPath("/JSPFive");
		response.addCookie(cookie);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
