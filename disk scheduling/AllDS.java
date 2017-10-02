import java.util.Scanner;
class AllDS
  {
     static int sum1=0,sum2=0,sum3=0;
    public static void main(String args[])
     {   Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of reference string ");
        int sizeors=sc.nextInt();
        sc.nextLine();

        int a[]=new int[sizeors+1],sum=0;
      System.out.println("\n  the reference string ");
      for(int i=1;i<=sizeors;i++)
             {
                   a[i]=(int)(Math.random()*200);
                   System.out.print(a[i]+" ");
             }

       a[0]=(int)(Math.random()*200);
       System.out.println("\n  the current reference is  "+a[0]);  
     
     AllDS ob=new AllDS();
    while(true)
   {
      System.out.println("\n enter the choice \n1.fifo \n2.optimal \n3.lru\n4.displaybestalgo \n5.exit\n ");
       int ch=sc.nextInt();
        sc.nextLine();
        switch(ch)
          {
              case 1: ob.fifo(sizeors,a);
                       break;
              case 2: ob.stsf(sizeors,a);
                       break;
              case 3: ob.clook(sizeors,a);
                       break;
              case 4: ob.display();
                       break;
              case 5: System.exit(1);
                       break;
           }
     }
   }           
    void fifo(int sizeors,int[] a)
       {   
          System.out.println(" \nDSFIFO\n");  
         System.out.println("currref   headMovement    preref ");
         for(int j=0;j<sizeors;j++)
            {
               System.out.print(" "+a[j]);
                    System.out.print("         "+Math.abs(a[j]-a[j+1]));
                    sum1=sum1+Math.abs(a[j]-a[j+1]);
                System.out.println("             "+a[j+1]);
             }
          System.out.println(" total disk head movement is "+sum1);

         }
     void stsf(int sizeors,int[] a)
       {  int min=0,k=0;
         System.out.println(" \nDSShortestSeakFirst\n");  
         System.out.println("currref   difference    preref ");
         for(int j=0;j<sizeors;j++)
            {   int  max=500;
                for(int i=j+1;i<=sizeors;i++)
                  {  min=Math.abs(a[j]-a[i]);
                       
                        if(min<max)
                          {
                            max=Math.abs(a[j]-a[i]);       
                             k=i;
                          }                  
                   }
               int t=a[j+1];
                   a[j+1]=a[k];
                   a[k]=t;
               System.out.print(" "+a[j]);
               System.out.print("         "+Math.abs(a[j+1]-a[j]));
                System.out.println("           "+a[j+1]);
                sum2=sum2+Math.abs(a[j+1]-a[j]);
             
             }
          System.out.println(" total disk head movement is "+sum2);

           }

     void clook( int sizeors,int[] a)
       {  Scanner in=new Scanner(System.in);
         int k=0;
        
    for(int j=1;j<=sizeors;j++)
     {
       for(int i=1;i<=sizeors;i++)
             {
                  if(a[j]<a[i])
                    { int t=a[j];
                      a[j]=a[i];
                      a[i]=t;
                     }
             }
    }
    int b=a[0];

for(int i=1;i<=sizeors;i++)
             {
                   System.out.print(a[i]+" ");
             }
         System.out.println(" \nDSCLOOK\n");  
         System.out.println("enter the choice \n1.MOVE RIGHT \n2.MOVE LEFT\n ");
         int c =in.nextInt();
         for(int i=1;i<=sizeors;i++)
             {
                if((b<a[i])&&(c==1))
                 {
                     k=i;
                     break;
                  }
                 if((b<a[i])&&(c==2))
                 {
                     k=i-1;
                     break;
                  }
              }
         System.out.println("currref   difference    preref ");
   switch(c)
     {
       case 1: for(int j=k;j<=sizeors+1;j++)
                {   
                 if(j==sizeors+1)
                  {
                    System.out.print(" "+b);
                    System.out.print("         "+Math.abs(b-a[1]));
                    sum3=sum3+Math.abs(b-a[1]);
                    System.out.println("             "+a[1]);
                  }
                 else
                  {
                      System.out.print(" "+b);
                      System.out.print("         "+Math.abs(b-a[j]));
                      sum3=sum3+Math.abs(b-a[j]);
                      System.out.println("             "+a[j]);
                      b=a[j];
                  }
             
                 }
                for(int j=1;j<k-1;j++)
                 {  System.out.print(" "+a[j]);
                    System.out.print("         "+Math.abs(a[j]-a[j+1]));
                    sum3=sum3+Math.abs(a[j]-a[j+1]);
                    System.out.println("             "+a[j+1]);
                 }
                System.out.println(" total disk head movement is "+sum3);
                break;
      case 2: for(int j=k;j>=0;j--)
               {   
                if(j==0)
                  {
                    System.out.print(" "+b);
                    System.out.print("         "+Math.abs(b-a[sizeors]));
                    sum3=sum3+Math.abs(b-a[sizeors]);
                    System.out.println("             "+a[sizeors]);
                   }
                  else
                   {
                     System.out.print(" "+b);
                     System.out.print("         "+Math.abs(b-a[j]));
                     sum3=sum3+Math.abs(b-a[j]);
                     System.out.println("             "+a[j]);
                     b=a[j];
                   }
                }
              for(int j=sizeors;j>k+1;j--)
               {   
                 System.out.print(" "+a[j]);
                 System.out.print("         "+Math.abs(a[j]-a[j-1]));
                 sum3=sum3+Math.abs(a[j]-a[j-1]);
                 System.out.println("             "+a[j-1]); 
               }
              System.out.println(" total disk head movement is "+sum3);
              break;
      }
           }

         void display()
           {
                if((sum1<sum2)&&(sum1<sum2))
                    System.out.print(" the fifo is best ");
                 else if((sum2<sum3)&&(sum2<sum3))
                    System.out.print(" the stsf is best ");
                 else
                    System.out.print(" the clook is best ");
           }
   }