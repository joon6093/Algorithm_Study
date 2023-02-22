import sys
from heapq import heappush, heappop
input = sys.stdin.readline

def find_set(u):
    curr = u
    history = []
    while curr != parent[curr]:
        history.append(curr)
        curr = parent[curr]
    for h in history:
        parent[h] = curr
    return curr

def union_set(u, v):
    if u == v:
        return False
    if rank[u] >= rank[v]:
        parent[v] = u
        if rank[u] == rank[v]:
            rank[u] += 1
    else:
        parent[u] = v
    return True


N, M = map(int, input().split())
parent = list(range(N+1))
rank = [0]*(N+1)
edges = []

village_cost = [9999999999]

for _ in range(N):
    village_cost.append(int(input()))

for _ in range(M):
    a, b, c = map(int, input().split())
    c += village_cost[a] + village_cost[b] + c
    heappush(edges, (c, a, b))

connected_cnt = 0
ans = 0
while connected_cnt < N - 1:
    w, x, y = heappop(edges)
    xr, yr = find_set(x), find_set(y)
    if union_set(xr, yr):
        ans += w
        connected_cnt += 1
        
ans += min(village_cost)

print(ans)