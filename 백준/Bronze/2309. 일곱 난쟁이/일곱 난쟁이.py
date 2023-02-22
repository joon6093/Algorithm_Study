import itertools
import sys
person_infor = [int(sys.stdin.readline()) for _ in range(9)]
case = itertools.combinations(person_infor, 7)

for i in case:
    if(sum(i)==100):
        i=list(i)
        i.sort()
        for j in i:
            print(j)
        break
        
