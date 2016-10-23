package com.aviacompany.project.appSettings;

import by.bs.xml.DOMSerializer;
import org.apache.crimson.tree.DOMImplementationImpl;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *@author     Siarhej Berdachuk
 *@created    Jan 2004.
 *@version    1.0
 */
public final class AppSettings {
  private AppSettings() {
    fHashMap = new HashMap();
  }


  public static Object get(String key) {
    return SINGLETON.fHashMap.get(key);
  }


  public static Object get(String key, Object deflt) {
    Object obj = SINGLETON.fHashMap.get(key);
    if (obj == null) {
      return deflt;
    } else {
      return obj;
    }
  }


  public static int getInt(String key, int deflt) {
    Object obj = SINGLETON.fHashMap.get(key);
    if (obj == null) {
      return deflt;
    } else {
      return new Integer((String) obj).intValue();
    }
  }


  public static boolean save(File file) throws Exception {
    // Create new DOM tree
    DOMImplementation domImpl = new DOMImplementationImpl();
    Document doc = domImpl.createDocument(null, "app-settings", null);
    Element root = doc.getDocumentElement();
    Element propertiesElement = doc.createElement("properties");
    root.appendChild(propertiesElement);
    Set set = SINGLETON.fHashMap.keySet();
    if (set != null) {
      for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
        String key = iterator.next().toString();
        Element propertyElement = doc.createElement("property");
        propertyElement.setAttribute("key", key);
        Text nameText = doc.createTextNode(get(key).toString());
        propertyElement.appendChild((Node) nameText);
        propertiesElement.appendChild(propertyElement);
      }
    }
    // Serialize DOM tree into file
    DOMSerializer serializer = new DOMSerializer();
    serializer.serialize(doc, file);
    return true;
  }


  public static void clear() {
    SINGLETON.fHashMap.clear();
  }


  public static void put(String key, Object data) {
    //prevent null values. Hasmap allow them
    if (data == null) {
      throw new IllegalArgumentException();
    } else {
      SINGLETON.fHashMap.put(key, data);
    }
  }


  public static boolean load(File file) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(file);
    if (doc == null) {
      throw new NullPointerException();
    }
    NodeList propertiesNL = doc.getDocumentElement().getChildNodes();
    if (propertiesNL != null) {
      for (int i = 0; (i < propertiesNL.getLength()); i++) {
        if (propertiesNL.item(i).getNodeName().equals("properties")) {
          NodeList propertyList = propertiesNL.item(i).getChildNodes();
          for (int j = 0; j < propertyList.getLength(); j++) {
            NamedNodeMap attributes = propertyList.item(j).getAttributes();
            if (attributes != null) {
              Node n = attributes.getNamedItem("key");
              NodeList childs = propertyList.item(j).getChildNodes();
              if (childs != null) {
                for (int k = 0; k < childs.getLength(); k++) {
                  if (childs.item(k).getNodeType() == Node.TEXT_NODE) {
                    put(n.getNodeValue(), childs.item(k).getNodeValue());
                  }
                }
              }
            }
          }
        }
      }
      return true;
    } else {
      return false;
    }
  }


  private HashMap fHashMap;
  private static AppSettings SINGLETON;
  static {
    SINGLETON = new AppSettings();
  }
}

/* Example 1

try
        {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            File file = new File("./","set.xml");
            try {
                AppSettings.save(file);
                AppSettings.put("cat","second");
                AppSettings.put("dog","first");
                AppSettings.save(file);
                System.out.println("Object "+AppSettings.get("cat"));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


 */

/*
Example 2

File file = new File(propDir, "settings.xml");
try {
  AppSettings.clear();
  AppSettings.load(file);
  String lnfName = UIManager.getLookAndFeel().getClass().getName();
  if (AppSettings.get(LF_KEY, lnfName) != lnfName) {
    UIManager.setLookAndFeel(
    (String) AppSettings.get(LF_KEY, lnfName));
    SwingUtilities.updateComponentTreeUI(MainFrame.this);
  }

  this.setSize(new Dimension(
  AppSettings.getInt(WIDTH_KEY, getWidth()),
  AppSettings.getInt(HEIGHT_KEY, getHeight())
  ));
} catch (Exception e) {
  e.printStackTrace();
}

 */
