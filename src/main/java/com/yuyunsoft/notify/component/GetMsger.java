package com.yuyunsoft.notify.component;


import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
import com.yuyunsoft.notify.config.MsgConfig;

/**
 * 
 * 创建人:黄小云
 * 创建时间: 2017年9月5日 下午4:14:42
 * 版本号:1.0
 * 说明:消息接收者，专门用于从队列中进行消息的接收
 * 
 *
 */
@Component
@RabbitListener(queues = MsgConfig.QUEUE)
public class GetMsger {

	private RabbitTemplate rabbitTemplate;  
	
	private static final Logger logger = LoggerFactory.getLogger(GetMsger.class);
	  
    /**  
     * 构造方法注入  
     */  
    @Autowired  
    public GetMsger(RabbitTemplate rabbitTemplate) {  
        this.rabbitTemplate = rabbitTemplate;  
    }  
    
    /**
     * 接收消息
     * @param content
     */
    @RabbitHandler
    public void process(String msg) {
    	logger.info("接收消息【" + msg  + "】ok.");
    }
    
}
