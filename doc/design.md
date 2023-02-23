| Class           | Methods                | Fields                                                              |
|-----------------|------------------------|---------------------------------------------------------------------|
| Game            | PlaySingleGame() <br/> |                                                                     |
| Player          |                        |                                                                     |
| Question        |                        | Physical ? :: String. <br/>Choices: a, b ,c, d <br/> Correct Answer |
| Response Record |                        |                                                                     |
|                 |                        |                                                                     |
|                 |                        |                                                                     |
| Stats Record    |                        |                                                                     |   

```plantuml
title Class Diagram
' classes
class Game{
main()
playSingleGame()
answerQuestion()
}
class Question{
    prompt: String
    choices: array[Choice]
    toString(): String
    
}
class Choice{
    name : String
    correct: boolean
    toString(): String
}
class Player{
name: String
correctRecord: int
}
interface IGameShow{
    pullQuestion(): Question
}
Game "1" -- "*" Question : contains 1...*
Question -- Choice
Game -- Player
Game "1"-- " 1 " IGameShow
class RandMultChoice{
    pullQuestion(): Question
}
IGameShow -- RandMultChoice
```
```plantuml
@startuml
title:Single Player MCQ Game Flow
participant "game : Game" as g
participant "p1 : Player" as p1
participant "gameshow : RandMultChoice" as rmc
participant "question : Question" as q
[o-> g: correct = true
[o-> g: numGames = 5
[o-> g: wins = 0
g -->> p1 **: p1 = new Player()
g -->> rmc **: gameshow = new RandMultChoice()
loop numGames != wins && correct
g -> rmc : question = rmc.pullQuestion()
rmc -->> q **: pullQuestion()
ref over rmc
Pulling Question
end ref
g -> q: print(question)
g -> p1 : p1Answer = p1.getAnswer()
g -> q: correct = question.isCorrect(p1Answer)
alt correct
[o-> g : win++
end
end

alt correct
[o-> g : print("Congrats")
else !correct
[o-> g : print("Failure")
end

@enduml

```

```plantuml
@startuml

mainframe sd Pulling Question

participant "gameshow : RandMultChoice" as rmc
participant "questionPool : Set<Question>" as qp
[o-> rmc: pullQuestion()
rmc -->> qp:: q = questionPool.getQ(category, difficulty, format, hasConditions)

ref over qp
Getting Question from the Question Pool
end ref

@enduml

```

```plantuml
@startuml
mainframe sd Getting Question from the Question Pool
participant "gameshow : RandMultChoice" as rmc
participant "questionPool : Set<Question>" as qp
participant "randomQ : Question" as q
rmc -> qp: getQ(category, difficulty, format, hasConditions)
[o-> qp: validQ = false
loop !validQ or !hasConditions
qp -->> q **: randomQ = get(randomSelection)
qp-> q: validQ = (randomQ.category == category) \n && (randomQ.difficulty == difficulty) \n && (randomQ.format == format)
end
qp -> rmc: return randomQ 
@enduml
```
