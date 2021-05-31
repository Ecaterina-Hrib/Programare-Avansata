# Programare-Avansata
Lab13-> compulsory

- package for resource 
- package com for the DisplayLocales, SetLocale, Information
- language tag with information
- class App for LocaleExplore
- translation

Lab12-> Compulsory

- inputul este hardcodat si este pus dintr-o oarecare locatie din file system
- identificat clasa specificata in memeorie
- am luat informatii despre fisier
- si am rulat teste cu adnotarile @Test ca demo

Lab 11-> compulsory + optional

- am creat tabela friends
- am creat o clasa entitate, un repository, un serviciu si un controller pentru functionalitatea de relationship/friendship
- am facut serviciu si pentru most famous si pentru least famous(le-am facut pe ambele)
- am inclus functionalitatile din proiectul trecut de client/server in metoda spring boot/mvc
- am facut o clasa de Exception Handler pentru RestControllerAdvice, pentru error handling cand raspunsul de la server trebuie sa fie diferit de 201 OK
- am facut si un serviciu pentru search friends dupa id1 sau id2
- am facut pe langa si un serviciu pentru numarul de prieteni
- am creat proiectul in Spring Boot
- am creat userul
- am facut pentru acesta un rest controller, un serviciu, si un model
- am urmat protocolul http si am facut operatii pe user de GET,PUT,POST si DELETE
- am testat si in Postman actiunile pe resurse


Lab 10-> compulsory + optional
- pentru optional am facut un folder diferit, deoarece am mers pe alta arhitectura
- am facut aplicatia orientata pe obiect, cu Theduri pentru client, model pentru client, unde se stocheaza difeite mesaje/ prieteni
- am facut comanda de stop de shutdown la server
- am implementat comenzile login, register,logout,read,send
- am setat pe server un timeout de inactivitate de 18000 secunde si acesta se inchide la numarul de secunde 
- in folderul lab 10 sunt 2 variante de proiect
- in primul folder am creat 2 proj application dar pt git le-am integrat in unul <3
- in al doilea folder am pus 2 cu 2 proj application, nu am stiut pe care sa le pun si le-am pus pe ambele
- am creat proj Server ce face apel la clientii pe diferite threaduri folosind algoritmul TCP prezentat in curs
- la fel am procedat si pentru proj Client ce comunica cu client Socket 
- comanda exit


Lab 9-> compulsory
- am folosit hibernate si facut persistence.xml
- am facut entity classes
- singleton pt EntityManagerFactory object
- repositories classes

Lab 8 -> optional + compulsory 
- pentru bonus, in plus am extins baza de date movies, pentru a aduga mai multe fielduri din csv, si am modificat si Model, cat si Controllerul
- am folosit opencsv ca librarie pentru manipularea datelor si adaugarea lor inj baza de date locala
- am adaugat tabbele pentru Directori si Actori
- am facut orientat model cu Modele si Controllere 
- clasele Movie cu Genre
- conexiunea cu baza de date
- am folosit Oracle localhost


Lab7-> compulsory 
- am creat clasa Player, Board, Game si Token
- intr-un game sunt playeri carora li se asigneaza un Board
- in Board se afla este lista de tokenuri

Lab6-> compulsory + 1/2 optional (shapes + config shapes, and delete last shape)
- clasa MainFrame, ConfigPanel,DrawingPanel,ControlPanel & RelgularPoygon

Lab5->compulsory+ 1/2 optional 
- clasa Catalog ce retine un array de clasa Pictures pentru fisiere de tip poza, cat si clasa Song
- am facut o interfata pentru Catalog unde sunt declarate metodele pentru comenzi, clasa Item unde sunt stocate fisierele de diferite tipuri


Lab4-> compulsory-ul deocamdata, am creat clasa Student si SChool si am folosit streamurile si lambda-urile pentru a initializa obiectele cat si a le manipula, am folosit LinkedList, cat si 2 ,mapuri pentru a afisa datele din obiectele School si Student


Lab3-> este facut doar compulsory-ul + optionalul
-> Clasa City, Hotel, Museum, Church,Restaurant,Location
-> interfata Payable, Visitable, Classifiable
-> clasele interfata sunt incluse dupa nevoie in clasele de tip


Lab2-> este facut doar compulsory-ul 

-am creat clasele Sourcetype(enum),Source,Destination si Problem;

-in Source am intergrat SourceType;

-in Problem am integrat Source + Destination;

-in App.java am apelat Clasa Problem;


Lab1-> este denumit test1(compulsory + 1/2 optional)-corectate
