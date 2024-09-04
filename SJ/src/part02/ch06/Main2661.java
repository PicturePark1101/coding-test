package part02.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2661 {

  private static int N;
  private static final String[] numsStr = {"1", "2", "3"};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    makeArr(0, "", "");
    br.close();
  }

  private static void makeArr(int depth, String arr, String beforeChar) {
    if (depth == N) {
      System.out.println(arr);
      System.exit(0);
      return;
    }

    for (int i = 0; i < 3; i++) {
      if (!beforeChar.equals(numsStr[i]) && isValid(arr + numsStr[i])) {
        makeArr(depth + 1, arr + numsStr[i], numsStr[i]);
      }
    }
  }

  private static boolean isValid(String arr) {
    int strLength = arr.length();
    for (int i = 2; i <= strLength / 2; i++) {
      String str1 = arr.substring(strLength - i, strLength);
      String str2 = arr.substring(strLength - i  * 2, strLength - i);
      if (str1.equals(str2)) return false;
    }
    return true;
  }
}