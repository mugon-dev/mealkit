package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.Member;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("*.do")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	request.setCharacterEncoding("utf-8");
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String action=requestURI.substring(contextPath.length());
		if(action.equals("/main.do")) {
			request.getRequestDispatcher("main/home.jsp").forward(request, response);
    	}else if(action.equals("/loginForm.do")) {
    		request.getRequestDispatcher("main/login.jsp").forward(request, response);
    	}else if(action.equals("/login.do")) { //로그인
    		String id = request.getParameter("id");
    		String pw = request.getParameter("pw");
    		int n = MemberDao.getInstance().login(id, pw);
    		if(n==1) {
//    			session 생성
    			HttpSession session = request.getSession();
    			session.setAttribute("session_id", id);
    			out.print("<script>alert('로그인성공');location.href='main.do';</script>");
    		}else if(n==0) {
    			out.print("password error");
    		}else {
    			out.print("id error");
    		}
    		
    	}else if(action.equals("/registerForm.do")) {
    		request.getRequestDispatcher("main/register.jsp").forward(request, response);
    	}else if(action.equals("/register.do")) { //회원가입
    		String id=request.getParameter("id");
    		String pw=request.getParameter("pw");
    		String name=request.getParameter("name");
    		String addr=request.getParameter("addr");
    		String tel=request.getParameter("tel");
    		boolean flag=MemberDao.getInstance().insert(new Member(id, pw, name, addr, tel));
    		if(flag) {
    			out.print("<script>alert('회원가입성공');location.href='main.do';</script>");
    		}else {
    			out.print("<script>alert('회원가입실패');location.href='registerForm.do';</script>");
    		}
    	}else if(action.equals("/overappedId.do")){ //아이디 중복확인
    		String id = request.getParameter("id");
    		boolean flag=MemberDao.getInstance().overappedId(id);
    		if(flag) {
    			out.print("not usable");
    		}else {
    			out.print("usable");
    		}	
    	}else if(action.equals("/shopForm.do")) {
    		request.getRequestDispatcher("main/shop.jsp").forward(request, response);
    	}else if(action.equals("/shop.do")) {
    		
    	}else if(action.equals("/blogForm.do")) {
    		request.getRequestDispatcher("main/blog.jsp").forward(request, response);
    	}else if(action.equals("/blog.do")) {
    		
    	}
    		
    	
	}
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

}
