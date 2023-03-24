import sys
from collections import deque
input = sys.stdin.readline


def bfs(rain,row,col):
    queue=deque([(row,col)])
    while queue:
        row,col=queue.popleft()
        for x,y in move:
            move_row=row + x
            move_col=col + y
            if 0 <= move_row < N and 0 <= move_col < N:
                if visited[move_row][move_col] ==0 and area[move_row][move_col] > rain:
                    visited[move_row][move_col]=1
                    queue.append((move_row,move_col))
N = int(input())
area=[]
Max_number=0
for i in range(N):
    area.append(list(map(int, input().split())))
    Max_number=max(Max_number,max(area[i]))

song = 0
result = 0
move=[[-1,0],[1,0],[0,-1],[0,1]]
for i in range(Max_number):
    visited=[[0] * N for i in range(N)]
    for row in range(N):
        for col in range(N):
            if area[row][col] > i and visited[row][col] == 0:
                visited[row][col]=1
                bfs(i,row,col)
                result+=1
    song=max(result,song)
    result = 0
print(song)
            