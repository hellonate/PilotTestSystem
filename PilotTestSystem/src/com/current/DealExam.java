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
 * ����Ŀ���д���
 * @author MLF
 *
 */
public class DealExam {
		private PreparedStatement ps=null;
		private Page page=new Page();
		/**
		 * ͨ��ҳ��õ���Ŀ
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
	 * �õ��ܵ�ҳ����
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
	 * ����ÿҳ����ʾ������
	 */
	public void setPageSize(int i){
		page.setPageSize(i);
		
	}
	/**
	 * ���õ�ǰҳ��
	 */
	public void setCurPage(int i){
		page.setCurPage(i);
		
	}
	/**
	 * ����page
	 */
	public void setPage(Page p){
		this.page=p;
	}
	/**
	 * �õ�Page
	 * @throws SQLException 
	 */
	public int getPage() throws SQLException{
		return setPage();
		
	}
	/**
	 * ���ص�ǰ��ҳ��
	 * @return
	 */
	public int getCurPage(){
		return	page.getCurPage();
	}
	/**
	 * ����ÿһҳ����Ŀ����
	 * @return
	 */
	public int getPageSize(){
		return  page.getPageSize();
	}
	/**
	 * �����ܵ�ҳ����
	 */
	public int getPageCount(){
		return page.getPageCount();
	}

}
