import sys
input = sys.stdin.readline

numbers = list(map(str, input().strip()))
number=0
index=0
while len(numbers) != index:
    number+=1
    for one_number in str(number):
        if index >= len(numbers):
            break
        if numbers[index]==one_number:
            index+=1
print(number)