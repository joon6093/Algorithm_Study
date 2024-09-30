def solution(progresses, speeds):
    answer = []
    time = 0
    deploy = 0
    
    while len(progresses)> 0:
        if (progresses[0] + time*speeds[0]) >= 100:
            progresses.pop(0)
            speeds.pop(0)
            deploy += 1
            
        else:
            if deploy > 0:
                answer.append(deploy)
                deploy = 0
            time += 1
    answer.append(deploy)
    return answer