import java.util.Scanner;
class ProcessOPPPrior
{ 
   private String str ;
   private int cpuburst, tat, wt,prio;
   private static int sumcpub=0,a[]=new int[20],b[]=new int[20];
   private static float sumtat=0.0f,sumwt=0.0f;
   boolean status;

public static Scanner sc =new Scanner(System.in);
ProcessOPPPrior[] obj = new ProcessOPPPrior[20]; 

public void input(int n)
  {   
       int timer=0,k=0,j=0,mincb,minprio;
      for(int i=0;i<n;i++)
        {   
	   obj[i] = new ProcessOPPPrior();
           sc.nextLine();
    	   System.out.print(" enter id ");
   	   obj[i].str=sc.nextLine();
	   System.out.print(" enter cpuburst ");
     	   obj[i].cpuburst=sc.nextInt();
           sumcpub=sumcpub+obj[i].cpuburst;
           System.out.print(" enter priority ");
   	   obj[i].prio=sc.nextInt();
           b[i]=obj[i].prio;

	}
         for(int i=0;i<n;i++)
	  {    
            for(int l=0;l<n;l++)
      	       {  
        	 if(b[i]<b[l])
           	   {   int t=b[i];
              	       b[i]=b[l];
                       b[l]=t;
                   }
                }
           }  
   while(timer<sumcpub)
       {
          mincb=sumcpub+1;
          for(int i=0;i<n;i++)
            {
                if((obj[i].status==false)&&(obj[i].cpuburst<mincb)&&obj[i].prio<=b[j])
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
      sumcpub=0;
      for(int i=0;i<n;i++)
        {
           obj[a[i]].wt=sumcpub;
           sumwt=sumwt+obj[a[i]].wt;
           sumcpub=sumcpub+obj[a[i]].cpuburst;
           obj[a[i]].tat=sumcpub;
           sumtat=sumtat+obj[a[i]].tat;
         }
   }

public void display(int n)
   {
       System.out.println("  ID  PRIO  CPUBURST   TAT    WAITTIME  ");
		for(int i=0;i<n;i++)
		   {    System.out.print("  "+obj[a[i]].str);
                        System.out.print("   "+obj[a[i]].prio);
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
      int sumcpub=0;
      System.out.print("            0");
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

  public class ProcessOPPPriorMain
     {
        public static void main(String arg[])
           {
  		 Scanner in = new Scanner(System.in);
   		 ProcessOPPPrior obj1 = new ProcessOPPPrior();
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