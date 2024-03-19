# Compounded Words Finder
It is a Java program designed to find the longest and second longest words from a list of words. Compounded words are words that can be formed by combining short words of the same form.

# Problem Description
Given a list of alphabetically sorted words in a text file, a compounded word is defined as a word that can be constructed by combining shorter words also found in the same file. The program aims to identify the longest and second-longest compounded words from the input file.

# Solution Overview
The program uses the Trie data structure to store and retain messages. It creates a Trie by reading each word in the input file and placing it into the Trie. As each word is added, all possible prefixes in the Trie for that word are checked and added to the column containing the word's endings.

After creating the Trie, the program will iterate through the lines and check if the meaning of each word is a valid word already found in the Trie. If so, it updates the longest message and the second longest message together. The process will continue until the queue runs out.

# Usage
Compilation: Compile the Java source file Solution.java using the Java compiler.
1. Compilation: Compile the Java source files using a Java compiler. For example: javac Solution.java
2. Execution: Run the compiled Java program, specifying the input text file as an argument. For example: java Solution Input_01.txt
3. Output: The program will display the longest compounded word, the second-longest compounded word, and the time taken to process the input file.

# File Structure
Solution.java: Contains the main solution logic.
Node.java: Represents a node in the Trie data structure.
Trie.java: Implements the Trie data structure.
Input_01.txt: Sample input file containing alphabetically sorted words.

# Screenshots
![1_CompoundedWords](https://github.com/PranavChaturvedi26/Word_Composition/assets/72809454/c3f12774-f2ab-4605-9b22-7d985300805e)
![2_CompoundedWords](https://github.com/PranavChaturvedi26/Word_Composition/assets/72809454/83e3c035-c02b-4a9e-930b-1b510d354d1c)


# Requirements
Java Development Kit (JDK) installed on the system.
Text file containing alphabetically sorted words as input.
# Dependencies
None.
