/*There are two mice and n different types of cheese, each type of cheese should be eaten by exactly one mouse.

A point of the cheese with index i (0-indexed) is:

reward1[i] if the first mouse eats it.
reward2[i] if the second mouse eats it.
You are given a positive integer array reward1, a positive integer array reward2, and a non-negative integer k.

Return the maximum points the mice can achieve if the first mouse eats exactly k types of cheese.*/

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int[][] arr = new int[n][2];
        for(int i = 0; i < reward2.length; i++){
            arr[i] = new int[] {(reward1[i] - reward2[i]) , i};
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        int points = 0;
        for(int i = 0 ; i < k ; i++){
            points += reward1[arr[i][1]];
        }
        for(int i = k; i < n; i++){
            points += reward2[arr[i][1]];
        }
    return points;
    }
}