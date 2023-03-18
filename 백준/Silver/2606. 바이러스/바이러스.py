import sys
input = sys.stdin.readline

def dfs(node):
    visited[node] = 1
    for i in graph[node]:
        if not visited[i]:
            dfs(i)

N = int(input())
M = int(input())
count = 0
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph:
    i.sort()

visited = [0] * (N + 1)
dfs(1)
print(sum(visited)-1)
