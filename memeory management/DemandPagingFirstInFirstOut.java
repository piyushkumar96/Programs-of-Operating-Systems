import java.util.Scanner;
class DemandPagingFirstInFirstOut
  {
    public static void main(String args[])
     {   int a[]=new int[200],pf=0;
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the no. of frames ");
        int tfr=sc.nextInt();
        sc.nextLine();
        int fr[] = new int[tfr+1];

        for(int i=1;i<=tfr;i++)
             fr[i]=-1;

        System.out.println("enter the size of reference string ");
            int sizeors=sc.nextInt();
/*
  System.out.println("\n enter the reference string ");
   for(int i=1;i<=sizeors;i++)
        {
                   a[i]=sc.nextInt();
                   sc.nextLine();
               
        }
*/

      System.out.println("\n  the reference string ");
      for(int i=1;i<=sizeors;i++)
             {
                   a[i]=(int)(Math.random()*10);
                   System.out.print(a[i]+" ");
             }


         System.out.println(" \nFIFO\n");  
         System.out.println("refernceno   referenceInframe         page fault ");
         for(int i=1;i<=tfr;i++)
           {
               fr[i]=a[i];
               pf++;
              System.out.print("     "+a[i]+"             ");
               for(int j=1;j<=i;j++)
                     System.out.print(fr[j]+" ");  
               System.out.println("                   "+pf);
           }

          for(int j=tfr+1;j<=sizeors;j++)
            {
               for(int i=1;i<=tfr;i++)
                {  
                   if(fr[i]==a[j])
                     {    
                        j++;
                        i--;
                     }
                   else
                     {  
                        fr[i]=a[j];
                        pf++;       
                       if(j<=sizeors)
                         {
                            System.out.print("     "+a[j]+"             ");
                            for(int k=1;k<=tfr;k++)
                               System.out.print(fr[k]+" ");  
                            System.out.println("                   "+pf);
                            j++;
                         }
                       else
                        {
                           break;
                        }

                              if(i==tfr)
                                 j--;
                       continue;
                      }
            
                }

             }
      }
   }