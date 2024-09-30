def solution(arr):
    result = []
    for i in range(len(arr)):
        if i == 0 or arr[i - 1] != arr[i]:
            result.append(arr[i])
    return result