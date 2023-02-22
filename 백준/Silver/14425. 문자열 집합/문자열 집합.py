import sys
Main_index,Check_index  = map(int,sys.stdin.readline().strip().split())

Main_list = [(sys.stdin.readline().strip()) for _ in range(Main_index)]
Check_list = [(sys.stdin.readline().strip()) for _ in range(Check_index)]
song=0
for String in Check_list:
    if(String in Main_list):
        song+=1
print(song)