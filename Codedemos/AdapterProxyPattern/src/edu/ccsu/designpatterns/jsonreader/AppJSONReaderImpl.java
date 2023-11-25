package edu.ccsu.designpatterns.jsonreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;

/**
 * Implementation of JSON reader, note method naming is such that it follows standard for JSON
 * rather than XML.
 * 
 * @author Chad Williams
 *
 */
public class AppJSONReaderImpl implements AppJSONReader {
  private JSONObject jo = null;

  @Override
  public String getName(String name) {
    if (jo == null) {
      return "";
    } else if (jo.has(name)) {
      return jo.getString(name);
    } else {
      return "";
    }
  }

  @Override
  public void loadJSONDocument(String fileName) throws IOException {
    StringBuffer readJSONContents = new StringBuffer();
    BufferedReader reader = new BufferedReader(new FileReader(fileName));

    String line = reader.readLine();
    while (line != null) {
      readJSONContents.append(line);
      line = reader.readLine();
    }
    reader.close();
    jo = new JSONObject(readJSONContents.toString());
  }

  public static void main(String[] args) {
    try {
      AppJSONReaderImpl jsonReader = new AppJSONReaderImpl();
      jsonReader.loadJSONDocument("demo.json");
      System.out.println("AppName: " + jsonReader.getName("AppName"));
      System.out.println("AppAuthor: " + jsonReader.getName("AppAuthor"));
      System.out.println("AppCreationDate: " + jsonReader.getName("AppCreationDate"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
