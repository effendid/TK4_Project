/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.binus;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class DataSewa {
     private int awal=0;     //data awal
    Scanner input = new Scanner(System.in); //Scanner input
    /*Array List*/
    Paket_Fasilitas fas = new Paket_Fasilitas();
    Unit_Kost unit = new Unit_Kost();
    
    Paket_Fasilitas newFasilitas; //objek data baru
    DateFormat formattanggal = new SimpleDateFormat("dd-MM-yyyy");      //pembuatan objek formattanggal        
    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance(); /*FORMAT UANG RUPIAH*/
    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();     //Format Rupiah
    int bts, bts1, bts2, bts3, bts4;
    String id;
    String deskripsi;
    String id_fsl;
    double harga = 0;
    int jumlah = 0;
    int choice = 0;
    
    public void tambahKost()            //menu untuk masukan array list
    {
        int pe;
        System.out.println("TAMBAH UNIT KOST");
        System.out.print("DESKRIPSI\t: ");
        deskripsi = input.nextLine();
        
        fas.lihatFasilitas();
        
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
        //tambahData(id, deskripsi, id_fsl, harga, jumlah);   //pemberian nilai pada objek data sesuai dengan parameter yang diminta 
        System.out.println("Data Berhasil Disimpan"); 
        System.out.println("");
    }
}
