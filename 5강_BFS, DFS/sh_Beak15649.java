// 내코드아냐ㅠ
import java.util.Scanner;

class Beak15649{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[M]; // 크기 왜? 스택역할?
        // 순열 길이!

        dfs(arr,0,N);
    }

    // i가 현재노드?
    public static void dfs(int[] arr, int i, int N){
        if(i == arr.length){ // (순열 길이이면)
            for(int j=0;j<arr.length; j++){ // 배열(순열) 길이만큼
                if(!contain(arr,j,i)){ // [0,i-1] for j를 찾으면 true
                    arr[i] = j;
                    dfs(arr, i+1, N);
                }
            }
        }else{ // 순열 길이가 아니면
            for(int j=1;j<=N;j++){ // 입력받은 수 길이만큼
                if(!contain(arr,j,i)){ // [0,i-1] for j를 찾으면 true
                    // 찾지 못하면 if문 수행하겠다
                    arr[i] = j;
                    dfs(arr,i+1,N);
                }

            }
        }
    }

    public static boolean contain(int[] arr, int find, int k){
        for(int i=0;i<k;i++){
            if(arr[i] == find) return true;
        }
        return false;
    }
}



