=================
= How to run it =
=================

---------
- Linux -
---------

Run game
--------
Simply change to hooverbot directory, and execute "hooverbot_linux.sh" like this:

user@machine:~/hooverbot
$ ./hooverbot_linux.sh

As long as there is an inputfile.txt file in the same directory where you execute this script from, Hooverbot will do its job.

Alternatively you can change to the jar directory, and after you make sure you have an input.txt file in there, run "java -jar jar/hooverbot.jar
".

Execute tests
-------------
Same as before, but execute "hooverbot-junit_linux.sh". You should get the following message:

JUnit version 4.11
................
Time: 0.037
OK (16 tests)

-----------
- Windows - (Not a requirement but there you go)
-----------

Run game
--------
Simply change to hooverbot directory, and execute "hooverbot_win.sh" like this:

C:\Users\stathis\workspace\hooverbot>hooverbot_win.bat

Execute tests
-------------
Same as before, but execute "hooverbot-junit_win.bat". You should get the following message.


============================
= Environment requirements =
============================
A Linux or Windows machine with java 1.8 installed. Specifically, it has been tested on:

Linux
-----
java version "1.8.0_25"
Java(TM) SE Runtime Environment (build 1.8.0_25-b17)
Java HotSpot(TM) 64-Bit Server VM (build 25.25-b02, mixed mode)

Windows
-------
java version "1.8.0_20"
Java(TM) SE Runtime Environment (build 1.8.0_20-b26)
Java HotSpot(TM) 64-Bit Server VM (build 25.20-b23, mixed mode)


====================
= Notes ==
====================
1) Assumptions made:
  a) We are the ones feeding the data to the Hoverbot. We don't expect others having access to the Hoverbot public methods. 
  b) We don't have to provide for an insanely huge map. All modern computers should be able to handle a map with thousands millions of tiles, but for very big maps (eg trillions of tiles), maybe a different implementation is required (notes in Map contructor)
2) Because of 1a, the syntax-specific validation of the file, was left for the InputParser, and everything else, logic-specific, is for robot/game to check. For instance, the input parser will validate a position coordinate is not a letter, but making sure it is in the bounds of a map, is left for the Game class. If you start feeding the Hooverbot directly with invalid data, undefined behaviour might occur.
