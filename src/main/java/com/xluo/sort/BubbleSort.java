package com.xluo.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 方法：依次比较，找到不符合升序或降序的突破口，进行交换，一轮一下能找到一个最大值或最小值
 * 结论：冒泡排序的时间效率是不确定的：最好的情况下，初始数据序列已经有序，执行一趟即可，做n-1次比较
 * 	无需任何交换；最坏的情况下，初始数据序列处于完全逆序，算法要执行n-1趟冒泡，要做n-i次比较，执行n-i-1
 * 	次对象交换。此时的比较总次数为n*(n-1)/2，记录移动总次数为n*(n-1)*3/2。n^2
 * 时间复杂度：平均O(n^2)、最好O(n)、最坏O(n^2)
 *  辅助空间：O(1)
 *  优点：思路简单、实现容易、空间效率高、稳定
 *  缺点：耗时较长
 * 要点：在遍历的时候要注意，当要比较i、i+1或i-1、i的时候要注意循环的条件，前者i是[0, array.length - 1]
 * 	后者i是[1, array.length]
 * @author luozhangjie
 *
 */
public class BubbleSort {

	public static void bubbleSort(int[] array){
		for(int i = 0; i < array.length - 1; i++){ //趟数
			boolean flag = false; //优化标记
//			for(int j = 0; j < array.length - i - 1; j++){ //比较
//				if(array[j] > array[j + 1]){ //突破点
//					array[j] = array[j]^array[j + 1];
//					array[j + 1] = array[j]^array[j + 1];
//					array[j] = array[j]^array[j + 1];
//					flag = true;
//				}
//			}
			for(int j = 1; j < array.length - i; j++){ //比较
				if(array[j - 1] > array[j]){ //突破点
					array[j - 1] = array[j - 1]^array[j];
					array[j] = array[j - 1]^array[j];
					array[j - 1] = array[j - 1]^array[j];
					flag = true;
				}
			}
			if(!flag){
				break;
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		bubbleSort(new int[]{0, 1, 2, 3, 1, 3, 6, 7, 1, 9});
		bubbleSort(new int[]{0, 1, 0, 3, 1, 3, 6, 7, 1, 9});
	}
	
}
