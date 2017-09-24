/**
*@auchor HPC
*
*/
package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Bean.Chapter;
import com.utils.DbUtil;

public class ChapterDaoImpl {

	/**
	 * ��ȡchapter���е�������Ϣ
	 * @return ����chapter�б�
	 * @throws SQLException if the columnLabel is not valid; if a database access error occurs 
	 * or this method is called on a closed result set 
	 */
	public ArrayList<Chapter> getAllInfo() throws SQLException{
		ArrayList<Chapter> chapters = new ArrayList<>();
		String sql = "select * from tb_chapter";
		try{
			ResultSet rs = DbUtil.executeQuery(sql);
			int chapterId;
			String name,content,comment,status; 
			Chapter chapter;
			while(rs.next()){
				chapterId = rs.getInt("chapterId");
				name = rs.getString("name");
				content = rs.getString("content");
				comment = rs.getString("comment");
				status = rs.getString("status");
				
				chapter = new Chapter();
				chapter.setChapterId(chapterId);
				chapter.setName(name);
				chapter.setComment(comment);
				chapter.setContent(content);
				chapter.setStatus(status);
				
				chapters.add(chapter);
			}
			
			DbUtil.close();
			return chapters;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	
	/**
	 * ͨ��ָ��id��ȡchapter��Ϣ
	 * @param chapterId ָ��id
	 * @return �ɹ�����chapterʵ�������򷵻�null
	 * @throws SQLException
	 */
	public Chapter getChapterById(int chapterId) throws SQLException{
		Chapter chapter = new Chapter();
		String sql = "select * from tb_chapter where chapterId=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, chapterId);
			ResultSet rs = ps.executeQuery();
			
			String name,content,comment,status; 
			while(rs.next()){
				chapterId = rs.getInt("chapterId");
				name = rs.getString("name");
				content = rs.getString("content");
				comment = rs.getString("comment");
				status = rs.getString("status");
				
				chapter = new Chapter();
				chapter.setChapterId(chapterId);
				chapter.setName(name);
				chapter.setComment(comment);
				chapter.setContent(content);
				chapter.setStatus(status);
			}
			
			DbUtil.close();
			return chapter;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	
	public ArrayList<Chapter> getChaptersLikeName(String chapterName) throws SQLException{
		ArrayList<Chapter> chapters = new ArrayList<>();
		String sql = "select * from tb_chapter where name like ?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, chapterName);
			ResultSet rs = ps.executeQuery();
			
			String name,content,comment,status; 
			int chapterId;
			Chapter chapter = null;
			while(rs.next()){
				chapterId = rs.getInt("chapterId");
				name = rs.getString("name");
				content = rs.getString("content");
				comment = rs.getString("comment");
				status = rs.getString("status");
				
				chapter = new Chapter();
				chapter.setChapterId(chapterId);
				chapter.setName(name);
				chapter.setComment(comment);
				chapter.setContent(content);
				chapter.setStatus(status);
				
				chapters.add(chapter);
			}
			
			DbUtil.close();
			return chapters;
		} catch (SQLException e) {
			throw e;
		}
	}
	

	/**
	 * ͨ��ָ��name��ȡchapter��Ϣ
	 * @param name chapter����
	 * @return �ɹ�����chapterʵ�������򷵻�null
	 * @throws SQLException
	 */
	public Chapter getChapterByName(String name) throws SQLException{
		Chapter chapter = new Chapter();
		String sql = "select * from tb_chapter where name=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			int chapterId;
			String content,comment,status; 
			while(rs.next()){
				chapterId = rs.getInt("chapterId");
				name = rs.getString("name");
				content = rs.getString("content");
				comment = rs.getString("comment");
				status = rs.getString("status");
				
				chapter = new Chapter();
				chapter.setChapterId(chapterId);
				chapter.setName(name);
				chapter.setComment(comment);
				chapter.setContent(content);
				chapter.setStatus(status);
			}
			DbUtil.close();
			return chapter;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * �����µ�chapter��Ϣ(chapterIdֵ��Ч)
	 * @param chapter
	 * @return  Ӱ�������
	 * @throws SQLException
	 */
	public int insertChapter(Chapter chapter) throws SQLException{
		String sql = "insert into tb_chapter (name,content,comment,status) values (?,?,?,?)";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, chapter.getName());
			ps.setString(2, chapter.getContent());
			ps.setString(3, chapter.getComment());
			ps.setString(4, chapter.getStatus());
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * ͨ��id����chapter��Ϣ(���ܸ���chapterIDֵ)
	 * @param chapter
	 * @param id 
	 * @return Ӱ�������
	 * @throws SQLException
	 */
	public int updateChapterById(Chapter chapter,int id) throws SQLException{
		String sql = "update tb_chapter set name=?,content=?,comment=?,status=? where chapterId=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, chapter.getName());
			ps.setString(2, chapter.getContent());
			ps.setString(3, chapter.getComment());
			ps.setString(4, chapter.getStatus());
			ps.setInt(5, id);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * ͨ��name����chapter��Ϣ(���ܸ���chapterIDֵ)
	 * @param chapter
	 * @param id 
	 * @return  Ӱ�������
	 * @throws SQLException
	 */
	public int updateChapterByName(Chapter chapter,String name) throws SQLException{
		String sql = "update tb_chapter set name=?,content=?,comment=?,status=? where name=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, chapter.getName());
			ps.setString(2, chapter.getContent());
			ps.setString(3, chapter.getComment());
			ps.setString(4, chapter.getStatus());
			ps.setString(5, name);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * ͨ��idֵɾ��chapter��Ϣ
	 * @param id
	 * @return  Ӱ�������
	 * @throws SQLException
	 */
	public int deleteChapterById(int id) throws SQLException{
		String sql = "delete from tb_chapter where chapterId=?";
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
	 * ͨ��nameֵɾ��chapter��Ϣ
	 * @param id
	 * @return  Ӱ�������
	 * @throws SQLException
	 */
	public int deleteChapterByName(String name) throws SQLException{
		String sql = "delete from tb_chapter where name=?";
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
