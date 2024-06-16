def solution(arr):
    min_num = min(arr)
    
    
    
    answer=[]
    for i in arr:
        if min_num != i :
            answer.append(i)
    
    
    
    return answer if answer else [-1]