import java.util.Collections;

public class Game implements Runnable
{
    protected int round;
    ArrayList<Agent> playerList = new ArrayList<>();
    ArrayList<Card> deck = new ArrayList<>();
    ArrayList<Card> fold = new ArrayList<>();
    ArrayList<Card> path = new ArrayList<>();

    public Game()
    {
        this.number = number;
    }

    public void deckShffule()
    {
        Collections.shuffle(this.deck);
    }

    public void flop()
    {
        this.path.add(this.deck.remove(0));
    }

    public int getRound()
    {
        return this.round;
    }

    public boolean checkAllBack()
    {
        boolean isAllBack = false;
        for (Player p : this.playerlist)
            isAllBack |= p.status;
        return !isAllBack ;
    }
}
