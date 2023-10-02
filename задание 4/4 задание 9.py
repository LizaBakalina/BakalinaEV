a = b =1 #первый и второй элемент
N = int(input())-2
print(a,b,end = ' ')
for i in range(2,N):
    a,b = b, a +b
    print(b,end = ' ')