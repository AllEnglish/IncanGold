import java.util.List;

public class Artifact extends Treasure
{
    protected boolean inTomb;
    
    public Artifact(int number, int value)
    {
        super(number, value);
        this.inTomb = true;
    }
    
    public Artifact(Artifact a)
    {
        super(a.number, a.value);
        this.inTomb = a.inTomb;
    }
    
    @Override
    public String name()
    {
        String nameOfArtifact;
        
        switch (this.number)
        {
            case 0:
                nameOfArtifact = "King Tut's Dagger";
                break;
            case 1:
                nameOfArtifact = "Ankh";
                break;
            case 2:
                nameOfArtifact = "Falcon Pectoral";
                break;
            case 3:
                nameOfArtifact = "Crook and Flail";
                break;
            case 4:
                nameOfArtifact = "Mask of Tutankhamun";
                break;
            default:
                nameOfArtifact = "Unknown";
                break;
        }
        
        return nameOfArtifact;
    }
    
    @Override
    public void share(List<Agent> receivers)
    {
        if (receivers.size() == 1 && !receivers.get(0).isInExploring() && this.inTomb)
        {
            receivers.get(0).possessionOfArtifacts.add(this);
            this.inTomb = false;
        }
    }
    
    @Override
    public String toString()
    {
        return String.format("<\u001B[33m%s\u001B[0m>", (this.inTomb ? this.name() : "---"));
        // return String.format("%s <Artifact %d with value %d>", this.name(), this.number, this.value);
    }
}
