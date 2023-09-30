n = int(input())
chas = n//60
minut = n%60
sut = n//1440
if chas < 24:
    print(chas,minut)
else:
    chas = (n%1440)//60
    minut = (n%1440)%60
    print(sut,chas,minut)