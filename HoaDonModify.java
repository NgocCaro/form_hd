/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package from_hd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class HoaDonModify {
    private Connection conn;
    String ma="";
    public HoaDonModify(){
        try {
            String url="jdbc:mysql://localhost/minimarket";
            String user="root";
            String password="";
            conn=DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
        }
    }
    // show hóa đơn có trên db
    public ArrayList<quanlyhoadon> getListHD(){
    ArrayList<quanlyhoadon> list=new ArrayList<>();
    String sql="select hoa_don.ma_hd,khach_hang.sdt_khach,hoa_don.ngay_tao,hoa_don.thanh_toan from hoa_don,khach_hang where hoa_don.ma_khach=khach_hang.ma_khach";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                quanlyhoadon s=new quanlyhoadon();
                s.setMahd(rs.getInt("ma_hd"));
                s.setSdt_kh(rs.getString("sdt_khach"));
                s.setDate_Buy(rs.getString("ngay_tao"));
                s.setThanhTien(rs.getInt("thanh_toan"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    //tìm kiếm hóa đơn theo sdt
     public ArrayList<quanlyhoadon> getHoa_donBySdt(String sdt) {
         ArrayList<quanlyhoadon> list=new ArrayList<>();        
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             String query="SELECT hoa_don.ma_hd,khach_hang.sdt_khach,hoa_don.ngay_tao,hoa_don.thanh_toan FROM hoa_don,khach_hang WHERE hoa_don.ma_khach=khach_hang.ma_khach AND khach_hang.sdt_khach=? ";
             conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
           sttm=conn.prepareStatement(query); 
            sttm.setString(1,sdt);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                quanlyhoadon pr=new quanlyhoadon(rs.getInt("ma_hd"),rs.getString("sdt_khach"),rs.getString("ngay_tao"),rs.getInt("thanh_toan"));
               list.add(pr);
            }
                
         } catch (Exception e) {
                 System.out.println("Error"+e.toString());      
         }finally{
            try {
                sttm.close();
                conn.close();
            } catch (Exception e) {
            }
         }
         return list;
     }
     
    public int getmahd(){
         String sql="select ma_hd from hoa_don where ngay_tao='"+ma+"'";
         try {
             PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt("ma_hd");
            }
        } catch (Exception e) {
        }
          
         return 0;
    }
    // thêm hóa đơn trên db
    public int AddHD(quanlyhoadon hd){        
        try {
            String sql="insert hoa_don(ngay_tao,thanh_toan) values(?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, hd.getDate_Buy());
            ps.setInt(2, hd.getThanhTien());
            ma= hd.getDate_Buy();
             if(ps.executeUpdate()>0){
               System.out.println(ma);
                 
               return 1;
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
       return -1; 
       
    }
    // xóa hóa đơn
     public void DeleteHD(int id ){
       String sql="delete from hoa_don where ma_hd=?";
       
        try {
            PreparedStatement ps=conn.prepareCall(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new HoaDonModify();
    }
    
}