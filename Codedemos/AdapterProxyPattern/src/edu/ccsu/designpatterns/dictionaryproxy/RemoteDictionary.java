package edu.ccsu.designpatterns.dictionaryproxy;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Class is acting as a Remote Proxy that makes a call to https://dictionaryapi.dev/ to lookup the
 * meaning and definition of the passed word.
 * 
 * @author Chad Williams
 */
public class RemoteDictionary implements Dictionary {
  private static long bytesReceived = 0;

  /** Returns bytes received since last reset */
  public static long getBytesReceived() {
    return bytesReceived;
  }

  /** Resets the bytes received back to zero */
  public static void resetBytesReceived() {
    bytesReceived = 0;
  }

  /**
   * Strip any special characters so only letters are used in query to avoid this being used for any
   * sort of attack
   * 
   * @param passedWord User specified word
   * @return letters of typed input
   */
  private String sanatize(String passedWord) {
    StringBuffer returnWord = new StringBuffer();
    for (int i = 0; i < passedWord.length(); i++) {
      if (Character.isLetter(passedWord.charAt(i))) {
        returnWord.append(passedWord.charAt(i));
      }
    }
    return returnWord.toString();
  }

  private JSONObject queryDictionary(String word) throws IOException, InterruptedException {
    // Make sure we are only sending
    String sanitizedWord = sanatize(word);
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.dictionaryapi.dev/api/v2/entries/en/" + sanitizedWord))
        .build();
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    if (response.statusCode() != 200) {
      throw new IOException("HTTP Status not OK, received: status=" + response.statusCode());
    }
    // System.out.println(response.body());
    bytesReceived += response.body().getBytes().length;
    JSONArray ja = new JSONArray(response.body());
    JSONObject jo = ja.optJSONObject(0);
    return jo;
  }

  @Override
  public List<Meaning> lookupWordMeanings(String word) {
    List<Meaning> meanings = new ArrayList();
    try {
      JSONObject dictionaryResponse = queryDictionary(word);
      JSONArray meaningsResponse = dictionaryResponse.getJSONArray("meanings");
      meanings = Meaning.createFromJSONObject(meaningsResponse);
    } catch (Exception e) {
      // Output to error stream, but return empty collection
      System.err.println("Failed to retrieve word error: " + e.getMessage());
    }
    return meanings;
  }

  @Override
  public List<WordDefinition> lookupWordDefinitions(String word) {
    List<WordDefinition> definitions = new ArrayList();
    try {
      JSONObject dictionaryResponse = queryDictionary(word);
      JSONArray meaningsResponse = dictionaryResponse.getJSONArray("meanings");
      List<Meaning> meanings = Meaning.createFromJSONObject(meaningsResponse);
      for (Meaning m : meanings) {
        definitions.addAll(m.definitions);
      }
    } catch (Exception e) {
      // Output to error stream, but return empty collection
      System.err.println("Failed to retrieve word error: " + e.getMessage());
    }
    return definitions;
  }
}
