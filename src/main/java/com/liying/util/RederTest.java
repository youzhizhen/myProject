package com.liying.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;

import org.apache.ibatis.builder.BuilderException;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.parsing.XPathParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class RederTest {
    
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        XPathParser parser = new XPathParser(inputStream, true, null, new XMLMapperEntityResolver());
        List<XNode> s = parser.evalNodes("/configuration/settings/*");

    }

    //
    private static Document createDocument(InputSource inputSource) {
        // important: this must only be called AFTER common constructor
        try {
          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

          factory.setNamespaceAware(false);
          factory.setIgnoringComments(true);
          factory.setIgnoringElementContentWhitespace(false);
          factory.setCoalescing(false);
          factory.setExpandEntityReferences(true);

          DocumentBuilder builder = factory.newDocumentBuilder();
          builder.setErrorHandler(new ErrorHandler() {
            public void error(SAXParseException exception) throws SAXException {
              throw exception;
            }

            public void fatalError(SAXParseException exception) throws SAXException {
              throw exception;
            }

            public void warning(SAXParseException exception) throws SAXException {
            }
          });
          return builder.parse(inputSource);
        } catch (Exception e) {
          throw new BuilderException("Error creating document instance.  Cause: " + e, e);
        }
      }
}
