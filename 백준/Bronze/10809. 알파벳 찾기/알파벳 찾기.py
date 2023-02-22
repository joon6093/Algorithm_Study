import sys
input = sys.stdin.readline().strip()
alpa_list=[-1]*26
for i,v in enumerate(input):
    if(alpa_list[ord(v)-ord('a')]==-1):
        alpa_list[ord(v)-ord('a')]=i
print(*alpa_list)

