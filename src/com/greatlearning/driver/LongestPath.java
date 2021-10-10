package com.greatlearning.driver;

import java.util.ArrayList;

public class LongestPath {

	static class Node {

		Node left;
		Node right;
		int data;		
	}

	static Node newNode(int data) {

		Node temp = new Node();

		temp.data = data;

		temp.left = null;
		temp.right =null;

		return temp;
	}

	public static ArrayList<Integer> longestPath(Node root) {

		if (root == null) {

			ArrayList<Integer> path = new ArrayList<>();
			return path;
		}

		ArrayList<Integer> left = longestPath(root.left);
		ArrayList<Integer> right = longestPath(root.right);

		if (left.size() > right.size()) {
			left.add(root.data);
		}
		else {
			right.add(root.data);
		}

		return (left.size() > right.size() ? left : right);

	}

	public static void main(String[] args) {

		Node root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(130);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.right.left = newNode(110);
		root.right.right = newNode(140);
		root.left.left.left = newNode(5);

		ArrayList<Integer> path = longestPath(root);

		int n = path.size();

		System.out.print(path.get(n - 1));
		for(int i = n - 2; i >= 0; i--)
		{
			System.out.print(" -> " + path.get(i));
		}

	}

}
