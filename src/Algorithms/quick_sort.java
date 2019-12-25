package Algorithms;

import java.util.Arrays;

public class quick_sort {
	
	public static void main(String[] args) {
		int[] x = {4,8,2,7,5,9,1,3,6};
		quickSort(x, 0, x.length - 1);
		
		System.out.println(Arrays.toString(x));
	}
	
	public static void quickSort(int[] a, int low, int high) {
		if (low >= high) { return; }
		
		int index = partition(a, low, high);
		quickSort(a, low, index);
		quickSort(a, index + 1, high);
		
	}
	
	public static int partition(int[] a, int low, int high) {
		int x = low;
		int y = high;
		
		while (true) {
			while (a[x] < a[low]) {
				x++;
			}
			
			while (a[y] > a[low]) {
				y--;
			}
			
			exchange(a, x, y);
			
			if (x >= y) {
				break;
			}
		}
		
		exchange(a, low, x);
		return x;
	}
	
	public static void exchange(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}
