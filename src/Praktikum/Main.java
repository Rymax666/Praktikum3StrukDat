package Praktikum;
/*
 * Rymax666
 * Fuck Everyone Else !
 */
public class Main {

    public static void main(String[] args) {
        Auth auth = new Auth();
        String email = "";
        String password = "";

        auth.dataAkun();
        auth.loginAkun(email,password);
    }
}
