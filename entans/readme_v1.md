#可可英语手机下载音频批量处理小工具
&copy; 惊叹号荣誉出品
##缘由及目的：
1.	学习英语中，发现了《赖世雄美语重头学》不错，可可英语有完整版。
无奈可可英语APP支持的模式不都。遂打算将文件生成Aboboo然后批量倒入到系统中。
2.	后续可可英语的优质，感兴趣资料均会进行一次处理。
3.	同时可以加强自己的编程和处理问题的能力，一举输得，何乐不为？

------------------------------------------------------------


## 使用说明[Usage]

###**1. Usage by User** 

*   将文件与Json目录复制到指定目录下：目前默认指向目录。
*   执行该文件【】--完成转换。
*	默认输入目录：
*	默认输出目录：

###**2. Usage by admin** 

*	修改默认输入输出文件，在kekeconf.property文件修改
	
** 修改值**：
*	NPUT_PATH=xxxx
*	OUTPUT_PATH=xxx



------------------------------------------------------------



## 功能清单 && APIs

1.  readFileList:	批量读取同一目录下所有文件<将所有文件名称放到（List<Map<String,File>中）>
2.  handleFiles:	依次遍历,循环处理每个文件.

###	getJson：获取文件信息



###	【生成Irc字幕文件】


####	generateIrcFile:
	
*	readFile:	读取字幕文件Json文件;
*	transFile:	转换成中英文字幕[处理Irc文件];
*	dataOutput:	输出字幕文件。

###		genereateAudioFile【copy生成音频文件-->重命名文件】
*	readFile:	读取文件
*	transFile:	处理Mp3【获取文件名，Json中；然后copy】
*	dataOutput:	生成文件。


###		mixTrans[混合处理]


#### [重复以上步骤，遍历文件，完成功能]	

---

 
 
#Part II  Design software[OOAD]#

##Design Object And Class 
 
###
	1.	FileOperate.java
	
	2.	IOperate.java
		-->操作过程封装
	
	3. IrcOperate 	--> IOperate	
	
	4. AudioOperate --> IOperate
		
	5. IFactory	-->	
	
	6. 
	
	
	
	
 