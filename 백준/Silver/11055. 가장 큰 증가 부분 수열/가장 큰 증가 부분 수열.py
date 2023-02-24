import sys
input = sys.stdin.readline

N=int(input())
A = list(map(int, input().split()))

dp_table = [1] * N

for i in range(N):
    dp_table[i]=A[i]
    for j in range(i):
        if A[i] > A[j]:
            dp_table[i] = max(dp_table[i], dp_table[j]+A[i])

print(max(dp_table))