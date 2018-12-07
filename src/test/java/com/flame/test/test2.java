package com.flame.test;

import java.io.File;

import org.junit.Test;

import com.zhiyun.util.AppendToFile;
import com.zhiyun.util.ReadFromFile;
import com.zhiyun.util.ZipUtil;

public class test2 {

	
	
	@Test
	public void zip() {
		try {
			File zipFile = new File("C:\\Users\\Administrator\\Desktop\\123.zip");
			ZipUtil.unzip(zipFile, "C:\\Users\\Administrator\\Desktop\\unzip\\");
			System.out.println("!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void read() {
		try {
			ReadFromFile.readFileByLines("C:\\Users\\Administrator\\Desktop\\unzip\\qqq.txt");
			System.out.println("!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void write() {
		try {
			AppendToFile.appendMethodB("C:\\Users\\Administrator\\Desktop\\unzip\\aa.html", "<!DOCTYPE html><html><head></head><body></body></html>");
			System.out.println("!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void asdsa() {
		try {
			String aaa = "ddddda${asd!}wdqwdqw<sad>sadsa</dqwd>asda";
			aaa = aaa.replaceAll("\\$.*?}", "");
			System.out.println(aaa);
			
			String a = "0123456";
			System.out.println(a.substring("012".length()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
