package com.yuyunsoft.notify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * 创建人:黄小云
 * 创建时间: 2017年9月5日 下午4:14:05
 * 版本号:1.0
 * 说明:spring-boot启动类
 * 
 *
 */
@SpringBootApplication
public class YuyunsoftNotifyApplication {

	private static final Logger logger = LoggerFactory.getLogger(YuyunsoftNotifyApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(YuyunsoftNotifyApplication.class, args);
		
		logger.info("spring boot启动成功");
		
	} 
	 
}
