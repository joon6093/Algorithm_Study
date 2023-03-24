from collections import deque
import sys
input = sys.stdin.readline


def bfs():  
    queue=deque([S])
    index_arr[S]=0
    while queue:
        floor=queue.popleft()
        if floor==G:
            print(index_arr[floor])
            exit()
        for next_floor in [floor+U,floor-D]:
            if 0<next_floor<=F and next_floor not in index_arr:
                queue.append(next_floor)
                index_arr[next_floor]=index_arr[floor]+1

F, S, G, U, D = map(int,input().split()) 
index_arr={}
bfs()
print("use the stairs")