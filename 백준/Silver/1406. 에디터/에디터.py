import sys
from collections import deque
input = sys.stdin.readline

string = deque(input().strip())
start = 0 

for i in range(int(input().strip())):
    command_list = list(input().strip().split())
    if command_list[0] == 'L':
        if start < len(string):  
            string.rotate(1)
            start +=1
    elif command_list[0] == 'D':
        if start > 0:
            string.rotate(-1)
            start -=1
    elif command_list[0] == 'B':
        if start < len(string):  
            string.pop()
    elif command_list[0] == 'P':
        string.append(command_list[1])

string = list(string)
print(''.join(string[start:] + string[:start]))