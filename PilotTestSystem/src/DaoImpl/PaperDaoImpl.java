/**
*@auchor HPC
*
*/
package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Bean.Paper;
import com.utils.DbUtil;

public class PaperDaoImpl {

	/**
	 * ��ȡ�����Ծ���Ϣ
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Paper> getAllInfo() throws SQLException{
		ArrayList<Paper> papers = new ArrayList<>();
		String sql = "select * from tb_paper";
		try{
			ResultSet rs = DbUtil.executeQuery(sql);
			
			int id,examId,userId,topicId,score;
			String answer; 
			Paper paper;
			
			while(rs.next()){
				id = rs.getInt("id");
				examId = rs.getInt("examId");
				userId = rs.getInt("userId");
				topicId = rs.getInt("topicId");
				score = rs.getInt("score");
				answer = rs.getString("answer");
				
				paper = new Paper();
				paper.setId(id);
				paper.setExamId(examId);
				paper.setUserId(userId);
				paper.setTopicId(topicId);
				paper.setScore(score);
				paper.setAnswer(answer);
				
				papers.add(paper);
			}
			
			DbUtil.close();
			return papers;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	
	
	/**
	 * ͨ��examId��ȡ�Ծ���Ϣ
	 * @param examId
	 * @return
	 * @throws SQLException
	 */
	public Paper getPaperByExamId(int examId) throws SQLException{
		Paper paper = null;
		String sql = "select * from tb_paper where examId =?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, examId);
			ResultSet rs = ps.executeQuery();
			
			int id,userId,topicId,score;
			String answer; 
			
			while(rs.next()){
				id = rs.getInt("id");
				examId = rs.getInt("examId");
				userId = rs.getInt("userId");
				topicId = rs.getInt("topicId");
				score = rs.getInt("score");
				answer = rs.getString("answer");
				
				paper = new Paper();
				paper.setId(id);
				paper.setExamId(examId);
				paper.setUserId(userId);
				paper.setTopicId(topicId);
				paper.setScore(score);
				paper.setAnswer(answer);
				
				break;
			}
			DbUtil.close();
			return paper;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * ͨ��userId��ȡ�û������Ծ���Ϣ
	 * @param userId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Paper> getPaperByUserId(int userId) throws SQLException{
		ArrayList<Paper> papers = new ArrayList<>();
		String sql = "select * from tb_paper where userId =?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			int id,examId,topicId,score;
			String answer; 
			Paper paper;
			
			while(rs.next()){
				id = rs.getInt("id");
				examId = rs.getInt("examId");
				userId = rs.getInt("userId");
				topicId = rs.getInt("topicId");
				score = rs.getInt("score");
				answer = rs.getString("answer");
				
				paper = new Paper();
				paper.setId(id);
				paper.setExamId(examId);
				paper.setUserId(userId);
				paper.setTopicId(topicId);
				paper.setScore(score);
				paper.setAnswer(answer);
				
				papers.add(paper);
			}
			DbUtil.close();
			return papers;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * �����µ��Ծ���Ϣ
	 * @param paper
	 * @return  Ӱ�������
	 * @throws SQLException
	 */
	public int insertPaper(Paper paper) throws SQLException{
		String sql = "insert into tb_paper (examId,userId,topicId,score,answer) values (?,?,?,?,?)";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, paper.getExamId());
			ps.setInt(2, paper.getUserId());
			ps.setInt(3, paper.getTopicId());
			ps.setInt(4, paper.getScore());
			ps.setString(5, paper.getAnswer());
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * ͨ��examId�����Ծ���Ϣ
	 * @param paper
	 * @param examId
	 * @return  Ӱ�������
	 * @throws SQLException
	 */
	public int updatePaperByExamId(Paper paper,int examId) throws SQLException{
		String sql = "update tb_paper set examId=?,userId=?,topicId=?,score=?,answer=?"+
								" where examId=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, paper.getExamId());
			ps.setInt(2, paper.getUserId());
			ps.setInt(3, paper.getTopicId());
			ps.setInt(4, paper.getScore());
			ps.setString(5, paper.getAnswer());
			ps.setInt(6,examId);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * ɾ��ָ��examId���Ծ���Ϣ
	 * @param examId
	 * @return  Ӱ�������
	 * @throws SQLException
	 */
	public int deletePaperByExamId(int examId) throws SQLException{
		String sql = "delete from tb_paper where examId=?";
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
	
}
