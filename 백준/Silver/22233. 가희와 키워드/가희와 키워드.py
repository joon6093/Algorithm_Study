import sys
input = sys.stdin.readline

N, M = map(int, input().strip().split())
memo_set = set(input().strip() for _ in range(N))
keword_set = [set(input().strip().split(",")) for _ in range(M)]

for keword_list in keword_set:
    for keword in keword_list:
        if keword in memo_set:
            memo_set.remove(keword)
    print(len(memo_set))