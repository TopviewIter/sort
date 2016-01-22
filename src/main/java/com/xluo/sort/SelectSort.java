package com.xluo.sort;

import java.util.Arrays;

/**
 * 简单选择排序
 * 方法：类似于擂台法，保留一个擂主，让后续的与它比较，从而每一轮都能确定一个最值，与冒泡不同的是，它保留在前，冒泡保留在后
 * 结论：对于直接选择排序，数据交换最多n-1次，但程序比较次数较多。总体来说，其时间效率为O(n^2)
 * 	直接选择排序空间效率很高，只要一个附加程序单元用于交换，其空间效率为O(1)
 * 时间复杂度：平均、最好、最坏O(n^2)
 *  辅助空间：O(1)
 *  优点：思路简单、实现容易、空间效率高
 *  缺点：性能略差、不稳定
 *	应用：可以用来求数组的前k个最值
 * @author luozhangjie
 *
 */
public class SelectSort {

	public static void selectSort(int[] array){
		for(int i = 0; i < array.length - 1; i++){
			int minIndex = i; //擂主
			for(int j = i + 1; j < array.length; j++){
				if(array[j] < array[minIndex]){
					minIndex = j; //新擂主
				}
			}
			if(minIndex != i){ //交换擂主
				array[i] = array[i]^array[minIndex];
				array[minIndex] = array[i]^array[minIndex];
				array[i] = array[i]^array[minIndex];
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		selectSort(new int[]{0, 1, 2, 3, 1, 3, 6, 7, 1, 9});
		selectSort(new int[]{0, 1, 0, 3, 1, 3, 6, 7, 1, 9});
	}
	
}
