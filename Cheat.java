public class Cheat extends Move {

    public Cheat() {
        super("Cheat");
    }

    //    Cheat (causes 40 damage if the referee was not looking, causes -20 health if the referee was looking).
    // This penalty does not apply if the players special move is that of ‘Bribed Referee’.
    public void performMove(Player player, Player opponent, Move opponentMove, Referee referee) {
        if (!referee.isLooking()) {
            int opponentHealth = opponent.getHealth();
            int value = 40;

            if (opponentMove.getName().equals("Block"))
                value /= 2;

            opponentHealth = Math.max(0, opponentHealth - value);
            opponent.setHealth(opponentHealth);
        } else if (!player.getSpecialMove().isBribe()) {
            int playerHealth = player.getHealth();
            int value = 20;

            playerHealth = Math.max(0, playerHealth - value);
            player.setHealth(playerHealth);
        }
    }
}

