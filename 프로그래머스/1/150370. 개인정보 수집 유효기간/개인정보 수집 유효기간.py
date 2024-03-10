def solution(today, terms, privacies):
    today_year, today_month, today_date = map(int, today.split("."))
    terms_category = {}
    answer = []
    for term in terms:
        term_category, term_mount = map(str, term.split())
        terms_category[term_category] = int(term_mount)
    
    for i in range(len(privacies)):
        user_infor, user_category =  map(str, privacies[i].split())
        user_year, user_month, user_date = map(int, user_infor.split("."))
        
        user_year_mount = user_year * 12 + user_month
        user_year_mount += terms_category[user_category]
        today_year_mount  = today_year * 12 + today_month
        
        
        if today_year_mount < user_year_mount:
            continue
        elif today_year_mount == user_year_mount and today_date < user_date:
            continue
            
        answer.append(i+1)
        
    return answer