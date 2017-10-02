// package piyush;
import java.util.Scanner;
class ProcessOOPSJFWithArrivalTime
{ 
   private String str ;
   private int cpuburst, tat, wt,arrtm;
   private static int minarrtm,sumcpub=0,a[]=new int[20];
   private static float sumtat=0.0f,sumwt=0.0f;
   boolean status;

public static Scanner sc =new Scanner(System.in);
ProcessOOPSJFWithArrivalTime[] obj = new ProcessOOPSJFWithArrivalTime[20]; 

public void input(int n)
  {   
      int timer,k=0,j=0,mincb;  
      for(int i=0;i<n;i++)
        {   
	   obj[i] = new ProcessOOPSJFWithArrivalTime();
           sc.nextLine();
    	   System.out.print(" enter id ");
   	   obj[i].str=sc.nextLine(); 
	   System.out.print(" enter cpuburst ");
     	   obj[i].cpuburst=sc.nextInt();
           sumcpub=sumcpub+obj[i].cpuburst;
           System.out.print(" enter arrivaltime ");
       	   obj[i].arrtm=sc.nextInt();
	}

          minarrtm=obj[0].arrtm;
	  for(int i=1;i<n;i++)
 	    {
 	      if(obj[i].arrtm<minarrtm)
   	          minarrtm=obj[i].arrtm;
             }
  timer=minarrtm;
     while(timer<sumcpub+minarrtm)
       {
          mincb=sumcpub+minarrtm+1;
          for(int i=0;i<n;i++)
            {
                if((obj[i].status==false)&&(obj[i].arrtm<=timer)&&(obj[i].cpuburst<mincb))
                   {
                       mincb=obj[i].cpuburst;
                       k=i;
                   }
            }
        obj[k].status=true;
        a[j]=k;
        j++;
        timer=timer+obj[k].cpuburst;
      }
   }

public void calTatWaiTime(int n)
  {  
      sumcpub=minarrtm;
      for(int i=0;i<n;i++)
        {
           obj[a[i]].wt=sumcpub-obj[a[i]].arrtm;
           sumwt=sumwt+obj[a[i]].wt;
           sumcpub=sumcpub+obj[a[i]].cpuburst;
           obj[a[i]].tat=sumcpub-obj[a[i]].arrtm;
           sumtat=sumtat+obj[a[i]].tat;
         }
   }

public void display(int n)
   {
       System.out.println("  ID  ART  CPUBURST   TAT    WAITTIME  ");
		for(int i=0;i<n;i++)
		   {    System.out.print("  "+obj[a[i]].str);
                        System.out.print("   "+obj[a[i]].arrtm);
                        System.out.print("      "+obj[a[i]].cpuburst);
			System.out.print("        "+obj[a[i]].tat);
			System.out.println("        "+obj[a[i]].wt);
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
            for(int j=0;j<obj[a[i]].cpuburst;j++)
              {  
                 if(j==(obj[a[i]].cpuburst/2))
                     System.out.print(obj[a[i]].str);
                 else
                     System.out.print(" "); 
               }
            System.out.print("|");
          }
      System.out.println("\n            _________________________________________________________");
      sumcpub=0;
      System.out.print("            "+obj[a[0]].arrtm);
       for(int i=0;i<n;i++)
         {   
            sumcpub=sumcpub+obj[a[i]].cpuburst;
            for(int j=0;j<=obj[a[i]].cpuburst+1;j++)
              {    
                  if(j==(obj[a[i]].cpuburst))
                        System.out.print(sumcpub);
                  else
                       System.out.print(" "); 
               }
         }
     }
}
  public class ProcessOOPSJFWithArrivalTimeMain
     {
        public static void main(String arg[])
         {
  		 Scanner in = new Scanner(System.in);
   		 ProcessOOPSJFWithArrivalTime obj1 = new ProcessOOPSJFWithArrivalTime();
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