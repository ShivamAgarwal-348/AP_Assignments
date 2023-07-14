import java.util.*;


public class lecture_slide {
    
    private String title;
    private int slides_no;
    private ArrayList<String> slides = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private instructor _instructor;
    private Date date;

    public lecture_slide()
    {
       
    }
    public String gettitle()
    {
        return this.title;
    }
    
    public int get_sno()
    {
        return this.slides_no;
    }
    
    public void set_slides(String s)
    {
        slides.add(s);
    }
    public Date get_date()
    {
        return this.date;
    }
    
    public instructor get_instructor()
    {
        return this._instructor;
    }
    

    public void add_slide(instructor in)
    {
        System.out.print("Enter Topic of slides: ");
        this.title = sc.next();
        System.out.print("Enter number of slides: ");
        this.slides_no = sc.nextInt();
        System.out.println("Enter content of slides");
        for(int i=0;i<this.slides_no;i++)
        {
            System.out.print("Content of slide " + (i+1) + " : ");
            this.set_slides(sc.next());
        }
        this.date = java.util.Calendar.getInstance().getTime();
        this._instructor = in;

    }
    
    public void print_slides()
    {
        System.out.println("Title: " + this.title);
        for(int j =0 ; j<slides_no ;j++)
        {
            System.out.println("Slide " + (j+1) + ": " + this.slides.get(j));
        }
        System.out.println("Number of slides: " + slides_no);
        System.out.println("Date of upload: " + this.date);
        System.out.println("Uploaded by: " + this._instructor.get_name());
        System.out.println();
        
    }
}
