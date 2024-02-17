import sys
input = sys.stdin.readline

n = int(input().strip())
student_list = []
for birth in range(n):
    name, dd, mm, yyyy = input().strip().split()
    student_list.append([int(yyyy), int(mm), int(dd), name])
    
student_list.sort(key=lambda x:(x[0],x[1],x[2]))

print(student_list[-1][3])
print(student_list[0][3])