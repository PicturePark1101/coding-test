package part02.ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6603 {

  static int[] nums;
  static int[] bucket;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int K = Integer.parseInt(st.nextToken());
    while (K != 0) {
      nums = new int[K];
      bucket = new int[K];
      for (int i = 0; i < K; i++) {
        nums[i] = Integer.parseInt(st.nextToken());
      }
      dfs(0, 0, 6);
      st = new StringTokenizer(br.readLine());
      K = Integer.parseInt(st.nextToken());
      System.out.println();
    }
  }

  private static void dfs(int start, int pick, int N) {
    if (N == pick) {
      for (int i = 0; i < N; i++) {
        System.out.print(bucket[i]+ " ");
      }
      System.out.println();
      return;
    }

    for (int i = start; i < nums.length; i++) {
      bucket[pick] = nums[i];
      dfs(i + 1, pick + 1, N) ;
    }
  }
}