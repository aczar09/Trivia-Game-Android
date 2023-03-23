
```plantuml
title Class Diagram
' classes
'skinparam classAttributeIconSize 0 
class TextUI{
--
+main(String[] args): void
+ playSingleGame(Game g): void
+ getAnswer(): int
}
class Game{
    -numGames: int
    - correct = true: boolean
    - correctRecord = 0: int
--
    + checkAnswer(Question q, int index): String
}
class Question{
    -prompt: String
    -difficulty: String
    -category: String
    -questionType: String
    -choices: array[Choice]
    --
    +toString(): String
    +isCorrect(int selection): boolean
    
}
class Choice{
    -name : String
    -correct: boolean
    --
    +toString(): String
    +getCorrect(): boolean
}
class Player{
-name: String
-wins: int
}
interface IGameShow{
--
    getQuestion(): Question
}
Game "1" ---left-- "*" Question : "                         are-contained-in                        "
Question "\t1" -left-->"(1..*)" Choice:choices\n{random order, arrayList}
Game "1\t" --right-- "1..*" Player: "      requires         "
Game "1 " --down-- " 1 " IGameShow: " is-described-by"
class RandMultiChoice{
    -questionPool: ArrayList<Question>
    --
    +getQuestion(): Question
    +getQuestion(String category, String difficulty, String questionType): Question
}
IGameShow"\t   1\n\n\n\n" <|..left.."1\t" RandMultiChoice:"        is-formatted-by                    "
RandMultiChoice "1 "--up-- " * " Question: " are-contained-in"
Game "1" -up-- "1" TextUI: " interacts with "
```

```plantuml
@startuml
hide footbox
mainframe sd Configure Game
actor "User" as us
actor "User" as us 
participant "TextUI" as tui 
participant "Game (controller)" as clr 
participant "p1: Player" as p1
tui -> us: num = gameSetUp()
us -> tui: Inputs number of games to play
tui --> clr: g = new Game(num)
ref over clr
Play Game
end
```
```plantuml
@startuml
hide footbox
mainframe sd Play Game
actor "User" as us 
participant "TextUI" as tui 
participant "Game (controller)" as clr 
participant "p1: Player" as p1
clr --> p1: p1 = new Player()
loop gameCount < g.numGames
tui -> clr: playSingleGame(g)
loop g.correct && (g.correctRecord < 5)
ref over clr
Play Game Round
end
end
alt g.correct
clr -> p1: p1.wins++
tui -> us: Print("Game Won")
else !g.correct
tui -> us: Print("Game Lost")
end
tui -> clr: g.resetGame()
end

```
```plantuml
@startuml
hide footbox
mainframe sd Play Game Round
actor "User" as us 
participant "TextUI" as tui 
participant "Game (controller)" as clr
participant RandMultiChoice as rmc
participant "QuestionPool: arraylist" as qp

clr -> rmc: getQuestion(RandMultiChoice)
rmc -> qp: qt = QuestionPool.get(int ranIdx)
rmc -> qp: QuestionPool.remove(int ranIdx)

clr -> tui: Provides question for UI
tui -> us: System prints out question
loop !valid
tui -> us: int index = getAnswer()
us -> tui: Reads question and inputs response
end
tui -> clr: Provides valid answer index
participant "choices: choice array" as chc
clr -> chc:\ts = checkAnswer(Question q, int index)
participant "c: Choice" as cc 
chc -> cc: correct = choices.get(int index).correct
clr -> tui: Provides whether index is correct 
alt correctResponse
tui -> us: Print("Congrats")
tui -> clr: g.correctRecord++ 
else !correctResponse
tui -> us: Print("Failure")
tui -> clr: g.correct = false
end


@enduml
``` 
