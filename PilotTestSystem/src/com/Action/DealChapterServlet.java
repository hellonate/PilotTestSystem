package com.Action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.Chapter;
import com.Bean.User;

import DaoImpl.ChapterDaoImpl;
import DaoImpl.UserDaoImpl;

/**
 * Servlet implementation class DealChapterServlet
 */
@WebServlet("/DealChapterServlet")
public class DealChapterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealChapterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String  param=request.getParameter("delete_chapter_name");
		if(param != null){
			try {
				deleteChapter(request, response, param);
				return;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
      	int	id=(Integer.parseInt(request.getParameter("update_chapter_id")));
      	System.out.println(id);
		if(id>=0){
			//将要更新的用户的信息传递到前台
			try {
				updateChapter(request, response, id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从前台提交的form表单的请求
		String param=request.getParameter("param");
		
		String chapterName=request.getParameter("chapterName");
		String chapterIntro=request.getParameter("chapterIntro");
		if(param.equals("insert")){
			insertChapter(request, response, 0, chapterName, chapterIntro);
			return;
		}
		if(param.equals("update")){
			int chapterIndex=(Integer.parseInt(request.getParameter("chapterIndex")));
			try {
				changeChapter(request, response, chapterIndex, chapterName, chapterIntro);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		
	}
	/**
	 * 删除章节
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void deleteChapter(HttpServletRequest request, HttpServletResponse response,String name) throws SQLException, IOException{
		ChapterDaoImpl cd=new ChapterDaoImpl();
		cd.deleteChapterByName(name);
		 response.sendRedirect("manager/Delete_success.html");
	
	}
	/**
	 * 添加章节
	 * @throws IOException 
	 */
	public void insertChapter(HttpServletRequest request, HttpServletResponse response,int chapterIndex,String chapterName,String chapterIntro) throws IOException{
		Chapter chapter=new Chapter(chapterIndex, chapterName, chapterIntro);
		ChapterDaoImpl cd=new ChapterDaoImpl();
		try {
			cd.insertChapter(chapter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("manager/Insert_success.html");
	}
	/**
	 * 传递章节(并不修改，真正修改交给changerChapter()方法来执行.)
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void updateChapter(HttpServletRequest request, HttpServletResponse response,int id) throws SQLException, ServletException, IOException{
		ChapterDaoImpl cd=new ChapterDaoImpl();
		Chapter chapter=cd.getChapterById(id);
		request.setAttribute("chapter", chapter);
		request.getRequestDispatcher("manager/UpdateChapter.jsp").forward(request, response);
		
	}
	/**
	 * 改变章节内容
	 * @param request
	 * @param response
	 * @param chapterIndex
	 * @param chapterName
	 * @param chapterIntro
	 * @throws SQLException
	 * @throws IOException 
	 */
	public void changeChapter(HttpServletRequest request, HttpServletResponse response,int chapterIndex,String chapterName,String chapterIntro) throws SQLException, IOException{
		ChapterDaoImpl cd=new ChapterDaoImpl();
	     Chapter chapter=cd.getChapterById(chapterIndex);
	     chapter.setName(chapterName);
	     chapter.setComment(chapterIntro);
	     cd.updateChapterById(chapter, chapterIndex);
	     response.sendRedirect("manager/Update_success.html");
	}
}