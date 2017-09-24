package com.Dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.Bean.User;
import com.utils.DbUtil;
public class UserDao {
	Connection conn=null;
	Statement st=null;
	ResultSet rs=null;
	public List<User> getAll(){
		List<User> users=new ArrayList<>();
		String sql="select * from tb_user";
		rs=DbUtil.executeQuery(sql);
		try {
				while(rs.next()){
					int id=rs.getInt(1);
					String passw=rs.getString(2);
					String name=rs.getString(3);
					String identity=rs.getString(4);
					User user_=new User(id, passw, name,identity);
					users.add(user_);
				}
			} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	public boolean isLogin(String username_,String pass_,String type){
		String sql="select * from tb_user";
		try{
			rs=	DbUtil.executeQuery(sql);
			while(rs.next()){
				if(rs.getString("name").equals(username_))
					if(rs.getString("password").equals(pass_) && rs.getString("type").equals(type)){
						return true;
					}
				}
		
			}catch(Exception e){
			e.printStackTrace();
			}
		return false;
		}

}
