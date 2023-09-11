package org.example;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;

//import org.dom4j.io.SAXReader;
public class Dome4j_ {


    /**
     * 演示如何加载xml文件
     */
    @Test
    public void loadXml() throws DocumentException {
//        得到一个解析器
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("C:\\Users\\chai0\\IdeaProjects\\hspedu_xml\\src\\main\\java\\org\\example\\students.xml"));
//        System.out.println(document);

    }
}






