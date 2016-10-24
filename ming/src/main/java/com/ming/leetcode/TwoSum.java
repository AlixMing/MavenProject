package com.ming.leetcode;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		int size = nums.length;
		for(int i = 0; i < size -1; i++){
			for(int j = i+1; j < size; j++){
				if((nums[i] + nums[j]) == target){
					result[0] = i;
					result[1] = j;
					break;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] result = twoSum(new int[]{1,3,2}, 3);
		for (int i : result) {
			System.out.println(i);
		}
	}
	

}
