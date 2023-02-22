import sys

index = int(sys.stdin.readline())
String = [(sys.stdin.readline().strip()) for _ in range(index)]
song={}
num=9
sum=0

for Str in (String):
    square=len(Str)-1
    for i in Str:
        if(i not in song):
            song[i]=10**square
            square-=1
        else:
            song[i]+=10**square
            square-=1

song=sorted(song.items(), key=lambda x: x[1], reverse=True)

for value in song:
    sum+=value[1]*num
    num-=1

print(sum)