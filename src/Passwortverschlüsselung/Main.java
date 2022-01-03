package Passwortverschlüsselung;

public class Main {
    public static void main(String[] args) {
        Passwort passwort = new Passwort(1996);
        passwort.storePasswort();
        System.out.println(1996 ^ 123456789);

    }
}
