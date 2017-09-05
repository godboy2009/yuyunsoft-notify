package com.yuyunsoft.notify.component;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yuyunsoft.notify.thread.MsgHandlerThread;
 
/**
 * 
 * 创建人:黄小云
 * 创建时间: 2017年9月5日 下午4:15:41
 * 版本号:1.0
 * 说明:初始化启动一个线程来测试消息发送和接收
 *
 *
 */
@Component
public class InitMsgLoader {
	
	@Autowired 
	MsgHandlerThread msgHandlerThread;
	
	private Logger logger = Logger.getLogger(InitMsgLoader.class); 
	
	@PostConstruct
	public void init() {  
 
		Thread t1 = new Thread(msgHandlerThread);   
	    t1.start(); 
 
	    logger.debug("初始化成功");
	}
}
