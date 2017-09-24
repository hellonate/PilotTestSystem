package com.Action;

import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.Bean.User;

import DaoImpl.UserDaoImpl;

/**
 * Servlet implementation class DealServlet
 */
@WebServlet("/DealUserServlet")
public class DealUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String  param=request.getParameter("delete_user_name");
		if(param != null){
			try {
				deleteUser(request, response, param);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		System.out.println(id);
		String password=request.getParameter("password");
		String username=request.getParameter("username");
		String identity=request.getParameter("identity");
		//String type = request.getParameter("type");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
//		//TODO
//		//将日期从String转为Date格式
//		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//		Date registDate=null;
//		 try {
//			registDate=(Date)simpleDateFormat.parse(request.getParameter("registDate"));
//			//这里有问题
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
//		int rightNum=Integer.parseInt(request.getParameter("rightNum"));
//		int finishNum=Integer.parseInt(request.getParameter("finishNum"));
//		
//		int  errorNum=Integer.parseInt(request.getParameter("errorNum"));
//		int examNum=Integer.parseInt(request.getParameter("examNum"));
//		String comment=request.getParameter("comment");
//		
//		System.out.println(username+""+identity+""+password);
		String param=request.getParameter("param");
	//	System.out.println(param);
		//如果参数为update则更新
		if(param.equals("update")){
			try {
				int id_=Integer.parseInt(id);
				System.out.println(id);
				updateUser(request, response, id_, password, username, identity,question, answer);
				System.out.println("执行了updateuser方法");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(param.equals("insert")){
			try {
				
				insertUser(request, response, password, username, identity);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	/**
	 * 删除用户
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void deleteUser(HttpServletRequest request, HttpServletResponse response,String name) throws SQLException, IOException{
		UserDaoImpl ud=new UserDaoImpl();
		 ud.deleteUserByName(name);
		 response.sendRedirect("manager/Delete_success.html");
	}
	/**
	 * 更新(修改)用户
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void updateUser(HttpServletRequest request, HttpServletResponse response,int id,String password,String username,String identity,String question,String answer) throws SQLException, IOException{
		UserDaoImpl ud=new UserDaoImpl();
		//java.sql.Date sqlDate = new java.sql.Date(registDate.getTime());
//		User user=new User(id, password, username, identity, type, question, answer,
//				sqlDate, rightNum, finishNum, errorNum, examNum, comment);
		User user = new UserDaoImpl().getUserById(id).get(0);
		user.setName(username);
		user.setPassword(password);
		user.setIdentity(identity);
		user.setQuestion(question);
		user.setAnswer(answer);
		ud.updateUserByName(user, username);
		response.sendRedirect("manager/Update_success.html");
	}
	/**
	 * 插入新用户 w
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void insertUser(HttpServletRequest request, HttpServletResponse response,String password,String name,String identity) throws SQLException, IOException{
		User user=new User(name, password, identity);
		UserDaoImpl ud=new UserDaoImpl();
		ud.insertUser(user);
		response.sendRedirect("manager/Insert_success.html");
		
	}
}
