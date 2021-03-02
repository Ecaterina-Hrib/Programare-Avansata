package org.example;
// clasa Museum implemeteaza clasa interfata Visitable,Payable pentru diferitele valori pe care le va avea obiectul de tip Museum
// deoarece am considerat ca un obiect de tip Museum nu va fi clasificat intr-un anumit fel
public class Museum extends Location implements Visitable,Payable{
    public Museum() {
    }
}
