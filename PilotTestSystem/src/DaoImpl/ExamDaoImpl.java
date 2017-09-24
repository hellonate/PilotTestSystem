/**
*@auchor HPC
*
*/
package DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.Bean.Exam;
import com.utils.DbUtil;

public class ExamDaoImpl {

	/**
	 * 获取exam表中的所有信息
	 * @return 返回exam列表
	 * @throws SQLException
	 */
	public ArrayList<Exam> getAllInfo() throws SQLException{
		ArrayList<Exam> exams = new ArrayList<>();
		String sql = "select * from tb_exam";
		try{
			ResultSet rs = DbUtil.executeQuery(sql);
			
			int id,duration,choiceNum,choiceScore,judgeNum,judgeScore,blankNum,blankScore;
			String creator,type,examName,comment; 
			Date examTime;
			Exam exam;
			
			while(rs.next()){
				id = rs.getInt("id");
				duration = rs.getInt("duration");
				choiceNum = rs.getInt("choiceNum");
				choiceScore = rs.getInt("choiceScore");
				judgeNum = rs.getInt("judgeNum");
				judgeScore = rs.getInt("judgeScore");
				blankNum = rs.getInt("blankNum");
				blankScore = rs.getInt("blankScore");
				creator = rs.getString("creator");
				type = rs.getString("type");
				examName = rs.getString("examName");
				comment = rs.getString("comment");
				examTime = rs.getDate("examTime");
				
				exam = new Exam();
				exam.setId(id);
				exam.setDuration(duration);
				exam.setChoiceNum(choiceNum);
				exam.setChoiceScore(choiceScore);
				exam.setJudgeNum(judgeNum);
				exam.setJudgeScore(judgeScore);
				exam.setBlankNum(blankNum);
				exam.setBlankScore(blankScore);
				exam.setCreator(creator);
				exam.setType(type);
				exam.setExamName(examName);
				exam.setComment(comment);
				exam.setExamTime(examTime);
				
				exams.add(exam);
			}
			
			DbUtil.close();
			return exams;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	
	/**
	 * 通过creator获取exam列表
	 * @param creator
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Exam> getExamByCreator(String creator) throws SQLException{
		ArrayList<Exam> exams = new ArrayList<>();
		String sql = "select * from tb_exam where creator = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, creator);
			ResultSet rs = ps.executeQuery();
			
			int id,duration,choiceNum,choiceScore,judgeNum,judgeScore,blankNum,blankScore;
			String type,examName,comment; 
			Date examTime;
			Exam exam;
			
			while(rs.next()){
				id = rs.getInt("id");
				duration = rs.getInt("duration");
				choiceNum = rs.getInt("choiceNum");
				choiceScore = rs.getInt("choiceScore");
				judgeNum = rs.getInt("judgeNum");
				judgeScore = rs.getInt("judgeScore");
				blankNum = rs.getInt("blankNum");
				blankScore = rs.getInt("blankScore");
				creator = rs.getString("creator");
				type = rs.getString("type");
				examName = rs.getString("examName");
				comment = rs.getString("comment");
				examTime = rs.getDate("examTime");
				
				exam = new Exam();
				exam.setId(id);
				exam.setDuration(duration);
				///这里修改过
				exam.setChoiceNum(choiceNum);
				exam.setChoiceScore(choiceScore);
				exam.setJudgeNum(judgeNum);
				exam.setJudgeScore(judgeScore);
				exam.setBlankNum(blankNum);
				exam.setBlankScore(blankScore);
				exam.setCreator(creator);
				exam.setType(type);
				exam.setExamName(examName);
				exam.setComment(comment);
				exam.setExamTime(examTime);
				
				exams.add(exam);
			}
			DbUtil.close();
			return exams;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	
	public ArrayList<Exam> getExamLikeName(String examName) throws SQLException{
		ArrayList<Exam> exams = new ArrayList<>();
		String sql = "select * from tb_exam where examName like ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, examName);
			ResultSet rs = ps.executeQuery();
			
			int id,duration,choiceNum,choiceScore,judgeNum,judgeScore,blankNum,blankScore;
			String type,creator,comment; 
			Date examTime;
			Exam exam;
			
			while(rs.next()){
				id = rs.getInt("id");
				duration = rs.getInt("duration");
				choiceNum = rs.getInt("choiceNum");
				choiceScore = rs.getInt("choiceScore");
				judgeNum = rs.getInt("judgeNum");
				judgeScore = rs.getInt("judgeScore");
				blankNum = rs.getInt("blankNum");
				blankScore = rs.getInt("blankScore");
				creator = rs.getString("creator");
				type = rs.getString("type");
				examName = rs.getString("examName");
				comment = rs.getString("comment");
				examTime = rs.getDate("examTime");
				
				exam = new Exam();
				exam.setId(id);
				exam.setDuration(duration);
				///这里修改过
				exam.setChoiceNum(choiceNum);
				exam.setChoiceScore(choiceScore);
				exam.setJudgeNum(judgeNum);
				exam.setJudgeScore(judgeScore);
				exam.setBlankNum(blankNum);
				exam.setBlankScore(blankScore);
				exam.setCreator(creator);
				exam.setType(type);
				exam.setExamName(examName);
				exam.setComment(comment);
				exam.setExamTime(examTime);
				
				exams.add(exam);
			}
			DbUtil.close();
			return exams;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	
	public Exam getExamById(int id) throws SQLException{
		Exam exam = null;
		String sql = "select * from tb_exam where id = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			int duration,choiceNum,choiceScore,judgeNum,judgeScore,blankNum,blankScore;
			String type,examName,comment,creator; 
			Date examTime;
			
			while(rs.next()){
				id = rs.getInt("id");
				duration = rs.getInt("duration");
				choiceNum = rs.getInt("choiceNum");
				choiceScore = rs.getInt("choiceScore");
				judgeNum = rs.getInt("judgeNum");
				judgeScore = rs.getInt("judgeScore");
				blankNum = rs.getInt("blankNum");
				blankScore = rs.getInt("blankScore");
				creator = rs.getString("creator");
				type = rs.getString("type");
				examName = rs.getString("examName");
				comment = rs.getString("comment");
				examTime = rs.getDate("examTime");
				
				exam = new Exam();
				exam.setId(id);
				exam.setDuration(duration);
				///这里修改过
				exam.setChoiceNum(choiceNum);
				exam.setChoiceScore(choiceScore);
				exam.setJudgeNum(judgeNum);
				exam.setJudgeScore(judgeScore);
				exam.setBlankNum(blankNum);
				exam.setBlankScore(blankScore);
				exam.setCreator(creator);
				exam.setType(type);
				exam.setExamName(examName);
				exam.setComment(comment);
				exam.setExamTime(examTime);
				
				break;
			}
			DbUtil.close();
			return exam;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	
	public ArrayList<Exam> getExamByType(String type) throws SQLException{
		ArrayList<Exam> exams = new ArrayList<>();
		String sql = "select * from tb_exam where type = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			
			int id,duration,choiceNum,choiceScore,judgeNum,judgeScore,blankNum,blankScore;
			String creator,examName,comment; 
			Date examTime;
			Exam exam;
			
			while(rs.next()){
				id = rs.getInt("id");
				duration = rs.getInt("duration");
				choiceNum = rs.getInt("choiceNum");
				choiceScore = rs.getInt("choiceScore");
				judgeNum = rs.getInt("judgeNum");
				judgeScore = rs.getInt("judgeScore");
				blankNum = rs.getInt("blankNum");
				blankScore = rs.getInt("blankScore");
				creator = rs.getString("creator");
				type = rs.getString("type");
				examName = rs.getString("examName");
				comment = rs.getString("comment");
				examTime = rs.getDate("examTime");
				
				exam = new Exam();
				exam.setId(id);
				exam.setDuration(duration);
				///这里修改过
				exam.setChoiceNum(choiceNum);
				exam.setChoiceScore(choiceScore);
				exam.setJudgeNum(judgeNum);
				exam.setJudgeScore(judgeScore);
				exam.setBlankNum(blankNum);
				exam.setBlankScore(blankScore);
				exam.setCreator(creator);
				exam.setType(type);
				exam.setExamName(examName);
				exam.setComment(comment);
				exam.setExamTime(examTime);
				
				exams.add(exam);
			}
			DbUtil.close();
			return exams;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 通过examName获取exam列表
	 * @param examName 
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Exam> getExamByExamName(String examName) throws SQLException{
		ArrayList<Exam> exams = new ArrayList<>();
		String sql = "select * from tb_exam where examName = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, examName);
			ResultSet rs = ps.executeQuery();
			
			int id,duration,choiceNum,choiceScore,judgeNum,judgeScore,blankNum,blankScore;
			String type,creator,comment; 
			Date examTime;
			Exam exam;
			
			while(rs.next()){
				id = rs.getInt("id");
				duration = rs.getInt("duration");
				choiceNum = rs.getInt("choiceNum");
				choiceScore = rs.getInt("choiceScore");
				judgeNum = rs.getInt("judgeNum");
				judgeScore = rs.getInt("judgeScore");
				blankNum = rs.getInt("blankNum");
				blankScore = rs.getInt("blankScore");
				creator = rs.getString("creator");
				type = rs.getString("type");
				examName = rs.getString("examName");
				comment = rs.getString("comment");
				examTime = rs.getDate("examTime");
				
				exam = new Exam();
				exam.setId(id);
				exam.setDuration(duration);
				exam.setChoiceNum(choiceNum);
				exam.setChoiceScore(choiceScore);
				exam.setJudgeNum(judgeNum);
				exam.setJudgeScore(judgeScore);
				exam.setBlankNum(blankNum);
				exam.setBlankScore(blankScore);
				exam.setCreator(creator);
				exam.setType(type);
				exam.setExamName(examName);
				exam.setComment(comment);
				exam.setExamTime(examTime);
				
				exams.add(exam);
			}
			DbUtil.close();
			return exams;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	public int insertExam(Exam exam) throws SQLException{
		String sql = "insert into tb_exam (duration,choiceNum,choiceScore,judgeNum,judgeScore,"+
					"blankNum,blankScore,type,creator,comment,examName,examTime) "+
					"values (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, exam.getDuration());
			ps.setInt(2, exam.getChoiceNum());
			ps.setInt(3, exam.getChoiceScore());
			ps.setInt(4, exam.getJudgeNum());
			ps.setInt(5, exam.getJudgeScore());
			ps.setInt(6, exam.getBlankNum());
			ps.setInt(7, exam.getBlankScore());
			
			ps.setString(8, exam.getType());
			ps.setString(9, exam.getCreator());
			ps.setString(10, exam.getComment());
			ps.setString(11, exam.getExamName());
			
			ps.setDate(12, exam.getExamTime());
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 删除指定考试名的所有考试信息
	 * @param examName
	 * @return  影响的行数
	 * @throws SQLException
	 */
	public int deleteExamByExamName(String examName) throws SQLException{
		String sql = "delete from tb_exam where examName=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, examName);
			
			int i = ps.executeUpdate();
			ps.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * 删除某个创建者创建的所有考试信息
	 * @param creator
	 * @return  影响的行数
	 * @throws SQLException
	 */
	public int deleteExamByCreator(String creator) throws SQLException{
		String sql = "delete from tb_exam where creator=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, creator);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
}
