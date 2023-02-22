from sys import maxsize
import sys
import heapq

node_index = int(sys.stdin.readline())
line_index = int(sys.stdin.readline())
graph = [[] for i in range(node_index + 1)]
for _ in range(line_index):
    a, b, c = map(int, sys.stdin.readline().split())
    graph[a].append((b, c))
start_index,end_index  = map(int,sys.stdin.readline().strip().split())  
distance = [maxsize] * (node_index + 1)

def dijkstra(start_index):
    q = []
    heapq.heappush(q, (0, start_index))
    distance[start_index] = 0
    while q:  
        dist, now = heapq.heappop(q)
        if (now == end_index):
            print(dist)
            exit()
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

dijkstra(start_index)