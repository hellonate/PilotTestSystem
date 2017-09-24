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
	 * 获取小节表中的所有信息
	 * @return 返回section列表
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
	 * 通过章节名获取小节
	 * @param chapterId 章节id号
	 * @return 返回小节列表
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
	 * 通过小节名获取小节信息
	 * @param sectionName 小节名
	 * @return 返回小节列表
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
	 * 通过小节id获取小节信息
	 * @param sectionId 小节id
 	 * @return 返回小节列表
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
	 * 插入新的section信息
	 * @param section
	 * @return 影响的行数
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
	 * @return 影响的行数
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
	 * @return 影响的行数
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
	 * 删除某章的所有小节信息
	 * @param chapterId
	 * @return 影响的行数
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
	 * @return 影响的行数
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
	 * @return 影响的行数
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
