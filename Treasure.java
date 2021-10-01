public abstract class Treasure extends Card
{
    protected final int value;
    // always show $value on either Artifact or Gemstone card, NOT $currentValue!
    
    public Treasure(int number, int value)
    {
        super(number);
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }

    public abstract void share(ArrayList<Agent> receivers);
}
