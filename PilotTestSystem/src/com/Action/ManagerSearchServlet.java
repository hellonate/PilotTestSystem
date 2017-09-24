package com.Action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.Chapter;
import com.Bean.Exam;
import com.Bean.Topic;
import com.Bean.User;
import com.current.DealUser;
import com.utils.Page;

import DaoImpl.ChapterDaoImpl;
import DaoImpl.ExamDaoImpl;
import DaoImpl.TopicDaoImpl;
import DaoImpl.UserDaoImpl;

/**
 * Servlet implementation class ManagerSearchServlet
 */
@WebServlet("/ManagerSearchServlet")
public class ManagerSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("param");
		String searchValue = request.getParameter("searchValue");
		searchValue = "%"+searchValue+"%";
		if(param.equals("user")){
			if(!searchValue.equals("")){
				try {
					ArrayList<User> list = new UserDaoImpl().getUserLikeName(searchValue);
					Page page=new Page(1,8,list.size(),list.size()/8);
					request.setAttribute("userlist",list);
					request.setAttribute("page", page);
					request.getRequestDispatcher("manager/addUser.jsp").forward(request, response);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else if (param.equals("exam")) {
			if(!searchValue.equals("")){
				try {
					ArrayList<Exam> list = new ExamDaoImpl().getExamLikeName(searchValue);
					Page page=new Page(1,8,list.size(),list.size()/8);
					request.setAttribute("examlist",list);
					request.setAttribute("page", page);
					request.getRequestDispatcher("manager/addTest.jsp").forward(request, response);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else if (param.equals("chapter")) {
			if(!searchValue.equals("")){
				try {
					ArrayList<Chapter> list = new ChapterDaoImpl().getChaptersLikeName(searchValue);
					
					request.setAttribute("chapters",list);
					request.getRequestDispatcher("manager/addChapter.jsp").forward(request, response);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else if (param.equals("topic")) {
			if(!searchValue.equals("")){
				try {
					ArrayList<Topic> list = new TopicDaoImpl().getTopicLikeQuestion(searchValue);
					Page page=new Page(1,8,list.size(),list.size()/8);
					request.setAttribute("userlist",list);
					request.setAttribute("page", page);
					request.getRequestDispatcher("manager/addQuestion.jsp").forward(request, response);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
