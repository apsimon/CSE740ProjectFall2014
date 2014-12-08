import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

	/** Simple java program that will output .query files for
	 *  use in Pegasus random walk with restart algorithm.
	 * @param args
	 * @author Alexander Simon
	 */
	public static void main(String[] args) {
		/* This array list holds the number of nodes for each of the  
		 * years 2001-2010. Ex: 2001 has 6425 nodes, 2002 has 5673 nodes etc */
		ArrayList<Integer> numberOfNodes = new ArrayList<Integer>();
		numberOfNodes.add(6425);
		numberOfNodes.add(5673);
		numberOfNodes.add(4851);
		numberOfNodes.add(5946);
		numberOfNodes.add(7089);
		numberOfNodes.add(7193);
		numberOfNodes.add(7739);
		numberOfNodes.add(6037);
		numberOfNodes.add(6560);
		numberOfNodes.add(6342);
		int count = 1; 
		for(int i: numberOfNodes){
			try {
				String concat = "";
				if(count < 10){
					concat = "0" + count;
				}else{
					concat = Integer.toString(count);
				}
				String fileName = "investments20" + concat + ".query";
				File f = new File(fileName);
				FileWriter fw = new FileWriter(f);
				for(int j = 0; j < i; j++){
					fw.append("" + j + "");
					fw.append("\t");
					fw.append("1");
					fw.append("\n");
				}
				fw.flush();
				fw.close();
				count++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

