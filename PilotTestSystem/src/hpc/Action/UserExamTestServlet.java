package hpc.Action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Bean.Error;
import com.Bean.Exam;
import com.Bean.Paper;
import com.Bean.Topic;
import com.Bean.User;

import DaoImpl.ErrorDaoImpl;
import DaoImpl.ExamDaoImpl;
import DaoImpl.PaperDaoImpl;
import DaoImpl.TopicDaoImpl;
import DaoImpl.UserDaoImpl;
import dataUtil.ExamUtil;

/**
 * Servlet implementation class UserExamTestServlet
 */
@WebServlet("/UserExamTestServlet")
public class UserExamTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    Exam exam = null;
    User user = null;
	ArrayList<Topic> topics = null;
	int currentIndex = 0;
	int choiceNum = 0,choiceScore = 0;
	int judgeNum = 0,judgeScore=0;
	int blankNum = 0,blankScore=0;
	
	boolean isJoin = false;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserExamTestServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		isJoin = true;
		
		// TODO
		 HttpSession session = request.getSession();
		 user = (User)session.getAttribute("userBean");

//		UserDaoImpl userDaoImpl = new UserDaoImpl();
//		try {
//			ArrayList<User> users = userDaoImpl.getUserByName("mlf");
//			user = users.get(0);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		String param = request.getParameter("param");
		initData();
		if(param.equals("join")){
			String examId = request.getParameter("examId");
			ExamDaoImpl examDaoImpl = new ExamDaoImpl();
			try {
				exam = examDaoImpl.getExamById(Integer.parseInt(examId));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			topics = new ArrayList<>();
			TopicDaoImpl topicDaoImpl = new TopicDaoImpl();
			String[] topicIds = exam.getComment().split(",");
			for(int i=0;i<topicIds.length;i++){
				try {
					topics.add(topicDaoImpl.getTopicById(Integer.parseInt(topicIds[i])));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			request.setAttribute("isLast", "false");
			request.setAttribute("num", (currentIndex+1));
			request.setAttribute("topic", topics.get(currentIndex));
			request.getRequestDispatcher("/user/user_showQuestions.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//TODO
		HttpSession session = request.getSession();
		user = (User)session.getAttribute("userBean");
		
//		UserDaoImpl userDaoImpl = new UserDaoImpl();
//		try {
//			ArrayList<User> users = userDaoImpl.getUserByName("mlf");
//			user = users.get(0);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		String isLast = "false";
		
		String param = request.getParameter("param");
		if(param.equals("create")){
			isJoin = false;
			String[] chapterNames=request.getParameterValues("chapterNames");
			String[] topicTypes=request.getParameterValues("type");
			int selectNums=Integer.parseInt(request.getParameter("questionNum"));
			int duration = Integer.parseInt(request.getParameter("duration"));
			initData();
			ExamUtil examUtil=new ExamUtil();
			try {
				topics = examUtil.createExamTopics(chapterNames, topicTypes, selectNums);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
			String examTime = simpleDateFormat.format(date);
			exam = new Exam();
			exam.setExamName("自主考试-"+examTime);
			exam.setCreator(user.getName());
			exam.setComment("内容");
			exam.setDuration(duration);
			exam.setExamTime(new java.sql.Date(date.getTime()));
			exam.setType("自考");
			if(topics.size() > 0)
				currentIndex = 0;
		}else if (param.equals("next")) {
			String value = request.getParameter("options");
			Topic topic = topics.get(currentIndex);
			isRight(topic, value);		
			currentIndex++;
			if(currentIndex == topics.size()-1){
				isLast = "true";
			}
		}else if (param.equals("submit")) {
			String value = request.getParameter("options");
			Topic topic = topics.get(currentIndex);
			isRight(topic, value);		
			commitExam();
			int result = choiceScore+judgeScore;
			request.setAttribute("resultScore", result);
			request.getRequestDispatcher("/user/user_result.jsp").forward(request, response);
			return;
		}
		request.setAttribute("isLast", isLast);
		request.setAttribute("num", (currentIndex+1));
		request.setAttribute("topic", topics.get(currentIndex));
		request.getRequestDispatcher("/user/user_showQuestions.jsp").forward(request, response);
	}
	
	
	private void commitExam(){
		exam.setBlankNum(blankNum);
		exam.setBlankScore(blankScore);
		exam.setChoiceNum(choiceNum);
		exam.setChoiceScore(choiceScore);
		exam.setJudgeNum(judgeNum);
		exam.setJudgeScore(judgeScore);
		
		user.setFinishNum(user.getFinishNum()+choiceNum+judgeNum+blankNum);
		user.setRightNum(user.getRightNum()+choiceScore+judgeScore+blankScore/2);
		user.setErrorNum(user.getErrorNum()+choiceNum-choiceScore
				+judgeNum-judgeScore+blankNum-blankScore/2);
		
		ExamDaoImpl examDaoImpl = new ExamDaoImpl();
		try {
			if(!isJoin){
				examDaoImpl.insertExam(exam);
			}
			new UserDaoImpl().updateUserById(user, user.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Paper paper = new Paper();
		try {
			paper.setExamId(examDaoImpl.getExamByExamName(exam.getExamName()).get(0).getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		paper.setUserId(user.getId());
		paper.setScore(blankScore+choiceScore+judgeScore);
		
		try {
			new PaperDaoImpl().insertPaper(paper);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void initData(){
		currentIndex = 0;
		choiceNum = 0;
		judgeNum = 0;
		blankNum = 0;
		choiceScore = 0;
		judgeScore = 0;
		blankScore = 0;
	}
	
	private void isRight(Topic topic,String value){
		if(topic.getType().equals("choice")){
			choiceNum++;
			if(topic.getAnswer().equals(value)){
				choiceScore += 1;
			}else{
				try {
					ArrayList<Error> errors = new ErrorDaoImpl()
							.getErrorByUserIdAndTopicId(user.getId(), topic.getId());
					Error error = new Error();
					if(errors.size() == 0){
						error.setUserId(user.getId());
						error.setContinueSelect("Y");
						error.setErrorCount(1);
						error.setTopicId(topic.getId());
						new ErrorDaoImpl().insertError(error);
					}else{
						error = errors.get(0);
						error.setErrorCount(error.getErrorCount()+1);
						new ErrorDaoImpl().updateErrorByUserIdAndTopicId(error, user.getId(), topic.getId());
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}else if (topic.getType().equals("judge")) {
			judgeNum++;
			if(topic.getAnswer().equals(value)){
				judgeScore += 1;
			}else{
				try {
					ArrayList<Error> errors = new ErrorDaoImpl()
							.getErrorByUserIdAndTopicId(user.getId(), topic.getId());
					Error error = new Error();
					if(errors.size() == 0){
						error.setUserId(user.getId());
						error.setContinueSelect("Y");
						error.setErrorCount(1);
						error.setTopicId(topic.getId());
						new ErrorDaoImpl().insertError(error);
					}else{
						error = errors.get(0);
						error.setErrorCount(error.getErrorCount()+1);
						new ErrorDaoImpl().updateErrorByUserIdAndTopicId(error, user.getId(), topic.getId());
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	

}
