package com.current;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.Bean.Topic;
import com.utils.DbUtil;
import com.utils.Page;
/**
 * ����Ŀ���д���
 * @author MLF
 *
 */
public class DealTpoic {
		private PreparedStatement ps=null;
		private Page page=new Page();
		/**
		 * ͨ��ҳ��õ���Ŀ
		 * @param pg
		 * @return
		 */
		public List<Topic> GetTopicByPage(int pg) {
		page.setCurPage(pg);
		List<Topic> topics=new ArrayList<>();
		String sql="select * from tb_topic  limit ?,?";
		try {
			ps= DbUtil.executePreparedStatement(sql);
			ps.setInt(1,(page.getCurPage()-1)*page.getPageSize());
			ps.setInt(2, page.getPageSize());
			 ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String  chaptername=rs.getString("chapterName");
				String	question=rs.getString("question");
				String 	type=rs.getString("type");
				String  answer=rs.getString("answer");
				Topic topic=new Topic(id,chaptername,question,type,answer);
				topics.add(topic);
			}
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topics;
	}
	
	/**
	 * �õ��ܵ�ҳ����
	 * @throws SQLException
	 */
	public int  setPage() throws SQLException{
			int i=0;
			String sql="select * from tb_topic";
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
