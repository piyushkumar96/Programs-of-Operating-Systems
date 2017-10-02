import java.util.Scanner;
class MMLogAddTOPhyAddUsingPaging
  {
    int pn;
    int fno;
  }

class MMLogAddTOPhyAddUsingPagingMain
 {
   public static void main (String arg[])
     {  
         Scanner sc = new Scanner(System.in);
        
       int psize,i,totPages,pno,offset,sof,rand,arr[]= new int[100],phy_add=0;
       arr[0]=0;
      
       MMLogAddTOPhyAddUsingPaging mm[] = new MMLogAddTOPhyAddUsingPaging[200];
      
       System.out.println(" Logical Address To Physical Address\n");
       System.out.print("Enter  the Size of File ");
       sof=sc.nextInt();
       System.out.println("Enter the Page Size ");
       psize=sc.nextInt();
       totPages=sof/psize;
       for(i=0;i<totPages;i++)
       {
              rand=(int)(Math.random()*totPages);
              int  j=(int)(Math.random()*102);
              if(arr[rand] == 1)
              {
                  i--;
                  continue;
              }
              arr[rand]=1;
              mm[i] = new MMLogAddTOPhyAddUsingPaging();
              mm[i].pn=rand;
              mm[i].fno=j;
       }

       System.out.println("The Structure of Main Memory after pages are alloted to frames \n");
       System.out.println("Frame\tPage\nNumber\tNumber\n");
       for(i=0; i < totPages; i++)
       {
              System.out.println(mm[i].fno+"\t"+mm[i].pn+"\n");
       }
 
       System.out.println("Enter The Logical Address\nPage Number : ");
       pno=sc.nextInt();
       System.out.println("Offset : ");
       offset=sc.nextInt();
       
      if(pno >= totPages || offset > psize)
       {
          System.out.println("Invalid Input\n");
       }
      else 
       { 
           for(i=0;i<totPages;i++)
           { 
                 if(mm[i].pn==pno)
                   {
                      phy_add = mm[i].fno*psize + offset;
                       break;
                    }    
             }         
       
          System.out.println("Physical Address :"+phy_add);
          
          int count=0;
          String phy_addfrmno ="";
          while(phy_add>0)
            {   
                phy_addfrmno= phy_addfrmno.concat(""+phy_add%2);
                phy_add=phy_add/2;
                count++;
                if(phy_add==0)
                 {   
                    StringBuffer buffer = new StringBuffer(phy_addfrmno);
                    phy_addfrmno= ""+buffer.reverse();
                  
                    for(i=0;i<30-count-psize;i++)
                        phy_addfrmno="0".concat(phy_addfrmno);
                  }
             } 
         
          String phy_addoffset ="";  count=0 ;
          while(offset>0)
            {   
                phy_addoffset= phy_addoffset.concat(""+offset%2);
                offset=offset/2;
                count++;
                if(offset==0)
                    {  
                        StringBuffer buffer = new StringBuffer(phy_addoffset);
                        phy_addoffset= ""+buffer.reverse();
                        for(i=0;i<psize-count;i++)
                        phy_addoffset="0".concat(phy_addoffset);
                    }
             }

             System.out.println("\n\n_________________________________");  
             System.out.println("|"+phy_addfrmno.concat("|"+phy_addoffset)+"|"); 
             System.out.println("_________________________________");  
          }
   }
}