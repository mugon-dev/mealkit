package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import dao.MaterialDao;
import dao.MemberDao;
import dao.OrderDao;
import dao.RecipeDao;
import vo.Blog;
import vo.Material;
import vo.Member;
import vo.Order;
import vo.OrderPrice;
import vo.PageMaker;
import vo.Recipe;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("*.do")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_REPO = "C:\\Users\\admin\\Desktop\\work2\\mealkit\\WebContent\\images"; // 파일업로드용

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String action = requestURI.substring(contextPath.length());
		if (action.equals("/main.do")) {
			List<Material> list=new ArrayList<Material>();
			list=MaterialDao.getInstance().selectMain();
			request.setAttribute("list", list);
			request.getRequestDispatcher("main/home.jsp").forward(request, response);
		} else if (action.equals("/loginForm.do")) {
			String mil_no= request.getParameter("no");
			request.setAttribute("mil_no", mil_no);
			request.getRequestDispatcher("main/login.jsp").forward(request, response);
		} else if (action.equals("/login.do")) { // 로그인
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");	
			String mil_no = request.getParameter("mil_no");
			int n = MemberDao.getInstance().login(id, pw);
			int no = MemberDao.getInstance().getMemberNo(id);
			if (n == 1) {
//    			session 생성
				HttpSession session = request.getSession();
				session.setAttribute("session_id", id);
				session.setAttribute("session_no", no);
				System.out.println(mil_no);
				System.out.println("sdlkjsldf");
				
				if(mil_no!="") {
					out.print("<script>alert('로그인성공');location.href='product.do?no="+mil_no+"';</script>");
				}else {
					out.print("<script>alert('로그인성공');location.href='main.do';</script>");
				}
				
			} else if (n == 0) {
				out.print("password error");
			} else {
				out.print("id error");
			} // myPageForm.do
		} else if (action.equals("/myPageForm.do")) { // myPage 이동
			request.getRequestDispatcher("main/myPage.jsp").forward(request, response);
		} else if (action.equals("/registerForm.do")) {
			request.getRequestDispatcher("main/register.jsp").forward(request, response);
		} else if (action.equals("/register.do")) { // 회원가입
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String addr = request.getParameter("addr");
			String tel = request.getParameter("tel");
			boolean flag = MemberDao.getInstance().insert(new Member(id, pw, name, addr, tel));
			if (flag) {
				out.print("<script>alert('회원가입성공');location.href='main.do';</script>");
			} else {
				out.print("<script>alert('회원가입실패');location.href='registerForm.do';</script>");
			}
		} else if (action.equals("/overappedId.do")) { // 아이디 중복확인
			String id = request.getParameter("id");
			boolean flag = MemberDao.getInstance().overappedId(id);
			if (flag) {
				out.print("not usable");
			} else {
				out.print("usable");
			}
		} else if (action.equals("/shopForm.do")) {
			List<Material> list=new ArrayList<Material>();
			list=MaterialDao.getInstance().selectMain();
			request.setAttribute("list", list);
			List<Recipe> listRecipe=new ArrayList<Recipe>();
			listRecipe=RecipeDao.getInstance().selectAll();
			request.setAttribute("recipe", listRecipe);
			request.getRequestDispatcher("main/shop.jsp").forward(request, response);
		} else if (action.equals("/shop.do")) {

		} else if (action.equals("/matForm.do")) { // 재료 등록 modal
			List<Material> list = MaterialDao.getInstance().selectAll();
			List<Material> selectMeat = MaterialDao.getInstance().selectList("10");
			List<Material> selectVeg = MaterialDao.getInstance().selectList("20");
			List<Material> selectSau = MaterialDao.getInstance().selectList("30");
			request.setAttribute("list", list);
			request.setAttribute("selectMeat", selectMeat);
			request.setAttribute("selectVeg", selectVeg);
			request.setAttribute("selectSau", selectSau);
			request.getRequestDispatcher("main/mat.jsp").forward(request, response);
		} else if (action.equals("/mat.do")) { // 재료 등록 , 사진업로드, hsahmap으로 수정
			//Map<String, String> materialMap = MaterialDao.getInstance().upload(request, response,FILE_REPO);
			Map<String, String> materialMap = upload(request, response);

			int mat_no = Integer.parseInt(materialMap.get("mat_no"));
			String mat_idx = materialMap.get("mat_idx");
			String mat_nm = materialMap.get("mat_nm");
			int mat_price = Integer.parseInt(materialMap.get("mat_price"));
			int mat_unit = Integer.parseInt(materialMap.get("mat_unit"));
			String mat_image = materialMap.get("filename");
			System.out.println(materialMap.toString());
			boolean flag = MaterialDao.getInstance().insert(new Material(mat_no, mat_idx, mat_nm, mat_price, mat_unit, mat_image));
			if(flag) {
				out.print("<script>alert('새 글을 추가했습니다.'); location.href='matForm.do';</script>");
			} else {
				out.print("<script>alert('새 글 추가 실패했습니다.'); location.href='matForm.do';</script>");
			}
    	}  else if (action.equals("/logout.do")) { // 로그아웃 header의 ajax 스크립트
			HttpSession session = request.getSession();
			session.removeAttribute("session_id");
			session.removeAttribute("session_no");
			out.print("success");
		} else if (action.equals("/myPageForm.do")) { // myPage 이동
			request.getRequestDispatcher("main/myPage.jsp").forward(request, response);
		} else if (action.equals("/registerForm.do")) {
			request.getRequestDispatcher("main/register.jsp").forward(request, response);
		} else if (action.equals("/register.do")) { // 회원가입
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String addr = request.getParameter("addr");
			String tel = request.getParameter("tel");
			boolean flag = MemberDao.getInstance().insert(new Member(id, pw, name, addr, tel));
			if (flag) {
				out.print("<script>alert('회원가입성공');location.href='main.do';</script>");
			} else {
				out.print("<script>alert('회원가입실패');location.href='registerForm.do';</script>");
			}
		} else if (action.equals("/overappedId.do")) { // 아이디 중복확인
			String id = request.getParameter("id");
			boolean flag = MemberDao.getInstance().overappedId(id);
			if (flag) {
				out.print("not usable");
			} else {
				out.print("usable");
			}
		} else if (action.equals("/shopForm.do")) {
			request.getRequestDispatcher("main/shop.jsp").forward(request, response);
		} else if (action.equals("/shop.do")) {

		} else if (action.equals("/matForm.do")) { // 재료 등록 modal
			request.getRequestDispatcher("main/mat.jsp").forward(request, response);
		} else if (action.equals("/mat.do")) { // 재료 등록 , 사진업로드, hsahmap으로 수정
			//Map<String, String> materialMap = MaterialDao.getInstance().upload(request, response,FILE_REPO);
			Map<String, String> materialMap = upload(request, response);

			int mat_no = Integer.parseInt(materialMap.get("mat_no"));
			String mat_idx = materialMap.get("mat_idx");
			String mat_nm = materialMap.get("mat_nm");
			int mat_price = Integer.parseInt(materialMap.get("mat_price"));
			int mat_unit = Integer.parseInt(materialMap.get("mat_unit"));
			String mat_image = materialMap.get("filename");
			System.out.println(materialMap.toString());
			boolean flag = MaterialDao.getInstance().insert(new Material(mat_no, mat_idx, mat_nm, mat_price, mat_unit, mat_image));
			if (flag) {
				out.print("<script>alert('새 글을 추가했습니다.'); location.href='matForm.do';</script>");
			} else {
				out.print("<script>alert('새 글 추가 실패했습니다.'); location.href='matForm.do';</script>");
			}
		} else if (action.equals("/logout.do")) { // 로그아웃 header의 ajax 스크립트
			HttpSession session = request.getSession();
			session.removeAttribute("session_id");
			out.print("success");
		} else if(action.equals("/search.do")) {
			//음식 타입 재료 조리방법 get
    		String type1=request.getParameter("type1");
    		int type2=Integer.parseInt(request.getParameter("type2"));
    		String type3=request.getParameter("type3");
    		
    		//레시피 셀렉트
    		List<Recipe> list1=new ArrayList<Recipe>();
    		list1=RecipeDao.getInstance().selectList(type1,type2,type3);
    		request.setAttribute("list", list1);


    		request.getRequestDispatcher("main/search.jsp").forward(request, response);
    	} else if(action.equals("/product.do")) {
    		List<Material> matList=new ArrayList<Material>();
    		int no=Integer.parseInt(request.getParameter("no"));
    		Recipe recipe=RecipeDao.getInstance().selectOne(no);
    		
    		Material mat=MaterialDao.getInstance().selectOne(recipe.getMat_no1());
    		matList.add(mat);
    		if(recipe.getMat_no2()!=0) {
    			mat=MaterialDao.getInstance().selectOne(recipe.getMat_no2());
        		matList.add(mat);
    		}
    		if(recipe.getMat_no3()!=0) {
    			mat=MaterialDao.getInstance().selectOne(recipe.getMat_no3());
        		matList.add(mat);
    		}
    		
    		for(int i=0;i<matList.size();i++) {
    			System.out.println(matList.get(i));
    		}
    		request.setAttribute("matList", matList);
    		request.setAttribute("recipe", recipe);
    		request.getRequestDispatcher("main/product.jsp").forward(request, response);
    	} else if(action.equals("/cart.do")) {
    		List<OrderPrice> listOrder=new ArrayList<OrderPrice>();
    		Order order=null;
    		int count=Integer.parseInt(request.getParameter("count"));
    		String id=request.getParameter("session_id");
    		int no=MemberDao.getInstance().getMemberNo(id);
    		int[] mat=new int[count];
    		for(int i=0;i<count;i++) {
    			int temp=i+1;
    			Material material=MaterialDao.getInstance().selectOne(Integer.parseInt(request.getParameter("material"+temp)));
    			mat[i]=Integer.parseInt(request.getParameter("mat"+temp));
    			order=new Order(no,material.getMat_no(),material.getMat_nm(),mat[i],material.getMat_unit());
    			boolean b=OrderDao.getInstance().insert(order);
    			if(b==true) {
    				System.out.println("카트 입력 성공");
    			}else {
    				System.out.println("카트 입력 실패");
    			}
//    			
//    			System.out.println(mat[i]);
//    			System.out.println(material);
    		}
    		out.print("<script>alert('장바구니 입력 성공. 장바구니로 이동합니다.'); location.href='cartForm.do?id="+id+"';</script>");
    	}else if(action.equals("/cartForm.do")) {
    		List<OrderPrice> listOrder=new ArrayList<OrderPrice>();
    		String id=request.getParameter("id");
    		int no=MemberDao.getInstance().getMemberNo(id);
    		listOrder=OrderDao.getInstance().selectOrder(no);
    		request.setAttribute("listOrder", listOrder);   		
    		request.getRequestDispatcher("main/cart.jsp").forward(request, response);
    	}
    	
    	else if(action.equals("/blogForm.do")) {
    		String strPage = request.getParameter("pageNum");
    		String idx = request.getParameter("idx");
    		String no = request.getParameter("no");
    		if(idx == null || no == null) { 
    			idx = "5";
    			no = "";
    		} 
    		
    		System.out.println("================== blogForm.do ==================");
    		System.out.println("------ strPage: " + strPage);
    		
    		int pageNum = 1;
			if(strPage != null) {
				pageNum = Integer.parseInt(strPage);
			}
			BlogDao blogDao = BlogDao.getInstance();
			int totalCount = blogDao.getBlogCount(idx, no);
			PageMaker pageM = new PageMaker(pageNum, totalCount);
			List<Blog> list = blogDao.selectAll(pageM.getStart(), pageM.getEnd(), idx, no);
			request.setAttribute("pageM", pageM);
			request.setAttribute("list", list); 
    		System.out.println("------ list: " + list);
    		
    		request.getRequestDispatcher("main/blog.jsp").forward(request, response);
    	} else if(action.equals("/blogDetailForm.do")) {
    		System.out.println("================== blogDetailForm.do ==================");
			request.getRequestDispatcher("main/blogDetail.jsp").forward(request, response);
		} else if(action.equals("/blogDetail.do")) { 
    		System.out.println("================== blogDetail.do ==================");
			Map<String, String> recipeMap = upload(request, response);
			
			int matQty1 = Integer.parseInt(recipeMap.get("matQty1"));
			int matQty2 = Integer.parseInt(recipeMap.get("matQty2"));
			int matQty3 = Integer.parseInt(recipeMap.get("matQty3")); 
			int no = Integer.parseInt(recipeMap.get("no"));
			String recIdx = recipeMap.get("recIdx");
			String title = recipeMap.get("title");
			String content  = recipeMap.get("content");
			String image = recipeMap.get("image");
			String cookIdx = recipeMap.get("cookIdx");
			String cookType = recipeMap.get("cookType");
			String matNo1 = recipeMap.get("matNo1");
			String matNo2 = recipeMap.get("matNo2");
			String matNo3 = recipeMap.get("matNo3");
			String matEtc = recipeMap.get("matEtc");
			String plate = recipeMap.get("plate");
			String hour = recipeMap.get("hour");
			String level = recipeMap.get("level");
			
			boolean flag = BlogDao.getInstance().insert(new Blog(matQty1, matQty2, matQty3,
					no, recIdx, title, content, image, cookIdx, cookType, matNo1, matNo2,
					matNo3, matEtc, plate,  hour, level));
			
			if(flag) {
				out.print("<script>alert('새 글을 추가했습니다.'); location.href='blogDetail.do';</script>");
			} else {
				out.print("<script>alert('새 글 추가 실패했습니다.'); location.href='blogForm.do';</script>");
			}
    	}
	}

	private int nvl(int parseInt, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 파일 업로드
	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> recipeMap = new HashMap<String, String>();
		String encoding = "UTF-8";
		File currentDirPath = new File(FILE_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024 * 5); // 5GB
		factory.setDefaultCharset(encoding); // 파일올라올때 인코딩
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for (int i = 0; i < items.size(); i++) {
				FileItem item = (FileItem) items.get(i);
				if (item.isFormField()) {
					System.out.println(item.getFieldName() + ":" + item.getString());
					recipeMap.put(item.getFieldName(), item.getString());
				} else {
					System.out.println("파라미터명: " + item.getFieldName());
					System.out.println("파일명: " + item.getName());
					System.out.println("파일의 크기: " + item.getSize());

					if (item.getSize() > 0) {
						int idx = item.getName().lastIndexOf("\\"); // 윈도우시스템
						if (idx == -1) {
							idx = item.getName().lastIndexOf("/"); // 리눅스시스템 파일 마지막 부분
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
	//mat 업로드
	public Map<String, String> matUpload(HttpServletRequest request, HttpServletResponse response,String FILE_REPO) throws ServletException, IOException {
  		Map<String, String> matetrialMap = new HashMap<String, String>();
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
  					matetrialMap.put(item.getFieldName(), item.getString());
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
  						matetrialMap.put(item.getFieldName(), fileName);
  						item.write(uploadFile);
  					}
  				}
  			}
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		return matetrialMap;
  	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

}
