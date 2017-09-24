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

import com.Bean.Exam;
import com.Bean.User;

import DaoImpl.ExamDaoImpl;
import DaoImpl.UserDaoImpl;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;Charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		//TODO
		//鐢ㄦ埛淇℃伅
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
		
		
		ExamDaoImpl examDaoImpl = new ExamDaoImpl();
		ArrayList<Exam> zikao = new ArrayList<>();
		try {
			zikao = examDaoImpl.getExamByCreator(user.getName());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		ArrayList<Exam> tongkao = new ArrayList<>();
		try {
			tongkao = examDaoImpl.getExamByType("统考");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("zikao", zikao);
		request.setAttribute("tongkao", tongkao);
		request.setAttribute("user", user);
		request.getRequestDispatcher("user/user_information.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
