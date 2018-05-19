package com.zhoutong.util;

import java.util.Random;

public class Encrypt {
	/**
	 *@author hahazhoutie4
	 *@website cnblogs.com/hahazhoutie4-blogs/
	 */
	public static String encrypt(String s){
		int a=new Random().nextInt(1)*14+1;
		int length=s.length();
		String buf="";
		for (int i = 0; i < length; i++) {
	        String x = Integer.toHexString(s.charAt(i) ^ a);
	        if (x.length() == 1)
	            x = "000" + x;
	        else if (x.length() == 2)
	            x = "00" + x;
	        else if (x.length() == 3)
	            x = "0" + x;
	        buf += x;
	    }
		return Integer.toHexString(a)+buf;
	}
	public static String decrypt(String c) {
		int length=c.length();
		int f=length%4;
		String ox=c.substring(0,f);
		int a=Integer.valueOf(ox,16);
		String next=c.substring(f);
		String buf="";
		for(int i=0;i<length/4;i++) {
			String oo=next.substring(i*4, i*4+4);
			String e="";
			if(oo.contains("000")) {
				e=oo.split("000")[1];
			}else if(oo.contains("00")) {
				e=oo.split("00")[1];
			}else {
				e=oo.split("0")[1];
			}
			int l=Integer.valueOf(e,16);
			buf+=(char)(l^a);
		}
	return buf;	
	}
}

