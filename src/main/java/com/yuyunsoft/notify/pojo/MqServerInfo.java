package com.yuyunsoft.notify.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * 创建人:黄小云
 * 创建时间: 2017年9月5日 下午4:18:21
 * 版本号:1.0
 * 说明: 根据前缀mq,从配置文件中获取对应的配置文件存储到pojo类
 * 
 *
 */
@Component
@ConfigurationProperties(prefix="mq")
public class MqServerInfo {
	 private String host;  
	    
	    private String port;    
	 
	    private String username;   
	    
	    private String password;    
	   
	    private String vhost;   
	    
	    public String getHost() {
			return host;
		}


		public void setHost(String host) {
			this.host = host;
		}


		public String getPort() {
			return port;
		}


		public void setPort(String port) {
			this.port = port;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getVhost() {
			return vhost;
		}


		public void setVhost(String vhost) {
			this.vhost = vhost;
		}
}
