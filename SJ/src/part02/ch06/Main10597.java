package part02.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10597 {
  private static int[] bucket;
  private static boolean[] visited;
  private static StringBuilder sb;
  private static int[] str;
  private static boolean findAns;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] inputStr = br.readLine().split("");

    str = new int[inputStr.length];
    bucket = new int[inputStr.length];
    visited = new boolean[51];
    sb = new StringBuilder();

    for (int i = 0; i < str.length; i++) {
      str[i] =  Integer.parseInt(inputStr[i]);
    }

    makeArr(0, 0);
    System.out.println(sb);
    br.close();
  }

  private static void makeArr(int depth, int size) {

    if (findAns) {
      return;
    }

    if (depth >= str.length) {
      for (int i = 1; i <= size; i++) {
        if (!visited[i]) return;
      }
      findAns = true;
      for (int i = 0; i < size; i++) {
        sb.append(bucket[i]).append(" ");
      }
      sb.append("\n");
      return;
    }

    int num = str[depth];
    if (num != 0 && !visited[num]) {
      bucket[size] = num;
      visited[num] = true;
      makeArr(depth + 1, size + 1);
      visited[num] = false;
    }

    if (depth + 1 != str.length) {
      num = str[depth] * 10 + str[depth + 1];
      if (num <= 50 &&  !visited[num])  {
        bucket[size] = num;
        visited[num] = true;
        makeArr(depth + 2, size + 1);
        visited[num] = false;
      }
    }
  }
}