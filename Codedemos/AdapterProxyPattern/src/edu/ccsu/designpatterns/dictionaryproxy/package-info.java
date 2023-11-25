/**
 * This package provides an example of using the proxy pattern to as a way of providing a local
 * proxy for remote calls. Specifically the RemoteDictionary class makes a call to
 * https://dictionaryapi.dev/ anytime a word is looked up to get the corresponding meanings or
 * definitions. This incurs a cost in terms of both time and network usage associated with each
 * call. If these lookups are likely to be common could instead use proxy pattern to cache responses
 * reducing the cost of calls so only the first requestor pays the network time and subsequent calls
 * are fulfilled by the proxy while making the end system unaware the proxy is even in between.
 * 
 * This package uses the org.json library that you can get here:
 * https://github.com/stleary/JSON-java
 * 
 * 
 * @author Chad Williams
 *
 */
package edu.ccsu.designpatterns.dictionaryproxy;
