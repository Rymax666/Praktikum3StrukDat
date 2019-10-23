package Praktikum;
/*
* Rymax666
* Fuck Everyone Else !
 */
import java.util.HashMap;
import java.util.Scanner;

public class Auth {
    Scanner scan = new Scanner(System.in);
    int pilih = 0;
    int hitungLogin = 0;
    int hitungLogout = 0;

    //KEGIATAN 1
    HashMap<String, String> tabelAkun = new HashMap<String, String>();
    //KEGIATAN 2
    HashMap<String, String> tabelSesiLogin = new HashMap<String, String>();

    public boolean dataAkun() {
        tabelAkun.put("Labit@umm.ac.id", "Labit123");
        tabelAkun.put("Rymax.xxx@gmail.com", "bendycakep");
        tabelAkun.put("dosen_tamvan@umm.ac.id", "gantengnyaa");
        tabelAkun.put("SofyanArifinto666@gmail.com", "ngulangkalkulus");
        tabelAkun.put("Lord_Sofyan@darkness.com", "mampoeskalean");
        return false;
    }

    public boolean registerAkun(String email, String password) {
        System.out.println("-Register Akun-");
        System.out.print("Masukan Email : ");
        email = scan.next();
        System.out.println("Masukkan Password : ");
        password = scan.next();

        if (tabelAkun.containsKey(email) == true) {
            System.out.println("Gagal Input bos , Email e wes onok");
            System.out.println("Miliho Bos");
            System.out.println("1. Register Maneh");
            System.out.println("2. Opo Login");
            pilih = scan.nextInt();
            if (pilih == 1) {
                registerAkun(email, password);
            } else if (pilih == 2) {
                loginAkun(email, password);
            } else {
                tabelAkun.put(email, password);
                System.out.println("Register Berhasil bossku , login o maneh : ");
                loginAkun(email, password);
            }
        }
        return false;
    }

    public boolean hapusAkun(String email, String kornfirm) {
        System.out.println("Hapus Akun Bos");
        System.out.print("Masukno Email e Bos : ");
        email = scan.next();
        System.out.println("Konfirmasi Password Bos : ");
        kornfirm = scan.next();
        if (tabelAkun.containsKey(email) == true && tabelAkun.containsValue(kornfirm) == true) {
            if (tabelSesiLogin.containsKey(email) == true) {
                System.out.println("Datane Sek Digawe Bos");
            } else {
                tabelAkun.remove(email);
                System.out.println("Berhasil Dihapus bos");
            }
        } else {
            System.out.println("Datane Gak Onok Bos");
        }
        return false;
    }

    public int totalEmailUMM() {
        int count = 0;
        for (String key : tabelAkun.keySet()) {
            if (key.endsWith("@umm.ac.id")) {
                count++;
            } else {
                count = count;
            }
        }
        System.out.println("Total Akun Dengan Email Umm : " + count);
        return 0;
    }

    public boolean loginAkun(String email, String password) {
        System.out.println("Pilihan : ");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print(">>>  ");
        pilih = scan.nextInt();
        switch (pilih) {
            case 1:
                System.out.println("-Login-");
                System.out.print("Masukkan Email : ");
                email = scan.next();
                System.out.print("Masukkan Password : ");
                password = scan.next();
                if (tabelAkun.containsKey(email) == true && tabelAkun.containsValue(password) == true) {
                    tabelSesiLogin.put(email, password);
                    hitungLogin += 1;
                    System.out.println("Berhasil Login Bos");
                    home(email, password);
                } else {
                    System.out.println("Login Gagal Bos , Mbaleni maneh");
                    loginAkun(email, password);
                }
                break;

            case 2:
                registerAkun(email, password);
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Gaonok boss boss");
                break;
        }
        return false;
    }

    public boolean logoutAkun(String s, String email) {
        System.out.println("-Logout-");
        System.out.print("Masukkan Email : ");
        email = scan.next();
        if (tabelSesiLogin.containsKey(email) == true) {
            tabelSesiLogin.remove(email);
            hitungLogout += 1;
            System.out.println("Logout Berhasil Bos");
        } else {
            System.out.println("Logout Gagal Bos");
            logoutAkun(email, email);
        }
        return false;
    }

    public int totalLogout() {
        System.out.println("\nJumlah Logout Akun : " + hitungLogout);
        return 0;
    }

    public int totalLogin() {
        System.out.println("\nJumlah Login Akun : " + hitungLogin);
        System.out.println();
        return 0;
    }

    public int totalAuth() {
        System.out.println("\n-Total data yg sedang login-");
        System.out.println("Total : " + tabelSesiLogin);
        System.out.println();
        return 0;
    }

    public void hapus(String email, String konfirm) {
        hapusAkun(email, konfirm);
    }

    public void home(String email, String password) {
        System.out.println("\n\nLogin Berhasil!");
        System.out.println("Menu : ");
        System.out.println("1. Total Akun Yang Login");
        System.out.println("2. Total Akun Yang Logout");
        System.out.println("3. Total Akun Yang Dengan Login");
        System.out.println("4. Total Akun Dengan Email UMM");
        System.out.println("5. Hapus Akun");
        System.out.println("6. Logout");
        System.out.print("Pilih : ");
        pilih = scan.nextInt();
        switch (pilih) {
            case 1:
                totalLogin();
                home(email, password);
                break;
            case 2:
                totalLogout();
                home(email, password);
                break;
            case 3:
                totalAuth();
                home(email, password);
                break;
            case 4:
                totalEmailUMM();
                home(email, password);
                break;
            case 5:
                String konfirm = "";
                password = konfirm;
                hapus(email, password);
                home(email, password);
                break;
            case 6:
                logoutAkun(email, email);
                logoutAkun(email, password);
                break;
            default:
                System.out.println("Gaonok Boss");
                break;
        }
    }
}


