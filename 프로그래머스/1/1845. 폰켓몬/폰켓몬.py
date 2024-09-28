def solution(nums):
    unique = set(nums)
    if len(unique) >  len(nums)//2:
        return len(nums)//2
    else:
        return len(unique)