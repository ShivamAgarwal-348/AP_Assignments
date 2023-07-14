public abstract  class floor {
    
    private int floorno;
    private int next_floor;
    protected int floor_value;
    protected String name_floor;

    public floor()
    {

    }

    public void set_floorno(int n)
    {
        floorno = n;
    }
    public int get_floorno()
    {
        return floorno;
    }
    public void set_next_floor(int n)
    {
        next_floor = n;
    }
    public int get_next_floor()
    {
        return next_floor;
    }
    public abstract void set_floor_value();
    
    public int get_floor_value()
    {
        return floor_value;
    }
    public String get_name_floor()
    {
        return name_floor;
    }
    public abstract void set_name_floor();
    
    
     

}
