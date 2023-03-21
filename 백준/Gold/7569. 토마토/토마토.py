from collections import deque
import copy
import sys
input = sys.stdin.readline
m,n,h = map(int,input().split()) 
tomato_data = [[list(map(int, input().split())) for _ in range(n)] for _ in range(h)]
queue = deque([])

move=[[-1,0,0],[1,0,0],[0,-1,0],[0,1,0],[0,0,-1],[0,0,1]]

def bfs():
    while queue:
        z,x,y = queue.popleft()
        for move_z,move_x,move_y in move:
            after_z = z + move_z
            after_x = x + move_x
            after_y = y + move_y
            if -1<after_z<h and -1<after_x<n and -1<after_y<m:
                if tomato_data[after_z][after_x][after_y] == 0:
                    tomato_data[after_z][after_x][after_y] = tomato_data[z][x][y] + 1
                    queue.append((after_z,after_x,after_y))
                
for i in range(h):
    for j in range(n):
        for k in range(m):
            if tomato_data[i][j][k] == 1:
                queue.append((i,j,k))

bfs()
song=0
for i in range(h):
    for j in range(n):
        for k in range(m):
            if tomato_data[i][j][k] == 0:
                print(-1)
                exit()
            song = max(song,tomato_data[i][j][k])

print(song-1)
