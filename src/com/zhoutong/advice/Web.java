package com.zhoutong.advice;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhoutong.model.Xiangmu;
import com.zhoutong.service.CompanyTemplate;
import com.zhoutong.service.XiangmuTemplate;
import com.zhoutong.util.Encrypt;

@Controller
@Scope("prototype")
@RequestMapping("/")
public class Web {
	
	private static Logger logger = Logger.getLogger(Web.class);
	private final static String DATABASE ="DB_INFO  ";
	private final static String PROCESS ="PROCESS  ";
	
	@Resource(name="companyService")
	public CompanyTemplate companyService;
	
	@Resource(name="xiangmuService")
	public XiangmuTemplate xiangmuService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String next(HttpServletRequest request){
		return "index";
	}
	/**
	 * @param np   name&password encrypt
	 *  cookie encrypt{name:up##,value:username+"###"+password}
	 */
	@ResponseBody
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public String login(@RequestParam(value="username",required=true)String username,@RequestParam(value="password",required=true)String password,@RequestParam(value="rem",required=false)String rem,HttpServletResponse response){
		Xiangmu x=null;
		logger.info(DATABASE+username+DATABASE+password+DATABASE+rem);
		x=xiangmuService.getX(username,password);
		//setCookie
		if(x!=null&&null!=rem){
			Cookie cookie=null;
			cookie=new Cookie("up##",Encrypt.encrypt(username+"###"+password));
			cookie.setMaxAge(2*60*60);
			response.addCookie(cookie);
			logger.info(PROCESS+"write Cookie");
			return "view";
		}
		if(null==x){
			return "false";
		}else{
			return "view";
		}
	}
	
	@RequestMapping(value="/view")
	public String view() {
		return "model";
	}
	
	@RequestMapping(value="/")
	public void ind(HttpServletRequest request,HttpServletResponse response){
		try {
			logger.info("redirect to index from url '/'");
			response.sendRedirect(request.getContextPath()+"/index");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}