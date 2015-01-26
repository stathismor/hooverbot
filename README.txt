================
 = Description =
================

This program navigates an imaginary robotic hoover (much like a Roomba) through an equally imaginary room based on:
1. Room dimensions as X and Y coordinates, identifying the top right corner of the room rectangle. This room is divided up in a grid based on these dimensions; a room that has dimensions X: 5 and Y: 5 has 5 columns and 5 rows, so 25 possible hoover positions. The bottom left corner is the point of origin for our coordinate system, so as the room contains all coordinates its bottom left corner is defined by X: 0 and Y: 0.
2. Locations of patches of dirt, also defined by X and Y coordinates identifying the bottom left corner of those grid positions.
3. An initial hoover position (X and Y coordinates like patches of dirt)
4. Driving instructions (as cardinal directions where e.g. N and E mean "go north" and "go east" respectively)

The room will be rectangular, has no obstacles (except the room walls), no doors and all locations in the room will be clean (hoovering has no effect) except for the locations of the patches of dirt presented in the program input.
Placing the hoover on a patch of dirt ("hoovering") removes the patch of dirt so that patch is then clean for the remainder of the program run. The hoover is always on - there is no need to enable it.
Driving into a wall has no effect (the robot skids in place).

=========
= Goal = 
=========

The goal of the program is to take the room dimensions, the locations of the dirt patches, the hoover location and the driving instructions as input and to then output the following:

1. The final hoover position (X, Y)
2. The number of patches of dirt the robot cleaned up
3. Input

Program input will be received in a file with the format described here. You can process it however you like.
The file will be named input.txt and reside in the same directory as your executable program / web page.
Example:
5 5
1 2
1 0
2 2
2 3
NNESEESWNWW

1. The first line holds the room dimensions (X Y), separated by a single space (all coordinates will be presented in this format)
2. The second line holds the hoover position
3. Subsequent lines contain the zero or more positions of patches of dirt (one per line)
4. The next line then always contains the driving instructions (at least one)

===========
 = Output = 
===========

Program output should be printed to the standard output (STDOUT) of the terminal (or equivalent in the browser, console.log())
The first line of your program output should display the X and Y coordinates marking the position of the hoover after processing all commands.
The second line of the program output should display the number of patches of dirt the robot cleaned up
Example (matching the input above):
1 3
1

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
