import sys
input = sys.stdin.readline

people = int(input())
search_x, search_y = map(int,input().split())
index = int(input())
relationship = [list(map(int, input().split())) for _ in range(index)]

graph = [[] for _ in range(people + 1)]
visited = [False] * (people + 1) 
for x,y in relationship:
    graph[x].append(y)
    graph[y].append(x)

def dfs(node,count):
    count +=1
    visited[node] = True
    if node == search_y:
        print(count)
        exit()
    for i in graph[node]:
        if not visited[i]:
            dfs(i,count)

dfs(search_x,-1)
print(-1)

