import java.util.Scanner;

public class MainKRS {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AntrianKRS antrian = new AntrianKRS(10); 
        int pilihan;

        do {
            System.out.println("\n=== MENU ANTRIAN KRS MAHASISWA ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Proses 2 Mahasiswa untuk KRS");
            System.out.println("3. Tampilkan Semua Antrian");
            System.out.println("4. Tampilkan 2 Terdepan");
            System.out.println("5. Tampilkan Antrian Terakhir");
            System.out.println("6. Cek Jumlah Antrian");
            System.out.println("7. Cek Jumlah yang Sudah Diproses");
            System.out.println("8. Cek Kuota DPA");
            System.out.println("9. Cek Sisa Antrian");
            System.out.println("10. Kosongkan Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();
                    antrian.tambahAntrian(new Mahasiswa(nim, nama, prodi, kelas));
                    break;
                case 2:
                    antrian.prosesKRS();
                    break;
                case 3:
                    antrian.tampilkanSemua();
                    break;
                case 4:
                    antrian.tampilkanDuaTerdepan();
                    break;
                case 5:
                    antrian.tampilkanTerakhir();
                    break;
                case 6:
                    antrian.cetakJumlahAntrian();
                    break;
                case 7:
                    antrian.cetakJumlahDiproses();
                    break;
                case 8:
                   System.out.println("Sisa Mahasiswa DPA: " + antrian.getSisakuotaDpa());
                   break;
                case 9:
                    System.out.println("Mahasiswa yang belum diproses: " + antrian.getJumlahBelumDiproses());
                    break; 
                case 10:
                    antrian.clear();
                    break;
                case 0:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 0);
    }
}
