package com.Action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.Chapter;
import com.Bean.Exam;
import com.Bean.Topic;
import com.Bean.User;
import com.Dao.UserDao;
import com.current.DealExam;
import com.current.DealTpoic;
import com.current.DealUser;
import com.utils.Page;
import DaoImpl.ChapterDaoImpl;
import DaoImpl.ExamDaoImpl;
import DaoImpl.TopicDaoImpl;
import DaoImpl.UserDaoImpl;
import dataUtil.ExamUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;Charset=utf-8");	
		//题目分页
		String page=request.getParameter("page");
		if(page!=null){
			try {
				int pg=Integer.parseInt(page);
				getTopicByPage(request, response,pg);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
		}
		//用户分页
		String user=request.getParameter("user");
		if(user!=null){
			try {
				int pg=Integer.parseInt(user);
				getUserByPage(request, response,pg);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
		}
		//考试分页
		String exam=request.getParameter("exam");
		if(exam!=null){
			try {
				int pg=Integer.parseInt(exam);
				getExamByPage(request, response,pg);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
		}
		//章节管理
		String param_=request.getParameter("param_");
		if(param_.equals("show_chapter")){
			try {
				getAllChapter( request,  response);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		
			
	}
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;Charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String param=request.getParameter("param_");
		if(param.equals("login")){
					String user=request.getParameter("username");
					String password=request.getParameter("password");
					String type =request.getParameter("user_type");
					//获取输入的验证码
					String  code=request.getParameter("check_num");
					String certCode=(String)request.getSession().getAttribute("certCode");
					//System.out.println("前端输入的code值为的"+code+"前端显示的验证码为:"+certCode);
					if(code.equals(certCode)){
						UserDao userDao=new UserDao();
						if (userDao.isLogin(user,password,type)) {
							HttpSession session=request.getSession();
							try {
								User s = new UserDaoImpl().getUserByName(user).get(0);
								session.setAttribute("user", user);
								session.setAttribute("userBean", s);
							} catch (SQLException e) {
								e.printStackTrace();
							}
							if(type.equals("user"))
								response.sendRedirect("user/user_all.jsp");
							else
								response.sendRedirect("manager/manager_all.jsp");
						}
						else{
							response.sendRedirect("index.html");
						}
					}
					else{
						response.sendRedirect("wrong.jsp");
					}
			
		}		
		if (param.equals("creatTest")){
			try {
				getExamTopic(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
	}

	/**
	 * 获取用户列表
	 * @param request
	 * @param response
	 */
	public void showList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;Charset=utf-8");	
		UserDaoImpl users=new UserDaoImpl();
		ArrayList<User> userlist= users.getAllInfo();
		request.setAttribute("userlist", userlist);
		request.getRequestDispatcher("manager/user_information.jsp").forward(request, response);
		
	}
	/**
	 * 获取管理员创建的考试
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void getTest(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		ExamDaoImpl EDI=new ExamDaoImpl();
		 ArrayList<Exam> aExams=EDI.getAllInfo();
		 request.setAttribute("aExams", aExams);
		 request.getRequestDispatcher("manager/addTest.jsp").forward(request, response);
	}
	/**
	 * 获取考试题目
	 * @param request
	 * @param response
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void getExamTopic(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException{
		String[] chapterNames=request.getParameterValues("chapterNames");
		String[] topicTypes=request.getParameterValues("type");
		int selectNums=Integer.parseInt(request.getParameter("questionNum"));
	/*	for(String s:chapterNames){
			System.out.println(s+",");
		}
		for(String s2:topicTypes){
			System.out.println(s2+",");
		}*/
		ExamUtil examUtil=new ExamUtil();
		//TODO
		ArrayList<Topic> topic= examUtil.createExamTopics(chapterNames, topicTypes, selectNums);
		/*Topic topic_1=dataUtil.getTopicInExamTopics(1);
		System.out.println(topic.getQuestion());
		System.out.println(topic.getOptionA());*/
		request.setAttribute("topic", topic);
		request.getRequestDispatcher("user/show_questions.jsp").forward(request, response);
	}
	/**
	 * 得到所有的题目
	 * @param request
	 * @param response
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
		public void getAllTopic(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
			TopicDaoImpl TDI=new TopicDaoImpl();
			ArrayList<Topic> topics=TDI.getAllInfo();
			request.setAttribute("Topics", topics);
			request.getRequestDispatcher("manager/addQuestion.jsp").forward(request, response);
			}
	/**
	 * 获取所有章节
	 * @param request
	 * @param response
	 */
	public void getAllChapter(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		ChapterDaoImpl CDI=new ChapterDaoImpl();
		ArrayList<Chapter> chapters= CDI.getAllInfo();
		request.setAttribute("chapters", chapters);
		request.getRequestDispatcher("manager/addChapter.jsp").forward(request, response);
	}
	/**
	 * 根据传来的页码得到试题，并传给前台
	 * @param request
	 * @param response
	 * @param pg
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void getTopicByPage(HttpServletRequest request, HttpServletResponse response,int pg) throws SQLException, ServletException, IOException{
		//初始化参数
		DealTpoic dt=new DealTpoic();
		//需要将后台数据库一共分了多少页的信息传递给前台
		//设置每一页显示的题目数量
		dt.setPageSize(8);
		//设置当前的页码数
		dt.setCurPage(pg);
		//得到页码的总数
		dt.setPage();
		//得到指定页码的题目列表
		dt.getPageCount();
		List<Topic> userlist=dt.GetTopicByPage(pg);
		request.setAttribute("userlist",userlist);
		Page page=new Page(dt.getCurPage(),dt.getPageSize(),dt.getPage(),dt.getPageCount());
		request.setAttribute("page", page);
		request.getRequestDispatcher("manager/addQuestion.jsp").forward(request, response);
	}
	/**
	 * 通过页面得到用户信息
	 * @param request
	 * @param response
	 * @param pg
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	
	public void getUserByPage(HttpServletRequest request, HttpServletResponse response,int pg) throws SQLException, ServletException, IOException{
		//初始化参数
		DealUser du=new DealUser();
		//需要将后台数据库一共分了多少页的信息传递给前台
		//设置每一页显示的题目数量
		du.setPageSize(8);
		//设置当前的页码数
		du.setCurPage(pg);
		//得到页码的总数
		du.setPage();
		//得到指定页码的题目列表
		//du.getPageCount();
	
		List<User> userlist=du.GetUserByPage(pg);
		request.setAttribute("userlist",userlist);
		Page page=new Page(du.getCurPage(),du.getPageSize(),du.getPage(),du.getPageCount());
		request.setAttribute("page", page);
		request.getRequestDispatcher("manager/addUser.jsp").forward(request, response);
	}
	/**
	 * 通过页面得到考试信息
	 * @param request
	 * @param response
	 * @param pg
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	
	public void getExamByPage(HttpServletRequest request, HttpServletResponse response,int pg) throws SQLException, ServletException, IOException{
		//初始化参数
		DealExam de=new DealExam();
		//需要将后台数据库一共分了多少页的信息传递给前台
		//设置每一页显示的题目数量
		de.setPageSize(8);
		//设置当前的页码数
		de.setCurPage(pg);
		//得到页码的总数
		de.setPage();
		//得到指定页码的题目列表
		de.getPageCount();
		List<Exam> examlist=de.GetExamByPage(pg);
		request.setAttribute("examlist",examlist);
		Page page=new Page(de.getCurPage(),de.getPageSize(),de.getPage(),de.getPageCount());
		request.setAttribute("page", page);
		request.getRequestDispatcher("manager/addTest.jsp").forward(request, response);
	}
}
	