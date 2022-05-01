// Create the action menu
//Once this is complete the round begins as follows: The human user is asked to select one of the following action options

public class Move
{
    private String name;

    public Move() {}

    public Move(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public void performMove(Player player, Player opponent, Move opponentMove, Referee referee) {
        // Implement this in each subclass
        System.out.println("ERROR: NOT IMPLEMENTED");
    }
}


