import sys
from collections import deque
index  = int(sys.stdin.readline())
number_infor = [int(sys.stdin.readline()) for _ in range(index)]
deque = deque()
for i in number_infor:
    count=0
    song=[]
    two_square=1
    while(True):
        two_square=two_square*2
        if(i<two_square):
            break
    number=i
    while(True):
        two_square=two_square//2
        if(number>=two_square):
            number-=two_square
            deque.append(1)
        else:
            deque.append(0)
        if(two_square==1):
            break
    while(len(deque)!=0):    
        if(deque.pop()==1):
            song.append(count)
        count+=1
    print(*song)
    
