import java.util.Scanner;
class ProcessOOPRRWithArrivalTimeNP 
{ 
   private String str ;
   private int cpuburst,remcpuburst , tat, wt,arrtm ;
   private static int sumcpub=0,a[]=new int[200], quant;
   private static float sumtat=0.0f,sumwt=0.0f;
   private boolean status,remstatus;
public static Scanner sc =new Scanner(System.in);
ProcessOOPRRWithArrivalTimeNP[] obj = new ProcessOOPRRWithArrivalTimeNP[20]; 

public void input(int n)
  { 
     for(int i=1;i<=n;i++)
        {   
	   obj[i] = new ProcessOOPRRWithArrivalTimeNP();
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
        System.out.print(" enter the time slice ");
        quant=sc.nextInt();
  }
public void calTatWaiTime(int n)
  { 
      int timer=0,k=0,j=1,nop=0,p=0,nopr=n;
     while(true)
      {    
         
             k=0;
            for(int i=1;i<=n;i++)
                {
                    if((obj[i].remcpuburst!=0)&&(obj[i].arrtm<=timer)&&((obj[i].remstatus==false)&&(obj[i].status==false)))
                       {
                          k=i;
                        }
                }
            if(k==0)
               {
                 timer++;
              }
                 
            else if(obj[k].remcpuburst!=1)
             {  
                 for(int i=1;i<=quant;i++)
                  {  
                       if(obj[k].remcpuburst==1)
                           break;
                     obj[k].remcpuburst--;
                     timer++;
                     a[j]=k;
                    j++; 
                  }
                  obj[k].status=true;
                  p++;
            
               if(p==nopr)
                 {  
                    for(int i=1;i<=n;i++)
                          obj[i].status=false;
                   p=0;
                 }       
             }
      
            if((k!=0)&&(obj[k].remcpuburst==1))
              {   
                    a[j]=k;
                    j++;
                     nop++;
                obj[k].tat=timer-obj[k].arrtm+1;
                sumtat=sumtat+obj[k].tat;
                obj[k].wt=obj[k].tat-obj[k].cpuburst;
                sumwt=sumwt+obj[k].wt; 
                obj[k].remcpuburst--;
                timer++;
                obj[k].remstatus=true;
                obj[k].status=true;
                nopr--;    
                p--;
             }
         if(nop==n)
           break;
       }
   }

public void display(int n)
   {   
       System.out.print(" \n the time slice is "+quant+" \n");
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
         System.out.print("           _________________________________________________________\n");
         System.out.print("            |");
       for(int i=1;i<=n;i++)
         { 
            for(int j=1;j<=obj[a[i]].tat;j++)
              {  
                 if(j==(obj[a[i]].tat/2))
                     System.out.print(obj[a[i]].str);
                 else
                     System.out.print(" "); 
               }
            System.out.print("|");
          }
      System.out.println("\n            _________________________________________________________");
      sumcpub=obj[a[1]].arrtm;
      System.out.print("            "+obj[a[1]].arrtm);
       for(int i=1;i<=n;i++)
         {   
            sumcpub=sumcpub+obj[a[i]].cpuburst;
            for(int j=1;j<=obj[a[i]].cpuburst+1;j++)
              {    
                  if(j==(obj[a[i]].cpuburst))
                        System.out.print(sumcpub);
                  else
                       System.out.print(" "); 
               }
         }
  }
}

  public class ProcessOOPRRWithArrivalTimeMainNP
     {
        public static void main(String arg[])
           {
  		 Scanner in = new Scanner(System.in);
   		 ProcessOOPRRWithArrivalTimeNP obj1 = new ProcessOOPRRWithArrivalTimeNP();
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