package com.utils;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class WebPool {
	/**
	 * 声明JDBC相关对象
	 */
	protected static Statement s=null;
	protected static ResultSet rs = null;
	protected static Connection conn = null;
	
	public static Connection getConnection()
	{
		try
		{
			//Context是javax.name包中的一个接口，用于查找数据库连接池的配置文件
			Context ctx = new InitialContext();  
			ctx = (Context) ctx.lookup("java:comp/env");
             //dbpool为context.xml文件中<Resource>元素name属性值
			DataSource ds = (DataSource) ctx.lookup("DBpool");
			conn = ds.getConnection();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 执行INSERT/UPDATE/DELETE SQL语句
	 * @param sql SQL语句，字符串类型
	 * @return 执行结果，int类型
	 */
	public static int executeUpdate(String sql)
	{
		int result = 0;
		try {
			s = getConnection().createStatement();
			result = s.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 执行SELECT SQL语句
	 * @param sql SQL语句，字符串类型
	 * @return ResultSet结果集
	 */
		public static ResultSet executeQuery(String sql)
	{
		
		try {
			s = getConnection().createStatement();
			rs = s.executeQuery(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * 执行动态SQL语句
	 * @param sql 含有参数的动态SQL语句。 
	 * @return 返回PreparedStatement对象
	 */
	public static PreparedStatement executePreparedStatement(String sql)
	{
		PreparedStatement ps = null;
		try
		{
			ps = getConnection().prepareStatement(sql);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return ps;
	}
	
	/**
	 * 事务回滚
	 */
	public static void rollback() {
		try {
			getConnection().rollback();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	/**
	 * 关闭数据库连接对象
	 */
	public static void close()
	{
		try
		{
			if(rs!=null)
				rs.close();
			if(s!= null)
				s.close();
			if(conn!=null)
				conn.close();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}


}
