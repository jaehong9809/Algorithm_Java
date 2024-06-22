def solution(price, money, count):
    answer = 0
    for i in range(1, count+1):
        answer+=price*i
    answer = money - answer
    return answer*(-1) if answer<0 else 0 