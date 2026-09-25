package com.training.ioapp.student.parser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.training.ioapp.student.model.Student;

public class XmlParser implements Parser {

    @Override
    public List<Student> parse(Path file) throws IOException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            Document document = factory.newDocumentBuilder().parse(file.toFile());
            NodeList nodes = document.getElementsByTagName("student");
            List<Student> students = new ArrayList<Student>();

            for (int index = 0; index < nodes.getLength(); index++) {
                Node node = nodes.item(index);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element student = (Element) node;
                    students.add(new Student(
                            Integer.parseInt(value(student, "id")),
                            value(student, "firstName"),
                            value(student, "lastName"),
                            value(student, "email"),
                            value(student, "course")));
                }
            }
            return students;
        } catch (ParserConfigurationException | SAXException exception) {
            throw new IOException("Invalid XML file", exception);
        }
    }

    private String value(Element student, String name) {
        return student.getElementsByTagName(name).item(0).getTextContent().trim();
    }
}
