import sys
input= sys.stdin.readline

S = input().strip()
zero_count = S.count('0')
one_count = S.count('1')

print('0'*(zero_count//2) + '1' * (one_count//2))