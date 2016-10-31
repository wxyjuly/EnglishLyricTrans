/**
 * Project Name:KeKeEnglishDownloadFileTransFer
 * File Name:FileOperate.java
 * Package Name:org.leon.en.trans.commom
 * Date:2016年8月17日下午5:30:38
 * Copyright (c) 2016, xiyang@asiainfo.com All Rights Reserved.
 *
*/

package org.leon.en.trans.commom.file.operate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.leon.en.trans.commom.LyricConst;
import org.leon.en.trans.commom.file.json.JsonConvert;

/**
 * ClassName:FileOperate <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月17日 下午5:30:38 <br/>
 * @author   xiyang
 * @version  v1.0
 * @since    JDK 1.6
 * @see 	 
 */
public class FileRead {
	
	public static Map<String,File> ircFiles = new HashMap<String,File>();  //歌词 Map
	
	public static Map<String,File> mp3Files = new HashMap<String,File>();  //mp3 Map
	
	public static String filePath = "" ; //文件目录
	
	static {
		
	}
	

	/**
	 * Creates a new instance of FileRead.
	 * @param path : 文件路径.
	 */
	public FileRead(String path) {
		
	}
	
	public static String getProperty(String key) {
		filePath = "" ;
		return filePath ;
	}
	
	/**
	 * 
	 * readFileByPath:递归读取所有文件. 
	 * 				     只接受指定后缀的值<br/>
	 * @author xiyang
	 * @param obj
	 * @param suffix : 后缀
	 * @return
	 * @since JDK 1.6
	 */
	public static Map<String, File> readFileListByPathWithSuffix(Object obj, String suffix){
		
		File dir = null ;
		Map<String, File> fileList = new HashMap<String,File>() ;
		if(obj instanceof File){	//文件
			dir = (File) obj ;
		} else {	//路径
			dir = new File(obj.toString()) ;
		}
		if(dir.isFile()) {
			if(isAccept(dir, suffix)){
				fileList.put(getFileNameWithoutSuffix(dir), dir) ; // key-->value
printFileInfo(dir) ;
			}
			return fileList ;
		} else if(dir.isDirectory()) {
			File[]	fileArr	= dir.listFiles() ;
			for (File file : fileArr) {
				fileList.putAll(readFileListByPathWithSuffix(file, suffix)) ;
//printFileInfo(file) ;
			}
		}
		return fileList;
	}
	
	/**
	 * 
	 * isAccept:是否符合文件格式要求. <br/>
	 *
	 * @author xiyang
	 * @param file
	 * @param suffix
	 * @return
	 * @since JDK 1.6
	 */
	public static boolean isAccept(File file,String suffix) {
		return file.getName().toUpperCase().endsWith(suffix.toUpperCase());	//比较大写
	}
	/**
	 * 
	 * readFileByPath:递归读取所有文件. <br/>
	 * @author xiyang
	 * @param obj
	 * @return
	 * @since JDK 1.6
	 */
	public static List<File> readFileListByPath(Object obj){
		
		File dir = null ;
		List<File> fileList = new ArrayList<File>() ;
		if(obj instanceof File){
			dir = (File) obj ;
		} else {
			dir = new File(obj.toString()) ;
		}
		if(dir.isFile()) {
			fileList.add(dir) ;
printFileInfo(dir) ;
			return fileList ;
		} else if(dir.isDirectory()) {
			File[]	fileArr	= dir.listFiles() ;
			for (File file : fileArr) {
				fileList.addAll(readFileListByPath(file)) ;
printFileInfo(file) ;
			}
		}
		return fileList;
	}
	
	/**
	 * 
	 * printFileInfo:打印文件信息. <br/>
	 *
	 * @author xiyang
	 * @param file
	 * @since JDK 1.6
	 */
	public static void printFileInfo(File file){
		System.out.println(
				"文件名+后缀:[" + file.getName()
			+	"];文件路径：[" + file.getPath() 
			+	"];文件绝对路径:[" + file.getAbsolutePath()
			+	"];文件修改时间[" + file.lastModified() 
			+	"];文件名[" + file.getName().split("\\.")[0]
			+	"];文件后缀[" + getFileSuffix(file)
			+	"]"
			
		);
	}
	
	/**
	 * 
	 * getFileSuffix:获取文件前缀. <br/>
	 *
	 * @author xiyang
	 * @param fileName
	 * @return
	 * @since JDK 1.6
	 */
	public static String getFileSuffix(File fileName) {
		return fileName.getName().split("\\.")[1] ;
	}
	
	/**
	 * 
	 * getFileName:获取文件名，去除后缀. <br/>
	 *
	 * @author xiyang
	 * @param fileName
	 * @return
	 * @since JDK 1.6
	 */
	public static String getFileNameWithoutSuffix(File fileName) {
		String [] fileInfo = fileName.getName().split("\\.") ;
		return fileInfo[0] ;
	}
	
	/**
	 * readFileDataByJDK7:通过JDK7-NIO方法，读取数据所有数据到内存. <br/>
	 *
	 * @author xiyang
	 * @param file
	 * @return
	 * @throws IOException
	 * @since JDK 1.6
	 */
	public static List<String> readFileDataByJDK7(File file) throws IOException {
		return Files.readAllLines(file.toPath()) ;
	}
	
	
	/**
	 *-------------------------------======Copy File=======--------------------------- 
	 */
	
	/**
	 * 
	 * copyAudioFile:拷贝一个文件，并且重命名文件名. <br/>
	 * 
	 * @author xiyang
	 * @param desPath
	 * @param file
	 * @return
	 * @since JDK 1.6
	 */
	public static boolean copyAudioFile(String desPath, File file){
		return false ;
	}
	
	/**
	 * 
	 * generateIrcByJson:将数据读取到内存中，并进行解析. <br/>
	 *
	 * @author xiyang
	 * @param jsonObject
	 * @return
	 * @since JDK 1.6
	 */
	public static String generateIrcByJson(JSONObject jsonObject){
		StringBuffer ircContent = new StringBuffer() ;
		ircContent.append("[00:00.00]").append("【"+jsonObject.get("catname")+"】-->").append(jsonObject.get("title")+"\n") ;
		
		JSONArray contentJsons = (JSONArray) jsonObject.get("content") ;
		
		JSONObject jsonTmp ;
		String time = "" ;
		String en = "" ;
		String cn = "" ;
		int millisecond = 0 ;
		
		for (int i = 0; i < contentJsons.length(); i++) {
			jsonTmp = (JSONObject) contentJsons.get(i) ;
			
			time = (String) jsonTmp.get("time") ;
			en = jsonTmp.getString("en") ;
			cn = jsonTmp.getString("cn") ;
			millisecond = jsonTmp.getInt("millisecond") ;
			
			ircContent.append("["+time+"]")
					 .append(en)
					 .append("\t\t")
					 .append(cn)
					 .append("\n") ;
		}
System.out.println("lyric-->" + ircContent) ;
		return ircContent.toString() ;
	}

	/**
	 * 
	 * getRealTitleFromJson:从JSON中获取文件标题. <br/>
	 *
	 * @author xiyang
	 * @param jsonObject
	 * @return
	 * @since JDK 1.6
	 */
	public static String getRealTitleFromJson(JSONObject jsonObject){
		return jsonObject.getString(LyricConst.LYRIC_TITLE) ;
	}
	
	/**
	 * 
	 * initAndHandle:初始化并且生成代码. <br/>
	 *
	 * @author xiyang
	 * @param testPath
	 * @param desPath
	 * @throws IOException
	 * @since JDK 1.6
	 */
	public static void initAndHandle(String testPath, String desPath) throws IOException {
		Map<String,File> mp3Files = FileRead.readFileListByPathWithSuffix(testPath, MP3_SUFFIX) ;
		Map<String,File> jsonFiles = FileRead.readFileListByPathWithSuffix(testPath, JSON_SUFFIX) ;
//System.out.println("-->\n" + mp3Files);
//System.out.println("-->\n" + jsonFiles);
		Set<String> mp3Keys = mp3Files.keySet();
//System.out.println("\n\nmp3Keys-->"+mp3Keys);
		File mp3FileTmp = null ;
		File jsonFileTmp = null ;
		
		int count = 0 ;
		for (String key : mp3Keys) {
			mp3FileTmp = mp3Files.get(key) ;
			jsonFileTmp = jsonFiles.get(key) ;
//System.out.println("mp3FileTmp-->"+mp3FileTmp);
//System.out.println("jsonFileTmp-->"+jsonFileTmp);
			if(null!=mp3FileTmp 
			  && null!=jsonFileTmp) {
				handleMp3AndLyric(desPath, jsonFileTmp.getPath(), mp3FileTmp.getPath());
				count++ ;
			}
		}
System.out.println("----->共处理生成【"+count+"】个文件!"+"-->忽略["+(mp3Files.size()-count)+"]个文件！");
	}

	/**
	 * 
	 * handleMp3AndLyric: 生成歌词和代码文件. <br/>
	 *
	 * @author xiyang
	 * @param desPath
	 * @param ircJsonFromFilePath
	 * @param mp3FromFilePath
	 * @throws IOException
	 * @since JDK 1.6
	 */
	public static void handleMp3AndLyric(String desPath, String ircJsonFromFilePath, String mp3FromFilePath)
			throws IOException {
		File file = new File(ircJsonFromFilePath) ;
		JSONObject ircJson = readFileAndGetJSON(ircJsonFromFilePath);
		String desTitle = (String) ircJson.get("title") 
						   + "_" + getFileNameWithoutSuffix(file) ;  //拷贝文件名
		
		desTitle = replaceTitileSpacialSymbol(desTitle);
		
		String ircTitle = desTitle + ".lrc" ;
		
		String mp3Title = desTitle + ".mp3" ;
		
//System.out.println("lyric tile--> " + ircTitle) ;
//System.out.println("mp3   tile--> " + mp3Title) ;
//		System.out.println("jsonData-->\n"+ircJson) ;
		String transFileContent = generateIrcByJson(ircJson) ;
		String lyricDesPathAndTitle = desPath+ircTitle ;
		String mp3DesPathAndTitle = desPath+mp3Title ;
//System.out.println("lyricDesTitle-->"+lyricDesPathAndTitle);
//System.out.println("lyricDesTitle-->"+mp3DesPathAndTitle);
//		FileWrite.fileWritter2Local(lyricDesPathAndTitle, transFileContent); //写文件
		FileWrite.fileWritter2LocalSetEncoding(lyricDesPathAndTitle, transFileContent, "GBK");
		FileCopy.copyFileByApacheCommonIO(new File(mp3FromFilePath), new File(mp3DesPathAndTitle));
//System.out.println("----文件操作完成---");
	}

	/**
	 * 
	 * replaceTitileSpacialSymbol: 替换特殊字符. <br/>
	 * \ / : * ?"< > | 空格
	 * @author xiyang
	 * @param desTitle
	 * @return
	 * @since JDK 1.6
	 */
	public static String replaceTitileSpacialSymbol(String desTitle) {
		String[] specialSymbols = {"\\", "/", " ",":", "*", "?", "<", ">", "|" } ;
		
		for (String tmpSymbol : specialSymbols) {
			desTitle = desTitle.replace(tmpSymbol, "_") ;
		}
		return desTitle;
	}

	/**
	 * 
	 * readFileAndGetJSON:读取JSON文件并且返回JSONObject数据. <br/>
	 *
	 * @author xiyang
	 * @param testJsonFile
	 * @return
	 * @throws IOException
	 * @since JDK 1.6
	 */
	private static JSONObject readFileAndGetJSON(String testJsonFile) throws IOException {
		List<String> strList = readFileDataByJDK7(new File(testJsonFile)) ;
		System.out.println("----------======Json文件内容======---------");
		
		StringBuffer jsonFileData = new StringBuffer() ; //Json值
		
		for (String tmp : strList) {
			jsonFileData.append(tmp) ;
//			System.out.println(tmp);
		}		
		JSONObject ircJson = JsonConvert.transJsonObject(jsonFileData.toString()) ;
		return ircJson;
	}
	
	//--文件后缀
	public static String MP3_SUFFIX = "mp3" ;
	public static String JSON_SUFFIX = "json" ;
	public static String IRC_SUFFIX = "lrc" ;
	
	
	//---------===========Test===========-------------
	
	public static void main(String[] args) throws IOException {
		
		String realSrcPath = "F:/English_Keke/com.kekeclient_/files/mp3" ; //--with mp3s and Json lyrics
		
		String testPath = "F:/English_Keke/com.kekeclient_/files/test" ;		
		String desPath = "F:/English_Keke/com.kekeclient_/files/copy_test/" ;
		
		initAndHandle(testPath, desPath);
//		initAndHandle(realSrcPath, desPath);
	}
}

