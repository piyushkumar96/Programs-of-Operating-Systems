//package piyush ;
import java.util.Scanner;
class ProcessOOPFCFS 
{ 
   private String str ;
   private int cpuburst, tat, wt;
   private static float sumtat=0.0f,sumwt=0.0f;
public static Scanner sc =new Scanner(System.in);
ProcessOOPFCFS [] obj = new ProcessOOPFCFS [20]; 

public void input(int n)
   {		
       	for(int i=0;i<n;i++)
	  {   
	     obj[i] = new ProcessOOPFCFS();
             sc.nextLine();
    	     System.out.print(" enter id ");
   	     obj[i].str=sc.nextLine();
    	     System.out.print(" enter cpuburst ");
     	     obj[i].cpuburst=sc.nextInt();
          }
    }
public void calTatWaiTime(int n)
    {  
      int  sum=0;
        for(int i=0;i<n;i++)
           {
              obj[i].wt=sum;
              sumwt=sumwt+obj[i].wt;
              sum=sum+obj[i].cpuburst;
              obj[i].tat=sum;
              sumtat=sumtat+obj[i].tat;
            }
     }
public void display(int n)
     {   
        System.out.println("  ID   CPUBURST   TAT    WAITTIME  ");
		for(int i=0;i<n;i++)
		   {    System.out.print("  "+obj[i].str);
                        System.out.print("      "+obj[i].cpuburst);
			System.out.print("        "+obj[i].tat);
			System.out.println("      "+obj[i].wt);
		   }
       System.out.println(" the average tat "+(sumtat/n));
       System.out.println(" the average wt "+(sumwt/n));
     }
public void ganttChart(int n)
    {  
         System.out.print("      The Gantt Chart \n ");
         System.out.print("           _________________________________________________________\n");
         System.out.print("            |");
       for(int i=0;i<n;i++)
         { 
            for(int j=0;j<obj[i].cpuburst;j++)
              {  
                 if(j==(obj[i].cpuburst/2))
                     System.out.print(obj[i].str);
                 else
                     System.out.print(" "); 
               }
            System.out.print("|");
          }
      System.out.println("\n            _________________________________________________________");
      int sum=0;
      System.out.print("            0");
       for(int i=0;i<n;i++)
         {   
            sum=sum+obj[i].cpuburst;
            for(int j=0;j<=obj[i].cpuburst+1;j++)
              {    
                  if(j==(obj[i].cpuburst))
                        System.out.print(sum);
                  else
                       System.out.print(" "); 
               }
         }
     }

     

     
}
public class ProcessOOPFCFSMain 
{
   public static void main(String arg[])
           {
  		 Scanner in = new Scanner(System.in);
   		 ProcessOOPFCFS obj1 = new ProcessOOPFCFS();
		 int n=0;
              while(true)
                {   
                     System.out.print(" \n\n Enter the choice\n 1.Input \n 2.CalculateTATWAITTIME \n 3.Display \n 4.GanttChart \n 5.Exit \n");
  		     int ch =in.nextInt();
                    switch(ch)
                      {
                           case 1: System.out.print(" Enter the no. OF PROCESS  (must be > 1)");
  		                   n=in.nextInt();
                                   obj1.input(n);break;
	       	           case 2: obj1.calTatWaiTime(n) ;break;
	       	           case 3:  obj1.display(n);break;
                           case 4:  obj1.ganttChart(n);break;
	       	           case 5: System.exit(0);
	       	           default: System.out.print(" \n Entered wrong choice \n ");break;
                      }
                 }
            }
}