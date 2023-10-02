n = int(input())
if n <=9:
    for i in range(n):
        for j in range(1, i+1):
            print(j , sep = '', end = '' )
        print()
