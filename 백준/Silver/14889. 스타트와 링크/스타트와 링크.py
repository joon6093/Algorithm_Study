import sys

input = sys.stdin.readline

N = int(input())
team = [list(map(int,input().split())) for _ in range(N)]
result = 1e9 
visited = [False] * (N + 1) 



def solve(depth, idx):
    global result
    if depth == (N // 2): 
        start, link = 0, 0 
        for i in range(N): 
            for j in range(i + 1, N):
                if visited[i] and visited[j]:
                    start += (team[i][j] + team[j][i]) 
                elif not visited[i] and not visited[j]: 
                    link += (team[i][j] + team[j][i]) 
        
        result = min(result, abs(start - link)) 
        return
    
    for i in range(idx, N): 
        if not visited[i]: 
            visited[i] = True
            solve(depth + 1, i + 1) 
            visited[i] = False


solve(0, 0)
print(result)