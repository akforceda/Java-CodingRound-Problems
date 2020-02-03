package collections;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DuplicateNumberFromArray {

	public static void main(String[] args) {
		long a = System.nanoTime();					//capturing time to check efficiency(start time of code in nanoseconds)
		
		Random rd = new Random();					//generating a random array
		
		int array[] = new int[1000];				//declaring a static size
		
		for (int i = 0; i < array.length; i++) {	//storing generated values to array
			array[i] = rd.nextInt(1000);
		}
		
		Set<Integer> s1 = new HashSet<Integer>();	//creating set rather than for inside another for
		Set<Integer> s2 = new HashSet<Integer>();	//to avoid O(n^2) complexity
		
		for (int i = 0; i < array.length; i++) {	//iterating over the array
			if(s1.add(array[i])) {					//if number is newly entered set returns true else false
				continue;
			}else {
				s2.add(array[i]);					//all the duplicate numbers are captured
			}
		}
		
		System.out.println("************************************************");
		
		for(Integer integer : s2) {					//displaying the duplicate number list
			System.out.println(integer);
		}
		
		System.out.println("***********************************************");
		
		System.out.println("array size= "+array.length);	
		System.out.println("list Size= "+s2.size());

		long b = System.nanoTime();					//capturing time to check efficiency(end time of code in nanoseconds)
		
		System.out.println(b-a);					//difference to compare the efficiency against the O(n^2) complexity approach
		
	}

}
