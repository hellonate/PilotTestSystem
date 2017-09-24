/**
*@auchor HPC
*
*/
package dataUtil;

import java.util.ArrayList;

import com.google.gson.*;

public class JsonUtil {
	
	/**
	 * ��bean����ת��Ϊjson
	 * @param object
	 * @return
	 */
	public String convertBeanToJSON(Object object){
		Gson gson = new Gson();
		String value = gson.toJson(object);
		
		return value;
	}
	
	/**
	 * ��arraylist����ת��Ϊjson
	 * @param objects
	 * @return
	 */
	public String convertBeanToJSON(ArrayList<Object> objects){
		Gson gson = new Gson();
		String value = gson.toJson(objects);
		
		return value;
	}


}
