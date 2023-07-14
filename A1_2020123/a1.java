import java.util.*;

public class a1{

    public static class Vaccine
    {
        private String name ;
        private int no_doses;
        private int gap_doses;
        
        public Vaccine(String s,int a,int b)
        {
            this.name = s;
            this.no_doses = a;
            this.gap_doses = b;
        }
        public String getname()
        {
            return this.name;
        }
        public void setname(String s)
        {
            this.name = s;
        }
        public int get_num_doses()
        {
            return this.no_doses;
        }
        public void set_num_doses(int a)
        {
            this.no_doses = a;
        }
        public int get_gap_doses()
        {
            return this.gap_doses;
        }
        public void set_gap_doses(int a)
        {
            this.gap_doses = a;
        }

        public String toString()
        {
            return "Vaccine Name: " + getname() + ", Number of Doses: " + get_num_doses() + ", Gap between Doses: " + get_gap_doses(); 
        }
    }
    
    public static class Citizen
    {
        private String name ;
        private int age;
        private String id;
        private int doses_given = 0;
        private Vaccine vac_given;
        private int vac_day = -1;
        public Citizen(String s,int a,String b)
        {
            this.name = s;
            this.age = a;
            this.id = b;
        }
        public String getname()
        {
            return this.name;
        }
        public void setname(String s)
        {
            this.name = s;
        }
        public int get_age()
        {
            return this.age;
        }
        public void set_age(int a)
        {
            this.age = a;
        }
        public int get_dosegiven()
        {
            return this.doses_given;
        }
        public void set_dosegiven()
        {
            this.doses_given++;
        }
        public String get_id()
        {
            return this.id;
        }
        public void set_id(String s)
        {
            this.id = s;
        }
        public Vaccine get_vac()
        {
            return this.vac_given;
        }
        public void set_vac(Vaccine a)
        {
            this.vac_given = a;
        }
        public int get_vacday()
        {
            return this.vac_day;
        }
        public void set_vacday(int a)
        {
            this.vac_day = a + this.vac_given.get_gap_doses();
        }
        public String toString()
        {
            return "Citizen Name: " + getname() + ", Age: " + get_age() + ", Unique ID: " + get_id(); 
        }
    }

    public static class Hospital
    {
        private String name ;
        private String pincode;
        private static int count = 100000;
        private int id;
        public ArrayList<slot> slots = new ArrayList<>();
        public int slot_no = 0;
        
        public Hospital(String s,String a)
        {
            this.id = count;
            count++;
            this.name = s;
            this.pincode = a;
            
        }
        public String getname()
        {
            return this.name;
        }
        public void setname(String s)
        {
            this.name = s;
        }
        public String get_pincode()
        {
            return this.pincode;
        }
        public void set_pincode(String s)
        {
            this.pincode = s;
        }
        public int get_id()
        {
            return this.id;
        }
        public void slot_details(slot s)
        {
            System.out.println("Slot added by Hospital: " + this.id + ", for Day: " + s.get_dayno() + ", Available Quantity: " + s.get_qty() + ", of Vaccine: "+s.get_vac().getname());
            
        }
        public String toString()
        {
            return "Hospital Name: " + getname() + ", Pincode: " + get_pincode() + ", Unique ID: " + get_id(); 
        }

    }

    public static class slot{

        private int day_no;
        private int qty;
        private Vaccine vac;
                
        public slot(int a,int b,Vaccine v)
        {
            this.day_no = a;
            this.qty = b;
            this.vac = v;
        
        }
        public int get_dayno()
        {
            return this.day_no;
        }
        public void set_dayno(int s)
        {
            this.day_no = s;
        }
        public int get_qty()
        {
            return this.qty;
        }
        public void set_qty(int s)
        {
            this.qty = s;
        }
        public Vaccine get_vac()
        {
            return this.vac;
        }
        public void set_vac(Vaccine a)
        {
            this.vac = a;
        }
        
    }



    public static void main(String args[])
    {
              

        Scanner sc = new Scanner(System.in);

        int n = 0;
        System.out.println("Covin Portal Initialized...");
        
        ArrayList<Vaccine> vaccines = new ArrayList<>();  
        ArrayList<Hospital> hospitals = new ArrayList<>(); 
        ArrayList<Citizen> citizens = new ArrayList<>(); 
        int v = 0;
        int h = 0;
        int c = 0;

        while(n!=8)
        {
            System.out.println("------------------------------------");
            System.out.println("Menu Options");
            System.out.println("------------------------------------");
            System.out.println("1. Add Vaccine");
            System.out.println("2. Register Hospital");
            System.out.println("3. Register Citizen");
            System.out.println("4. Add slot for Vaccination");
            System.out.println("5. Book slot for Vaccination");
            System.out.println("6. List all slots for Vaccination");
            System.out.println("7. Check Vaccination Status");
            System.out.println("8. Exit");
            System.out.println("------------------------------------");
            n = sc.nextInt();
            

            if(n == 1)
            {   
                System.out.print("Vaccine Name : ");
                String s = sc.next();
                System.out.print("Number of Doses : ");
                int a = sc.nextInt();
                System.out.print("Gap Between Doses : ");
                int b = sc.nextInt();
                vaccines.add(new Vaccine(s, a, b));
                System.out.println(vaccines.get(v));
                v++;
            }
            else if(n == 2)
            {
                System.out.print("Hospital Name : ");
                String s = sc.next();
                System.out.print("Pincode : ");
                String a = sc.next();                
                hospitals.add(new Hospital(s, a));
                System.out.println(hospitals.get(h));
                h++;
            }

            else if(n == 3)
            {
                System.out.print("Citizen Name : ");
                String s = sc.next();
                System.out.print("Age : ");
                int a = sc.nextInt();
                System.out.print("Unique ID : ");
                String b = sc.next();
                if(a > 17)
                {
                    citizens.add(new Citizen(s, a, b));
                    System.out.println(citizens.get(c));
                    c++;
                }
                else{
                    System.out.println("Only above 18 are allowed");
                }
            }

            else if(n == 4)
            {
                System.out.print("Enter Hospital ID : ");
                int s = sc.nextInt();
                System.out.print("Enter number of slots to be added : ");
                int a = sc.nextInt();
                for(int i=0;i<h;i++)
                {
                    if(s == hospitals.get(i).get_id())
                    {
                        while(a>0)
                        {
                            System.out.print("Enter day number : ");
                            int day = sc.nextInt();
                            System.out.print("Enter Quantity : ");
                            int Qty = sc.nextInt();
                            System.out.print("Select Vaccine : \n");
                            for(int j=0;j<v;j++)
                            {
                                System.out.println(j + ". " + vaccines.get(j).getname());
                            }
                            int select = sc.nextInt();

                            hospitals.get(i).slots.add(new slot(day,Qty,vaccines.get(select)));
                            hospitals.get(i).slot_details(hospitals.get(i).slots.get(hospitals.get(i).slot_no));
                            hospitals.get(i).slot_no ++;
                            a--;

                        }
                    }
                }
               
            }
            else if(n == 5)
            {
                System.out.print("Enter Patient ID : ");
                String s = sc.next();
                System.out.print("1. Search by Pincode \n");
                System.out.print("2. Search by Vaccine \n");
                System.out.print("3. Exit \n");
                System.out.print("Enter Option : ");
                int a = sc.nextInt();
                int cid = 0;
                for(int k=0;k<c;k++)
                {
                    if(citizens.get(k).get_id().equals(s))
                    {
                        cid = k;
                    }
                }

                if(a == 1)
                {
                    System.out.print("Enter Pincode : ");
                    String b = sc.next();
                    for(int i=0 ;i<h;i++)
                    {
                        if(hospitals.get(i).get_pincode().equals(b))
                        {
                            System.out.println(hospitals.get(i).get_id() + " " + hospitals.get(i).getname());
                        }
                    }

                    System.out.print("Enter Hospital ID : ");
                    int hid = sc.nextInt();
                    for(int i=0 ;i<h;i++)
                    {
                        if(hid == hospitals.get(i).get_id())
                        {
                            int slot_avail = 0;
                            for(int j = 0;j< hospitals.get(i).slot_no;j++)
                            {
                                if((citizens.get(cid).get_vacday() == -1 || (citizens.get(cid).get_vacday() <= hospitals.get(i).slots.get(j).get_dayno() && hospitals.get(i).slots.get(j).get_vac().getname().equals(citizens.get(cid).get_vac().getname()))) && hospitals.get(i).slots.get(j).get_qty() > 0)
                                {
                                    System.out.println(j + "->Day: " + hospitals.get(i).slots.get(j).get_dayno() + ", Available Quantity: " + hospitals.get(i).slots.get(j).get_qty() + ", Vaccine: " + hospitals.get(i).slots.get(j).get_vac().getname());
                                    slot_avail = 1;
                                }
                            }
                            if(slot_avail == 0)
                            {
                                System.out.println("No Slots Available");
                            }
                            else
                            {
                                System.out.print("Choose slot : ");
                                int slotno = sc.nextInt();
                                //hospitals.get(i).slots.get(slotno).get_dayno();
                                hospitals.get(i).slots.get(slotno).set_qty(hospitals.get(i).slots.get(slotno).get_qty() - 1);
                                for(int j=0;j<c;j++)
                                {
                                    if(citizens.get(j).get_id().equals(s))
                                    {
                                        System.out.println(citizens.get(j).getname() + " vaccinated with " + hospitals.get(i).slots.get(slotno).get_vac().getname());
                                        citizens.get(j).set_vac(hospitals.get(i).slots.get(slotno).get_vac());
                                        citizens.get(j).set_vacday(hospitals.get(i).slots.get(slotno).get_dayno());
                                        citizens.get(j).set_dosegiven();
                                        
                                    }
                                }
                            }
                        }
                    }

                }

                else if(a == 2)
                {
                    System.out.print("Enter Vaccine Name : ");
                    String b = sc.next();

                    for(int i=0 ;i<h;i++)
                    {
                        for(int j = 0;j<hospitals.get(i).slot_no;j++)
                        {
                            if(hospitals.get(i).slots.get(j).get_vac().getname().equals(b))
                            {
                                System.out.println(hospitals.get(i).get_id() + " " + hospitals.get(i).getname());
                                break;
                            }
                        }
                        
                    }

                    System.out.print("Enter Hospital ID : ");
                    int hid = sc.nextInt();  
                    
                    for(int i=0 ;i<h;i++)
                    {
                        if(hid == hospitals.get(i).get_id())
                        {
                            int slot_avail = 0;
                            for(int j = 0;j< hospitals.get(i).slot_no;j++)
                            {
                                if(hospitals.get(i).slots.get(j).get_vac().getname().equals(b))
                                {
                                    //System.out.println(j + "->Day: " + hospitals.get(i).slots.get(j).get_dayno() + ", Available Quantity: " + hospitals.get(i).slots.get(j).get_qty() + ", Vaccine: " + hospitals.get(i).slots.get(j).get_vac().getname());
                                    if((citizens.get(cid).get_vacday() == -1 || (citizens.get(cid).get_vacday() <= hospitals.get(i).slots.get(j).get_dayno() && hospitals.get(i).slots.get(j).get_vac().getname().equals(citizens.get(cid).get_vac().getname()))) && hospitals.get(i).slots.get(j).get_qty() > 0)
                                    {
                                    System.out.println(j + "->Day: " + hospitals.get(i).slots.get(j).get_dayno() + ", Available Quantity: " + hospitals.get(i).slots.get(j).get_qty() + ", Vaccine: " + hospitals.get(i).slots.get(j).get_vac().getname());
                                    slot_avail = 1;
                                    }
                                }
                            }   
                            if(slot_avail == 0)
                            {
                                System.out.println("No Slots Available");
                            }
                            else{
                                System.out.print("Choose slot : ");
                                int slotno = sc.nextInt();
                                //hospitals.get(i).slots.get(slotno).get_dayno();
                                hospitals.get(i).slots.get(slotno).set_qty(hospitals.get(i).slots.get(slotno).get_qty() - 1);
                                for(int j=0;j<c;j++)
                                {
                                    if(citizens.get(j).get_id().equals(s))
                                    {
                                        System.out.println(citizens.get(j).getname() + " vaccinated with " + hospitals.get(i).slots.get(slotno).get_vac().getname());
                                        citizens.get(j).set_vac(hospitals.get(i).slots.get(slotno).get_vac());
                                        citizens.get(j).set_vacday(hospitals.get(i).slots.get(slotno).get_dayno());
                                        citizens.get(j).set_dosegiven();
                                        
                                    }
                                }
                            }
                        }
                    }


                }



            }


            else if(n == 6)
            {
                System.out.print("Hospital ID : ");
                int a = sc.nextInt();
                
                for(int i=0;i<h;i++)
                {
                    if(a == hospitals.get(i).get_id())
                    {
                        for(int j=0;j<hospitals.get(i).slot_no;j++)
                        {   
                            if(hospitals.get(i).slots.get(j).get_qty() > 0)
                            System.out.println("Day: " +hospitals.get(i).slots.get(j).get_dayno() + ", Vaccine: " + hospitals.get(i).slots.get(j).get_vac().getname() + ", Available Quantity: " +hospitals.get(i).slots.get(j).get_qty());
                        }
                    }
                }
            }

            else if(n == 7)
            {
                System.out.print("Enter Patient ID : ");
                String s = sc.next();
                for(int j=0;j<c;j++)
                {
                    if(citizens.get(j).get_id().equals(s))
                    {
                        if(citizens.get(j).get_dosegiven() == 0)
                        {
                            System.out.println("Citizen Registered");
                        }
                        else
                        {   int z = 0;
                            if(citizens.get(j).get_dosegiven() == citizens.get(j).get_vac().get_num_doses())
                            {
                                System.out.println("Fully Vaccinated");
                            }
                            else
                            {
                                System.out.println("Partially Vaccinated");
                                z=1;
                            }
                            System.out.println("Vaccine Given: " + citizens.get(j).get_vac().getname());
                            System.out.println("number of Doses Given: " + citizens.get(j).get_dosegiven());
                            if(z == 1)
                            {
                                System.out.println("Next Dose due date: " + citizens.get(j).get_vacday()); 
                            }
                        }
                    }
                }


            }

            else if(n == 8)
            {
                System.out.println("End of Test Case");
            }
            else
            {
                System.out.println("Incorrect Input, Choose again..");
            }




        }
        


        

        
       

    }
}