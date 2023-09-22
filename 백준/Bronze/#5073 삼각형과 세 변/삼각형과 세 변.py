import sys
input = sys.stdin.readline

while (True):
    triangle_list = list(map(int,input().rstrip().split()))
    max_num = max(triangle_list)
    triangle_set = set(triangle_list)
    if max_num == 0:
        break
    triangle_list_temp = triangle_list[:]
    triangle_list_temp.remove(max_num)
    if sum(triangle_list_temp) <= max_num:
        print("Invalid")
    elif len(triangle_set)==1:
        print("Equilateral")
    elif len(triangle_set) == 2:
        print("Isosceles")
    else:
        print("Scalene")