from collections import deque

def solution(numbers, target):
    queue = deque()
    answer = 0
    queue.append([numbers[0],0])
    queue.append([-numbers[0],0])
    while queue:
        number, index = queue.popleft()
        if index == len(numbers) -1:
            if number == target:
                answer += 1
            continue
        queue.append([number + numbers[index+1],index+1])
        queue.append([number - numbers[index+1],index+1])
        
    return answer