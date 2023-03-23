import sys
from collections import deque
input = sys.stdin.readline

def bfs():
    que=deque([N])
    index_arr[N]=0
    while que:
        subin_pos=que.popleft()
        if subin_pos == K:
            print(index_arr[subin_pos])
            exit()
        for pos in [subin_pos + 1,subin_pos - 1, subin_pos * 2]:
            if 0<=pos<100001 and pos not in index_arr:
                que.append(pos)
                index_arr[pos] = index_arr[subin_pos] +1

N, K =  map(int,input().strip().split())
index_arr = {}
bfs()