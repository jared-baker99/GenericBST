// Jared Baker (NID: ja907583)
// COP 3503, Fall 2022

// Basic binary search tree (BST) implementation that supports insert() and
// delete() operations. This framework is provided for you to modify as part of
// Programming Assignment #2.

import java.io.*;
import java.util.*;

// Modify the node to a type node that points to other type nodes
class Node<type>
{
	type data;
	Node<type> left, right;

	Node(type data)
	{
		this.data = data;
	}
}

public class GenericBST<type extends Comparable <type>>
{
	private Node<type> root;

	// Adds a new node to the Binary Search Tree
	public void insert(type data)
	{
		root = insert(root, data);
	}

	private Node<type> insert(Node<type> root, type data)
	{
		// If their is no node at the root being looked at
		if (root == null)
		{
			return new Node<type>(data);
		}
		// Compares the root to the data being inserted
		// determines how we will travers the tree to insert the nodes
		// traverses left if the data is less than the root
		else if (data.compareTo(root.data) < 0)
		{
			root.left = insert(root.left, data);
		}
		//traverses right if the data is greater than the root
		else if (data.compareTo(root.data) > 0)
		{
			root.right = insert(root.right, data);
		}
		// returns if the data is already in the tree
		return root;
	}

	// deletes a node from the Binary Search Tree
	public void delete(type data)
	{
		root = delete(root, data);
	}

	private Node<type> delete(Node<type> root, type data)
	{
		// if we travers the tree and point to a null and dont find the data
		if (root == null)
		{
			return null;
		}
		// Compares the root to the data being inserted
		// determines how we will travers the tree to delete the nodes
		// If the data is less than the root we travers to the left of the tree
		else if (data.compareTo(root.data) < 0)
		{
			root.left = delete(root.left, data);
		}
		// if the data is greater than the root we travers to the right
		else if (data.compareTo(root.data) > 0)
		{
			root.right = delete(root.right, data);
		}
		// We found the node we want to delete
		else
		{
			// The node we are deleting isnt pointing to other nodes
			if (root.left == null && root.right == null)
			{
				return null;
			}
			// the node is only pointing to nodes to the left of it
			else if (root.left == null)
			{
				return root.right;
			}
			// the node is only pointing to nodes to the right
			else if (root.right == null)
			{
				return root.left;
			}
			// the node we are deleting points to two nodes
			else
			{
				// finds the largest data on the left side that will allow the tree to stay true in shape
				root.data = findMax(root.left);
				// replaces the largest data with the root we are deleting
				root.left = delete(root.left, root.data);
			}
		}
		return root;
	}

	// This method assumes root is non-null, since this is only called by
	// delete() on the left subtree, and only when that subtree is not empty.
	private type findMax(Node<type> root)
	{
		while (root.right != null)
		{
			root = root.right;
		}

		return root.data;
	}

	// determines if the tree contains the node or not
	public boolean contains(type data)
	{
		return contains(root, data);
	}

	private boolean contains(Node<type> root, type data)
	{
		// if we get to a pointer with null we traversed the tree to not find the node
		if (root == null)
		{
			return false;
		}
		// traverses to the left if the data we want is smaller than the root we are at
		else if (data.compareTo(root.data) < 0)
		{
			return contains(root.left, data);
		}
		// traverses right if the data is greater than the root
		else if (data.compareTo(root.data) > 0)
		{
			return contains(root.right, data);
		}
		// if the data is equal to the root we return true
		else
		{
			return true;
		}
	}

	// prints the tree inOrder
	public void inorder()
	{
		System.out.print("In-order Traversal:");
		inorder(root);
		System.out.println();
	}

	private void inorder(Node root)
	{
		if (root == null)
			return;

		inorder(root.left);
		System.out.print(" " + root.data);
		inorder(root.right);
	}

	// prints the tree in preOrder
	public void preorder()
	{
		System.out.print("Pre-order Traversal:");
		preorder(root);
		System.out.println();
	}

	private void preorder(Node<type> root)
	{
		if (root == null)
			return;

		System.out.print(" " + root.data);
		preorder(root.left);
		preorder(root.right);
	}

	// prints the tree in postOrder
	public void postorder()
	{
		System.out.print("Post-order Traversal:");
		postorder(root);
		System.out.println();
	}

	private void postorder(Node<type> root)
	{
		if (root == null)
			return;

		postorder(root.left);
		postorder(root.right);
		System.out.print(" " + root.data);
	}

	// Comments out the main because the main would be in the TestCase01.java or SanityCheck.jave

	// public static void main(String [] args)
	// {
	// 	GenericBST<type> myTree = new GenericBST<>();
	//
	// 	for (int i = 0; i < 5; i++)
	// 	{
	// 		int r = (int)(Math.random() * 150) + 1;
	// 		System.out.println("Inserting " + r + "...");
	// 		myTree.insert(r);
	// 	}
	//
	// 	myTree.inorder();
	// 	myTree.preorder();
	// 	myTree.postorder();
	// }

	public static double difficultyRating()
	{
		return 2.0;
	}
	public static double hoursSpent()
	{
		return 15;
	}
}
