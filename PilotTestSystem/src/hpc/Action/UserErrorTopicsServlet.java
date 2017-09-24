package hpc.Action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.Chapter;
import com.Bean.Topic;
import com.Bean.User;

import DaoImpl.ChapterDaoImpl;
import DaoImpl.ErrorDaoImpl;
import DaoImpl.UserDaoImpl;
import dataUtil.ErrorUtil;

/**
 * Servlet implementation class UserErrorTopicsServlet
 */
@WebServlet("/UserErrorTopicsServlet")
public class UserErrorTopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;Charset=utf-8");
		
	
		//TODO
		// 用户信息
		 HttpSession session = request.getSession();
		 User user = (User)session.getAttribute("userBean");
//		UserDaoImpl userDaoImpl = new UserDaoImpl();
//		User user = null;
//		try {
//			ArrayList<User> users = userDaoImpl.getUserByName("mlf");
//			user = users.get(0);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		String target = "";
		String param = request.getParameter("param");
		if(param.equals("chapter")){
			ArrayList<Chapter> chapters = new ArrayList<>();
			try {
				chapters = new ChapterDaoImpl().getAllInfo();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("chapters", chapters);
			target = "user/user_error.jsp";
		}else if (param.equals("detail")) {
			String chapter = request.getParameter("chapter");
			ArrayList<Topic> errorTopics = new ArrayList<>();
			try {
				errorTopics = 
						new ErrorUtil().getErrorTopicsByUserIdAndChapterName(user.getId(), chapter);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("chapterName", chapter);
			request.setAttribute("errorTopics", errorTopics);
			target = "user/user_errorDetail.jsp";
		}else if (param.equals("deleteChapter")) {
			String chapterName = request.getParameter("chapter");
			ArrayList<Topic> errorTopics = new ArrayList<>();
			try {
				errorTopics = 
						new ErrorUtil().getErrorTopicsByUserIdAndChapterName(user.getId(), chapterName);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for(Topic topic:errorTopics){
				try {
					int i = new ErrorDaoImpl().deleteErrorByTopicId(topic.getId());
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			ArrayList<Chapter> chapters = new ArrayList<>();
			try {
				chapters = new ChapterDaoImpl().getAllInfo();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("chapters", chapters);
			target = "user/user_error.jsp";
		}
		
		request.setAttribute("user", user);
		request.getRequestDispatcher(target).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
