/**
*@author HPC
*/
package dataUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import com.Bean.Topic;

import DaoImpl.TopicDaoImpl;

public class ExamUtil {
	
	private ArrayList<Topic> examTopics = null;
	
	public ExamUtil(){
		examTopics = new ArrayList<>();
	}
	
	/**
	 * 创建考试试题
	 * @param chapterNames 考试章节
	 * @param topicTypes 题目类型
	 * @param selectNums 选择数量
	 * @return 返回随机选择数量的题目
	 * @throws SQLException
	 */
	public ArrayList<Topic> createExamTopics(String[] chapterNames,String[] topicTypes,int selectNums) 
			throws SQLException{
		ArrayList<Topic> examTopics = new ArrayList<>();
		TopicDaoImpl topicDaoImpl = new TopicDaoImpl();
		for(String name:chapterNames){//遍历每一章
			ArrayList<Topic> topics = new ArrayList<>();
			try {
				topics = topicDaoImpl.getTopicByChapterName(name);
			} catch (SQLException e) {
				throw e;
			}
			for(Topic topic:topics){//遍历一章下所有题
				for(String type:topicTypes){//遍历所有题型
					if(topic.getType().equals(type)){
						examTopics.add(topic);
					}
				}
			}
		}
		examTopics = getRandomObjects(examTopics, selectNums);
		this.examTopics = examTopics;
		return examTopics;
	}
	
	/**
	 * 随机筛选
	 * @param dataObjects
	 * @param selectNum
	 * @return
	 * @throws IllegalArgumentException
	 */
	private ArrayList<Topic> getRandomObjects(ArrayList<Topic> dataObjects,int selectNum)
						throws IllegalArgumentException{
		int count = dataObjects.size();
		if(selectNum < 0){
			throw new IllegalArgumentException();
		}
		if(selectNum >= count){//选择数大于数据总数
			return dataObjects;
		}else{
			Random random = new Random();
			ArrayList<Topic> selectObjects = new ArrayList<>();
			for(int i=0;i<selectNum;i++){
				int index = random.nextInt(count-i);
				selectObjects.add(dataObjects.get(index));
				dataObjects.remove(index);
			}
			return selectObjects;
		}
	}
	
	/**
	 * 获取已创建试题库中的试题
	 * @param index 题目下标(从1开始)
	 * @return 返回Topic实例
	 * @throws IllegalArgumentException 下标值小于1或者大于最大值
	 * @throws IllegalStateException 没有创建试题库
	 */
	public Topic getTopicInExamTopics(int index) 
			throws IllegalArgumentException,IllegalStateException{
		if(examTopics.size() == 0){
			throw new IllegalStateException();
		}else{
			if(index < 1 || index > examTopics.size()){
				throw new IllegalArgumentException();
			}else{
				return examTopics.get(index-1);
			}
		}
	}
	

}
