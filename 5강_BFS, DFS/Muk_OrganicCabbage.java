import java.util.*;

public class Muk_OrganicCabbage {
  static Queue<Integer> qx = new LinkedList<Integer>();
  static Queue<Integer> qy = new LinkedList<Integer>();
  static int dx[] = { 0, 0, -1, 1 };
  static int dy[] = { 1, -1, 0, 0 };
  static int arr[][];
  static boolean visit[][];

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int loop = scan.nextInt();

    for (int l = 0; l < loop; l++) {
      int earthworm = 0;

      int cols = scan.nextInt();
      int row = scan.nextInt();
      int cabbage = scan.nextInt();

      arr = new int[row][cols];
      visit = new boolean[row][cols];

      for (int i = 0; i < cabbage; i++) {
        int y = scan.nextInt();
        int x = scan.nextInt();
        arr[x][y] = 1;
      }

      for (int j = 0; j < row; j++) {
        for (int k = 0; k < cols; k++) {
          if (arr[j][k] == 1 && !visit[j][k]) {
            earthworm++;
            qx.offer(j);
            qy.offer(k);

            BFS();
          }
        }
      }

      System.out.println(earthworm);
    }
    scan.close();

  }

  public static void BFS() {
    while (!qx.isEmpty()) {
      int x = qx.poll();
      int y = qy.poll();

      visit[x][y] = true;

      for (int i = 0; i < 4; i++) {
        int _x = x + dx[i];
        int _y = y + dy[i];

        if (_x < 0 || _x >= visit.length || _y < 0 || _y >= visit[i].length) {
          continue;
        }
        if (arr[_x][_y] == 1 && !visit[_x][_y]) {
          qx.offer(_x);
          qy.offer(_y);
          visit[_x][_y] = true;
        }
      }
    }
  }
}
