def solution(phone_book):
    set_phone_book = set(phone_book)
    for phone_number in phone_book:
        for i in range(1, len(phone_number)):
            prefix = phone_number[:i]
            if prefix in set_phone_book:
                return False
    return True