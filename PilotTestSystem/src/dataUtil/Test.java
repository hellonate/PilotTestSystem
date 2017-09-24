/**
*@auchor HPC
*
*/
package dataUtil;

import java.util.ArrayList;

import com.Bean.Chapter;
import com.Bean.Topic;

import DaoImpl.ChapterDaoImpl;



public class Test {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		System.out.println("test Start");
		
		try {
			
			ExamUtil dataUtil = new ExamUtil();
			ArrayList<Topic> topics = 
					dataUtil.createExamTopics(new String[]{"��һ��"}, new String[]{"choice"}, 9);
			
			//System.out.println(topics.size());
			
			
			ErrorUtil errorUtil = new ErrorUtil();
			ArrayList<Topic> errorTopics = 
					errorUtil.getErrorTopicsByUserIdAndChapterName(1, "第一章");
			
			System.out.println(errorTopics.size());
			
			
			
			
		}  catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("test Done");
	}

}
