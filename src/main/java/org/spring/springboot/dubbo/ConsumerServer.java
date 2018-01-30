package org.spring.springboot.dubbo;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tl.toma.mapper.DubboMapper;
import org.tl.toma.usermodel.Usermodel;

import com.alibaba.dubbo.config.annotation.Reference;


@Component
public class ConsumerServer {

	@Reference(version = "1.0.0")
    DubboMapper servermapper;
	
	public Usermodel clientshow() {
		Usermodel user=servermapper.dubbo();
			return user;
		
	}
	
}
