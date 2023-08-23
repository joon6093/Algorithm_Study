import sys
input = sys.stdin.readline

words = input().upper().strip()

word_list = {}
max_count = 0 
max_Alpa = ''
duplicate_check = 0
for i in words :
    if i in word_list:
        word_list[i] += 1
    else:
        word_list[i] = 1
    if max_count < word_list[i]:
        max_count = word_list[i]
        duplicate_check = 0
        max_Alpa = i
    elif max_count == word_list[i]:
        duplicate_check += 1

if duplicate_check:
    print('?')
else:
    print(max_Alpa)