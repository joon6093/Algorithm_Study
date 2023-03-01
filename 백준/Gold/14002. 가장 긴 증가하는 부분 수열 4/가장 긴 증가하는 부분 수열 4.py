import sys
input = sys.stdin.readline

N=int(input())
A = list(map(int, input().split()))

dp_table = [1] * N

for i in range(N):
    for j in range(i):
        if A[i] > A[j]:
            dp_table[i] = max(dp_table[i], dp_table[j]+1)

song=max(dp_table)
print(song)


result = []
for i in range(N-1,-1,-1):
    if dp_table[i]==song:
        result.append(A[i])
        song-=1

result.reverse()
print(*result)
