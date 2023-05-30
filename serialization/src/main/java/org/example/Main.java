package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        HelperClass h1 = new HelperClass();
        h1.setDoubleAttr(2.2);
        h1.setIntAttr(54);
        HelperClass h2 = new HelperClass();
        h2.setDoubleAttr(22.36);
        h2.setIntAttr(11);
        List<HelperClass> h = new ArrayList<HelperClass>();
        h.add(h1);
        h.add(h2);
        Map<String, String> hashmap = new HashMap<String, String>();
        hashmap.put("zero", "one");
        ExampleClass ex = new ExampleClass();
        ex.setStringAttr("aa");
        ex.setDoubleAttr(22.22);
        ex.setIntattr(17);
        ex.setDate(new Date());
        ex.setProperies(hashmap);
        ex.setAnEnum(ExampleEnum.TYPE1);
        ex.setListAttr(h);
        //var mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = xmlMapper.writeValueAsString(ex);
            xmlMapper.writeValue(new File("ex.xml"), ex);
            File file = new File("ex.xml");
            ExampleClass value = xmlMapper.readValue(file, ExampleClass.class);
            System.out.println(value.toString());
            //var xml = mapper.writeValueAsString(ex);
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}