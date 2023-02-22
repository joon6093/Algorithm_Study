import sys

input = sys.stdin.readline
N, L = map(int, input().split())
runway = [list(map(int, input().split())) for _ in range(N)]

runway_check=[]
count=0
def check(way):
    for i in range(1,N):
        diff=way[i]-way[i-1]
        if(abs(diff)>1):
            return False
        if(diff==-1):
            for k in range(L):
                if(i+k>=N or runway_check[i+k] or way[i+k]!=way[i]):
                    return False
                runway_check[i+k]=True
        elif(diff==1):
            for k in range(L):
                if(i-k-1<0 or runway_check[i-k-1] or way[i-k-1]!=way[i-1]):
                    return False
                runway_check[i-k-1]=True
    return True

for i in runway:
    runway_check=[False] * N
    if check(i):
        count += 1

for i in range(N):
    runway_check=[False] * N
    if check([runway[j][i] for j in range(N)]):
        count += 1

print(count)

