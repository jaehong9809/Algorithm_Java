def solution(arr, divisor):
    answer = []
    arr.sort()
    for num in arr:
        if num%divisor ==0:
            answer.append(num)
    return answer if answer else [-1]