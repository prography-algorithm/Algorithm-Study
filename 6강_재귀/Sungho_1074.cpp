#include <bits/stdc++.h>
using namespace std;

int n, r, c;
//왼쪽 위 꼭지점이 x, y이고 한 변의 길이가 n인 사각형에서 r, c를 방문하는 순서를 반환하는 함수
int solve(int n, int x, int y){
    //기저사례: 길이가 1일경우 0 반환
    if(n == 1) return 0;
    int nxtN = n / 2;
    //1사분면
    if(r < x + nxtN && c < y + nxtN)
        return solve(nxtN, x, y);
    //2사분면
    if(r < x + nxtN && c >= y + nxtN)
        return solve(nxtN, x, y + nxtN) + nxtN * nxtN;
    //3사분면
    if(r >= x + nxtN && c < y + nxtN)
        return solve(nxtN, x + nxtN, y) + 2 * nxtN * nxtN;
    //4사분면
    if(r >= x + nxtN && c >= y + nxtN)
        return solve(nxtN, x + nxtN, y + nxtN) + 3 * nxtN * nxtN;
}

int main(void){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> r >> c;
    cout << solve(pow(2, n), 0, 0);
    return 0;
}