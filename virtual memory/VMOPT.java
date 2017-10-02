import java.io.*;
import java.util.*;
class VMOPT
{
public static void main(String args[])
{
int i=0,k=0,n,f;
Scanner sc=new Scanner(System.in);
System.out.println("Enter the no of frames and size of reference list ");
f=sc.nextInt();
n=sc.nextInt();
int an[]=new int[n];
int af[]=new int[f];
int au[]=new int[f];
System.out.print("\n references list is ");
while(i<n){
an[i]=(int)(Math.random()*10);
System.out.print(an[i]+" ");
i++;
}
int j=0;int c=0,flag=0,top=0,pf=0;
System.out.println("\nMEMORY		STRING			PF");
for(j=0;j<n;j++)
{
       if(c==0)
       {
	af[c]=an[j];
	System.out.println(an[j]+"		"+af[0]+"			"+(++pf));
       }
       else if(c<f)
        {
          for(i=0;i<c;i++)
       	    {
	       if(af[i]==an[j])
	        { 
                  flag=1;
	          break;
                }
	    }
          if(flag==0)
           {
             ++pf;
             af[c]=an[j];
           }
          else
            c--;
         flag=0;
         System.out.print(an[j]+"		");
         for(k=0;k<=c;k++)
            System.out.print(af[k]+"    ");
         System.out.print("			"+(pf)+"\n");
       }
       else
        {
          int min=0;
          for(i=0;i<f;i++)
	   {
	     if(an[j]==af[i])
	       {
                 flag=1;
	         break;
	       }
	    }
          if(flag==0)
           {
             
              for(i=0;i<f;i++)
	        {
	           for(k=j+1;k<n;k++)
		     {
		       if(af[i]==an[k])
		         {
                            au[i]=k-j-1;
                            break;
                         }
		        else
		          au[i]=k;
		      }
	          }
              for(i=0;i<f;i++)
                 if(au[i]>au[min])
                    min=i;
              af[min]=an[j];
              ++pf;
               min=0;
            }
          System.out.print(an[j]+"		");
          for(k=0;k<f;k++)
              System.out.print(af[k]+"    ");
          System.out.print("			"+(pf)+"\n");
        }
      c++;flag=0;
   }
  }
}