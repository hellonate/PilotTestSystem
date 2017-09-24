package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
	/**
	 * �������ݿ������Լ��˺�����
	 */
public static final String URL="jdbc:mysql://localhost:3306/pilot";
public static final String USER="root";
public static final String PASSWORD="root";
	/**
	 * ����JDBC����ض��� 
	 */
protected static Connection conn=null;
protected static Statement st=null;
protected static ResultSet rs=null;
/**
 * �������ݿ�����
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
 * ִ��INSERT/UPDATE/DELETE SQL���
 * @param sql SQL��䣬�ַ�������
 * @return ִ�н����int����
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
 * ִ��SELECT SQL���
 * @param sql SQL��䣬�ַ�������
 * @return ResultSet�����
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
 * ִ�ж�̬SQL���
 * @param sql ���в����Ķ�̬SQL��䡣 
 * @return ����PreparedStatement����
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
 * ����ع�
 */
public static void rollback() {
	try {
		getConnection().rollback();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}
/**
 * �ر����ݿ����Ӷ���
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
