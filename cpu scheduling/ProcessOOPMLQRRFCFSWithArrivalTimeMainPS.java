import java.util.Scanner;
class ProcessOOPMLQRRFCFSWithArrivalTimePS
{  
   String str;
   int cpuburst,remcpuburst,tat,wt,at,noqtep=0,comptm;
   boolean status;
}
public class ProcessOOPMLQRRFCFSWithArrivalTimeMainPS
{
    static ProcessOOPMLQRRFCFSWithArrivalTimePS objfc[];
    static int nop=0,nopfc=0,tm=0;
  public static void main(String args[])
   {
         Scanner sc=new Scanner(System.in);
         int n,quant,tnoqgtep;

         System.out.println("Enter the no. of process");                                                            //input of no processes
         n=sc.nextInt();   sc.nextLine();
  
         System.out.println("Enter time quantum for RR ");                                                          //input of time quantum
         quant=sc.nextInt();

         System.out.println("Enter no of quantum given to each process in RR ");                                    //input of total no of quantum given to each process
         tnoqgtep=sc.nextInt();
  
         ProcessOOPMLQRRFCFSWithArrivalTimePS objrr[]=new ProcessOOPMLQRRFCFSWithArrivalTimePS[n+1];
         objfc=new ProcessOOPMLQRRFCFSWithArrivalTimePS[n+1];
        
         for(int i=1;i<=n;i++)                                                                                       // random generation of cpuburst and arrival time
           {
	     objrr[i]=new ProcessOOPMLQRRFCFSWithArrivalTimePS();
             objrr[i].str="P"+i;
             System.out.println("enter the AT ");
             objrr[i].at=sc.nextInt();
             System.out.println("enter the CPUBURST");
             objrr[i].cpuburst=objrr[i].remcpuburst=sc.nextInt();
            }
        ProcessOOPMLQRRFCFSWithArrivalTimePS swap;                                                                   
        for(int i=1;i<=n;i++)                                                                                       //sorting process acording to arrival time
          {
              for(int j=2;j<=n;j++)
                {
                  if(objrr[j].at<objrr[j-1].at)
                     {
                       swap=objrr[j];
                       objrr[j]=objrr[j-1];
                       objrr[j-1]=swap;
                     }
                }
           }
       
        int noprr=1,t=0,tempt=0,tnopfc=0,temptt,v=0;
        System.out.println("\n the quantum time is "+quant);
        System.out.println("the gantt chart \n");
        System.out.print(t);
     while(nop!=n)                                                               //while loop 1
      {
        while(noprr<=n)                                                          //while loop 2
          { 
             if(objrr[noprr].status==false)
            {
            if(objrr[noprr].at<=t)
              {
                if((objrr[noprr].remcpuburst > quant))                                                             // quant is less than remcpuburst
                  {
                     if((tempt+6-t)<quant)                                                                        // quant is more than rr time  and  rr time is finish befores a process completes its one quantum;                                 
                        {
                          if(t!=tempt+6)                                                                          // process is executed to time equal to rr time remain and process is remain in rr queue     
                             System.out.print("--"+objrr[noprr].str+"R-->"+(tempt+6));
                          temptt=tempt+6-t;                                                                       //storing the remaining time quantum left for same process in temptt
                          t=tempt+6;
                              tempt=t=processInFCFS(t,tnopfc);                                                   //process in fcfs is executed till fc time is finished
                             
                          System.out.print("--"+objrr[noprr].str+"R-->"+(t+quant-temptt));                         // completing the remaining time quantum
                          t=t+quant-temptt;
                          tm++;
                         }
                      else
                        {
                          System.out.print("--"+objrr[noprr].str+"R-->"+(t+quant));
                          t=t+quant;
                        }
                      objrr[noprr].remcpuburst=objrr[noprr].remcpuburst-quant;
                      objrr[noprr].noqtep++;                                                             
                      if(objrr[noprr].noqtep==tnoqgtep)                         // no of each process is taken by each process =  total no of quantum given to each process
                             objfc[++tnopfc]=objrr[noprr];                      // now process are removed from RR queue and feed to fcfs ready queue
                   }
                 else                                                                                            // quant is more than remcpuburst                                                                                                                     
                  {
                    if((tempt+6-t)<objrr[noprr].remcpuburst)                                                     // rr time is finish befores a process completes its one quantum;
                       {
                          if(t!=tempt+6)                                                                         // process is executed to time equal to rr time remain and process is remain in rr queue 
                             System.out.print("--"+objrr[noprr].str+"R-->"+(tempt+6));
                          temptt=tempt+6-t;                                                                      //storing the remaining time quantum left for same process in temptt  
                          t=tempt+6;
                              tempt=t=processInFCFS(t,tnopfc);                                                       //process in fcfs is executed till fc time is finished 
                          System.out.print("--"+objrr[noprr].str+"R-->"+(t+objrr[noprr].remcpuburst-temptt));    // completing the remaining time quantum 
                          t=t+objrr[noprr].remcpuburst-temptt;
                        }
                     else
                       {
                          System.out.print("--"+objrr[noprr].str+"R-->"+(t+objrr[noprr].remcpuburst));
                          t=t+objrr[noprr].remcpuburst;
                        }
                     nop++;                                                                                      //process is complete
                     objrr[noprr].status=true;
                     objrr[noprr].comptm=t;
                     objrr[noprr].tat=t-objrr[noprr].at;                                                         //calculating tat and wt
                     objrr[noprr].wt=objrr[noprr].tat-objrr[noprr].cpuburst;
                   }
               }
             else                                                                                               // no process in round robin 
               {
                  if(nopfc==tnopfc)                                                                            // no process in fcfs
                    {
                       System.out.print("---->"+(t+1)); 
                       t++;
                       tempt=t;
                    }
                   else                                                                                                                                                                         
                    {
                       t=processInFCFS(t,tnopfc);                                                    //executing fcfs queue 
                       tempt=t;
                    }
                  noprr--;                                                                  // pointing to same process until its one time quantum is not complete
                }
             }
             noprr++; 
             if(noprr==n+1)
              {   v++;
                  noprr=1;
                  if(v==tnoqgtep)
                     noprr=n+1;
               }
         
            }                                                                               //while loop 2 end 
          t=processInFCFS(t,tnopfc);
        }                                                                                   //while loop 1 end

       int sumwt=0, sumtat=0;

       System.out.println("\n\n ID"+"  AT"+" CPUBURST"+"  COMPTM"+"  TATIME"+"   WTIME");                  
       for(int i=1;i<=n;i++)
         {
            System.out.println(" "+objrr[i].str+"  "+objrr[i].at+"    "+objrr[i].cpuburst+"        "+objrr[i].comptm+"        "+objrr[i].tat+"       "+objrr[i].wt);
            sumwt=sumwt+objrr[i].wt;
            sumtat=sumtat+objrr[i].tat;
         }
        System.out.println("average tat is "+(float)sumtat/n);
        System.out.println("average wt  is "+(float)sumwt/n);
   } // main method end

static int processInFCFS(int t,int tnopfc)
  {
    int tempt=t;
    while(nopfc<tnopfc)                                    //while loop 3   // checking no. of process in fcfs pointer points to total no of process in fcfs ready queue
      {
         for(int i=1;i<=tnopfc;i++)
           {
              if(objfc[i].status==false)
                {
                  if(objfc[i].remcpuburst<=(tempt+4-t))                                                                //remaining cpuburst is less or equal to fc time                
                    {
                      objfc[i].status=true;                                                                           // process is completes
                      nop++;                                                                                           
                      nopfc++;                                                                                               //changing pointer to next process in fc queue
                      System.out.print("--"+objfc[i].str+"F-->"+(t+objfc[i].remcpuburst));
                      t=t+objfc[i].remcpuburst;
                      objfc[i].comptm=t;
                      objfc[i].tat=t-objfc[i].at;                                                                            //calculating tat and wt
                      objfc[i].wt=objfc[i].tat-objfc[i].cpuburst;
                    }
                   else                                                                                             //remaining cpuburst is less or equal to fc time 
                    {
                      if(t==tempt+4)                                                        
                        return t;
                      objfc[i].remcpuburst=objfc[i].remcpuburst-(tempt+4-t);
                      System.out.print("--"+objfc[i].str+"F-->"+(tempt+4));
                      t=tempt+4;
                      return t;
                     }
                  }
             }  //end of for loop
       }  //end of while loop 3
     return t;

  } //end of method processInFCFS
}  //end of class ProcessOOPMLQRRFCFSWithArrivalTimeMainPS