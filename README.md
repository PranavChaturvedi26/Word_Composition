# Compounded Words Finder
This Java program reads a list of alphabetically sorted words from a text file, identifies the longest and second-longest compounded words, and measures the time taken to process the input file.

#Problem Description
Given a list of alphabetically sorted words in a text file, a compounded word is defined as a word that can be constructed by combining shorter words also found in the same file. The program aims to identify the longest and second-longest compounded words from the input file.

#Solution Overview
The solution provided consists of:

Trie Data Structure: Implemented to efficiently store the words from the input file and facilitate the search for prefixes and valid words.

Solution Class: Contains the main logic for processing the input file, building the Trie, and finding the longest and second-longest compounded words.

Node Class: Represents a node in the Trie data structure.

#Usage
Compilation: Compile the Java source files using a Java compiler. For example:

Copy code
javac Solution.java
Execution: Run the compiled Java program, specifying the input text file as an argument. For example:

Copy code
java Solution Input_01.txt
Output: The program will display the longest compounded word, the second-longest compounded word, and the time taken to process the input file.

#File Structure
Solution.java: Contains the main solution logic.
Node.java: Represents a node in the Trie data structure.
Trie.java: Implements the Trie data structure.
Input_01.txt: Sample input file containing alphabetically sorted words.
#Requirements
Java Development Kit (JDK) installed on the system.
Text file containing alphabetically sorted words as input.
#Dependencies
None.
