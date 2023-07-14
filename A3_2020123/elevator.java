

public class elevator extends floor{
    
    public elevator(int n)
    {
        set_floorno(n);
        set_floor_value();
        set_name_floor();
    }
    public void set_name_floor()
    {
        name_floor = "Elevator floor" ;
    }
    public void set_floor_value()
    {
        floor_value = 4;
    }




}
