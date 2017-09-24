package hpc.Action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;

import com.Bean.Topic;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import DaoImpl.TopicDaoImpl;
import excelUtil.ExcelReadUtil;
import excelUtil.SheetReadUtil;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServletConfig servletconfig;
	String path = "";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.servletconfig = config;
		this.path = getServletContext().getRealPath("/")+"upload";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//上传文件
		request.setCharacterEncoding("GBK");
		SmartUpload su = new SmartUpload();
		su.initialize(servletconfig,request,response);
		su.setMaxFileSize(100000);
		su.setTotalMaxFileSize(200000);
		try {
			su.setAllowedFilesList("xls,xlsx");
			su.setDeniedFilesList("exe,bat,jsp,htm,html");
		} catch (SQLException e) {
			//文件格式错误处理
			request.setAttribute("errorMessage", "选择文件格式错误");
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			return;
		}
		try {
			su.upload();
		} catch (SmartUploadException e) {
			request.setAttribute("errorMessage", "文件上传错误");
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			return;
		} catch (SecurityException e) {
			//文件格式错误处理
			request.setAttribute("errorMessage", "选择文件格式错误");
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			return;
		}
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			su.save(path);
		} catch (SmartUploadException e) {
			request.setAttribute("errorMessage", "文件上传错误");
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			request.setAttribute("errorMessage", "文件上传错误");
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			return;
		}
		
		//处理文件
		Files files = su.getFiles();
		com.jspsmart.upload.File uploadFile = files.getFile(0);
		if(uploadFile.isMissing()){
			//没有上传文件
			request.setAttribute("errorMessage", "没有选择上传文件");
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			return;
		}
		String fileName = uploadFile.getFileName();
		
		Request request2 = su.getRequest();
		boolean isCover = false;
		String cover = request2.getParameter("isCover");
		if(cover.equals("true")){
			isCover = true;
		}
		
		boolean success = addTopicsToDatabase(path+"\\"+fileName, isCover);
		if(success){//更新成功
			response.sendRedirect("manager/manager_mid.jsp");
			return;
		}else{//更新失败
			request.setAttribute("errorMessage", "数据库更新错误");
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			return;
		}
	}
	
	/**
	 * 添加题目到数据库
	 * @param filePath
	 * @param isCover 是否覆盖所有题目
	 * @return
	 */
	private boolean addTopicsToDatabase(String filePath,boolean isCover){
		ExcelReadUtil excelReadUtil = null;
		try {
			//System.out.println(filePath);
			excelReadUtil = new ExcelReadUtil(filePath);
			excelReadUtil.readFirstSheet();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		SheetReadUtil sheetReadUtil = new SheetReadUtil(excelReadUtil.getSheetList().get(0));
		sheetReadUtil.readAllRows();
		sheetReadUtil.setTitles(0, 0, 12);
		
		if(sheetReadUtil.getTitleColIndexByValue("optionA") == -1){
			return false;
		}
		int d = 1;
		if(sheetReadUtil.getTitleColIndexByValue("id") == -1){
			d = 0;
		}
		
		TopicDaoImpl topicDaoImpl = new TopicDaoImpl();
		if(isCover){
			try {
				topicDaoImpl.deleteAllTopics();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		ArrayList<Row> rows = sheetReadUtil.getRowList();
		Row row = null;
		Topic topic = new Topic();
		for(int i=1;i<rows.size();i++){
			row = rows.get(i);
			if(row!=null){
				if(SheetReadUtil.getCellValue(row.getCell(0+d)).equals("")){
					break;
				}
				topic.setQuestion(SheetReadUtil.getCellValue(row.getCell(0+d)));
				topic.setAnswer(SheetReadUtil.getCellValue(row.getCell(1+d)));
				topic.setType(SheetReadUtil.getCellValue(row.getCell(2+d)));
				topic.setScore(Integer.parseInt(SheetReadUtil.getCellValue(row.getCell(3+d))));
				topic.setChapterId(Integer.parseInt(SheetReadUtil.getCellValue(row.getCell(4+d))));
				topic.setChapterName(SheetReadUtil.getCellValue(row.getCell(5+d)));
				topic.setSectionName(SheetReadUtil.getCellValue(row.getCell(6+d)));
				topic.setOptionA(SheetReadUtil.getCellValue(row.getCell(7+d)));
				topic.setOptionB(SheetReadUtil.getCellValue(row.getCell(8+d)));
				topic.setOptionC(SheetReadUtil.getCellValue(row.getCell(9+d)));
				topic.setOptionD(SheetReadUtil.getCellValue(row.getCell(10+d)));
				try {
					topicDaoImpl.insertTopic(topic);
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		try {
			excelReadUtil.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
