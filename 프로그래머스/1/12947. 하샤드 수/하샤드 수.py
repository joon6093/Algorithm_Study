def solution(x):
    x_sum = sum((map(int, list(str(x)))))
    answer = x % x_sum == 0
    return answer