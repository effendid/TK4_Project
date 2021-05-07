/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.binus;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Student
 */
public class Paket_Fasilitas {
    private String id;
    private String deskripsi;
    private String fasilitas;
    private int status;
    List paketfasilitas = new ArrayList();
    List pf = new ArrayList();
    
    public List getPF()
    {
        return paketfasilitas;
    }
    
    public Paket_Fasilitas() {
    }

    public Paket_Fasilitas(String id, String deskripsi, String fasilitas, int status) {
        this.id = id;
        this.deskripsi = deskripsi;
        this.fasilitas = fasilitas;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public int getStatus() {
        return status;
    }
    
    public void dataFasilitas()
    {
        Paket_Fasilitas fas1 = new Paket_Fasilitas("FS001", "PAKET 1", "AC, KM. DALAM, LAUNDRY", 1);    //pembuatan objek baru
        paketfasilitas.add(fas1); //simpan objek baru kedalam array list
        pf.add(1);  //id otomatis jadi 1
        
        Paket_Fasilitas fas2 = new Paket_Fasilitas("FS002", "PAKET 2", "AC, KM. LUAR, LAUNDRY", 1);    //pembuatan objek baru
        paketfasilitas.add(fas2); //simpan objek baru kedalam array list
        pf.add(2);  //id otomatis jadi 1
        
        Paket_Fasilitas fas3 = new Paket_Fasilitas("FS003", "PAKET 3", "KM. DALAM, LAUNDRY", 1);    //pembuatan objek baru
        paketfasilitas.add(fas3); //simpan objek baru kedalam array list
        pf.add(3);  //id otomatis jadi 1
        
        Paket_Fasilitas fas4 = new Paket_Fasilitas("FS004", "PAKET 4", "KM. LUAR, LAUNDRY", 0);    //pembuatan objek baru
        paketfasilitas.add(fas4); //simpan objek baru kedalam array list
        pf.add(4);  //id otomatis jadi 1
    }
    
    public void lihatFasilitas()
    {
        String status;
        System.out.println("LIHAT FASILITAS KOST");
        System.out.println("ID\t\tDEKSRIPSI\t\tFASILITAS\t\tSTATUS");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        List pf;
        pf = getPF();

        for(int i = 0; i < pf.size(); i++)
        {
            Paket_Fasilitas a = (Paket_Fasilitas) pf.get(i);      //menampilkan setiap yang akan ditampilkan sesuai urutan index mengikuti dengan perulangan
            if(a.getStatus()==1)
            {
                status = "TERSEDIA";
            }
            else
            {
                status = "TIDAK TERSEDIA";
            }
            System.out.println(a.getId()+"\t\t"+a.getDeskripsi()+"\t\t"+a.getFasilitas()+"\t\t"+
                    status);
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }
    
    public void lihatFasilitas2()
    {
        String status;
        System.out.println("LIHAT FASILITAS KOST");
        System.out.println("ID\t\tDEKSRIPSI\t\tFASILITAS\t\tSTATUS");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        List pf;
        pf = getPF();

        for(int i = 0; i < pf.size(); i++)
        {
            Paket_Fasilitas a = (Paket_Fasilitas) pf.get(i);      //menampilkan setiap yang akan ditampilkan sesuai urutan index mengikuti dengan perulangan
            if(a.getStatus()==1)
            {
                status = "TERSEDIA";
                
                System.out.println(a.getId()+"\t\t"+a.getDeskripsi()+"\t\t"+a.getFasilitas()+"\t\t"+
                    status);
            }
        }
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }
}
