package org.independentStudy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class NumberOfSingleNodeNeighborhoods {
	
	public static void main(String[] args) {
		int year = 2001;
		while(year <= 2010){
			File f2 = new File("/home/hduser/RWRResults/inv_"+ year +"/results/rwr/rwr_distr/part-00000");
			try {
				Scanner in = new Scanner(f2);
				int num_of_one_node_neighborhoods = 0;
				/* Read in all */
				while(in.hasNext()){
					String line = in.nextLine();
					String[] parts = line.split("\t");
					double neighborhood_size = Double.parseDouble(parts[1]);
					if(neighborhood_size == 1){
						num_of_one_node_neighborhoods++;
					}
				}
				System.out.println(num_of_one_node_neighborhoods);
				in.close();		
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			year++;
		}
	}
}
