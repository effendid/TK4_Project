/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.binus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Student
 */
public class Penyewa implements Interface_Sewa_Kost{
/**
 *
 * @author Student
 */
    private String id;
    private String nama;
    private Date ttl;
    private String telp;
    private int umur;
    private double selisih;
    private int awal =0;
    
    List listpenyewa = new ArrayList();
    List nyewa = new ArrayList();
    private int awalpenyewa = 0;
    private int bts=0;
    Scanner input = new Scanner(System.in);
    
    Date tanggal = null;                                                //variabel tanggal bernilai null
    DateFormat formattanggal = new SimpleDateFormat("dd-mm-yyyy");      //pembuatan objek formattanggal
        

    public int getAwalpenyewa() {
        return awalpenyewa;
    }
    
    public List getListPenyewa()
    {
        return listpenyewa;
    }
    
    public Penyewa() {
    }

    public Penyewa(String id, String nama, Date ttl, String telp) {
        this.id = id;
        this.nama = nama;
        this.ttl = ttl;
        this.telp = telp;
        this.umur = (int) getUmur();
    }
    public int getumurnya()
    {
        return umur;
    }
    
    @Override
    public final double getUmur() {
        try {
            countTotal();
        } catch (ParseException ex) {
            Logger.getLogger(Penyewa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return selisih;
    }

    private void countTotal() throws ParseException
    {
        selisih = daysBetween(ttl, NowDate())/365;
    }
    
    public double daysBetween(Date d1, Date d2)
    {
        return ((d2.getTime()-d1.getTime())/(1000*60*60*24));                   
    }
    
    public Date NowDate() throws ParseException
    {
        Calendar cal = Calendar.getInstance();
        String tanggalstr = formattanggal.format(cal.getTime());
        return formattanggal.parse(tanggalstr);
    }
    
    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public Date getTtl() {
        return ttl;
    }

    public String getTelp() {
        return telp;
    }
    
    public void dataPenyewa()
    {
        awalpenyewa = 1;
        Penyewa sew1 = null;    //pembuatan objek baru
        try {
            sew1 = new Penyewa("PS001", "JIJI",  tanggal = formattanggal.parse("10-10-1994"), "0812131564");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listpenyewa.add(sew1); //simpan objek baru kedalam array list
        nyewa.add(1);  //id otomatis jadi 1

        Penyewa sew2 = null;    //pembuatan objek baru
        try {
            sew2 = new Penyewa("PS002", "TANTRI",  tanggal = formattanggal.parse("7-5-1994"), "0856123584");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listpenyewa.add(sew2); //simpan objek baru kedalam array list
        nyewa.add(2);  //id otomatis jadi 1

        Penyewa sew3 = null;    //pembuatan objek baru
        try {
            sew3 = new Penyewa("PS003", "INDARI",  tanggal = formattanggal.parse("8-12-1994"), "0811126479");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listpenyewa.add(sew3); //simpan objek baru kedalam array list
        nyewa.add(3);  //id otomatis jadi 1

        Penyewa sew4 = null;    //pembuatan objek baru
        try {
            sew4 = new Penyewa("PS004", "SUSI",  tanggal = formattanggal.parse("27-8-1990"), "0899365473");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listpenyewa.add(sew4); //simpan objek baru kedalam array list
        nyewa.add(4);  //id otomatis jadi 1

        Penyewa sew5 = null;    //pembuatan objek baru
        try {
            sew5 = new Penyewa("PS005", "JUJU",  tanggal = formattanggal.parse("2-102"
                    + "-1992"), "0857056585");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listpenyewa.add(sew5); //simpan objek baru kedalam array list
        nyewa.add(5);  //id otomatis jadi 1
    }
    
    public void hapusFasilitas()
    {
        bts=0;      //kondisi batasan awal
        int i;
        
        System.out.print("MASUKKAN ID PENYEWA:");
        id = input.nextLine();
        for(i = 0; i< listpenyewa.size(); i++)     //perulangan sebanyak array list yang ada
        {
            Penyewa sewa = (Penyewa) listpenyewa.get(i);        //pembuatan objeck pancing dengan mengikuti setiap indeks perulangan dalam array list
            if(sewa.getId().equals(id))      //apakah id yang dicari ada?
            {
                System.out.println("ID\t\tNAMA\t\tTGL. LAHIR\t\tTELP");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println(sewa.getId()+"\t\t"+sewa.getNama()+"\t\t"+formattanggal.format(sewa.getTtl())+"\t\t"+sewa.getTelp());
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("YAKIN DIHAPUS[Y/T]? ");
                String yakin = input.nextLine();
                if(yakin.equals("Y"))
                {
                    listpenyewa.remove(sewa);       //menghapus id
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

    public String getIDAuto()
    {
        //Logic get ID auto
        int temp;       //temp menyimpan angka sementara dari list


        // mengambil nilai maksimal untuk setiap ID, sehingga nantinya auto increment
        temp = listpenyewa.size();

        String ID = "";     //String id dimulai dengan data kosong
        temp = temp+1;      //temp bertambah 1
        nyewa.add(temp);       //simpan temp ke dalam array list
        if(temp<10)         //jika temp lebih kecil dari 10
        {
            ID = "PS00";
        }
        else if(temp<100)   //jika temp lebih kecil dari 100
        {
            ID = "PS0";
        }
        else if(temp<1000)  //jika temp lebih kecil dari 1000
        {
            ID = "PS";
        }

        String no = Integer.toString(temp); //temp diubah dari integer ke String
        String IDfix = ID + no;             //IDfix = ID + no
        return IDfix;                       //return ID fix
    }

    public void tambahData(String id, String nama, Date ttl, String telp) {
        Penyewa penyewa = new Penyewa(id, nama, ttl, telp);
        listpenyewa.add(penyewa);
    }
    
    @Override
    public String searchById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTotalPembayaran() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
