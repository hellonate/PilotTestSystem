package com.Action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.Exam;
import com.Bean.User;

import DaoImpl.ExamDaoImpl;
import DaoImpl.UserDaoImpl;

/**
 * Servlet implementation class DealTestServlet
 */
@WebServlet("/DealTestServlet")
public class DealTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String  param=request.getParameter("delete_exam_name");
		if(param != null){
			try {
				deleteTest(request, response, param);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		String name=request.getParameter("update_exam_name");
		if(name!=null){
			try {
				deliverTest(request, response, name);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String id=request.getParameter("identity");
		String password=request.getParameter("password");
		User user=new User(username, password, id);
		UserDaoImpl ud=new UserDaoImpl();
		try {
			ud.insertUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("manager/Insert_success.html");
	}
	/**
	 * É¾³ý¿¼ÊÔ
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void deleteTest(HttpServletRequest request, HttpServletResponse response,String name) throws SQLException, IOException{
		ExamDaoImpl ed=new ExamDaoImpl();
		ed.deleteExamByExamName(name);
		 response.sendRedirect("manager/Delete_success.html");
	}
	/**
	 * ´«µÝ¿¼ÊÔ
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void deliverTest(HttpServletRequest request, HttpServletResponse response,String  name) throws SQLException, ServletException, IOException{
		ExamDaoImpl ed=new ExamDaoImpl();
		Exam exam= ed.getExamByExamName(name).get(0);
		request.setAttribute("exam", exam);
		request.getRequestDispatcher("manager/UpdateTest.jsp").forward(request, response);
		
	}
}
