package org.dimigo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.vo.UserVo;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/bloglogin")
public class BlogLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("myblog/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		boolean result = "test@naver.com".equals(id);
		
		if(result) {
			HttpSession session = request.getSession();
			UserVo user = new UserVo();
			user.setId(id);
			user.setPw(pw);
			user.setName("관리자");
			user.setNick("관리자");
			session.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("myblog/home.jsp");
			rd.forward(request, response);
			
		}
		else {
			HttpSession session = request.getSession();
			UserVo user = new UserVo();
			user.setId(id);
			user.setPw(pw);
			session.setAttribute("user", user);
			request.setAttribute("msg", "error");
			RequestDispatcher rd = request.getRequestDispatcher("myblog/login.jsp");
			rd.forward(request, response);
		}
		
	}
}