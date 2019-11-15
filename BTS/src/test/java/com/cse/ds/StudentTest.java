package com.cse.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * StudentTest
 * 
 * @author Yueqi Liao
 * 
 * @login cs12sp19iv
 * 
 * @date May 30, 2019
 * 
 * @email yliao@ucsd.edu
 */
public class StudentTest {
	
	//FIELD 
	//two arrays as the input
	String[] cities = {"San Diego", "Los Angeles", "New York", "Shanghai", "Beijing", "Chongqing",
			"Big city1", "Big city2", "Big city3", "Big city4", "Big city5"};
	int[] population = {1,2,3,4,5,6,7,8,9,10,11};
	
	static BinarySearchTree bst = null;
	
	/**
	 * testCtor1
	 * 
	 * test the firstconstructor
	 */
	@Test
	public void testCtor1() {
	
		bst = new BinarySearchTree(cities, population);
		Assert.assertEquals(bst.root.getCity(), "Chongqing");
		Assert.assertEquals(bst.root.left.getCity(), "New York");
		Assert.assertEquals(bst.root.right.getCity(), "Big city3");
		Assert.assertEquals(bst.root.left.left.getCity(), "San Diego");
		Assert.assertEquals(bst.root.left.left.right.getCity(), "Los Angeles");
		Assert.assertEquals(bst.root.right.right.getCity(), "Big city4");
		Assert.assertEquals(bst.root.right.right.right.getCity(), "Big city5");
		
	}
	
	/**
	 * testCtor2
	 * 
	 * test the second constructor
	 */
	@Test
	public void testCtor2() {
		
		bst = new BinarySearchTree("resource/input.txt", 5);
		Assert.assertEquals("|Chicago city_Illinois:2695598\n" + 
				"|L:\n" + 
				"|-----Phoenix city_Arizona:1445632\n" + 
				"|-----L:\n" + 
				"|----------NULL\n" + 
				"|-----R:\n" + 
				"|----------Houston city_Texas:2099451\n" + 
				"|----------L:\n" + 
				"|---------------NULL\n" + 
				"|----------R:\n" + 
				"|---------------NULL\n" + 
				"|R:\n" + 
				"|-----Los Angeles city_California:3792621\n" + 
				"|-----L:\n" + 
				"|----------NULL\n" + 
				"|-----R:\n" + 
				"|----------New York city_New York:8175133\n" + 
				"|----------L:\n" + 
				"|---------------NULL\n" + 
				"|----------R:\n" + 
				"|---------------NULL\n", bst.toString());
	}
	
	/**
	 * testNullFilename
	 * 
	 * test when input file name is null
	 */
	@Test
	public void testNullFileName() {
		bst = new BinarySearchTree(null, 4);
		Assert.assertNull(bst.root);
	}
	
	/**
	 * testNumLinesLessThanZero
	 * 
	 * test when input num_lines < 0
	 */
	@Test
	public void testNumLinesLessThanZero() {
		bst = new BinarySearchTree("resource/input.txt", -1);
		Assert.assertNull(bst.root);
	}
	
	/**
	 * testAddNull
	 * 
	 * test add null elements in the tree, IllegalArgumentException expected
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddNull() {
		
		bst = new BinarySearchTree(cities, population);
		bst.addCity(null, 1);
	}
	/**
	 * testLeftView
	 * 
	 * test the left view of tree
	 */
	@Test 
	public void testLeftView() {
		
		bst = new BinarySearchTree(cities, population);
		Assert.assertEquals(Arrays.asList(new String[] {"Chongqing", "New York", "San Diego", "Los Angeles"}), bst.getLeftView());
	}
	
	/**
	 * testLeftView
	 * 
	 * test the left view of tree
	 */
	@Test 
	public void testRightView() {
		
		bst = new BinarySearchTree(cities, population);
		Assert.assertEquals(Arrays.asList(new String[] {"Chongqing", "Big city3", "Big city4", "Big city5"}), bst.getRightView());
	}
	
	/**
	 * testTopView
	 * 
	 * test the op view of tree
	 */
	@Test
	public void testTopView() {
		
		bst = new BinarySearchTree(cities, population);
		Assert.assertEquals(Arrays.asList(new String[] {"San Diego", "New York","Chongqing", "Big city3", "Big city4", "Big city5"}),
				bst.getTopView());
	}
	
	/**
	 * testWrongInput
	 * 
	 * test when the sizes of two parameter arrays do not match, should throw 
	 * IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testWrongInput() {
		
		int[] arr = new int[population.length-1];
		for (int i = 0; i < population.length-1; i++) {
			arr[i]=population[i];
		}
		bst = new BinarySearchTree(cities, arr);
	}
	
	/**
	 * testBottomView
	 * 
	 * test bottom view of the tree
	 */
	@Test
	public void testBottomView() {
		
		bst = new BinarySearchTree(cities, population);
		Assert.assertEquals(Arrays.asList(new String[] {"San Diego", "Los Angeles", "Big city1", "Big city2", "Big city4", "Big city5"}), 
				bst.getBottomView());
	}
	
	/**
	 * testPreTraversal
	 * 
	 * test the pre-order traversal of the tree
	 */
	@Test
	public void testPreTraversal() {
		
		bst = new BinarySearchTree(cities, population);
		String[] arr = {"Chongqing", "New York", "San Diego", "Los Angeles", "Shanghai", "Beijing", "Big city3", "Big city1","Big city2",
				"Big city4","Big city5"};
		Assert.assertEquals(Arrays.asList(arr), bst.getPreOrderTraversal());
		
	}
	
	/**
	 * testInTraversal
	 * 
	 * test in-order traversal of the tree
	 */
	@Test
	public void testInTraversal() {
		
		bst = new BinarySearchTree(cities, population);
		Assert.assertEquals(Arrays.asList(cities), bst.getSortedCities());
		
	}
	
	/**
	 * testPostTraversal
	 * 
	 * test post-order traversal of the tree
	 */
	@Test
	public void testPostTraversal() {
		
		bst = new BinarySearchTree(cities, population);
		String[] arr = {"Los Angeles", "San Diego","Beijing","Shanghai", "New York", "Big city2", "Big city1","Big city5",
				"Big city4","Big city3","Chongqing"};
		Assert.assertEquals(Arrays.asList(arr), bst.getPostOrderTraversal());
		
	}
	
	/**
	 * testTwistyTraversal
	 * 
	 * test the twisty traversal of the tree
	 */
	@Test
	public void testTwistyTraversal() {
		
		//variable initialization
		bst = new BinarySearchTree(cities, population);
		List<List<String>> list = new ArrayList<List<String>>();
		List<String> tmp1=new ArrayList<String>();
		List<String> tmp2=new ArrayList<String>();
		List<String> tmp3=new ArrayList<String>();
		List<String> tmp4=new ArrayList<String>();
		tmp1.add("Chongqing");
		list.add(tmp1);
		tmp2.add("Big city3");
		tmp2.add("New York");
		list.add(tmp2);
		tmp3.add("San Diego");
		tmp3.add("Shanghai");
		tmp3.add("Big city1");
		tmp3.add("Big city4");
		list.add(tmp3);
		tmp4.add("Big city5");
		tmp4.add("Big city2");
		tmp4.add("Beijing");
		tmp4.add("Los Angeles");
		list.add(tmp4);
		Assert.assertEquals(list, bst.getTwistyTraversal());
		
	}
	
	/**
	 * testLevelWiseCities
	 * 
	 * test getLevelWiseCities method
	 */
	@Test
	public void testLevelWiseCities() {
		
		bst = new BinarySearchTree(cities, population);
		List<List<String>> list = new ArrayList<List<String>>();
		list.add(Arrays.asList(new String[] {"Chongqing"}));
		list.add(Arrays.asList(new String[] {"New York", "Big city3"}));
		list.add(Arrays.asList(new String[] {"San Diego", "Shanghai", "Big city1", "Big city4"}));
		list.add(Arrays.asList(new String[] {"Los Angeles", "Beijing", "Big city2", "Big city5"}));
		Assert.assertEquals(list, bst.getLevelWiseCities());
	}
	
	/**
	 * testNullRootTilt
	 * 
	 * test empty tree
	 */
	@Test
	public void testNullRootTilt() {
		bst= new BinarySearchTree(null, null);
		Assert.assertEquals(bst.getBSTilt(), 0);
	}
	
	/**
	 * testNullRootGetPath
	 * 
	 * test empty tree should return empty list
	 */
	@Test
	public void testNullRootGetPath() {
		
		List<String> list = new ArrayList<String>();
		bst= new BinarySearchTree(null, null);
		Assert.assertEquals(bst.getAllPaths(), list);
	}
	/**
	 * testNullRootGetViews
	 * 
	 * test empty tree should return empty list
	 */
	@Test
	public void testNullRootGetViews() {
		
		List<String> list = new ArrayList<String>();
		bst= new BinarySearchTree(null, null);
		Assert.assertEquals(bst.getLeftView(), list);
		Assert.assertEquals(bst.getRightView(), list);
		Assert.assertEquals(bst.getTopView(), list);
		Assert.assertEquals(bst.getBottomView(), list);
	}
	
	/**
	 * testNullRootTraversals
	 * 
	 * test empty tree should return empty list
	 */
	@Test
	public void testNullRootTraversals() {
		
		List<String> list = new ArrayList<String>();
		List<List<String>> list2 = new ArrayList<List<String>>();
		bst= new BinarySearchTree(null, null);
		Assert.assertEquals(bst.getSortedCities(), list);
		Assert.assertEquals(bst.getPreOrderTraversal(), list);
		Assert.assertEquals(bst.getPostOrderTraversal(), list);
		Assert.assertEquals(bst.getTwistyTraversal(), list2);
	}
	
	/**
	 * testNullRootLevelWiseCities
	 * 
	 * test empty tree should return empty list
	 */
	@Test
	public void testNullRootLevelWiseCities() {
		
		List<List<String>> list2 = new ArrayList<List<String>>();
		bst= new BinarySearchTree(null, null);
		Assert.assertEquals(bst.getLevelWiseCities(), list2);
	}

	/**
	 * testNullRootFindSmallest
	 * 
	 * should return null
	 */
	@Test
	public void testNullRootFindSmallest() {
		
		bst= new BinarySearchTree(null, null);
		Assert.assertNull(bst.getSmallestCity());
	}
	
	/**
	 * testNullRootFindLargest
	 * 
	 * should return null
	 */
	@Test
	public void testNullRootFindLargest() {
		
		bst= new BinarySearchTree(null, null);
		Assert.assertNull(bst.getLargestCity());
	}
	
	/**
	 * testBSTilt
	 * 
	 * test the getBSTilt method
	 */
	@Test
	public void testBSTilt() {
		
		bst = new BinarySearchTree(cities, population);
		Assert.assertEquals(68, bst.getBSTilt());
	}
	
	/**
	 * testToString
	 * 
	 * test toString method
	 */
	@Test
	public void testToString() {
		
		bst = new BinarySearchTree(cities, population);
		Assert.assertEquals("|Chongqing:6\n"+
						    "|L:\n"+
						    "|-----New York:3\n" +
						    "|-----L:\n"+
						    "|----------San Diego:1\n"+
						    "|----------L:\n"+
						    "|---------------NULL\n"+
						    "|----------R:\n"+
						    "|---------------Los Angeles:2\n"+
						    "|---------------L:\n"+
						    "|--------------------NULL\n"+
						    "|---------------R:\n"+
						    "|--------------------NULL\n"+
						    "|-----R:\n"+
						    "|----------Shanghai:4\n"+
						    "|----------L:\n"+
						    "|---------------NULL\n"+
						    "|----------R:\n"+
						    "|---------------Beijing:5\n"+
						    "|---------------L:\n"+
						    "|--------------------NULL\n"+
						    "|---------------R:\n"+
						    "|--------------------NULL\n"+
						    "|R:\n"+
						    "|-----Big city3:9\n"+
						    "|-----L:\n"+
						    "|----------Big city1:7\n"+
						    "|----------L:\n"+
						    "|---------------NULL\n"+
						    "|----------R:\n"+
						    "|---------------Big city2:8\n"+
						    "|---------------L:\n"+
						    "|--------------------NULL\n"+
						    "|---------------R:\n"+
						    "|--------------------NULL\n"+
						    "|-----R:\n"+
						    "|----------Big city4:10\n"+
						    "|----------L:\n"+
						    "|---------------NULL\n"+
						    "|----------R:\n"+
						    "|---------------Big city5:11\n"+
						    "|---------------L:\n"+
						    "|--------------------NULL\n"+
						    "|---------------R:\n"+
						    "|--------------------NULL\n", bst.toString());
		
	}
	
	/**
	 * testGetWidth
	 * 
	 * test getMaxWidth method
	 */
	@Test
	public void testGetWidth() {
		
		bst = new BinarySearchTree(cities, population);
		Assert.assertEquals(5, bst.getMaxWidth());
		
	}
	
	/**
	 * testGetDepth
	 * 
	 * test getMaxDepth method
	 */
	@Test
	public void testGetDepth() {
		
		bst = new BinarySearchTree(cities, population);
		Assert.assertEquals(4, bst.getMaxDepth());
		
	}
	
	/**
	 * testSmallest
	 * 
	 * test getSmallestCity method
	 */
	@Test
	public void testSmallest() {
		
		bst = new BinarySearchTree(cities, population);
		Assert.assertEquals("San Diego", bst.getSmallestCity());
	}
	
	/**
	 * testLargest
	 * 
	 * test getSmallestCity method
	 */
	@Test
	public void testLargest() {
		
		bst = new BinarySearchTree(cities, population);
		Assert.assertEquals("Big city5", bst.getLargestCity());
	}
	
	/**
	 * testToLinkedList
	 * 
	 * test FlattenToLL method
	 */
	@Test
	public void testToLinkedList() {
		
		bst = new BinarySearchTree(cities, population);
		bst.flattenToLL();
		Assert.assertEquals("|Chongqing:6\n" + 
				"|L:\n" + 
				"|-----NULL\n" + 
				"|R:\n" + 
				"|-----New York:3\n" + 
				"|-----L:\n" + 
				"|----------NULL\n" + 
				"|-----R:\n" + 
				"|----------San Diego:1\n" + 
				"|----------L:\n" + 
				"|---------------NULL\n" + 
				"|----------R:\n" + 
				"|---------------Los Angeles:2\n" + 
				"|---------------L:\n" + 
				"|--------------------NULL\n" + 
				"|---------------R:\n" + 
				"|--------------------Shanghai:4\n" + 
				"|--------------------L:\n" + 
				"|-------------------------NULL\n" + 
				"|--------------------R:\n" + 
				"|-------------------------Beijing:5\n" + 
				"|-------------------------L:\n" + 
				"|------------------------------NULL\n" + 
				"|-------------------------R:\n" + 
				"|------------------------------Big city3:9\n" + 
				"|------------------------------L:\n" + 
				"|-----------------------------------NULL\n" + 
				"|------------------------------R:\n" + 
				"|-----------------------------------Big city1:7\n" + 
				"|-----------------------------------L:\n" + 
				"|----------------------------------------NULL\n" + 
				"|-----------------------------------R:\n" + 
				"|----------------------------------------Big city2:8\n" + 
				"|----------------------------------------L:\n" + 
				"|---------------------------------------------NULL\n" + 
				"|----------------------------------------R:\n" + 
				"|---------------------------------------------Big city4:10\n" + 
				"|---------------------------------------------L:\n" + 
				"|--------------------------------------------------NULL\n" + 
				"|---------------------------------------------R:\n" + 
				"|--------------------------------------------------Big city5:11\n" + 
				"|--------------------------------------------------L:\n" + 
				"|-------------------------------------------------------NULL\n" + 
				"|--------------------------------------------------R:\n" + 
				"|-------------------------------------------------------NULL\n", bst.toString());
	}
	
	/**
	 * testAddCities
	 * 
	 * test add cities
	 */
	@Test
	public void testAddCities() {
		
		//initialize the tree
		bst = new BinarySearchTree(null, null);
		bst.addCity("A", 5);
		bst.addCity("B", 3);
		bst.addCity("C", 7);
		bst.addCity("D", 2);
		bst.addCity("E", 1);
		bst.addCity("F", 6);
		bst.addCity("G", 4);
		bst.addCity("H", 8);
		bst.addCity("I", 10);
		bst.addCity("J", 9);
		
		List<String> list = new ArrayList<String>();
		list.add("=>A=>B=>D=>E");
		list.add("=>A=>B=>G");
		list.add("=>A=>C=>F");
		list.add("=>A=>C=>H=>I=>J");
		
		//test toString 
		Assert.assertEquals("|A:5\n" + 
				"|L:\n" + 
				"|-----B:3\n" + 
				"|-----L:\n" + 
				"|----------D:2\n" + 
				"|----------L:\n" + 
				"|---------------E:1\n" + 
				"|---------------L:\n" + 
				"|--------------------NULL\n" + 
				"|---------------R:\n" + 
				"|--------------------NULL\n" + 
				"|----------R:\n" + 
				"|---------------NULL\n" + 
				"|-----R:\n" + 
				"|----------G:4\n" + 
				"|----------L:\n" + 
				"|---------------NULL\n" + 
				"|----------R:\n" + 
				"|---------------NULL\n" + 
				"|R:\n" + 
				"|-----C:7\n" + 
				"|-----L:\n" + 
				"|----------F:6\n" + 
				"|----------L:\n" + 
				"|---------------NULL\n" + 
				"|----------R:\n" + 
				"|---------------NULL\n" + 
				"|-----R:\n" + 
				"|----------H:8\n" + 
				"|----------L:\n" + 
				"|---------------NULL\n" + 
				"|----------R:\n" + 
				"|---------------I:10\n" + 
				"|---------------L:\n" + 
				"|--------------------J:9\n" + 
				"|--------------------L:\n" + 
				"|-------------------------NULL\n" + 
				"|--------------------R:\n" + 
				"|-------------------------NULL\n" + 
				"|---------------R:\n" + 
				"|--------------------NULL\n", bst.toString());
		
		//test tree views
		Assert.assertEquals(Arrays.asList(new String[]{"E", "D", "B", "A", "C", "H", "I"}), bst.getTopView());
		Assert.assertEquals(Arrays.asList(new String[]{"E", "D", "B", "F", "C", "J", "I"}), bst.getBottomView());
		Assert.assertEquals(Arrays.asList(new String[]{"A", "B", "D", "E", "J"}), bst.getLeftView());
		Assert.assertEquals(Arrays.asList(new String[]{"A", "C", "H", "I", "J"}), bst.getRightView());
		Assert.assertEquals(list, bst.getAllPaths());
		
		//test traversals
		Assert.assertEquals(Arrays.asList(new String[]{"A", "B", "D", "E", "G", "C", "F", "H", "I", "J"}), bst.getPreOrderTraversal());
		Assert.assertEquals(Arrays.asList(new String[]{"E", "D", "G", "B", "F", "J", "I", "H", "C", "A"}), bst.getPostOrderTraversal());
		Assert.assertEquals(Arrays.asList(new String[]{"E", "D", "B", "G", "A", "F", "C", "H", "J", "I"}), bst.getSortedCities());
		
		//test get numbers
		Assert.assertEquals(81, bst.getBSTilt());
		Assert.assertEquals(6, bst.getMaxWidth());
		Assert.assertEquals(5,  bst.getMaxDepth());
		
		//test get cities
		Assert.assertEquals("E", bst.getSmallestCity());
		Assert.assertEquals("I", bst.getLargestCity());
		
		//test get level wise cities
		List<List<String>> list2 = new ArrayList<List<String>>();//initialize lists
		List<String> t1 = new ArrayList<String>();
		List<String> t2 = new ArrayList<String>();
		List<String> t3 = new ArrayList<String>();
		List<String> t4 = new ArrayList<String>();
		List<String> t5 = new ArrayList<String>();
		//add elements to lists
		t1.add("A");
		t2.add("B");
		t2.add("C");
		t3.add("D");
		t3.add("G");
		t3.add("F");
		t3.add("H");
		t4.add("E");
		t4.add("I");
		t5.add("J");
		list2.add(t1);
		list2.add(t2);
		list2.add(t3);
		list2.add(t4);
		list2.add(t5);
		Assert.assertEquals(list2, bst.getLevelWiseCities());
		
		//test twisty traversal
		List<List<String>> list3 = new ArrayList<List<String>>();//initialize lists
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>();
		List<String> l3 = new ArrayList<String>();
		List<String> l4 = new ArrayList<String>();
		List<String> l5 = new ArrayList<String>();
		//add elements to lists
		l1.add("A");
		l2.add("C");
		l2.add("B");
		l3.add("D");
		l3.add("G");
		l3.add("F");
		l3.add("H");
		l4.add("I");
		l4.add("E");
		l5.add("J");
		list3.add(l1);
		list3.add(l2);
		list3.add(l3);
		list3.add(l4);
		list3.add(l5);
		Assert.assertEquals(list3, bst.getTwistyTraversal());
	}
}