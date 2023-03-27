import sys
input = sys.stdin.readline

N = int(input())
S = [0]*21
song =[]
for _ in range(N):
    calculation = input().strip().split()
    if len(calculation) == 1:
        if calculation[0] == 'all':
            S = [1]*21
        elif calculation[0] == 'empty':
            S = [0]*21
    else:
        cal = calculation[0]
        num = int(calculation[1])
        if cal == 'add':
            S[num] = 1
        elif cal == 'remove':
            S[num]=0
        elif cal == 'check':
            print(S[num])
        elif cal == 'toggle':
            S[num]=int(not(S[num]))
