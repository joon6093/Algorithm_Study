import sys
input=sys.stdin.readline
range_index =int(input())
for _ in range(range_index):
    index=int(input())
    infor = list(map(int, input().split()))
    song=0
    max_value=infor[index-1]
    value=infor[index-1]
    for i in range(index-2,-1,-1):
        before_value=value
        value=infor[i]
        if(max_value<value):
            max_value=value
        else:
            song+=max_value-value
    print(song)