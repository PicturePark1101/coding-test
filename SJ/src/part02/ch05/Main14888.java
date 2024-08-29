package part02.ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14888 {

  private static int[] nums;
  private static String[] op;
  private static String[] bucket;
  private static boolean[] visited;
  private static int max;
  private static int min;


  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());

    nums = new int[N];
    op = new String[N - 1];
    bucket = new String[N - 1];
    visited = new boolean[N - 1];
    max = Integer.MIN_VALUE;
    min = Integer.MAX_VALUE;

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    int idx = 0;
    for (int i = 0; i < 4; i++) {
      int operationNums = Integer.parseInt(st.nextToken());
      for (int j = 0; j < operationNums; j++) {
        op[idx++] = chooseOperator(i);
      }
    }

    dfs( 0);

    System.out.println(max);
    System.out.println(min);

    br.close();
  }

  private static void dfs(int depth) {

    if (depth == op.length) {
      int result = calc();
      max = Math.max(max, result);
      min = Math.min(min, result);
      return;
    }

    for (int i = 0; i < op.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        bucket[depth] = op[i];
        dfs(depth + 1);
        visited[i] = false;
      }
    }
  }

  private static String chooseOperator(int i){
    switch (i) {
      case 0 -> { return "+"; }
      case 1 -> { return "-"; }
      case 2 -> { return "*"; }
      case 3 -> { return "/"; }
    }
    return null;
  }

  private static int calc () {
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      switch (bucket[i - 1]) {
        case "+" -> result += nums[i];
        case "-" -> result -= nums[i];
        case "*" -> result *= nums[i];
        case "/" -> {
          if (result < 0) {
            result = - (Math.abs(result) / nums[i]);
          } else {
            result /= nums[i];
          }
        }
      }
    }
    return result;
  }
}