def solution(s):
    length = len(s)
    answer = ''
    strings = s.split(" ")
    for string in strings:
        tmp = ""
        for i in range(len(string)):
            if i%2==0:
                tmp+=string[i].upper()
            else:
                tmp+=string[i].lower()
        
        answer+=tmp+" "
    answer = answer[:-1]
    return answer