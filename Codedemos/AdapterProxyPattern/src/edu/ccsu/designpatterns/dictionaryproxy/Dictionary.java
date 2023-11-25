package edu.ccsu.designpatterns.dictionaryproxy;

import java.util.List;

/**
 * Interface for Dictionary lookup supported by https://dictionaryapi.dev/
 * 
 * @author Chad Williams
 *
 */
public interface Dictionary {
  /**
   * Lookup up word and get a list of meanings associated with the word and the definitions
   * associated with each meaning.
   * 
   * @param word Word to be looked up
   * @return List of Meanings
   */
  public List<Meaning> lookupWordMeanings(String word);

  /**
   * Lookup up word and get a list of definitions associated with the word.
   * 
   * @param word Word to be looked up
   * @return List of definitions
   */

  public List<WordDefinition> lookupWordDefinitions(String word);

  /**
   * Get an instance of a Dictionary
   * 
   * @return Dictionary that can be used for looking up words
   */
  public static Dictionary getInstance() {
    return CachedDictionaryProxy.getInstance();
  }
}
