import sys

sum = int(sys.stdin.readline())
song=0
while(True):
    song+=1
    sum-=song
    if(sum<song+1):
        break

print(song)