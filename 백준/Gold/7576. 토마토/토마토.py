import sys
from collections import deque
col_index,row_index  = map(int,sys.stdin.readline().strip().split())
arr = [list(map(int,sys.stdin.readline().strip().split())) for _ in range(row_index)]

ripe=deque()
move=[[0,-1],[0,1],[-1,0],[1,0]]
#left,right,up,down
for i in range(row_index):
    for j in range(col_index):
        if(arr[i][j] == 1):
            ripe.append([i,j])

while(len(ripe) != 0):
    row, col= ripe.popleft()
    for i in move:
        move_row=row+i[0]
        move_col=col+i[1]   
        if(move_row<0 or move_row>row_index-1 or move_col<0 or move_col>col_index-1):
            continue
        elif(arr[move_row][move_col] == 0):
            arr[move_row][move_col]=arr[row][col]+1
            ripe.append([move_row,move_col])
song=0
for i in range(row_index):
    for j in range(col_index):
        if(arr[i][j] == 0):
            print(-1)
            exit(0)
        if(song<(arr[i][j]-1)):
            song=arr[i][j]-1
print(song)