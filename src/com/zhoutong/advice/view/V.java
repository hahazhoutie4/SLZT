package com.zhoutong.advice.view;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhoutong.service.CompanyTemplate;
import com.zhoutong.service.XiangmuTemplate;

/**
 *  excel.htmlҳ���²���
 * @author zhoutong
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/view")
public class V {
	@Resource(name="xiangmuService")
	private XiangmuTemplate xiangmuTemplate;
	@Resource(name="companyService")
	private  CompanyTemplate companyTemplate;
	@ResponseBody
	@RequestMapping("/web")
	public String web(@RequestParam(value="url",required=false)String url,HttpSession session){
		Document doc = null;
		try {
			doc = Jsoup.connect(URLDecoder.decode(url,"utf-8")).get();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(null!=doc){
			session.setAttribute(url, doc);
		return doc.html();
		}
		return "";
	}
	@RequestMapping("/v")
	public String vi(@RequestParam(value="vi",required=false)String vi){
		return "";
	}
}