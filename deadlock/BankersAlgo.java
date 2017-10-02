import java.util.Scanner;
class BankersAlgo
  {
    public static void main(String args[])
     {   int i,j;
        Scanner sc=new Scanner(System.in);

        System.out.println(" enter the no of resources ");
         int res=sc.nextInt();
         sc.nextLine();
 
         int r[] = new int[res+1];
         int avl[]=new int[res+1];
         System.out.println(" enter the resource value  ");
         for(i=1;i<=res;i++)
           {
              r[i]=sc.nextInt();
             avl[i]=0;
            }
         
        System.out.println(" enter the no of process ");
         int nop=sc.nextInt();
         sc.nextLine();

         int all[][] = new int[nop+1][res+1];
         
         System.out.println(" enter the allocation matrix  \n  ");
         for(i=1;i<=nop;i++)
           {
               for(j=1;j<=res;j++)
                 {
                    all[i][j]=sc.nextInt();
                    avl[j]=avl[j]+all[i][j];    
                  }
            }
          int avl1[]=new int[res+1];
           System.out.print(" \n after allocation available is ");
           for(i=1;i<=res;i++)
             {
                avl[i]=avl1[i]=r[i]-avl[i];
                System.out.print(avl[i]+" ");
             }        
           int maxr[][] = new int[nop+1][res+1];
           int need[][] = new int[nop+1][res+1];
          System.out.println(" \nenter the max resource matrix \n  ");
         for(i=1;i<=nop;i++)
           {
               for(j=1;j<=res;j++)
                 {
                    maxr[i][j]=sc.nextInt();
                    need[i][j]=maxr[i][j]-all[i][j];
                  }
            }
           System.out.println("\nProcess  allocated   maxdemand   need   available  \n  ");
         
        boolean fin[]=new boolean[nop+1];
        int c=0,n=0,o=0;
            while(true)
             {
                 for(i=1;i<=nop;i++)
                    {  
                       if(fin[i]==false)
                         {
                             for(j=1;j<=res;j++)
                               {
                                   if(need[i][j]<=avl[j])
                                       c++;
                               }
                             if(c==res)
                               {    
                                         System.out.print("P"+i+"         ");
                                         for(j=1;j<=res;j++)
                                            {
                                               System.out.print(all[i][j]+" ");
                                            }
                                          System.out.print("\t");
                                         for(j=1;j<=res;j++)
                                            {
                                               System.out.print(maxr[i][j]+" ");
                                            }
                                         System.out.print("\t");
                                         for(j=1;j<=res;j++)
                                            {
                                               System.out.print(need[i][j]+" ");                                        
                                            }
                                        System.out.print("\t");
                                        for(j=1;j<=res;j++)
                                           {   
                                               System.out.print(avl[j]+" ");                                            
                                               avl[j]=avl[j]+all[i][j];
                                           }
                                        System.out.print("\n");
                                   
                                     fin[i]=true;
                                     if(fin[i]==true)
                                        n++;    
                                  }
                               
                            }        
                           c=0;
                       }
                  o++;
                  if(n==nop)
                     break;
                  if(o>10)
                     break;
                }
           
                if(n==nop)
                   System.out.print(" the  system is in safe state ");
                else
                   System.out.print(" the system is in unsafe state ");
         int req[] = new int[res+1];
         c=0;
          System.out.println("\nid of requesting for new instance (greater than 1 and less than equal to "+nop+")\n  ");
           int y=sc.nextInt();
            System.out.println(" \n enter the request of process "+y+"\n");   
             for(i=1;i<=res;i++)
                 {
                   req[i]=sc.nextInt();
                    all[y][i]=all[y][i]+req[i];
                    need[y][i]=need[y][i]-req[i];
                    if(req[i]<=avl1[i])
                      {
                         avl1[i]=avl1[i]-req[i];
                        c++;
                      }
                   }     
      if(c==res)
       { 
                       for(i=1;i<=nop;i++)
                          {   
                             fin[i]=false;
                           }
                                
                       System.out.println("\nProcess  allocated      need   available  \n  ");
         
           c=0;n=0;o=0;
            while(true)
             {
                 for(i=1;i<=nop;i++)
                    {  
                       if(fin[i]==false)
                         {
                             for(j=1;j<=res;j++)
                               {
                                   if(need[i][j]<=avl1[j])
                                       c++;
                               }
                             if(c==res)
                              {    
                                         System.out.print("P"+i+"         ");
                                         for(j=1;j<=res;j++)
                                            {
                                               System.out.print(all[i][j]+" ");
                                            }
                                          System.out.print("\t");
                                         for(j=1;j<=res;j++)
                                            {
                                               System.out.print(need[i][j]+" ");
                                            }
               
                                          
                                  System.out.print("\t");
                                   for(j=1;j<=res;j++)
                                      {    System.out.print(avl1[j]+" ");                                            
                                           avl1[j]=avl1[j]+all[i][j];
                                       }
                                  System.out.print("\n");
                                   
                                  fin[i]=true;
                                  if(fin[i]==true)
                                     n++;    
                               }
                               
                           }        
                            c=0;
                       }
                    o++;
                  if(n==nop)
                     break;
                  if(o>10)
                     break;
                }
           
                if(n==nop)
                    System.out.print(" the  system is in safe state and request is granted ");
                else
                    System.out.print(" the system is in unsafe state after the granting request ");
             }
           else
             System.out.print(" the currently available is not sufficient for new request ");
                 
          

  }
}



         