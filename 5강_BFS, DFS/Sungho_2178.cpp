#include <iostream>
#include <queue>
#include <algorithm>
#include <string>
using namespace std;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
int n, m;
int a[101][101], v[101][101];
int main(void){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> n >> m;
    for(int i = 0; i < n; i++){
        string s;
        cin >> s;
        for(int j = 0; j < m; j++){
            a[i][j] = s[j] - '0';
        }
    }
    queue<pair<int, int>> q;
    q.push({0, 0});
    v[0][0] = 1;
    while(q.size()){
        int x = q.front().first, y = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i], ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(!a[nx][ny] || v[nx][ny]) continue;
            q.push({nx, ny});
            v[nx][ny] = v[x][y] + 1;
        }
    }
    cout << v[n - 1][m - 1];
    return 0;
}