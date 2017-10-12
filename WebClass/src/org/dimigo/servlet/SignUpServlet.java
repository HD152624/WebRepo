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

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("jsp/signup.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		
//		Gson gson = new Gson();
//		JsonObject json = new JsonObject();
//		json.addProperty("id",id);
//		String j = gson.toJson(json);
//		System.out.println(j);
//		out.write(j);
		boolean result = true;
		
		if(result) {
			HttpSession session = request.getSession();
			UserVo user = new UserVo();
			user.setId(id);
			user.setName(name);
			user.setNick(nickname);
			user.setPw(pw);
			session.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			rd.forward(request, response);
			
		}
		else {
			HttpSession session = request.getSession();
			UserVo user = new UserVo();
			user.setId(id);
			user.setName(name);
			user.setNick(nickname);
			user.setPw(pw);
			session.setAttribute("user", user);
			request.setAttribute("msg", "error");
			RequestDispatcher rd = request.getRequestDispatcher("jsp/signup.jsp");
			rd.forward(request, response);
		}
		//out.close();
		}

}