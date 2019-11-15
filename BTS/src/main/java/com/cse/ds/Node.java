package com.cse.ds;

/**
 * Node
 *
 * @author Yueqi Liao
 * 
 * @Login cs12sp19iv
 * 
 * @date May 25, 2019
 * 
 * @email yliao@ucsd.edu
 */
public class Node {
    //FIELD
	String city;
    int population;
    
    Node left;
    Node right;
    
    /**
     * Node
     * 
     * constructor
     */
    public Node() {
		
	}
    
    /**
     * Node
     * 
     * @param city
     * @param population
     * 
     * constructor
     */
    public Node(String city, int population) {
		this.city = city;
		this.population = population;
	}
    
    /**
     * setLeftt
     * 
     * @param left
     * 
     * set the left Node
     */
    public void setLeft(Node left) { this.left = left; }
    
    /**
     * setRight
     * 
     * @param right
     * 
     * set the right Node
     */
    public void setRight(Node right) { this.right = right; }
    
    /**
     * getPopulation
     * 
     * @return int population
     */
    public int getPopulation() { return this.population; }
   
    /**
     * getCity
     * 
     * @return String city
     */
    public String getCity() { return this.city; }
    
}