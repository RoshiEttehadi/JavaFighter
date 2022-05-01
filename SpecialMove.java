// Create the special moves menu 

public class SpecialMove extends Move
{
    private String type;
    private int point;

    public SpecialMove(String input)
    {
        String[] array = input.split(",");
        setName(array[0]);
        type = array[1];
        point = Integer.parseInt(array[2]);
    }

    public boolean isDamage() { return type.equals("Damage"); }

    public boolean isHealth()
    {
        return type.equals("Health");
    }
    public boolean isBribe() { return getName().equals("Bribed Referee"); }

    public int getPoint()
    {
        return point;
    }

    public String toString()
    {
        return getName();
    }

    public void display()
    {
        if (isBribe())
            System.out.println(getName() + " " + "(initial health reduced by " + point + ")");
        else if (isDamage())
            System.out.println(getName() + " " + "(causes " + point + " " + type.toLowerCase() + ")");
        else if (isHealth())
            System.out.println(getName() + " " + "(recovers " + point + " " + type.toLowerCase() + ")");
    }
    //If the special skill is to add health, the total health should not be > 100.
    public void performMove(Player player, Player opponent, Move opponentMove, Referee referee) {
        if (isDamage()) {
            int opponentHealth = opponent.getHealth();
            int value = point;

            if (opponentMove.getName().equals("Block"))
                value /= 2;

            opponentHealth = Math.max(0, opponentHealth - getPoint());
            opponent.setHealth(opponentHealth);

        } else if (isHealth()) {
            int playerHealth = player.getHealth();

            playerHealth = Math.min(100, playerHealth + point);
            player.setHealth(playerHealth);
        }
    }
}


