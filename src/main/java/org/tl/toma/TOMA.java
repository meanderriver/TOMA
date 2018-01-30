package org.tl.toma;

import org.mybatis.spring.annotation.MapperScan;
import org.spring.springboot.dubbo.ConsumerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.tl.toma.advanced.AdvancedProducer;


@SpringBootApplication
@ComponentScan
@MapperScan("org.tl.toma.mapper")
public class TOMA {

	public static void main(String[] args) {
		  SpringApplication.run(TOMA.class, args);
	}
}
