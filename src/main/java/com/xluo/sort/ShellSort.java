package com.xluo.sort;

import java.util.Arrays;

/**
 * 思路：以某一个步长,把整个序列分成若干分,再在若干份子序列内进行直接插入排序.继续变化步长,再进行直接插入排序,直到步长变为1
 * 时间复杂度：平均O(n^1.3)、最好O(n)、最坏O(n^2)
 * 	空间复杂度：O(1)
 * @author luozhangjie
 *
 */
public class ShellSort {

	public static void shellSort_01(int[] array){
		for(int gap = array.length / 2; gap > 0; gap /= 2){ //步长的变化
			for(int i = 0; i < gap; i++){
				for(int j = i + gap; j < array.length; j += gap){ //i i+gap i+2gap i+3gap...序列进行直接插入排序
					if(array[j] > array[j - gap]){
						int temp = array[j];
						int k = j - gap;
						do{
							array[k + gap] = array[k];
							k -= gap;
						}while(k >= 0 && array[k] < temp);
						array[k + gap] = temp;
					}
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	public static void shellSort_03(int[] array){
		int i, j, gap;
		for(gap = array.length / 2; gap > 0; gap /= 2){
			for(i = gap; i < array.length; i++){
				for(j = i - gap; j >= 0 && array[j] > array[j + gap]; j -= gap){
					array[j] = array[j]^array[j + gap];
					array[j + gap] = array[j]^array[j + gap];
					array[j] = array[j]^array[j + gap];
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	public static void main(String[] args) {
		shellSort_01(new int[]{0, 1, 2, 3, 1, 3, 6, 7, 1, 9});
		shellSort_01(new int[]{0, 1, 0, 3, 1, 3, 6, 7, 1, 9});
	}
	
}
