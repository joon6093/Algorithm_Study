import sys

input=sys.stdin.readline

infor = input().rstrip()
search = input().rstrip()

start=0
song=0
while(True):
    start=infor.find(search,start)
    if(start == -1):
        break
    start += len(search)
    song+=1

print(song)