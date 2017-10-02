import java.util.Scanner;
class JobOOPMMMFT
  {
    int t,size,tr,wt;
    float IF;
    String id;
    boolean flag;
  }
class MemoryOOPMMMFT
  {
    int size;
    JobOOPMMMFT job; 
    boolean flag;
  }
class MMMFTMain
  {
    public static void main(String args[])
     {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of partitions of memory");
      int tnomb=sc.nextInt();
      sc.nextLine();
      MemoryOOPMMMFT mem[]=new MemoryOOPMMMFT[tnomb+1];
      for(int i=1;i<=tnomb;i++)
        {
           mem[i]=new MemoryOOPMMMFT();
           System.out.println("enter size of the partition "+i);
           mem[i].size=sc.nextInt();
           sc.nextLine();
        }

        System.out.println("enter the no. the jobs");
        int tnoj=sc.nextInt();
        sc.nextLine();
        JobOOPMMMFT job[]=new JobOOPMMMFT[tnoj+1];
       for(int i=1;i<=tnoj;i++)
        {
          job[i]=new JobOOPMMMFT();
          System.out.println("enter jobs id ");
          job[i].id=sc.nextLine();
          System.out.println("enter jobs size "+job[i].id);
          job[i].size=sc.nextInt();
          sc.nextLine();
          System.out.println("enter time required by job "+job[i].id+" to complete");
          job[i].t=job[i].tr=sc.nextInt();
          sc.nextLine();
         }
      

    int  noja=0,t=0,totmem=0,sum2,l[]= new int[tnoj+1];
      for(int i=1;i<=tnomb;i++)
          totmem=totmem+mem[i].size;

System.out.println("TIME  MEMORY UTILISATION ");

      while(noja<tnoj)
         {
             for(int i=1;i<=tnoj;i++)
               {
                  if(job[i].flag==false)
                   {
                      int j=1;
                      while((j<=tnomb)&&((mem[j].size<job[i].size)||(mem[j].flag==true)))
                           {
                               j++;
                           }
                      if(j<=tnomb)
                       {  l[i]=mem[j].size;
                          job[i].wt=t;
                        //  job[i].IF=(float)job[i].size/mem[j].size;
                          job[i].IF=mem[j].size-job[i].size;
                          job[i].flag=mem[j].flag=true;
                          mem[j].job=job[i];
                       }
                    }
                 }

              sum2=0;
            for(int i=1;i<=tnomb;i++)
             {
                  if(mem[i].flag==true)
                     {
                        sum2=sum2+mem[i].job.size;
                     }
             }
          
          System.out.println(t+"          "+((float)sum2/totmem)*100);
          t++;
          for(int i=1;i<=tnomb;i++)
            {
              if(mem[i].flag==true)
                {
                  mem[i].job.tr--;
                  if(mem[i].job.tr==0)
                     {
                        noja++;
                        mem[i].flag=false;
                     }
                }
             }
      if(t>21)
         break;
    }
 
 System.out.println("\n the throughput is "+((float)tnoj/t));
 System.out.print("MEMORY BLOCKS { ");
  for(int i=1;i<=tnomb;i++)
    {
           System.out.print(mem[i].size+"  " );
    }
 System.out.println(" }\n  ");
 System.out.println("\nJOBID  JOBSIZE  MEMSIZE  WAITTMINQ    INTERNALFRAG   ");
  for(int i=1;i<=tnoj;i++)
    {
           System.out.print(job[i].id);
           System.out.print("         "+job[i].size);
           System.out.print("     "+l[i]);
           System.out.print("         "+job[i].wt);
           System.out.println("       "+job[i].IF);
    }
 }
}