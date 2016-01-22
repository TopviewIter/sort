package com.xluo.sort;

import java.util.Arrays;

/**
 * 折半插入排序
 * 思路：实际上就是对直接插入排序的一个优化,因为直接插入排序并没有利用前半部分已经是有序这一特性
 * 	在这里使用二分查找先确定插入位置再后移,而不像直接插入排序那样边后移边比较从而确定停止时间
 * 总结：与直接插入排序的效果基本相同,只是更快了一些,因为折半插入排序可以更快地确定第i个元素的插
 * 	入位置
 * @author luozhangjie
 *
 */
public class BinaryInsertSort {

	public static void binaryInsertSort(int[] array){

		for(int i = 1; i < array.length; i++){
			if(array[i] < array[i - 1]){ //突破点
				int target = array[i];
				int start = 0;
				int end = i - 1; //在[0, i-1]间查找插入点
				while(start <= end){ //找到插入点
					int mid = (start + end) >> 1;
					if(target < array[mid]){
						end = mid - 1;
					}else{
						start = mid + 1;
					}
				}
				for(int j = i - 1; j >= start; j--){ //0-mid均为大于等于target的，那么应该从mid之后插入,而这时mid+1=start
					array[j + 1] = array[j];
				}
				array[start] = target;
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		binaryInsertSort(new int[]{0, 1, 2, 3, 1, 3, 6, 7, 1, 9, -1});
		binaryInsertSort(new int[]{0, 1, 0, 3, 1, 3, 6, 7, 1, 9});
		binaryInsertSort(new int[]{9, 9, 0, 3, 1, 3, 6, 7, 1, 9});	
		binaryInsertSort(new int[]{1, 3, 3, 4, 2});
		binaryInsertSort(new int[]{1, 3, 4, 2});
	}
}
