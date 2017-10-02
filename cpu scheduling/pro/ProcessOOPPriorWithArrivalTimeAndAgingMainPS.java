import java.util.Scanner;
class ProcessOOPPriorWithArrivalTimeAndAgingPS
{
int cpuburst,at,remcpuburst,wt,tat,pr;
String id;
}
class ProcessOOPPriorWithArrivalTimeAndAgingMainPS
{
public static void main(String args[])
{
System.out.println("enter the no. of process");
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
sc.nextLine();
System.out.println("enter the aging period");
int ap=sc.nextInt();
sc.nextLine();
ProcessOOPPriorWithArrivalTimeAndAgingPS obj[]=new ProcessOOPPriorWithArrivalTimeAndAgingPS[n+1];
int sum=0;
for(int i=1;i<=n;i++)
{
obj[i]=new ProcessOOPPriorWithArrivalTimeAndAgingPS();
System.out.println("enter process id");
obj[i].id=sc.nextLine();
System.out.println("enter the CPU burst ");
obj[i].cpuburst=obj[i].remcpuburst=sc.nextInt();
sc.nextLine();
System.out.println("enter the arrival time");
obj[i].at=sc.nextInt();
sc.nextLine();
System.out.println("enter the priority");
obj[i].pr=sc.nextInt();
sc.nextLine();
sum=sum+obj[i].cpuburst;
}
int min,k=0,t=0,nop=0,tempat=0;
System.out.println("\nthe aging period is "+ap);
        System.out.println("the gantt chart \n");
        System.out.print(t);
while(true)
{
min=101;
k=0;
for(int i=1;i<=n;i++)
{
if((obj[i].remcpuburst!=0)&&(obj[i].at<=t))
{
if(obj[i].pr==min)
{
if(obj[i].at<tempat)
{
min=obj[i].pr;
tempat=obj[i].at;
k=i;
}
}
else if(obj[i].pr<min)
{
min=obj[i].pr;
tempat=obj[i].at;
k=i;
}
}
}
for(int i=1;i<=n;i++)
{
if((obj[i].at<=t)&&(obj[i].remcpuburst!=0)&&((t+1-obj[i].at-(obj[i].cpuburst-obj[i].remcpuburst))%ap==0)&&((t+1-obj[i].at-(obj[i].cpuburst-obj[i].remcpuburst))!=0)&&(i!=k)&&((obj[i].pr)!=0))
obj[i].pr--;
}
if(k==0)
{
System.out.print("--->"+(t+1));
t++;
}
else
{
System.out.print("-"+obj[k].id+"->"+(t+1));
obj[k].remcpuburst--;
t++;
if(obj[k].remcpuburst==0)
{
obj[k].tat=t-obj[k].at;
obj[k].wt=obj[k].tat-obj[k].cpuburst;
nop++;
}
}
if(nop==n)
break;
}
int sumtat=0,sumwt=0;
       System.out.println(" \n ID  ART  PRIO   CPUBURST   TAT    WAITTIME  ");
		for(int i=1;i<=n;i++)
		   {    System.out.print("  "+obj[i].id);
                        System.out.print("   "+obj[i].at);
                        System.out.print("   "+obj[i].pr);
                        System.out.print("      "+obj[i].cpuburst);
			System.out.print("        "+obj[i].tat);
			System.out.println("        "+obj[i].wt);
                       sumtat=sumtat+obj[i].tat;
                       sumwt=sumwt+obj[i].wt;
		   }
      System.out.println(" the average tat "+(sumtat/n));
      System.out.println(" the average wt "+(sumwt/n));
  
}
}