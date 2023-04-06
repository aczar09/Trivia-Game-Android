Use Case: Configure Game
=================================
**Actors**: Player, Systems

**Priority**: Medium

**Level** : User goal

**Scope**: Software system

**The Primary Actor**: User playing the game

**Purpose**: To assign the game flow based on user input

**Type**: Primary

**Preconditions**: User has opened the app

**Post-condition**: User will begin the main game flow.

**Overview**: The user decides how many rounds of game shows they'd like to play and which variations they'd like to play.
The game will begin once the desired amount of formats has been selected.

Typical course of events:
----------------------
```plantuml
@startuml
scale max 600 height
title Configure Game
'define swimlanes
|#technology|Player|
|#implementation|System|
|System|
start
:Prints start menu, offers selection of number of game shows;
|Player|
:Select the number of game-shows they'd like to play;
if(Select random generated game shows?) then (no)

while(Has number of game shows been chosen?) is (no)
|System|
:Prints out a selection of game shows to choose from;
|Player|
while(Game show  been selected?) is (no)
:Selects a game show to play;
|System|
if(Has a valid selection been made?) then (yes)
:Add to list of game shows;
endif
end while
endwhile
else (yes)
:Generate list of gameshows;
endif
|Player|
:Confirm selection;
|System|
: Return list of game shows;
Stop

@enduml
```
Alternative Courses:
-----------
1. User may select and then deselect a given game show.
2. User may exit the game at any given moment
3. User may reshuffle random gameshows



