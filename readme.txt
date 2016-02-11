gonna put typing analysis stuff here

PART 1: ACCURACY ANALYZER [req: prompt string, raw user input string]
Can write it in java since all it is going to do is receive two strings and compare them and spit out a number - doesn't need to be implemented in android or unity
Will be based on that CHI paper about typing accuracy measures

PART 2: TYPING SPEED ANALYZER [req: start time, end time, sanitized user input string]
based on that one link to the typing website - divide by five and then by minutes blah blah
also can be a standalone java app, no need for unity or android

PART 3: TYPING TEST PROGRAM TO PROMPT USER FOR INPUT
this will need to be implemented in both java (for android), and C# (for unity)
will build short prompt strings from random selection of top 200 English words. Must take raw user input (include backspace key, etc), time of prompt, time of first key-press, time from first key-press till time completed, and save it all to file for later analysis.
