package Advent_07;

import java.util.ArrayList;

public class Node {
	
	//name of Node
	String name;
	//weight of the node
	int weight;
	//weight that is being held
	int holdingWeight;
	//Nodes above
	ArrayList<Node> holding;
	
	//Default Constructor
	public Node() {
		name = "";
		holding = null;
		weight = 0;
		holdingWeight = 0;
	}
	
	//Specialized Constructor
	public Node(String name, ArrayList<Node> holding, int weight) {
		this.name = name;
		this.holding = holding;
		this.weight = weight;
		//We need to calculate the holding weight here from the ones that this node
		//is holding up
		int temp = 0;
		for(Node n : holding) {
			temp += n.getWeight();
		}
		this.holdingWeight = temp;
	}
	
	//Specialized Constructor (no nodes holding)
	public Node(String name, int weight) {
		this.name = name;
		this.holding = null;
		this.weight = weight;
	}
	
	//Getters(Accessors)
	public String getName() {
		return name;
	}
	
	public ArrayList<Node> getHolding() {
		return holding;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getHoldingWeight() {
		return holdingWeight;
	}
	
	//Setters(Mutators)
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHolding(ArrayList<Node> holding) {
		this.holding = holding;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void setHoldingWeight(int holdingWeight) {
		this.holdingWeight = holdingWeight;
	}
	
	//Methods for Nodes
	public boolean checkHolding() {
		return true;
	}
	
	public String toString() {
		return (name + ": " + weight + ": " + holding);
	}

}
