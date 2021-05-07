/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.binus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Student
 */
public class Transaksi_Sewa{
    private String id;
    private Date tanggal;
    private String penyewa_id;
    private String kost_id;
    private double totalbayar;
    private int status;
    
    List transaksi = new ArrayList();
    List trs = new ArrayList();
    //Logic get ID auto
    int temp=0;       //temp menyimpan angka sementara dari list
        
    public Transaksi_Sewa(String id, Date tanggal, String penyewa_id, String kost_id, double totalbayar, int status) {
        this.id = id;
        this.tanggal = tanggal;
        this.penyewa_id = penyewa_id;
        this.kost_id = kost_id;
        this.totalbayar = totalbayar;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public String getPenyewa_id() {
        return penyewa_id;
    }

    public String getKost_id() {
        return kost_id;
    }

    public double getTotalbayar() {
        return totalbayar;
    }

    public int getStatus() {
        return status;
    }

    public List getTransaksi() {
        return transaksi;
    }

    public List getTrs() {
        return trs;
    }

    public Transaksi_Sewa() {
    }
    
     public String getIDAutoTrans()
    {
        if(temp==0)     //jika data dimulai dari awal
        {
            temp = 0;
        }
        else            //jika data tidak ditambahkan di awal
        {
            temp = (int) Collections.max(trs);   //mencari data dalam array yang paling besar
        }
        
        String ID = "";     //String id dimulai dengan data kosong
        temp = temp+1;      //temp bertambah 1
        trs.add(temp);       //simpan temp ke dalam array list
        if(temp<10)         //jika temp lebih kecil dari 10
        {
            ID = "TRS00";
        }
        else if(temp<100)   //jika temp lebih kecil dari 100
        {
            ID = "TRS0";
        }
        else if(temp<1000)  //jika temp lebih kecil dari 1000
        {
            ID = "TRS";
        }
        
        String no = Integer.toString(temp); //temp diubah dari integer ke String
        String IDfix = ID + no;             //IDfix = ID + no
        return IDfix;                       //return ID fix
    }
     
     public void tambahTrans(String id, Date tanggal, String penyewa_id, String kost_id, double totalbayar, int status) {
        Transaksi_Sewa trans = new Transaksi_Sewa(id, tanggal, penyewa_id, kost_id, totalbayar, status);
        transaksi.add(trans);
    }
}
