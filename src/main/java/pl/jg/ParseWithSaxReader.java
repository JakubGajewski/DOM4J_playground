package pl.jg;

import java.io.*;
import java.util.*;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class ParseWithSaxReader {
    public static void main(String[] args) {

        try {

            SAXReader saxReader = new SAXReader();

//        File file = new File ("./src/main/resources/input");
//        Document document = saxReader.read(file);
//        Element element = document.getRootElement();
//        Node helloNode = document.selectSingleNode("/class/hello");
//        System.out.println(helloNode.getText());
//        List<Node> nodes = document.selectNodes("/class/student" );
//        System.out.println("----------------------------");
//
//        for (Node node : nodes) {
//            System.out.println("\nCurrent Element :"
//                    + node.getName());
//            System.out.println("Student roll no : "
//                    + node.valueOf("@rollno") );
//            System.out.println("First Name : "
//                    + node.selectSingleNode("firstname").getText());
//            System.out.println("Last Name : "
//                    + node.selectSingleNode("lastname").getText());
//            System.out.println("First Name : "
//                    + node.selectSingleNode("nickname").getText());
//            System.out.println("Marks : "
//                    + node.selectSingleNode("marks").getText());
//        }

            File groceryFile = new File("./src/main/resources/grocery_store.xml");
            org.dom4j.Document groceryDocument = saxReader.read(groceryFile);
            Node node = groceryDocument.selectSingleNode("/groceries");
            List<Node> someNodeList = node.selectNodes("/groceries/vegetables/vegetable");

            someNodeList.forEach(s -> System.out.println(s.getName() + " " + s.getText() + " : " + s.valueOf("@price")));

        } catch (DocumentException e) {
            e.printStackTrace();
        }



    }
}
