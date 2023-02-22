import sys
from itertools import *
output,index  = map(int,sys.stdin.readline().strip().split())
infor = list(map(str, sys.stdin.readline().split()))
infor.sort()
infor=list(combinations(infor, output))
vowels_list=['a','e','i','o','u']
for list in infor:
    vowels_count=0
    for vowel in vowels_list:
        if(vowel in list):
            vowels_count+=1
    if(vowels_count>0 and len(list)-vowels_count>1):
        list="".join(list)
        print(list)