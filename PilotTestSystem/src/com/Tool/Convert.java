package com.Tool;
public class Convert {
	/**
	 * ������ת����Ϊ�ַ���
	 */
	public Convert(){}
	public String arrToStr(String[] arr){
		StringBuffer sb=new StringBuffer();
		if(arr!=null&&arr.length>0){
			for(String s:arr){
				sb.append(s);
				sb.append(",");
			}
			if(sb.length()>0){
				sb=sb.deleteCharAt(sb.length()-1);
				
			}
		}
		return sb.toString();
	}
}
