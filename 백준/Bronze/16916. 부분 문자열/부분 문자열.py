import sys
input = sys.stdin.readline

word=input().strip()
pattern=input().strip()

if(pattern in word):
    print(1)
else:
    print(0)