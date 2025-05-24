public class AntrianKRS {

    Mahasiswa[] data;
    int front, rear, size, max, jumlahDiproses;

    public AntrianKRS(int max) {
        this.max = max;
        data = new Mahasiswa[max];
        front = 0;
        rear = -1;
        size = 0;
        jumlahDiproses = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
        jumlahDiproses = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }

    public void tambahAntrian(Mahasiswa mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh. Tidak bisa menambahkan " + mhs.nama);
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " telah ditambahkan ke antrian.");
    }

    public void prosesKRS() {
    if (jumlahDiproses + 2 > 30) {
        System.out.println("Kuota DPA telah penuh. Tidak bisa memproses mahasiswa lagi.");
        return;
    }

    if (size < 2) {
        System.out.println("Antrian kurang dari 2, proses KRS membutuhkan 2 mahasiswa.");
        return;
    }

    System.out.println("Mahasiswa yang diproses untuk KRS:");
    for (int i = 0; i < 2; i++) {
        Mahasiswa mhs = data[front];
        mhs.tampilkanData();
        front = (front + 1) % max;
        size--;
        jumlahDiproses++;
    }
}


    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar seluruh antrian:");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            data[index].tampilkanData();
        }
    }

    public void tampilkanDuaTerdepan() {
        if (size < 2) {
            System.out.println("Antrian tidak cukup untuk menampilkan 2 terdepan.");
            return;
        }
        System.out.println("2 Mahasiswa terdepan:");
        for (int i = 0; i < 2; i++) {
            int index = (front + i) % max;
            data[index].tampilkanData();
        }
    }

    public void tampilkanTerakhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa paling akhir dalam antrian:");
            data[rear].tampilkanData();
        }
    }

    public void cetakJumlahAntrian() {
        System.out.println("Jumlah antrian saat ini: " + size);
    }

    public void cetakJumlahDiproses() {
        System.out.println("Jumlah mahasiswa yang sudah diproses: " + jumlahDiproses);
    }

    public int getSisakuotaDpa() {
        return 30 - jumlahDiproses;
    }

     public int getJumlahBelumDiproses() {
        return size;
    }
}
