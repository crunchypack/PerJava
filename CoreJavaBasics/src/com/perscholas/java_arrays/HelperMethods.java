package com.perscholas.java_arrays;

public class HelperMethods {
	public static void Sort(int[] values) {
		int[] tempValues = values.clone();
		Sort(tempValues,0,values.length, values);
		
	}
	public static void Sort(int[] tempValues, int i0, int i1, int[] values) {
		if(i1 - i0 < 2) return;
		int iMid = (i0 + i1)/2;
		Sort(values, i0, iMid,tempValues);
		Sort(values, iMid,i1,tempValues);
		Merge(tempValues, i0, iMid,i1, values);
		
	}
	public static void Merge(int[] source, int iBegin, int iMid, int iEnd, int[] dest) {
		int i = iBegin, j = iMid;
		for(int k = iBegin; k < iEnd; k++) {
			if(i<iMid && (j>= iEnd || source[i] <= source[j])) {
				dest[k] = source[i++];
			}else {
				dest[k] = source[j++];
			}
		}
	}
	public static int getLargeIndex(int[] values) {
		if(values.length != 0) {
			int max = values[0];
			int maxIndex = 0;
			for(int i= 1; i < values.length; ++i) {
				if(values[i] > max) {
					max = values[i];
					maxIndex = i;
				}
			}
			return maxIndex;
		}else {
			return 0;
		}
		
	}
	public static int getSmallIndex(int[] values) {
		if(values.length != 0) {
			int min = values[0];
			int minIndex = 0;
			for(int i= 1; i < values.length; ++i) {
				if(values[i] < min) {
					min = values[i];
					minIndex = i;
				}
			}
			return minIndex;
		}else {
			return 0;
		}
		
	}
	
}
