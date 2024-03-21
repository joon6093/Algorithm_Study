def solution(survey, choices):
    score = [0,0,0,0]
    forward_category  = ["RT","CF","JM","AN"]
    reverse_category = ["TR","FC","MJ","NA"]
    for i in range(len(survey)):
        if survey[i] in forward_category:
            index = forward_category.index(survey[i])
            score[index] += scoring(choices[i])
        else:
            index = reverse_category.index(survey[i])
            score[index] += - scoring(choices[i])
    answer = ["T","E","S","T"]
    for i in range(4):
        if score[i] >= 0:
            answer[i] = forward_category[i][0]
        else:
            answer[i] = forward_category[i][1]
    answer = "".join(answer)  
    return answer


def scoring(category_score):
    return -(category_score - 4)
    