/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package from_hd;

/**
 *
 * @author Admin
 */
public class Product {
     private int ma_sp;
    private String ten_sp;
   // private int gia_nhap;
    private int gia_ban;
    private int so_luong;
    public Product() {
    }
public Product(int ma_sp, String ten_sp, int gia_ban, int so_luong) {
        this.ma_sp = ma_sp;
        this.ten_sp = ten_sp;
        this.gia_ban = gia_ban;
        this.so_luong = so_luong;
    }

    public int getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(int ma_sp) {
        this.ma_sp = ma_sp;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public int getGia_ban() {
        return gia_ban;
    }

    public void setGia_ban(int gia_ban) {
        this.gia_ban = gia_ban;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }

    
    

    
    /*
    private int ma_sp;
    private String ten_sp;
    
    private int gia_ban;
    private int soluong;
    public Product() {
    }

    public Product(int ma_sp, String ten_sp, int gia_ban, int soluong) {
        this.ma_sp = ma_sp;
        this.ten_sp = ten_sp;
        this.gia_ban = gia_ban;
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "Product{" + "ma_sp=" + ma_sp + ", ten_sp=" + ten_sp + ", gia_ban=" + gia_ban + ", soluong=" + soluong + '}';
    }

    public int getMa_sp() {
        return ma_sp;
    }

    public void setMa_sp(int ma_sp) {
        this.ma_sp = ma_sp;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public int getGia_ban() {
        return gia_ban;
    }

    public void setGia_ban(int gia_ban) {
        this.gia_ban = gia_ban;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

     */

    
    
   
}
