/**
 * Project Name:KeKeEnglishDownloadFileTransFer
 * File Name:Lyric.java
 * Package Name:org.leon.en.trans.commom.file.entity
 * Date:2016年8月18日下午8:42:38
 * Copyright (c) 2016, xiyang@asiainfo.com All Rights Reserved.
 *
*/

package org.leon.en.trans.commom.file.entity;

import java.util.List;

/**
 * ClassName:Lyric <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月18日 下午8:42:38 <br/>
 * @author   xiyang
 * @version  v1.0
 * @since    JDK 1.6
 * @see 	 
 */
public class Lyric {
	
	private String catname ;  //上级标题
	
	private String teach ;   //是否可读
	
	private String title ;   //文件标题
	
	private String type ;   //类型
	
	private String lmpic ; // 文件图片
	
	private String playurl ;
	
	private String switchF ;
	
	private String mp3 ;
	
	private String catid ;
	
	private String commentcount ;
	
	private String ting ;
	
	private String shareurl ;
	
	private String Irc ;
	
	private List<LyricSetence> lyricSetences ; //歌词合集

	
	
	public Lyric() {
	}

	public Lyric(String catname, String teach, String title, String type, String lmpic, String playurl, String switchF,
			String mp3, String catid, String commentcount, String ting, String shareurl, String irc,
			List<LyricSetence> lyricSetences) {
		super();
		this.catname = catname;
		this.teach = teach;
		this.title = title;
		this.type = type;
		this.lmpic = lmpic;
		this.playurl = playurl;
		this.switchF = switchF;
		this.mp3 = mp3;
		this.catid = catid;
		this.commentcount = commentcount;
		this.ting = ting;
		this.shareurl = shareurl;
		Irc = irc;
		this.lyricSetences = lyricSetences;
	}

	public String getCatname() {
		return catname;
	}

	public void setCatname(String catname) {
		this.catname = catname;
	}

	public String getTeach() {
		return teach;
	}

	public void setTeach(String teach) {
		this.teach = teach;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLmpic() {
		return lmpic;
	}

	public void setLmpic(String lmpic) {
		this.lmpic = lmpic;
	}

	public String getPlayurl() {
		return playurl;
	}

	public void setPlayurl(String playurl) {
		this.playurl = playurl;
	}

	public String getSwitchF() {
		return switchF;
	}

	public void setSwitchF(String switchF) {
		this.switchF = switchF;
	}

	public String getMp3() {
		return mp3;
	}

	public void setMp3(String mp3) {
		this.mp3 = mp3;
	}

	public String getCatid() {
		return catid;
	}

	public void setCatid(String catid) {
		this.catid = catid;
	}

	public String getCommentcount() {
		return commentcount;
	}

	public void setCommentcount(String commentcount) {
		this.commentcount = commentcount;
	}

	public String getTing() {
		return ting;
	}

	public void setTing(String ting) {
		this.ting = ting;
	}

	public String getShareurl() {
		return shareurl;
	}

	public void setShareurl(String shareurl) {
		this.shareurl = shareurl;
	}

	public String getIrc() {
		return Irc;
	}

	public void setIrc(String irc) {
		Irc = irc;
	}

	public List<LyricSetence> getLyricSetences() {
		return lyricSetences;
	}

	public void setLyricSetences(List<LyricSetence> lyricSetences) {
		this.lyricSetences = lyricSetences;
	}

	@Override
	public String toString() {
		return "Lyric [catname=" + catname + ", teach=" + teach + ", title=" + title + ", type=" + type + ", lmpic="
				+ lmpic + ", playurl=" + playurl + ", switchF=" + switchF + ", mp3=" + mp3 + ", catid=" + catid
				+ ", commentcount=" + commentcount + ", ting=" + ting + ", shareurl=" + shareurl + ", Irc=" + Irc
				+ ", lyricSetences=" + lyricSetences + "]";
	}
	
}

