import java.io.*;
class process implements Cloneable
{
int at,cpub,tat=0,wt=0,tr=0;
String pid;
int rt;static int ts;int r=0;
	public void stat(process obj[])throws CloneNotSupportedException
	{
		int i,j,k;process fcfs[]=new process[obj.length];
		process st;
		for(i=0;i<obj.length;i++)
		{
		for(j=0;j<obj.length-1;j++)
		{
		if(obj[j].at>obj[j+1].at)
		{
		st=obj[j+1];
		obj[j+1]=obj[j];
		obj[j]=st;
		}}}
		float sumtat=0.0f,sumwt=0.0f;
		int c=0,count=0,timer=obj[0].at,flag,fc=0;int rr=0,fr=0,temp=0,temp1=0;	
		while(true)
		{			
					
					for(j=0;j<obj.length;j++)
					{
					if(obj[j].rt!=0&&obj[j].at<=timer)
					      {
						if(obj[j].rt<ts)
						ts=obj[j].rt;
							if(temp!=0&&obj[temp1].rt!=0)
							{
							j=temp1;
							ts=temp;
							}
							temp=ts;temp1=j;
						for(k=1;k<=ts;k++)
						{
						if(timer+k==rr+6)
							{ts=k;}
						}
						temp=temp-ts;
						for(k=1;k<=ts;k++)
						{
						if(obj[j].r+k==6)
						ts=k;
						}
						timer=timer+ts;obj[j].r+=ts;
						obj[j].tr=timer;
						obj[j].rt=obj[j].rt-ts;
						System.out.println("Process is over at  "+timer+" PID "+obj[j].pid+" RT "+obj[j].rt+" RR ");
							if(obj[j].rt!=0&&obj[j].r==6)
								{	
									fcfs[fc++]=(process)obj[j].clone();
									obj[j].rt=0;
								}
							
						}
						else
						{
							if(obj[j].at>timer&&obj[j].rt!=0)
							{	int cc=0;
							for(i=0;i<j;i++)
							{
								if(obj[i].rt==0)
								++cc;
							}
							if(cc==j)
								{
								/*for(i=timer;i<=obj[i].at;i++)
								      {
									if(timer+i==rr+6)
									timer=i;	
								      }*/
								timer=obj[j].at;
								}
							}
						}
						if(timer==(rr+6))
							{
								rr=timer;	
								if(fc!=0)
								{	//System.out.println("FCi  "+fcfs[fc-1].rt);
									fr=timer;
									for(i=0;i<fc&&timer<fr+4;i++)
									{
									if(fcfs[i].rt!=0)
									      {
										if(fcfs[i].rt<4)
										{
											timer=timer+fcfs[i].rt;
											fcfs[i].rt=0;
											for(k=0;k<obj.length;k++)
											{
											if((obj[k].pid).equals(fcfs[i].pid))
											obj[k].tr=timer;
											}
											
										}
										else
										{
										timer=timer+4;
										fcfs[i].rt=fcfs[i].rt-4;
										for(k=0;k<obj.length;k++)
											{
											if((obj[k].pid).equals(fcfs[i].pid))
											obj[k].tr=timer;
											}
										}
									System.out.println("Process is over at  "+timer+" PID "+fcfs[i].pid+" RT "+fcfs[i].rt+" FC");
									        }
									
									}
								}
								rr=timer;	
							}
						ts=3;
					}
			for(i=0;i<obj.length;i++)
			{
				if(obj[i].rt==0)
				++count;
			}
			if(count==obj.length)
			{	count=0;
				for(i=0;i<fcfs.length&&fcfs[i]!=null;i++)
				{
					if(fcfs[i].rt!=0)
					{
					timer+=fcfs[i].rt;
					fcfs[i].rt=0;
					for(j=0;j<obj.length;j++)
					{
					if((obj[j].pid).equals(fcfs[i].pid))
					obj[j].tr=timer;
					}
					System.out.println("Process is over at  "+timer+" PID "+fcfs[i].pid+" RT "+fcfs[i].rt+" FC");
					}
				}
				break;
			}
			count=0;
						
		}
		System.out.println();
		System.out.println("PROCESS	   	AT		CPUB		CT	TAT	         WT");
		for(i=0;i<obj.length;i++)
		{
			obj[i].tat=obj[i].tr-obj[i].at;
			obj[i].wt=obj[i].tat-obj[i].cpub;
		System.out.println(obj[i].pid+"		"+obj[i].at+"		"+obj[i].cpub+"		"+obj[i].tr+"	"+obj[i].tat+"		"+obj[i].wt);
		}
		
	}
}
class MLQ
{
public static void main(String args[]) throws CloneNotSupportedException
{
int n,i;
Console c=System.console();
System.out.println("Enter no of process");
n=Integer.parseInt(c.readLine());
System.out.println("TIME QUANTUM=3");
process.ts=3;
process ob[]=new process[n];
System.out.println("ENTER PROCESS ID CPUB AND ARRIVAL TIME OF    "+n+"  PROCESS");
for(i=0;i<n;i++)
{
ob[i]=new process();
System.out.println("ENTER THE PROCESS ID Of  "+(i+1)+" process");
ob[i].pid=c.readLine();
System.out.println("ENTER THE CPUB Of   "+(i+1)+" process");
ob[i].cpub=Integer.parseInt(c.readLine());
ob[i].rt=ob[i].cpub;
System.out.println("ENTER THE ARRIVAL TIME OF	 "+(i+1)+"  process");
ob[i].at=Integer.parseInt(c.readLine());
}
process o=new process();
o.stat(ob);
}
}
