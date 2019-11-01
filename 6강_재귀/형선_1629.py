import sys
sys.setrecursionlimit(100000)
A, B, C = [int(x) for x in input().split()]
def solution(start, count = 1):
    if count == B:
        return start
    count += 1
    return solution(start * A, count)

print(solution(A) % C)