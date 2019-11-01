#include <bits/stdc++.h>
using namespace std;

int n;
vector<pair<int, int>> ans;
//solve: n개의 원판을 s에서 e로 옮긴다
void solve(int n, int s, int e){
    //기저사례 원판이 한개일 경우 s에서 e로 옮김
    if(n == 1){
        ans.emplace_back(s, e);
        return;
    }
    int nxt = 6 - (s + e);
    //n번째 원판을 e로 옮기기 위해서는 n - 1개의 원판을 s도 e도 아닌 다른 막대(nxt)로 옮긴다
    solve(n - 1, s, nxt);
    //n번째 원판을 옮김
    ans.emplace_back(s, e);
    //nxt로 옮겨뒀던 원판들을 다시 e로 옮김
    solve(n - 1, nxt, e);
}

int main(void){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    solve(n, 1, 3);
    cout << ans.size() << '\n';
    for(const auto &[x, y] : ans)
        cout << x << ' ' << y << '\n';
    return 0;
}