/**
 * Project Name:KeKeEnglishDownloadFileTransFer
 * File Name:JsonConvert.java
 * Package Name:org.leon.en.trans.commom
 * Date:2016年8月18日下午4:20:29
 * Copyright (c) 2016, xiyang@asiainfo.com All Rights Reserved.
 *
*/

package org.leon.en.trans.commom.file.json;

import org.json.JSONObject;

/**
 * ClassName:JsonConvert <br/>
 * Function: 转换Json串. <br/>
 * Date:     2016年8月18日 下午4:20:29 <br/>
 * @author   xiyang
 * @version  v1.0
 * @since    JDK 1.6
 * @see 	 
 */
public class JsonConvert {
	
	public static JSONObject jsonObject ;
	
	private JsonConvert(){
		
	}
	
	public static JSONObject getInstance() {
		if(jsonObject==null) {
			jsonObject = new JSONObject() ;
		} 
		return jsonObject ;
	}
	
	public static JSONObject transJsonObject(String source) {
		return new JSONObject(source) ;
	}
	public static void main(String[] args) {

		// TODO Auto-generated method stub

	}

}

