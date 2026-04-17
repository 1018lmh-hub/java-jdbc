package com.kh.keeper.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kh.keeper.view.KeeperView;

public class KeeperRun {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		prop.setProperty("A", "B");
		
		try {
			// xml 설명
			//http://java.sun.com/dtd/properties.dtd dtd가 하는 일 유효성 검사 
			//<properties> properties 여는테그 </properties> properties 닫는테그 <- 둘이 합쳐서 properties 요소
			// <comment>MEMBER SQL</comment> 사이에 있는 MEMBER SQL comment 이건 요소의 콘텐트영역
			//<entry key="A"> key <- entry 요소의 key 속성, "A" <- entry 요소의 key 속성값
			/*
			  <properties>
			  <comment>MEMBER SQL</comment>
			  <entry key="A">B</entry>
		 	  </properties>
		 	  properties 가 부모요소, comment entry 가 자식요소
			 */
			// 부모요소 안에 있는 자식 요소는 위치 자유롭게 가능
			prop.storeToXML(new FileOutputStream("member-mapper.xml"), "MEMBER SQL");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		KeeperView kv = new KeeperView();
		kv.mainMenu();
		
//		new KeeperView().mainMenu();

	}

}
