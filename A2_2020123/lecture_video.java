import java.util.*;

public class lecture_video {
    
    private String title;
    private String filename;
    private Scanner sc = new Scanner(System.in);
    private instructor _instructor;
    private Date date;

    public lecture_video()
    {
       
    }
    public String gettitle()
    {
        return this.title;
    }
    public String get_filename()
    {
        return this.filename;
    }
    
    public Date get_date()
    {
        return this.date;
    }
    
    public instructor get_instructor()
    {
        return this._instructor;
    }
    

    public void add_video(instructor in,String s1,String s2)
    {
        this.title = s1;
        this.filename = s2;
        
        this.date = java.util.Calendar.getInstance().getTime();
        this._instructor = in;

    }
    public void print_video()
    {
        System.out.println("Title: " + this.title);
        System.out.println("Video file: " + filename);
        System.out.println("Date of upload: " + this.date);
        System.out.println("Uploaded by: " + this._instructor.get_name());
        System.out.println();

        
    }
}


