package com.yuyunsoft.notify.component;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yuyunsoft.notify.config.MsgConfig;

/**
 * 
 * 创建人:黄小云
 * 创建时间: 2017年9月5日 下午4:15:41
 * 版本号:1.0
 * 说明:消息发送者，专门用于将消息发送到队列
 *
 *
 */
@Component
public class SendMsger  implements RabbitTemplate.ConfirmCallback {
	
	 	private RabbitTemplate rabbitTemplate;  
	  
	 	private static final Logger logger = LoggerFactory.getLogger(SendMsger.class);
	 	
	    
	    @Autowired  
	    public SendMsger(RabbitTemplate rabbitTemplate) {  
	        this.rabbitTemplate = rabbitTemplate;  
	    }  
	  
	    public void sendMsg(String content) {  
	        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());  
	        rabbitTemplate.convertAndSend(MsgConfig.EXCHANGE, MsgConfig.ROUTINGKEY, content, correlationId);  
	    }

		@Override
		public void confirm(CorrelationData correlationData, boolean ack, String cause)  {
			logger.info("回调id:" + correlationData);  
	        if (ack) {  
	        	logger.info("消息成功消费");  
	        } else {  
	        	logger.info("消息消费失败:" + cause);  
	        }
		}
	  
}
