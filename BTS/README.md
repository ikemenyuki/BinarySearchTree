# PA8 BST

To be honest this was the hardest PA I have ever encountered. I spent like 30 hours in total to finish this one. There are four classes need to be implemented, among which three are the binary tree class, tree node class, and the queue class. The queue class is just like the previous PA, the node class is simple as well, but there are too many methods to be implemented in the binary tree class. First there are two contructors, one takes in two arrays as parameters, and the second one takes a file containing data and the lines to be read in as the parameters. To initialize the arrays as the binary tree, take the element in the middle index as the root node, and constantly split them into two halfs, using recursion to set the left childs and the right childs. The second constructor is implemented with the FileInputStream and the BufferedReader to read in the data and split them into two sorted arrays. Then use the same method in the first constructor to initialize the tree. The we have methods like adding nodes to the tree, getting the smallest and largest cities, get the width and the depth of the tree... Then we have four different traversal methods and getting lists using the traversal. Besides, we need to get different views fo the tree. Then we have special tree implementations like flattening the tree to linked list, finding the paths etc... The the other file is the test case class in which we need to write our own test cases to cover as many cases (including edge cases) as possible.

## Author

* **Yueqi Liao** - *Yueqi Liao* - [cs12sp19iv](mailto:yliao@ucsd.edu)

## Acknowledgments

* Hat tip to anyone who helps me on this assignment
* Inspiration
* etc
