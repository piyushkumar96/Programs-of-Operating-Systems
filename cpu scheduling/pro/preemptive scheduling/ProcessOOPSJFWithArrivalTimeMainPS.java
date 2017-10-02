// package piyush;
import java.util.Scanner;
class ProcessOOPSJFWithArrivalTimePS
{ 
   private String str ;
   private int cpuburst, remcpuburst, tat, wt,arrtm;
   private static int sumcpub=0,a[]=new int[200],l=1;
   private static float sumtat=0.0f,sumwt=0.0f;

public static Scanner sc =new Scanner(System.in);
ProcessOOPSJFWithArrivalTimePS[] obj = new ProcessOOPSJFWithArrivalTimePS[20]; 

public void input(int n)
  {    
      for(int i=1;i<=n;i++)
        {   
	   obj[i] = new ProcessOOPSJFWithArrivalTimePS();
           sc.nextLine();
    	   System.out.print(" enter id ");
   	   obj[i].str=sc.nextLine(); 

	   System.out.print(" enter cpuburst ");
     	   obj[i].cpuburst=sc.nextInt();
           obj[i].remcpuburst=obj[i].cpuburst;
           sumcpub=sumcpub+obj[i].cpuburst;

           System.out.print(" enter arrivaltime ");
       	   obj[i].arrtm=sc.nextInt();
	}
    obj[0] = new ProcessOOPSJFWithArrivalTimePS();
        obj[0].str="-";
}


public void calTatWaiTime(int n)
  {  
     int timer=0,k=0,nop=0,mincb; 
     while(true)
       {
          mincb=sumcpub;
          k=0;
          for(int i=1;i<=n;i++)
            {
                if((obj[i].remcpuburst!=0)&&(obj[i].arrtm<=timer)&&(obj[i].remcpuburst<mincb))
                   {
                       mincb=obj[i].remcpuburst;
                       k=i;
                   }
            }
      if(k==0)
        {
         timer++;
            a[l]=k;
          l++;
         }
         
      else if(obj[k].remcpuburst!=1)
        {  
            obj[k].remcpuburst--;
            timer++;
            a[l]=k;
          l++;
         } 
      else
       {    a[l]=k;
          l++;
           
           nop++;
         obj[k].tat=timer-obj[k].arrtm+1;
           sumtat=sumtat+obj[k].tat;
           obj[k].wt=obj[k].tat-obj[k].cpuburst;
           sumwt=sumwt+obj[k].wt; 
            obj[k].remcpuburst--;
            timer++;
       }
     if(nop==n)
       break;
       
      }
   }

public void display(int n)
   {
       System.out.println("  ID  ART  CPUBURST   TAT    WAITTIME  ");
		for(int i=1;i<=n;i++)
		   {    System.out.print("  "+obj[i].str);
                        System.out.print("   "+obj[i].arrtm);
                        System.out.print("      "+obj[i].cpuburst);
			System.out.print("        "+obj[i].tat);
			System.out.println("        "+obj[i].wt);
		   }
      System.out.println(" the average tat "+(sumtat/n));
      System.out.println(" the average wt "+(sumwt/n));
    }  
public void ganttChart(int n)
    {  
         System.out.print("      The Gantt Chart \n ");
         System.out.print("           _____________________________________________________________________________________________________________________________________\n");
         System.out.print("            | ");
       for(int i=1;i<l;i++)
         { 
            System.out.print(obj[a[i]].str);
            System.out.print(" | ");
          }
      System.out.println("\n            ____________________________________________________________________________________________________________________________________");
      System.out.print("            ");
       for(int i=obj[a[1]].arrtm;i<l;i++)
         { 
              System.out.print(" "+i+" ");
              if(i>15)
               System.out.print(" "); 
         }
  }
}
  public class ProcessOOPSJFWithArrivalTimeMainPS
     {
        public static void main(String arg[])
         {
  		 Scanner in = new Scanner(System.in);
   		 ProcessOOPSJFWithArrivalTimePS obj1 = new ProcessOOPSJFWithArrivalTimePS();
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