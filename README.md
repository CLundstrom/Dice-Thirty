### Game structure

#### Main Activity

Welcome screen. Starts a game of Thirty.

#### GameActivity

Provides the Game Logic.


10 rounds.

One round:

Throws 6 dices. Choose the ones you want to save. Rethrow others.

Choose to count as x.
Sum amount of ways to x. Add score.

Example: 

6 6 2 1 3 -> Rethrow 2,1,3

6 6 6 1 2 -> Rethrow 1,2

6,6,6,4,3 -> Round 1 Score: 

Choose 6 combination as score -> 18 points.

Remove 6 from available score picks.

Repeat 10 times.

Throws 3*10 = 30. Hence Thirty.

#### ResultActivity

Displays the final score.


