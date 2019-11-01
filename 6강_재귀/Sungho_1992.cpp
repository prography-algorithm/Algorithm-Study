#include <bits/stdc++.h>
using namespace std;

int n;
string a[64];
//x, y를 시작점으로 하고 길이가 n인 사각형을 쿼드트리 압축하는 함수
void solve(int n, int x, int y){
    //기저사례: 사각형이 전부 같은 색인경우
    char c = a[x][y];
    int i, j;
    for(i = 0; i < n; i++){
        for(j = 0; j < n; j++)
            if(a[x + i][y + j] != c) break;
        if(j != n) break;
    }
    if(i == n){
        cout << c;
        return;
    }
    //4사분면 압축
    cout << '(';
    int nxtN = n / 2;
    solve(nxtN, x, y);
    solve(nxtN, x, y + nxtN);
    solve(nxtN, x + nxtN, y);
    solve(nxtN, x + nxtN, y + nxtN);
    cout << ')';
}

int main(void){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for(int i = 0; i < n; i++) cin >> a[i];
    solve(n, 0, 0);
    return 0;
}