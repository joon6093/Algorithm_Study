import sys
input = sys.stdin.readline

string = input().strip()
a_count = string.count('a')
string += string[0:a_count-1]
min_count = float('inf')

for i in range(len(string) - (a_count - 1)):
    min_count = min(min_count, string[i:i+a_count].count('b'))

print(min_count)