package com.xluo.sort;

import java.util.Arrays;

/**
 * 思路：先建立一个大顶堆,然后得到最大值(根节点),然后使用它与最后一个叶子节点交换,再使剩下的节点的节点进行建堆操作,
 * 	这样通过一个循环建堆,找到一个个最大值,使它独立于下一次的建堆操作之下,从而最终得到一个有序序列
 * 	如果要得到升序序列：在建堆的时候,创建小顶堆;如果要得到降序序列：在建堆的时候,创建大顶堆
 * 总结：对于堆算法,假设有n项数据,需要时行n-1次建堆,每次建堆本身耗时log2n,则其时间复杂度为O(nlog2n)
 * 	堆排序空间效率很高,它只需要一个附加程序单元用于交换,其空间效率为O(1),它是不稳定的
 * 为什么建堆时间为logn？
 * 	每次得到最有堆的过程是用parent和leftChild和rightChild结点进行比较,并且把最大值放到parent的位置上。
 * 	这个过程是constant的,然而堆其实就是一个完全二叉树,所有的调整是跟层数有关系的。一个n个节点的树层数就是logn,
 * 	那么需求最大堆的一次调整就是在一层一层地比较,如果该层的parent节点小于子节点(以大顶堆为例),那么调整该节点,每
 * 	层调整时间的常数级别,那么多少层呢?logn层,所以最大堆调整的时间复杂度就是O(logn)。那么建立最大堆不就是一个结点调整
 * 	就是logn,n个节点的时间就应该是O(nlogn)
 * 时间复杂度:O(nlogn)
 * 	空间复杂度:O(1)
 * 优点：效率快
 * 缺点：实现起来复杂、不稳定
 * 要点：倘若给堆中每一个节点都赋予一个整数值标签，根节点被标记为0，对于每一个标记为i的节a点，
 * 	其左子节点（若存在的话）被标记为2*i+1，其右子节点（若存在的话）被标记为2*i+2，
 * 	对于一个标记为i的非根节点，其父节点被标记为（i-1）/2。
 * @author luozhangjie
 *
 */
public class HeadSort {

	public static void headSort(int[] array){
		int arrayLength = array.length;
//		buildMaxHeap(array, arrayLength - 1);  创建一个大顶堆
		for(int i = 0; i < arrayLength - 1; i++){ 
			//每个循环使得根节点是一个最大的值(因为建堆得到的是大顶堆),然后让最大值跑到最后,不参与
			//下一次建堆,这样通过一次次的建堆来得到一个个最大值,最终得到一个有序序列
			buildMaxHeap(array, arrayLength - 1 - i);
			//交换根与最后一个叶子节点
			array[0] = array[0]^array[arrayLength - 1 - i];
			array[arrayLength - 1 - i] = array[0]^array[arrayLength - 1 - i];
			array[0] = array[0]^array[arrayLength - 1 - i];
		}
		System.out.println(Arrays.toString(array));
	}
	
	private static void buildMaxHeap(int[] array, int lastIndex){
		//堆的筛选操作
		for(int i = (lastIndex - 1) >> 1; i >= 0; i--){
			int k = i;
			while(k * 2 + 1 <= lastIndex){
				int biggerIndex = 2 * k + 1;
				if(biggerIndex < lastIndex){
					if(array[biggerIndex] < array[biggerIndex + 1]){
						biggerIndex++;
					}
				}
				if(array[k] < array[biggerIndex]){
					array[k] = array[k]^array[biggerIndex];
					array[biggerIndex] = array[k]^array[biggerIndex];
					array[k] = array[k]^array[biggerIndex];
					//交换完第一次后,k指向biggerIndex与其下的子节点比较看是否符合父>子这准则
					k = biggerIndex;
				}else{
					break;
				}
				System.out.println(Arrays.toString(array));
			}
		}
	}
	
	public static void main(String[] args) {
		headSort(new int[]{0, 1, 2, 3, 1, 3, 6, 7, 1, 9, -1});
		headSort(new int[]{0, 1, 0, 3, 1, 3, 6, 7, 1, 9});
		headSort(new int[]{0, 1, 2, 3, 3, 5, 5});
	}
}
