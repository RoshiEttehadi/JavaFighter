public class Kick extends Move {

    public Kick() {
        super("Kick");
    }

    public void performMove(Player player, Player opponent, Move opponentMove, Referee referee) {
        int opponentHealth = opponent.getHealth();
        int value = 20;

        if (opponentMove.getName().equals("Block"))
            value /= 2;

        opponentHealth = Math.max(0, opponentHealth - value);
        opponent.setHealth(opponentHealth);
    }
}
