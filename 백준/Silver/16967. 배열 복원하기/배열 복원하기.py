import sys

input = sys.stdin.readline
H, W, X, Y = map(int,input().split())
arr = [list(map(int, sys.stdin.readline().rstrip().split())) for _ in range(H+X)]

answer=  [[0 for _ in range(W)] for _ in range(H)]


for i in range(H):
    for j in range(W):
        if i<X or j<Y:
            answer[i][j]=arr[i][j]
        else:
            answer[i][j]=arr[i][j]-answer[i-X][j-Y]
        print(answer[i][j], end=' ')
    print()
