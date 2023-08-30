import sys
import copy
input = sys.stdin.readline

N=int(input().strip())
word_list = [list(input().strip()) for _ in range(N)]

song = 0
for i in range(1, N):
    first_word = copy.deepcopy(word_list[0])
    check = 0
    for j in word_list[i]:
        if j in first_word:
            first_word.remove(j)
        else:
            check += 1
    if len(first_word) < 2 and check < 2:
        song += 1
print(song)