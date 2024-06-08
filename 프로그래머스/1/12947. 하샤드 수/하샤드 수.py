def solution(x):
    
    tmp=0
    for i in str(x):
        tmp+=int(i)
        
    return True if x%tmp==0 else False