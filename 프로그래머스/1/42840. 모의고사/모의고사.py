def solution(answers):
    peoples = [[1, 2, 3, 4, 5], 
               [2, 1, 2, 3, 2, 4, 2, 5], 
               [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]]
    count_list = []
    for people in peoples:
        index = 0
        count = 0
        while(len(answers) != index):
            if people[index%(len(people))] == answers[index]:
                count+=1
            index+=1
        count_list.append(count)
        
    answer=[]
    for i in range(len(count_list)):
        if max(count_list) == count_list[i]:
            answer.append(i+1)
            
    return answer