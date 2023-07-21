import sys
input = sys.stdin.readline
N, K  = map(int,input().strip().split())
nation_infor=[]
for _ in range(N):
    nation=list(map(int,input().strip().split()))
    num=nation[0]
    nation_infor.append(nation[1:])
    if num == K:
        K_infor=nation[1:]

song = 1
for i in range(N):
    if nation_infor[i][0]>K_infor[0]:
        song+=1
        continue
    elif nation_infor[i][0]==K_infor[0]:
        if nation_infor[i][1]>K_infor[1]:
            song+=1
            continue
        elif nation_infor[i][1]==K_infor[1]:
            if nation_infor[i][2]>K_infor[2]:
                song+=1
                continue

print(song)
