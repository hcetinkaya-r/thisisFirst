#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Dec 11 02:23:06 2019

@author: hakancetinkaya
"""

def islem(kelime,operasyon,indeks):
    if operasyon == "*":
        return yildiz(kelime,indeks)
    elif operasyon == "+":
        return arti(kelime,indeks)
def yildiz(kelime,indeks):
    while kelime[indeks] == "*":
        indeks += 1 
    if (kelime[indeks:].count('*'))<=1:
        return kelime[:indeks] + kelime[indeks:].replace("*","")
    elif (kelime[indeks:].count('*'))>=2:
        y_ilkindeks = kelime.index("*",indeks)
        y_sonindeks = kelime.index("*",y_ilkindeks+1)
        return kelime[:y_ilkindeks] + kelime[y_sonindeks+1:]
    elif kelime[indeks] == '*':
        yildiz(kelime,indeks + 1)      
def arti(kelime,indeks):
    while kelime[indeks] == "+":
        indeks += 1
    if (kelime[indeks:].count('+'))<=1:
        return kelime[:indeks] + kelime[indeks:].replace("+","")
    elif (kelime[indeks:].count('+'))>=2:
        a_ilkindeks = kelime.index("+",indeks)
        a_sonindeks = kelime.index("+",a_ilkindeks+1)
        return kelime[:a_ilkindeks] + kelime[a_sonindeks+1:] + kelime[a_ilkindeks+1:a_sonindeks] 
    elif kelime[indeks] == '+':
        arti(kelime,indeks + 1)
          


 