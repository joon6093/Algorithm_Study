import sys
def KMP_table(pattern):
    lp = len(pattern)
    tb = [0 for _ in range(lp)]
    
    pidx = 0 
    for idx in range(1, lp): 
        while pidx > 0 and pattern[idx] != pattern[pidx]:
            pidx = tb[pidx-1]
        if pattern[idx] == pattern[pidx] :
            pidx += 1
            tb[idx] = pidx
    
    return tb

input = sys.stdin.readline
song=0
word=input().rstrip()
for i in range(len(word)):
    song=max(song,max(KMP_table(word[i:])))
print(song)