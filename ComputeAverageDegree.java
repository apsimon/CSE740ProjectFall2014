package org.independentStudy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ComputeAverageDegree {
	public static void main(String[] args) {
		int year = 2001;
		while(year <= 2010){
			File f2 = new File("/home/hduser/RWRResults/inv_"+ year +"/results/deg/inout/dd_node_deg/part-00000");
			try {
				Scanner in = new Scanner(f2);
				int count = 0;
				int sum = 0;
				/* Read in all */
				while(in.hasNext()){
					String line = in.nextLine();
					String[] parts = line.split("\t");
					count++;
					sum += Integer.parseInt(parts[1]);
				}
				System.out.println(year +": "+ (sum / count));
				in.close();		
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			year++;
		}
	}
}
