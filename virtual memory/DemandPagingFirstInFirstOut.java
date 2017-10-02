import java.util.Scanner;
class DemandPagingFirstInFirstOut
  {
    public static void main(String args[])
     {   int pf=0,loop;
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
                                       System.out.println("               "+pf);
                                     j++;
                                     k=1;
                                  }
                               if(j>sizeors)
                                   break; 
                         } 
                        
                        fr[i]=a[j];
                        pf++;       
                       
                            System.out.print("     "+a[j]+"             ");
                            for(int m=1;m<=tfr;m++)
                              { 
                                if(fr[m]==-1)
                                   System.out.print("  "); 
                                else 
                                   System.out.print(fr[m]+" ");
                               }
                            System.out.println("               "+pf);
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
   }