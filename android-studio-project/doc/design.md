```plantuml
title Class Diagram
' classes
'skinparam classAttributeIconSize 0




class MainActivity{
  -PLAYER: String
  -AQUESTION: String
  -mainView: IMainView
  -player: Player
  -activeQuestion: Question
  -questionBase: IGameShow
  -persistenceFacade: IPersistenceFacade
  -continueGame: boolean
  -curCategory: String
  -curMode: String
  -bestCategory: String
  -bestMode: String
--
  # onCreate(Bundle savedInstanceState): void
  # onSavedInstanceState(Bundle outstate): void
  + onPlayerReceived(Player player): void
  + onDatabaseReceived(IGameShow database): void
  + resetGame(): void
  + getActiveQuestion(): Question
  + getQuestion(): Question
  + rightAnswer(): Choice
  + questionNumber(): int
  + getCategory(): String
  + getBestCategory(): String
  + getBestMode(): String
  + getNumberWins(): String
  + getNumberQuestionsCorrect(): String
  + onStats(): void
  + onWWM(): void
  + onCategoriesMode(): void
  + onGeo(): void
  + onTV(): void
  + onHobbies(): void
  + onSports(): void
  + onRandom(): void
  + onRandomCat(): void
  + onTrivialPursuit(): void
  + onMoreInfo(): void
  + onPlayAgain(): void
  + onMenu(): void
  + onNext(): void
  + onGoBack(): void
  + onSubmit(int index): void
}
class Question{
  -prompt: String
  -category: String
  -choices: List<Choice>
  --
  +toString(): String
  +isCorrect(int selection): boolean
  +getPrompt(): String
  +getCategory(): String
  +getChoice(int i): Choice
  +getCorrectChoiceInd(): int
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
+answerStreak: int
+questionNumber: int
+totalQuestionsCorrect: int
+ totalWins: int
+ categoryScores: Map<String, Integer>
+ modeScores: Map<String, Integer>
--
+rightAns(): void
+addWin(): void
+resetStreak(): void
+addCategoryWin(category): void
+addModeWin(mode):void
+getName(): String
+getWins(): int


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
- binding: FragmentActiveQuestionBinding
- listener: Listener
--
+onCreateView(inflater, container, savedInstanceState): View
+onViewCreated(view, savedInstanceState): void
+numQuestion(): int
+curQuestion(): Question
}
class CorrectAnsFragment{
- binding: FragmentCorrectAnsBinding
- listener: Listener
--
+onCreateView(inflater, container, savedInstanceState): View
+onViewCreated(view, savedInstanceState): void
}
class GameLostFragment{
- binding: FragmentGameLostBinding
- listener: Listener
--
+onCreateView(inflater, container, savedInstanceState): View
+onViewCreated(view, savedInstanceState): void
+correctAnswerChoice(): Choice
}
class GameModeFragment{
- binding: FragmentGameModeBinding
- listener: Listener
--
+onCreateView(inflater, container, savedInstanceState): View
+onViewCreated(view, savedInstanceState): void
}
class GameWonFragment{
- binding: FragmentGameWonBinding
- listener: Listener
--
+onCreateView(inflater, container, savedInstanceState): View
+onViewCreated(view, savedInstanceState): void
}
class GameConfigFragment{
- binding: FragmentGameConfigBinding
- listener: Listener
--
+onCreateView(inflater, container, savedInstanceState): View
+onViewCreated(view, savedInstanceState): void
+topCategory(): String
}
interface IActiveQuestionView{
}
interface IActiveQuestionView.Listener{
--
      onSubmit(int index): void
      questionNumber(): int
      getQuestion(): Question
      getCategory(): String
      getActiveQuestion(): Question
}


interface ICorrectAnsView{


}


interface ICorrectAnsView.Listener{
--
   onNext(): void
}


interface IGameLostView{


}
interface IGameLostView.Listener{
--
      onPlayAgain(): void
      onMenu(): void
      rightAnswer(): Choice
}


interface IGameModeView{


}
interface IGameModeView.Listener{
--
   onGoBack(): void
}


interface IGameWonView{


}
interface IGameWonView.Listener{
--
      onPlayAgain(): void
      onMenu(): void
}


interface IGameConfigView{


}
interface IGameConfigView.Listener{
--
      onWWM(): void
      onRandom(): void
      onMoreInfo(): void
      onCategoriesMode(): void
      onTrivialPursuit(): void
      getBestCategory(): String
}


interface IMainView{
--
+getRootView(): View
+displayFragment(fragment, reversible, name): void
}
interface ICategoriesModeView{
}
interface ICategoriesModeView.Listener{
--
onGeo(): void
onTV(): void
onHobbies(): void
onSports(): void
onRandomCat(): void
onGoBack(): void
}
class CategoriesModeFragment{
- binding: FragmentCategoriesModeBinding
- listener: Listener
--
+onCreateView(inflater, container, savedInstanceState): View
+onViewCreated(view, savedInstanceState): void
}
class MainView{
fmanager: FragmentManager
binding: ActivityMainBinding
--
+getRootView(): View
+displayFragment(fragment, reversible, name): void
}


class TriviaTimeFragFactory{
- VIEW_PACKAGE: String
- controller: MainActivity
--
+instantiate(classLoader, className): Fragment
}

interface IStatsView{

}
interface IStatsView.Listener{
}
class StatsFragment{
-binding: FragmentStatsBinding
-listener: Listener
--
+onCreateView(infalter, container, savedInstanceState): View
+onViewCreated(view, savedInstanceState): void
+topCategory(): String
+topMode(): String
+numWins(): String
+numQuestionsCorrect(): String
}

TriviaTimeFragFactory"1" -right- "1"MainActivity: "allows screen rotations for"
IStatsView "1" <|.up. "1" StatsFragment: "implements"
ICategoriesModeView "1" <|.up. "1 "CategoriesModeFragment: "implements"
IMainView"1" <|.up. "1  "MainView: "implements"
IGameConfigView"1" <|.down. "1  "GameConfigFragment: "implented-by"
IGameWonView"1" <|.down. "1  "GameWonFragment: "implented-by"
IGameModeView"1" <|.down. "1  "GameModeFragment: "implented-by"
IGameLostView"1" <|.down. "1  "GameLostFragment: "implented-by"
ICorrectAnsView"1" <|.down. "1  "CorrectAnsFragment: "implented-by"
IActiveQuestionView"1" <|.down. "1  "ActiveQuestionFrag: "implented-by"
MainActivity"1" -up- "*"GameConfigFragment: "created-by"
MainActivity"1" -up- "*"CorrectAnsFragment: "created-by"
MainActivity"1" -up- "*"ActiveQuestionFrag: "created-by"
MainActivity"1" -up- "*"GameLostFragment: "created-by"
MainActivity"1" -up- "*"GameWonFragment: "created-by"
MainActivity"1" -up- "*"GameModeFragment: "created-by"
MainActivity"1" -right- "*" CategoriesModeFragment: "creates"
MainActivity"1" -right- "*" StatsFragment: "creates"
MainActivity"1" .up.|> "1"IGameConfigView.Listener : "implented-by"
MainActivity"1" .up.|> "1"IGameWonView.Listener: "implented-by"
MainActivity"1" .up.|> "1"IGameModeView.Listener: "implented-by"
MainActivity"1" .up.|> "1"IGameLostView.Listener: "implented-by"
MainActivity"1" .up.|> "1"ICorrectAnsView.Listener: "implented-by"
MainActivity"1" .up.|> "1"IActiveQuestionView.Listener: "implented-by"
MainActivity"1" .right.|> "1" ICategoriesModeView.Listener: "implents"
MainActivity"1" .right.|> "1" IStatsView.Listener: "implemens
MainActivity"1" -- "1"MainView: takes in




interface IPersistenceFacade{
--
retrieveDatabase(listener): void
saveDatabase(database): void
}
interface IPersistenceFacadeListener{
--
onDatabaseReceived(database): void


}


class LocalStorageFacade{
- file: File
- file2: File
--
+retrieveDatabase(listener): void
+saveDatabase(database): void
+retrievePlayer(listener): void
+savePlayer(player): void
}
class QuestionDatabase{
   -database: Map<String, List<Question>>
   --
   +readQuestions(category, inputStream): void
  
}
IPersistenceFacade"1" <|.up. "1"LocalStorageFacade: "implented-by"
IPersistenceFacadeListener .left.|> MainActivity: "implented-by"
MainActivity -down- LocalStorageFacade: "has info stored locally in"
QuestionDatabase -right- RandMultiChoice: "feeds questions to"

```

```plantuml
@startuml
hide footbox
mainFrame sd Configure Game
actor us as "User"
participant wwmb as "WWM: button"
participant stb as "Stats: button"
participant cmb as "Categories: button"
participant tpb as "Trivial Pursuit: button"
participant rand as "Random: button"
participant ginfo as "More Info: button"
participant gback as "Go Back: button"
participant GCV as "GameConfigView"
participant MIV as "GameInfoView"
participant clr as "MainActivity (Controller)"
participant p1 as "p1: Player"
participant gs as "RandMultChoice: IGameShow"
participant pf as "persistenceFacade: IPersistenceFacade"
alt First Iteration
clr -> p1 :player = new Player()
clr -> gs: questionbase = new RandMultChoice()
else Not First Iteration
clr -> pf: player = persistenceFacade.retrievePlayer(this)
clr -> pf: questionbase = persistenceFacade.retrieveDatbase(this)
end
clr -> GCV: Makes GameConfigView Fragment
GCV --> ginfo: setOnClickListener(this)
GCV --> rand: setOnClickListener(this)
GCV --> tpb: setOnClickListener(this)
GCV --> cmb: setOnClickListener(this)
GCV --> stb: setOnClickListener(this)
GCV --> wwmb: setOnClickListener(this)
alt clickWWM
us --> wwmb: click "WWM"
wwmb -> GCV: \t\t\t\t\t\t\t\t\t\t\t\t\tonClick(this)
GCV -> clr: onWWM()
ref over clr
Play Games
end
else clickCateogriesMode
us --> cmb: click "Categories Mode"
cmb -> GCV: onClick(this)
GCV -> clr: OnCategoriesMode()
ref over clr
Play Game Round
end 
else clickTrivialPursuit
us --> tpb: click "Trivial Pursuit"
tpb -> GCV: onClick(this)
GCV -> clr: onTrivialPursuit()
ref over clr
Play Game Round
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
else clickStats
us --> stb: click "Stats"
stb -> GCV: onClick(this)
GCV -> clr: onStats()
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
participant CMV as "CategoriesModeView"
participant clr as "Main Activity (Controller)"
participant p1 as "p1: Player"
participant GS as "questionBase: RandMultiChoice"
participant QP as "questionPool: ArrayList<Question>"
participant QST as ":Question"
participant CA as "choices: choice Array"
participant CHC as ":Choice"
alt CategoriesMode first-round or Trivial Pursuit
clr --> CMV: Makes "CategoriesModeView"
CMV -> us: Displays various category options
us --> CMV: User selects category of question to play
end
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