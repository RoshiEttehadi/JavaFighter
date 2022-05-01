public class Player
{
    private int health;
    private SpecialMove specialMove;

    public Player(int health)
    {
        this.health = health;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public SpecialMove getSpecialMove() { return specialMove; }

    public void setSpecialMove(SpecialMove specialMove) {
        this.specialMove = specialMove;
        if (specialMove.isBribe())
            health += specialMove.getPoint();
    }
}
