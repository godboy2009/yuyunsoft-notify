package com.yuyunsoft.notify.thread;
 
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yuyunsoft.notify.component.SendMsger;

/**
 * 
 * 创建人:黄小云
 * 创建时间: 2017年9月5日 下午4:18:57
 * 版本号:1.0
 * 说明:该线程专门负责发送消息
 * 
 *
 */
@Component
public class MsgHandlerThread implements Runnable {
	private Logger logger = Logger.getLogger(MsgHandlerThread.class);
	
	@Autowired
	private  SendMsger sender;
	
	@Override
	public void run() {
		int i = 1;
		while(true) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 
			String msg = "用户" + i + "在" + sdf.format(date) + "时发送了一条消息";
		 	sender.sendMsg(msg);
			logger.info("发送消息【" + msg + "】 ok.");
			if (i>=10000) 
				i = 1;
			else	
				i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { 
				logger.error(e.getMessage());
			}
		}		
	}

}
