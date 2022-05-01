import java.util.Scanner;

public class Human extends Player
{
    private String name;

    public Human(int health)
    {
        super(health);
    }

    // requests the player to enter their name, 
    public String getUserName()
    {
        if (name == null) {
            Scanner console = new Scanner(System.in);

            while (true) {
                System.out.println("Please enter your name:");
                name = console.nextLine().trim();

                // which cannot be blank and can only be between 3 and 12 characters (inclusive) in length, otherwise ask to reenter.
                if (name.length() == 0)
                    System.out.println("The field can't be blank, please re-enter your name!");
                else if (name.length() < 3 || name.length() > 12)
                    System.out.println("The name can't be less than 3 and more than 12 characters!Please re-enter your name");
                else
                    break;
            }
        }

        return name;
    }
}
