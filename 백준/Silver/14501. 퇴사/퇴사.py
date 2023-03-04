import sys
input = sys.stdin.readline

N=int(input())
plan = [list(map(int, input().split())) for _ in range(N)]

dp_table=[0] * N

for i in range(N):
    if plan[i][0] > N-i:
        plan[i][1]=0
    dp_table[i] = plan[i][1]
    plan[i][0]-=1
    for j in range(i):
        if(plan[j][0] != 0):
            plan[j][0]-=1
        else:
            dp_table[i] = max(dp_table[i], plan[i][1] + dp_table[j])

print(max(dp_table))