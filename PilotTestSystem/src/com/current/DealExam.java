package com.current;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.Bean.Exam;
import com.utils.DbUtil;
import com.utils.Page;
/**
 * 对题目进行处理
 * @author MLF
 *
 */
public class DealExam {
		private PreparedStatement ps=null;
		private Page page=new Page();
		/**
		 * 通过页码得到题目
		 * @param pg
		 * @return
		 */
		public List<Exam> GetExamByPage(int pg) {
		page.setCurPage(pg);
		List<Exam> exams=new ArrayList<>();
		String sql="select * from tb_exam  limit ?,?";
		try {
			ps= DbUtil.executePreparedStatement(sql);
			ps.setInt(1,(page.getCurPage()-1)*page.getPageSize());
			ps.setInt(2, page.getPageSize());
			 ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String type=rs.getString("type");
				String creator=rs.getString("creator");
				int duration=rs.getInt("duration");
				String examName=rs.getString("examName");
				Date examTime=rs.getDate("examTime");
				Exam exam=new Exam(id, examTime, examName, type, duration, creator);
				exams.add(exam);				
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exams;
	}
	
	/**
	 * 得到总的页码数
	 * @throws SQLException
	 */
	public int  setPage() throws SQLException{
			int i=0;
			String sql="select * from tb_exam";
			ResultSet rs=DbUtil.executeQuery(sql);
			while(rs.next()){
				i++;
			}
			rs.close();
		return	page.setPage(i);
	}
	
	/**
	 * 设置每页的显示的数量
	 */
	public void setPageSize(int i){
		page.setPageSize(i);
		
	}
	/**
	 * 设置当前页码
	 */
	public void setCurPage(int i){
		page.setCurPage(i);
		
	}
	/**
	 * 设置page
	 */
	public void setPage(Page p){
		this.page=p;
	}
	/**
	 * 得到Page
	 * @throws SQLException 
	 */
	public int getPage() throws SQLException{
		return setPage();
		
	}
	/**
	 * 返回当前的页码
	 * @return
	 */
	public int getCurPage(){
		return	page.getCurPage();
	}
	/**
	 * 返回每一页的题目数量
	 * @return
	 */
	public int getPageSize(){
		return  page.getPageSize();
	}
	/**
	 * 返回总的页码数
	 */
	public int getPageCount(){
		return page.getPageCount();
	}

}
