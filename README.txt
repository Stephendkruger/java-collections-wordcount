This was a quick Java project I hammered out as part of an interviewing process. It uses JUnit for testing, and does a wordcount using maps and collection iteration loops.

Given a text file (for example, Ulysses http://www.gutenberg.org/cache/epub/4300/pg4300.txt ), write a java program that processes a text file and prints a report of a word count.
 
Requirements:
1) This should use core java: Streams, Strings, and Collections.
2) It should also be modern java, with proper use of generics and modern iteration idioms.
3) This should use a minimal amount of memory on reading the file input.
4) Input should handle white space and punctuation as a delimiter (so " dog. " is properly parsed as "dog")
5) Any additional libraries should be included, or referenced as a dependency.
6) The report should be case-insensitive (DOG, dog, and Dog should all be aliases into the same count).
7) You should provide a test method (preferably a junit @Test) with a handful of words showing that these requirements are met, as well as being able to read an external file.
 
Follow-up questions:
1) Whats the overall run-time complexity (big-O notation) of the entire program?
2) What would it take to modify this program to print the report alphabetically?
3) What would it take to modify this program to print the report in insertion order (i.e.: first word encountered is the first word printed)?
4) Is there any way you can think of to make this program more efficient?

ANSWER:

See attached zip folder, net beans project format, contains source code, Jar, and test files(including a JUnit test).

Follow Up Questions:
1) Whats the overall run-time complexity (big-O notation) of the entire program?
This should be O(N), as each line is read in once and longer lines take approximately as long as several shorter lines that add up to the same length, and each word is looked at once as the line collection iterates through.

2) What would it take to modify this program to print the report alphabetically?
Simply replacing the implementation of Map from HashMap to TreeMap would do it. If you wanted a more specific order, you could implement with LinkedHashMap and write a sorting function to sort by some other criteria, i.e most common to least common words. Either way you will take an efficiency hit over non sorted HashMap. 

3) What would it take to modify this program to print the report in insertion order (i.e.: first word encountered is the first word printed)?
 Just implementing via LinkedHashMap would do this, as it maintains insertion order as a default.

4) Is there any way you can think of to make this program more efficient?
I could write a custom reader with built in delimiter checks and skip the split process, which would reduce memory use to one word at a time, instead of one line at a time as is current. Given that a single line COULD have 2^31 - 1 chars (around 4 GB of memory) if they never used a line break, this would be advisable if you plan to use this on non formatted text. Fixing this would also slice off some of the logic currently necessary for parsing each line, but would take a few hours to write (best Estimate X 3 = real estimate).

 Doing the above improvement would eliminate this issue except for extremely(!) long nonsense words that could break string. (i.e. some alphanumeric code file without punctuation or white space) If this happens it will kick an exception.

Also the test for the print function requires visual inspection. I could figure out a way to make the test an actual unit test. I could set it to generate a string array of the output and test it, but that would lower efficiency. If you would like to see this, let me know.

Numerals, like "The 3 Musketeers", will get clobbered. This could be worked around with some extra logic if requested, but 3 isn't a word, so currently is left out.