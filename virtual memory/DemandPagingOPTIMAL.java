import java.util.Scanner;
class DemandPagingOPTIMAL
  {
     public static void main(String args[])
       { 
          int pf=0,loop,max,temp=-1,l=0;
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter the no. of frames ");
          int tfr=sc.nextInt();
          sc.nextLine();
        
          int fr[] = new int[tfr+1];
          for(int i=1;i<=tfr;i++)
             fr[i]=-1;

          System.out.println("enter the size of reference string ");
          int sizeors=sc.nextInt();
          int a[]=new int[sizeors+1];

          System.out.println("\n  the reference string ");
          for(int i=1;i<=sizeors;i++)
             {
                   a[i]=(int)(Math.random()*10);
                   System.out.print(a[i]+" ");
             }


          System.out.println(" \nOPTIMAL\n");  
          System.out.println("refernceno   refInframe       pgfault ");
           for(int i=1;i<=sizeors;i++)
             {
               boolean statusfr=false;
               for(int j=1;j<=tfr;j++)
                 {
                   if(fr[j]==-1)
                     {
                        statusfr=true;
                        l=j;
                        break;
                      }
                  }
                System.out.println();
                System.out.print("   "+a[i]+"           ");
                boolean status=false;
                for(int j=1;j<=tfr;j++)
                  {
                    if(a[i]==fr[j])
                      status=true;
                   }
                 if(status==true)
                   {
                      for(int j=1;j<=tfr;j++)
                        {
                           if(fr[j]==-1)
                              System.out.print("  ");
                           else
                              System.out.print(fr[j]+" ");
                         }
                        System.out.print("          "+pf);
                    }
                  else if(statusfr==true)
                    {
                       pf++;
                       fr[l]=a[i];
                       for(int j=1;j<=tfr;j++)
                         {
                           if(fr[j]==-1)
                              System.out.print("  ");
                           else
                              System.out.print(fr[j]+" ");
                          }
                         System.out.print("          "+pf);
                      }
                    else
                     {
                       max=-1;
                       pf++;
                       for(int j=1;j<=tfr;j++)
                          {
                             int k;
                             boolean reffg=false;
                             for(k=i+1;k<=sizeors;k++)
                                {
                                   if(fr[j]==a[k])
                                     {
                                        reffg=true;
                                        if(k>max)
                                          {
                                             max=k;
                                             temp=j;
                                           }
                                          break;
                                       }
                                  }
                                if(reffg==false)
				  {
				    temp=j;
				    break;
				   }
			    }
			 fr[temp]=a[i];
			 for(int j=1;j<=tfr;j++)
			   {
			      if(fr[j]==-1)
				 System.out.print("  ");
			      else
			         System.out.print(fr[j]+" ");
			    }
			  System.out.print("          "+pf);
		         }
                       }
      }
}