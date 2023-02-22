import sys
index = int(sys.stdin.readline())
infor = list(map(int, sys.stdin.readline().split()))
infor.sort()
number=[False,False]  #0 , 1
for i in range(2,infor[index-1]+1):
    if(i==1):
        continue
    if(i in infor):
        number.append(True)
    else:
        number.append(False)

for i in range(2,infor[index-1]+1):
    for j in infor:
        if(i==j):
            continue
        if(j%i==0):
            number[j]=False
print(number.count(True))