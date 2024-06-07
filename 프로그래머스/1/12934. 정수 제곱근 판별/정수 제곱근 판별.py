import math
def solution(n):
    x= -1
    for i in range(1, int(math.sqrt(n)+1)):
        if i*i == n:
            x = i   
            break
    answer = -1
    if x != -1:
        answer = math.pow(x+1, 2)
    
    
    return answer