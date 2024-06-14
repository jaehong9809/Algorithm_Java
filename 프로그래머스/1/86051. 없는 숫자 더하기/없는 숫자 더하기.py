def solution(numbers):
    d = [0 for i in range(10)]
    
    for i in numbers:
        d[i]+=1
    answer=0
    for i in range(10):
        if d[i] ==0:
            answer+=i
            
    return answer