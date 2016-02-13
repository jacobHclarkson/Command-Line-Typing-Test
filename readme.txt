README - Command Line Typing Test
=================================

About
-----
A test for typing speed and accuracy that runs in the terminal.

The program calculates typing accuracy using a combination of methods as described here: http://dl.acm.org/citation.cfm?id=642632

Two typing speed measures are used, Gross Words Per Minute (does not take errors into account), as well as Net Words Per Minute (which penalizes you for uncorrected errors).


Installation
------------
To make the typing test available as a terminal command, store the .jar file ('exec/TypingTest.jar') somewhere on your system like '/usr/local/bin' and set an alias to it.

Usage
-----
For convenience, a compiled version of the program is included (exec/TypingTest.jar).
Run the program with 'java -jar TypingTest.jar'. Alternatively, store the jar file somewhere on your system like '/usr/local/bin' and set an alias to it.
Opening the .jar file will give you access to 'wordlist.txt', editing this file will change the pool of words from which each test is randomly chosen. Simply add more words (separated by spaces) to increase the pool.

Compilation
-----------
The program relies on the JNativeHook library: https://github.com/kwhat/jnativehook 

This library is packaged in the provided executable so isn't needed to run, but you will need it if you wish to compile from source.

In order to compile, you must include 'jnativehook-2.0.3.jar' in your classpath:

	1) export CLASSPATH="/PATH/TO/jnativehook-2.0.3.jar":"${CLASSPATH}"
	2) javac Driver.java
To run:
	1) java Driver


If you wish to compile your own .jar file from source you will need the JNativeHook library .jar file as well as One-Jar, which can be found here:
	http://one-jar.sourceforge.net/

Follow the instructions under "COMMAND LINE APPROACH" heading here to make your own TypingTest.jar:
	http://one-jar.sourceforge.net/index.php?page=getting-started&file=quickstart
