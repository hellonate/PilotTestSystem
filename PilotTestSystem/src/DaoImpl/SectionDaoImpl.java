/**
*@auchor HPC
*
*/
package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Bean.Section;
import com.utils.DbUtil;
public class SectionDaoImpl {
	
	/**
	 * ��ȡС�ڱ��е�������Ϣ
	 * @return ����section�б�
	 * @throws SQLException
	 */
	public ArrayList<Section> getAllInfo() throws SQLException{
		ArrayList<Section> objects = new ArrayList<>();
		String sql = "select * from tb_section";
		try{
			ResultSet rs = DbUtil.executeQuery(sql);
			
			int id,chapterId;
			String sectionId,chapterName,sectionName,comment,flags;
			Section object;
			
			while(rs.next()){
				id = rs.getInt("id");
				chapterId = rs.getInt("chapterId");
				sectionId = rs.getString("sectionId");
				chapterName = rs.getString("chapterName");
				sectionName = rs.getString("sectionName");
				comment = rs.getString("comment");
				flags = rs.getString("flags");
				
				object = new Section();
				object.setId(id);
				object.setChapterId(chapterId);
				object.setChapterName(chapterName);
				object.setComment(comment);
				object.setFlags(flags);
				object.setSectionId(sectionId);
				object.setSectionName(sectionName);
				
				objects.add(object);
			}
			
			DbUtil.close();
			return objects;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * ͨ���½�����ȡС��
	 * @param chapterId �½�id��
	 * @return ����С���б�
	 * @throws SQLException
	 */
	public ArrayList<Section> getSectionByChapterId(int chapterId) throws SQLException{
		ArrayList<Section> objects = new ArrayList<>();
		String sql = "select * from tb_section where chapterId = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, chapterId);
			ResultSet rs = ps.executeQuery();
			
			int id;
			String sectionId,chapterName,sectionName,comment,flags;
			Section object;
			
			while(rs.next()){
				id = rs.getInt("id");
				chapterId = rs.getInt("chapterId");
				sectionId = rs.getString("sectionId");
				chapterName = rs.getString("chapterName");
				sectionName = rs.getString("sectionName");
				comment = rs.getString("comment");
				flags = rs.getString("flags");
				
				object = new Section();
				object.setId(id);
				object.setChapterId(chapterId);
				object.setChapterName(chapterName);
				object.setComment(comment);
				object.setFlags(flags);
				object.setSectionId(sectionId);
				object.setSectionName(sectionName);
				
				objects.add(object);
			}
			DbUtil.close();
			return objects;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * ͨ��С������ȡС����Ϣ
	 * @param sectionName С����
	 * @return ����С���б�
	 * @throws SQLException
	 */
	public ArrayList<Section> getSectionBySectionName(String sectionName) throws SQLException{
		ArrayList<Section> objects = new ArrayList<>();
		String sql = "select * from tb_section where sectionName = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, sectionName);
			ResultSet rs = ps.executeQuery();
			
			int id,chapterId;
			String sectionId,chapterName,comment,flags;
			Section object;
			
			while(rs.next()){
				id = rs.getInt("id");
				chapterId = rs.getInt("chapterId");
				sectionId = rs.getString("sectionId");
				chapterName = rs.getString("chapterName");
				sectionName = rs.getString("sectionName");
				comment = rs.getString("comment");
				flags = rs.getString("flags");
				
				object = new Section();
				object.setId(id);
				object.setChapterId(chapterId);
				object.setChapterName(chapterName);
				object.setComment(comment);
				object.setFlags(flags);
				object.setSectionId(sectionId);
				object.setSectionName(sectionName);
				
				objects.add(object);
			}
			DbUtil.close();
			return objects;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * ͨ��С��id��ȡС����Ϣ
	 * @param sectionId С��id
 	 * @return ����С���б�
	 * @throws SQLException
	 */
	public ArrayList<Section> getSectionBySectionId(String sectionId) throws SQLException{
		ArrayList<Section> objects = new ArrayList<>();
		String sql = "select * from tb_section where sectionId = ?";
		try{
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, sectionId);
			ResultSet rs = ps.executeQuery();
			
			int id,chapterId;
			String sectionName,chapterName,comment,flags;
			Section object;
			
			while(rs.next()){
				id = rs.getInt("id");
				chapterId = rs.getInt("chapterId");
				sectionId = rs.getString("sectionId");
				chapterName = rs.getString("chapterName");
				sectionName = rs.getString("sectionName");
				comment = rs.getString("comment");
				flags = rs.getString("flags");
				
				object = new Section();
				object.setId(id);
				object.setChapterId(chapterId);
				object.setChapterName(chapterName);
				object.setComment(comment);
				object.setFlags(flags);
				object.setSectionId(sectionId);
				object.setSectionName(sectionName);
				
				objects.add(object);
			}
			DbUtil.close();
			return objects;
		}catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * �����µ�section��Ϣ
	 * @param section
	 * @return Ӱ�������
	 * @throws SQLException
	 */
	public int insertSection(Section section) throws SQLException{
		String sql = "insert into tb_section (chapterId,sectionId,chapterName,sectionName,comment,flags)"+
								" values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, section.getChapterId());
			ps.setString(2, section.getSectionId());
			ps.setString(3, section.getChapterName());
			ps.setString(4, section.getSectionName());
			ps.setString(5, section.getComment());
			ps.setString(6, section.getFlags());
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * @param section
	 * @param sectionId
	 * @return Ӱ�������
	 * @throws SQLException
	 */
	public int updateSectionBySectionId(Section section,String sectionId) throws SQLException{
		String sql = "update tb_section set chapterId=?,sectionId=?,chapterName=?,sectionName=?,comment=?,flags=?"+
								" where sectionId=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, section.getChapterId());
			ps.setString(2, section.getSectionId());
			ps.setString(3, section.getChapterName());
			ps.setString(4, section.getSectionName());
			ps.setString(5, section.getComment());
			ps.setString(6, section.getFlags());
			ps.setString(7, sectionId);
			
			int i = ps.executeUpdate();
			DbUtil.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * @param section
	 * @param sectionName
	 * @return Ӱ�������
	 * @throws SQLException
	 */
	public int updateSectionBySectionName(Section section,String sectionName) throws SQLException{
		String sql = "update tb_section set chapterId=?,sectionId=?,chapterName=?,sectionName=?,comment=?,flags=?"+
								" where sectionName=?";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, section.getChapterId());
			ps.setString(2, section.getSectionId());
			ps.setString(3, section.getChapterName());
			ps.setString(4, section.getSectionName());
			ps.setString(5, section.getComment());
			ps.setString(6, section.getFlags());
			ps.setString(7, sectionName);
			
			int i = ps.executeUpdate();
			ps.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * ɾ��ĳ�µ�����С����Ϣ
	 * @param chapterId
	 * @return Ӱ�������
	 * @throws SQLException
	 */
	public int deleteSectionByChapterId(int chapterId) throws SQLException{
		String sql = "delete from tb_section where chapterId=? ";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setInt(1, chapterId);
			
			int i = ps.executeUpdate();
			ps.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}

	/**
	 * @param sectionId
	 * @return Ӱ�������
	 * @throws SQLException
	 */
	public int deleteSectionBySectionId(String sectionId) throws SQLException{
		String sql = "delete from tb_section where sectionId=? ";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, sectionId);
			
			int i = ps.executeUpdate();
			ps.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
	
	/**
	 * @param sectionName
	 * @return Ӱ�������
	 * @throws SQLException
	 */
	public int deleteSectionBySectionName(String sectionName) throws SQLException{
		String sql = "delete from tb_section where sectionName=? ";
		try {
			PreparedStatement ps = DbUtil.executePreparedStatement(sql);
			ps.setString(1, sectionName);
			
			int i = ps.executeUpdate();
			ps.close();
			return i;
		} catch (SQLException e) {
			throw e;
		}
	}
}
