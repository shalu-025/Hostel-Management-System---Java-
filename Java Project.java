/*
   When you have free time try to solve the questions which I am sending during the holidays.
1) There are 10 rooms (5 for girls and 5 for boys) in the I3 building. For girls,
each room maximum capacity is 5 and for boys, each room maximum capacity is 4. When a student requests 
for room allocation, allocate the rooms sequentially i.e., after one room filling then fill another room and also 
take care of gender separation. After allocating the room, display his/her personnel details including the allocated
room number. If rooms are not vacant display as not vacant. While registering a room, save the date on which he or 
she checked in. While checkout also save tnhe check out date. Then finally calculate the bill for the total number of 
days stayed in the hostel (each day cost : 300 rupees). Now the check out room can allocate to newly joining students. 
Write a Java program to implement the above requirement and take care of all possible scenarios.

Note: you can use arrays, Date class in Java to solve the above tasks.
*/

import java.util.*;
public class RoomAllot
{
	public static void main(String[] args)
	{    int i,j,k,gen,c;
    	 boolean choice = true;
    	Scanner sc = new Scanner(System.in); 
	    Student g[][] = new Student[5][5];
	    Student b[][] = new Student[5][4];
	  while(choice)
     {
        System.out.print("Choose from the Below.\n1.ROOM ENTRY\n2.ROOM EXIT\nChoose a number: ");
        int ch = sc.nextInt();
        if(ch==1)
        {
            System.out.print("Enter Boy(0) or Girl(1): ");
            gen = sc.nextInt();
            c=0;
            if(gen==1)
            {
                for(i=0;i<5;i++)
                {
                    for(j=0;j<5;j++)
                    {
                        if(g[i][j]==null)
                        {
                            g[i][j]=new Student();
                            g[i][j].details();
                            g[i][j].display();
                            System.out.println("You are alloted in Room No: G"+(i+1)+"\nYour number in the Room: "+(j+1));
                            c++;
                            if(c==1)    break;
                        }
                    }
                    if(c==1)    break;
                }
                if(c==0) System.out.println("No vaccancies Left.");
            }
            c=0;
            if(gen==0)
            {
                for(i=0;i<5;i++)
                {
                    for(j=0;j<4;j++)
                    {
                        if(b[i][j]==null)
                        {
                            b[i][j]=new Student();
                            b[i][j].details();
                            b[i][j].display();
                            System.out.println("You are alloted in Room No: B"+(i+1)+"\nYour number in the Room: "+(j+1));
                            c++;
                            if(c==1)    break;
                        }
                    }
                    if(c==1)    break;
                }
                if(c==0) System.out.println("No vaccancies Left.");
            }
        }
	    else if(ch==2)
	    {
	        System.out.print("Enter Boy(0) or Girl(1): ");
	        gen = sc.nextInt();
	        System.out.print("Enter your Room No(1 or 2 or..): ");
	        i = sc.nextInt();
	        System.out.print("Enter your Number in the Room: ");
	        j = sc.nextInt();
	        if(gen==0)
	        {
		    if(b[i-1][j-1]==null) System.out.println("The specified position is empty.");	
	            else
	            {
			b[i-1][j-1].exit();
	           	b[i-1][j-1].display();
	            	b[i-1][j-1]=null;
		    }

	        }
	        if(gen==1)
	        {
  		    if(g[i-1][j-1]==null) System.out.println("The specified position is empty.");
	            else
	            {
			g[i-1][j-1].exit();
	                g[i-1][j-1].display();
	                g[i-1][j-1]=null;
		    }
	        }
	        
	    }
	    else System.out.println("Enter appropriate Choice.");
	   System.out.print("Do you want to continue[true] or Exit[false]: ");
	   choice = sc.nextBoolean();
     }
     
	}
}

class Student
{
    Scanner sc = new Scanner(System.in);
    String name,id,edt,outdt;
    int yy,mm,dd;
    Date ind,outd;
    void details()
    {
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Id No: ");
        id = sc.nextLine();
        System.out.print("Enter Date of Entry(yyyy,mm,dd.): ");
        edt = sc.nextLine();
        yy = Integer.parseInt(edt.substring(0,4)) - 1900;
        mm = Integer.parseInt(edt.substring(5,7)) - 1;
        dd = Integer.parseInt(edt.substring(8,10));
        ind = new Date(yy,mm,dd);
    }
   void display()
    {
        System.out.println("Name: "+ name);
        System.out.println("Id No: "+ id);
        System.out.println("Date of Entry: "+ ind);
        if(outd!=null)
        {
            System.out.println("Date of Exit: "+ outd);
            long n=(outd.getTime())-(ind.getTime());
            long days=n/86400000;
            System.out.println("Amount to be paid: "+days*300+" Rupees");
        }
    }
    void exit()
    {
        System.out.print("Enter Date of Exit(yyyy,mm,dd.): ");
        outdt = sc.nextLine();
        yy = Integer.parseInt(outdt.substring(0,4)) - 1900;
        mm = Integer.parseInt(outdt.substring(5,7)) - 1;
        dd = Integer.parseInt(outdt.substring(8,10));
        outd = new Date(yy,mm,dd);
    }
    
}
