import sys
input = sys.stdin.readline


N, M = map(int, input().split())
store_word={}
for i in range(N):
    word=input().strip()
    if len(word) < M:
        continue
    else:
        if word in store_word:
            store_word[word]+=1
        else:
            store_word[word]=1


store_word=sorted(store_word.items(),key=lambda x:(-x[1],-len(x[0]),x[0]))

for i in store_word:
    print(i[0])