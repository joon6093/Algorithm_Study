import sys
min,max  = map(int,sys.stdin.readline().strip().split())
song =1
while(min < max):
    if(max % 2 == 1):
        max=(max-1)/10
    else:
        max=max/2
    song+=1

if(min != max):
    song = -1
print(song)