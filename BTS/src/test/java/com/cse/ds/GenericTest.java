package com.cse.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenericTest {
	
	static BinarySearchTree bst = null;
	
	@BeforeClass
    public static void setUpBeforeClass() {
		bst = new BinarySearchTree(null, null);
		bst.addCity("A", 5);
		bst.addCity("B", 4);
		bst.addCity("C", 8);
		bst.addCity("D", 2);
		bst.addCity("E", 7);
    }
	
	@Before
	public void beforeMethod()
	{
		bst = new BinarySearchTree(null, null);
		bst.addCity("A", 5);
		bst.addCity("B", 4);
		bst.addCity("C", 8);
		bst.addCity("D", 2);
		bst.addCity("E", 7);
	}
	
	@Test
	public void test1() {
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
	
	@Test
	public void test2( ) {
		Assert.assertEquals(Arrays.asList(new String[]{"D", "B", "A", "E", "C"}),bst.getSortedCities());
		Assert.assertEquals(Arrays.asList(new String[]{"A", "B", "D", "C", "E"}),bst.getPreOrderTraversal());
		Assert.assertEquals(Arrays.asList(new String[]{"D", "B", "E", "C", "A"}),bst.getPostOrderTraversal());
	}
	
	@Test
	public void test2_2( ) {
		Assert.assertEquals(3, bst.getMaxDepth());
		Assert.assertEquals(3, bst.getMaxWidth());
	}
	
	@Test
	public void test2_3( ) {
		List<List<String>> res = new ArrayList<>();
		res.add(Arrays.asList(new String[]{"A"}));
		res.add(Arrays.asList(new String[]{"B","C"}));
		res.add(Arrays.asList(new String[]{"D","E"}));

		Assert.assertEquals(res,bst.getLevelWiseCities());
	}
	
	@Test
	public void test2_4( ) {
		Assert.assertEquals(Arrays.asList(new String[]{"=>A=>B=>D", "=>A=>C=>E"}),bst.getAllPaths());
		
		List<List<String>> res1 = new ArrayList<>();
		res1.add(Arrays.asList(new String[]{"A"}));
		res1.add(Arrays.asList(new String[]{"C","B"}));
		res1.add(Arrays.asList(new String[]{"D","E"}));
		Assert.assertEquals(res1,bst.getTwistyTraversal());
	}
	
	@Test
	public void test2_5( ) {
		List<List<String>> res1 = new ArrayList<>();
		res1.add(Arrays.asList(new String[]{"A"}));
		res1.add(Arrays.asList(new String[]{"C","B"}));
		res1.add(Arrays.asList(new String[]{"D","E"}));
		Assert.assertEquals(res1,bst.getTwistyTraversal());
	}
	
	@Test
	public void test3( ) {
		Assert.assertEquals(18, bst.getBSTilt());
	}
	
	@Test
	public void test4( ) {
		Assert.assertEquals(Arrays.asList(new String[]{"A", "C", "E"}), bst.getRightView());
	}
	
	@Test
	public void test5( ) {
		Assert.assertEquals(Arrays.asList(new String[]{"A", "B", "D"}), bst.getLeftView());
	}
	
	@Test
	public void test6( ) {
		Assert.assertEquals(Arrays.asList(new String[]{"D", "B", "A", "C"}), bst.getTopView());
	}
	
	@Test
	public void test7( ) {
		Assert.assertEquals(Arrays.asList(new String[]{"D", "B", "E", "C"}), bst.getBottomView());
	}

	
	@Test
	public void test9( ) {
		bst.flattenToLL();
		Assert.assertEquals("|A:5\n" + 
				"|L:\n" + 
				"|-----NULL\n" + 
				"|R:\n" + 
				"|-----B:4\n" + 
				"|-----L:\n" + 
				"|----------NULL\n" + 
				"|-----R:\n" + 
				"|----------D:2\n" + 
				"|----------L:\n" + 
				"|---------------NULL\n" + 
				"|----------R:\n" + 
				"|---------------C:8\n" + 
				"|---------------L:\n" + 
				"|--------------------NULL\n" + 
				"|---------------R:\n" + 
				"|--------------------E:7\n" + 
				"|--------------------L:\n" + 
				"|-------------------------NULL\n" + 
				"|--------------------R:\n" + 
				"|-------------------------NULL\n", bst.toString());
	}

}
