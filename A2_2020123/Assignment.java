import java.util.*;


public class Assignment {
    
    private String title;
    private static int max_marks;
    private boolean close;
    
    private Scanner sc = new Scanner(System.in);
    
    private subm_assm[] assm_subs;

    public Assignment()
    {
       this.close = false;

       assm_subs = new subm_assm[3];
       assm_subs[0] = new subm_assm();
       assm_subs[1] = new subm_assm();
       assm_subs[2] = new subm_assm();
    }
    public String gettitle()
    {
        return this.title;
    }
    
    public int get_maxmarks()
    {
        return this.max_marks;
    }
        

    public void add_assignment()
    {
        System.out.print("Enter Problem Statement: ");
        this.title = sc.nextLine();
        System.out.print("Enter max marks: ");
        this.max_marks = sc.nextInt();
        
    }
    public void print_assignment(int j)
    {
        System.out.println("ID: "+ j + ", Assignment: " + this.title +", Max Marks: " + this.max_marks);   
    }
    public void close_assignment()
    {
        this.close = true;
    }
    public boolean if_closed()
    {
        return close;
    }
    public subm_assm get_sub_assm(int id)
    {
        return assm_subs[id];
    }
}
