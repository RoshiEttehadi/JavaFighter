import java.util.Random;

//However, for the special move 'Bribed referr', it only comes into effect during the start when the player
// (either human or computer) is being setup, leading to the player's initial health being reduced by 50 points,
// and this special move is not applicable for each turn.
//The only stats of the referee are looking or not looking.
// For each turn this is randomly selected only AFTER the players have made a choice for
// their action that turn. If the special move selected is ‘bribed referee’ then this setting does not impact the player.
public class Referee {
    private boolean looking;

    public Referee() {
        updateReferee();
    }

    public boolean isLooking() { return looking; }

    public boolean updateReferee() {
        Random rd = new Random();
        looking = (rd.nextDouble() <= 0.50);
        return false;
    }

    public String getStatus() {
        if (looking)
            return "The referee is looking";
        else
            return "The referee is not looking";
    }
}


