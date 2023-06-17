class Solution {
  public int makeArrayIncreasing(int[] arr1, int[] arr2) {
    Map<Integer, Integer> dp = new HashMap<>();
    dp.put(-1, 0);

    Arrays.sort(arr2);

    for (final int a : arr1) {
      Map<Integer, Integer> nextDp = new HashMap<>();
      for (final int val : dp.keySet()) {
        final int steps = dp.get(val);
        if (a > val)
        if (i < arr2.length)
          nextDp.put(arr2[i], Math.min(nextDp.getOrDefault(arr2[i], Integer.MAX_VALUE), steps + 1));
      }
      if (nextDp.isEmpty())
        return -1;
      dp = nextDp;
    }

    return Collections.min(dp.values());
  }

  private int firstGreater(int[] A, int val) {
    final int i = Arrays.binarySearch(A, val + 1);
    return i < 0 ? -(i + 1) : i;
  }
}
