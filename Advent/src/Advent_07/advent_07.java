package Advent_07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The idea for this program is that you will take the data from the sheet,
 * and make an Arraylist of the nodes. Then, start with the top of the tower,
 * And continuously run through the list and continually cross out nodes that you
 * know are not correct.
 * @author Zachary R. Jones
 *
 */
public class advent_07 {
	
	public static void main(String args[]) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("src/advent_07/input7.txt"));
		ArrayList<Node> nodes = new ArrayList<Node>();
		ArrayList<Node> temp = new ArrayList<Node>();
		ArrayList<Node> above = new ArrayList<Node>();
		
		//Now we need to read the file and build each of the nodes
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] parts = line.split(" ");
			// [0] = name
			// [1] = weight
			// optional
			// [2] = ->
			// [3,...,inf] = above
			
			//We already know the name, but we need to find the ones above
			//2 cases
			
			//Nothing holding
			Node newNode;
			
			if(parts.length == 2) {
				newNode = new Node(parts[0], Integer.parseInt(parts[1].substring(1, parts[1].length() - 1)));
				//System.out.println(newNode);
			} else {
				ArrayList<Node> holding = new ArrayList<Node>();
				//need to know how many are left
				for(int i = 3; i < parts.length; i++) {
					if(i == (parts.length - 1)) {
						holding.add(new Node(parts[i].substring(0,  parts[i].length()), 0));
					} else {
						holding.add(new Node(parts[i].substring(0, parts[i].length() - 1), 0));
					}
				}
				
				newNode = new Node(parts[0], holding, Integer.parseInt(parts[1].substring(1, parts[1].length() - 1)));
				
			}
			
			nodes.add(newNode);
		}
		//System.out.println("-------------");
		
		//Now, all of the nodes should be created and ready to work with
		//So lets get started running through the nodes list
		
		//First, we need to get every node that doesn't have a holding
		//This means that they are on top
		
		
		//Go through every node
		//The temp list are all of the ones that don't have nodes on top
		for(Node n : nodes) {
			if(!(n.getHolding() == null)) {
				temp.add(n);
			} else {
				above.add(n);
			}
			
		}
		
		nodes = new ArrayList<Node>();
		
		//So this part worked from what I can see
		for(Node n : temp) {
			nodes.add(n);
		}
		
		
		//currently in above
		//for(Node n : above) {
		//	System.out.println(n);
		//}
		int tempSize1 = nodes.size();
		int tempSize2 = 0;
		int switch1 = 0;
		ArrayList<Node> newList = new ArrayList<Node>();
		int o = 1;
		while(tempSize1 != tempSize2) {
			System.out.println("Home");
			temp = new ArrayList<Node>();
		
			//Ok, so we have this new list, where everything has a holding, so we need to check the holdings
			//And cross check with our list and cross some off.
			for(Node n : nodes) {
				System.out.println(n);
				boolean exists = false;
				int stuffAbove = 0;
					for(Node l : above) {
						if(l.equals(n.getName())) {
							exists = true;
							stuffAbove += l.getHoldingWeight();
						}
					}
			
					if(!exists) {
						temp.add(n);
					} else {
						above.add(n);
					}
			}
			//Now we have this temp list of the next tier of the tower
			//So, I'm going to calculate the
			int[] holdingCheck = new int[nodes.size()];
			for(int i = 0; i < nodes.size(); i++) {
				int temp1 = 0;
				temp1 += nodes.get(i).getWeight();
				//System.out.println("We are on node: " + nodes.get(i).getName());
				for(Node n : nodes.get(i).getHolding()) {
					//Need to find the one above that has the same string
					for(Node m : above) {
						if(m.getName().equals(n.getName())) {
							//System.out.println(m.getName());
							temp1 += m.getWeight();
						}
					}
					temp1 += n.getWeight();
				}
				holdingCheck[i] = temp1;
			}
			//Now the weight array is filled and we can work to see if any of them are different
			for(int i = 0; i < holdingCheck.length; i++) {
				System.out.println(holdingCheck[i]);
			}
			
			//New array
			for(Node n : nodes) {
				
				boolean getRidOf = false;
				//Need to see if any of them have the name
				for(Node m : temp) {
					if(!m.getName().equals(n.getName())) {
						for(Node h : n.getHolding()) {
							if(h.getName().equals(m.getName()) ) {
								getRidOf = true;
							}
						}
					}
				}
				if(!getRidOf) {
					if(!newList.contains(n) && n.getHolding().size() == o) {
						newList.add(n);
					}
				}
			} //end of for loop
			
			
			if(switch1 == 0) {
				tempSize2 = newList.size();
				switch1 = 1;
			} else {
				tempSize1 = newList.size();
				switch1 = 0;
			}
			o++;
		} //End of While
		
		//Need to get rid of the one that holds the other ones
		for(Node n : temp) {
			nodes.add(n);
			System.out.println(n);
		}
		
		
		
		System.out.println("----------------");
		for(Node g : newList) {
			int temp1 = 0;
			
			for(int i = 0; i < newList.size(); i++) {
				temp1 = 0;
				temp1 += newList.get(i).getWeight();
				//System.out.println("We are on node: " + nodes.get(i).getName());
				for(Node n : newList.get(i).getHolding()) {
					//Need to find the one above that has the same string
					for(Node m : above) {
						if(m.getName().equals(n.getName())) {
							//System.out.println(m.getName());
							System.out.println(m.getWeight());
							temp1 += m.getWeight();
						}
					}
					//temp1 += n.getWeight();
				}
				System.out.println("home" + temp1);
			}
			for(int p = 0; p < g.getHolding().size(); p++) {
				System.out.print(" ");
			}
				System.out.print(temp1 + ": ");
				System.out.println(g);
		}
	}

}
