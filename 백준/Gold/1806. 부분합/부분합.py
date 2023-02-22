import sys

index,sum_infor  = map(int,sys.stdin.readline().strip().split())
infor = list(map(int, sys.stdin.readline().split()))

sum=0
start=0
end=-1
song=100001
while(True):
    if(sum<sum_infor):
        end+=1
        if(index==end):
            break
        else:
            sum+=infor[end]
    else:
        sum-=infor[start]
        if(song>end-start+1):
            song=end-start+1
        start+=1
if(song==100001):
    song=0
print(song)