/**
*@auchor HPC
*
*/
package dataUtil;

import java.util.ArrayList;

import com.google.gson.*;

public class JsonUtil {
	
	/**
	 * 将bean对象转换为json
	 * @param object
	 * @return
	 */
	public String convertBeanToJSON(Object object){
		Gson gson = new Gson();
		String value = gson.toJson(object);
		
		return value;
	}
	
	/**
	 * 将arraylist对象转换为json
	 * @param objects
	 * @return
	 */
	public String convertBeanToJSON(ArrayList<Object> objects){
		Gson gson = new Gson();
		String value = gson.toJson(objects);
		
		return value;
	}


}
