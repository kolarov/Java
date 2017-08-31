package algorithms.dataStructures;

import java.util.Scanner;

public class BagClient 
{

	public static void main(String[] args) 
	{
		
		BagLinkedList<Double> bagOfNumbers = new BagLinkedList<>();
		
		Scanner sc = new Scanner(System.in); //Get input from the from System.in
		while (sc.hasNext())
		{
			bagOfNumbers.add(Double.parseDouble(sc.next()));
		}
		int N = bagOfNumbers.size();
		double sum = 0.0;
		for (double x : bagOfNumbers)
			sum += x;
		double mean = sum/N;
		sum = 0.0;
		for (double x : bagOfNumbers)
			sum += (x - mean)*(x - mean);
		double std = Math.sqrt(sum/(N-1));
		System.out.println("Mean: %.2f\n" + mean);
		System.out.println("Std dev: %.2f\n" + std);
	}

}
