package part02.ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14888V2 {

  private static int[] nums;
  private static int[] opNum;
  private static int max;
  private static int min;


  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());

    nums = new int[N];
    opNum = new int[4];
    max = Integer.MIN_VALUE;
    min = Integer.MAX_VALUE;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      opNum[i] = Integer.parseInt(st.nextToken());
    }

    dfs(1, nums[0]);

    System.out.println(max);
    System.out.println(min);

    br.close();
  }

  private static void dfs(int depth, int result) {

    if (depth == nums.length) {
      max = Math.max(max, result);
      min = Math.min(min, result);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (opNum[i] > 0) {
        opNum[i]--;
        switch (i) {
          case 0 -> dfs(depth + 1, result + nums[depth]);
          case 1 -> dfs(depth + 1, result - nums[depth]);
          case 2 -> dfs(depth + 1, result * nums[depth]);
          case 3 -> dfs(depth + 1, result / nums[depth]);
        }
        opNum[i]++;
      }
    }
  }
}