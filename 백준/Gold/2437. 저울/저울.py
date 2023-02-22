import sys

index = int(sys.stdin.readline())
infor = [int(i) for i in (sys.stdin.readline().strip().split())]
infor.sort()

sum=1
for i in infor:
    if(sum >= i):
        sum+=i
    else:
        break

print(sum)