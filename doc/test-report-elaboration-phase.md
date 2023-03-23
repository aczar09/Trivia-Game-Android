## Test 1: Invalid Answer
### User Input: 
Strings that are not A - D (not case-sensitive)
### Output:
```
Geography: 
How many federal states does Germany have? 
A) 16
B) 13
C) 25
D) 32

1
Invalid Answer, Please try again.
e
Invalid Answer, Please try again.
32
Invalid Answer, Please try again.
QWERTY
Invalid Answer, Please try again.
```
### Does this meet expectations?
Yes, this does meet expectations, as the only valid responses should be one of the
answer choices, so non A-D/a-d characters, numbers, or other Strings should not
register as valid.

## Test 2: Incorrect Answer on First Question
### User Input: 
A valid, but incorrect answer to a question
### Output:
```Sports & Leisure:
Which sport is played at The Billie Jean King Cup?
A) Baseball
B) Tennis
C) Athletics
D) Motorsports

a
Sorry wrong answer. The correct response was B. Tennis
GAME OVER
You got 0 question(s) right! Better luck next time!

```
### Does this meet expectations?
Yes, this does meet expectations, as a single round should end once a user answers
incorrectly to a question.

## Test 3: Multiple Correct Answers and An Incorrect Answer
### User Input: 
Multiple correct answers followed by an incorrect answer
### Output:
```

General Knowledge: 
In the Morse code, which letter is indicated by 3 dots? 
A) S
B) C
C) A
D) O

a
That's Right!!!
Science & Nature: 
An organic compound is considered an alcohol if it has what functional group? 
A) Hydroxyl
B) Aldehyde
C) Alkyl
D) Carbonyl

a
That's Right!!!
Geography: 
How many federal states does Germany have? 
A) 25
B) 16
C) 13
D) 32

c
Sorry wrong answer. The correct response was B. 16
GAME OVER
You got 2 question(s) right! Better luck next time!
```
### Does this meet expectations?
Yes, this does meet expectations, as a single round should end once a user answers
incorrectly to a question, and should print out their streak of questions accordingly.

## Test 4: All Correct Answers
### User Input: 
Every answer to questions are correct
### Output:
```
Animals: 
By definition, where does an abyssopelagic animal live? 
A) At the bottom of the ocean
B) Inside a tree
C) On top of a mountain
D) In the desert

a
That's Right!!!
Entertainment: 
The Internet Meme “All your base are belong to us” is based on the poorly translated English Version of which Video Game? 
A) Wing Commander
B) F-Zero
C) Star Wars: X-Wing
D) Zero Wing

d
That's Right!!!
Food & Drink: 
Where in the world are bell peppers originally from? 
A) Europe
B) Central America
C) China
D) Central Asia

b
That's Right!!!
Entertainment: 
Who is the main antagonist in the Portal franchise? 
A) GLaDOS
B) Rick
C) Wheatley
D) Chell

a
That's Right!!!
Geography: 
The Pyrenees mountains are located on the border of which two countries? 
A) France and Spain
B) Norway and Sweden
C) Italy and Switzerland
D) Russia and Ukraine

a
That's Right!!!
Congratulations!! You succesfully answered all 5 questions! You're a trivia master!

```
### Does this meet expectations?
Yes, as the user input the correct answer for all the questions in the round, 
thus resulting in corresponding congratulations message being printed

## Test 5: Questions Choices Shuffled
### User Input: 
User inputs the same response/answer choice for the same question
### Output:
```
Food & Drink: 
Where in the world are bell peppers originally from? 
A) China
B) Central Asia
C) Central America
D) Europe

c
That's Right!!!
...

Food & Drink: 
Where in the world are bell peppers originally from? 
A) Central America
B) Europe
C) Central Asia
D) China

c
Sorry wrong answer. The correct response was A. Central America
```
### Does this meet expectations?
Yes this does, as everytime a question appears, the choices should be shuffled
in a different order, and thus the correct input should be different as well.

## Test 6: Selecting to Play Multiple Rounds
### User Input: 
The number of rounds they'd like to play, and answering the question as previously shown.
### Output:
```
How many games would you like to play?
Choose your number:  3
Entertainment: 
Who is the main antagonist in the Portal franchise? 
A) Wheatley
B) GLaDOS
C) Chell
D) Rick

b
That's Right!!!
Geography: 
Conakry is the capital city of which country? 
A) Romania
B) Guinea
C) Lebanon
D) Barbados

c
Sorry wrong answer. The correct response was B. Guinea
GAME OVER
You got 1 question(s) right! Better luck next time!
Geography: 
The Pyrenees mountains are located on the border of which two countries? 
A) France and Spain
B) Norway and Sweden
C) Russia and Ukraine
D) Italy and Switzerland

a
That's Right!!!
Entertainment: 
Who is the main antagonist in the Portal franchise? 
A) Rick
B) Wheatley
C) Chell
D) GLaDOS

a
Sorry wrong answer. The correct response was D. GLaDOS
GAME OVER
You got 1 question(s) right! Better luck next time!
Entertainment: 
Who is the main antagonist in the Portal franchise? 
A) Rick
B) Chell
C) Wheatley
D) GLaDOS

b
Sorry wrong answer. The correct response was D. GLaDOS
GAME OVER
You got 0 question(s) right! Better luck next time!

```
### Does this meet expectations?
Yes, this does meet expectations. The user selected to play 3 rounds, they got 1 question
right the first round, 1 the second, and none the last. After each round, the
game resets and picks from the same pool of questions. This will change when we start
incorporating different game modes, as each round will be a different game and have 
a different pool of questions to pull from.

## Test 7: All Correct Answers, Multiple Rounds
### User Input: 
Selects to play 3 rounds of trivia, and then provides to correct answer to every question
### Output:
```
How many games would you like to play?
Choose your number:  3
Entertainment: 
Who is the main antagonist in the Portal franchise? 
A) Rick
B) Wheatley
C) Chell
D) GLaDOS

d
That's Right!!!
Geography: 
Which of these countries borders People's Republic of China? 
A) Cambodia
B) Tajikistan
C) Thailand
D) Bangladesh

b
That's Right!!!
Sports & Leisure: 
Which sport is played at The Billie Jean King Cup? 
A) Athletics
B) Tennis
C) Motorsports
D) Baseball

b
That's Right!!!
Science & Nature: 
Which horizon in a soil profile consists of bedrock? 
A) B
B) O
C) R
D) D

c
That's Right!!!
Society & Culture: 
Which of these people was an Italian explorer who landed in America? 
A) Napoleon Bonaparte
B) Martin Luther
C) Marco Polo
D) Christopher Columbus

d
That's Right!!!
Congratulations!! You succesfully answered all 5 questions! You're a trivia master!
Entertainment: 
The Internet Meme “All your base are belong to us” is based on the poorly translated English Version of which Video Game? 
A) Star Wars: X-Wing
B) Wing Commander
C) Zero Wing
D) F-Zero

c
That's Right!!!
Sports & Leisure: 
Which sport is played at The Billie Jean King Cup? 
A) Motorsports
B) Tennis
C) Baseball
D) Athletics

b
That's Right!!!
Geography: 
How many federal states does Germany have? 
A) 25
B) 13
C) 32
D) 16

d
That's Right!!!
Entertainment: 
Who is the main antagonist in the Portal franchise? 
A) GLaDOS
B) Chell
C) Rick
D) Wheatley

a
That's Right!!!
Celebrities: 
How tall is Tom Cruise? 
A) 5’ 5
B) 5’ 7
C) 5’ 4
D) 5’ 9

b
That's Right!!!
Congratulations!! You succesfully answered all 5 questions! You're a trivia master!
Geography: 
How many sovereign states are members of the United Nations? 
A) 178
B) 153
C) 195
D) 201

c
That's Right!!!
Science & Nature: 
An organic compound is considered an alcohol if it has what functional group? 
A) Hydroxyl
B) Aldehyde
C) Alkyl
D) Carbonyl

a
That's Right!!!
Geography: 
The Pyrenees mountains are located on the border of which two countries? 
A) Norway and Sweden
B) Russia and Ukraine
C) Italy and Switzerland
D) France and Spain

d
That's Right!!!
Entertainment: 
The Internet Meme “All your base are belong to us” is based on the poorly translated English Version of which Video Game? 
A) Wing Commander
B) Zero Wing
C) F-Zero
D) Star Wars: X-Wing

b
That's Right!!!
Celebrities: 
How old was Muhammad Ali when he died? 
A) 61
B) 56
C) N/A (Still alive)
D) 74

d
That's Right!!!
Congratulations!! You succesfully answered all 5 questions! You're a trivia master!
```
### Does this meet expectations?
Yes, this does meet expectations. The user selected to play 3 rounds, and answered
every question right (15 questions in total), getting the congratulations message
at the end of each round.

## Test 8: Invalid Number of Round Input
### User Input: 
Invalid number of rounds, then a valid number of rounds, then valid responses to questions
### Output:
```
Welcome to our trivia game
How many games would you like to play?
Choose your number:  0
Invalid number given. Please give valid number:  
-5
Invalid number given. Please give valid number:  
three
Invalid number given. Please give valid number:  
3
Arts & Literature: 
Which author wrote 'The Communist Manifesto'? 
A) Erich Maria Remarque
B) Friedrich Engels
C) Karl May
D) Michael Ende

a
Sorry wrong answer. The correct response was B. Friedrich Engels
GAME OVER
You got 0 question(s) right! Better luck next time!
Sports & Leisure: 
Which sport is played at The Billie Jean King Cup? 
A) Athletics
B) Motorsports
C) Tennis
D) Baseball

a
Sorry wrong answer. The correct response was C. Tennis
GAME OVER
You got 0 question(s) right! Better luck next time!
Food & Drink: 
Where in the world are bell peppers originally from? 
A) Central Asia
B) Europe
C) Central America
D) China

a
Sorry wrong answer. The correct response was C. Central America
GAME OVER
You got 0 question(s) right! Better luck next time!
```
### Does this meet expectations?
Yes, this does meet expectations. The program should only except integers greater than
0 as input for the number of rounds and should ask the user repeatedly until
that condition is met, and that number should be used to determine how many game
rounds are played, in this case, three.