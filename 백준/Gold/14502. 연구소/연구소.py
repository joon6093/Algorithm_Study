
from collections import deque
import copy
import sys
input = sys.stdin.readline
move=[[-1,0],[1,0],[0,-1],[0,1]]

def check(map):
    queue = deque()
    global result
    temp_map=copy.deepcopy(map)
    for i in range(N):
        for j in range(M):
            if temp_map[i][j] == 2:
                queue.append((i, j))
    while queue:
        x, y = queue.popleft()

        for move_x,move_y in move:
            new_x=x+move_x
            new_y=y+move_y

            if new_x < 0 or new_x >= N or new_y < 0 or new_y >= M:
                continue
            if temp_map[new_x][new_y] == 0:
                temp_map[new_x][new_y] = 2
                queue.append((new_x, new_y))
    song=0
    for i in range(N):
        song += temp_map[i].count(0)
    result = max(result, song)


def wall(count):
    if count == 3:
        check(map)
        return
    for i in range(N):
        for j in range(M):
            if map[i][j] == 0:
                map[i][j] = 1
                wall(count + 1)
                map[i][j] = 0

N, M = map(int,input().split())
map = [list(map(int,input().split())) for _ in range(N)]
result=0
wall(0)
print(result)