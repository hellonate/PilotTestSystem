package com.current;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.Bean.User;
import com.utils.DbUtil;
import com.utils.Page;

public class DealUser {
	private PreparedStatement ps=null;
	private Page page=new Page();
	/**
	 * ͨ�����ݵ�ҳ��ֵ(����˵��5ҳ)���ظ���ҳ�����Ŀ
	 * @param pg
	 * @return
	 * @throws SQLException
	 */
	public  List<User> GetUserByPage(int pg){
		page.setCurPage(pg);
		List<User> users=new ArrayList<>();
		String sql="select * from tb_user limit ?,?";
	     ps=DbUtil.executePreparedStatement(sql);
	     try {
	     ps.setInt(1, (page.getCurPage()-1)*page.getPageSize());
	     ps.setInt(2, page.getPageSize());
	     ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String password=rs.getString("password");
				String name=rs.getString("name");
				String type=rs.getString("type");
				String identity=rs.getString("identity");
				String question=rs.getString("question");
				String answer=rs.getString("answer");
				Date registDate=rs.getDate("registDate");
				int rightNum=rs.getInt("rightNum");
				int finishNum=rs.getInt("finishNum");
				int errorNum=rs.getInt("errorNum");
				int examNum=rs.getInt("examNum");
				String comment=rs.getString("comment");
				User user=new User(id,password, name,identity,type,question,answer,
				 registDate, rightNum, finishNum, errorNum, examNum, comment);
				users.add(user);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	/**
	 * �õ��ܵ�ҳ����
	 * @throws SQLException
	 */
	public int  setPage() throws SQLException{
			int i=0;
			String sql="select * from tb_user";
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
