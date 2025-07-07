package assignment2;

//Total Reward after 1000 games: 1949

public class RockPaperScissors {

	public static void main(String[] args) {
        int totalReward = 0;
        int rounds = 1000;
        
        // Player's strategy sequence: Scissors (3), Rock (1), Paper (2)
        int[] playerMoves = {3, 1, 2};
        int playerIndex = 0;
        
        for (int i = 0; i < rounds; i++) {
            int playerChoice = playerMoves[playerIndex]; // Get player's move from sequence
            int computerChoice = 1 + (int)(3 * Math.random()); // Random choice for computer (1, 2, or 3)
            
            // Determine the result of the game
            if (playerChoice == computerChoice) {
                totalReward += 2; // Tie
            } else if ((playerChoice == 1 && computerChoice == 3) || // Rock beats Scissors
                       (playerChoice == 2 && computerChoice == 1) || // Paper beats Rock
                       (playerChoice == 3 && computerChoice == 2)) { // Scissors beat Paper
                totalReward += 5; // Win
            } else {
                totalReward -= 1; // Loss
            }
            
            // Move to the next strategy in sequence (Scissors -> Rock -> Paper)
            playerIndex = (playerIndex + 1) % 3;
        }
        
        // Display the total reward
        System.out.println("Total Reward after " + rounds + " games: " + totalReward);
    }
}