package part02.ch05;

import java.util.*;
import java.io.*;

public class Main1208 {
  private static int[] nums;
  private static int S;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    nums = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    Map<Integer, Long> leftMap = new HashMap<>();
    Map<Integer, Long> rightMap = new HashMap<>();

    makeSumList(0, N / 2, 0, leftMap);
    makeSumList(N / 2, N, 0, rightMap);

    List<Integer> leftMapKeyList = new ArrayList<>(leftMap.keySet());
    List<Integer> rightMapKeyList = new ArrayList<>(rightMap.keySet());

    leftMapKeyList.sort(Comparator.naturalOrder());
    rightMapKeyList.sort(Comparator.naturalOrder());

    long ans = calc(leftMap, rightMap, leftMapKeyList, rightMapKeyList);
    if (S == 0) ans --;
    System.out.println(ans);

    br.close();
  }

  private static long calc(Map<Integer, Long> leftMap, Map<Integer, Long> rightMap, List<Integer> leftMapKeyList, List<Integer> rightMapKeyList) {

    long result = 0;
    int leftPointer = 0;
    int rightPointer = rightMapKeyList.size() - 1;

    while (leftPointer < leftMapKeyList.size() && rightPointer >= 0) {
      int sum = leftMapKeyList.get(leftPointer) + rightMapKeyList.get(rightPointer);
      if (sum == S) {
        result += leftMap.get(leftMapKeyList.get(leftPointer)) * rightMap.get(rightMapKeyList.get(rightPointer));
        leftPointer++;
        rightPointer--;
      } else if (sum > S){
        rightPointer--;
      } else {
        leftPointer++;
      }
    }
    return result;
  }

  private static void makeSumList(int idx, int end, int count, Map<Integer, Long> map) {
    if (idx == end) {
      map.put(count, map.getOrDefault(count, 0L) + 1);
      return;
    }
    makeSumList(idx + 1, end, count, map);
    makeSumList(idx + 1, end,count + nums[idx], map);
  }
}