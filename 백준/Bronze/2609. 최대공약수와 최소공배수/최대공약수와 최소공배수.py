import sys
a,b  = map(int,sys.stdin.readline().strip().split())

if(a<b):
    temp=a
    a=b
    b=temp
max=a
min=b
while(min>0):
    temp=max
    max=min
    min=temp%min

print(max)
print(a*b//max)

