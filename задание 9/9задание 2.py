def F(A):
    a = len(A)
    b = len(A[0])
    for i in range(a):
        A[i][0], A[i][b - 1] = A[i][b - 1], A[i][0]
    for i in range(a):
        for j in range(b):
            print(A[i][j], end=' ')
        print()

n = int(input())
m = int(input())
A = []
for i in range(m):
    b = []
    for j in range(n):
        print (i,j)
        b.append(int(input()))
    A.append(b)
print()
for i in range(m):
    for j in range(n):
        print(A[i][j],end = '')
    print()
F(A)
