/**
 * Project Name:KeKeEnglishDownloadFileTransFer
 * File Name:LyricTime.java
 * Package Name:org.leon.en.trans.commom.file.entity
 * Date:2016年8月18日下午8:43:08
 * Copyright (c) 2016, xiyang@asiainfo.com All Rights Reserved.
 *
*/

package org.leon.en.trans.commom.file.entity;
/**
 * ClassName:LyricSetence <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月18日 下午8:43:08 <br/>
 * @author   xiyang
 * @version  v1.0
 * @since    JDK 1.6
 * @see 	 
 */
public class LyricSetence {
	
	private String millisecond ; // 毫秒时间
	private String en ; //英文字幕
	private String cn ; //中文字幕
	private String time ; //句子所在位置
	
	
	public LyricSetence(String millisecond, String en, String cn, String time) {
		super();
		this.millisecond = millisecond;
		this.en = en;
		this.cn = cn;
		this.time = time;
	}
	
	public String getMillisecond() {
		return millisecond;
	}
	public void setMillisecond(String millisecond) {
		this.millisecond = millisecond;
	}
	public String getEn() {
		return en;
	}
	public void setEn(String en) {
		this.en = en;
	}
	public String getCn() {
		return cn;
	}
	public void setCn(String cn) {
		this.cn = cn;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "LyricSetence [millisecond=" + millisecond + ", en=" + en + ", cn=" + cn + ", time={" + time + "}]";
	}
	
	
}

