import java.util.ArrayList;
import java.util.List;

public abstract class Agent // implements Comparable<Agent>
{
    protected final int type;
    protected boolean inExploring;
    protected int gems;
    protected int gemsInsideTent;
    protected ArrayList<Artifact> possessionOfArtifacts;
    
    public Agent(int type)
    {
        this.type = type;
        this.inExploring = false;
        this.possessionOfArtifacts = new ArrayList<>();
    }
    
    public int getType()
    {
        return this.type;
    }
    
    public boolean isInExploring()
    {
        return this.inExploring;
    }
    
    public void setInExploring(boolean inExploring)
    {
        this.inExploring = inExploring;
    }

    public int getGems()
    {
        return this.gems;
    }
    
    public int getGemsInsideTent()
    {
        return this.gemsInsideTent;
    }
    
    public void addGems(int gems)
    {
        this.gems += gems;
    }

    public void storeGemsIntoTent()
    {
        this.gemsInsideTent += this.gems;
        this.gems = 0;
    }

    public void flee()
    {
        this.gems = 0;
        this.inExploring = false;
    }
    
    // the name of this method and it's varible are temporary
    public int totalValue()
    {
        int xv = 0;
        for (Artifact af : this.possessionOfArtifacts)
            xv += af.getValue();
        return this.gemsInsideTent + xv;
    }
    
    @Override
    public String toString()
    {
        return String.valueOf(this.type);
    }

    public final void act(Game g)
    {
        // do something complicated to divide the argument "game" into the three parameter for act() method.
        // for those who want to make their own computer logic, it only needs to override decision() method and return a boolean value.
        // NOTICE 1: for some reason, this method should be final...
        // NOTICE 2: we cannot pass "game.path" into decision() directly, but the deep-copied one.
        
        if (this.inExploring)
        {
            GameData data = new GameData(g);
            this.inExploring = this.decision(data);

            try
            {
                int millisecond = (int)(Math.random() * 100);
                Thread.sleep(millisecond);
                System.out.println("    " + this.getClass().getName() + " " + this.type + " decided! (" + (millisecond / 1000.0) + "s)");
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public abstract boolean decision(GameData data);
}
