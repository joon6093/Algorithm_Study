import sys
input = sys.stdin.readline

N = int(input().strip())
have_card = list(map(int, input().strip().split()))  
M = int(input().strip())
find_card = list(map(int, input().strip().split()))

dict = {}
for i in have_card:
    if i in dict:
        dict[i] += 1
    else:
        dict[i] = 1

for i in find_card:
    if i in dict:
        print(dict[i], end=" ")
    else:
        print(0, end=" ")