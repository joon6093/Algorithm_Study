def solution(tickets):
    dict = {}
    for start, end in tickets:
        if start not in dict:
            dict[start] = [end]
        else:
            dict[start].append(end)
            
    for i in dict:
        dict[i].sort(reverse = True)
        
    city_list = ["ICN"]
    answer = []
    while city_list:
        city = city_list[-1]
        if city not in dict or not dict[city]:
            answer.append(city_list.pop())   
        else:
            city_list.append(dict[city].pop())

    return answer[::-1]