/**
*@auchor HPC
*
*/
package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Bean.Range;
import com.utils.DbUtil;

public class RangeDaoImpl {
	
	/**
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Range> getAllInfo() throws SQLException{
		ArrayList<Range> objects = new ArrayList<>();
		String sql = "select * from tb_range";
		try{
			ResultSet rs = DbUtil.executeQuery(sql);
			
			int id,examId,userId,totalScore;
			String chapterId; 
			Range object;
			
			while(rs.next()){
				id = rs.getInt("id");
				examId = rs.getInt("examId");
				userId = rs.getInt("userId");
				totalScore = rs.getInt("totalScore");
				chapterId = rs.getString("chapterId");
				
				object = new Range();
				object.setId(id);
				object.setChapterId(chapterId);
				object.setExamId(examId);
				object.setTotalScore(totalScore);
				object.setUserId(userId);
				
				objects.add(object);
			}
		
			DbUtil.close();
			return objects;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	
	/**
	 * @param examId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Range> getRangeByExamId(int examId) throws SQLException{
		ArrayList<Range> objects = new ArrayList<>();
		String sql = "select * from tb_range where examId = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, examId);
			ResultSet rs = ps.executeQuery();
			
			int id,userId,totalScore;
			String chapterId; 
			Range object;
			
			while(rs.next()){
				id = rs.getInt("id");
				examId = rs.getInt("examId");
				userId = rs.getInt("userId");
				totalScore = rs.getInt("totalScore");
				chapterId = rs.getString("chapterId");
				
				object = new Range();
				object.setId(id);
				object.setChapterId(chapterId);
				object.setExamId(examId);
				object.setTotalScore(totalScore);
				object.setUserId(userId);
				
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
	public ArrayList<Range> getRangeByUserId(int userId) throws SQLException{
		ArrayList<Range> objects = new ArrayList<>();
		String sql = "select * from tb_range where userId = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			int id,examId,totalScore;
			String chapterId; 
			Range object;
			
			while(rs.next()){
				id = rs.getInt("id");
				examId = rs.getInt("examId");
				userId = rs.getInt("userId");
				totalScore = rs.getInt("totalScore");
				chapterId = rs.getString("chapterId");
				
				object = new Range();
				object.setId(id);
				object.setChapterId(chapterId);
				object.setExamId(examId);
				object.setTotalScore(totalScore);
				object.setUserId(userId);
				
				objects.add(object);
			}
			DbUtil.close();
			return objects;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 插入新的range信息
	 * @param range
	 * @return  影响的行数
	 * @throws SQLException
	 */
	public int insertRange(Range range) throws SQLException{
		String sql = "insert into tb_range (examId,userId,totalScore,chapterId) values (?,?,?,?)";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, range.getExamId());
			ps.setInt(2, range.getUserId());
			ps.setInt(3, range.getTotalScore());
			ps.setString(4, range.getChapterId());
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 通过指定examId更新range信息
	 * @param range
	 * @param examId
	 * @return  影响的行数
	 * @throws SQLException
	 */
	public int updateRangeByExamId(Range range,int examId) throws SQLException{
		String sql = "update tb_range set examId=?,userId=?,totalScore=?,chapterId=?"+
								" where examId=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, range.getExamId());
			ps.setInt(2, range.getUserId());
			ps.setInt(3, range.getTotalScore());
			ps.setString(4, range.getChapterId());
			ps.setInt(5, examId);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 删除指定examId的range信息
	 * @param examId
	 * @return  影响的行数
	 * @throws SQLException
	 */
	public int deleteRangeByExamId(int examId) throws SQLException{
		String sql = "delete from tb_range where examId=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, examId);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 删除指定用户的range信息
	 * @param userId
	 * @return  影响的行数
	 * @throws SQLException
	 */
	public int deleteRangeByUserId(int userId) throws SQLException{
		String sql = "delete from tb_range where userId=?";
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

}
