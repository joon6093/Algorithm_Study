import sys
index = int(sys.stdin.readline())
pabonachi=[0,1]
for i in range(2,index+1):
    pabonachi.append(pabonachi[i-2]+pabonachi[i-1])

print(pabonachi[index])

