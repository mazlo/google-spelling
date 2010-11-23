This is a simple API to use Google Spelling service. There are no external dependencies and the code is compatible with Java 6+. If you want to use Java 5, you need to place JAXB jars in your classpath.

There are three ways to use the Google Spell Service:

1) Searching into text and returns a list of Word object that contains the bad words and spell suggestions for own.
<pre><code>List<Word> out = GSpellingChecker.checkWords("Boing is an amaing aircraft", ENGLISH);
// returns [Boing=[Boeing, Booing, Bing...], amaing=[aiming, arming, amazing, ...]</code></pre>

2) Searching into text to find spelling errors, and return the bad words.
<pre><code>List<String> out = GSpellingChecker.checkBadWords("Boing aircraft", ENGLISH);
// returns [Boing]</code></pre>

1) Searching into text and returns a list of suggestions for one or more words.
<pre><code>List<String> out = GSpellingChecker.getSuggestions("Boing", ENGLISH);
// returns [Boeing, Booing, Bing, Being, Binge]</code></pre>

*To use through a proxy server*

To use this API through a proxy server you can pass these parameters in the JVM initialization:

<pre><code>java -Dhttp.proxyHost=myproxyserver.com -Dhttp.proxyPort=8080 MyClass</code></pre>

Or you can set the properties via System.setProperty method.

<pre><code>System.setProperty("http.proxyHost", "myProxyServer.com");
System.setProperty("http.proxyPort", "8080");</code></pre>

This is an experimental project. Have fun =)