/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Muhammad Wahab
 */
public class PigenholePrinciple {
    
    private int NumberOfpeople;
    Random random=new Random();
    int[] birthDates;
     static int succes=0,trails=0;
    public ArrayList Decisive;
    private boolean isSame;

    public PigenholePrinciple() {
        
       Decisive=new ArrayList();  
    }
    public int[] getBirthDays(int NumberOfpeople)
    {
        this.NumberOfpeople=NumberOfpeople;
        birthDates=new int[this.NumberOfpeople];
       
        for(int i=0;i<this.NumberOfpeople;i++)
        {
        birthDates[i]=random.nextInt(365);
        }
        return birthDates;
    
    }
    
    public int[] sortedBithDates()
    {
        Arrays.sort(birthDates);
        return birthDates;
    }
    double simulate()
    {
    
   
			ArrayList array=new ArrayList();
			
			for(int j=0;j<birthDates.length;j++)
			{
				int value=random.nextInt(365);
				Object object=String.valueOf(value);
				boolean find=array.contains(object);
				if(!find)
				{
					birthDates[j]=value;
                                        
					array.add(String.valueOf(value));
				}
				else if(j==0 && find!=true)
				{
					birthDates[j]=value;
					array.add(object);
                                        
					array.add(String.valueOf(value));
					
				}
				else
				{
					succes++;
                                       
                                        isSame=true;
					break;
				}
			}
                        trails++;
                    
		double probability=(double)succes/trails;
                
                if(isSame)
                {
                    result("Yes");
                    isSame=false;
                }
                else
                {
                    result("No");
                }
                
                        
			
			
		return probability;
    }
    
    ArrayList getResult()
   {
       
        return  Decisive;
   
   }
     void result(String Decision)
   {
        Decisive.add(Decision);
       
   
   }
    
       public static double simulate(int NumberOfPeople)
    {
       
        Random random=new Random();
        int suc=0;
    
  int[] birth=new int[NumberOfPeople];   
			ArrayList array=new ArrayList();
			
			for(int i = 0; i <trails; i++)
                        {
                            for(int j=0;j<birth.length;j++)
			{
				int value=random.nextInt(365);
				Object object=String.valueOf(value);
				boolean find=array.contains(object);
				if(!find)
				{
					birth[j]=value;
                                        
					array.add(String.valueOf(value));
				}
				else if(j==0 && find!=true)
				{
					birth[j]=value;
					array.add(object);
                                        
					array.add(String.valueOf(value));
					
				}
				else
				{
					suc++;
                                       
                                       
					break;
				}
			}
                            
                            
             
            }
                        
        		
		return (double)suc/trails;
    }
       
       static double average(double[] prob)
       {
           double aver=0;
           
           for(int i=0;i<prob.length;i++)
           {
           
           aver+=prob[i];
           }
           return aver/prob.length;
       
       
       }
    static double sample(int numberOfPeople)
    {
    
    
		Random random=new Random();
		System.out.println("Enter People to enter room");
		int size=numberOfPeople;
		System.out.println("Enter Simulation");
		int count=trails;
		 int birthDay[];
		 int Success = 0;
		 
		 
			birthDay=new int[size];
		
		//Arrays.fill(birthDay, 0);
		for(int i=0;i<count;i++)   // simulation
		{
			ArrayList array=new ArrayList();
			
			for(int j=0;j<birthDay.length;j++)
			{
				int value=random.nextInt(365);
				Object object=String.valueOf(value);
				boolean find=array.contains(object);
				if(!find)
				{
					birthDay[j]=value;
					array.add(String.valueOf(value));
				}
				else if(j==0 && find!=true)
				{
					birthDay[j]=value;
					array.add(object);
					array.add(String.valueOf(value));
					
				}
				else
				{
					Success++;
					break;
				}
				
				
				
			}
			
			
		}
		
		double sim=count;
		double probability=(Success/sim);
		
		System.out.println("Success is "+Success);
		System.out.println("Probability is is "+probability+"%");
        return probability;

    
    }
    
      public static String[] StringNumber()
    {
    String num[]=new String[366];
    for(int i=0;i<=365;i++)
    {
    
        try {
             num[i]=""+i;
        } catch (Exception e) {
            System.out.println("Exception in string"+e);
        }
    }
    return num;
    }
     
    
}
