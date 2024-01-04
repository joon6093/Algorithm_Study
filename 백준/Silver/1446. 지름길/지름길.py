import sys
input = sys.stdin.readline

N, D = map(int, input().strip().split())
shortcut_list = [list(map(int,input().strip().split())) for _ in range(N)]

high_way = [0] * (D+1)

for i in range(1,D+1):
    high_way[i] = high_way[i-1] + 1
    for j in range(N):
        if shortcut_list[j][1] == i:
            high_way[i] = min(high_way[shortcut_list[j][0]] + shortcut_list[j][2],high_way[i])

print(high_way[D])
    