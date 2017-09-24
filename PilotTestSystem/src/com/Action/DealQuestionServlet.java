package com.Action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.Bean.Topic;
import com.Bean.User;

import DaoImpl.TopicDaoImpl;
import DaoImpl.UserDaoImpl;

/**
 * Servlet implementation class DealQuestonServlet
 */
@WebServlet("/DealQuestionServlet")
public class DealQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String param = request.getParameter("delete_question_id");
		if(param != null){
			int  id = Integer.parseInt(param);
			if(id>=0){
				try {
					deleteQuestion(request, response, id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return;
			}
		}
		param = request.getParameter("update_question_id");
		if(param != null){
			int update_question_id =Integer.parseInt(param);
			//更新用户
			if(update_question_id>=0){
				try {
					getQuestion(request, response, update_question_id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		String type=request.getParameter("type");
		int score=Integer.parseInt(request.getParameter("score"));
		int  chapterId=Integer.parseInt(request.getParameter("chapterId"));
		String chapterName=request.getParameter("chapterName");
		String sectionName=request.getParameter("sectionName");
		String optionA=request.getParameter("optionA");
		String optionB=request.getParameter("optionB");
		String optionC=request.getParameter("optionC");
		String optionD=request.getParameter("optionD");
		String param=request.getParameter("param");
		if(param.equals("insert")){
			insertQuestion(request, response, 0, question, answer, type, score, chapterId, chapterName, sectionName, optionA, optionB, optionC, optionD);
		}
		if(param.equals("update")){
			int id=Integer.parseInt(request.getParameter("id"));
			try {
				updateQuestion(request, response, id, question, answer, type, score, chapterId, chapterName, sectionName, optionA, optionB, optionC, optionD);
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
	public void deleteQuestion(HttpServletRequest request, HttpServletResponse response,int id) throws SQLException, IOException{
		TopicDaoImpl td=new TopicDaoImpl();
		td.deleteTopicById(id);
		 response.sendRedirect("manager/Delete_success.html");
	
	}
	/**
	 * 并不更新用户，只是将获取的信息封装好传递给前台显示
	 * @param request
	 * @param response
	 * @param id
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void getQuestion(HttpServletRequest request, HttpServletResponse response,int id) throws SQLException, ServletException, IOException{
		TopicDaoImpl td=new TopicDaoImpl();
		Topic topic=td.getTopicById(id);
		request.setAttribute("topic", topic);
		request.getRequestDispatcher("manager/UpdateQuestion.jsp").forward(request, response);
	}
	/**
	 * 插入用户
	 * @throws IOException 
	 */
	public void insertQuestion(HttpServletRequest request, HttpServletResponse response,int id,String question,String answer,String type,int score,int chapterId,String chapterName,String sectionName,String optionA,String optionB,String optionC,String optionD) throws IOException{
		Topic topic=new Topic(id,question,answer,type,score,chapterId,chapterName, sectionName,optionA,optionB,optionC,optionD);
		TopicDaoImpl td=new TopicDaoImpl();
		try {
			td.insertTopic(topic);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("manager/Insert_success.html");
		
	}
	/**
	 * 更新用户
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public void updateQuestion(HttpServletRequest request, HttpServletResponse response,int id,String question,String answer,String type,int score,int chapterId,String chapterName,String sectionName,String optionA,String optionB,String optionC,String optionD) throws SQLException, IOException{
		TopicDaoImpl td=new TopicDaoImpl();
		Topic topic=td.getTopicById(id);
		topic.setQuestion(question);
		topic.setAnswer(answer);
		topic.setType(type);
		topic.setScore(score);
		topic.setChapterId(chapterId);
		topic.setChapterName(chapterName);
		topic.setSectionName(sectionName);
		topic.setOptionA(optionA);
		topic.setOptionB(optionB);
		topic.setOptionC(optionC);
		topic.setOptionD(optionD);
		td.updateTopicById(topic, id);
		response.sendRedirect("manager/Update_success.html");
		
	}
	
}
