package edu.ccsu.designpatterns.dictionaryproxy;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Read-only data class for Definition element returned by https://dictionaryapi.dev/
 */
public class WordDefinition {
  /** Part of speech for this meaning */
  public final String partOfSpeech;
  /** Definition of the word when used with this part of speech */
  public final String definition;
  /** Example of its use if available */
  public final String example;
  /** Synonyms for this use if available */
  public final List<String> synonyms;
  /** Antonyms for this use if available */
  public final List<String> antonyms;

  private WordDefinition(String partOfSpeech, String definition, String example,
      List<String> synonyms, List<String> antonyms) {
    this.partOfSpeech = partOfSpeech;
    this.definition = definition;
    this.example = example;
    this.synonyms = List.copyOf(synonyms);
    this.antonyms = List.copyOf(antonyms);
  }

  @Override
  public String toString() {
    return "{definition='" + definition + "' ex.='" + example + "' syn=" + synonyms + " ant="
        + antonyms + "}";
  }

  static List<WordDefinition> createFromJSONArray(String partOfSpeech, JSONArray jsonDefns) {
    List<WordDefinition> definitions = new ArrayList();
    for (int i = 0; i < jsonDefns.length(); i++) {
      JSONObject jsonDefn = jsonDefns.getJSONObject(i);
      String definition = jsonDefn.getString("definition");
      String example = "";
      if (jsonDefn.has("example")) {
        example = jsonDefn.getString("example");
      }
      WordDefinition wordDefinition =
          new WordDefinition(partOfSpeech, definition, example, new ArrayList(), new ArrayList());
      definitions.add(wordDefinition);
    }
    return definitions;
  }

}
