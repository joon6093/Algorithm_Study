import sys
input = sys.stdin.readline

N=int(input())
people = list(map(int, input().split()))

dp_table = [1] * N

for i in range(N):
    for j in range(i):
        if people[i] < people[j]:
            dp_table[i] = max(dp_table[i], dp_table[j]+1)

print(len(people) - max(dp_table))