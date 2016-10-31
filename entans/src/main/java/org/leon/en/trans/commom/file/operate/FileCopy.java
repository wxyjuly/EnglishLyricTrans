/**
 * Project Name:KeKeEnglishDownloadFileTransFer
 * File Name:FileCopy.java
 * Package Name:org.leon.en.trans.commom.file
 * Date:2016年8月18日上午10:42:32
 * Copyright (c) 2016, xiyang@asiainfo.com All Rights Reserved.
 *
*/

package org.leon.en.trans.commom.file.operate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;

/**
 * ClassName:FileCopy <br/>
 * Function: 文件拷贝. <br/>
 * Date:     2016年8月18日 上午10:42:32 <br/>
 * @author   xiyang
 * @version  v1.0
 * @since    JDK 1.6
 * @see 	 http://my.oschina.net/biezhi/blog/486030[reference] 
 * 
 * @test Result
 * ---------------------------------------------------------
 * Time taken by FileStreams Copy = 127572360
 * Time taken by FileChannels Copy = 10449963
 * Time taken by Java7 Files Copy = 10808333
 * Time taken by Apache Commons IO Copy = 17971677
 * ---------------------------------------------------------
 */
public class FileCopy {

	/**
	 * copyFileByFileStreams:FileStreams. <br/>
	 * 
	 * 1. 使用FileStreams复制:
	 * 	      这是最经典的方式将一个文件的内容复制到另一个文件中。 使用FileInputStream读取文件A的字节，使用FileOutputStream写入到文件B
	 * 
	 * @author xiyang
	 * @param srcFile
	 * @param desPath
	 * @return
	 * @throws Exception
	 * @since JDK 1.6
	 */
	public static boolean copyFileByFileStreams(File srcFile, File desFile)  throws Exception{
		InputStream input = null ;
		OutputStream output = null ;
		try {
			input = new FileInputStream(srcFile) ;
			output = new FileOutputStream(desFile) ;
			byte[] buffer = new byte[1024] ;
			int bytesRead ;
			while((bytesRead = input.read(buffer))>0) {
				System.out.println(buffer);
				output.write(buffer, 0, bytesRead);
			}
			return true;
		} finally {
			if(null!=input){
				input.close();
			}
			if (null != output) {
				output.close();
			}
			System.out.println("Copy success....");
		}
	}
	
	/**
	 * 
	 * copyFileByFileChannel:Java NIO 拷贝文件. <br/>
	 *
	 * @author xiyang
	 * @param srcFile
	 * @param desFile
	 * @throws IOException
	 * @since JDK 1.6
	 */
	public static void copyFileByFileChannel(File srcFile, File desFile) throws IOException {
		FileChannel inputChannel  ;
		FileChannel outputChannel ;
		inputChannel = new FileInputStream(srcFile).getChannel() ;
		outputChannel = new FileOutputStream(desFile).getChannel() ;
		try {
			outputChannel.transferFrom(inputChannel, 0, inputChannel.size()) ;
		} finally {
			if(null!=inputChannel){
				inputChannel.close();
			}
			if (null != outputChannel) {
				outputChannel.close();
			}
			System.out.println("Channel Copy success...");
		}
		
	}
	/**
	 * 
	 * copyFileByApacheCommonIO:通过Apache Commons FileUtils类，中IO来实现拷贝. <br/>
	 * Apache Commons IO提供拷贝文件方法在其FileUtils类,可用于复制一个文件到另一个地方。
	 * 它非常方便使用Apache Commons FileUtils类时,您已经使用您的项目。基本上,这个类使用Java NIO FileChannel内部
	 * @author xiyang
	 * @param srcFile
	 * @param desFile
	 * @throws IOException
	 * @since JDK 1.6
	 */
	public static void copyFileByApacheCommonIO(File srcFile, File desFile) throws IOException {
		FileUtils.copyFile(srcFile, desFile);
		System.out.println("Copy success...");
	}
	
	/**
	 * 
	 * copyFileByJDK7:[4. 使用Java7的Files类复制.] <br/>
	 * 如果你有一些经验在Java 7中你可能会知道,可以使用复制方法的Files类文件,从一个文件复制到另一个文件。
	 * @author xiyang
	 * @param srcFile
	 * @param desFile
	 * @throws IOException
	 * @since JDK 1.7
	 */
	public static void copyFileByJDK7(File srcFile, File desFile) throws IOException {
		Files.copy(srcFile.toPath(), desFile.toPath()) ;
	}
	
	public static void main(String[] args) throws Exception {
		String srcFilePath = "F:/English_Keke/com.kekeclient_/files/test/336544.json" ;
		String desFilePath = "F:/English_Keke/com.kekeclient_/files/copy_test/赖世雄英语_336544.Json" ;
		
		File srcFile = new File(srcFilePath)  ;
		File desFile = new File(desFilePath)  ;
		
//		copyFileByFileStreams(srcFile, desFile) ;
		
//		copyFileByFileChannel(srcFile, desFile);
		
//		copyFileByApacheCommonIO(srcFile, desFile);
		copyFileByJDK7(srcFile, desFile);
		
	}



}

