
//Binary Search  :- Time complexity in best case-> 0(1) , wrost case-> o(logn) , Average case-> o)logn 
//Space complexity :- 0(1) 

import java.util.*;

public class Main2 {

    public static boolean isBadVersion(int val) {
        int bad = 10;
        if (val >= bad) {
            return true;
        }
        return false;
    }

    public static void FirstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)){
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }  
        }
        System.out.println(ans);;
        
    }

    public static void SubsetOfArray(int[] arr) {
        int n = arr.length;
        int total = (int) Math.pow(2, n);

        for (int i = 0; i < total; i++) {
            int temp = i;
            String str = "";

            for (int j = n - 1; j >= 0; j--) {
                int rem = temp % 2;
                temp = temp / 2;
                if (rem == 0) {
                    str = "_ " + str;
                } else {
                    str = arr[j] + " " + str;
                }
            }

            System.out.println(str);
        }
    }

    public static int CeilAndFloor(int[] arr, int target, int iteration) {
        int lo = 0;
        int hi = arr.length - 1;
        int ceil = 0;
        int floor = 0;

        while (lo <= hi) {
            int mid = (hi + lo) + 1 / 2;

            if (arr[mid] == target) {
                ceil = arr[mid];
                floor = arr[mid];
                iteration++;
                break;
            }

            else if (arr[mid] < target) {
                floor = arr[mid];
                lo = mid + 1;
                iteration++;
            } else {
                ceil = arr[mid];
                hi = mid - 1;
                iteration++;
            }

        }

        System.out.println("Ceil is:- " + ceil + " " + "Floor:- " + floor);

        return iteration;

    }

    public static int binarySearch(int[] arr, int target, int iterations) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) + 1 / 2;
            if (target == arr[mid]) {
                System.out.println("Index of taregt:- " + mid);
                iterations++;
                break;
            } else if (target < arr[mid]) {
                hi = mid - 1;
                iterations++;
            } else {
                lo = mid + 1;
                iterations++;
            }
        }

        if (lo > hi) {
            System.out.println("Not found");
            // break;
        }
        return iterations;
    }

    public static int FirstAndLastIdx(int[] arr, int target, int iteration) {
        int stIdx = 0;
        int ltIdx = arr.length - 1;
        int FirstIdx = -1;
        int LastIdx = -1;

        while (stIdx <= ltIdx) {

            int mid = (ltIdx + stIdx) + 1 / 2;
            if (arr[mid] == target) {
                FirstIdx = mid;
                ltIdx = mid - 1;
                iteration++;
            }

            else if (arr[mid] < target) {
                stIdx = mid + 1;
                iteration++;
            } else {
                ltIdx = mid - 1;
                iteration++;
            }
        }

        stIdx = 0;
        ltIdx = arr.length - 1;

        while (stIdx <= ltIdx) {
            int mid = (ltIdx + stIdx) + 1 / 2;

            if (arr[mid] == target) {
                LastIdx = mid;
                stIdx = mid + 1;
                iteration++;
            }

            else if (arr[mid] < target) {
                stIdx = mid + 1;
                iteration++;
            } else {
                ltIdx = mid - 1;
                iteration++;
            }

        }

        System.out.println("FirstIndex = " + FirstIdx + " , " + "LastIndex = " + LastIdx);

        return iteration;
    }

    public static void main(String[] args) {
        // Scanner scn = new Scanner(System.in);
        // int[] arr = { 1, 2, 3 };
        int k = 32;
        FirstBadVersion(k);
        // SubsetOfArray(arr);

        // int iterations = FirstAndLastIdx(arr, k, 0);
        // System.out.println("Iternations are to search this target is:- " +
        // iterations);

    }
}
