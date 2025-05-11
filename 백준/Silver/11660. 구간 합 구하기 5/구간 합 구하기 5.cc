#define _CRT_SECURE_NO_WARNINGS
#define _USE_MATH_DEFINES
#include <bits/stdc++.h>
typedef long long ll;
typedef unsigned long long ull;
using namespace std;
const ll INF = 987'654'321;

int main() {
#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);


		// n*n 2차 배열을 입력받는다.
    int n, q;
    cin >> n >> q;
    vector<vector<int>> arr(n + 1, vector<int>(n + 1));
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            cin >> arr[i][j];
        }
    }
	
		// 2차 누적합 배열을 생성한다.
    vector<vector<int>> sum(n + 1, vector<int>(n + 1));
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
		        // 무엇을 빼고, 무엇을 더한 것일까요??
		        // 그림이 기억나시나요?
            sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + arr[i][j];
        }
    }
		
		// q개의 쿼리문을 처리한다.
    while (q-- > 0) {
        int a, b, c, d;
        cin >> a >> b >> c >> d;

        int result =
            sum[c][d] - sum[a - 1][d] - sum[c][b - 1] + sum[a - 1][b - 1];
        cout << result << "\n";
    }
    
    return 0;
}
