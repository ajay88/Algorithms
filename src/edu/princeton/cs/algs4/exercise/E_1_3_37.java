package edu.princeton.cs.algs4.exercise;

public class E_1_3_37 {

	private static class Node {
		int val;
		Node next;
	}

	public static int josephIndex(int N, int M) {
		Node X = new Node();
		X.val = 1;
		X.next = X;
		Node head = X;
		Node tail = X;
		for (int i = 2; i <= N; i++) {
			Node y = new Node();
			y.val = i;
			tail.next = y;
			tail = y;
			tail.next = head;
		}
		Node d = tail;
		while (d != d.next) {
			for (int j = 1; j < M; j++) {
				d = d.next;
			}
			d.next = d.next.next;
		}
		return d.val;
	}

	public static void main(String[] args) {
		if (args[0] == null)
			throw new IllegalArgumentException(
					"Please provide number of people");
		if (args[1] == null)
			throw new IllegalArgumentException(
					"Please provide number M to be deleted");
		int N = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);
		System.out.println("N is : " + N + "," + " M is : " + M);
		System.out.println("Josephus saving index will be : "+josephIndex(N, M));
	}
}
