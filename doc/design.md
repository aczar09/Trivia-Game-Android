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
participant "game : Game" as g


participant "p1 : Player" as p1
participant "gameshow : RandMultChoice" as rmc
participant "question : Question" as q
participant "choice : Choice" as c
[o-> g: correct = true
[o-> g: numGames = 5
[o-> g: wins = 0
g -->> p1 **: p1 = new Player()
g -->> rmc **: gameshow = new RandMultChoice()
loop numGames != wins && correct
g -->> rmc : question = rmc.pullQuestion()
rmc -->> q **: pullQuestion()
g -->> q: System.out.println(question)
g -->> p1 : p1Answer = p1.getAnswer()
g -->> q: correct = question.isCorrect(p1Answer)
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