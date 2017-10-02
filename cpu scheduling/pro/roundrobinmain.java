import java.util.Scanner;
class roundrobin
{
int cpub,cpubr,tat,wt,at;
String id;
boolean status;
}
class roundrobinmain
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
int n=(int)(Math.random()*10)+1;
System.out.println(" \n total no. of process are "+n);
roundrobin p[]=new roundrobin[n+1];
for(int i=1;i<=n;i++)
{
p[i]=new roundrobin();
p[i].id="  "+i;
System.out.println("process id "+p[i].id);

p[i].at=(int)(Math.random()*20)+1;
System.out.println("the artm is   "+p[i].at );
p[i].cpubr=p[i].cpub=(int)(Math.random()*20)+1;
System.out.println("the cpuburst is   "+p[i].cpub);
System.out.println(" \n ");
}

System.out.println("\n enter the time quantum");
int tq=sc.nextInt();
sc.nextLine();

int count=0,t=0;
boolean remstatus;
System.out.println("\n gantt chart is  \n  ");
System.out.println(t);
while(count!=n)
{
remstatus=false;
for(int i=1;i<=n;i++)
{
if((p[i].status==false)&&(p[i].at<=t))
{
remstatus=true;
if((p[i].cpubr-tq)>0)
{
p[i].cpubr=p[i].cpubr-tq;
System.out.print("--"+p[i].id+"-->"+(t+tq));
t=t+tq;
}
else
{
System.out.println("--"+p[i].id+"-->"+(t+p[i].cpubr));
t=t+p[i].cpubr;
p[i].cpubr=0;
count++;
p[i].tat=t-p[i].at;
p[i].wt=p[i].tat-p[i].cpub;
p[i].status=true;
}
}
}
if(remstatus==false)
{
System.out.print("---->"+(t+1));
t++;
}
}
int sumwt=0;
int sumtat=0;
 System.out.print(" \n the time slice is "+tq+" \n");
       System.out.println("  ID  ART  CPUBURST   TAT    WAITTIME  ");
		for(int i=1;i<=n;i++)
		   {    System.out.print("  "+p[i].id);
                        System.out.print("   "+p[i].at);
                        System.out.print("      "+p[i].cpub);
			System.out.print("        "+p[i].tat);
			System.out.println("        "+p[i].wt);
                                         sumwt=sumwt+p[i].wt;
                                         sumtat=sumtat+p[i].tat;
		   }
System.out.println("\n average wt is "+(float)sumwt/n);
System.out.println("\n average tat is "+(float)sumtat/n);
}
}