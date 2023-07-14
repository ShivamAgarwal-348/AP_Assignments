
public class ladder extends floor{
    
    public ladder(int n)
    {
        set_floorno(n);
        set_floor_value();
        set_name_floor();
    }
    public void set_name_floor()
    {
        name_floor = "Ladder floor" ;
    }
    public void set_floor_value()
    {
        floor_value = 2;
    }




}
