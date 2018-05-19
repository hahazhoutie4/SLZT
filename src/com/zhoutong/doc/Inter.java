package com.zhoutong.doc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.tools.ant.taskdefs.Input;

public  class Inter {
	
	private String url;
	public Inter(String url){
		this.url=url;
	}
	
	private String login(){
		return "";
	}
	
	private void connect(){
		try {
			URL u=new URL(url);
			HttpURLConnection http=(HttpURLConnection)u.openConnection();
			http.setRequestMethod("POST");
			http.setDoOutput(true);
			http.setRequestProperty("Referer", "http://120.27.16.210/?g=Doc&m=Login&a=index&back_url=Lw==");
			http.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:57.0) Gecko/20100101 Firefox/57.0");
			OutputStream out=http.getOutputStream();
			out.write(("back_url=Lw==,account="+URLEncoder.encode("工业经理部","utf-8")+",passwd=gyjlb2018").getBytes());
			int code = http.getResponseCode();
			BufferedReader reader=new BufferedReader(new InputStreamReader(http.getInputStream()));
			String buf="";
			while(reader.readLine()!=null){
				buf+=reader.readLine()+"\r\n";
			}
			System.out.println(buf);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Inter i=new Inter("http://120.27.16.210/?g=Doc&m=Login&a=index&back_url=Lw==");
		i.connect();
	}
	
}
