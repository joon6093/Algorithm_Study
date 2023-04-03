import sys
input = sys.stdin.readline

N=input().strip()

word_list=[]
for i in range(len(N)-2):
    for j in range(i+1, len(N)-1):
        for k in range(j+1, len(N)):
            word = N[:j][::-1] + N[j:k][::-1] + N[k:][::-1]
            word_list.append(word)

print(min(word_list))


