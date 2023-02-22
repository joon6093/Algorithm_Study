import sys

infor = int(sys.stdin.readline())
count=0
while True:
    if(infor == 0):
        break
    elif(infor < 3):
        count=-1
        break
    if(infor%5 == 0):
        count+=infor//5
        infor=0
        continue
    infor-=3
    count+=1


print(count)