# Basic Cases

## Game Opens - Single Game Mode
1. Game opening screen is shown
2. Player receives multiple options of style of game to choose
3. Player's picks an option between: different styles or random
4. Player's choice is registered and single player is activated

## Game Opens - Multiple Game Mode
1. Game opening screen is shown
2. Player decides how many round they'd like to play.
3. Player receives multiple options of style of game to choose
4. Player's picks an option between: different styles or random
5. Player's choice is registered
6. Process repeats until a given number of styles have been chosen
7. Single player mode is activated

### Choosing a random game mode
1. Player chooses the random game option
2. Game uses a random generator to pick which of the available game modes to play
3. If game mode has already been selected, then try again, until three modes have
been selected


## Single Player

### Game Flow
1. Game starts
2. Player plays the game until finish conditions are met (all answered correctly, one wrong answer, etc)
3. Results are printed for the round
4. If any rounds are left, repeat process with new game style, otherwise, print final results.


### Choosing a category
1. Player receives multiple categories to answer a question from
2. Player chooses fromm the given category
3. Game outputs a question from the category chosen by the player

### Multiple Choice, general category
1. Print out trivia question
2. Provide answer choices
3. Player chooses their preferred answer
4. Program registers the chosen answer 
5. Program reads whether answer was correct or not.
6. If player answers, correctly the process repeats
7. If player answers incorrectly, we break out
8. If player reaches question and registers a correct response we also break out
## BreakOut
### Player breaks out due to incorrect response
1. Players' game stats are printed
2. Player then receives a game over message

### Player answers 10 questions correctly
1. Player's game stats are printed 
2. Player then receives a message of victory
3. Win is recorded on account record

## Post-Results
1. Player receives win statistics
2. Player receives option to play again

## Accessing Trivia Questions
1. Based on the given criteria (category, difficulty, question type, etc.),
search for an appropriate trivia question
2. Checks that question has not been asked in the same game session
3. Once one is found, return it to the program and display to the user

Use Case: Playing Single Player Multiple Choice Game
=================================
**Actors**: Player, Systems, Database

**Priority**: High

**Level** : User goal

**Scope**: Software system

**Purpose**: Intention of the use case.

**Type**: Primary (Secondary, Optional)

**Preconditions**: User has chosen to play a standard multiple choice game.

**Overview**: A brief description of what happens in this use case.

Typical course of events:
----------------------

| Actor Action                                     | System Response                                                                          | Database Response                                    |
|:-------------------------------------------------|:-----------------------------------------------------------------------------------------|------------------------------------------------------|
|                                                  | 1. Game starts                                                                           |                                                      |
| 3. Selects a category to receive a question from | 2. Prints out a selection of question categories to choose from                          |                                                      |
| 4.                                               | 5. Registers the user choice                                                             |                                                      |
| 5.                                               | 6. Requests a question from the database                                                 | 7. Searches for a question which matches the request |
|                                                  | 9. Receives question                                                                     | 8. Sends question to the system                      |
|                                                  | 10. Checks if question has been asked already. If so, repeat process.                    |                                                      |
| 12. Selects an answer                            | 11. If question is valid, then output question to the user with choices                  |                                                      |
|                                                  | 13. Checks if answer is valid.                                                           |                                                      |
|                                                  | 14. If so, outputs congratulations message, otherwise output a failure message           |                                                      |
|                                                  | 15. Repeat process until limit of questions has been reached or user answers incorrectly |                                                      |
|                                                  | 16. Output final stats message (questions correct, points earned, etc.)                  |                                                      |                                                 |                                                                                          |                                                      |


Alternative Courses:
-----------
1a. ...

3a. ...

3b. ...

Section: A subsection of the use case, e.g. Paying by cash
-----------
| Actor Action                                                   | System Response                                   |
|:---------------------------------------------------------------|:--------------------------------------------------|
| 1. This use case begins when Actor wants to initiate an event. |                                                   |
| 2. The Actor does something...                                 | 3. The system determines something or responds... |
| 4.                                                             ||
| 5.                                                             | 6.                                                |