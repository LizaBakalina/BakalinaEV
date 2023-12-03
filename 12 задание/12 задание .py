def F(a, b):
    if a == b:
        print(a)
    elif a < b:
        print(a)
        F(a + 1, b)
    else:
        print(a)
        F(a - 1, b)
A = int(input())
B = int(input())
F(A,B)