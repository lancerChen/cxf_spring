package com.testxml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

/**
 * @name:
 * @author:liangxian.chen@hand-china.com
 * @date: Created in 11:47 2018/02/06
 * @Modified By:
 * @description：
 */
public class DomXML {
    public static void main(String[] args){

        String xmlString = "<root><people>APPLE</people></root>";
        try {
            Document document = DocumentHelper.parseText(xmlString);
            System.out.println(document.asXML());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
