import sys
input = sys.stdin.readline

N, K = map(int,input().split())
things = [[0,0]]
for _ in range(N):
    things.append(list(map(int, input().split())))

knapsack = [[0 for _ in range(K + 1)] for _ in range(N + 1)]

for row in range(1,N+1):
    for col in range(1,K+1):
        if things[row][0]<=col:
            knapsack[row][col]=max(knapsack[row-1][col], knapsack[row-1][col-things[row][0]]+things[row][1])
        else:
            knapsack[row][col]=knapsack[row-1][col]

print(knapsack[N][K])
    
