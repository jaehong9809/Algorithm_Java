TESTCASE = int(input())

for _ in range(TESTCASE):
    stack = []
    string = input()
    correct_sign = True
    for ch in string:
        if ch == '(':
            stack.append(ch)
        else:
            if len(stack) == 0:
                correct_sign = False
                break
            stack.pop()

    if len(stack) > 0 or not correct_sign:
        print("NO")
    else:
        print("YES")
