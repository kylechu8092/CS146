def longestPalindrome(self, s):
    count = [0] * 128
    for c in s:
        count[ord(c)] += 1
    result = 0
    for current in count:
        result += current // 2 * 2
        if result % 2 == 0 and current % 2 == 1:
            result += 1
    return result
