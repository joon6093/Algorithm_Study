import sys
def find_string(parent, pattern):
    parent_len = len(parent)
    pattern_len = len(pattern)
    parent_hash = 0
    pattern_hash = 0
    power = 1
    count=0
    for i in range(parent_len - pattern_len + 1):
        if i == 0:
            for j in range(pattern_len):
                parent_hash += ord(parent[pattern_len - 1 - j]) * power
                pattern_hash += ord(pattern[pattern_len - 1 - j]) * power
                if j < pattern_len - 1:
                    power *= 2
        else:
            parent_hash = 2 * (parent_hash - ord(parent[i - 1]) * power) + ord(parent[pattern_len - 1 + i])
            
        if parent_hash == pattern_hash:
            count+=1

    return count

input = sys.stdin.readline
N=int(input())
S=int(input())
word=input().rstrip()
pattern='IO'*N + 'I'

count=find_string(word, pattern)
print(count)

