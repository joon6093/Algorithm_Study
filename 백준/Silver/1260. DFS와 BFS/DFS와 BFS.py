from collections import deque
import sys
input = sys.stdin.readline

def dfs(node):
    visited[node] = 1
    print(node,end=' ')
    for i in graph[node]:
        if not visited[i]:
            dfs(i)

def bfs(start):
    que=deque([start])
    visited[start]=1
    while que:
        node=que.popleft()
        print(node,end=' ')
        for i in graph[node]:
            if not visited[i]:
                visited[i]=1
                que.append(i)

N, M, V = map(int, input().split())
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph:
    i.sort()

visited = [0] * (N + 1)
dfs(V)
print()

visited = [0] * (N + 1)
bfs(V)