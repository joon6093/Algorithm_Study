import sys
from itertools import combinations


input_index,letter_index  = map(int,sys.stdin.readline().strip().split())
# k 가 5보다 작으면 어떤 언어도 배울 수 없음
if letter_index < 5:
    print(0)
    exit()
# k 가 26이면 모든 언어를 배울 수 있음
elif letter_index == 26:
    print(input_index)
    exit()

word_list = [set(sys.stdin.readline().strip()).difference('a', 'c', 'i', 't', 'n') for _ in range(input_index)]
alpa_list={chr(i + 97): i for i in range(26)}

song=0
for i in combinations([i for i in range(26) if chr(i + 97) not in ['a', 'c', 'i', 't', 'n']],letter_index-5):
    count=0
    combi_bit=0
    for j in i:
        combi_bit |= 1 << j
    for j in word_list:
        word_bit=0
        for k in j:
            word_bit|= 1 << alpa_list[k]
        if combi_bit | word_bit == combi_bit:
            count += 1
    song=max(song,count)
print(song)

