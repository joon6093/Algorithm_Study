import sys

start_index,end_index  = map(int,sys.stdin.readline().strip().split())

index=0
range_index=0
song=0
while(True):
    if(range_index>=end_index):
        break
    index+=1
    for i in range(0,index):
        range_index+=1
        if(range_index>end_index):
            break
        if(range_index>=start_index):
            song+=index
        

print(song)