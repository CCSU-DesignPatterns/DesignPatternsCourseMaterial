package edu.ccsu.designpatterns.dictionaryproxy;

import java.util.List;

/**
 * Example that shows how proxy can help for remote calls
 */
public class Main {
  /**
   * Example that shows how proxy can help for remote calls
   * 
   * @param args No arguments needed
   */
  public static void main(String[] args) {
    long preCallTime, postCallTime;
    List<String> wordList = List.of("dog", "paper", "host", "class", "design", "pattern");
    Dictionary dictionary;
    List<Meaning> meanings;
    List<WordDefinition> definitions;

    // Demonstration not using proxy
    preCallTime = System.currentTimeMillis();
    dictionary = new RemoteDictionary();
    for (int i = 0; i < 10; i++) {
      for (String word : wordList) {
        meanings = dictionary.lookupWordMeanings(word);
        definitions = dictionary.lookupWordDefinitions(word);
        System.out.println(
            "R: " + word + " meanings:" + meanings.size() + " definitions:" + definitions.size());
      }
    }
    postCallTime = System.currentTimeMillis();
    System.out.println("Remote call execution took: " + (postCallTime - preCallTime)
        + "ms bytes received: " + RemoteDictionary.getBytesReceived());
    RemoteDictionary.resetBytesReceived();

    // Demonstration using proxy
    preCallTime = System.currentTimeMillis();
    dictionary = Dictionary.getInstance();
    for (int i = 0; i < 10; i++) {
      for (String word : wordList) {
        meanings = dictionary.lookupWordMeanings(word);
        definitions = dictionary.lookupWordDefinitions(word);
        System.out.println(
            "C: " + word + " meanings:" + meanings.size() + " definitions:" + definitions.size());
      }
    }
    postCallTime = System.currentTimeMillis();
    System.out.println("Proxy call execution took: " + (postCallTime - preCallTime)
        + "ms bytes received: " + RemoteDictionary.getBytesReceived());
  }

}
