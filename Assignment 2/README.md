# Project Title: Rock-Paper-Scissors Game Simulator
A Java console application that simulates 1000 rounds of Rock-Paper-Scissors against a computer, calculating the total accumulated reward based on a fixed player strategy. This project was completed for the BMME008 - Programming for Managers course.

# Project Description
This program automates a game of Rock-Paper-Scissors to test a specific strategy over a large number of rounds. The computer's moves are chosen randomly, while the player employs a fixed, repeating sequence of moves. The primary goal is to determine the final reward after 1000 rounds based on the outcome of each game (win, lose, or tie).
Game Rules & Strategy
1. The simulation follows these rules:
- Reward System:
Win: +$5

Tie: +$2

Loss: -$1

- Strategies:
- 
Player Strategy: A fixed, repeating sequence of moves is used:
Round 1: Scissors
Round 2: Rock
Round 3: Paper
Round 4: Scissors (and so on...)
- Computer Strategy: The computer chooses its move (Rock, Paper, or Scissors) randomly in each round.

2. Features
- Simulates a loop of 1000 rounds.
- Implements the player's sequential strategy.
- Generates a random move for the computer in each iteration.
- Calculates the outcome (win, lose, or tie) based on the classic Rock-Paper-Scissors rules.
- Maintains and updates a running total of the player's reward.
- Displays the final accumulated reward after the simulation is complete.
