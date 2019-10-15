import java.util.*;

public class Muk_Maze {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int row = scan.nextInt();
    int cols = scan.nextInt();

    int arr[][] = new int[row][cols];

    for (int i = 0; i < row; i++) {
      String str = scan.next();

      for (int j = 0; j < cols; j++) {
        arr[i][j] = str.charAt(j) - '0';
      }
    }
    scan.close();

    int dist[][] = new int[row][cols];
    dist[0][0] = 1;

    Queue<Integer> qx = new LinkedList<Integer>();
    Queue<Integer> qy = new LinkedList<Integer>();
    boolean visit[][] = new boolean[row][cols];
    int dx[] = { 0, 0, -1, 1 };
    int dy[] = { 1, -1, 0, 0 };

    qx.offer(0);
    qy.offer(0);

    int x, y;
    int _x, _y;

    while (qx.peek() != null) {
      x = qx.poll();
      y = qy.poll();

      visit[x][y] = true;

      for (int i = 0; i < 4; i++) {
        _x = x + dx[i];
        _y = y + dy[i];

        if (_x < 0 || _x >= row || _y < 0 || _y >= cols) {
          continue;
        }

        if (arr[_x][_y] == 1 && !visit[_x][_y]) {
          qx.offer(_x);
          qy.offer(_y);

          visit[_x][_y] = true;

          dist[_x][_y] += dist[x][y] + 1;
        }

      }
    }

    System.out.println(dist[row - 1][cols - 1]);
  }
}
