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
	 * ��ȡerror���е�������Ϣ
	 * @return ����error�б�
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
	 * ͨ��ָ��userId��ȡerror��Ϣ
	 * @param userId ָ��userId
	 * @return ����error�б�
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
	 * ͨ��topicId��ȡerror�б�
	 * @param topicId ָ��topicId 
	 * @return ����error�б�
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
	 * ��ѯĳ���û���ĳ������ľ���error��Ϣ
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
	 * �����µ�error��Ϣ
	 * @param error
	 * @return  Ӱ�������
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
	 * ����ĳ���û���ĳ��������Ŀ������Ϣ
	 * @param error
	 * @param userId
	 * @param topicId
	 * @return  Ӱ�������
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
	 * ɾ��ĳ���û���ĳ������Ĵ�����Ϣ
	 * @param userId
	 * @param topicId
	 * @return  Ӱ�������
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
	 * ɾ��ĳ���û������д�����Ϣ
	 * @param userId
	 * @return  Ӱ�������
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
	 * ɾ��ĳ����Ŀ�����г�����Ϣ
	 * @param topicId
	 * @return Ӱ�������
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
