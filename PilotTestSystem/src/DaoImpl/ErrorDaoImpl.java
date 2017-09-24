/**
*@auchor HPC
*
*/
package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Bean.Error;
import com.utils.DbUtil;

public class ErrorDaoImpl {

	
	/**
	 * 获取error表中的所有信息
	 * @return 返回error列表
	 * @throws SQLException
	 */
	public ArrayList<Error> getAllInfo() throws SQLException{
		ArrayList<Error> errors = new ArrayList<>();
		String sql = "select * from tb_error";
		try{
			ResultSet rs = DbUtil.executeQuery(sql);
			int id,topicId,errorCount,userId;
			String continueSelect; 
			Error error;
			while(rs.next()){
				id = rs.getInt("id");
				topicId = rs.getInt("topicId");
				errorCount = rs.getInt("errorCount");
				userId = rs.getInt("userId");
				continueSelect = rs.getString("continueSelect");
				
				error = new Error();
				error.setId(id);
				error.setContinueSelect(continueSelect);
				error.setErrorCount(errorCount);
				error.setTopicId(topicId);
				error.setUserId(userId);
				
				errors.add(error);
			}
			DbUtil.close();
			return errors;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 通过指定userId获取error信息
	 * @param userId 指定userId
	 * @return 返回error列表
	 * @throws SQLException
	 */
	public ArrayList<Error> getErrorByUserId(int userId) throws SQLException{
		ArrayList<Error> errors = new ArrayList<>();
		String sql = "select * from tb_error where userId = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			int id,topicId,errorCount;
			String continueSelect; 
			Error error;
			while(rs.next()){
				id = rs.getInt("id");
				topicId = rs.getInt("topicId");
				errorCount = rs.getInt("errorCount");
				userId = rs.getInt("userId");
				continueSelect = rs.getString("continueSelect");
				
				error = new Error();
				error.setId(id);
				error.setContinueSelect(continueSelect);
				error.setErrorCount(errorCount);
				error.setTopicId(topicId);
				error.setUserId(userId);
				
				errors.add(error);
			}
			DbUtil.close();
			return errors;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 通过topicId获取error列表
	 * @param topicId 指定topicId 
	 * @return 返回error列表
	 * @throws SQLException
	 */
	public ArrayList<Error> getErrorByTopicId(int topicId) throws SQLException{
		ArrayList<Error> errors = new ArrayList<>();
		String sql = "select * from tb_error where topicId = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, topicId);
			ResultSet rs = ps.executeQuery();
			int id,userId,errorCount;
			String continueSelect; 
			Error error;
			while(rs.next()){
				id = rs.getInt("id");
				topicId = rs.getInt("topicId");
				errorCount = rs.getInt("errorCount");
				userId = rs.getInt("userId");
				continueSelect = rs.getString("continueSelect");
				
				error = new Error();
				error.setId(id);
				error.setContinueSelect(continueSelect);
				error.setErrorCount(errorCount);
				error.setTopicId(topicId);
				error.setUserId(userId);
				
				errors.add(error);
			}
			DbUtil.close();
			return errors;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 查询某个用户的某个错题的具体error信息
	 * @param userId
	 * @param topicId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Error> getErrorByUserIdAndTopicId(int userId, int topicId) throws SQLException{
		ArrayList<Error> errors = new ArrayList<>();
		String sql = "select * from tb_error where topicId = ? and userId=?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(2, userId);
			ps.setInt(1, topicId);
			ResultSet rs = ps.executeQuery();
			int id,errorCount;
			String continueSelect; 
			Error error;
			while(rs.next()){
				id = rs.getInt("id");
				topicId = rs.getInt("topicId");
				errorCount = rs.getInt("errorCount");
				userId = rs.getInt("userId");
				continueSelect = rs.getString("continueSelect");
				
				error = new Error();
				error.setId(id);
				error.setContinueSelect(continueSelect);
				error.setErrorCount(errorCount);
				error.setTopicId(topicId);
				error.setUserId(userId);
				
				errors.add(error);
			}
			DbUtil.close();
			return errors;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 插入新的error信息
	 * @param error
	 * @return  影响的行数
	 * @throws SQLException
	 */
	public int insertError(Error error) throws SQLException{
		String sql = "insert into tb_error (topicId,errorCount,userId,continueSelect) values (?,?,?,?)";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, error.getTopicId());
			ps.setInt(2, error.getErrorCount());
			ps.setInt(3, error.getUserId());
			ps.setString(4, error.getContinueSelect());
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	
	
	/**
	 * 更新某个用户的某个错误题目具体信息
	 * @param error
	 * @param userId
	 * @param topicId
	 * @return  影响的行数
	 * @throws SQLException
	 */
	public int updateErrorByUserIdAndTopicId(Error error,int userId,int topicId) throws SQLException{
		String sql = "update tb_error set topicId=?,errorCount=?,userId=?,continueSelect=?"+
								" where userId=? and topicId=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, error.getTopicId());
			ps.setInt(2, error.getErrorCount());
			ps.setInt(3, error.getUserId());
			ps.setString(4, error.getContinueSelect());
			ps.setInt(5, userId);
			ps.setInt(6, topicId);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 删除某个用户的某个具体的错误信息
	 * @param userId
	 * @param topicId
	 * @return  影响的行数
	 * @throws SQLException
	 */
	public int deleteErrorByUserIdAndTopicId(int userId,int topicId) throws SQLException{
		String sql = "delete from tb_error where userId=? and topicId=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, topicId);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 删除某个用户的所有错题信息
	 * @param userId
	 * @return  影响的行数
	 * @throws SQLException
	 */
	public int deleteErrorByUserId(int userId) throws SQLException{
		String sql = "delete from tb_error where userId=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, userId);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 删除某个题目的所有出错信息
	 * @param topicId
	 * @return 影响的行数
	 * @throws SQLException
	 */
	public int deleteErrorByTopicId(int topicId) throws SQLException{
		String sql = "delete from tb_error where topicId=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, topicId);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	
}
