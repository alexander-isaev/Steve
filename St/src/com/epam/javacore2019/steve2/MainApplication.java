package com.epam.javacore2019.steve2;

import com.epam.javacore2019.steve2.dbservice.server_old.DBApplication;
import com.epam.javacore2019.steve2.dbservice.misc.Utils;
import com.epam.javacore2019.steve2.dbservice.misc.XMLDocumentHandler;
import com.epam.javacore2019.steve2.dbservice.misc.DBConstants;
import com.epam.javacore2019.steve2.webservice.WebClientApplication;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class MainApplication {

    public static void main(String[] args) {
        DBApplication.INSTANCE.start(); // Starting DB app.
        //DBApplication.INSTANCE.stop();
        //testXMLReader();

        try {
            WebClientApplication.INSTANCE.start(); // Starting Web app.
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void testXMLReader() {
        try {
            Utils.readXMLDocument(DBConstants.STRUCTURE_DIR + "/test.xml",
                    new XMLDocumentHandler() {
                        @Override
                        public void handleDocument(Document document) {
                            Element root = document.getDocumentElement();
                            System.out.println(root.getAttribute("name"));
                            NodeList columns = root.getElementsByTagName("column");
                            System.out.println(columns.getLength());
                            for (int i = 0, len = columns.getLength(); i < len; i++) {
                                Element column = (Element)columns.item(i);
                                System.out.println(column.getAttribute("systemName"));
                                System.out.println(column.getAttribute("displayName"));
                            }
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
