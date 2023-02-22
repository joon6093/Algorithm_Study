import sys

index = int(sys.stdin.readline())

number=666
six_count=0
song=0
while(True):
    six_count=0
    for i in str(number):
        if(i=='6'):
            six_count+=1
        else:
            six_count=0
        if(six_count==3):
            song+=1
            break
    if(index==song):
        break
    number+=1
print(number)

