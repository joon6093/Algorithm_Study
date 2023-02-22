import sys
import math
input = sys.stdin.readline

index = int(input())
deadline = list(map(int, input().split()))
plan = list(map(int, input().split()))

infor=[]
for i in range(index):
    infor.append([deadline[i], plan[i]])

infor.sort(key=lambda x: (x[1], x[0]))

before=infor[0][1]
song=0
max_value=0

for i in range(index):
    if(before> infor[i][0]):
        before=max(before,infor[i][1])
        value=before-infor[i][0]
        ceil_value=math.ceil(value/30)   
        infor[i][0]+=ceil_value*30
        song+=ceil_value

    max_value=max(max_value,infor[i][0])

    if(i != index-1 and infor[i][1] != infor[i+1][1]):
        before=max_value

print(song)