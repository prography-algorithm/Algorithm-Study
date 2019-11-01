#include <bits/stdc++.h>
using namespace std;

int n;
char a[7000][7000];
//시작점이 x, y이고 길이가 n인 사각형에 문제에 적힌 조건대로 문자 c를 채우는 함수
void solve(int n, int x, int y){
    //기저사례: 길이가 3일경우 모양을 채워줌
    if(n == 3){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == 1 && j == 1) continue;
                a[x + i][y + j] = '*';
            }
        }
        return;
    }
    int nxtN = n / 3;
    //가운데가 빈 사각형 형태이므로 가운데 사각형일때만 비워줌
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            if(i == 1 && j == 1) continue;
            solve(nxtN, x + i * nxtN, y + j * nxtN);
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    solve(n, 0, 0);
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(!a[i][j]) cout << ' ';
            else cout << a[i][j];
        }
        cout << '\n';
    }
    return 0;
}