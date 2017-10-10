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

import org.dimigo.vo.UserVO;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(asyncSupported = true, name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
      rd.forward(request,  response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("application/json;charset=utf-8");
      PrintWriter out = response.getWriter();
      
      request.setCharacterEncoding("utf-8");
      String id = request.getParameter("id");
      String pwd = request.getParameter("pwd");
      System.out.printf("id : %s, pwd : %s\n", id, pwd);
      
      boolean result = true;
      
      if(result) {
    	  // 세션에 사용자 정보 생성
    	 HttpSession session = request.getSession();
    	  
    	 UserVO user = new UserVO();
    	 user.setId(id);
    	 user.setName("홍길동");
    	 user.setNickname("의적");
    	  
    	 session.setAttribute("user", user);
    	 RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
    	 rd.forward(request,  response);
      } else {
    	  request.setAttribute("msg", "error");
    	  RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
    	  rd.forward(request,  response);
      }
      out.close();
   }
}