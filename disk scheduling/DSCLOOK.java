import java.util.Scanner;
class DSCLOOK
  {
    public static void main(String args[])
     {   int sum=0,k=0;
        Scanner sc=new Scanner(System.in);

        System.out.println("enter the size of reference string ");
         int sizeors=sc.nextInt();
         sc.nextLine();
         int a[]=new int[sizeors+1];
      System.out.println("\n  the reference string ");
      for(int i=1;i<=sizeors;i++)
             {
                   a[i]=(int)(Math.random()*200);
                   System.out.print(a[i]+" ");
             }
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
System.out.print("\n the shortest reference string \n");
    
      int  b=(int)(Math.random()*200);
     System.out.println("\n  the current reference is  "+b);  
for(int i=1;i<=sizeors;i++)
             {
                   System.out.print(a[i]+" ");
             }
         System.out.println(" \nDSCLOOK\n");  
         System.out.println("enter the choice \n1.MOVE RIGHT \n2.MOVE LEFT\n ");
         int ch =sc.nextInt();
         for(int i=1;i<=sizeors;i++)
             {
                if((b<a[i])&&(ch==1))
                 {
                     k=i;
                     break;
                  }
                 if((b<a[i])&&(ch==2))
                 {
                     k=i-1;
                     break;
                  }
              }
         System.out.println("currref   difference    preref ");
   switch(ch)
     {
       case 1: for(int j=k;j<=sizeors+1;j++)
                {   
                 if(j==sizeors+1)
                  {
                    System.out.print(" "+b);
                    System.out.print("         "+Math.abs(b-a[1]));
                    sum=sum+Math.abs(b-a[1]);
                    System.out.println("             "+a[1]);
                  }
                 else
                  {
                      System.out.print(" "+b);
                      System.out.print("         "+Math.abs(b-a[j]));
                      sum=sum+Math.abs(b-a[j]);
                      System.out.println("             "+a[j]);
                      b=a[j];
                  }
             
                 }
                for(int j=1;j<k-1;j++)
                 {  System.out.print(" "+a[j]);
                    System.out.print("         "+Math.abs(a[j]-a[j+1]));
                    sum=sum+Math.abs(a[j]-a[j+1]);
                    System.out.println("             "+a[j+1]);
                 }
                System.out.println(" total disk head movement is "+sum);
                break;
      case 2: for(int j=k;j>=0;j--)
               {   
                if(j==0)
                  {
                    System.out.print(" "+b);
                    System.out.print("         "+Math.abs(b-a[sizeors]));
                    sum=sum+Math.abs(b-a[sizeors]);
                    System.out.println("             "+a[sizeors]);
                   }
                  else
                   {
                     System.out.print(" "+b);
                     System.out.print("         "+Math.abs(b-a[j]));
                     sum=sum+Math.abs(b-a[j]);
                     System.out.println("             "+a[j]);
                     b=a[j];
                   }
                }
              for(int j=sizeors;j>k+1;j--)
               {   
                 System.out.print(" "+a[j]);
                 System.out.print("         "+Math.abs(a[j]-a[j-1]));
                 sum=sum+Math.abs(a[j]-a[j-1]);
                 System.out.println("             "+a[j-1]); 
               }
              System.out.println(" total disk head movement is "+sum);
              break;
      }
               
    }
 }