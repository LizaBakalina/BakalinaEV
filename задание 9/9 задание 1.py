def F(A):
    sum1 = sum(A[0])
    for i in A:
        if sum(i) != sum1:
            return False
    for j in range(len(A)):
        if sum(i[j] for i in A) != sum1:
            return False
    if sum(A[i][i] for i in range(len(A))) != sum1:
        return False
    if sum(A[i][len(A) - 1 - i] for i in range(len(A))) != sum1:
        return False
    return True
n = int(input())
A = []
for i in range(n):
    b = []
    for i in range(n):
        b.append(int(input()))
    A.append(b)
for i in range(n):
    for j in range(n):
        print(A[i][j],end ='')
    print()

F(A)
if F(A) == True:
    print("является")
else:
    print("не является")