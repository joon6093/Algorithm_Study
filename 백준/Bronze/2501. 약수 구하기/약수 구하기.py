import sys
number,index  = map(int,sys.stdin.readline().strip().split())
count=0
song=0
for i in range(1,number+1):
    if(number%i == 0):
        count +=1
    if(count==index):
        song=i
        break
print(song)