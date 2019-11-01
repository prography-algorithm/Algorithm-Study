# import sys
# sys.setrecursionlimit(100000)
N = int(input())
# '1', '2', '3'
def solution(n, start, mid, end):
    if n == 1:
        print(start+' '+end)
        return
    solution(n - 1, start, end, mid)
    solution(1, start, mid, end)
    solution(n - 1, mid, start, end)
print(pow(2, N) - 1)
solution(N, '1', '2', '3')

# 시간 초과된 풀이
# # import sys
# # sys.setrecursionlimit(100000)
# N = int(input())
# # '1', '2', '3'
# count = 0
# string = ''
# def solution(n, start, mid, end):
#     global count
#     global string
#     if n == 1:
#         val = start + ' ' + end + '\n'
#         string += val
#         count += 1
#         return
#     solution(n - 1, start, end, mid)
#     solution(1, start, mid, end)
#     solution(n - 1, mid, start, end)
# solution(N, '1', '2', '3')
# print(count)
# print(string)