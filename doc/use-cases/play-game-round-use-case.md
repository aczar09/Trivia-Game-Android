



Use Case: Play Game Round
=================================
**Actors**: Player, Systems, Database

**Priority**: High

**Level** : User goal

**Scope**: Software system

**The Primary Actor**: User playing the game

**Purpose**: To play a basic round of multiple choice trivia

**Type**: Primary

**Preconditions**: User has chosen to play a standard a given trivia game.

**Post-condition**: User will have completed a game of trivia on their record.

**Overview**: Based on the type of game show, a question is selected by the system for the user to provide a response to.
This continues either until the user loses, or they answer all questions correctly.

## Typical course of events:

```plantuml
@startuml

scale max 600 height
title Single-Player Trivia Game Flow
'define swimlanes
|#technology|Player|
|#implementation|System|
|System|
start
:Game starts;
while(Has user failed or answered every question correct?) is (no)
:Picks a question based on given criteria (category, difficulty, question type, etc.);
:Print out question to the user with response type (free response, multiple choice, etc.);
|Player|
:Selects an answer;
|System|
if (Is answer is correct?) then (yes)
:Output congratulations;
else (no)
:Output failure;
endif
endwhile
:Output final stats message (questions correct, points earned, etc.);
Stop

@enduml

```

Alternative Courses:
-----------
1. Question may be selected based on user's decision or by random generation based on a game's format
2. User may answer free response or multiple choice
3. User may exit the game at any given moment
4. For any question, the user may select to use a hint before answering (50/50, Phone a friend, Ask the audience),
   which will print onto the screen to help the user answer.

