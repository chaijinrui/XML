package org.example;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

//import org.dom4j.io.SAXReader;
//解析xml

/**
 * 获得标签 通常分为以下几个步骤
 * 1. 通过saxreader解析文件
 * 2. 再获取Document节点→再获取下一层级标签→一直往下获取标签→最后拿到目标标签的文本
 */
public class Dome4j_ {


    /*
     * 演示如何加载xml文件

     */
    @Test
    public void loadXml() throws DocumentException {
//        得到一个解析器
//        document对象解析
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/main/java/org/example/students.xml"));
//        System.out.println(document);

    }

    /*
     * 遍历所有student信息
     */
    @Test
    public void listStus() throws DocumentException {
        //        得到一个解析器
//        document对象解析
        SAXReader saxReader = new SAXReader();
//        src/main/java/org/example/students.xml 仓库根路径
        Document document = saxReader.read(new File("src/main/java/org/example/students.xml"));
//        得到rootelement
        Element rootElement = document.getRootElement();
//        拿到rootelement下的stuednety
        List<Element> student = rootElement.elements("student");
//        System.out.println(student.size());   2
//        开始获取两个元素的name等属性
        for (Element studentElement : student) {
//获取studentElement的name Element
            Element name = studentElement.element("name");
            Element gender = studentElement.element("gender");
            System.out.println(name.getText());
            System.out.println(gender.getText());
        }
    }

    /*
     * 指定读取第一个学生的信息 就是 dom4j+xpath
     */
    @Test
    public void firstStus() throws DocumentException {
//        解析xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/main/java/org/example/students.xml"));
//        得到rootelement
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement.elements().get(1).getClass().getSimpleName());
        Element stduent = (Element) rootElement.elements().get(0);
//        再往下一层获取name标签
        Element name = stduent.element("name");
//        最后获取name的文本
        System.out.println(name.getText());
//        获取标签属性
        System.out.println(stduent.attributeValue("id"));
    }

    /**
     * 下面的了解一下就行
     */

    /*
     * //删除元素(要求：删除第一个学生) 使用少，了解
     *
     * @throws Exception
     */
    @Test
    public void del() throws Exception {
        //1.得到解析器
        SAXReader saxReader = new SAXReader();
        //2.指定解析哪个xml文件
        Document document = saxReader.read(new File("src/main/java/org/example/students.xml"));
        //找到该元素第一个学生
        Element stu = (Element) document.getRootElement().elements("student").get(0);
        //删除元素
        stu.getParent().remove(stu);
//        //删除元素的某个属性
//        stu.remove(stu.attribute("id"));
        //更新xml
        //直接输出会出现中文乱码:
        OutputFormat output = OutputFormat.createPrettyPrint();
        output.setEncoding("utf-8");//输出的编码utf-8
        //把我们的xml文件更新
        XMLWriter writer = new XMLWriter(
                new FileOutputStream(new File("src/main/java/org/example/students.xml")), output);
        writer.write(document);
        writer.close();
        System.out.println("删除成功~");
    }


    /*
     * //更新元素(要求把所有学生的年龄+3) 使用少，了解
     *
     * @throws Exception
     */
    @Test
    public void update() throws Exception {

        //1.得到解析器
        SAXReader saxReader = new SAXReader();
        //2.指定解析哪个xml文件
        Document document = saxReader.read(new File("src/main/java/org/example/students.xml"));
        //得到所有学生的年龄
        List<Element> students = document.getRootElement().elements("student");
        //遍历, 所有的学生元素的age+3
        for (Element student : students) {
            //取出年龄
            Element age = student.element("age");
            age.setText((Integer.parseInt(age.getText()) + 3) + "");
        }

        //更新
        //直接输出会出现中文乱码:
        OutputFormat output = OutputFormat.createPrettyPrint();
        output.setEncoding("utf-8");//输出的编码utf-8

        //把我们的xml文件更新
        XMLWriter writer = new XMLWriter(
                new FileOutputStream(new File("src/main/java/org/example/students.xml")), output);
        writer.write(document);
        writer.close();
        System.out.println("更新成功~");
    }
    /*

     */


}





