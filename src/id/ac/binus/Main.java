package id.ac.binus;

/*
*
* KELOMPOK 1
*
* ADNAN BAYU AJI
* DWI MAHMUD EFFENDI
* ARIGHI YUSKOWANASTRA
* PEBRY HARNELFI MIRZA
*
* */

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int statusint;
    static Unit_Kost unit;
    static Paket_Fasilitas fas;
    private static String idunitkost;

    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Scanner input = new Scanner (System.in);
        fas = new Paket_Fasilitas();
        Penyewa pen = new Penyewa();
        unit = new Unit_Kost();
        Transaksi_Sewa trs = new Transaksi_Sewa();
        Main app = new Main();

        DateFormat formattanggal = new SimpleDateFormat("dd-MM-yyyy");      //pembuatan objek formattanggal

        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance(); /*FORMAT UANG RUPIAH*/
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();     //Format Rupiah

        String fasilitas = null;
        String status;
        /*FORMAT MATA UANG RUPIAH*/
        /////////////////////////////////////////////////////////////////
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        /////////////////////////////////////////////////////////////////

        String id = null;
        String deskripsi;
        String id_fsl;
        double harga = 0;
        int jumlah = 0;

        String nama = null;
        String tanggalal;
        String telp ;
        Date tanggallahir = null;
        String choose;

        int bts, bts2;
        int pe;
        int pil = 0, pil2 = 0;
        String pil3;
        String improt;

        double hargasewa = 0;

        fas.dataFasilitas();
        unit.dataUnitKost();
        pen.dataPenyewa();

        String idsewa;
        String idkost;
        int posisiuk = 0;

        do
        {
            bts = 0;
            System.out.println("=========================================");
            System.out.println("Sewa Kost Sejahtera");
            System.out.println("=========================================");
            System.out.println("MENU:");
            System.out.println("1. Lihat Data Fasilitas Kost");
            System.out.println("2. Kelola Data Penyewa");
            System.out.println("3. Kelola Unit Kos");
            System.out.println("4. Transaksi");
            System.out.println("5. Lihat Transaksi");
            System.out.println("6. KELUAR");
            do
            {
                pe = 0;
                System.out.print("MASUKKAN PILIHAN : ");
                try
                {
                    pil = Integer.parseInt(input.nextLine());
                }
                catch(Exception exc)
                {
                    System.out.println("Masukkan Angka");
                    pe = 1;
                }
            }
            while(pe == 1);
            System.out.println("-----------------------------------------");
            switch(pil)
            {
                case 1:
                    do
                    {
                        fas.lihatFasilitas();
                        System.out.println("TEKAN 'Q' UNTUK KEMBALI KE MAIN MENU ...");
                        improt = input.nextLine();
                    }
                    while(!improt.equals("Q"));
                    System.out.println("-----------------------------------------");
                    break;
                case 2:
                    do
                    {
                        System.out.println("KELOLA DATA PENYEWA");
                        System.out.println("1. TAMBAH PENYEWA");
                        System.out.println("2. LIHAT PENYEWA");
                        System.out.println("3. HAPUS PENYEWA");
                        do
                        {
                            pe = 0;
                            System.out.print("MASUKKAN PILIHAN : ");
                            try
                            {
                                pil2 = Integer.parseInt(input.nextLine());
                            }
                            catch(Exception exc)
                            {
                                System.out.println("Masukkan Angka");
                                pe = 1;
                            }
                        }
                        while(pe == 1);
                        System.out.println("-----------------------------------------");
                        switch(pil2)
                        {
                            case 1:
                                //data.tambahKost();
                                System.out.println("TAMBAH DATA PENYEWA");
                                System.out.print("NAMA\t: ");
                                nama = input.nextLine();
                                do
                                {
                                    pe = 0;
                                    System.out.print("TANGGAL LAHIR(dd-mm-yyyy)\t: ");
                                    try
                                    {
                                        tanggalal = input.nextLine();
                                        tanggallahir = formattanggal.parse(tanggalal);
                                    }
                                    catch(Exception exc)
                                    {
                                        System.out.println("Format tanggal tidak sesuai");
                                        pe = 1;
                                    }
                                }
                                while(pe == 1);
                                System.out.print("Nomor Telepon\t: ");
                                telp = input.nextLine();
                                id = pen.getIDAuto();
                                pen.tambahData(id, nama, tanggallahir, telp);   //pemberian nilai pada objek data sesuai dengan parameter yang diminta
                                System.out.println("Data Berhasil Disimpan");
                                System.out.println("");
                                break;
                            case 2:
                                System.out.println("LIHAT DATA PENYEWA");
                                System.out.println("ID\t\tNAMA\t\tTGL. LAHIR\t\tUMUR\t\tTELP");
                                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                                List penyewa;
                                penyewa = pen.getListPenyewa();

                                for (Object o : penyewa) {
                                    Penyewa a = (Penyewa) o;      //menampilkan setiap yang akan ditampilkan sesuai urutan index mengikuti dengan perulangan
                                    System.out.println(a.getId() + "\t\t" + a.getNama() + "\t\t" + formattanggal.format(a.getTtl()) + "\t\t" + a.getumurnya() + "\t\t" + a.getTelp());
                                }
                                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                                break;
                            case 3:
                                System.out.println("HAPUS DATA PENYEWA");
                                pen.hapusFasilitas();
                                break;
                            default:
                                System.out.println("Masukkan Salah");
                                break;
                        }
                        System.out.println("-----------------------------------------");

                        System.out.println("TEKAN 'K' UNTUK KEMBALI...");
                        System.out.println("TEKAN 'Q' UNTUK KEMBALI KE MENU");
                        pil3 = input.nextLine();
                        switch(pil3)
                        {
                            case "K":
                                bts2=0;
                                break;
                            case "Q":
                                bts2=1;
                                break;
                            default:
                                bts2=0;
                                System.out.println("Masukkan Salah");
                                break;
                        }
                        System.out.println("-----------------------------------------");
                    }
                    while(bts2==0);
                    break;
                case 3:
                    do
                    {
                        System.out.println("Kelola Unit Kost");
                        System.out.println("1. TAMBAH UNIT KOST");
                        System.out.println("2. LIHAT UNIT KOST");
                        System.out.println("3. HAPUS UNIT KOST");
                        do
                        {
                            pe = 0;
                            System.out.print("MASUKKAN PILIHAN : ");
                            try
                            {
                                pil2 = Integer.parseInt(input.nextLine());
                            }
                            catch(Exception exc)
                            {
                                System.out.println("Masukkan Angka");
                                pe = 1;
                            }
                        }
                        while(pe == 1);
                        System.out.println("-----------------------------------------");
                        switch(pil2)
                        {
                            case 1:
                                //data.tambahKost();
                                System.out.println("TAMBAH UNIT KOST");
                                System.out.print("DESKRIPSI\t: ");
                                deskripsi = input.nextLine();

                                fas.lihatFasilitas2();

                                System.out.println("ID FASILITAS\t: ");
                                id_fsl = input.nextLine();
                                do
                                {
                                    pe=0;
                                    System.out.print("Harga Sewa\t\t: ");
                                    try
                                    {
                                        harga = Double.parseDouble(input.nextLine());
                                        if(harga<1)
                                        {
                                            throw new Exception();
                                        }
                                    }
                                    catch(Exception exc)
                                    {
                                        System.out.println("Inputan harus angka(rupiah) diatas 0");
                                        pe=1;
                                    }
                                }
                                while(pe==1);
                                System.out.println("1. Tersedia\t0. Tidak Tersedia");
                                do
                                {
                                    pe=0;
                                    System.out.print("STATUS[1/0]\t: ");
                                    try
                                    {
                                        jumlah = Integer.parseInt(input.nextLine());
                                        if(jumlah==0||jumlah==1)
                                        {
                                        }
                                        else
                                        {
                                            throw new Exception();
                                        }
                                    }
                                    catch(Exception exc)
                                    {
                                        System.out.println("Inputan harus angka 0 atau 1");
                                        pe=1;
                                    }
                                }
                                while(pe==1);
                                id = unit.getIDAuto();
                                unit.tambahData(id, deskripsi, id_fsl, harga, jumlah);   //pemberian nilai pada objek data sesuai dengan parameter yang diminta
                                System.out.println("Data Berhasil Disimpan");
                                System.out.println("");
                                break;
                            case 2:
                                app.LihatKost();
                                System.out.println("TEKAN 'U' UNTUK MENGUBAH");
                                System.out.println("PILIH SELAIN 'U' UNTUK TIDAK MENGUBAH DATA");
                                choose = input.nextLine();
                                if ("U".equals(choose)) {
                                    System.out.println("UBAH UNIT KOST");

                                    System.out.print("MASUKKAN ID UNIT KOST\t: ");
                                    idunitkost = input.nextLine();

                                    System.out.println("LIHAT UNIT KOST");
                                    System.out.println("ID\t\tDEKSRIPSI\t\tFASILITAS\t\tHARGA\t\tSTATUS");
                                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                                    List unitkost = unit.getUnitKost();
                                    List pf = fas.getPF();

                                    for (int i = 0; i < unitkost.size(); i++) {
                                        Unit_Kost a = (Unit_Kost) unitkost.get(i);      //menampilkan setiap yang akan ditampilkan sesuai urutan index mengikuti dengan perulangan
                                        if (idunitkost.equals(a.getId())) {
                                            id = a.getId();
                                            if (a.getStatusKost() == 1) {
                                                status = "TERSEDIA";
                                            } else {
                                                status = "TIDAK TERSEDIA";
                                            }

                                            for (Object o : pf) {
                                                Paket_Fasilitas b = (Paket_Fasilitas) o;

                                                if (a.getId_fsl().equals(b.getId())) {
                                                    fasilitas = b.getFasilitas();
                                                }
                                            }
                                            System.out.println(a.getId() + "\t\t" + a.getDeskripsi() + "\t\t" + fasilitas + "\t\t" + kursIndonesia.format(a.getHargasewa()) + "\t\t" +
                                                    status);
                                            posisiuk = i;
                                            break;
                                        }
                                    }
                                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

                                    System.out.print("DESKRIPSI\t: ");
                                    deskripsi = input.nextLine();

                                    fas.lihatFasilitas2();

                                    System.out.println("ID FASILITAS\t: ");
                                    id_fsl = input.nextLine();
                                    do {
                                        pe = 0;
                                        System.out.print("Harga Sewa\t\t: ");
                                        try {
                                            harga = Double.parseDouble(input.nextLine());
                                            if (harga < 1) {
                                                throw new Exception();
                                            }
                                        } catch (Exception exc) {
                                            System.out.println("Inputan harus angka(rupiah) diatas 0");
                                            pe = 1;
                                        }
                                    }
                                    while (pe == 1);
                                    System.out.println("1. Tersedia\t0. Tidak Tersedia");
                                    do {
                                        pe = 0;
                                        System.out.print("STATUS[1/0]\t: ");
                                        try {
                                            jumlah = Integer.parseInt(input.nextLine());
                                            if (jumlah == 0 || jumlah == 1) {
                                            } else {
                                                throw new Exception();
                                            }
                                        } catch (Exception exc) {
                                            System.out.println("Inputan harus angka 0 atau 1");
                                            pe = 1;
                                        }
                                    }
                                    while (pe == 1);

                                    Unit_Kost unita = new Unit_Kost(id, deskripsi, id_fsl, harga, jumlah);
                                    unitkost.remove(posisiuk);         //hapus data arraylist
                                    unitkost.add(posisiuk, unita);   //tambahkan data yang baru

                                    System.out.println("Data Berhasil Disimpan");
                                    System.out.println("");
                                }
                                break;
                            case 3:
                                System.out.println("HAPUS UNIT KOST");
                                unit.hapusUnitKost();
                                break;
                            default:
                                System.out.println("Masukkan Salah");
                                break;
                        }
                        System.out.println("-----------------------------------------");
                        System.out.println("TEKAN 'K' UNTUK KEMBALI...");
                        System.out.println("TEKAN 'Q' UNTUK KEMBALI KE MENU");
                        pil3 = input.nextLine();
                        switch(pil3)
                        {
                            case "K":
                                bts2=0;
                                break;
                            case "Q":
                                bts2=1;
                                break;
                            default:
                                bts2=0;
                                System.out.println("Masukkan Salah");
                                break;
                        }
                        System.out.println("-----------------------------------------");
                    }
                    while(bts2==0);
                    break;
                case 4:
                    System.out.print("TRANSAKSI SEWA\t: ");
                    Calendar cal = Calendar.getInstance();
                    String tgltrans = formattanggal.format(cal.getTime());
                    System.out.println(tgltrans);
                    Date tanggalnew = formattanggal.parse(tgltrans);
                    System.out.print("MASUKKAN ID PENYEWA\t:");
                    idsewa = input.nextLine();
                    System.out.print("MASUKKAN ID KOST\t:");
                    idkost = input.nextLine();
                    System.out.print("TOTAL YANG HARUS DIBAYARKAN\t:");
                    List ukkos = unit.getUnitKost();
                    for (Object ukko : ukkos) {
                        Unit_Kost ab = (Unit_Kost) ukko;      //menampilkan setiap yang akan ditampilkan sesuai urutan index mengikuti dengan perulangan
                        if (idkost.equals(ab.getId())) {
                            hargasewa = ab.getHargasewa();
                            System.out.println(kursIndonesia.format(hargasewa));
                            break;
                        }
                    }
                    System.out.print("BAYAR(Y/T)? ");
                    String pilx = input.nextLine();
                    if(pilx.equals("Y")||pilx.equals("y"))
                    {
                        do
                        {
                            pe=0;
                            System.out.print("MASUKKAN UANG PEMBAYARAN\t:");
                            try
                            {
                                jumlah = Integer.parseInt(input.nextLine());
                                if(jumlah<hargasewa)
                                {
                                    throw new Exception();
                                }
                            }
                            catch(Exception exc)
                            {
                                System.out.println("Inputan harus diatas pembayaran");
                                pe=1;
                            }
                        }
                        while(pe==1);
                        System.out.println("KEMBALI\t:"+kursIndonesia.format(jumlah-hargasewa));
                        statusint = 1;
                    }
                    else
                    {
                        statusint = 0;
                    }
                    trs.tambahTrans(trs.getIDAutoTrans(), tanggalnew, idsewa, idkost, hargasewa, statusint);
                    System.out.println("-----------------------------------------");
                    break;
                case 5:

                    System.out.println("LIHAT TRANSAKSI");
                    System.out.println("ID\t\tTanggal\t\tNama Penyewa\t\tNo Unit\t\tTotal Bayar\t\tStatus");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    List trans = trs.getTransaksi();
                    List sewaan = pen.getListPenyewa();

                    for (Object tran : trans) {
                        Transaksi_Sewa a = (Transaksi_Sewa) tran;      //menampilkan setiap yang akan ditampilkan sesuai urutan index mengikuti dengan perulangan
                        if (a.getStatus() == 1) {
                            status = "Lunas";
                        } else {
                            status = "Belum";
                        }

                        for (Object o : sewaan) {
                            Penyewa bs = (Penyewa) o;

                            if (a.getPenyewa_id().equals(bs.getId())) {
                                nama = bs.getNama();
                            }
                        }
                        System.out.println(a.getId() + "\t\t" + formattanggal.format(a.getTanggal()) + "\t\t" + nama + "\t\t" + a.getKost_id() + "\t\t" +
                                kursIndonesia.format(a.getTotalbayar()) + "\t\t" + status);
                    }
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println("-----------------------------------------");

                    break;
                case 6:
                    System.out.println("=========================================");
                    System.out.println("TERIMAKASIH TELAH MENGGUNAKAN PROGRAM INI");
                    System.out.println("=========================================");
                    bts=1;
                    break;
                default:
                    System.out.println("Masukan Salah");
                    break;
            }
        }
        while(bts==0);
    }

    public void LihatKost()
    {
        String status;
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance(); /*FORMAT UANG RUPIAH*/
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();     //Format Rupiah

        String fasilitas = null;
        /*FORMAT MATA UANG RUPIAH*/
        /////////////////////////////////////////////////////////////////
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        /////////////////////////////////////////////////////////////////
        System.out.println("LIHAT UNIT KOST");
        System.out.println("ID\t\tDEKSRIPSI\t\t\t\tFASILITAS\t\t\t\tHARGA\t\t\t\tSTATUS");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        List unitkost = unit.getUnitKost();
        List pf = fas.getPF();

        for (Object value : unitkost) {
            Unit_Kost a = (Unit_Kost) value;      //menampilkan setiap yang akan ditampilkan sesuai urutan index mengikuti dengan perulangan
            if (a.getStatusKost() == 1) {
                status = "TERSEDIA";
            } else {
                status = "TIDAK TERSEDIA";
            }

            for (Object o : pf) {
                Paket_Fasilitas b = (Paket_Fasilitas) o;

                if (a.getId_fsl().equals(b.getId())) {
                    fasilitas = b.getFasilitas();
                }
            }
            System.out.println(a.getId() + "\t\t" + a.getDeskripsi() + "\t\t" + fasilitas + "\t\t" + kursIndonesia.format(a.getHargasewa()) + "\t\t" +
                    status);
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }
}
