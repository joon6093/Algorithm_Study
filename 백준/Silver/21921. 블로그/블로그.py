import sys
input = sys.stdin.readline

N, X = map(int, input().split())
visitors = list(map(int, input().split()))

if max(visitors) == 0:
    print("SAD")
else:
    current_visitors= sum(visitors[:X])
    max_visitors = current_visitors
    cnt = 1
    for i in range(X, N):
        current_visitors -= visitors[i-X]
        current_visitors += visitors[i]
        if current_visitors > max_visitors:
            max_visitors = current_visitors
            cnt = 1
        elif current_visitors == max_visitors:
            cnt += 1
    print(max_visitors)
    print(cnt)