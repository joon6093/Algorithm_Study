
from collections import deque
import sys
input = sys.stdin.readline
move=[[-1,0],[1,0],[0,-1],[0,1],[-1,-1],[1,-1],[1,1],[-1,1]]

def shark():
    queue = deque()
    for i in range(N):
        for j in range(M):
            if shark_map[i][j] == 1:
                queue.append((i, j))
    while queue:
        x, y = queue.popleft()
        for move_x,move_y in move:
            new_x=x+move_x
            new_y=y+move_y
            if new_x < 0 or new_x >= N or new_y < 0 or new_y >= M:
                continue
            if shark_map[new_x][new_y] == 0:
                shark_map[new_x][new_y] = shark_map[x][y]+1
                queue.append((new_x, new_y))

    print(max(map(max, shark_map))-1)



N, M = map(int,input().split())
shark_map = [list(map(int,input().split())) for _ in range(N)]
shark()