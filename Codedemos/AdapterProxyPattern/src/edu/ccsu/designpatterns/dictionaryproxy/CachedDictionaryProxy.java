package edu.ccsu.designpatterns.dictionaryproxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is an example of the Proxy pattern, acting as a Proxy for the RemoteDictionary class
 * caching responses to reduce the number of network calls needed for frequent lookups.
 * 
 * @author Chad Williams
 *
 */
public class CachedDictionaryProxy implements Dictionary {

  private Map<String, List<Meaning>> meanings;
  private Map<String, List<WordDefinition>> definitions;

  private static CachedDictionaryProxy instance = null;

  private CachedDictionaryProxy() {
    meanings = new HashMap();
    definitions = new HashMap();
  }

  /**
   * Get singleton instance of this class
   * 
   * @return Instance of the class
   */
  public static Dictionary getInstance() {
    if (instance == null) {
      instance = new CachedDictionaryProxy();
    }
    return instance;
  }

  @Override
  public List<Meaning> lookupWordMeanings(String word) {
    List<Meaning> meaningsResults = null;
    if (meanings.containsKey(word)) {
      meaningsResults = meanings.get(word);
    } else {
      meaningsResults = (new RemoteDictionary()).lookupWordMeanings(word);
      meanings.put(word, List.copyOf(meaningsResults));
    }
    return meaningsResults;
  }

  @Override
  public List<WordDefinition> lookupWordDefinitions(String word) {
    List<WordDefinition> definitionResults = null;
    if (definitions.containsKey(word)) {
      definitionResults = definitions.get(word);
    } else {
      // Use Meanings lookup on remotes and cache both from results
      List<Meaning> meaningsResults = (new RemoteDictionary()).lookupWordMeanings(word);
      meanings.put(word, List.copyOf(meaningsResults));
      definitionResults = new ArrayList();
      for (Meaning m : meaningsResults) {
        definitionResults.addAll(m.definitions);
      }
      definitions.put(word, List.copyOf(definitionResults));
    }
    return definitionResults;
  }

}
