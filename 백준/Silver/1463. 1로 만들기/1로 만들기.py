import sys
input = sys.stdin.readline

N=int(input())

dp_tabel=[0]*(N+1)

for i in range(2,N+1):
    dp_tabel[i]=dp_tabel[i-1]+1
    if(i%2==0):
        dp_tabel[i]=min(dp_tabel[i],dp_tabel[i//2]+1)
    if(i%3==0):
        dp_tabel[i]=min(dp_tabel[i],dp_tabel[i//3]+1)

print(dp_tabel[N])