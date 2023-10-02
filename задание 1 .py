print('Курс Основы программирования начался')#1
print(16823*12302%3092)#2
age = int(input('возраст абитуриента'))#3
name = int(input('имя абитуриента'))
if 0 < age < 75 and name != 'Иван':
    if age >= 16:
        print('Поздравляем вы поступили в ВГУИТ')
    else:
        print('Сначала нужно окончить школу!')
        print('осталось до поступления:', 16 - age)
else:
    print('не соответствует критериям')
seconds = int(input())#4
dni = seconds//86400
chas = (seconds%86400)//3600
minut = ((seconds%86400)%3600)//60
sec = ((seconds%86400)%3600)%60
print(dni,chas,minut,sec)
n = int(input())#5
print(n + n**2 + n**3 + n**4 + n**5)
x = input()#6
y = input()
print(x,y)
x,y = y,x
print(x,y)
number = int(input())#7
if number%2 ==0:
    print('True')
else:
    print('False')