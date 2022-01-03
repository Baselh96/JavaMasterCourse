package Passwortverschlüsselung;

public class Passwort {
    private final int key = 123456789;
    private double verschlusseltePasswort;
    private int passwort;
    public static final int tokey;
    static {
        tokey = 20;
        System.out.println("To key istalliert");
    }

    public Passwort(int passwort) {
        this.verschlusseltePasswort = verschlusseln(passwort);
        this.passwort =passwort;
    }
    static {
        System.out.println("To key nochmal istalliert");
    }
    private double verschlusseln(int passwort){
        return passwort ^ key;
    }
    public void storePasswort(){
        System.out.println("Passwort ist stored: "+ passwort);
    }
    public boolean einloggen(int passwort){
        if( verschlusseltePasswort == verschlusseln(passwort)){
            System.out.println("Welcome");
            return true;
        }else{
            System.out.println("Sie können nicht eingelogt werden");
            return false;
        }
    }
}
