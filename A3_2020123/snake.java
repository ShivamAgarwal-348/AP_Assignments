

public class snake extends floor{
    
    public snake(int n)
    {
        set_floorno(n);
        set_floor_value();
        set_name_floor();
    }
    public void set_name_floor()
    {
        name_floor = "Snake floor" ;
    }
    public void set_floor_value()
    {
        floor_value = -2;
    }




}
