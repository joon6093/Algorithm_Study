import sys
from collections import deque
input = sys.stdin.readline
colrow_index=int(input())
arr = [list(map(int, input().rstrip())) for _ in range(colrow_index)]
song=[]

def check_dange(arr, row_index, col_index):
    dange=deque()
    move=[[0,-1],[0,1],[-1,0],[1,0]]
    dange.append([row_index,col_index])
    song=[]
    count=1
    while dange:
        row,col = dange.popleft()
        for i in move:
            move_row=row+i[0]
            move_col=col+i[1]   
            if(move_row<0 or move_row>colrow_index-1 or move_col<0 or move_col>colrow_index-1):
                continue
            if arr[move_row][move_col] == 1:
                arr[move_row][move_col]= -1
                count+=1
                dange.append([move_row,move_col])
    return count

for i in range(colrow_index):
    for j in range(colrow_index):
        if(arr[i][j]==1):
            arr[i][j]=-1
            song.append(check_dange(arr,i,j))

print(len(song))
song.sort()
for i in song:
    print(i)
