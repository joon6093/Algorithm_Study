def solution(k, tangerine):
    count_tangerine={}
    for i in tangerine:
        if i in count_tangerine:
            count_tangerine[i] +=1
        else: 
            count_tangerine[i] = 1

    count_tangerine = sorted(count_tangerine.items(), key = lambda x: x[1], reverse = True)
    
    answer = 0
    for i in count_tangerine:
        if k <= 0:
            break
        k -= i[1]
        answer += 1
    return answer