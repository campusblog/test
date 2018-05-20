package com.java.util;

import java.security.MessageDigest;
import java.util.Scanner;

/**
 * 比较简单的MD5加密工具类
 * @Description TODO 
 * @author 刘凯
 * @date 2018年5月15日:上午11:14:54
 * @Package com.java.util
 * @Project crm
 * @ClassName MD5.java
 * @since   JDK1.8
 * @version 1.0
 */
public class MD5 {
	 public final static String MD5(String s)  
	    {  
	        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
	        try  
	        {  
	            byte[] strTemp=s.getBytes();  
	            MessageDigest mdTemp=MessageDigest.getInstance("MD5");  
	            mdTemp.update(strTemp);  
	            byte[] md=mdTemp.digest();  
	            int j=md.length;  
	            char str[]=new char[j * 2];  
	            int k=0;  
	            for(int i=0;i<j;i++)  
	            {  
	                byte byte0=md[i];  
	                str[k++]=hexDigits[byte0 >>> 4 & 0xf];  
	                str[k++]=hexDigits[byte0 & 0xf];  
	            }  
	            return new String(str);
	        }catch(Exception e)  
	        {  
	            return null;
	        }  
	    }
	 
	public static void main(String[] args) {
		System.out.println("123456加密后");
		System.out.println(MD5("123456"));
		System.out.println("请输入要加密的文本：");
		Scanner scanner=new Scanner(System.in);
		String iString=scanner.next();
		System.out.println("加密后的文本："+MD5(iString));
	}
}
