```plantuml
title Class Diagram
' classes
'skinparam classAttributeIconSize 0


class MainActivity{
   -mainView: IMainView
   -player: Player
   -activeQuestion: Question
   -questionBase: IGameShow
   -continueGame: boolean
--
   # onCreate(Bundle savedInstanceState): void
   + resetGame(): void
   + getQuestion(): Question
   + rightAnswer(): Choice
   + questionNumber(): int
   + onWWM(): void
   + onRandom(): void
   + onMoreInfo(): void
   + onPlayAgain(): void
   + onMenu(): void
   + onNext(): void
   + onGoBack(): void
   + onSubmit(int index): void
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
   +getPrompt(): String
   +getChoice(int i): Choice
   +getCorrectChoice(): Choice
}
class Choice{
   -name : String
   -isCorrect: boolean
   --
   +toString(): String
   +getCorrect(): boolean
}
class Player{
-name: String
-wins: int
-answerStreak: int
-questionNumber: int
--
+rightAns(): void
+resetStreak(): void
}
interface IGameShow{
--
getQuestion(): Question
}
MainActivity "1" ---left-- "*" Question : "                         are-contained-in                        "
Question "\t1" -left-->"(1..*)" Choice:a component of
MainActivity "1\t" --right-- "1..*" Player: "      requires         "
MainActivity "1 " --down-- " 1 " IGameShow: " is-described-by"
class RandMultiChoice{
   -questionPool: ArrayList<Question>
   --
   +getQuestion()
}
IGameShow"\t   1\n\n\n\n" <|..left.."1\t" RandMultiChoice:" \t\t            is-formatted-by     \t\t\t                    "
RandMultiChoice "1 "--up-- " * " Question: " are-contained-in"
class ActiveQuestionFrag{
private binding: FragmentActiveQuestionBinding
private listener: Listener
--
+onCreateView(inflater, container, savedInstanceState): View
+onViewCreated(view, savedInstanceState): void
+numQuestion(): int
+curQuestion(): Question
}
class CorrectAnsFragment{
private binding: FragmentCorrectAnsBinding
private listener: Listener
--
+onCreateView(inflater, container, savedInstanceState): View
+onViewCreated(view, savedInstanceState): void
}
class GameLostFragment{
private binding: FragmentGameLostBinding
private listener: Listener
--
+onCreateView(inflater, container, savedInstanceState): View
+onViewCreated(view, savedInstanceState): void
+correctAnswerChoice(): Choice
}
class GameModeFragment{
private binding: FragmentGameModeBinding
private listener: Listener
--
+onCreateView(inflater, container, savedInstanceState): View
+onViewCreated(view, savedInstanceState): void
}
class GameWonFragment{
private binding: FragmentGameWonBinding
private listener: Listener
--
+onCreateView(inflater, container, savedInstanceState): View
+onViewCreated(view, savedInstanceState): void
}
class GameConfigFragment{
private binding: FragmentGameConfigBinding
private listener: Listener
--
+onCreateView(inflater, container, savedInstanceState): View
+onViewCreated(view, savedInstanceState): void
}
interface IActiveQuestionView{
   interface Listener{
       onSubmit(int index): void
       questionNumber(): int
       getQuestion(): Question
}
interface ICorrectAnsView{
   interface Listener{
       onNext(): void
}
interface IGameLostView{
   interface Listener{
       onPlayAgain(): void
       onMenu(): void
       rightAnswer(): Choice
}
interface IGameModeView{
   interface Listener{
       onGoBack(): void
}
interface IGameWonView{
   interface Listener{
       onPlayAgain(): void
       onMenu(): void
}
interface IGameConfigView{
   interface Listener{
       onWWM(): void
       onRandom(): void
       onMoreInfo(): void
}
interface IMainView{
--
+getRootView(): View
+displayFragment(fragment, reversible, name): void
}
class MainView{
fmanager: FragmentManager
binding: ActivityMainBinding
--
+getRootView(): View
+displayFragment(fragment, reversible, name): void
}
IMainView"1" .up.|> "1  "MainView: "Implemented-by"
IGameConfigView"1" .down.|> "1  "GameConfigFragment: "implements"
IGameWonView"1" .down.|> "1  "GameWonFragment: "implements"
IGameModeView"1" .down.|> "1  "GameModeFragment: "implements"
IGameLostView"1" .down.|> "1  "GameLostFragment: "implements"
ICorrectAnsView"1" .down.|> "1  "CorrectAnsFragment: "implements"
IActiveQuestionView"1" .down.|> "1  "ActiveQuestionFrag: "implements"
MainActivity"1" -up- "*"GameConfigFragment: "created-by"
MainActivity"1" -up- "*"CorrectAnsFragment: "created-by"
MainActivity"1" -up- "*"ActiveQuestionFrag: "created-by"
MainActivity"1" -up- "*"GameLostFragment: "created-by"
MainActivity"1" -up- "*"GameWonFragment: "created-by"
MainActivity"1" -up- "*"GameModeFragment: "created-by"
MainActivity"1" <|.up. "1"IGameConfigView : "listener implements"
MainActivity"1" <|.up. "1"IGameWonView: "listener implements"
MainActivity"1" <|.up. "1"IGameModeView: "listener implements"
MainActivity"1" <|.up. "1"IGameLostView: "listener implements"
MainActivity"1" <|.up. "1"ICorrectAnsView: "listener implements"
MainActivity"1" <|.up. "1"IActiveQuestionView: "listener implements"
MainActivity"1" -- "1"MainView: takes in


```

```plantuml
@startuml
hide footbox
mainFrame sd Configure Game
actor us as "User"
participant wwmb as "WWM: button"
participant rand as "Random: button"
participant ginfo as "More Info: button"
participant gback as "Go Back: button"
participant GCV as "GameConfigView"
participant MIV as "GameInfoView"
participant clr as "MainActivity (Controller)"
participant p1 as "p1: Player"
participant gs as "RandMultChoice: IGameShow"
alt First Iteration
clr -> p1 :player = new Player()
clr -> gs: questionbase = new RandMultChoice()
else Not First Iteration
clr -> p1: player.resetStreak()
clr -> gs: questionbase = new RandMultChoice()
end
clr -> GCV: Makes GameConfigView Fragment
GCV --> ginfo: setOnClickListener(this)
GCV --> rand: setOnClickListener(this)
GCV --> wwmb: setOnClickListener(this)
alt clickWWM
us --> wwmb: click "WWM"
wwmb -> GCV: \t\t\t\t\t\t\t\t\t\t\t\t\tonClick(this)
GCV -> clr: onWWM()
ref over clr
Play Games
end
else  clickRandom
us --> rand: click "Random"
rand -> GCV: \t\t\t\t\t\t\t\t\tonClick(this)
GCV -> clr: onRandom()
ref over clr
Play Games
end
else clickMoreInfo
us --> ginfo: click "More Info"
ginfo -> GCV: \t\t\t\t\tonClick(this)
GCV -> clr: onMoreInfo()
clr -> MIV: Makes GameInfoView Fragment
MIV --> gback:setOnClickListener(this)
us --> gback: click "Go Back"
gback -> MIV: \t\t\t\t\tonClick(this)
MIV -> clr:\t\t\tonGoBack()
ref over clr
Configure Game
end
end
@endUML
```


```plantuml
@startuml
hide footbox
mainFrame sd Play Game Round
actor us as "User"
participant sub as "Submit: button"
participant rdb as "RadioButton: button"
participant qtv as "QuestionText"
participant AQV as "ActiveQuestionView"
participant RAV as "CorrectAnswerView"
participant GLV as "GameLostView"
participant GWV as "GameWonView"
participant clr as "Main Activity (Controller)"
participant p1 as "p1: Player"
participant GS as "questionBase: RandMultiChoice"
participant QP as "questionPool: ArrayList<Question>"
participant QST as ":Question"
participant CA as "choices: choice Array"
participant CHC as ":Choice"
clr -> AQV: makes ActiveQuestion Fragment
AQV --> rdb: setOnClickListener(this)
AQV --> sub: setOnClickListener(this)
AQV -> clr: question = curQuestion();
clr -> GS: question = getQuestion()
GS -> QP: question = questionPool.get(int randIdx);
GS -> QP: \t\tquestionPool.remove(randIdx)
QP -> QST: activeQuestion = getQuestion()
clr -> AQV: Sends activeQuestion to ActiveQuestionView
AQV -> qtv: setText(question.getPrompt())
AQV -> rdb: setText(question.choice.toString())
alt radioButton noselection
loop !selection
us --> sub: click "Submit"
sub -> AQV: \t\t\t\t\t\t\t\t\t\t\t\t\t\tonClick(this)
AQV -> us: return Snackbar("No selection was made")
end
else radioButton.selectionMade
us --> rdb: click "Choice a", "Choice b", "Choice c", "Choice d"
us --> sub: click "Submit"
sub -> AQV: \t\t\t\t\t\t\t\t\t\t\t\t\t\tonClick(this)
AQV -> clr: \t\t\t\t\t\tonSubmit(int index)
end
clr -> QST: boolean continueGame = activeQuestion.isCorrect(index)
QST -> CA: choices.get(index)
CA -> CHC: continueGame = isCorrect()
alt continueGame
clr -> p1: player.rightans()
end
alt p1.answerStreak == 5
clr -> GWV: makes GameWon Fragment
else !continueGame
clr -> GLV: makes GameLost Fragment
else continueGame
clr -> RAV: makes CorrectAnsFragment
end
ref over clr
Play Game Round Extend
end
@enduml
```


```plantuml
@startuml
hide footbox
mainFrame sd Play Game Round Extend
actor us as "User"
participant MU as "Menu: button"
participant PA as "Play Again: button"
participant NB as "Next: button"
participant RAV as "CorrectAnswerView"
participant GWV as "GameWonView"
participant GLV as "GameLostView"
participant CLR as "MainActivity (Controller)"


ref over CLR
Play Game Round
end


alt answerStreak == 5
GWV --> PA: setOnClickListener(this)
GWV --> MU: setOnClickListener(this)
alt click Play Again
us --> PA: click "Yes"
PA -> GWV: onClick(this)
GWV -> CLR: onPlayAgain()
ref over CLR
Play Game Round
end
else click Menu
us --> MU: click "Menu"
MU -> GWV: onClick(this)
GWV -> CLR: onMenu()
ref over CLR
Configure Game
end
end
else continueGame
RAV --> NB: setOnClickListener(this)
us --> NB: click "Next"
NB -> RAV: onClick(this)
RAV -> CLR: OnNext()
ref over CLR
Play Game Round
end
else !continueGame
GLV --> PA: setOnClickListener(this)
GLV --> MU: setOnClickListener(this)
alt click Play Again
us --> PA: click "Yes"
PA -> GLV: onClick(this)
GLV -> CLR: onPlayAgain()
ref over CLR
Play Game Round
end
else click Menu
us --> MU: click "Menu"
MU -> GLV: onClick(this)
GLV -> CLR: onMenu()
ref over CLR
Configure Game
end
end
end
@enduml
```
