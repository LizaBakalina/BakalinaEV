seconds = int(input())
dni = seconds//86400
chas = (seconds%86400)//3600
minut = ((seconds%86400)%3600)//60
sec = ((seconds%86400)%3600)%60
print(dni,chas,minut,sec)