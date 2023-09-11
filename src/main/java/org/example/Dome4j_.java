package org.example;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.List;

//import org.dom4j.io.SAXReader;
public class Dome4j_ {


    /**
     * 演示如何加载xml文件
     */
    @Test
    public void loadXml() throws DocumentException {
//        得到一个解析器
//        document对象解析
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/main/java/org/example/students.xml"));
//        System.out.println(document);
//

    }

    /**
     * 遍历所有student信息
     */
    @Test
    public void listStus() throws DocumentException {
        //        得到一个解析器
//        document对象解析
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/main/java/org/example/students.xml"));
//        得到rootelement
        Element rootElement = document.getRootElement();
//        拿到rootelement下的stuednety
        List<Element> student = rootElement.elements("student");
//        System.out.println(student.size());   2
//        开始获取两个元素的name等属性
        for (Element studentElement : student){
//获取studentElement的name Element
            Element name = studentElement.element("name");
            Element gender = studentElement.element("gender");
            System.out.println(name.getText());
            System.out.println(gender.getText());
        }
    }
}






