public class Player {
    
    private dice _dice;
    private floor _floor;
    private int points;
    private int position;


    private String name;

    public Player()
    {
        position = -1;
    }
    public void set_dice(dice d)
    {
        _dice = d;
    }
    public void set_floor(floor F)
    {
        _floor = F;
    }
    public void set_name(String s)
    {
        name = s;
    }
    public void roll_dice()
    {
        _dice.roll();
    }
    public void set_position(floor F)
    {
        position = F.get_floorno();
        points += F.get_floor_value();
        _floor = F;

    }
    public int get_position()
    {
        return position;
    }
    public int get_points()
    {
        return points;
    }
    public String get_name()
    {
        return name;
    }
    public floor get_floor()
    {
        return _floor;
    }
    


}
