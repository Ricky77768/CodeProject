package Algorithms;

import java.util.Arrays;

public class merge_sort {

	public static void main(String[] args) {
		int[] x = {4,8,2,7,5,9,1,3,6};
		separate(x, new int[x.length], 0, x.length - 1);
		
		System.out.println(Arrays.toString(x));
	}
	
	public static void separate(int[] a, int[] temp, int low, int high) {
		if (low >= high) { return; }
		int mid = (low + high) / 2;
		
		separate(a, temp, low, mid);
		separate(a, temp, mid + 1, high);
		merge(a, temp, low, mid, high);
	}
	
	public static void merge(int[] a, int[] temp, int low, int mid, int high) {
		for (int i = 0; i < temp.length; i++) {
			temp[i] = a[i];
		}
		int x = low;
		int y = mid + 1;
		int progress = 0;
		
		while (x <= mid || y < high) {
				
			if (x > mid) {
				a[low + progress] = temp[y];
				y++;
				progress++;
			}
			else if (y > high) {
				a[low + progress] = temp[x];
				x++;
				progress++;
			}
			else if (temp[x] < temp[y]) {
				a[low + progress] = temp[x];
				x++;
				progress++;
			}
			else if (temp[y] < temp[x]) {
				a[low + progress] = temp[y];
				y++;
				progress++;
			}
		}
	}
}

