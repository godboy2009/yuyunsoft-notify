package com.yuyunsoft.notify.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.config.ConfigurableBeanFactory; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 
import org.springframework.context.annotation.Scope; 
import com.yuyunsoft.notify.pojo.MqServerInfo;
 
 /**
  * 
  * 创建人:黄小云
  * 创建时间: 2017年9月5日 下午4:17:20
  * 版本号:1.0
  * 说明:消息服务器配置，专门用于从配置文件中读取有关连接rabbitmq消息服务器的ip地址、端口、用户名及密码等信息
  * 
  *
  */
@Configuration  
public class MsgConfig {  
  
    public static final String EXCHANGE   = "yuyunsoft-mq-exchange";  
    public static final String ROUTINGKEY = "yuyunsoft-mq-routingKey";  
    public static final String QUEUE = "yuyunsoft-mq-queue";  
    
    @Autowired
    private MqServerInfo mqServerInfo;
   

	@Autowired
    private ConnectionFactory connectionFactory; 
	
    @Bean  
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {  
        RabbitTemplate template = new RabbitTemplate(getConnectionFactory());  
        return template;  
    }  
    
    @Bean  
    public Binding binding() {  
        return BindingBuilder.bind(getQueue()).to(defaultExchange()).with(MsgConfig.ROUTINGKEY);  
    }    
  
   
    @Bean  
    public DirectExchange defaultExchange() {  
        return new DirectExchange(EXCHANGE);  
    }  
  
    @Bean  
    public Queue getQueue() {  
        return new Queue(MsgConfig.QUEUE, true);  
  
    }  
  

    @Bean  
    public ConnectionFactory getConnectionFactory() {  
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();  
        connectionFactory.setAddresses(mqServerInfo.getHost() + ":" + mqServerInfo.getPort());  
        connectionFactory.setUsername(mqServerInfo.getUsername());  
        connectionFactory.setPassword(mqServerInfo.getPassword());  
        connectionFactory.setVirtualHost(mqServerInfo.getVhost());  
        connectionFactory.setPublisherConfirms(true);  
        return connectionFactory;  
    }  
    
}  