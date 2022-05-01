public class Punch extends Move {

    public Punch() {
        super("Punch");
    }

    public void performMove(Player player, Player opponent, Move opponentMove, Referee referee) {
        int opponentHealth = opponent.getHealth();
        int value = 10;

        if (opponentMove.getName().equals("Block"))
            value /= 2;

        opponentHealth = Math.max(0, opponentHealth - value);
        opponent.setHealth(opponentHealth);
    }

}
