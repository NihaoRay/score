package com.marsdl.test.java;

import com.marsdl.test.src.Glossary;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>titile  </p>
 * <p>@description </p>
 *
 * @author chenrui
 * @since 2018/1/26
 */
public class TestGlossary {

    public static void main(String[] args) throws Exception {

        List<Glossary> list = new ArrayList<Glossary>();
        SAXReader reader = new SAXReader();


        Document document = reader.read(new File("D:/githubList/score/ScoreWeb/src/main/resources/glossary.xml"));
        /*InputSource in = new InputSource(new StringReader(xml));*/
        Element root = document.getRootElement();
        //listNodes(root);
        Element rootElement = document.getRootElement();
        Iterator<Element> modulesIterator = rootElement.elements("glossary").iterator();
        while(modulesIterator.hasNext()){
            //每次添加list时候new一个新的对象
            Glossary glossary = new Glossary();
            //根节点下面继续遍历
            Element moduleElement = modulesIterator.next();
            System.out.println(moduleElement.getName());
            Element identElement = moduleElement.element("ident");
            glossary.setIdent(identElement.getText());
            Element filenameElement = moduleElement.element("filename");
            glossary.setFilename(filenameElement.getText());

            Element levelElement = moduleElement.element("level");
            glossary.setLevel(levelElement.getText());

            Element processElement = moduleElement.element("process");
            glossary.setProcess(processElement.getText());

            Element staticElement = moduleElement.element("static");
            glossary.setStaticString(staticElement.getText());

            Element srclangElement = moduleElement.element("srclang");
            glossary.setSrclang(srclangElement.getText());

            Element trglangElement = moduleElement.element("trglang");
            glossary.setTrglang(trglangElement.getText());

            Element commentsElement = moduleElement.element("comments");
            glossary.setComments(commentsElement.getText());

            Element removedupesElement = moduleElement.element("removedupes");
            glossary.setRemovedupes(removedupesElement.getText());

            //有四个没有加，自己加上
            list.add(glossary);
        }

        System.out.println(list.size());
    }

}
