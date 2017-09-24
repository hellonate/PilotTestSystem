/**
*@auchor HPC
*
*/
package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Bean.Right;
import com.utils.DbUtil;

public class RightDaoImpl {

	/**
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Right> getAllInfo() throws SQLException{
		ArrayList<Right> objects = new ArrayList<>();
		String sql = "select * from tb_right";
		try{
			ResultSet rs = DbUtil.executeQuery(sql);
			
			int id,topicId,userId;
			Right object;
			
			while(rs.next()){
				id = rs.getInt("id");
				topicId = rs.getInt("topicId");
				userId = rs.getInt("userId");
				
				object = new Right();
				object.setId(id);
				object.setUserId(userId);
				object.setTopicId(topicId);
				
				objects.add(object);
			}
			
			DbUtil.close();
			return objects;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	
	/**
	 * @param topicId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Right> getRightByTopicId(int topicId) throws SQLException{
		ArrayList<Right> objects = new ArrayList<>();
		String sql = "select * from tb_right where topicId = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, topicId);
			ResultSet rs = ps.executeQuery();
			
			int id,userId;
			Right object;
			
			while(rs.next()){
				id = rs.getInt("id");
				topicId = rs.getInt("topicId");
				userId = rs.getInt("userId");
				
				object = new Right();
				object.setId(id);
				object.setUserId(userId);
				object.setTopicId(topicId);
				
				objects.add(object);
			}
			DbUtil.close();
			return objects;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	
	/**
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Right> getRightByUserId(int userId) throws SQLException{
		ArrayList<Right> objects = new ArrayList<>();
		String sql = "select * from tb_right where userId = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			int id,topicId;
			Right object;
			
			while(rs.next()){
				id = rs.getInt("id");
				topicId = rs.getInt("topicId");
				userId = rs.getInt("userId");
				
				object = new Right();
				object.setId(id);
				object.setUserId(userId);
				object.setTopicId(topicId);
				
				objects.add(object);
			}
			DbUtil.close();
			return objects;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 插入新的right信息
	 * @param right
	 * @return 影响的行数
	 * @throws SQLException
	 */
	public int insertRight(Right right) throws SQLException{
		String sql = "insert into tb_right (topicId,userId) values (?,?)";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, right.getTopicId());
			ps.setInt(2, right.getUserId());
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 删除指定用户的指定right信息
	 * @param userId
	 * @param topicId
	 * @return 影响的行数
	 * @throws SQLException
	 */
	public int deleteRightByUserIdAndTopicId(int userId,int topicId) throws SQLException{
		String sql = "delete from tb_right where topicId=? and userId=? ";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, topicId);
			ps.setInt(2, userId);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 删除指定用户的所有right信息
	 * @param userId
	 * @return 影响的行数
	 * @throws SQLException
	 */
	public int deleteRightByUserId(int userId) throws SQLException{
		String sql = "delete from tb_right where userId=? ";
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
	 * 删除指定题目的所有right信息
	 * @param topicId
	 * @return 影响的行数
	 * @throws SQLException
	 */
	public int deleteRightByTopicId(int topicId) throws SQLException{
		String sql = "delete from tb_right where topicId=?";
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
