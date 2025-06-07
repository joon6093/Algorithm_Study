#define _CRT_SECURE_NO_WARNINGS
#define _USE_MATH_DEFINES
#include <bits/stdc++.h>
typedef long long ll;
typedef unsigned long long ull;
using namespace std;
const ll INF = 987'654'321;

vector<int> result(2);

// 세로 위치, 가로위치, 확인해야 하는 개수, 전체 배열
void dfs(int i, int j, int n, vector<vector<int>>& arr) {
    // 기저 사례 n = 1 인 경우 그 색상을 저장한다.
    if (n == 1) {
        // 1개짜리면 그냥 그 색상으로 처리
        result[arr[i][j]] += 1;
        return;
    }

    // 확인해야 하는 범위에는 시작 위치의 색상과 모두 일치해야 한다.
    int start_color = arr[i][j];
    for (int y = i; y < i + n; ++y) {
        for (int x = j; x < j + n; ++x) {
            if (start_color != arr[y][x]) {
                // 다르다!!!
                // 쪼개야 한다!!!
                int half = n / 2;
                dfs(i, j, half, arr);                // 왼쪽 위
                dfs(i, j + half, half, arr);         // 오른쪽 위
                dfs(i + half, j, half, arr);         // 왼쪽 아래
                dfs(i + half, j + half, half, arr);  // 오른쪽 아래
                return;
            }
        }
    }
    // 다 일치했어!
    result[start_color] += 1;
}

int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    // 전체 크기 N
    int n;
    cin >> n;

    vector<vector<int>> arr(n, vector<int>(n));
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> arr[i][j];
        }
    }

    // 세로 위치, 가로위치, 확인해야 하는 범위, 전체 배열
    dfs(0, 0, n, arr);
    cout << result[0] << "\n"
         << result[1] << "\n";

    return 0;
}
