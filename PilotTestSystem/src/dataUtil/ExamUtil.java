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
	 * ������������
	 * @param chapterNames �����½�
	 * @param topicTypes ��Ŀ����
	 * @param selectNums ѡ������
	 * @return �������ѡ����������Ŀ
	 * @throws SQLException
	 */
	public ArrayList<Topic> createExamTopics(String[] chapterNames,String[] topicTypes,int selectNums) 
			throws SQLException{
		ArrayList<Topic> examTopics = new ArrayList<>();
		TopicDaoImpl topicDaoImpl = new TopicDaoImpl();
		for(String name:chapterNames){//����ÿһ��
			ArrayList<Topic> topics = new ArrayList<>();
			try {
				topics = topicDaoImpl.getTopicByChapterName(name);
			} catch (SQLException e) {
				throw e;
			}
			for(Topic topic:topics){//����һ����������
				for(String type:topicTypes){//������������
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
	 * ���ɸѡ
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
		if(selectNum >= count){//ѡ����������������
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
	 * ��ȡ�Ѵ���������е�����
	 * @param index ��Ŀ�±�(��1��ʼ)
	 * @return ����Topicʵ��
	 * @throws IllegalArgumentException �±�ֵС��1���ߴ������ֵ
	 * @throws IllegalStateException û�д��������
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
