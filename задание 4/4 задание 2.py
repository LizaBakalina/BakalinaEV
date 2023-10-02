A = int (input())
B = int (input())
x = []
if A < B:
    for i in range(A, B + 1):
        x.append(i)
else:
    for j in range(B, A + 1):
        x.append(j)
    x.reverse()
print(x)
