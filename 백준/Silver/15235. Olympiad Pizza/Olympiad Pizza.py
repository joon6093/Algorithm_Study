import sys
index = int(sys.stdin.readline())
infor = list(map(int, sys.stdin.readline().strip().split()))
song=[0]*index
count=0
range_count=max(infor)*index

for i in range(range_count):
    i=i%index
    if(infor[i]>0):
        count+=1
    infor[i]-=1
    if(infor[i]==0):
        song[i]=count
print(*song)