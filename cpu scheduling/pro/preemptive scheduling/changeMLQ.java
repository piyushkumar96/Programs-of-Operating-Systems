import java.util.Scanner;
class process
{
int cpub,cpubr,tat,wt,at;
String id;
boolean flagf,flagr;
}
class changeMLQ
{
static process pf[];
static int count=0,cf=0;
public static void main(String args[])
{
   Scanner sc=new Scanner(System.in);
   int tq=3;
   System.out.println("enter the no. of process");
   int n=sc.nextInt();
   sc.nextLine();
   pf=new process[n+1];
   process pr[]=new process[n+1];
   for(int i=1;i<=n;i++)
    {
      pr[i]=new process();
      pr[i].id=""+i;
      System.out.println("enter the AT of process");
      pr[i].at=sc.nextInt();
      sc.nextLine();
      System.out.println("enter the CPUB of process");
      pr[i].cpubr=pr[i].cpub=sc.nextInt();
      sc.nextLine();
    }
   process temp;
   for(int i=1;i<=n;i++)
     {
       for(int j=2;j<=n;j++)
	{
	  if(pr[j].at<pr[j-1].at)
	   {
		temp=pr[j];
		pr[j]=pr[j-1];
		pr[j-1]=temp;
	   }
	}
      }
   boolean select;
   int cr,t=0,tempt=0,pfp=0,temptt;
   System.out.println("the gentt chart is as follows ");
   while(count!=n)
    {
      select=false;
      cr=1;
      while(cr<=n)
        {
            if((pr[cr].at<=t)&&(pr[cr].flagr==false))
              {
		select=true;
		if((pr[cr].cpubr-tq)>0)
		 {
		   if((tempt+6-t)<tq)
		    {
		      if(t!=tempt+6)
			System.out.println("from t = "+t+" to t = "+(tempt+6)+" "+pr[cr].id+" process runs");
		      temptt=tempt+6-t;
                      t=tempt+6;
                      tempt=t=fcfs(t,pfp);
                      System.out.println("from t = "+t+" to t = "+(t+tq-temptt)+" "+pr[cr].id+" process runs");
                      t=t+tq-temptt;
                    }
                   else
                    {
                 	if((tempt+6-t)==tq)
			    tempt=t=fcfs(t,pfp);
			System.out.println("from t = "+t+" to t = "+(t+tq)+" "+pr[cr].id+" process runs");
			t=t+tq;
		    }
		  pr[cr].cpubr=pr[cr].cpubr-tq;
		  if((pr[cr].cpub-pr[cr].cpubr)==6)
 		  {
		    pr[cr].flagr=true;
		    pf[++pfp]=pr[cr];
		  }
	 	 }
		else
		{
		   if((tempt+6-t)<pr[cr].cpubr)
		    {
		      if(t!=tempt+6)
		      System.out.println("from t = "+t+" to t = "+(tempt+6)+" "+pr[cr].id+" process runs");
		      temptt=tempt+6-t;
		      t=tempt+6;
	  	      tempt=t=fcfs(t,pfp);
	              System.out.println("from t = "+t+" to t = "+(t+pr[cr].cpubr-temptt)+" "+pr[cr].id+" process runs");
	              t=t+pr[cr].cpubr-temptt;
		    }
		   else
		    {
		      if((tempt+6-t)==pr[cr].cpubr)
	 	      tempt=t=fcfs(t,pfp);
                      System.out.println("from t = "+t+" to t = "+(t+pr[cr].cpubr)+" "+pr[cr].id+" process runs");
                      t=t+pr[cr].cpubr;
                    }
                  count++;
		  pr[cr].tat=t-pr[cr].at;
		  pr[cr].wt=pr[cr].tat-pr[cr].cpub;
		  pr[cr].flagr=true;
		}
              }
             else if(pr[cr].at>t)
		{
 		  if(select==false)
   		   {
     		     if(cf==pfp)
      		      {
      		         System.out.println("from t = "+t+" to t = "+(t+1)+" no process runs");
      		         t++;
     		         tempt=t;
      		      }
     		     else
     		        tempt=t=fcfs(t,pfp);
   	            }
    		  tempt=t;
  		  break;
                }
            cr++;
          }  //inner while loop
      if((cr==n+1)&&(select==false))
       {
         while(count!=n)
         t=fcfs(t,pfp);
        }
   }
int sum=0;
for(int i=1;i<=n;i++)
{
System.out.println("ID"+" CPUB"+" AT"+" WT"+" TAT");
System.out.println(" "+pr[i].id+"   "+pr[i].cpub+"  "+pr[i].at+"  "+pr[i].wt+"  "+pr[i].tat);
sum=sum+pr[i].wt;
}
System.out.println("average waiting time of the processes is "+(float)sum/n);
}
static int fcfs(int t,int pfp)
{
int tempt=t;
while(cf<pfp)
{
for(int i=1;i<=pfp;i++)
{
if(pf[i].flagf==false)
{
if(pf[i].cpubr<=(tempt+4-t))
{
pf[i].flagf=true;
count++;
cf++;
System.out.println("from t = "+t+" to t = "+(t+pf[i].cpubr)+" "+pf[i].id+" process runs");
t=t+pf[i].cpubr;
pf[i].tat=t-pf[i].at;
pf[i].wt=pf[i].tat-pf[i].cpub;
}
else
{
if(t==tempt+4)
return t;
pf[i].cpubr=pf[i].cpubr-(tempt+4-t);
System.out.println("from t = "+t+" to t = "+(tempt+4)+" "+pf[i].id+" process runs");
t=tempt+4;
return t;
}
}
}
}
return t;
}
}