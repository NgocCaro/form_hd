/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package from_hd;

/**
 *
 * @author Admin
 */
public class chi_tiet_hd {
    private int ma_chi_tiet_hd;
    private int masp;
    private int mahd;
    private int so_luong;
    private int gia_ban;
    private int tong;
    

    public chi_tiet_hd() {
    }

    public chi_tiet_hd(int mahd) {
        this.mahd = mahd;
    }

    public chi_tiet_hd(int ma_chi_tiet_hd, int masp, int so_luong, int gia_ban, int tong) {
        this.ma_chi_tiet_hd = ma_chi_tiet_hd;
        this.masp = masp;
        this.so_luong = so_luong;
        this.gia_ban = gia_ban;
        this.tong = tong;
    }
// cái này dùng để hiện list
    public chi_tiet_hd(int masp, int so_luong, int gia_ban, int tong) {
        this.masp = masp;
        this.so_luong = so_luong;
        this.gia_ban = gia_ban;
        this.tong = tong;
    }
// cái này dùng để đẩy lên db

    public chi_tiet_hd(int masp, int so_luong, int tong) {
        this.masp = masp;
        this.so_luong = so_luong;
        this.tong = tong;
    }
    
    public int getMa_chi_tiet_hd() {
        return ma_chi_tiet_hd;
    }

    public void setMa_chi_tiet_hd(int ma_chi_tiet_hd) {
        this.ma_chi_tiet_hd = ma_chi_tiet_hd;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    public int getGia_ban() {
        return gia_ban;
    }

    public void setGia_ban(int gia_ban) {
        this.gia_ban = gia_ban;
    }

    public int getTong() {
        return tong;
    }

    public void setTong(int tong) {
        this.tong = tong;
    }

     

    
 
    
}
