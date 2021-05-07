/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.binus;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Unit_Kost extends Abstract_Kost{
    private String id;
    private String deskripsi;
    private String id_fsl;
    private double hargasewa;
    private int statuskost;
    private int awal =0;
    int bts, bts1, bts2, bts3, bts4;
    Paket_Fasilitas fas = new Paket_Fasilitas();
    Scanner input = new Scanner(System.in);
    
    List unitkost = new ArrayList();
    List uk = new ArrayList();
    
    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance(); /*FORMAT UANG RUPIAH*/
    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();     //Format Rupiah
    
    public List getUnitKost()
    {
        return unitkost;
    }
    
    public Unit_Kost() {
    }

    public int getAwal() {
        return awal;
    }
    
    public Unit_Kost(String id, String deskripsi, String id_fsl, double hargasewa, int statuskost) {
        this.id = id;
        this.deskripsi = deskripsi;
        this.id_fsl = id_fsl;
        this.hargasewa = hargasewa;
        this.statuskost = statuskost;
    }

    public String getId() {
        return id;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getId_fsl() {
        return id_fsl;
    }

    public double getHargasewa() {
        return hargasewa;
    }

    @Override
    public int getStatusKost() {
        return statuskost;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setId_fsl(String id_fsl) {
        this.id_fsl = id_fsl;
    }

    public void setHargasewa(double hargasewa) {
        this.hargasewa = hargasewa;
    }

    public void setStatuskost(int statuskost) {
        this.statuskost = statuskost;
    }
    
    public void dataUnitKost()
    {
        awal = 1;
        Unit_Kost kos1 = new Unit_Kost("KS001", "ALAMANDA", "FS001", 1575000, 1);    //pembuatan objek baru
        unitkost.add(kos1); //simpan objek baru kedalam array list
        uk.add(1);  //id otomatis jadi 1
        
        Unit_Kost kos2 = new Unit_Kost("KS002", "BOUGENVILLE", "FS002", 1300000, 1);    //pembuatan objek baru
        unitkost.add(kos2); //simpan objek baru kedalam array list
        uk.add(2);  //id otomatis jadi 1
        
        Unit_Kost kos3 = new Unit_Kost("KS003", "CHRYSANT", "FS003", 975000, 1);    //pembuatan objek baru
        unitkost.add(kos3); //simpan objek baru kedalam array list
        uk.add(3);  //id otomatis jadi 1
        
        Unit_Kost kos4 = new Unit_Kost("KS004", "CHRYSANT", "FS003", 975000, 0);    //pembuatan objek baru
        unitkost.add(kos4); //simpan objek baru kedalam array list
        uk.add(4);  //id otomatis jadi 1
        
        Unit_Kost kos5 = new Unit_Kost("KS005", "DAHLIA", "FS001", 1575000, 1);    //pembuatan objek baru
        unitkost.add(kos5); //simpan objek baru kedalam array list
        uk.add(5);  //id otomatis jadi 1
    }
    
    public String getIDAuto()
    {
        //Logic get ID auto
        int temp;       //temp menyimpan angka sementara dari list
        
        if(awal==0)     //jika data dimulai dari awal
        {
            temp = 0;
            awal = 1;
        }
        else            //jika data tidak ditambahkan di awal
        {
            temp = (int) Collections.max(uk);   //mencari data dalam array yang paling besar
        }
        
        String ID = "";     //String id dimulai dengan data kosong
        temp = temp+1;      //temp bertambah 1
        uk.add(temp);       //simpan temp ke dalam array list
        if(temp<10)         //jika temp lebih kecil dari 10
        {
            ID = "KS00";
        }
        else if(temp<100)   //jika temp lebih kecil dari 100
        {
            ID = "KS0";
        }
        else if(temp<1000)  //jika temp lebih kecil dari 1000
        {
            ID = "KS";
        }
        
        String no = Integer.toString(temp); //temp diubah dari integer ke String
        String IDfix = ID + no;             //IDfix = ID + no
        return IDfix;                       //return ID fix
    }

    public void tambahData(String id, String deskripsi, String id_fsl, double hargasewa, int statuskost) {
        Unit_Kost unit = new Unit_Kost(id, deskripsi, id_fsl, hargasewa, statuskost);
        unitkost.add(unit);
    }

    public void hapusUnitKost()
    {
        bts=0;      //kondisi batasan awal
        int i;

        Paket_Fasilitas fas = new Paket_Fasilitas();

        System.out.print("MASUKKAN ID PENYEWA:");
        id = input.nextLine();
        for(i = 0; i< unitkost.size(); i++)     //perulangan sebanyak array list yang ada
        {
            Unit_Kost untkst = (Unit_Kost) unitkost.get(i);        //pembuatan objeck pancing dengan mengikuti setiap indeks perulangan dalam array list
            if(untkst.getId().equals(id))      //apakah id yang dicari ada?
            {
                System.out.println("ID\t\tNAMA\t\tTGL. LAHIR\t\tTELP");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//                System.out.println(untkst.getId()+"\t\t"+untkst.getDeskripsi()+"\t\t"+untkst.get()+"\t\t"+untkst.getTelp()+"\t\t"+untkst.getTelp());
                List unitkost3 = getUnitKost();
                List pf = fas.getPF();
                String status;
                String fasilitas = null;

                for(int x = 0; x < unitkost3.size(); x++)
                {
                    Unit_Kost a = (Unit_Kost) unitkost3.get(x);      //menampilkan setiap yang akan ditampilkan sesuai urutan index mengikuti dengan perulangan
                    if(a.getId().equals(untkst.getId()))
                    {
                        if(a.getStatusKost()==1)
                        {
                            status = "TERSEDIA";
                        }
                        else
                        {
                            status = "TIDAK TERSEDIA";
                        }

                        for( int y =0; y<pf.size(); y++)
                        {
                            Paket_Fasilitas b = (Paket_Fasilitas) pf.get(y);

                            if(a.getId_fsl().equals(b.getId()))
                            {
                                fasilitas = b.getFasilitas();
                            }
                        }
                        System.out.println(a.getId()+"\t\t"+a.getDeskripsi()+"\t\t"+fasilitas+"\t\t"+kursIndonesia.format(a.getHargasewa())+"\t\t"+ status);
                    }
                }
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("YAKIN DIHAPUS[Y/T]? ");
                String yakin = input.nextLine();
                if(yakin.equals("Y"))
                {
                    unitkost.remove(untkst);       //menghapus id
                    System.out.println("Data telah dihapus");
                }
                else
                {
                    System.out.println("Data Tidak dihapus");
                }
                bts=1;      //batasan menjadi 1
                break;
            }
        }
        if(bts==0)
        {
            System.out.println("Data tidak ditemukan");
        }
    }
}
