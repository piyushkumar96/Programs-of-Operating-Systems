import java.util.Scanner;
import java.util.StringTokenizer;
class DemandPagingOptimal
{
   public static void main(String args[])
    {
      Scanner sc=new Scanner(System.in); 
      System.out.println("enter the spaced reference string");
      String str=sc.nextLine();
      StringTokenizer st=new StringTokenizer(str," ");
      int np=st.countTokens();
      int page[]=new int[np+1];
      int i=0;
      while(st.hasMoreTokens())
       {
         i++;
         page[i]=Integer.parseInt(st.nextToken());
       }
      System.out.println("enter the no. of frames");
      int nf=sc.nextInt();
      sc.nextLine();

      int frames[]=new int[nf+1];
      for(i=1;i<=nf;i++)
         frames[i]=-1;
      System.out.println("page-no.      frames       page-fault");
      int count=0,max,temp=0,l=0;
      for(i=1;i<=np;i++)
        {
          boolean f=false;
          for(int j=1;j<=nf;j++)
            {
              if(frames[j]==-1)
                {
                  f=true;
                  l=j;
                  break;
                }
            }
           System.out.println();
           System.out.print("   "+page[i]+"           ");
           boolean flag=false;
           for(int j=1;j<=nf;j++)
             {
               if(page[i]==frames[j])
                  flag=true;
             }
           if(f==true)
             {
               count++;
               frames[l]=page[i];
               for(int j=1;j<=nf;j++)
                 {
                   if(frames[j]==-1)
                      System.out.print(" ");
                   else
                      System.out.print(frames[j]);
                 }
                System.out.print("           "+count);
             }
            else if(flag==true)
             {
               for(int j=1;j<=nf;j++)
                 {
                    if(frames[j]==-1)
                       System.out.print(" ");
                    else
                       System.out.print(frames[j]);
                 }
                System.out.print("           "+count);
              }
             else
              {
                max=-1;
                count++;
                for(int j=1;j<=nf;j++)
                  {
                     int k;
                     for(k=i+1;k<=np;k++)
                       {
                         if((frames[j]==page[k])&&(k>max))
                           {
                              max=k;
                              temp=j;
                           }
                        }
                       if(k>np)
                         {
                           temp=j;
                            break;
                         }
                    }
                 frames[temp]=page[i];
                 for(int j=1;j<=nf;j++)
                   {
                     if(frames[j]==-1)
                        System.out.print(" ");
                     else
                        System.out.print(frames[j]);
                   }
                 System.out.print("           "+count);
                }
            }
    }
}