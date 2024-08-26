package part02.ch05;

import java.io.*;
import java.util.*;

public class Main1759 {

  private static char[] chars;
  private static char[] bucket;

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int L = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    chars = new char[C];
    bucket = new char[L];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < C; i++) {
      chars[i] = st.nextToken().charAt(0);
    }

    Arrays.sort(chars);
    dfs(0, 0, L);

    br.close();
  }

  private static void dfs(int idx, int pick, int N) {

    if (pick == N) {
      if (isValid()) {
        for (char c : bucket) {
          System.out.print(c);
        }
        System.out.println();
      }
      return;
    }

    for (int i = idx; i < chars.length; i++) {
      bucket[pick] = chars[i];
      dfs(i + 1, pick + 1, N);
    }
  }

  private static boolean isValid() {

    int vCount = 0;
    int cCount = 0;

    for (char c : bucket) {
      if (c == 'a'|| c == 'e'|| c == 'i' || c == 'o' || c == 'u')
        vCount++;
      else
        cCount++;
    }

    if (vCount >= 1 && cCount >= 2) return true;
    return false;
  }
}