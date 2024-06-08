import itertools
def solution(k, dungeons):
    length = len(dungeons)
    
    arr=itertools.permutations([i for i in range(length)], length)
    res =-1
    for tmp in arr:
        K = k
        cnt =0
        for i in tmp:
            if dungeons[i][0]<=K:
                cnt+=1
                K -= dungeons[i][1]
                
                
                
        res = max(res, cnt)
    return res