package com.kh.api.util;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParsing {

	public static void main(String[] args) {
		String serviceKey="UNmnLkcNtzgMKivBzvyb3TdrsqmthwquJWOHYpkKXK6aXtSdhG1gbTQ6EOqATL5t3ApCJ2hySkej4pCTXuaAZg%3D%3D";
		String url = "http://apis.data.go.kr/6260000/FoodService/getFoodKr?serviceKey=" + serviceKey + "&numOfRows=396";
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(url);
			
			doc.getDocumentElement().normalize();
			System.out.println(doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("item"); // <item>태그별로 나눔
			System.out.println("파싱할 데이터 수 : " + nList.getLength()); // 396 (리스트 개수)
			
			for(int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("MAIN_TITLE : " + getTagValue("MIN_TITLE", eElement));
					System.out.println("ADDR1 : " + getTagValue("ADDR1", eElement).trim()); // trim : 앞 뒤로 공백 제거
					System.out.println("------------------------------------");
	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getTagValue(String tag, Element eElement) {
		NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = nList.item(0);
		if(nValue == null) return null;
		return nValue.getNodeValue();
	};
	

}
