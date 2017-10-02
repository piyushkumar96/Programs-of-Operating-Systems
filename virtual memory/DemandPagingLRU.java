import java.util.Scanner;
class DemandPagingLRU
  {
    public static void main(String args[])
      { int pf=0,t1,t2,recentpg=0,i;
	Scanner sc=new Scanner(System.in);

          System.out.println("Enter the no. of frames ");
          int tfr=sc.nextInt();
          sc.nextLine();
        
          int fr[] = new int[tfr+1];
          for(i=1;i<=tfr;i++)
             fr[i]=-1;

          System.out.println("enter the size of reference string ");
          int sizeors=sc.nextInt();
          int a[]=new int[sizeors+1];

          System.out.println("\n  the reference string ");
          for( i=1;i<=sizeors;i++)
             {
                   a[i]=(int)(Math.random()*10);
                   System.out.print(a[i]+" ");
             }
          System.out.println(" \nLRU\n");  
          System.out.println("refernceno   refInframe       pgfault ");
          
	 for(i=1;i<=sizeors;i++)
	   {
	      t1=a[i];
	      System.out.println();
	      System.out.print("   "+a[i]+"           ");
	      boolean flag=false;
	      for(int j=1;j<=tfr;j++)
		{
		  if(a[i]==fr[j])
		   {
		     recentpg=j;
		     flag=true;
		    }
		 }
	       if(flag==true)
	  	{
		  for(int j=1;j<=recentpg;j++)
		    {
			t2=fr[j];
			fr[j]=t1;
			t1=t2;
		     }
		   for(int j=1;j<=tfr;j++)
		     {
			if(fr[j]==-1)
			   System.out.print("  ");
			else
			   System.out.print(fr[j]+" ");
		      }
		    System.out.print("           "+pf);
		  }
		 else
		  {
	       	     pf++;
                     for(int j=1;j<=tfr;j++)
                       {
			  t2=fr[j];
			  fr[j]=t1;
                          t1=t2;
                        }
                      for(int j=1;j<=tfr;j++)
                        {
			   if(fr[j]==-1)
			      System.out.print("  ");
			    else
			      System.out.print(fr[j]+" ");
                         }
                      System.out.print("           "+pf);
                    }
                 }
    }
}