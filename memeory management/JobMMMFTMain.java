import java.util.Scanner;
class JobMMMFT
{ 
   private String str;
   private int jobsize, tminqu,tmin,interfrag,timer[] =new int[10];
   private static int fixsize[]= { 0,9500,7000,4500,8500,9000,1000,5500,1500,500};
   boolean blockstatus , jobstatus;
   

public static Scanner sc =new Scanner(System.in);
JobMMMFT[] obj = new JobMMMFT[20]; 

public void input(int n)
  {   
     
      for(int i=1;i<=n;i++)
        {   
	   obj[i] = new JobMMMFT();
                    sc.nextLine();
    	   System.out.print(" enter job id ");
   	   obj[i].str=sc.nextLine(); 

	   System.out.print(" enter jobsize  ");
     	   obj[i].jobsize=sc.nextInt();
                     System.out.print(" enter time for which it remain in ready queue ");
       	   obj[i].tminqu=obj[i].tmin=sc.nextInt();

	}

}

public void calTiqFragMemUtil(int n)
  { 
      int k,nop=0,min;    
     while(true)
       {  
         for(int j=1;j<=n;j++)
        { 
           if(obj[i].jobstatus==true)
                 obj[j].tmin--;
          for(int i=1;i<=n;i++)
            {
               if(obj[i].jobstatus==true)
                 obj[j].tmin--;
                if(obj[j].jobsize<=fixsize[i]&&obj[i].blockstatus==false&&obj[j].jobstatus==false)
                   {
                        obj[j].interfrag=fixsize[i]-obj[j].jobsize;
                        System.out.println(" internal frag  "+obj[j].interfrag);
                        obj[i].blockstatus=true;
                        obj[i].jobstatus=true;
                         nop++;
                          obj[j].tmin--;
                        break;
                    }
             
               for(k=1;k<=n;k++)
                {
                  if(obj[k].tmin<0&&obj[k].jobstatus==true) 
                              obj[k].blockstatus=false;                       
                }   
              
            }
       
      }
     if(nop==n)
       break;
   }
  }
public void display(int n)
   {   int suminterfrag=0;
       System.out.println("  ID  TMINQU  JOBSIZE   FIXSIZE   INTERFRAG    ");
		for(int i=1;i<=n;i++)
		   {    System.out.print("\n   "+obj[i].str);
                        System.out.print("   "+obj[i].tminqu);
                        System.out.print("       "+obj[i].jobsize);
                        System.out.print("      "+fixsize[i]);
			System.out.print("        "+obj[i].interfrag);
                    suminterfrag=suminterfrag+obj[i].interfrag;
		   }
      System.out.println(" \n the total interfragmentation  "+(suminterfrag));
      System.out.println(" the memory utilization  "+((50000-suminterfrag)*100)/50000);
    }  

}
  public class JobMMMFTMain
     {
        public static void main(String arg[])
         {
  		 Scanner in = new Scanner(System.in);
   		 JobMMMFT obj1 = new JobMMMFT();
		 int n=0;
              while(true)
                {   
                    System.out.print(" \n\n Enter the choice\n 1.Input \n 2.calTiqFragMemUtil \n 3.Display \n 4.Exit \n");
  		    int ch =in.nextInt();
                    switch(ch)
                      {
                           case 1: System.out.print(" Enter the no. OF PROCESS  (must be > 1)");
  		                   n=in.nextInt();
                                   obj1.input(n);break;
	       	           case 2: obj1.calTiqFragMemUtil(n) ;break;
	       	           case 3:  obj1.display(n);break;
                                              case 4: System.exit(0);
	       	           default: System.out.print(" \n Entered wrong choice \n ");break;
                      }
                 }
          }
     }