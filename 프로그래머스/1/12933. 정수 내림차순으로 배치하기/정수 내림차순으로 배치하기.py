def solution(n):
    arr= []
    for i in str(n):
        arr.append(int(i))
    
    arr.sort(reverse=True)
    answer=""
    for i in arr:
        answer+=str(i)
        
    return int(answer)