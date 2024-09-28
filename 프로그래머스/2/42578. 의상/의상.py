def solution(clothes):
    dict = {}
    for name, type in clothes:
        if type in dict:
            dict[type] += 1
        else:
            dict[type] = 1
            
    answer = 1  
    for count in dict.values():
         answer*= count + 1
    return answer -1