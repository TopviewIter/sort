package com.xluo.sort;

import java.util.Arrays;

/**
 * 归并算法
 * 思路：通过递归,把原数组不断分成若两个分组,再进行比较合并两个分组,把比较的结果保存到临时数组中
 * 	最后覆盖原数组的值
 * 总结：归并算法需要递归地进行分解、合并,每进行一趟两路归并排序需要调用merge方法一次,每次执行
 * 	merge方法都需要比较n次,因些归并排序算法的时间复杂度为O(nlog2n)
 * 时间复杂度：平均\最好\最坏O(nlog2n)
 * 	空间复杂度：O(n)
 * 优点：稳定、效率高
 * 缺点：空间效率差,它需要一个与原序列同样大小的辅助序列,比较占内存
 * 要点：log2n的确定：因为要用到递归树,有n个递归节点,那么时间复杂度为nlog2n
 * @author luozhangjie
 *
 */
public class MergeSort {

	public static void mergeSort(int[] array){
		recurrence(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
	
	public static void recurrence(int[] array, int left, int right){
		if(left < right){
			int center = (left + right) >> 1;
			recurrence(array, left, center);
			recurrence(array, center + 1, right);
			merge(array, left, right);
		}
	}
	
	public static void merge(int[] array, int left, int right){
		//辅助空间
		int[] temp = new int[array.length];
		int center = (left + right) >> 1;
		int secondArrayIndex = center + 1;
		int tempIndex = left;
		int firstArrayIndex = left;
		//当两个分组都还存在未放到temp的元素时,进行比较
		while(firstArrayIndex <= center && secondArrayIndex <= right){
			if(array[firstArrayIndex] <= array[secondArrayIndex]){
				temp[tempIndex++] = array[firstArrayIndex++]; 
			}else{
				temp[tempIndex++] = array[secondArrayIndex++];
			}
		}
		//如果是第一个分组剩下元素
		while(firstArrayIndex <= center){
			temp[tempIndex++] = array[firstArrayIndex++];
		}
		//如果是第二个分组剩下元素
		while(secondArrayIndex <= right){
			temp[tempIndex++] = array[secondArrayIndex++];
		}
		//把临时数组覆盖到原数组中
		while(left <= right){
			array[left] = temp[left++];
		}
	}
	
	public static void main(String[] args) {
		mergeSort(new int[]{0, 1, 2, 3, 1, 3, 6, 7, 1, 9, -1});
		mergeSort(new int[]{0, 1, 0, 3, 1, 3, 6, 7, 1, 9});
		mergeSort(new int[]{0, 1, 2, 0, 1, 2});
	}
	
}
