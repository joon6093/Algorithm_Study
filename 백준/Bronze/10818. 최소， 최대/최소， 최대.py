import sys
index = int(sys.stdin.readline())
infor = list(map(int, sys.stdin.readline().split()))
min=1000001
max=-1000001
for i in infor:
    if(min>i):
        min=i
    if(max<i):
        max=i
    
print(min,max)