import sys
input = sys.stdin.readline

word = input().split('-')
for i in word:
    print(i[0], end='')