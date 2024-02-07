import sys
input = sys.stdin.readline

N = int(input().strip())
A = map(int,input().strip().split())
B = map(int,input().strip().split())
A = sorted(A)
B = sorted(B)

song = 0
for i in range(N):
    song += A[i] * B[N-i-1] 

print(song)