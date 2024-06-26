def makebi(n, num):
    if num==0:
        return [0,0,0,0,0]
    bin = ""
    while num!=1:
        bin  = str(num%2)+ bin
        num =num//2
    bin = '1'+bin
    if len(bin)!=n:
        for i in range(n-len(bin)):
            bin="0"+bin
            
    ar = [0 for i in range(n)]
    
    for i in range(n):
        ar[i] =int(bin[i])  
        
    return ar
    
    
        
    

def solution(n, arr1, arr2):
    answer = []
    tmp1 = []
    for i in arr1:
        tmp1.append(makebi(n, i))
    tmp2 = []
    for i in arr2:
        tmp2.append(makebi(n, i))
    
    for i in range(n):
        s = ""
        for j in range(n):
            if tmp1[i][j]==1 or tmp2[i][j]==1:
                s+="#"
            else:
                s+=" "
        answer.append(s)
        
    return answer