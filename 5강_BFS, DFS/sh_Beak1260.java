// 내코드아냐ㅠ
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Beak1260 {

    static int n;// 정점 개수
    static ArrayList<Integer>[] list;
    static boolean[] check;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 정점 개수
        int m = sc.nextInt(); // 간선 개수
        int start = sc.nextInt();

        list = new ArrayList[n+1]; // n+1 인 이유는?
        // <Integer> 타입 체크가 안전하지 않다고 한다
        // 행마다 new ArrayList<Integer> 생성해서 괜찮다

        for(int i=1; i<n+1 ; i++){ // [1,n]
            list[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){ // 간선 개수
            int u = sc.nextInt();
            int v = sc.nextInt();

            list[u].add(v);
            list[v].add(u); // 메모리 공간을 최소한으로 사용하려고 ArrayList[] 사용
        }
        // 입력받기 끝?

        for(int i=1; i<n+1; i++){ // [1,n]
            Collections.sort(list[i]); // 행에 대해 ArrayList 정렬 - 기본:오름차?
        }

        check = new boolean[n+1];
        dfs(start);
        

        check = new boolean[n+1];
        bfs(start);

        sc.close();
    }

    private static void dfs(int x){ // 전혀 스택을 사용하지 않네..
        if(check[x]){ // 이미 방문한 노드
            return;
        }

        check[x] = true;
        System.out.print(x+" ");
        for(int y:list[x]){
            if(!check[y])
            dfs(y);
        }
    }

    private static void bfs(int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start); // 시작노드 삽입
        check[start] = true;

        while(!queue.isEmpty()){ // 큐가 비어있지 않으면 반복
            int x = queue.poll(); // 현재 노드 꺼낸다
            System.out.print(x+" ");
            for(int y:list[x]){
                if(!check[y]){ //방문한 노드가 아니라면
                    check[y] = true; // 방문 표시
                    queue.add(y); // 큐에 삽입
                }
            }
        }
    }
}

