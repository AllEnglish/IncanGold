public class Hazard extends Card
{
    public Hazard(int number)
    {
        super(number);
    }
    
    public Hazard(Hazard h)
    {
        super(h.number);
    }
    
    @Override
    public String name()
    {
        String nameOfHazard;
        
        switch (this.number)
        {
            case 0:
                nameOfHazard = "Booby Trap";
                break;
            case 1:
                nameOfHazard = "Spiders";
                break;
            case 2:
                nameOfHazard = "Mummy";
                break;
            case 3:
                nameOfHazard = "Curse";
                break;
            case 4:
                nameOfHazard = "Rockslide Trap";
                break;
            default:
                nameOfHazard = "Unknown";
                break;
        }
        
        return nameOfHazard;
    }
    
    @Override
    public String toString()
    {
        return "<\u001B[31m" + this.name() + "\u001B[0m>";
        // return String.format("%s <Hazard %d>", this.name(), this.number);
    }
}
