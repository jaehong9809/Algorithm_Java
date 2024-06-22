def solution(s):
    if len(s)==4:
        pass
    elif len(s)==6:
        pass
    else : return False
        
    for i in s:
        tmp = ord(i) - ord('0')
        
        if tmp<0 or tmp>9:
            return False
    
    answer = True
    return answer