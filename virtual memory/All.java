import java.util.Scanner;
class All
  {
     static int pf1=0,pf2=0,pf3=0;
    public static void main(String args[])
     {   int a[]=new int[200],pf=0,loop;
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the no. of frames ");
        int tfr=sc.nextInt();
        sc.nextLine();
        int fr[] = new int[tfr+1];

        for(int i=1;i<=tfr;i++)
             fr[i]=-1;

        System.out.println("enter the size of reference string ");
            int sizeors=sc.nextInt();
      System.out.println("\n  the reference string ");
      for(int i=1;i<=sizeors;i++)
             {
                   a[i]=(int)(Math.random()*10);
                   System.out.print(a[i]+" ");
             }
     All ob=new All();
    while(true)
   {
      System.out.println("\n enter the choice \n1.fifo \n2.optimal \n3.lru\n4.displaybestalgo \n5.exit\n ");
       int ch=sc.nextInt();
        sc.nextLine();
        switch(ch)
          {
              case 1: ob.fifo(tfr,fr,sizeors,a);
                       break;
              case 2: ob.optimal(tfr,fr,sizeors,a);
                       break;
              case 3: ob.lru(tfr,fr,sizeors,a);
                       break;
              case 4: ob.display();
                       break;
              case 5: System.exit(1);
                       break;
           }
     }
   }           
    void fifo( int tfr,int[] fr,int sizeors,int[] a)
       {   
           System.out.println(" \nFIFO\n");  
         System.out.println("refernceno   referenceInframe         page fault ");

         for(int j=1;j<=sizeors;j++)
            {
               for(int i=1;i<=tfr;i++)
                {  
                  for(int k=1;k<=tfr;k++)
                        {     if(fr[k]==a[j])
                                  {   
                                      System.out.print("     "+a[j]+"             ");
                                      for(int m=1;m<=tfr;m++)
                                        { 
                                           if(fr[m]==-1)
                                              System.out.print("  "); 
                                           else 
                                              System.out.print(fr[m]+" ");
                                        }
                                       System.out.println("               "+pf1);
                                     j++;
                                     k=1;
                                  }
                               if(j>sizeors)
                                   break; 
                         } 
                        
                        fr[i]=a[j];
                        pf1++;       
                       
                            System.out.print("     "+a[j]+"             ");
                            for(int m=1;m<=tfr;m++)
                              { 
                                if(fr[m]==-1)
                                   System.out.print("  "); 
                                else 
                                   System.out.print(fr[m]+" ");
                               }
                            System.out.println("               "+pf1);
                            j++;
                       if(i==tfr)
                            { 
                                     j--;     
                             }
                       if(j>sizeors)
                           break;
                      
                      
                     }
                   
                  
                }

         }
     void optimal( int tfr,int[] fr,int sizeors,int[] a)
       {   int loop,max,temp=-1,l=0;
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
                        System.out.print("          "+pf2);
                    }
                  else if(statusfr==true)
                    {
                       pf2++;
                       fr[l]=a[i];
                       for(int j=1;j<=tfr;j++)
                         {
                           if(fr[j]==-1)
                              System.out.print("  ");
                           else
                              System.out.print(fr[j]+" ");
                          }
                         System.out.print("          "+pf2);
                      }
                    else
                     {
                       max=-1;
                       pf2++;
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
			  System.out.print("          "+pf2);
		         }
                       }
           }

     void lru( int tfr,int[] fr,int sizeors,int[] a)
       {     int t1,t2,recentpg=0,i;
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
		    System.out.print("           "+pf3);
		  }
		 else
		  {
	       	     pf3++;
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
                      System.out.print("           "+pf3);
                    }
                 }
           }

         void display()
           {
                if((pf1<pf2)&&(pf1<pf3))
                    System.out.print(" the fifo is best ");
                 else if((pf2<pf1)&&(pf2<pf3))
                    System.out.print(" the optimal is best ");
                 else
                    System.out.print(" the lru is best ");
           }
   }