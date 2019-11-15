package com.cse.ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.io.*;

/**
 * BinarySearchTree
 * 
 * @author Yueqi Liao
 * 
 * @Login cs12sp19iv
 * 
 * @date May25, 2019
 * 
 * @email yliao@ucsd.edu
 *
 */
public class BinarySearchTree {
	
	//FIELD
	public Node root;
	List<String> list = new ArrayList<String>();
	List<List<String>> list2 = new ArrayList<List<String>>();
	int tilt;
	String str = "";
	
	//============== BALANCED TREE CREATION ====================//
	/**
	 * BinarySearchTree
	 * 
	 * @param cities
	 * @param population
	 * 
	 * constructor
	 */
	public BinarySearchTree(String[] cities, int[] population) {
		
		if (cities== null || population == null)
			this.root = null;
		
		else if (cities.length == 0 || population.length == 0) {
			root = null;
		}
		else if (cities.length != population.length) {
			throw new IllegalArgumentException("Cities and population must correspond!");
		}
		else {
		int start = 0;
		int end = cities.length - 1;
		root = createBST(cities, population, start, end);
		}
		
		//TODO: Create a balanced BST by starting at mid node and creating tree recursively.
		//Use trim on cities names before adding
	}
	
	/**
	 * createBST
	 * 
	 * @param cArr
	 * @param pArr
	 * @param start
	 * @param end
	 * 
	 * helper method to recursively construct a BST
	 * 
	 * @return Node root
	 */
	public Node createBST(String[]cArr, int[]pArr, int start, int end) {
		
		if(start > end) //terminate condition
			return null;
		
		//define mid
		int mid = (start + end)/2;
		Node root = new Node(cArr[mid].trim(), pArr[mid]);
		//recursively construct Node root
		root.setLeft(createBST(cArr, pArr, start, mid-1));
		root.setRight(createBST(cArr, pArr, mid+1, end));
		
		return root;
	}
	
	/**
	 * BinarySearchTree
	 * 
	 * @param filename
	 * @param num_lines
	 * 
	 * constructor
	 */
	public BinarySearchTree(String filename, int num_lines) {
		
		//exceptions handling
		if (filename == null || num_lines <= 0) {
			this.root = null;
			return;
		}
		
		//define local variables
		FileInputStream file = null;
		BufferedReader reader = null;
		String[] cities = new String[num_lines];
		int[] population = new int[num_lines];
						
		
		try {
			file = new FileInputStream(filename);
			reader = new BufferedReader(new InputStreamReader(file));
			 
			int index = 0;
			
			//while loop to read every line of file
			while (index<num_lines) {
				
				String line = reader.readLine();
				//add elements to the arrrays
				String[] temp = line.split("=>");//trim the line
				cities[index] = temp[0].trim();
				population[index] = Integer.parseInt(temp[1].trim());
				//index increment
				index++;
			}
			
		} catch (FileNotFoundException e) {
			
			
		} catch (IOException e) {
			
			
		} finally {
			
			try {
				reader.close();
				file.close();
				
			} catch (IOException ex) {
				
			}
		}
		
		//reverse the arrays to the increasing order
		cities = reverse(cities);
		population = reverse(population);
		
		//create the root node of the BST
		int start = 0;
		int end = cities.length - 1;
		root = createBST(cities, population, start, end);
		//TODO: Create a balanced BST from the input.txt
		//Use trim on cities names before adding
	}
	
	/**
	 * reverse
	 * 
	 * @param a
	 * 
	 * helper method to reverse an int array
	 * 
	 * @return int[] a
	 */
	private int[] reverse(int[] a) {
		
		int n = a.length;
        for (int i = 0; i < n / 2; i++) { 
            int t = a[i]; 
            a[i] = a[n - i - 1]; 
            a[n - i - 1] = t; 
        } 
        
        return a;
	}

	/**
	 * reverse
	 * 
	 * @param <E>
	 * @param a
	 * 
	 * helper method to reverse an array
	 * 
	 * @return E[] a
	 */
	private <E> E[] reverse (E[] a) {

		int n = a.length;
        for (int i = 0; i < n / 2; i++) { 
            E t = a[i]; 
            a[i] = a[n - i - 1]; 
            a[n - i - 1] = t; 
        } 
        
        return a;
	}
	
	//============== COMMON TREE OPERATIONS ====================//
	/**
	 * addCity
	 * 
	 * @param city
	 * @param population
	 * 
	 * add Nodes to the BST
	 */
	public void addCity(String city, int population) {
		
		if (city == null) 
			throw new IllegalArgumentException("CANNOT BE NULL");//exceptions handling
		
		root = insert(root, city, population);
	}

	/**
	 * insert
	 * 
	 * @param root
	 * @param city
	 * @param population
	 * 
	 * helper method to recursively add nodes to the tree
	 * 
	 * @return Node root
	 */
	public Node insert(Node root, String city, int population) { 
		  
		// If the tree is empty, return a new node
		//terminate condition
	    if (root == null) { 
	        root = new Node(city, population); 
	        return root; 
	    } 
	  
	    // Otherwise, recur down the tree 
	    if (population < root.getPopulation()) 
	        root.left = insert(root.left, city, population); 
	    else if (population > root.getPopulation()) 
	        root.right = insert(root.right, city, population); 
	  
	    // return the (unchanged) node pointer
	    return root;

	}
	/**
	 * getMaxDepth
	 * 
	 * get the max depth of the tree
	 * 
	 * @return
	 */
	public int getMaxDepth() {
		
		return maxDepth(this.root);
	}
	
	/**
	 * maxDepth
	 * 
	 * @param node
	 * 
	 * helper method to recursively find the depths of left and right subtrees,
	 * and return the max of them
	 * 
	 * @return int depth
	 */
	private int maxDepth(Node node) {
		
		//return 0 is the (sub)tree is empty
		if (node == null)
			return 0;
		
		else {
			
			//recursively find the depths of left and right subtrees
			int leftDepth = maxDepth(node.left);
			int rightDepth = maxDepth(node.right);
			
			//compare and return the max of them
			if (leftDepth > rightDepth)
				return leftDepth+1;
			else 
				return rightDepth+1;
		}
	}

	/**
	 * getMaxWidth
	 * 
	 * getter of the width of the tree
	 * 
	 * @return int width
	 */
	public int getMaxWidth() {
		
		//create an inner class to store the horizontal distance of nodes
		class QueueObj {
			
			Node node;
			int distance;
			
			QueueObj(Node node, int distance) {
				this.node = node;
				this.distance = distance;
			}
		}
		
		//initialize queue and map objects 
		Queue<QueueObj> q = new Queue<QueueObj>();
		Map<Integer, Node> map = new TreeMap<Integer, Node>();
		
		//edge case handling
		if (this.root == null)
			return 0;
		else
			q.enqueue(new QueueObj(this.root, 0));
		
		while (!q.isEmpty()) {
			QueueObj tmpNode = q.dequeue();
			map.put(tmpNode.distance, tmpNode.node);
			
			//keeping updating the distances occurred 
			if (tmpNode.node.left != null)
				q.enqueue(new QueueObj(tmpNode.node.left, tmpNode.distance-1));
				
			if (tmpNode.node.right != null)
				q.enqueue(new QueueObj(tmpNode.node.right, tmpNode.distance+1));
			
		}
		
		//initialize max and min values
		int maxDis = Integer.MIN_VALUE;
		int minDis = Integer.MAX_VALUE;
		
		//get the max and min distances from the map because the 
		//distances are stored as keys
		for(Entry<Integer, Node> entry : map.entrySet()) {
			
			if (entry.getKey() < minDis)
				minDis = entry.getKey();
			
			if (entry.getKey() > maxDis)
				maxDis = entry.getKey();
		}
		
		return maxDis - minDis;
	}
	
	/**
	 * getSmallestCity
	 * 
	 * @return String smallest city name
	 */
	public String getSmallestCity() {
		
		//return null is tree is empty
		if (this.root == null)
			return null;
		
		return findSmallest(this.root);
	}
	
	/**
	 * findSmallest
	 * 
	 * @param node
	 * 
	 * helper method to recursively find the smallest
	 * 
	 * @return String smallest city
	 */
	private String findSmallest(Node node) {
		
		if (node.left == null)
			return node.getCity();
		
		return findSmallest(node.left);
	}
	
	/**
	 * getLargestCity
	 * 
	 * @return String largest city
	 */
	public String getLargestCity() {
		
		//return null if tree is empty
		if (this.root == null)
			return null;
		
		return findLargest(this.root);
	}
	
	/**
	 * findLargest
	 * 
	 * @param node
	 * 
	 * helper method to recursively find the largest city
	 * 
	 * @return String largest city
	 */
	private String findLargest(Node node) {
		
		if (node.right == null)
			return node.getCity();
		
		return findLargest(node.right);
	}

	//============== TREE TRAVERSALS ====================//
	
	/**
	 * getPreOrderTraversal
	 * 
	 * Returns a list of city names in the order of a pre-order traversal 
	 * on the current binary search tree.
	 * 
	 * @return List<String> list
	 */
	public List<String> getPreOrderTraversal() {
		
		this.list = new ArrayList<String>();
		preTraversal(this.root);
		return this.list;
	}
	
	/**
	 * preTraversal
	 * 
	 * @param node
	 * 
	 * helper method to recursively traverse BST in preorder
	 */
	private void preTraversal(Node node) {
		
		//terminate condition
		if (node == null)
			return;
		
		list.add(node.getCity());
		preTraversal(node.left);
		preTraversal(node.right);
	}
	
	/**
	 * getPostOrderTraversal
	 * 
	 * Returns a list of city names in the order of a post-order traversal 
	 * on the current binary search tree.
	 * 
	 * @return List<String> list
	 */
	public List<String> getPostOrderTraversal() {
		
		this.list = new ArrayList<String>();
		postTraversal(this.root);
		return this.list;
	}
	
	/**
	 * postTraversal
	 * 
	 * @param node
	 * 
	 * helper method to recursively traverse BST in postorder
	 */
	private void postTraversal(Node node) {
		
		//terminate condition
		if (node == null)
			return;
		
		postTraversal(node.left);
		postTraversal(node.right);
		list.add(node.getCity());
	}

	/**
	 * getSortedCities
	 * 
	 * Returns the list of city names in sorted order. (Ascending)
	 * 
	 * @return List<String> list
	 */
	public List<String> getSortedCities() {

		this.list = new ArrayList<String>();
		InTraversal(this.root);
		return this.list;
	}
	
	/**
	 * InTraversal
	 * 
	 * @param node
	 * 
	 * helper method to recursively traverse BST in inorder
	 */
	private void InTraversal(Node node) {

		//terminate condition
		if (node == null)
			return;
		
		InTraversal(node.left);
		list.add(node.getCity());
		InTraversal(node.right);
	}

	/**
	 * getLevelWiseCities
	 * 
	 * Returns a list of lists. Each list within the list stores all of 
	 * the city names at a specific level of the binary search tree. 
	 * Return list where levels closer to the root appear first.
	 * 
	 * @return List<List<String>> list2
	 */
	public List<List<String>> getLevelWiseCities() {
		
		//initialize list2 everytime when implementing the function
		list2 = new ArrayList<List<String>>();
		//if the tree is empty
		if (this.root == null)
			return list2;
		
		int depth = 1;
		//loop to add temp array to list2
		while(depth <= getMaxDepth()) {
			List<String> temp = new ArrayList<String>();
			getDepthLevel(temp, this.root, depth);
			list2.add(temp);
			depth++;
		}
		
		return list2;
	}

	/**
	 * getDepthLevel
	 * 
	 * @param node
	 * @param depth
	 * 
	 * helper method to recursively store the cities names at the same level
	 */
	private void getDepthLevel(List<String> temp, Node node, int depth) {
		
		//terminate condition
		if (node == null)
			return;
		
		//recursively add elements to the temp array
		if (depth == 1) {
			temp.add(node.getCity());
			return;
		}
		else {
			//recursion
			getDepthLevel(temp, node.left, depth - 1);
			getDepthLevel(temp, node.right, depth - 1);
		}
	}

	/**
	 * getTwistyTraversal
	 * 
	 * Returns the list of lists of cities at each level when 
	 * performing a twisty traversal on the tree.
	 * 
	 * @return List<List<String>> list
	 */
	public List<List<String>> getTwistyTraversal() {
		
		//get a List of getLevelWiseCities
		List<List<String>> tmp = getLevelWiseCities();
		
		int index = 0;
		//loop to change the list where the element list should be twisty
		while (index < tmp.size()) {
			if (index % 2 != 0) {
				List<String> t = tmp.get(index);
				t = reverse(t);
				tmp.set(index, t);
			}
			index++;//index increment
		}
		return tmp;
	}
	
	/**
	 * reverse
	 * 
	 * @param a
	 * 
	 * helper method to reverse a List
	 * 
	 * @return List<String> reversed a
	 */
	private List<String> reverse(List<String> a) {
		
		int n = a.size();
        for (int i = 0; i < n / 2; i++) { 
            String t = a.get(i); 
            a.set(i, a.get(n - i - 1)); 
            a.set(n - i - 1, t); 
        } 
        
        return a;
	}

	//============== TREE VIEWS ====================//
	
	/**
	 * getRightView
	 * 
	 * get a list of city names of the right view of the tree
	 * 
	 * @return List<String> 
	 */
	public List<String> getRightView() {
		
		//lists initialization
		list = new ArrayList<String>();
		List<List<String>> tmp1 = getLevelWiseCities();
		
		//for loop to add elements to list
		for (int i = 0; i < tmp1.size(); i++) {
			List<String> tmp2 = tmp1.get(i);
			list.add(tmp2.get(tmp2.size()-1));
		}
		
		return list;
    }
	
	/**
	 * getLeftView
	 * 
	 * get a list of city names of left view of the tree
	 * 
	 * @return List<String> list
	 */
	public List<String> getLeftView() {		
		
		//lists initialization
		list = new ArrayList<String>();
		List<List<String>> tmp1 = getLevelWiseCities();
				
		//for loop to add elements to list
		for (int i = 0; i < tmp1.size(); i++) {
			List<String> tmp2 = tmp1.get(i);
			list.add(tmp2.get(0));
		}
				
		return list;

    }
	

	/**
	 * getTopView
	 * 
	 * get a list of city names of the top views of the tree
	 * 
	 * @return List<String>
	 */
	public List<String> getTopView() {
		
		list = new ArrayList<String>();
		//initialize an inner class containing the horizontal distance
		class QueueObj {
			//FIELD
			Node node;
			int distance;
			
			QueueObj(Node node, int distance) {
				this.node = node;
				this.distance = distance;
			}		
		}
		
		//initialize a queue to store the the children of the root
		Queue<QueueObj> q = new Queue<QueueObj>();
		//mapping the distance from root with node
		Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>();
		
		//situation when the tree is empty
		if (this.root==null)
			return list;
		else
			q.enqueue(new QueueObj(this.root, 0));
		
		while (!q.isEmpty()) {
			QueueObj tmpNode = q.dequeue();
			
			//unchanged if the map contain the key, add a new one
			//if it does not contain the key
			if(!topViewMap.containsKey(tmpNode.distance)) 
				topViewMap.put(tmpNode.distance, tmpNode.node);
			
			//the order of putting the elements ensures the list is from left to right
			if(tmpNode.node.left != null)
				q.enqueue(new QueueObj(tmpNode.node.left, tmpNode.distance-1));
			
			if(tmpNode.node.right != null)
				q.enqueue(new QueueObj(tmpNode.node.right, tmpNode.distance+1));
			
		}
		
		//add the elements from the entry set of the map to the list
		for (Entry<Integer, Node> entry : topViewMap.entrySet()) {
			list.add(entry.getValue().getCity());
		}
			
        return list;
	}

	/**
	 * getBottomView
	 * 
	 * get a list containing the bottom view of the tree
	 * 
	 * @return List<String> list
	 */
	public List<String> getBottomView() {
		
		list = new ArrayList<String>();
		//create an inner class to store the horizontal distance from the root
		class QueueObj {
			Node node;
			int distance;
			
			QueueObj(Node node, int distance) {
				this.node = node;
				this.distance = distance;
			}		
		}
		
		//initialize a queue and map object
		Queue<QueueObj> q = new Queue<QueueObj>();
		Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>();
		
		if (this.root==null)
			return list;
		else
			q.enqueue(new QueueObj(this.root, 0));
		
		while (!q.isEmpty()) {
			QueueObj tmpNode = q.dequeue();
			
			//keeping updating, replacing the old node if the distance exists,
			//adding new node of the distance does not exist in the map
			topViewMap.put(tmpNode.distance, tmpNode.node);
			
			//the ordering of enqueuing ensures the order in the list is from 
			//left to right
			if(tmpNode.node.left != null)
				q.enqueue(new QueueObj(tmpNode.node.left, tmpNode.distance-1));
			
			if(tmpNode.node.right != null)
				q.enqueue(new QueueObj(tmpNode.node.right, tmpNode.distance+1));
			
		}
		
		//adding the elements from the entry set of the map to the list
		for (Entry<Integer, Node> entry : topViewMap.entrySet()) {
			list.add(entry.getValue().getCity());
		}
	    
        return list;
	}
	
	//============== SPECIAL TREE OPERATIONS ====================//
	/**
	 * getBSTilt
	 * 
	 * get the tilt of the tree
	 * 
	 * @return int tilt
	 */
	public int getBSTilt() {
		
		if (this.root == null)
			return 0;
		
		
		tilt = 0;
		//modify the tilt in the field
		findTilt(this.root);
		return tilt;
	}
	
	/**
	 * findTilt
	 *
	 * @param node
	 * 
	 * helper method to recursively find the tilt
	 * 
	 * @return int
	 */
	public int findTilt(Node node) {
		 
		//terminate condition
		if (node == null)
			return 0;
		
		int left = findTilt(node.left);
		int right = findTilt(node.right);
		//tilt increment of the field
		tilt += Math.abs(left-right);
		
		return left + right + node.getPopulation();
	}
	
	/**
	 * getAllPaths
	 * 
	 * find paths from nodes to the leaf nodes
	 * @return
	 */
	public List<String> getAllPaths() {
		
		//iterate left first and then iterate right
		list = new ArrayList<String>();
		
		//return empty list is the tree is empty
		if (this.root == null)
			return list;
		
		findPaths(list, this.root, "=>");
		
		return list;
	}
	
	/**
	 * findPaths
	 * 
	 * @param list
	 * @param node
	 * @param path
	 * 
	 * helper method to recursively find the paths
	 */
	private void findPaths(List<String> list, Node node, String path) {
		
		if (node == null)
			return;
		
		path += node.getCity();
		
		if (node.left == null && node.right == null) 
			list.add(path);
		else
			path += "=>";
		
		findPaths(list, node.left, path);
		findPaths(list, node.right, path);
	}
	
	/**
	 * toLinkedList
	 * 
	 * @param list
	 * @param root
	 * 
	 * helper method to recursively add nodes to the list in pre-order
	 */
	private void toLinkedList(List<Node> list, Node root) {
		
		if (root == null) 
			return;
		
		list.add(root);
		toLinkedList(list, root.left);
		toLinkedList(list, root.right);
	}
	
	/**
	 * flattenToLL
	 * 
	 * flatten the tree to linked lists in the pre-order
	 * 
	 */
	public void flattenToLL() {
		
		//initialize the tmp lists to store nodes
		List<Node> tmp = new ArrayList<Node>();
		toLinkedList(tmp, this.root);
		this.root = tmp.get(0);
		//initialize a node to iterate through the tree
		Node node = root;
		
		//recursively set the right nodes
		for(int i = 0; i < tmp.size()-1; i++) {
			node.setLeft(null);
			node.setRight(tmp.get(i+1));
			node = node.right;
		}
	}
	
	//============== TREE VISUALIZATION ====================//
	/**
	 * toString
	 * 
	 * generate the tree representation in string form
	 * 
	 * @return String 
	 */
	@Override
	public String toString() {
		
		str = "";

		rec(this.root, 0);
		return str;
	}
	
	/**
	 * rec
	 * 
	 * @param node
	 * @param level
	 * 
	 * helper method to recursive append the str 
	 */
	public void rec(Node node, int level) {
		
		str+="|";
		
		//terminate condition
		if (node == null) {
			//print null then end
			for (int i = 0; i < level; i++)
				str+="-----";
			str+="NULL\n";
			return;
		}
		
		//print the normal lines of nodes
		for (int i = 0; i < level; i++)
			str+="-----";
		str+=node.getCity()+":"+node.getPopulation()+"\n";
		
		//left child recursion
		str+="|";
		for (int i = 0; i < level; i++)
			str+="-----";
		str+="L:\n";
		rec(node.left, level+1);
		
		//right child recursion
		str+="|";
		for (int i = 0; i < level; i++)
			str+="-----";
		str+="R:\n";
		rec(node.right, level+1);
	}
	
}