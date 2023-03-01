import sys
from bisect import bisect_left
input=sys.stdin.readline

N=int(input())
L=list(map(int,input().split()))
dp_table=[-float('inf')]

for i in L:
    if dp_table[-1]<i:
        dp_table.append(i)
    else:
        dp_table[bisect_left(dp_table, i)] = i


print(len(dp_table)-1)