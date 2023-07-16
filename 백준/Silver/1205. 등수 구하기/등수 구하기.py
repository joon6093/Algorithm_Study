import sys
input = sys.stdin.readline


N, new_score, P = map(int, input().split())
if N != 0:
    numbers=list(map(int, input().split()))
else:
    print(1)
    exit()
start_grade = -1
same_grade = -1 
for i in  range(N):
    if start_grade == -1 and numbers[i] <= new_score:
        start_grade = i 
    if numbers[i] == new_score:
        same_grade = i
if start_grade == -1 and N<P:
    print(N+1)
elif start_grade == -1 or same_grade + 1 >= P:
    print(-1)
else:
    print(start_grade + 1)