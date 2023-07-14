import java.util.Random;

public class dice {
    
    private int value;
    Random rand = new Random();

    public dice()
    {
        roll();
        rand = new Random();
    }

    public void roll()
    {
        set_value(1 + rand.nextInt(2));
    }

    public void set_value(int n)
    {
        value = n;
    }
    public int get_value()
    {
        return value;
    }
    public String toString()
    {
        return "Dice gave " + value ;
    }
}
