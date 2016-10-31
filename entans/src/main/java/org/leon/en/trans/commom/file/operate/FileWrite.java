/**
 * Project Name:KeKeEnglishDownloadFileTransFer
 * File Name:FileOperate.java
 * Package Name:org.leon.en.trans.commom
 * Date:2016年8月17日下午5:30:38
 * Copyright (c) 2016, xiyang@asiainfo.com All Rights Reserved.
 *
*/

package org.leon.en.trans.commom.file.operate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.leon.en.trans.commom.LyricConst;
import org.leon.en.trans.commom.file.json.JsonConvert;

/**
 * ClassName:FileWrite <br/>
 * Function: 写文件. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月17日 下午5:30:38 <br/>
 * @author   xiyang
 * @version  v1.0
 * @since    JDK 1.6
 * @see 	 
 */
public class FileWrite {
	
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
	public static List<File> readFileListByPathWithSuffix(Object obj, String suffix){
		
		File dir = null ;
		List<File> fileList = new ArrayList<File>() ;
		if(obj instanceof File){	//文件
			dir = (File) obj ;
		} else {	//路径
			dir = new File(obj.toString()) ;
		}
		if(dir.isFile()) {
			if(isAccept(dir, suffix)){
				fileList.add(dir) ;
printFileInfo(dir) ;
			}
			return fileList ;
		} else if(dir.isDirectory()) {
			File[]	fileArr	= dir.listFiles() ;
			for (File file : fileArr) {
				fileList.addAll(readFileListByPathWithSuffix(file, suffix)) ;
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
		return file.getName().endsWith(suffix);
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
	
	//---------===========Test===========-------------
	
	public static void main(String[] args) throws IOException {
		String srcPath = "F:/English_Keke/.keke/json" ;
		String testPath = "F:/English_Keke/com.kekeclient_/files/test" ;
		
		String ircJsonFromFilePath = "F:/English_Keke/com.kekeclient_/files/test/336544.json" ;
		
		String mp3FileFromPath = "" ;
		
//		String suffix = "mp3" ;
//		File file = new File(srcPath) ;
//		List<File> fileList = FileOperate.readFileByPath(file) ;
//		System.out.println(fileList);
//		List<File> fileTestList = FileRead.readFileListByPathWithSuffix(testPath, suffix) ;
		
		File file = new File(ircJsonFromFilePath) ;
		
		JSONObject ircJson = readFileAndGetJSON(ircJsonFromFilePath);
		
		String desTitle = (String) ircJson.get("title") 
						   + "_" + getFileNameWithoutSuffix(file) ;  //拷贝文件名
		
		String ircTitle = desTitle + ".Irc" ;
		
		String mp3Title = desTitle + ".mp3" ;
		
System.out.println("lyric tile--> " + ircTitle) ;
System.out.println("mp3   tile--> " + mp3Title) ;
//		System.out.println("jsonData-->\n"+ircJson) ;
		String transFileContent = generateIrcByJson(ircJson) ;
		
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
	
	/**
	 * 
	 * FileWritter2Local:写内存-内容到本地. <br/>
	 *
	 * @author xiyang
	 * @param filePathAndName
	 * @param fileContent
	 * @throws IOException 
	 * @since JDK 1.6
	 */
	public static void fileWritter2Local(String filePathAndName, String fileContent) throws IOException {
		FileWriter fw = new FileWriter(filePathAndName) ;
		
		fw.write(fileContent);
		fw.flush();
		fw.close();
System.out.println("------文件写入完成------");
	}
	
	/**
	 * 
	 * fileWritter2LocalSetEncoding: 写内存-内容到本地；使用编码 <br/>
	 *
	 * @author xiyang
	 * @param filePathAndName
	 * @param fileContent
	 * @param outputEncoding
	 * @throws IOException
	 * @since JDK 1.6
	 */
	public  static void fileWritter2LocalSetEncoding(String filePathAndName, String fileContent,String outputEncoding) throws IOException {

		CharsetEncoder encoder = Charset.forName(outputEncoding).newEncoder();
		encoder.onMalformedInput(CodingErrorAction.REPORT);
		encoder.onUnmappableCharacter(CodingErrorAction.REPORT);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePathAndName),encoder));
		out.write(fileContent);
		out.flush();
		out.close();
	}
	
	
}

