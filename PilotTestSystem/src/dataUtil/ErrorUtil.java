/**
*@auchor HPC
*
*/
package dataUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.Bean.Error;
import com.Bean.Topic;

import DaoImpl.ErrorDaoImpl;
import DaoImpl.TopicDaoImpl;

public class ErrorUtil {
	
	
	public ArrayList<Topic> getErrorTopicsByUserIdAndChapterName(int userId,String chapterName) throws SQLException{
		ErrorDaoImpl errorDaoImpl = new ErrorDaoImpl();
		ArrayList<Error> errors = errorDaoImpl.getErrorByUserId(userId);
		
		ArrayList<Topic> errorTopics = new ArrayList<>();
		Topic topic = null;
		TopicDaoImpl topicDaoImpl = new TopicDaoImpl();
		for(Error error:errors){
			topic = topicDaoImpl.getTopicById(error.getTopicId());
			if(topic == null) continue;
			if(topic.getChapterName().equals(chapterName)){
				errorTopics.add(topic);
			}
		}
		return errorTopics;
	}
	
	public HashMap<String, Integer> getErrorNumByChapterName(int userId,String chapterName) throws SQLException{
		HashMap<String, Integer> map = new HashMap<>();
		int value = 0;
		ArrayList<Topic> topics = getErrorTopicsByUserIdAndChapterName(userId, chapterName);
		int choice=0,judge=0,blank=0;
		for(Topic topic:topics){
			if(topic.getType().equals("choice")){
				value = 1;
				choice++;
			}else if (topic.getType().equals("judge")) {
				value = 1;
				judge++;
			}else if (topic.getType().equals("blank")) {
				value = 1;
				blank++;
			}
		}
		map.put("hasValue",value);
		map.put("choice", choice);
		map.put("judge", judge);
		map.put("blank",blank);
		return map;
	}

}
