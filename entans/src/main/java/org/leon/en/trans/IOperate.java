/**
 * Project Name:KeKeEnglishDownloadFileTransFer
 * File Name:IOperate.java
 * Package Name:org.leon.en.trans
 * Date:2016年8月17日下午5:11:41
 * Copyright (c) 2016, xiyang@asiainfo.com All Rights Reserved.
 *
*/

package org.leon.en.trans;

import java.io.File;

/**
 * ClassName:IOperate <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年8月17日 下午5:11:41 <br/>
 * @author   xiyang
 * @version  v1.0
 * @since    JDK 1.6
 * @see 	 
 */
public interface IOperate {
	
	boolean readFiles(String srcPath);
	
	boolean transFile(File file);
	
	boolean dataOutput(String desPath,	File file);
	
	
}

