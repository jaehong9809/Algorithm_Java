def solution(land):
    dp = []
    dp.append(land[0])
    for i in range(1, len(land)):
        tmp = [0, 0, 0, 0]
        tmp[0] = max(dp[i-1][1], dp[i-1][2],dp[i-1][3]) + land[i][0]
        tmp[1] = max(dp[i-1][0], dp[i-1][2],dp[i-1][3]) + land[i][1]
        tmp[2] = max(dp[i-1][0], dp[i-1][1],dp[i-1][3]) + land[i][2]
        tmp[3] = max(dp[i-1][1], dp[i-1][2],dp[i-1][0]) + land[i][3]
        dp.append(tmp)

    return max(dp[len(land)-1])