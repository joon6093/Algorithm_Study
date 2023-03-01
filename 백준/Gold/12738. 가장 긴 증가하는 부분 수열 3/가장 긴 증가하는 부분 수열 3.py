import sys
from bisect import bisect_left
input=sys.stdin.readline

A = int(input())
arr = list(map(int, input().split()))
dp_table = [arr[0]]

for i in range(1,len(arr)):
    if dp_table[-1] < arr[i]:
        dp_table.append(arr[i])
    else:
        dp_table[bisect_left(dp_table, arr[i])] = arr[i]

print(len(dp_table))