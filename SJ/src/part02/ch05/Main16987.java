package part02.ch05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16987 {

  private static Egg[] eggs;
  private static int result;
  private static int N;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N  = Integer.parseInt(br.readLine());
    eggs = new Egg[N];
    result = Integer.MIN_VALUE;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    dfs(0, 0);
    System.out.println(result);
    br.close();
  }

  private static void dfs(int depth, int count) {

    if (depth == N || count == N  - 1) {
      result = Math.max(result, count);
      return;
    }

    if (eggs[depth].durability <= 0) { // 지금의 계란이 꺠져있음
      dfs(depth + 1, count); // 다음 계란으로 넘어가기
      return;
    }

    for (int i = 0; i < N; i++) {
      if (i != depth && eggs[i].durability > 0) { // 자기 자신은 제외. 상대 계란이 0보다 큰 경우만 깨기
        // 계란 깨기
        eggs[depth].knockEgg(eggs[i]);
        eggs[i].knockEgg(eggs[depth]);

        int currentCount = count;

        if (eggs[depth].durability <= 0) currentCount++;
        if (eggs[i].durability <= 0) currentCount++;
        dfs(depth + 1, currentCount); // 현재의 누적 값을 가지고 다음 계란으로 넘어간다.

        eggs[depth].restoreEgg(eggs[i]);
        eggs[i].restoreEgg(eggs[depth]);
      }
    }
  }
}

class Egg {
    int durability;
    int weight;

  public Egg(int durability, int weight) {
    this.durability = durability;
    this.weight = weight;
  }

  public void knockEgg(Egg egg) {
    this.durability -= egg.weight;
  }

  public void restoreEgg(Egg egg) {
    this.durability += egg.weight;
  }
}