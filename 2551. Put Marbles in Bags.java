class Solution {
  public long putMarbles(int[] weights, int k) {
    int[] A = new int[weights.length - 1]; 
    long min = 0;
    long max = 0;

    for (int i = 0; i < A.length; ++i)
      A[i] = weights[i] + weights[i + 1];

    Arrays.sort(A);

    for (int i = 0; i < k - 1; ++i) {
      min += A[i];
      max += A[A.length - 1 - i];
    }

    return max - min;
  }
}
