import tkinter
from tkinter import *
from tkinter.ttk import Combobox# добавление поля выбора курса
from tkinter.ttk import Checkbutton
from threading import Thread
from tkinter import ttk
import requests
import matplotlib.pyplot as plt
import csv
import pylab
import pandas as pd
import json
import numpy as np

state = {}
with open('state.json','r') as file:
    md = json.load(file)
    state.update(md)
    print(state)
requests = requests.get("https://api.exchangerate-api.com/v4/latest/RUB").json()
t = np.arange(0,100,10)

url1 = ("0")
url2 = ("0")
url3 = ("0")
url4 = ("0")
url5 = ("0")
url6 = ("0")

def curecy(cod):
    curenci = {}
    curenci.update(requests)
    return (curenci['rates'].get(cod))


def grapf(url):
    a = pd.read_xml(url)
    a.to_csv('Lilog.csv', index=False)
    X = []
    Y = []
    with open('LiLog.csv', 'r') as datafile:
        plotting = csv.reader(datafile, delimiter=',')
        for ROWS in plotting:
            ROWS[0] = ROWS[0].replace(',', '.')
            ROWS[4] = ROWS[4].replace(',', '.')
            if '.' in ROWS[4]:
                X.append(ROWS[0])
                Y.append(float(ROWS[4]))
            else:
                continue
    plt.plot(X, Y)

def grapf_total():
    grapf(url1)
    grapf(url2)
    grapf(url3)
    grapf(url4)
    grapf(url5)
    grapf(url6)

    plt.title('График курса валют')
    plt.show()


def window():
    window = Tk()
    window.title('Курс валют')
    window.geometry('700x600')

    l1 = tkinter.Label(window,text='')
    l1.place(x=330,y=175)

    def lable1():
        if chb1_state.get() == "On":
            l1.config(text=str(curecy('USD')))
        elif chb1_state.get() == 'Off':
            l1.config(text='')

    chb1_state = StringVar()
    chb1_state.set(state.get('USD'))
    chb1 = Checkbutton(window,text='Доллар США',variable = chb1_state,onvalue='On',offvalue="Off",command=lable1)
    chb1.place(x = 200,y = 175)

    l2 = tkinter.Label(window,text='')
    l2.place(x=330,y=150)

    def lable2():
        if chb2_state.get() == 'On':
            l2.config(text=str(curecy('EUR')))
        elif chb2_state.get() == 'Off':
            l2.config(text='')

    chb2_state = StringVar()
    chb2_state.set(state.get('EUR'))
    chb2 = Checkbutton(window,text='Евро',var = chb2_state,onvalue='On',offvalue='Off',command=lable2)
    chb2.place(x = 200, y = 150)

    l3 = tkinter.Label(window,text='')
    l3.place(x=330,y=125)

    def lable3():
        if chb3_state.get() == 'On':
            l3.config(text=str(curecy('CAD')))
        elif chb3_state.get() == 'Off':
            l3.config(text='')

    chb3_state = StringVar()
    chb3_state.set(state.get('CAD'))
    chb3 = Checkbutton(window,text='Канадский доллар',var = chb3_state,onvalue="On",offvalue="Off",command=lable3)
    chb3.place(x = 200, y = 125)

    l4 = tkinter.Label(window,text='')
    l4.place(x=330,y=100)

    def lable4():
        if chb4_state.get() == "On":
            l4.config(text=str(curecy('BYN')))
        elif chb4_state.get() == "Off":
            l4.config(text='')

    chb4_state = StringVar()
    chb4_state.set(state.get('BYN'))
    chb4 = Checkbutton(window,text='Белорусский рубль',var = chb4_state,onvalue="On",offvalue='Off',command=lable4)
    chb4.place(x=200,y=100)

    l5 = tkinter.Label(window,text='')
    l5.place(x=330,y=75)

    def lable5():
        if chb5_state.get() == 'On':
            l5.config(text=str(curecy('TRY')))
        elif chb5_state.get() == "Off":
            l5.config(text='')

    chb5_state = StringVar()
    chb5_state.set(state.get('TRY'))
    chb5 = Checkbutton(window,text='Турецуая лира',var = chb5_state,onvalue='On',offvalue="Off",command=lable5)
    chb5.place(x=200,y=75)

    l6 = tkinter.Label(window,text='')
    l6.place(x=330,y=50)

    def lable6():
        if chb6_state.get() == "On":
            l6.config(text=str(curecy('JPY')))
        elif chb6_state.get() == "Off":
            l6.config(text='')

    chb6_state = StringVar()
    chb6_state.set(state.get('JPY'))
    chb6 = Checkbutton(window,text='Японская йена',var = chb6_state,onvalue='On',offvalue='Off',command=lable6)
    chb6.place(x=200,y=50)

    lable_data= tkinter.Label(window,text='Введите дату для построения графика \n (например:21/01/2023-30/01/2023)')
    lable_data.place(x=250,y=240)

    lable_warning = tkinter.Label(window, text='')
    lable_warning.place(x=250, y=325)

    date = tkinter.Entry(window, background='#cfcec9', width=20)
    date.place(y=280,x = 300)
    date.insert(0,state.get('Entry'))

    def get_date():
        dinamo = date.get()
        date_reg1 = ''
        date_reg2 = ''
        for i in range(0,10):
            try:
                date_reg1 += dinamo[i]
            except IndexError:
                lable_warning.config(text='Дата введена не корректно!!!')
        for i in range(11,21):
            try:
                date_reg2 += dinamo[i]
            except IndexError:
                lable_warning.config(text='Дата введена не корректно!!!')
        global url1
        url1 = f"https://www.cbr.ru/scripts/XML_dynamic.asp?date_req1={date_reg1}&date_req2={date_reg2}&VAL_NM_RQ=R01235"
        global url2
        url2 = f"https://www.cbr.ru/scripts/XML_dynamic.asp?date_req1={date_reg1}&date_req2={date_reg2}&VAL_NM_RQ=R01239"
        global url3
        url3 = f"https://www.cbr.ru/scripts/XML_dynamic.asp?date_req1={date_reg1}&date_req2={date_reg2}&VAL_NM_RQ=R01350"
        global url4
        url4 = f"https://www.cbr.ru/scripts/XML_dynamic.asp?date_req1={date_reg1}&date_req2={date_reg2}&VAL_NM_RQ=R01090"
        global url5
        url5 = f"https://www.cbr.ru/scripts/XML_dynamic.asp?date_req1={date_reg1}&date_req2={date_reg2}&VAL_NM_RQ=R01700"
        global url6
        url6 = f"https://www.cbr.ru/scripts/XML_dynamic.asp?date_req1={date_reg1}&date_req2={date_reg2}&VAL_NM_RQ=R01820"
        Thread(target=grapf_total).start()
        state['USD'] = chb1_state.get()
        state['EUR'] = chb2_state.get()
        state['CAD'] = chb3_state.get()
        state['BYN'] = chb4_state.get()
        state['TRY'] = chb5_state.get()
        state['JPY'] = chb6_state.get()
        state['Entry'] = dinamo
        print(state)
        with open('state.json','w') as file:
            json.dump(state,file)


    date_butt = tkinter.Button(window,background='Red',text='Построить график', width=20,command=get_date).place(y=300,x=300)
    print(window)
    window.mainloop()
Thread(target=window).start()
