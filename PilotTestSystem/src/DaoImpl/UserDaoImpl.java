/**
*@auchor HPC
*
*/
package DaoImpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Bean.User;
import com.utils.DbUtil;

public class UserDaoImpl {

	public ArrayList<User> getAllInfo() throws SQLException{
		ArrayList<User> objects = new ArrayList<>();
		String sql = "select * from tb_user";
		try{
			ResultSet rs = DbUtil.executeQuery(sql);
			
			int id,rightNum,finishNum,errorNum,examNum;
			String password,name,identity,type,question,answer,comment;
			Date registDate;
			User object;
			
			while(rs.next()){
				id = rs.getInt("id");
				rightNum = rs.getInt("rightNum");
				finishNum = rs.getInt("finishNum");
				errorNum = rs.getInt("errorNum");
				examNum = rs.getInt("examNum");
				
				question = rs.getString("question");
				password = rs.getString("password");
				name = rs.getString("name");
				answer = rs.getString("answer");
				type = rs.getString("type");
				identity = rs.getString("identity");
				comment = rs.getString("comment");
				
				registDate = rs.getDate("registDate");
				
				
				object = new User();
				object.setId(id);
				object.setAnswer(answer);
				object.setComment(comment);
				object.setErrorNum(errorNum);
				object.setExamNum(examNum);
				object.setFinishNum(finishNum);
				object.setIdentity(identity);
				object.setName(name);
				object.setPassword(password);
				object.setQuestion(question);
				object.setRegistDate(registDate);
				object.setRightNum(rightNum);
				object.setType(type);
				
				objects.add(object);
			}
			
			DbUtil.close();
			return objects;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	
	public ArrayList<User> getUserById(int id) throws SQLException{
		ArrayList<User> objects = new ArrayList<>();
		String sql = "select * from tb_user where id = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			int rightNum,finishNum,errorNum,examNum;
			String password,name,identity,type,question,answer,comment;
			Date registDate;
			User object;
			
			while(rs.next()){
				id = rs.getInt("id");
				rightNum = rs.getInt("rightNum");
				finishNum = rs.getInt("finishNum");
				errorNum = rs.getInt("errorNum");
				examNum = rs.getInt("examNum");
				
				question = rs.getString("question");
				password = rs.getString("password");
				name = rs.getString("name");
				answer = rs.getString("answer");
				type = rs.getString("type");
				identity = rs.getString("identity");
				comment = rs.getString("comment");
				
				registDate = rs.getDate("registDate");
				
				
				object = new User();
				object.setId(id);
				object.setAnswer(answer);
				object.setComment(comment);
				object.setErrorNum(errorNum);
				object.setExamNum(examNum);
				object.setFinishNum(finishNum);
				object.setIdentity(identity);
				object.setName(name);
				object.setPassword(password);
				object.setQuestion(question);
				object.setRegistDate(registDate);
				object.setRightNum(rightNum);
				object.setType(type);
				
				objects.add(object);
			}
			DbUtil.close();
			return objects;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	
	public ArrayList<User> getUserByName(String name) throws SQLException{
		ArrayList<User> objects = new ArrayList<>();
		String sql = "select * from tb_user where name = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			int id,rightNum,finishNum,errorNum,examNum;
			String password,identity,type,question,answer,comment;
			Date registDate;
			User object;
			
			while(rs.next()){
				id = rs.getInt("id");
				rightNum = rs.getInt("rightNum");
				finishNum = rs.getInt("finishNum");
				errorNum = rs.getInt("errorNum");
				examNum = rs.getInt("examNum");
				
				question = rs.getString("question");
				password = rs.getString("password");
				name = rs.getString("name");
				answer = rs.getString("answer");
				type = rs.getString("type");
				identity = rs.getString("identity");
				comment = rs.getString("comment");
				
				registDate = rs.getDate("registDate");
				
				
				object = new User();
				object.setId(id);
				object.setAnswer(answer);
				object.setComment(comment);
				object.setErrorNum(errorNum);
				object.setExamNum(examNum);
				object.setFinishNum(finishNum);
				object.setIdentity(identity);
				object.setName(name);
				object.setPassword(password);
				object.setQuestion(question);
				object.setRegistDate(registDate);
				object.setRightNum(rightNum);
				object.setType(type);
				
				objects.add(object);
			}
			DbUtil.close();
			return objects;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	public ArrayList<User> getUserLikeName(String name) throws SQLException{
		ArrayList<User> objects = new ArrayList<>();
		String sql = "select * from tb_user where name like ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			int id,rightNum,finishNum,errorNum,examNum;
			String password,identity,type,question,answer,comment;
			Date registDate;
			User object;
			
			while(rs.next()){
				id = rs.getInt("id");
				rightNum = rs.getInt("rightNum");
				finishNum = rs.getInt("finishNum");
				errorNum = rs.getInt("errorNum");
				examNum = rs.getInt("examNum");
				
				question = rs.getString("question");
				password = rs.getString("password");
				name = rs.getString("name");
				answer = rs.getString("answer");
				type = rs.getString("type");
				identity = rs.getString("identity");
				comment = rs.getString("comment");
				
				registDate = rs.getDate("registDate");
				
				
				object = new User();
				object.setId(id);
				object.setAnswer(answer);
				object.setComment(comment);
				object.setErrorNum(errorNum);
				object.setExamNum(examNum);
				object.setFinishNum(finishNum);
				object.setIdentity(identity);
				object.setName(name);
				object.setPassword(password);
				object.setQuestion(question);
				object.setRegistDate(registDate);
				object.setRightNum(rightNum);
				object.setType(type);
				
				objects.add(object);
			}
			DbUtil.close();
			return objects;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	public ArrayList<User> getUserByIdentity(String identity) throws SQLException{
		ArrayList<User> objects = new ArrayList<>();
		String sql = "select * from tb_user where identity = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, identity);
			ResultSet rs = ps.executeQuery();
			
			int id,rightNum,finishNum,errorNum,examNum;
			String password,name,type,question,answer,comment;
			Date registDate;
			User object;
			
			while(rs.next()){
				id = rs.getInt("id");
				rightNum = rs.getInt("rightNum");
				finishNum = rs.getInt("finishNum");
				errorNum = rs.getInt("errorNum");
				examNum = rs.getInt("examNum");
				
				question = rs.getString("question");
				password = rs.getString("password");
				name = rs.getString("name");
				answer = rs.getString("answer");
				type = rs.getString("type");
				identity = rs.getString("identity");
				comment = rs.getString("comment");
				
				registDate = rs.getDate("registDate");
				
				
				object = new User();
				object.setId(id);
				object.setAnswer(answer);
				object.setComment(comment);
				object.setErrorNum(errorNum);
				object.setExamNum(examNum);
				object.setFinishNum(finishNum);
				object.setIdentity(identity);
				object.setName(name);
				object.setPassword(password);
				object.setQuestion(question);
				object.setRegistDate(registDate);
				object.setRightNum(rightNum);
				object.setType(type);
				
				objects.add(object);
			}
			DbUtil.close();
			return objects;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * @param user
	 * @return 影响的行数
	 * @throws SQLException
	 */
	public int insertUser(User user) throws SQLException{
		String sql = "insert into tb_user (rightNum,finishNum,errorNum,examNum,"+
					"password,name,type,question,identity,answer,comment,registDate)"+
					" values (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, user.getRightNum());
			ps.setInt(2, user.getFinishNum());
			ps.setInt(3, user.getErrorNum());
			ps.setInt(4, user.getExamNum());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getName());
			ps.setString(7, user.getType());
			ps.setString(8, user.getQuestion());
			ps.setString(9, user.getIdentity());
			ps.setString(10, user.getAnswer());
			ps.setString(11, user.getComment());
			ps.setDate(12, user.getRegistDate());
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * @param user
	 * @param name
	 * @return 影响的行数
	 * @throws SQLException
	 */
	public int updateUserByName(User user,String name) throws SQLException{
		String sql = "update tb_user set rightNum=?,finishNum=?,errorNum=?,examNum=?,"+
					"password=?,name=?,type=?,question=?,identity=?,answer=?,comment=?,registDate=?"+
					" where name=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, user.getRightNum());
			ps.setInt(2, user.getFinishNum());
			ps.setInt(3, user.getErrorNum());
			ps.setInt(4, user.getExamNum());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getName());
			ps.setString(7, user.getType());
			ps.setString(8, user.getQuestion());
			ps.setString(9, user.getIdentity());
			ps.setString(10, user.getAnswer());
			ps.setString(11, user.getComment());
			ps.setDate(12, user.getRegistDate());
			
			ps.setString(13, name);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public int updateUserById(User user,int id) throws SQLException{
		String sql = "update tb_user set rightNum=?,finishNum=?,errorNum=?,examNum=?,"+
					"password=?,name=?,type=?,question=?,identity=?,answer=?,comment=?,registDate=?"+
					" where id=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, user.getRightNum());
			ps.setInt(2, user.getFinishNum());
			ps.setInt(3, user.getErrorNum());
			ps.setInt(4, user.getExamNum());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getName());
			ps.setString(7, user.getType());
			ps.setString(8, user.getQuestion());
			ps.setString(9, user.getIdentity());
			ps.setString(10, user.getAnswer());
			ps.setString(11, user.getComment());
			ps.setDate(12, user.getRegistDate());
			
			ps.setInt(13, id);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * @param name
	 * @return 影响的行数
	 * @throws SQLException
	 */
	public int deleteUserByName(String name) throws SQLException{
		String sql = "delete from tb_user where name=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			
			ps.setString(1, name);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
}
