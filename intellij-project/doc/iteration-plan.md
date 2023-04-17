
# Iteration 1 Plan

| Rank   | Requirements                          | Comments                                                                           |
|--------|---------------------------------------|------------------------------------------------------------------------------------|
| High   | Single Player Game Mode               | Vital, as it the most basic mode and whole point of the app                        |
| High   | Giving a question                     | Vital, as questions make up trivia                                                 |
| High   | Answering a question                  | Vital, as answers have to be correct or incorrect                                  | 
| Medium | Choosing a category                   | It is not as important as not every game requires players to choose their category |
 | Medium | Breakout for Incorrect Response       | Can implement this in different ways, for instance a fixed amount of questions     |
 | Medium | Player answers 10 questions correctly | Same reason as incorrect response breakout                                         |
 | Low    | Multiplayer Game Mode                 | Not as important, as ot os riskier to implement                                    |
| Low    | Choosing a Random Game Mode           | Not important, but a cool add-on                                                   |
| Low    | Post Results                          | Not required to function, but nice added feature                                   |


# Iteration 2 Plan

| Rank   | Requirements                         | Comments                                                                                                                                     |
|--------|--------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------|
| High   | Multiple Game Modes                  | Expanding on the existing structure of the game                                                                                              |
| High   | Question Database                    | Need to switch over to a format that is more scalable than manually inputting every question into the program                                |
| Medium | Choosing a game modes                | Essential to game in long-term, but first must make sure the modes work first on their own                                                   |
| Medium | Choosing questions based on criteria | Depending on the game mode, access specific questions based on category, difficulty, etc; Main way game modes feel different from each other |
| High   | Multiplayer Game Mode                | Not as important, as ot os riskier to implement                                                                                              |
| Low    | Choosing a Random Game Mode          | Not important, but a cool add-on                                                                                                             |
| Low    | Post Results                         | Not required to function, but nice added feature                                                                                             |
### Requirements Update
While working on iteration 1, we realized that we need to put more emphasis on 
pulling questions from a database. In this iteration, we have only manually inputted questions, but we would
like to expand further and create a simpler way of pulling questions. Thi will shift our
attention away from the multiplayer setting for now. 

# Iteration 3 Plan
| Rank   | Requirements                         | Comments                                                                                                                                                |
|--------|--------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| High   | Question Database                    | Need to switch over to a format that is more scalable than manually inputting every question into the program, and that runs properly on Android studio |
| High   | Choosing questions based on criteria | Depending on the game mode, access specific questions based on category, difficulty, etc; Main way game modes feel different from each other            |
| High   | Multiple Game Modes                  | Expanding on the existing structure of the game                                                                                                         |
| Medium | Choosing a game modes                | Structure is there to have buttons for different modes                                                                                                  |
| Low    | Multiplayer Game Mode                | Not as important, as ot os riskier to implement                                                                                                         |
| Low    | Choosing a Random Game Mode          | Not important, but a cool add-on                                                                                                                        |
| Low    | Post Results                         | Not required to function, but nice added feature                                                                                                        |

### Requirements Update
While working on iteration 2, most of our time was spent transferring existing functionality of our game to the Android
platform. As well, while in the text-based game we were able to come up with a way to get a large database of questions,
when trying to implement it into Android, it provided many errors, and thus we decided to revert back to our hard coded
Questions for now so we could focus on basic functionality. In the next iteration, we will focus on getting
that database working, and then thinking how we could our existing structure to create new Game Mode variants.
