package com.Action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.Exam;
import com.Bean.Topic;
import com.Bean.User;
import com.current.DealExam;
import com.utils.Page;

import DaoImpl.ExamDaoImpl;
import dataUtil.ExamUtil;

/**
 * Servlet implementation class ManagerExamTestServlet
 */
@WebServlet("/ManagerExamTestServlet")
public class ManagerExamTestServlet extends HttpServlet {
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
		
		String param = request.getParameter("param");
		if(param.equals("create")){
			String[] chapterNames=request.getParameterValues("chapterNames");
			String[] topicTypes=request.getParameterValues("type");
			int selectNums=Integer.parseInt(request.getParameter("questionNum"));
			int duration = Integer.parseInt(request.getParameter("duration"));
		
			ExamUtil examUtil=new ExamUtil();
			ArrayList<Topic> topics = null;
			try {
				topics = examUtil.createExamTopics(chapterNames, topicTypes, selectNums);
			} catch (SQLException e) {
				e.printStackTrace();
				return;
			}
			
			int choiceNum = 0;
			int judgeNum = 0;
			String comment = "";
			for(Topic topic:topics){
				if(topic.getType().equals("choice")){
					choiceNum++;
					comment += topic.getId()+",";
				}else if (topic.getType().equals("judge")) {
					judgeNum++;
					comment += topic.getId()+",";
				}
			}
			
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
			String examTime = simpleDateFormat.format(date);
			Exam exam = new Exam();
			exam.setExamName("ͳһ����-"+examTime);
			//exam.setCreator(user.getName());
			exam.setCreator("hpc");
			exam.setComment(comment);
			exam.setDuration(duration);
			exam.setExamTime(new java.sql.Date(date.getTime()));
			exam.setType("ͳ��");
			exam.setBlankNum(0);
			exam.setBlankScore(0);
			exam.setChoiceNum(choiceNum);
			exam.setChoiceScore(0);
			exam.setJudgeNum(judgeNum);
			exam.setJudgeScore(0);
			
			try {
				new ExamDaoImpl().insertExam(exam);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		// ��ʼ������
		DealExam de = new DealExam();
		// ��Ҫ����̨���ݿ�һ�����˶���ҳ����Ϣ���ݸ�ǰ̨
		// ����ÿһҳ��ʾ����Ŀ����
		de.setPageSize(8);
		// ���õ�ǰ��ҳ����
		de.setCurPage(1);
		// �õ�ҳ�������
		try {
			de.setPage();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// �õ�ָ��ҳ�����Ŀ�б�
		de.getPageCount();
		List<Exam> examlist = de.GetExamByPage(1);
		request.setAttribute("examlist", examlist);
		Page page;
		try {
			page = new Page(de.getCurPage(), de.getPageSize(), de.getPage(), de.getPageCount());
			request.setAttribute("page", page);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("manager/addTest.jsp").forward(request, response);
	}

}
