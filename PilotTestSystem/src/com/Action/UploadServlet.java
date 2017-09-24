package com.Action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		SmartUpload su=new SmartUpload();
		su.initialize(config, request, response);
		su.setMaxFileSize(100000);
		su.setTotalMaxFileSize(200000);
		su.setAllowedFilesList("text,doc");
		try {
			su.setDeniedFilesList("exe,bat,html,htm,jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			su.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		try {
			int count=su.save("/Demo12-5/WebContent/upload");
		} catch (SmartUploadException e){
			e.printStackTrace();
		}
	
	}

}
