package part02.ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1182 {

  private static int[] nums;
  private static int count;
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

    dfs(0, 0);

    if (S == 0) count--;
    System.out.println(count);

    br.close();
  }

  private static void dfs(int idx, int cntSum) {
    if (nums.length == idx) {
      if (cntSum == S) count++;
      return;
    }

    dfs(idx + 1, cntSum + nums[idx]);
    dfs(idx + 1, cntSum);
  }
}