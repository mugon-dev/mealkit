package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.BlogDao;
import dao.DishDao;
import dao.MemberDao;
import dao.RecipeDao;
import dao.ReplyDao;
import vo.Blog;
import vo.Dish;
import vo.Member;
import vo.PageMaker;
import vo.Recipe;
import vo.Reply;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("*.do")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_REPO = "D:\\src\\mealkit\\mealkit\\WebContent\\images"; //파일업로드용 
	  
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
    		}//myPageForm.do
    	}else if(action.equals("/myPageForm.do")) { //myPage 이동
    		request.getRequestDispatcher("main/myPage.jsp").forward(request, response);	
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
    		
    	}else if(action.equals("/matForm.do")) {
    		request.getRequestDispatcher("main/mat.jsp").forward(request, response);
    	}else if(action.equals("/blogForm.do")) {
    		BlogDao blogDao = BlogDao.getInstance();
    		String strPage = request.getParameter("pageNum");
    		String idx = request.getParameter("idx");
    		int no = 1;
    		/*if(request.getParameter("no") == null) {
    			System.out.println("로그인 하지 않은 사용자 블로그 접근");
    			no = 1;
    			//out.print("<script>alert('로그인한 사용자만 이용가능합니다. '); location.href='login.do';</script>"); // 왜 안됨? 
    		} else {
    			no = Integer.parseInt(request.getParameter("no"));
    			System.out.println("로그인한 회원번호: " + no);
    		}*/
    		
			int pageNum = 1;
			if(strPage != null) {
				pageNum = Integer.parseInt(strPage);
			}
			int totalCount = blogDao.getBlogCount();
			PageMaker pageM = new PageMaker(pageNum, totalCount);
			
			List<Blog> list = blogDao.selectAll(pageM.getStart(), pageM.getEnd());
			
    		request.setAttribute("list", list);
    		for(int i=0;i<list.size();i++) {
    			System.out.println(list.get(i));
    		}
    		request.getRequestDispatcher("main/blog.jsp").forward(request, response);
    		
    	}else if(action.equals("/logout.do")) { //로그아웃 header의 ajax 스크립트
        		HttpSession session = request.getSession();
        		session.removeAttribute("session_id");
        		out.print("success");		
    	}else if(action.equals("/blog.do")) { //========================================================//
    		String strPage = request.getParameter("pageNum");
			int pageNum = 1;
			if(strPage != null) {
				pageNum = Integer.parseInt(strPage);
			}
			BlogDao blogDao = BlogDao.getInstance();
			int totalCount = blogDao.getBlogCount();
			PageMaker pageM = new PageMaker(pageNum, totalCount);
			
			List<Blog> list = blogDao.selectAll(pageM.getStart(), pageM.getEnd());
			request.setAttribute("pageM", pageM);
			request.setAttribute("list", list);
			System.out.println("pageM.getStart(): " + pageM.getStart() + ", pageM.getEnd(): " + pageM.getEnd());
			request.getRequestDispatcher("main/blog.jsp").forward(request, response);
			
    	}else if(action.equals("/blogDetailForm.do")) {
    		request.getRequestDispatcher("main/blogDetail.jsp").forward(request, response);
    	}else if(action.equals("/blogDetail.do")) { // 블로그 상세
    		int milNo = Integer.parseInt(request.getParameter("mil_no"));
			boolean flag = BlogDao.getInstance().updateReadCount(milNo);
			Blog blog = BlogDao.getInstance().selectOne(milNo);
			List<Reply> replyList = ReplyDao.getInstance().selectReply(milNo);
			if(blog != null && flag == true) {
				request.setAttribute("replyList", replyList);
				request.setAttribute("blog", blog);
				request.getRequestDispatcher("main/blogDetail.jsp").forward(request, response);
			} else {
				out.print("<script>alert('게시글 조회 실패.'); location.href='blog.do';</script>");
			}
    	}else if(action.equals("/search.do")) {
    		String type1=request.getParameter("type1");
    		String type2=request.getParameter("type2");
    		String type3=request.getParameter("type3");
    		//List<Dish> list=new ArrayList<Dish>();
    		//list=DishDao.getInstance().selectSearch(type1, type2, type3);
    		request.setAttribute("type1", type1);
    		request.setAttribute("type2", type2);
    		request.setAttribute("type3", type3);
    		List<Recipe> list1=new ArrayList<Recipe>();
    		list1=RecipeDao.getInstance().selectAll();
    		request.setAttribute("list", list1);
    		
    		//request.setAttribute("list", list);

    		request.getRequestDispatcher("main/search.jsp").forward(request, response);
    	}else if(action.equals("/product.do")) {
    		int no=Integer.parseInt(request.getParameter("no"));
    		System.out.println(no);
    		Recipe recipe=RecipeDao.getInstance().selectOne(no);
    		request.setAttribute("recipe", recipe);
    		System.out.println(recipe);
    		//Dish dish=DishDao.getInstance().selectOne(name);
    		//System.out.println(dish);
    		//request.setAttribute("dish", dish);
    		request.getRequestDispatcher("main/product.jsp").forward(request, response);
    	}else if(action.equals("/cartForm.do")) {
    		request.getRequestDispatcher("main/cart.jsp").forward(request, response);
    	}	
    	
	}
	
    // 파일 업로드 
  	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		Map<String, String> recipeMap = new HashMap<String, String>();
  		String encoding = "UTF-8";
  		File currentDirPath = new File(FILE_REPO);
  		DiskFileItemFactory factory = new DiskFileItemFactory();
  		factory.setRepository(currentDirPath);
  		factory.setSizeThreshold(1024*1024*5); //5GB
  		factory.setDefaultCharset(encoding); //파일올라올때 인코딩
  		ServletFileUpload upload = new ServletFileUpload(factory);
  		try {
  			List<FileItem> items = upload.parseRequest(request);
  			for(int i = 0 ; i < items.size() ; i++) {
  				FileItem item = (FileItem)items.get(i);
  				if(item.isFormField()) {
  					System.out.println(item.getFieldName() + ":" + item.getString());
  					recipeMap.put(item.getFieldName(), item.getString());
  				} else {
  					System.out.println("파라미터명: " + item.getFieldName());
  					System.out.println("파일명: " + item.getName());
  					System.out.println("파일의 크기: " + item.getSize());
  					
  					if(item.getSize() > 0) {
  						int idx = item.getName().lastIndexOf("\\"); //윈도우시스템
  						if(idx == -1) {
  							idx = item.getName().lastIndexOf("/"); //리눅스시스템 파일 마지막 부분 
  						}
  						String fileName = item.getName().substring(idx + 1);
  						File uploadFile = new File(currentDirPath + "\\" + fileName);
  						recipeMap.put(item.getFieldName(), fileName);
  						item.write(uploadFile);
  					}
  				}
  			}
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		return recipeMap;
  	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

}
