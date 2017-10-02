import java.util.Scanner;
class DSShortestSeakFirst
  {
    public static void main(String args[])
     {   int sum=0,min=0,k=0;
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
       a[0]=(int)(Math.random()*200);
     System.out.println("\n  the current reference is  "+a[0]);  
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
                sum=sum+Math.abs(a[j+1]-a[j]);
             
             }
          System.out.println(" total disk head movement is "+sum);

       
      }
   }