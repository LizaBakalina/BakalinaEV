def F():
    num = int(input())
    if num == 0:
        return 0
    a = F()
    return max(num, a)
print(F())
