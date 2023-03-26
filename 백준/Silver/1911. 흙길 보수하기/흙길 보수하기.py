import sys
import math 

N,L  = map(int,sys.stdin.readline().strip().split())
infor = [list(map(int,sys.stdin.readline().strip().split())) for _ in range(N)]

infor.sort()
count = 0
paper = 0
for start, end in infor:
    if paper>start:
        start=paper
    paper_len=math.ceil((end - start )/L)
    count+= paper_len
    paper= start + paper_len * L
print(count)