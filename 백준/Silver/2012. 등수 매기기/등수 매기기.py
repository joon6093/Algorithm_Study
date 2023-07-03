import sys
input = sys.stdin.readline

N=int(input())
grade = [int(input()) for _ in range(N)]

grade.sort()
song = 0
for i in range(1,N+1):
    song += abs(i-grade[i-1])

print(song)
