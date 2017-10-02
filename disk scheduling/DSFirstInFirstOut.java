import java.util.Scanner;
class DSFirstInFirstOut
  {
    public static void main(String args[])
     {  
        Scanner sc=new Scanner(System.in);
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

         System.out.println(" \nDSFIFO\n");  
         System.out.println("currref   headMovement    preref ");
         for(int j=0;j<sizeors;j++)
            {
               System.out.print(" "+a[j]);
                    System.out.print("         "+Math.abs(a[j]-a[j+1]));
                    sum=sum+Math.abs(a[j]-a[j+1]);
                System.out.println("             "+a[j+1]);
             }
          System.out.println(" total disk head movement is "+sum);

       
      }
   }