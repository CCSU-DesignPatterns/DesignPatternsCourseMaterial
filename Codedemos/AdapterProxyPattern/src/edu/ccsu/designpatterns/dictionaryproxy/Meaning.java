package edu.ccsu.designpatterns.dictionaryproxy;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Read-only data class for Meaning element returned by https://dictionaryapi.dev/
 */
public class Meaning {
  /** Part of speech for this meaning */
  public final String partOfSpeech;
  /** List of definitions associated with the meaning when used as this part of speech */
  public final List<WordDefinition> definitions;

  private Meaning(String partOfSpeech, List<WordDefinition> definitions) {
    this.partOfSpeech = partOfSpeech;
    this.definitions = List.copyOf(definitions);
  }

  @Override
  public String toString() {
    return "[partOfSpeech=" + partOfSpeech + " definitions=" + definitions + "]";
  }

  static List<Meaning> createFromJSONObject(JSONArray meaningsResponse) {
    List<Meaning> meanings = new ArrayList();
    for (int i = 0; i < meaningsResponse.length(); i++) {
      JSONObject curMeaningObj = meaningsResponse.getJSONObject(i);
      String partOfSpeech = curMeaningObj.getString("partOfSpeech");
      JSONArray definitionsResponse = curMeaningObj.getJSONArray("definitions");
      List<WordDefinition> definitions =
          WordDefinition.createFromJSONArray(partOfSpeech, definitionsResponse);
      Meaning curMeaning = new Meaning(partOfSpeech, definitions);
      meanings.add(curMeaning);
    }
    return meanings;
  }
}
