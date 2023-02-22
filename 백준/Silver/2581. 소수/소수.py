import sys

start_index=int(sys.stdin.readline())
end_index=int(sys.stdin.readline())

number=[True] * (end_index+1) #0 , 1
number[0]=False
number[1]=False

for i in range(2,end_index+1):
    if(number[i]==False):
        continue
    for j in range(2,end_index+1):
        if(i==j):
            continue
        if(j%i==0):
            number[j]=False
song=0
frist=0
first_check=0
for i,v in enumerate(number):
    if(i>=start_index and v==True):
        song+=i
        if(first_check==0):
            frist=i
            first_check=1 

if(song==0):
    print(-1)
    exit
else:
    print(song)
    print(frist)

