import sys
input = sys.stdin.readline
gather=('a','e','i','o','u')

while(True):
    test_case=input().rstrip()
    if test_case == 'end':
        break
    first_check=0
    second_check_gather=0
    second_check_else=0
    second_third_check=1
    temp=''
    for i in test_case:
        if i in gather:
            first_check = 1
            second_check_else = 0
            second_check_gather+=1
        else:
            second_check_else += 1
            second_check_gather = 0
        if second_check_gather >= 3 or second_check_else >= 3 or temp == i:
            second_third_check = 0
            break
        if i in ('e','o'):
            temp=''
        else:
            temp=i
    if first_check == 0 or second_third_check == 0:
        print("<"+test_case+"> is not acceptable.")
    else:
        print("<"+test_case+"> is acceptable.")
        