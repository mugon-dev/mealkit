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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.BlogDao;
import dao.MaterialDao;
import dao.MemberDao;
import dao.OrderDao;
import dao.RecipeDao;
import dao.ReplyDao;
import vo.Blog;
import vo.IScomb;
import vo.Material;
import vo.Member;
import vo.Order;
import vo.OrderPrice;
import vo.PageMaker;
import vo.Recipe;
import vo.Reply;

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
		/*==============================================================메인 home 시작=============================================================*/
		if (action.equals("/main.do")) {
			List<Material> list=new ArrayList<Material>();
			list=MaterialDao.getInstance().selectMain();
			request.setAttribute("list", list);
			List<Recipe> recipe1 = new ArrayList<Recipe>();
			List<Recipe> recipe2 = new ArrayList<Recipe>();
			String idx1 = "1";
			String idx2 = "2";
			recipe1 = RecipeDao.getInstance().selectLatest(idx1);
			recipe2 = RecipeDao.getInstance().selectLatest(idx2);
			request.setAttribute("recipe1", recipe1);
			request.setAttribute("recipe2", recipe2);
			request.getRequestDispatcher("main/home.jsp").forward(request, response);
		/*==============================================================로그인,회원관리 시작=============================================================*/
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
				if(mil_no!="") {
					out.print("<script>alert('로그인성공');location.href='product.do?no="+mil_no+"';</script>");
				}else {
					out.print("<script>alert('로그인성공');location.href='main.do';</script>");
				}
			} else if (n == 0) {
				out.print("<script>alert('비밀번호 틀림');location.href='loginForm.do';</script>");
			} else {
				out.print("<script>alert('아이디 틀림');location.href='loginForm.do';</script>");
			}
		} else if (action.equals("/readPerson.do")) { //session_no 받아오기 
			int no = Integer.parseInt(request.getParameter("no"));
			System.out.println("readperson"+no);
			Member member = MemberDao.getInstance().selectOne(no);
			String name = member.getName();
			String addr = member.getAddr();
			String tel = member.getTel();
			System.out.println(member.toString());
	    	JSONObject memberInfo = new JSONObject();
	    	JSONObject totalObject = new JSONObject();
	    	memberInfo.put("name", name);
	    	memberInfo.put("addr", addr);
	    	memberInfo.put("tel", tel);
	    	totalObject.put("members", memberInfo);
	    	String jsonInfo = totalObject.toJSONString();
	    	System.out.println(jsonInfo);
	    	out.print(jsonInfo);
		} else if (action.equals("/memberDelete.do")) { //member.no 받아와서 삭제
			int no = Integer.parseInt(request.getParameter("no"));
			boolean flag = MemberDao.getInstance().delete(no);
			if(flag) {
				out.print("<script>alert('삭제 성공');location.href='main.do';</script>");
			}else {
				out.print("<script>alert('삭제 실패');location.href='main.do';</script>");
			}
		} else if (action.equals("/memberUpdate.do")) { //session_no 받아오기
			int no = Integer.parseInt(request.getParameter("no"));
			Member member = MemberDao.getInstance().selectOne(no);
			String name = request.getParameter("name");
			if(name==null) {
				name = member.getName();
			}
			String addr = request.getParameter("addr");
			if(addr==null) {
				addr = member.getAddr();
			}
			String tel = request.getParameter("tel");
			if(addr==null) {
				tel = member.getTel();
			}
			boolean flag = MemberDao.getInstance().update(new Member(no, name, addr, tel));
			if (flag) {
				out.print("<script>alert('회원 수정 성공');location.href='main.do';</script>");
			} else {
				out.print("<script>alert('회원 수정 실패');location.href='main.do';</script>");
			}
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
		}else if (action.equals("/logout.do")) { // 로그아웃 header의 ajax 스크립트
			HttpSession session = request.getSession();
			session.removeAttribute("session_id");
			session.removeAttribute("session_no");
			out.print("success");
		/*==============================================================로그인,회원관리 끝=============================================================*/		
		/*==============================================================mat 시작=============================================================*/
		} else if (action.equals("/matForm.do")) { // 재료 등록 modal
			
			String strPage = request.getParameter("pageNum");
			String idx = request.getParameter("idx");
			int pageNum = 1;
			if(idx==null) {
				idx="0";
			}
			if(strPage != null) {
				pageNum = Integer.parseInt(strPage);
			}
			System.out.println("================== matForm.do ==================");
    		System.out.println("------ strPage: " + strPage);
			int totalCount = MaterialDao.getMatCount(idx);
			PageMaker pageM = new PageMaker(pageNum, totalCount,6);
			pageM.setPageSize(6);
			List<Material> list = MaterialDao.getInstance().selectAll(pageM.getStart(), pageM.getEnd(), idx);
			request.setAttribute("idx", idx);
			request.setAttribute("list", list);
			request.setAttribute("pageM", pageM);
			request.getRequestDispatcher("main/mat.jsp").forward(request, response);
			
		} else if (action.equals("/mat.do")) { // 재료 등록 , 사진업로드, hsahmap으로 수정
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
    	}else if (action.equals("/matDelete.do")) { //mat.no 받아와서 삭제
			String no = request.getParameter("mat_no");
			boolean flag = MaterialDao.getInstance().delete(no);
			if(flag) {
				out.print("<script>alert('삭제 성공');location.href='matForm.do';</script>");
			}else {
				out.print("<script>alert('삭제 실패');location.href='matDetail.do?no="+no+"';</script>");
			}
		} else if (action.equals("/matDetail.do")) { // mat상세페이지
			int no=Integer.parseInt(request.getParameter("no"));
			Material matOne = MaterialDao.getInstance().selectOne(no);
			if(matOne != null) {
			System.out.println("matDetail"+matOne.toString());
			request.setAttribute("mat", matOne);
			request.getRequestDispatcher("main/matDetail.jsp").forward(request, response);
			}else {
				out.print("<script>alert('게시글 조회 실패');location.href='matForm.do';</script>");
			}
		} else if (action.equals("/readMat.do")) { //session_no 받아오기 
			int no = Integer.parseInt(request.getParameter("matNo"));
			System.out.println("readMat"+no);
			Material material = MaterialDao.getInstance().selectOne(no);
			String name = material.getMat_nm();
			int price = material.getMat_price();
			int unit = material.getMat_unit();
			System.out.println(material.toString());
	    	JSONObject matInfo = new JSONObject();
	    	JSONObject totalObject = new JSONObject();
	    	matInfo.put("name", name);
	    	matInfo.put("price", price);
	    	matInfo.put("unit", unit);
	    	totalObject.put("materials", matInfo);
	    	String jsonInfo = totalObject.toJSONString();
	    	System.out.println(jsonInfo);
	    	out.print(jsonInfo);
		} else if (action.equals("/matUpdate.do")) { // mat 수정 
			Map<String, String> materialUp = upload(request, response);
			int no=Integer.parseInt(materialUp.get("mat_no"));
			String name = materialUp.get("mat_nm"); 
			int price=Integer.parseInt(materialUp.get("mat_price"));
			int unit=Integer.parseInt(materialUp.get("mat_unit"));
			String mat_image = materialUp.get("filename"); 
			if(mat_image == null) {
				mat_image=materialUp.get("ex_filename");
			}
			boolean flag = MaterialDao.getInstance().update(new Material(no,name,price,unit,mat_image));
			if(flag) {
				out.print("<script>alert('수정 성공');location.href='matDetail.do?no="+no+"';</script>");
			}else {
				out.print("<script>alert('수정 실패');location.href='matDetail.do?no="+no+"';</script>");
			}	    	
		/*==============================================================mat 끝=============================================================*/
		/*==============================================================shop 시작=============================================================*/
		} else if (action.equals("/shopForm.do")) {
			List<Material> list=new ArrayList<Material>();
			list=MaterialDao.getInstance().selectMain();
			request.setAttribute("list", list);
			List<Recipe> listRecipe=new ArrayList<Recipe>();
			listRecipe=RecipeDao.getInstance().selectAll();
			request.setAttribute("recipe", listRecipe);
			request.getRequestDispatcher("main/shop.jsp").forward(request, response);
		} else if (action.equals("/shop.do")) {
			String cook_idx=request.getParameter("cook_idx");
			String mat_no1=request.getParameter("mat_no1");
			String cook_type=request.getParameter("cook_type");
			
			if(cook_idx==null) {
				cook_idx="0";
			}
			if(mat_no1==null) {
				mat_no1="0";
			}
			if(cook_type==null) {
				cook_type="0";
			}
			List<IScomb> type1=new ArrayList<IScomb>();
			type1.add(new IScomb(0,"전체"));
			type1.add(new IScomb(1,"한식"));
			type1.add(new IScomb(2,"중식"));
			type1.add(new IScomb(3,"일식"));
			type1.add(new IScomb(4,"양식"));
			
			List<IScomb> type3=new ArrayList<IScomb>();
			type3.add(new IScomb(0,"전체"));
			type3.add(new IScomb(1,"구이"));
			type3.add(new IScomb(2,"찜"));
			type3.add(new IScomb(3,"탕"));
			type3.add(new IScomb(4,"생식"));
			type3.add(new IScomb(5,"기타"));
			
			
			String strPage = request.getParameter("pageNum");
			String idx = request.getParameter("idx");
			int pageNum = 1;
			if(idx==null) {
				idx="0";
			}
			if(strPage != null) {
				pageNum = Integer.parseInt(strPage);
			}
			List<Recipe> list=new ArrayList<Recipe>();
			list=RecipeDao.getInstance().selectShopDiv(cook_idx, mat_no1, cook_type);
			System.out.println("================== matForm.do ==================");
    		System.out.println("------ strPage: " + strPage);
			int totalCount = list.size();
			PageMaker pageM = new PageMaker(pageNum, totalCount,6);
			List<Recipe> recipeList = RecipeDao.getInstance().selectShopDiv(pageM.getStart(), pageM.getEnd(), cook_idx, mat_no1, cook_type);
			request.setAttribute("recipeList", recipeList);
			request.setAttribute("pageM", pageM);
			
			
			
			
			List<Material> type2=MaterialDao.getInstance().selectList("10");
			
			
			request.setAttribute("type1", type1);
			request.setAttribute("type2", type2);
			request.setAttribute("type3", type3);
			
			System.out.println(cook_idx);
			
			
			
			
			request.setAttribute("cook_idx", cook_idx);
			request.setAttribute("mat_no1", mat_no1);
			request.setAttribute("cook_type", cook_type);

			request.setAttribute("recipeList", recipeList);
			
			for(int i=0;i<recipeList.size();i++) {
				System.out.println("여기가 셀렉트"+recipeList.get(i).toString());
			}
			
			request.getRequestDispatcher("main/shopDiv.jsp").forward(request, response);
		} else if(action.equals("/search.do")) {
			//음식 타입 재료 조리방법 get
			String cook_idx=request.getParameter("cook_idx");
			String mat_no1=request.getParameter("mat_no1");
			String cook_type=request.getParameter("cook_type");
			
			if(cook_idx==null) {
				cook_idx="0";
			}
			if(mat_no1==null) {
				mat_no1="0";
			}
			if(cook_type==null) {
				cook_type="0";
			}
			
			
			List<Recipe> list_MD=new ArrayList<Recipe>();
			list_MD=RecipeDao.getInstance().selectShopDiv(cook_idx, mat_no1, cook_type,"1");
			request.setAttribute("list_MD", list_MD);
			
			List<Recipe> list_COMM=new ArrayList<Recipe>();
			list_COMM=RecipeDao.getInstance().selectShopDiv(cook_idx, mat_no1, cook_type,"2");
			request.setAttribute("list_COMM", list_COMM);
			
			request.setAttribute("cook_idx", cook_idx);
			request.setAttribute("mat_no1", mat_no1);
			request.setAttribute("cook_type", cook_type);
			System.out.println("cook_idx : "+cook_idx);
			System.out.println("mat_no1 : "+mat_no1);
			System.out.println("cook_type : "+cook_type);
			
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
    		Order order=null;
    		int count=0; //재료의 수
    		int[] mat=null; //각 재료의 개수
			String[] mat_no=null; //각 재료의 재료 번호
			String test =request.getParameter("test"); //구분자
			//blog와 shop의 parameter명이 달라 통일 하기위한 if문
			
			//blog
    		if(test.equals("1")) {
    			
    			count=1;
    			if(!request.getParameter("matNo2").equals("0")) {
    				count++;
    			}
    			if(!request.getParameter("matNo3").equals("0")) {
    				count++;
    			}
    			mat=new int[count];
    			mat_no=new String[count];
    			for(int i=0; i<count;i++) {
    				int temp=i+1;
    				mat[i]=Integer.parseInt(request.getParameter("matQty"+temp));
    				mat_no[i]=request.getParameter("matNo"+temp);
    			}
    			
    		}
    		//shop
    		else if(test.equals("2")){
    			count=Integer.parseInt(request.getParameter("count"));
    			mat=new int[count];
    			mat_no=new String[count];
    			for(int i=0;i<count;i++) {
    				int temp=i+1;
    				mat[i]=Integer.parseInt(request.getParameter("mat"+temp));
    				mat_no[i]=request.getParameter("material"+temp);
    			}
    		}else {
    			
    		}
    		String session_id=request.getParameter("session_id");
    		int no=MemberDao.getInstance().getMemberNo(session_id);
    		
    		for(int i=0;i<count;i++) {
    			Material material=MaterialDao.getInstance().selectOne(Integer.parseInt(mat_no[i]));
    			order=new Order(no,material.getMat_no(),material.getMat_nm(),mat[i],material.getMat_unit());
    			boolean b=OrderDao.getInstance().insert(order);
    			if(b==true) {
    				System.out.println("카트 입력 성공");
    			}else {
    				System.out.println("카트 입력 실패");
    			}

    		}
    		out.print("<script>alert('장바구니 입력 성공. 장바구니로 이동합니다.'); location.href='cartForm.do?id="+session_id+"';</script>");
    	}else if(action.equals("/cartForm.do")) {
    		List<OrderPrice> listOrder=new ArrayList<OrderPrice>();
    		String id=request.getParameter("id");
    		int no=MemberDao.getInstance().getMemberNo(id);
    		listOrder=OrderDao.getInstance().selectOrder(no);
    		request.setAttribute("listOrder", listOrder);   		
    		request.getRequestDispatcher("main/cart.jsp").forward(request, response);
    	}else if (action.equals("/purchase.do")) {
    		int count=Integer.parseInt(request.getParameter("count"));
    		int[] ord_no=new int[count];
    		int[] ord_qty=new int[count];
    		for(int i=0;i<count;i++) {
    			int temp=i+1;
    			ord_no[i]=Integer.parseInt(request.getParameter("ord_"+temp));
    			ord_qty[i]=Integer.parseInt(request.getParameter("qty_"+temp));
    			boolean f=OrderDao.getInstance().update(ord_no[i],ord_qty[i]);
    		}
    		//request.getRequestDispatcher("main/home.jsp").forward(request, response);
    		out.print("<script>location.href='main.do'</script>");
    	}
    	
//============================================================================================================================================//		
    	else if(action.equals("/blogForm.do")) {
    		String strPage = request.getParameter("pageNum");
    		String idx = request.getParameter("idx");
    		String no = request.getParameter("no");
    		String session_id = request.getParameter("session_id");
    		
    		System.out.println("no" + no);
    		if(idx == null) { 
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
    		
    		List<Material> list=new ArrayList<Material>();
			list=MaterialDao.getInstance().selectMain();
			request.setAttribute("list", list);
			
			List<Material> list2=new ArrayList<Material>();
			list2 = MaterialDao.getInstance().selectList("20");
			request.setAttribute("list2", list2);
			
			List<Material> list3=new ArrayList<Material>();
			list3 = MaterialDao.getInstance().selectList("30");
			request.setAttribute("list3", list3);
			
			request.getRequestDispatcher("main/blogDetail.jsp").forward(request, response);
		} else if(action.equals("/blogDetail.do")) { 
			System.out.println("================== blogDetail.do ==================");
    		int milNo = Integer.parseInt(request.getParameter("milNo"));

    		List<Material> list=new ArrayList<Material>();
			list=MaterialDao.getInstance().selectMain();
			request.setAttribute("list", list);

			List<Material> list2=new ArrayList<Material>();
			list2 = MaterialDao.getInstance().selectList("20");
			request.setAttribute("list2", list2);
			
			List<Material> list3=new ArrayList<Material>();
			list3 = MaterialDao.getInstance().selectList("30");
			request.setAttribute("list3", list3);
			
			System.out.println(milNo);
    		Blog blog = BlogDao.getInstance().selectOne(milNo);
    		boolean flag = BlogDao.getInstance().updateReadCount(milNo);
			List<Reply> replyList = ReplyDao.getInstance().selectReply(milNo);
    		if(blog != null && flag == true) {
    			request.setAttribute("replyList", replyList);
    			request.setAttribute("blog", blog);
    			request.getRequestDispatcher("main/blogDetail.jsp").forward(request, response);
    		} else {
				out.print("<script>alert('게시글 조회 실패.'); location.href='blogForm.do';</script>");
			}
			
    	} else if(action.equals("/blogWriteForm.do")) {
    		System.out.println("================== blogWriteForm.do ==================");
    		
			List<Material> list=new ArrayList<Material>();
			list=MaterialDao.getInstance().selectMain();
			request.setAttribute("list", list);

			List<Material> list2=new ArrayList<Material>();
			list2 = MaterialDao.getInstance().selectList("20");
			request.setAttribute("list2", list2);
			
			List<Material> list3=new ArrayList<Material>();
			list3 = MaterialDao.getInstance().selectList("30");
			request.setAttribute("list3", list3);
			
			request.getRequestDispatcher("main/blogWrite.jsp").forward(request, response);
		} else if(action.equals("/blogWrite.do")) { 
			System.out.println("================== blogWrite.do ==================");
			
			Map<String, String> blogMap = upload(request, response);
			
			int matQty1 = Integer.parseInt(blogMap.get("matQty1"));
			int matQty2 = Integer.parseInt(blogMap.get("matQty2"));
			int matQty3 = Integer.parseInt(blogMap.get("matQty3")); 
			int no = Integer.parseInt(blogMap.get("no"));
			String recIdx = blogMap.get("recIdx");
			String title = blogMap.get("title");
			String content  = blogMap.get("content");
			String image = blogMap.get("filename");
			String cookIdx = blogMap.get("cookIdx");
			String cookType = blogMap.get("cookType");
			String matNo1 = blogMap.get("matNo1");
			String matNo2 = blogMap.get("matNo2");
			String matNo3 = blogMap.get("matNo3");
			String matEtc = blogMap.get("matEtc");
			String plate = blogMap.get("plate");
			String hour = blogMap.get("hour");
			String level = blogMap.get("level");
			
			System.out.println(recIdx);
			boolean flag = BlogDao.getInstance().insert(new Blog(matQty1, matQty2, matQty3,
					no, recIdx, title, content, image, cookIdx, cookType, matNo1, matNo2,
					matNo3, matEtc, plate,  hour, level));
			
			if(flag) {
				out.print("<script>alert('새 글을 추가했습니다.'); location.href='blogForm.do';</script>");
			} else {
				out.print("<script>alert('새 글 추가 실패했습니다.'); location.href='blogForm.do';</script>");
			}
    	} else if(action.equals("/deleteBlog.do")) {
    		System.out.println("================== deleteBlog.do ==================");
			int milNo = Integer.parseInt(request.getParameter("milNo"));
			boolean flag = BlogDao.getInstance().delete(milNo);
			String pageNum = request.getParameter("pageNum");
			if(flag) {
				out.print("<script>alert('글을 삭제했습니다.'); location.href='blogForm.do';</script>");
			} else {
				out.print("<script>alert('글삭제를 실패했습니다.'); location.href='blogDetail.do?milNo=" + milNo + "&pageNum=" + pageNum + "';</script>");
			}
		} else if(action.equals("/updateBlog.do")) {
    		System.out.println("================== updateBlog.do ==================");
    		
    		String test=request.getParameter("milNo");
			Map<String, String> blogMap = upload(request, response);
			
			int milNo = Integer.parseInt(blogMap.get("milNo"));
			String title = blogMap.get("title");
			String content = blogMap.get("content");
			String cookIdx = blogMap.get("cookIdx");
			String cookType = blogMap.get("cookType");
			String plate = blogMap.get("plate");
			String hour = blogMap.get("hour");
			String level = blogMap.get("level");
			String recIdx = blogMap.get("recIdx");
			String matEtc = blogMap.get("matEtc");
			String matNo1 = blogMap.get("matNo1");
			String matNo2 = blogMap.get("matNo2");
			String matNo3 = blogMap.get("matNo3");
			int matQty1 = Integer.parseInt(blogMap.get("matQty1"));
			int matQty2 = Integer.parseInt(blogMap.get("matQty2"));
			int matQty3 = Integer.parseInt(blogMap.get("matQty3"));
			String image = blogMap.get("image");
			
			if(image == null) {
				image = blogMap.get("noImage.png");
			}
			
			boolean flag = BlogDao.getInstance().updateBlog(new Blog(matQty1, matQty2, matQty3, recIdx, title, content, 
					image, cookIdx, cookType, matNo1, matNo2, matNo3, matEtc, plate, hour, level, milNo));
			
			if(flag) {
				out.print("<script>alert('글을 수정했습니다.'); location.href='blogDetail.do?milNo=" + milNo + "';</script>");
			} else {
				out.print("<script>alert('글수정을 실패했습니다.'); location.href='blogDetail.do?milNo=" + milNo + "';</script>");
			}
		} else if(action.equals("/replyAdd.do")) {
			int milNo = Integer.parseInt(request.getParameter("milNo"));
			int no = Integer.parseInt(request.getParameter("no"));
			String replys = request.getParameter("replys");

			boolean flag = ReplyDao.getInstance().insertReply(new Reply(milNo, no, replys));
			boolean updateFlag = ReplyDao.getInstance().updateBlogReplyCount(milNo);
			
			if(flag == true && updateFlag == true) {
				out.print("<script>alert('댓글을 작성했습니다.'); location.href='blogDetail.do?milNo=" + milNo + "';</script>");
			} else {
				out.print("<script>alert('댓글을 작성했습니다.'); location.href='blogDetail.do?milNo=" + milNo + "';</script>");
			}
		} else if(action.equals("/replyDelete.do")) {
			int milNo = Integer.parseInt(request.getParameter("milNo"));
			int reNo = Integer.parseInt(request.getParameter("reNo"));
			boolean flag = ReplyDao.getInstance().deleteReply(reNo);
			boolean deleteFlag = ReplyDao.getInstance().deleteBlogReplyCount(milNo);
			
			if(flag == true && deleteFlag == true) {
				out.print("<script>alert('댓글을 삭제했습니다.'); location.href='blogDetail.do?milNo=" + milNo + "';</script>");
			} else {
				out.print("<script>alert('댓글을 삭제했습니다.'); location.href='blogDetail.do?milNo=" + milNo + "';</script>");
			}
		} else if(action.equals("/replyUpdate.do" )) {
			int milNo = Integer.parseInt(request.getParameter("milNo"));
			int reNo = Integer.parseInt(request.getParameter("reNo"));
			boolean flag = ReplyDao.getInstance().updateReply(reNo);
			
			if(flag) {
				out.print("<script>alert('댓글을 수정했습니다.'); location.href='blogDetail.do?milNo=" + milNo + "';</script>");
			} else {
				out.print("<script>alert('댓글수정을 실패했습니다.'); location.href='blogDetail.do?milNo=" + milNo + "';</script>");
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
		File currentDirPath = new File("D:\\src\\teamwork\\mealkit\\WebContent\\images");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024 * 5); // 5GB
		factory.setDefaultCharset(encoding); // 파일올라올때 인코딩
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(request);
			for (int i = 0; i < items.size(); i++) {
				FileItem item = (FileItem) items.get(i);
				if(item.isFormField()) {
					System.out.println(item.getFieldName() + ":" + item.getString());
					recipeMap.put(item.getFieldName(), item.getString());
				} else {
					System.out.println("파라미터명: " + item.getFieldName());
					System.out.println("파일명: " + item.getName());
					System.out.println("파일의 크기: " + item.getSize());

					if(item.getSize() > 0) {
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
		} catch(Exception e) {
			e.printStackTrace();
		}
		return recipeMap;
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
