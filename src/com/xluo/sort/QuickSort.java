package com.xluo.sort;

import java.util.Arrays;

/**
 * 快排
 * 思路：选择一个轴钮,然后把整个序列以它为分界,把比它小的放到一边,比它大的放到一边,
 * 	再通过递归的方式,以轴钮为临界,再排两边的子序列
 * 总结：快排的时间效率很好,因为它趟能确定的元素呈指数增长
 * 	快排需要使用递归,递归要使用栈,因此它的空间效率为O(log2n)
 * 	它里面包含跳跃式交换,因此是不稳定的算法
 * 时间复杂度：平均O(nlog2n)、最好O(nlog2n)、最坏O(n^2)：、
 * 	在最坏的情况下,快排退化成冒泡,每一趟只能排除掉一个元素
 * 	辅助空间:O(nlog2n)
 * 优点：效率高
 * 缺点：比较复杂
 * 要点：这里借助i、j主要的目的
 * 	1、可以整合两个交换,也就是把i、j都移到了合适的位置再进行交换
 * 	2、能够在一个方法体内完成对子序列的递归操作
 * @author luozhangjie
 *
 */
public class QuickSort {

	public static void quickSort(int[] array, int start, int end){
		if(start < end){
			int i = start;
			int j = end + 1;
			while(true){
				//把两个指针都移到要交换的位置上再进行交换
				while(i < end && array[++i] < array[start]);
				while(j > start && array[--j] > array[start]);
				if(i < j){
					array[i] = array[i]^array[j];
					array[j] = array[i]^array[j];
					array[i] = array[i]^array[j];
				}else{
					break;
				}
			}
			//把轴钮值赋到分割点,记得一定要加这个判断,不然,当start==j的时候,那么会把这个下标的值置为0
			if(start != j){ 
				array[start] = array[start]^array[j];
				array[j] = array[start]^array[j];
				array[start] = array[start]^array[j];
			}
			
			quickSort(array, start, j - 1);
			quickSort(array, j + 1, end);
		}
		
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
//		quickSort(new int[]{0, 1, 2, 3, 1, 3, 6, 7, 1, 9, -1}, 0, 10);
//		quickSort(new int[]{0, 1, 0, 3, 1, 3, 6, 7, 1, 9}, 0, 9);
		quickSort(new int[]{0, 0, 0, 1, 1, 1, 2}, 0, 6);
	}
	
}
