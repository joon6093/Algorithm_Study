import sys

input = sys.stdin.readline
index = int(input())
num = list(map(int, input().split()))
add_index,sub_index,mul_index,div_index=map(int, input().split())

max = -1e9
min= 1e9
def dfs(depth,song):
    global max, min, add_index, sub_index, mul_index, div_index
    if(index==depth):
        if song > max:
            max = song
        if song < min:
            min = song
        return
    if add_index:
        add_index-=1
        dfs(depth+1,song+num[depth])
        add_index+=1

    if sub_index:
        sub_index-=1
        dfs(depth+1,song-num[depth])
        sub_index+=1

    if mul_index:
        mul_index-=1
        dfs(depth+1,song*num[depth])
        mul_index+=1

    if div_index:
        div_index-=1
        dfs(depth+1,int(song/num[depth]))
        div_index+=1

dfs(1,num[0])

print(max)
print(min)
