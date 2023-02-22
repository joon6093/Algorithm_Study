import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
miro = [list(map(int, input().rstrip())) for _ in range(N)]
move=[[0,-1],[0,1],[-1,0],[1,0]]

queue= deque()
queue.append([0,0])
while queue:
    row,col = queue.popleft()
    for i in move:
        move_row=row+i[0]
        move_col=col+i[1]   
        if(move_row<0 or move_row>N-1 or move_col<0 or move_col>M-1):
            continue
        elif miro[move_row][move_col] == 1:
            miro[move_row][move_col]=miro[row][col]+1
            queue.append([move_row,move_col])
print(miro[N-1][M-1])

