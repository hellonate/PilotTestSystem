package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
	/**
	 * 声明数据库链接以及账号密码
	 */
public static final String URL="jdbc:mysql://localhost:3306/pilot";
public static final String USER="root";
public static final String PASSWORD="root";
	/**
	 * 声明JDBC的相关对象 
	 */
protected static Connection conn=null;
protected static Statement st=null;
protected static ResultSet rs=null;
/**
 * 创建数据库连接
 * @return conn
 */
public static synchronized Connection getConnection()
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(URL, USER, PASSWORD);
	} catch (Exception e) {
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
		st = getConnection().createStatement();
		result = st.executeUpdate(sql);
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
		st = getConnection().createStatement();
		rs = st.executeQuery(sql);
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
		if(st!= null)
			st.close();
		if(conn!=null)
			conn.close();
		
	}catch(SQLException e)
	{
		e.printStackTrace();
	}
}

}
