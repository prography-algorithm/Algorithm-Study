//분할정복을 이용한 거듭제곱 풀이
#include <bits/stdc++.h>
using namespace std;

int a, b, c;

//a를 b번 곱한 결과를 c로 나눈 나머지를 반환하는 함수
int dpow(int a, int b){
    int ret = 1;
    //b를 이진수로 생각
    //ex) b가 10일경우 b는 1010(2)
    //a^10 == (a^8 * a^2)
    //a를 계속 거듭제곱해주며 b의 비트가 1일때만 곱해주면 된다
    while(b){
        if(b & 1) ret = (1LL * ret * a) % c;
        a = (1LL * a * a) % c;
        //b를 오른쪽으로 한 비트 이동(b /= 2와 동일)
        b >>= 1;
    }
    return ret;
}

int main(void){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> a >> b >> c;
    cout << dpow(a % c, b);
    return 0;
}