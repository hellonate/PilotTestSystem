/**
*@auchor HPC
*
*/
package DaoImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.Bean.Topic;
import com.utils.DbUtil;
public class TopicDaoImpl {

	/**
	 * ��ȡ��Ŀ��Ϣ
	 * @return ����������Ϣ
	 * @throws SQLException
	 */
	public ArrayList<Topic> getAllInfo() throws SQLException{
		ArrayList<Topic> objects = new ArrayList<>();
		String sql = "select * from tb_topic";
		try{
			ResultSet rs = DbUtil.executeQuery(sql);
			
			int id,score,chapterId;
			String question,answer,type,chapterName,sectionName,optionA,optionB,optionC,optionD;
			Topic object;
			
			while(rs.next()){
				id = rs.getInt("id");
				score = rs.getInt("score");
				chapterId = rs.getInt("chapterId");
				
				question = rs.getString("question");
				chapterName = rs.getString("chapterName");
				sectionName = rs.getString("sectionName");
				answer = rs.getString("answer");
				type = rs.getString("type");
				optionA = rs.getString("optionA");
				optionB = rs.getString("optionB");
				optionC = rs.getString("optionC");
				optionD = rs.getString("optionD");
				
				object = new Topic();
				object.setId(id);
				object.setAnswer(answer);
				object.setChapterId(chapterId);
				object.setChapterName(chapterName);
				object.setOptionA(optionA);
				object.setOptionB(optionB);
				object.setOptionC(optionC);
				object.setOptionD(optionD);
				object.setQuestion(question);
				object.setScore(score);
				object.setSectionName(sectionName);
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
	 * ͨ��id��ȡ��Ŀ��Ϣ
	 * @param id ��Ŀid
	 * @return
	 * @throws SQLException
	 */
	public Topic getTopicById(int id) throws SQLException{
		String sql = "select * from tb_topic where id = ?";
		Topic object = new Topic();
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			int chapterId,score;
			String question,answer,type,chapterName,sectionName,optionA,optionB,optionC,optionD;
			
			while(rs.next()){
				id = rs.getInt("id");
				score = rs.getInt("score");
				chapterId = rs.getInt("chapterId");
				
				question = rs.getString("question");
				chapterName = rs.getString("chapterName");
				sectionName = rs.getString("sectionName");
				answer = rs.getString("answer");
				type = rs.getString("type");
				optionA = rs.getString("optionA");
				optionB = rs.getString("optionB");
				optionC = rs.getString("optionC");
				optionD = rs.getString("optionD");
				
				object = new Topic();
				object.setId(id);
				object.setAnswer(answer);
				object.setChapterId(chapterId);
				object.setChapterName(chapterName);
				object.setOptionA(optionA);
				object.setOptionB(optionB);
				object.setOptionC(optionC);
				object.setOptionD(optionD);
				object.setQuestion(question);
				object.setScore(score);
				object.setSectionName(sectionName);
				object.setType(type);
				
			}
			DbUtil.close();
			return object;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	
	/**
	 * ͨ����Ŀ���ͻ�ȡ��Ŀ��Ϣ
	 * @param type ��Ŀ����
	 * @return ������Ŀ�б�
	 * @throws SQLException
	 */
	public ArrayList<Topic> getTopicByType(String type) throws SQLException{
		ArrayList<Topic> objects = new ArrayList<>();
		String sql = "select * from tb_topic where type = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			
			int id,chapterId,score;
			String question,answer,chapterName,sectionName,optionA,optionB,optionC,optionD;
			Topic object;
			
			while(rs.next()){
				id = rs.getInt("id");
				score = rs.getInt("score");
				chapterId = rs.getInt("chapterId");
				
				question = rs.getString("question");
				chapterName = rs.getString("chapterName");
				sectionName = rs.getString("sectionName");
				answer = rs.getString("answer");
				type = rs.getString("type");
				optionA = rs.getString("optionA");
				optionB = rs.getString("optionB");
				optionC = rs.getString("optionC");
				optionD = rs.getString("optionD");
				
				object = new Topic();
				object.setId(id);
				object.setAnswer(answer);
				object.setChapterId(chapterId);
				object.setChapterName(chapterName);
				object.setOptionA(optionA);
				object.setOptionB(optionB);
				object.setOptionC(optionC);
				object.setOptionD(optionD);
				object.setQuestion(question);
				object.setScore(score);
				object.setSectionName(sectionName);
				object.setType(type);
				
				objects.add(object);
			}
			DbUtil.close();
			return objects;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	
	public ArrayList<Topic> getTopicLikeQuestion(String question) throws SQLException{
		ArrayList<Topic> objects = new ArrayList<>();
		String sql = "select * from tb_topic where question like ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, question);
			ResultSet rs = ps.executeQuery();
			
			int id,chapterId,score;
			String type,answer,chapterName,sectionName,optionA,optionB,optionC,optionD;
			Topic object;
			
			while(rs.next()){
				id = rs.getInt("id");
				score = rs.getInt("score");
				chapterId = rs.getInt("chapterId");
				
				question = rs.getString("question");
				chapterName = rs.getString("chapterName");
				sectionName = rs.getString("sectionName");
				answer = rs.getString("answer");
				type = rs.getString("type");
				optionA = rs.getString("optionA");
				optionB = rs.getString("optionB");
				optionC = rs.getString("optionC");
				optionD = rs.getString("optionD");
				
				object = new Topic();
				object.setId(id);
				object.setAnswer(answer);
				object.setChapterId(chapterId);
				object.setChapterName(chapterName);
				object.setOptionA(optionA);
				object.setOptionB(optionB);
				object.setOptionC(optionC);
				object.setOptionD(optionD);
				object.setQuestion(question);
				object.setScore(score);
				object.setSectionName(sectionName);
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
	 * ͨ���½�����ȡ��Ŀ��Ϣ
	 * @param chapterName �½���
 	 * @return ������Ŀ��Ϣ�б�
	 * @throws SQLException
	 */
	public ArrayList<Topic> getTopicByChapterName(String chapterName) throws SQLException{
		ArrayList<Topic> objects = new ArrayList<>();
		String sql = "select * from tb_topic where chapterName = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, chapterName);
			ResultSet rs = ps.executeQuery();
			
			int id,score,chapterId;
			String question,answer,type,sectionName,optionA,optionB,optionC,optionD;
			Topic object;
			
			while(rs.next()){
				id = rs.getInt("id");
				score = rs.getInt("score");
				chapterId = rs.getInt("chapterId");
				
				question = rs.getString("question");
				chapterName = rs.getString("chapterName");
				sectionName = rs.getString("sectionName");
				answer = rs.getString("answer");
				type = rs.getString("type");
				optionA = rs.getString("optionA");
				optionB = rs.getString("optionB");
				optionC = rs.getString("optionC");
				optionD = rs.getString("optionD");
				
				object = new Topic();
				object.setId(id);
				object.setAnswer(answer);
				object.setChapterId(chapterId);
				object.setChapterName(chapterName);
				object.setOptionA(optionA);
				object.setOptionB(optionB);
				object.setOptionC(optionC);
				object.setOptionD(optionD);
				object.setQuestion(question);
				object.setScore(score);
				object.setSectionName(sectionName);
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
	 * ͨ��С������ȡ��Ŀ�б�
	 * @param sectionName С����
	 * @return ������Ŀ�б�
	 * @throws SQLException
	 */
	public ArrayList<Topic> getTopicBySectionName(String sectionName) throws SQLException{
		ArrayList<Topic> objects = new ArrayList<>();
		String sql = "select * from tb_topic where sectionName = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, sectionName);
			ResultSet rs = ps.executeQuery();
			
			int id,score,chapterId;
			String question,answer,type,chapterName,optionA,optionB,optionC,optionD;
			Topic object;
			
			while(rs.next()){
				id = rs.getInt("id");
				score = rs.getInt("score");
				chapterId = rs.getInt("chapterId");
				
				question = rs.getString("question");
				chapterName = rs.getString("chapterName");
				sectionName = rs.getString("sectionName");
				answer = rs.getString("answer");
				type = rs.getString("type");
				optionA = rs.getString("optionA");
				optionB = rs.getString("optionB");
				optionC = rs.getString("optionC");
				optionD = rs.getString("optionD");
				
				object = new Topic();
				object.setId(id);
				object.setAnswer(answer);
				object.setChapterId(chapterId);
				object.setChapterName(chapterName);
				object.setOptionA(optionA);
				object.setOptionB(optionB);
				object.setOptionC(optionC);
				object.setOptionD(optionD);
				object.setQuestion(question);
				object.setScore(score);
				object.setSectionName(sectionName);
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
	 * @param topic
	 * @return Ӱ�������
	 * @throws SQLException
	 */
	public int insertTopic(Topic topic) throws SQLException{
		String sql = "insert into tb_topic (score,chapterId,question,answer,type,chapterName,sectionName,"+
					"optionA,optionB,optionC,optionD) values (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, topic.getScore());
			ps.setInt(2, topic.getChapterId());
			
			ps.setString(3, topic.getQuestion());
			ps.setString(4, topic.getAnswer());
			ps.setString(5, topic.getType());
			ps.setString(6, topic.getChapterName());
			ps.setString(7, topic.getSectionName());
			ps.setString(8, topic.getOptionA());
			ps.setString(9, topic.getOptionB());
			ps.setString(10, topic.getOptionC());
			ps.setString(11, topic.getOptionD());
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * @param topic
	 * @param id
	 * @return Ӱ�������
	 * @throws SQLException
	 */
	public int updateTopicById(Topic topic,int id) throws SQLException{
		String sql = "update tb_topic set score=?,chapterId=?,question=?,answer=?,type=?,chapterName=?,sectionName=?,"+
					"optionA=?,optionB=?,optionC=?,optionD=? where id=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, topic.getScore());
			ps.setInt(2, topic.getChapterId());
			
			ps.setString(3, topic.getQuestion());
			ps.setString(4, topic.getAnswer());
			ps.setString(5, topic.getType());
			ps.setString(6, topic.getChapterName());
			ps.setString(7, topic.getSectionName());
			ps.setString(8, topic.getOptionA());
			ps.setString(9, topic.getOptionB());
			ps.setString(10, topic.getOptionC());
			ps.setString(11, topic.getOptionD());
			
			ps.setInt(12, id);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * @param id
	 * @return Ӱ�������
	 * @throws SQLException
	 */
	public int deleteTopicById(int id) throws SQLException{
		String sql = "delete from tb_topic where id=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * ɾ��ĳ���½��µ�������Ŀ
	 * @param chapterName
	 * @return Ӱ�������
	 * @throws SQLException
	 */
	public int deleteTopicByChapterName(String chapterName) throws SQLException{
		String sql = "delete from tb_topic where chapterName=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			
			ps.setString(1, chapterName);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * ɾ��ĳС���µ�������Ŀ
	 * @param sectionName
	 * @return Ӱ�������
	 * @throws SQLException
	 */
	public int deleteTopicBySectionName(String sectionName) throws SQLException{
		String sql = "delete from tb_topic where chapterName=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			
			ps.setString(1, sectionName);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * ɾ��ĳ�����͵�������Ŀ
	 * @param type
	 * @return Ӱ�������
	 * @throws SQLException
	 */
	public int deleteTopicByType(String type) throws SQLException{
		String sql = "delete from tb_topic where type=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			
			ps.setString(1, type);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * ɾ��������Ŀ
	 * @return
	 * @throws SQLException
	 */
	public int deleteAllTopics() throws SQLException{
		String sql = "delete from tb_topic";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
}
