import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Fighter
{
    private ArrayList<SpecialMove> specialMoves = new ArrayList<SpecialMove>();
    private ArrayList<Move> moves = new ArrayList<Move>();

    private Human human;
    private Computer computer;
    private Referee referee;

    public Fighter()
    {
        human = new Human(100);
        computer = new Computer(100);
        referee = new Referee();

    }

    public static void main(String[] args)
    {
        Fighter fighter = new Fighter();

        fighter.startProgram();
    }

// ReadFile "specialmoves.txt"
    public void readFile()
    {
        try
        {
            FileReader reader = new FileReader("specialmoves.txt");
            Scanner console = new Scanner(reader);
            while(console.hasNextLine())
            {
                // Add to ArrayList
                specialMoves.add(new SpecialMove(console.nextLine()));
            }
            reader.close();
        }catch (Exception e)
        {
            System.out.println("Error in reading file. Exiting...");
        }
//        String list = specialMoves.toString();
        System.out.println("Welcome to the \"Java Fighter\" Game!");
    }

    public void startProgram()
    {
        Random rand = new Random();
        Referee referee = new Referee();

        int numberOfMoves = 0;

        // When the game begins, this file should be read only one time. 
        readFile();

        // Create the human player with the initial health 100 
        System.out.println("Hello " + human.getUserName());

        System.out.println("Your initial Health is " + human.getHealth() + "!");
        System.out.println("The computer player's initial Health is " + computer.getHealth() + "!");

        // Ask player to choose the special moves
        SpecialMove specialMove = getSpecialMove();
        System.out.println("\n" + "You selected: " + specialMove.getName());
        human.setSpecialMove(specialMove);
        System.out.println("Your Health is " + human.getHealth() + "!" + "\n");


        moves.add(new Punch());
        moves.add(new Kick());
        moves.add(new Block());
        if (!specialMove.isBribe())
            moves.add(specialMove);
        moves.add(new Cheat());

        specialMove = specialMoves.get(rand.nextInt(specialMoves.size()));
        System.out.println("Computer player Selected: " + specialMove);
        computer.setSpecialMove(specialMove);
        System.out.println("The computer's Health is " + computer.getHealth()+ "!" + "\n");

        while (true) {
            numberOfMoves++;

            Move playerMove = getMove();
            Move computerMove = computer.getRandomMove();

            System.out.println("You have selected: " + playerMove.getName()+ "!");
            System.out.println("Computer Player has selected: " + computerMove.getName()+ "!" + "\n");

            referee.updateReferee();
            System.out.println(referee.getStatus() + "!" + "\n");

            playerMove.performMove(human, computer, computerMove, referee);
            computerMove.performMove(computer, human, playerMove, referee);

            System.out.println("Your Health is " + human.getHealth()+ "!");
            System.out.println("The computer's Health is " + computer.getHealth()+ "!" + "\n");

            if(human.getHealth() <= 0 || computer.getHealth() <= 0)
                break;
        }

        System.out.println("THE GAME IS OVER");
        String outcome;
        if (human.getHealth() > computer.getHealth())
            outcome = "The Winner is " + human.getUserName() + "!";
        else if (human.getHealth() == computer.getHealth())
            outcome = "THE GAME IS A DRAW";
        else
            outcome = "The Winner is the Computer Player!";

        System.out.println(outcome);

        writeFile(outcome, numberOfMoves);
    }



//    When the game ends, the winning player and the number of moves is written to a file called 'outcome.txt'.

    private void writeFile(String outcome, int numberOfMoves) {
        try{
            FileWriter writer = new FileWriter("outcome.txt");
            writer.append(outcome);
            writer.append("\n");
            writer.append("The number of moves was " + numberOfMoves + "!");

            writer.close();

        } catch (IOException e) {
            System.out.println("Error in writing to a file. Exiting...");
        }
    }


    //create a move menu
    public SpecialMove getSpecialMove()
    {
        System.out.println("\n" + "Please choose your special move:");

        // Show list of moves
        for (int i = 0; i < specialMoves.size(); i++) {
            System.out.print((i + 1) + ") ");
            specialMoves.get(i).display();
        }

        // Get player's move
        int choiceInt = getInputInRange(1, specialMoves.size());

        return specialMoves.get(choiceInt - 1);
    }

    private int getInputInRange(int min, int max) {
        Scanner console = new Scanner(System.in);

        while(true) {
            String choice = console.nextLine();
            int choiceInt;

            try {
                choiceInt = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
                continue;
            }

            // Make sure it is in the correct range
            if (choiceInt >= min && choiceInt <= max)
                return choiceInt;

            System.out.println("Please enter a value between " + min + " and " + max);
        }
    }

    public Move getMove()
    {
        System.out.println("Please choose your action:");

        // Show list of Actions
        for (int i = 0; i < moves.size(); i++) {
            System.out.print((i + 1) + ") ");
            System.out.println(moves.get(i).getName());
        }

        int choiceInt = getInputInRange(1, moves.size());

        return moves.get(choiceInt - 1);
    }
}
