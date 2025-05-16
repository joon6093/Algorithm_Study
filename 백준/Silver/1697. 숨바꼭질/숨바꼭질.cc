#define _CRT_SECURE_NO_WARNINGS
#define _USE_MATH_DEFINES
#include <bits/stdc++.h>
typedef long long ll;
typedef unsigned long long ull;
using namespace std;
const ll INF = 987'654'321;

vector<int> arr;
vector<int> visited;  // 여기서 인덱스 값 = 위치, 내부 값은 최저 거리

bool able(int i) {
    // 여기가 100000도 허용하게 해 줘야 합니다!!!!
    // 입력 범위는 0~ 100'000 니까요
    // i >= 100000 -> i > 100000
    if (i < 0 || i > 100000) {
        return false;
    }
    return true;
}

void bfs(int start) {
    queue<pair<int, int>> q;
    q.push({start, 0});
    visited[start] = 0;

    while (!q.empty()) {
        int current = q.front().first;
        int cost = q.front().second + 1;
        q.pop();

        vector<int> nexts = {current + 1, current - 1, current * 2};
        for (int next : nexts) {
            if (!able(next)) continue;
            if (cost >= visited[next]) continue;

            q.push({next, cost});
            visited[next] = cost;
        }
    }
}

int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int start, end;
    cin >> start >> end;
    arr = vector<int>(100001);
    visited = vector<int>(100001, INF);
    bfs(start);

    int result = visited[end];
    cout << result << "\n";

    return 0;
}
