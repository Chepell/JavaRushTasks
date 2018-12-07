package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
	public void recursion(int n) {
		int divider = 2;
		while (n >= divider) {
			if ((n % divider) == 0) {
				if (divider != n) {
					System.out.print(divider + " ");
					recursion(n / divider);
				} else {
					System.out.print(divider);
				}
				return;
			}
			divider++;
		}
	}

	public static void main(String[] args) {
		new Solution().recursion(132);
	}
}
