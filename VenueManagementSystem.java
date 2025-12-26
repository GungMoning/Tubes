import java.util.Scanner;

public class VenueManagementSystem {

    
    static String[] namaTempat = new String[50];
    static String[] lokasiTempat = new String[50];
    static int[] kapasitasTempat = new int[50];
    static String[] fasilitasTempat = new String[50];
    static int[] hargaTempat = new int[50];
    static int jumlahData = 0;

   
    static String[] pesanNama = new String[50];
    static String[] pesanTanggal = new String[50];
    static String[] pesanWaktu = new String[50];
    static int[] pesanDurasi = new int[50];
    static int[] pesanBiaya = new int[50];
    static int jumlahPesanan = 0;

    

    static String cekString(Scanner input) {
        String hasil;
        while (true) {
            hasil = input.nextLine();
            boolean adaIsi = false;

            for (int i = 0; i < hasil.length(); i++) {
                if (hasil.charAt(i) != ' ') {
                    adaIsi = true;
                    break;
                }
            }

            if (adaIsi) {
                return hasil;
            } else {
                System.out.println(">> Error: Data tidak boleh kosong!");
            }
        }
    }

    static int cekAngka(Scanner input) {
        while (true) {
            if (input.hasNextInt()) {
                int hasil = input.nextInt();
                input.nextLine();
                if (hasil > 0) {
                    return hasil;
                }else{
                System.out.println(">> Error: Angka harus positif!");
                }
            } else {
                System.out.println(">> Error: Input harus angka!");
                input.nextLine();
            }
        }
    }

    static int validasiInputOpsi(Scanner input, int min, int max) {
        int hasil;
        while (true) {
            if (input.hasNextInt()) {
                hasil = input.nextInt();
                input.nextLine(); 
                
                if (hasil >= min && hasil <= max) {
                    return hasil; 
                }else {
                    System.out.println(">> Error: Pilihan angka harus antara " + min + " s.d " + max);
                }
            }else {
                System.out.println(">> Error: Input harus berupa angka!");
                input.nextLine(); 
            }
        }
    }
   

    static void urutkanData() {
        for (int i = 0; i < jumlahData - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < jumlahData; j++) {
                if (hargaTempat[j] < hargaTempat[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                int tempHrg = hargaTempat[i]; 
                hargaTempat[i] = hargaTempat[minIdx]; 
                hargaTempat[minIdx] = tempHrg;
                String tempNm = namaTempat[i]; 
                namaTempat[i] = namaTempat[minIdx]; 
                namaTempat[minIdx] = tempNm;
                String tempLok = lokasiTempat[i]; 
                lokasiTempat[i] = lokasiTempat[minIdx]; 
                lokasiTempat[minIdx] = tempLok;
                int tempKap = kapasitasTempat[i]; 
                kapasitasTempat[i] = kapasitasTempat[minIdx]; 
                kapasitasTempat[minIdx] = tempKap;
                String tempFas = fasilitasTempat[i]; 
                fasilitasTempat[i] = fasilitasTempat[minIdx]; 
                fasilitasTempat[minIdx] = tempFas;
            }
        }
    }

    static void isiDataAwal() {
        namaTempat[0] = "Gedung Serbaguna"; lokasiTempat[0] = "Jakarta"; kapasitasTempat[0] = 500; fasilitasTempat[0] = "AC, Proyektor"; hargaTempat[0] = 100000;
        namaTempat[1] = "Aula Kampus"; lokasiTempat[1] = "Bandung"; kapasitasTempat[1] = 200; fasilitasTempat[1] = "Sound System"; hargaTempat[1] = 75000;
        namaTempat[2] = "Taman Kota"; lokasiTempat[2] = "Bogor"; kapasitasTempat[2] = 1000; fasilitasTempat[2] = "Panggung"; hargaTempat[2] = 50000;
        namaTempat[3] = "Cafe"; lokasiTempat[3] = "Bali"; kapasitasTempat[3] = 30; fasilitasTempat[3] = "Kursi, Meja"; hargaTempat[3] = 30000;

        jumlahData = 4;
        urutkanData();
    }

    static String potong(String teks, int max) {
        if (teks.length() > max) {
            return teks.substring(0, max - 3) + "...";
        }
        return teks;
    }

    static void tampilkanHeader() {
        System.out.println("╔═══════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                           SISTEM MANAJEMEN SEWA TEMPAT                                        ║");
        System.out.println("║                    Kelola Tempat Acara Anda dengan Mudah!                                     ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════╝");
    }

    static void tampilkanMenu() {
        System.out.println("\n┌─────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│ MENU UTAMA                                                                                  │");
        System.out.println("├─────────────────────────────────────────────────────────────────────────────────────────────┤");
        System.out.println("│ 1. Tambah Tempat Baru                                                                       │");
        System.out.println("│ 2. Cari Tempat                                                                              │");
        System.out.println("│ 3. Edit Tempat                                                                              │");
        System.out.println("│ 4. Hapus Tempat                                                                             │");
        System.out.println("│ 5. Tampilkan Tempat (Terurut Harga Termurah)                                                │");
        System.out.println("│ 6. Pesan Tempat                                                                             │");
        System.out.println("│ 7. Lihat Riwayat Pesanan                                                                    │");
        System.out.println("│ 8. Keluar                                                                                   │");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────┘");
        System.out.print("Pilih menu (1-8): ");
    }

    static void tambahTempat(Scanner input) {
        System.out.println("\n┌─────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│ INPUT DATA BARU                                                                             │");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────┘");

        System.out.print("Nama Tempat   : "); 
        namaTempat[jumlahData] = cekString(input);

        System.out.print("Lokasi        : "); 
        lokasiTempat[jumlahData] = cekString(input);

        System.out.print("Kapasitas     : "); 
        kapasitasTempat[jumlahData] = cekAngka(input);

        System.out.print("Fasilitas     : "); 
        fasilitasTempat[jumlahData] = cekString(input);
        
        System.out.print("Harga per Jam : "); 
        hargaTempat[jumlahData] = cekAngka(input);
        
        jumlahData++;
        urutkanData();
        System.out.println(">> Data berhasil disimpan!");
    }

    static void editTempat(Scanner input) {
        tampilkanTabel(); 
        System.out.println("\n┌─────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│ EDIT DATA TEMPAT                                                                            │");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────┘");
        System.out.print("Masukkan NAMA tempat yang mau diedit: ");
        String target = cekString(input);
        int index = -1;

        for (int i = 0; i < jumlahData; i++) {
            if (namaTempat[i].equalsIgnoreCase(target)) { 
                index = i; 
                break; 
            }
        }

        if (index != -1) {
            System.out.println("--- Masukkan Data Baru ---");
            System.out.print("Nama Baru      : "); 
            namaTempat[index] = cekString(input);
            System.out.print("Lokasi Baru    : "); 
            lokasiTempat[index] = cekString(input);
            System.out.print("Kapasitas Baru : "); 
            kapasitasTempat[index] = cekAngka(input);
            System.out.print("Fasilitas Baru : "); 
            fasilitasTempat[index] = cekString(input);
            System.out.print("Harga Baru     : "); 
            hargaTempat[index] = cekAngka(input);
            urutkanData();
            System.out.println(">> Data berhasil diupdate!");
        } else {
            System.out.println(">> Tempat tidak ditemukan.");
        }
    }

    static void hapusTempat(Scanner input) {
        tampilkanTabel();
        System.out.println("\n┌─────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│ HAPUS DATA TEMPAT                                                                           │");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────┘");
        System.out.print("Masukkan NAMA tempat yang mau dihapus: ");
        String target = cekString(input);
        int index = -1;

        for (int i = 0; i < jumlahData; i++) {
            if (namaTempat[i].equalsIgnoreCase(target)) { 
                index = i; 
                break; 
            }
        }

        if (index != -1) {
            for (int i = index; i < jumlahData - 1; i++) {
                namaTempat[i] = namaTempat[i + 1];
                lokasiTempat[i] = lokasiTempat[i + 1];
                kapasitasTempat[i] = kapasitasTempat[i + 1];
                fasilitasTempat[i] = fasilitasTempat[i + 1];
                hargaTempat[i] = hargaTempat[i + 1];
            }
            jumlahData--;
            System.out.println(">> Data berhasil dihapus.");
        } else {
            System.out.println(">> Tempat tidak ditemukan.");
        }
    }

    static void tampilkanTabel() {
        if (jumlahData == 0) {
            System.out.println(">> Data masih kosong.");
            return;
        }

        urutkanData();
        System.out.println("\n┌─────┬──────────────────────────────┬──────────────┬──────────┬────────────────────┬─────────────┐");
        System.out.println("│ No  │ Nama Tempat                  │ Lokasi       │ Kapasitas│ Fasilitas          │ Harga/Jam   │");
        System.out.println("├─────┼──────────────────────────────┼──────────────┼──────────┼────────────────────┼─────────────┤");

        for (int i = 0; i < jumlahData; i++) {
            System.out.printf("│ %-3d │ %-28s │ %-12s │ %-8d │ %-18s │ Rp %-8d │\n", 
            (i + 1), potong(namaTempat[i], 28), potong(lokasiTempat[i], 12), kapasitasTempat[i], potong(fasilitasTempat[i], 18), hargaTempat[i]);
        }
        System.out.println("└─────┴──────────────────────────────┴──────────────┴──────────┴────────────────────┴─────────────┘");
    }

    static void cariTempat(Scanner input) {
        System.out.println("\n┌─────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│ CARI TEMPAT                                                                                 │");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────┘");
        System.out.println("1. Nama");
        System.out.println("2. Lokasi");
        System.out.println("3. Kapasitas");
        System.out.print("Pilih opsi pencarian (1-3): ");
        int opsi = validasiInputOpsi(input, 1, 3);

        System.out.print("Masukkan kata kunci/angka: ");
        String kunci = input.nextLine();
        boolean ketemu = false;

        System.out.println("\nHASIL PENCARIAN:");
        System.out.println("┌─────┬──────────────────────────────┬──────────────┬──────────┬─────────────┐");
        System.out.println("│ No  │ Nama Tempat                  │ Lokasi       │ Kapasitas│ Harga/Jam   │");
        System.out.println("├─────┼──────────────────────────────┼──────────────┼──────────┼─────────────┤");

        for (int i = 0; i < jumlahData; i++) {
            boolean cocok = false;
            
            if (opsi == 1 && namaTempat[i].equalsIgnoreCase(kunci)){
                cocok = true;
                }else if (opsi == 2 && lokasiTempat[i].equalsIgnoreCase(kunci)){
                    cocok = true;
                }else if (opsi == 3) {
                    int kapCari = Integer.parseInt(kunci);
                    if (kapasitasTempat[i] >= kapCari) cocok = true;
                }

            if (cocok) {
                System.out.printf("│ %-3d │ %-28s │ %-12s │ %-8d │ Rp %-8d │\n", (i + 1), potong(namaTempat[i], 28), potong(lokasiTempat[i], 12), kapasitasTempat[i], hargaTempat[i]);
                ketemu = true;
            }
        }
        System.out.println("└─────┴──────────────────────────────┴──────────────┴──────────┴─────────────┘");
        if (!ketemu) System.out.println("Data tidak ditemukan.");
    }

    static void pesanTempat(Scanner input) {
        tampilkanTabel();
        System.out.println("\n┌─────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("│ FORM PEMESANAN                                                                              │");
        System.out.println("└─────────────────────────────────────────────────────────────────────────────────────────────┘");
        System.out.print("Pilih NOMOR tempat (sesuai tabel): ");
        int nomor = validasiInputOpsi(input, 1, jumlahData) - 1;

        if (nomor < 0 || nomor >= jumlahData) {
            System.out.println("Nomor tidak valid.");
            return;
        }

        System.out.print("Tanggal (dd-mm-yyyy)  : "); 
        String tgl = cekString(input);
        System.out.print("Waktu Acara (contoh 09:00): "); 
        String waktu = cekString(input);

        for (int i = 0; i < jumlahPesanan; i++) {
            if (pesanNama[i].equals(namaTempat[nomor]) && pesanTanggal[i].equals(tgl)) {
                System.out.println(">> Maaf, Tempat ini sudah dibooking pada tanggal tersebut.");
                return;
            }
        }

        System.out.print("Durasi Sewa (jam)     : "); 
        int durasi = cekAngka(input);

        int total = hargaTempat[nomor] * durasi;

        pesanNama[jumlahPesanan] = namaTempat[nomor];
        pesanTanggal[jumlahPesanan] = tgl;
        pesanWaktu[jumlahPesanan] = waktu;
        pesanDurasi[jumlahPesanan] = durasi;
        pesanBiaya[jumlahPesanan] = total;
        jumlahPesanan++;

        System.out.println(">> Sukses! Total Tagihan: Rp " + total);
    }

    static void lihatPesanan() {
        if (jumlahPesanan == 0) {
            System.out.println(">> Belum ada riwayat pesanan.");
            return;
        }

        System.out.println("\n┌─────┬─────────────────────────────────┬──────────────┬────────────┬────────────┬───────────────────────┐");
        System.out.println("│ No  │ Nama Tempat                     │ Tanggal      │ Waktu      │ Durasi     │ Total Bayar           │");
        System.out.println("├─────┼─────────────────────────────────┼──────────────┼────────────┼────────────┼───────────────────────┤");
        
        for (int i = 0; i < jumlahPesanan; i++) {
            System.out.printf("│ %-3d │ %-31s │ %-12s │ %-10s │ %-10d │ Rp %-18d │\n",
                (i + 1), potong(pesanNama[i], 31), pesanTanggal[i], pesanWaktu[i], pesanDurasi[i], pesanBiaya[i]);
        }
        System.out.println("└─────┴─────────────────────────────────┴──────────────┴────────────┴────────────┴───────────────────────┘");
    }

   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
         System.out.println("██████╗ ███████╗███╗   ██╗██╗   ██╗███████╗██╗    ██╗ █████╗  █████╗ ███╗   ██╗    ████████╗███████╗███╗   ███╗██████╗  █████╗ ████████╗     █████╗  ██████╗ █████╗ ██████╗  █████╗ \r\n" + //
                        "██╔══██╗██╔════╝████╗  ██║╚██╗ ██╔╝██╔════╝██║    ██║██╔══██╗██╔══██╗████╗  ██║    ╚══██╔══╝██╔════╝████╗ ████║██╔══██╗██╔══██╗╚══██╔══╝    ██╔══██╗██╔════╝██╔══██╗██╔══██╗██╔══██╗\r\n" + //
                        "██████╔╝█████╗  ██╔██╗ ██║ ╚████╔╝ █████╗  ██║ █╗ ██║███████║███████║██╔██╗ ██║       ██║   █████╗  ██╔████╔██║██████╔╝███████║   ██║       ███████║██║     ███████║██████╔╝███████║\r\n" + //
                        "██╔═══╝ ██╔══╝  ██║╚██╗██║  ╚██╔╝  ██╔══╝  ██║███╗██║██╔══██║██╔══██║██║╚██╗██║       ██║   ██╔══╝  ██║╚██╔╝██║██╔═══╝ ██╔══██║   ██║       ██╔══██║██║     ██╔══██║██╔══██╗██╔══██║\r\n" + //
                        "██║     ███████╗██║ ╚████║   ██║   ███████╗╚███╔███╔╝██║  ██║██║  ██║██║ ╚████║       ██║   ███████╗██║ ╚═╝ ██║██║     ██║  ██║   ██║       ██║  ██║╚██████╗██║  ██║██║  ██║██║  ██║\r\n" + //
                        "╚═╝     ╚══════╝╚═╝  ╚═══╝   ╚═╝   ╚══════╝ ╚══╝╚══╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝       ╚═╝   ╚══════╝╚═╝     ╚═╝╚═╝     ╚═╝  ╚═╝   ╚═╝       ╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝\r\n" + //
                        "                                                                                                                                                                                    ");
        isiDataAwal(); 
        tampilkanHeader();

        boolean jalan = true;
        while (jalan) {
            tampilkanMenu();

            int menu = validasiInputOpsi(input, 1, 8);

            switch (menu) {
                case 1: 
                    tambahTempat(input); 
                    break;
                case 2: 
                    cariTempat(input); 
                    break;
                case 3: 
                    editTempat(input); 
                    break;
                case 4: 
                    hapusTempat(input); 
                    break;
                case 5: 
                    tampilkanTabel(); 
                    break; 
                case 6: 
                    pesanTempat(input); 
                    break;
                case 7: 
                    lihatPesanan(); 
                    break;
                case 8: 
                    System.out.println("Terima kasih telah menggunakan sistem!");
                    jalan = false;
                    break;
                default: System.out.println("Pilihan tidak valid!");
            }
        }
        input.close();
    }
}