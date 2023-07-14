import java.util.*;

public class comment {
    private String _comment;
    private Date date;

    public comment(){

    }
    Scanner sc = new Scanner(System.in);

    public void add_comment(String s)
    {
        this.date = java.util.Calendar.getInstance().getTime();
        System.out.print("Enter comment: ");
        String s1 = sc.nextLine();
        this._comment =  s1 + " - " + s ;
    }

    public void print_comments()
    {
        System.out.println(_comment);
        System.out.println(date);
        System.out.println();
    }
    
}
