def solution(edges):
    start_node_list = []
    end_node_list = []
    edges_list = {}
    visted_node_list = {}
    for edge in edges:
        start_node, end_node = map(int, edge)
        if start_node not in edges_list:
            edges_list[start_node] = [end_node]
            visted_node_list[start_node] = []
        else:
            edges_list[start_node].append(end_node)
        start_node_list.append(start_node)
        end_node_list.append(end_node)

    start_node_list = set(start_node_list)
    end_node_list = set(end_node_list)
    my_node = start_node_list - end_node_list
    
    for node in my_node:
        if len(edges_list[node]) > 1:
            my_node = node
            break
    donut_count = 0
    rod_count = 0
    eight_count = 0
    
    for node in edges_list[my_node]:
        start_node = node
        while(1):
            if node in edges_list:
                if len(edges_list[node]) > 1:
                    eight_count +=1
                    break
                else:
                    node = edges_list[node][0]
                    if node == start_node:
                        donut_count += 1
                        break
            else:
                rod_count += 1     
                break
    
            
    answer = [my_node, donut_count, rod_count, eight_count]
    return answer
