arr= [0 for i in range(5)]
aeiou = ["A", "E", "I", "O", "U"]
word_arr = []
def dfs(depth, limit):
    if depth ==limit:
        tmp = ""
        for i in range(limit):
            tmp+= aeiou[arr[i]]
        word_arr.append(tmp)
        return
    
    for i in range(5):
        arr[depth] = i
        dfs(depth+1, limit)

def solution(word):
    for i  in range(1, 6):
        dfs(0, i)
    word_arr.sort()
    answer=word_arr.index(word)+1
        
    return answer