/* package codechef; // don't place package name! */

import java.util.*;
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner s = new Scanner(System.in);
		int T  = s.nextInt();
		
		while(true){
		    int n = s.nextInt();
		    int x = s.nextInt();
		    int y = s.nextInt();
		    int a = s.nextInt();
		    int b = s.nextInt();
		    
		    double petrolCost = x * (n/a);
		    double diselCost = x * (n/b);
		    
		    if(petrolCost < diselCost)
		        System.out.println("Petrol");
		    else if(petrolCost > diselCost)
		        System.out.println("Disel");
		    else
		        System.out.println("Any");
		}
	}
}
