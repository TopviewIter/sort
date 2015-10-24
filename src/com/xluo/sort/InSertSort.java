package com.xluo.sort;

import java.util.Arrays;

/**
 * 直接插入排序
 * 思路：在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排好顺序的，现在要把第n个数插到前面的有序数中，使得这n个数
 *	也是排好顺序的。如此反复循环，直到全部排好顺序
 * 方法：先遍历找出突破点,再整体后移找到插入点
 * 结论：直接插入的时间效率并不高，如果在最坏情况下，所有元素的比较次数总和为(0+1+...+n-1)=O(n^2)
 * 	时间复杂度：平均O(n^2)、最好O(n)、最坏O(n^2)
 *  辅助空间：O(1)
 *  优点：实现简单
 *  缺点：效率低
 */
public class InSertSort {

	public static void insertSort(int[] array){
		for(int i = 1; i < array.length; i++){
			if(array[i] < array[i - 1]){ //突破点
				array[0] = array[i];
				int j = i - 1; //移动点
				do{
					array[j + 1] = array[j];
					j--;
				}while(j >= 0 && array[j] > array[0]);
				array[j + 1] = array[0]; //插入点
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		insertSort(new int[]{0, 1, 2, 3, 1, 3, 6, 7, 1, 9});
		insertSort(new int[]{0, 1, 0, 3, 1, 3, 6, 7, 1, 9});
	}
	
}

