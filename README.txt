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
