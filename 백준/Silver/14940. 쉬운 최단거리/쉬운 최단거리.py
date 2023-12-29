import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().strip().split())
miro = [list(map(int, input().strip().split())) for _ in range(N)]
move=[[0,-1],[0,1],[-1,0],[1,0]]
visited = [[0]  * M for _ in range(N)]
start_row = 0
start_col = 0
for i in range(N):
    if 2 in miro[i]:
        start_col = miro[i].index(2)
        start_row = i
        break

queue= deque()
queue.append([start_row,start_col])
miro[start_row][start_col] = 0
visited[start_row][start_col] = 1
while queue:
    row,col = queue.popleft()
    for i in move:
        move_row=row+i[0]
        move_col=col+i[1]   
        if(move_row<0 or move_row>N-1 or move_col<0 or move_col>M-1 or miro[move_row][move_col] == 0 or visited[move_row][move_col] == 1):
            continue
        visited[move_row][move_col] = 1
        miro[move_row][move_col]=miro[row][col]+1
        queue.append([move_row,move_col])

for i in range(N):
    for j in range(M):
        if miro[i][j] != 0 and visited[i][j] == 0:
            miro[i][j] = -1
for i in range(N):
    print(*miro[i])
