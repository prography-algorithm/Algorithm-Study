// 내코드아냐ㅠ
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Beak1012{

    static int h,w,kk,count;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args){

        // 왜 BufferedReader를 사용했을까? 한번에 읽으려고?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        for(int q=0; q<k; q++){ // k번 - 테스트 케이스 개수
            String[] a = br.readLine().split(" "); // 가로,세로,배추개수
            h = Integer.parseInt(a[1]); // 세로
            w = Integer.parseInt(a[0]); // 가로
            kk = Integer.parseInt(a[2]); // 배추개수
            count = 0; // 뭘 count ? 영역을 세는 거였다

            map = new int[h][w]; // 배추밭
            visited = new boolean[h][w]; // 방문여부 체크 ?

            for(int i=0; i<kk; i++){ // 배추개수
                String[] str = br.readLine().split(" ");
                // 배추밭에 좌표 정보 토대로 저장
                map[Integer.parseInt(str[1])][Integer.parseInt(str[0])] = 1;
            }

            for(int i=0; i<h; i++){ // 세로 - 행에 대해
                for(int j=0; j<w; j++){ // 열에 대해
                    if(!visited[i][j] && map[i][j]==1){ // 방문하지 않았고, 배추가 있으면
                        bfs(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count); // 영역 수
        }//end for
    }

    static Queue<dot> q = new LinkedList<>();
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    static void bfs(int a, int b){
        visited[a][b] = true;
        q.add(new dot(a,b));

        while(!q.isEmpty()){ // 비어있지 않으면 반복
            dot v = q.poll(); // 현재 노드 꺼낸다

            for(int i=0; i<dx.length; i++){
                int x2 = v.x + dx[i];
                int y2 = v.y + dy[i];

                // 배추밭 벗어나지 않았는지 확인
                // 배추가 있는지 확인
                // 방문하지 않았는지 확인
                if(x2>=0 && x2<h && y2>=0 && y2<w &&
                    map[x2][y2]==1 && !visited[x2][y2]]){
                        visited[x2][y2] = true; // 방문 표시
                        q.add(new dot(x2,y2)); // 큐에 삽입
                }
            }
        }
    }
}

class dot{ // 노드
    int x;
    int y;

    public dot(int x, int y){
        this.x = x;
        this.y = y;
    }
}