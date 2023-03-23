# CMPU-203 S23 - Team 2C



## Trivia Game: Functionality

This program serves as a text-based multiple choice trivia game, which in the future will
include various game show format. The user can select to play as many rounds of
5 question multiple choice trivia as they'd like, with each rounding ending once the user
has either got all 5 right or answered one incorrectly. However, there are some limitations:
1. There is only one game mode available to play, single-player multiple choice, but this will
expand in the future
2. Each round, the game pulls from the same question pool, so repeat questions are inevitable across
rounds, but not within rounds themselves
3. No data persistence as of right now, every time the game starts, previous results aren't kept track of



## How to Run
The main method can be located in the TextUI class. To run this from the command line,
do the following
```
javac team-2c/src/src/TextUI.java

java team-2c/src/src/TextUI.java

Welcome to our trivia game
How many games would you like to play?
Choose your number:  
```