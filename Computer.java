import java.util.Random;

public class Computer extends Player
{
    public Computer(int health)
    {
        super(health);
    }


    // The computer user randomly select an action options based on the defined probabilities
    //25%(0.25) chance to punch, 25%(0.25) chance to kick, 20%(0.2) chance to block, (0.2)20% chance to use special move, (0.1)10% chance to cheat.


    public Move getRandomMove() {
        Random rand = new Random();

        while (true) {
            double probability = rand.nextDouble();

            if (probability <= 0.25) {
                return new Punch();
            } else if (probability <= 0.50) {
                return new Kick();
            } else if (probability <= 0.70) {
                return new Block();
            } else if (probability <= 0.90) {
                if (!getSpecialMove().isBribe())
                    return getSpecialMove();
            } else {
                return new Cheat();
            }
        }
    }
}

