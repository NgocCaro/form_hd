/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package from_hd;

//import database.databaseUtils;
//import model.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ProductModify {
    
     public int add(Product pr){
        Connection conn=null;
        PreparedStatement sttm=null;
        try {
           String query="insert hang_hoa(ten_hang,gia_ban,so_luong) values(?,?,?)";
            conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
            sttm=conn.prepareStatement(query);
            sttm.setString(1,pr.getTen_sp());
 
            sttm.setInt(2, pr.getGia_ban());
            sttm.setInt(3, pr.getSo_luong());
            if(sttm.executeUpdate()>0)
            {
                System.out.println("Thêm mới thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
                       
            } catch (Exception e) {
            }
        }
        return -1;   //nếu thêm k thành công
    }
    //  sửa
     public int update(Product pr){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
           String query="update hang_hoa set ten_hang=? ,gia_ban=?,so_luong=? where ma_hang=?";
            conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
            sttm=conn.prepareStatement(query);
            sttm.setString(1,pr.getTen_sp());
           
            sttm.setInt(2, pr.getGia_ban());
            sttm.setInt(3, pr.getMa_sp());
            sttm.setInt(4, pr.getSo_luong());
            if(sttm.executeUpdate()>0)
            {
                System.out.println("sửa thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
                       
            } catch (Exception e) {
            }
        }
        return -1;   
    }
     //xóa theo id
     public int delete(int ma_hang){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
           String query="delete from hang_hoa where ma_hang = ?";
           conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
           sttm=conn.prepareStatement(query);
            sttm.setInt(1,ma_hang);
            
            if(sttm.executeUpdate()>0)
            {
                System.out.println("Xóa thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }
        return -1;   
    }
     
     //show tất cả sản phẩm
     
     public List<Product> getProduct(){
         List<Product>ls=new ArrayList<>();
        Connection conn=null;
        Statement sttm=null;
        try {
            String query="select ma_hang,ten_hang, gia_ban,so_luong from hang_hoa";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
            sttm=conn.createStatement();
            ResultSet rs=sttm.executeQuery(query);
            while(rs.next()){
                Product pr=new Product();
                pr.setMa_sp(rs.getInt(1));
                pr.setTen_sp(rs.getString(2));
              
                pr.setGia_ban(rs.getInt(3));
                pr.setSo_luong(rs.getInt(4));
                ls.add(pr);                  
            }
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
        }finally{
            try {
                sttm.close();conn.close();
            } catch (Exception e) {
            }
        }
         return ls;
     }
     // tìm theo id 
     public Product getProductById(int ma_hang) {
         Product pr=new Product();
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             String query="select ma_hang,ten_hang, gia_ban,so_luong from hang_hoa where ma_hang=?";
             conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
           sttm=conn.prepareStatement(query); 
            sttm.setInt(1,ma_hang);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                pr.setMa_sp(rs.getInt(1));
                pr.setTen_sp(rs.getString(2));
                
                pr.setGia_ban(rs.getInt(3));
                pr.setSo_luong(rs.getInt(4));
                return pr;
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
         return null;
     }
     // tìm kiếm theo tên
     public Product getProductByName(String ten_hang) {
         Product pr=new Product();
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             String query="select ma_hang,ten_hang ,gia_ban,so_luong from hang_hoa where ten_hang=?";
             conn=DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
           sttm=conn.prepareStatement(query); 
            sttm.setString(1,ten_hang);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                pr.setMa_sp(rs.getInt(1));
                pr.setTen_sp(rs.getString(2));
                
                pr.setGia_ban(rs.getInt(3));
                 pr.setSo_luong(rs.getInt(4));
                return pr;
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
         return null;// nếu k tìm thấy thì trả về null
     }
      public ArrayList<Product> addlist(Product pr){
          ArrayList<Product> a= new ArrayList<>();
        a.add(pr);
        return a;
    }
      // in ra những sản phẩm sắp hết
    public List<Product> getProducts(){
         List<Product> ls=new ArrayList<>();
        Connection conn=null;
        Statement sttm=null;
        try {// order by  so_luong asc
            String query="select * from hang_hoa order by  so_luong asc";
           conn= DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");
            sttm=conn.createStatement();
            ResultSet rs=sttm.executeQuery(query);
            while(rs.next()){
                 
                int sl= rs.getInt("so_luong");
                Product pr=new Product();
                if(sl>=0&&sl<=2){
                    pr.setMa_sp(rs.getInt(1));
                    pr.setTen_sp(rs.getString(2));
                    pr.setGia_ban(rs.getInt(3));
                    pr.setSo_luong(rs.getInt(4));
                    ls.add(pr);
                    System.out.println(sl +"sl ne");
                }
                else{
                    System.out.println("that bai roi");
                }
                                   
            }
        } catch (Exception e) {
            System.out.println("Error hmmmm má ôi"+e.toString());
        }finally{
            try {
                sttm.close();conn.close();
            } catch (Exception e) {
            }
        }
         return ls;
     }
   /*
    
    public ArrayList<Product> addlist(Product pr){
          ArrayList<Product> a= new ArrayList<>();
        a.add(pr);
        return a;
    }
    // thêm mới
    public int add(Product pr){
        Connection conn=null;
        PreparedStatement sttm=null;
        try {
           String query="insert hang_hoa(ten_hang ,gia_ban,so_luong) values(?,?,?,?)";
            conn= databaseUtils.getDBConnect();
            sttm=conn.prepareStatement(query);
            sttm.setString(1,pr.getTen_sp());
            
            sttm.setFloat(2, pr.getGia_ban());
            sttm.setInt(3, pr.getSoluong());
            
            if(sttm.executeUpdate()>0)
            {
                System.out.println("Thêm mới thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error nua ha"+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
                       
            } catch (Exception e) {
            }
        }
        return -1;   //nếu thêm k thành công
    }
    //  sửa
    
     public int update(Product pr){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            //UPDATE hang_hoa h, chi_tiet_nhap_hang ct set h.ten_hang=?, h.gia_han=?, ct.so_luong=? where h.ma_hang=ct.ma_hang=?
      
           String query="update hang_hoa h, chi_tiet_nhap_hang ct set h.ten_hang=?, h.gia_ban=?, ct.so_luong=? where h.ma_hang=ct.ma_hang=?";
            conn= databaseUtils.getDBConnect();
            sttm=conn.prepareStatement(query);
            sttm.setString(1,pr.getTen_sp());

            sttm.setFloat(2, pr.getGia_ban());
            sttm.setInt(3, pr.getSoluong());
            sttm.setInt(4, pr.getMa_sp());
           // sttm.setInt(4, pr.getSoluong());
            if(sttm.executeUpdate()>0)
            {
                System.out.println("sửa thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.toString());
        }finally{
            try {
                conn.close();
                sttm.close();
                       
            } catch (Exception e) {
            }
        }
        return -1;   
    }
     //xóa theo id
     public int delete(int ma_hang){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
           String query="delete from hang_hoa where ma_hang = ?";
           conn= databaseUtils.getDBConnect();
           sttm=conn.prepareStatement(query);
            sttm.setInt(1,ma_hang);
            
            if(sttm.executeUpdate()>0)
            {
                System.out.println("Xóa thành công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error aygu"+e.toString());
        }
        return -1;   
    }
     public List<Product> getProduct(){
         List<Product> ls=new ArrayList<>();
        Connection conn=null;
        Statement sttm=null;
        try {
            String query="select hang_hoa.ma_hang,hang_hoa.ten_hang,hang_hoa.gia_ban, chi_tiet_nhap.so_luong_nhap from hang_hoa INNER JOIN chi_tiet_nhap ON hang_hoa.ma_hang=chi_tiet_nhap.ma_hang order by chi_tiet_nhap.so_luong_nhap asc";
           conn= databaseUtils.getDBConnect();
            sttm=conn.createStatement();
            ResultSet rs=sttm.executeQuery(query);
            while(rs.next()){
                 
                int sl= rs.getInt("chi_tiet_nhap.so_luong_nhap");
                Product pr=new Product();
                if(sl>=0&&sl<=2){
                    pr.setMa_sp(rs.getInt(1));
                    pr.setTen_sp(rs.getString(2));
                    pr.setGia_ban(rs.getInt(3));
                    pr.setSoluong(rs.getInt(4));
                    ls.add(pr);
                    System.out.println(sl +"sl ne");
                }
                else{
                    System.out.println("that bai roi");
                }
                                   
            }
        } catch (Exception e) {
            System.out.println("Error hmmmm má ôi"+e.toString());
        }finally{
            try {
                sttm.close();conn.close();
            } catch (Exception e) {
            }
        }
         return ls;
     }*/
     //show tất cả
  /*   public List<Product> getAllProduct(){
         List<Product> ls=new ArrayList<>();
        Connection conn=null;
        Statement sttm=null;
        try {
             String query="select hang_hoa.ma_hang,hang_hoa.ten_hang,hang_hoa.gia_ban, chi_tiet_nhap.so_luong_nhap from hang_hoa INNER JOIN chi_tiet_nhap ON hang_hoa.ma_hang=chi_tiet_nhap.ma_hang ";
           // String query="select ma_hang,ten_hang,gia_ban, so_luong from hang_hoa";
           conn= DriverManager.getConnection("jdbc:mysql://localhost/minimarket", "root", "");;
            sttm=conn.createStatement();
            ResultSet rs=sttm.executeQuery(query);
            while(rs.next()){
                Product pr=new Product();
                pr.setMa_sp(rs.getInt(1));
                pr.setTen_sp(rs.getString(2));
                
                pr.setGia_ban(rs.getInt(3));
                pr.setSo_luong(rs.getInt(4));
                ls.add(pr);                  
            }
        } catch (Exception e) {
            System.out.println("Error hm troi ôii"+e.toString());
        }finally{
            try {
                sttm.close();conn.close();
            } catch (Exception e) {
            }
        }
         return ls;
     }/*
     // tìm theo id 
     public Product getProductById(int ma_hang) {
         Product pr=new Product();
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             //SELECT a.id, a.name, a.num, b.date, b.roll
            // FROM a
            // INNER JOIN b ON a.id=b.id;
             String query="select hang_hoa.ma_hang,hang_hoa.ten_hang,hang_hoa.gia_ban,"
               + " chi_tiet_nhap.so_luong_nhap from hang_hoa INNER JOIN chi_tiet_nhap ON hang_hoa.ma_hang=chi_tiet_nhap.ma_hang "
                     + "where hang_hoa.ma_hang=?";
            conn= databaseUtils.getDBConnect();
           sttm=conn.prepareStatement(query); 
            sttm.setInt(1,ma_hang);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                pr.setMa_sp(rs.getInt(1));
                pr.setTen_sp(rs.getString(2));
               
                pr.setGia_ban(rs.getInt(3));
                 pr.setSoluong(rs.getInt(4));
                return pr;
            }
                
         } catch (Exception e) {
                 System.out.println("Error roi ne condi"+e.toString());      
         }finally{
            try {
                sttm.close();
                conn.close();
            } catch (Exception e) {
            }
         }
         return null;
     }
     // tìm kiếm theo tên
     public Product getProductByName(String ten_hang) {
         Product pr=new Product();
         Connection conn = null;
        PreparedStatement sttm = null;
         try {
             String query="select ma_hang,ten_hang,gia_nhap,gia_ban from hang_hoa where ten_hang=?";
             conn= databaseUtils.getDBConnect();
           sttm=conn.prepareStatement(query); 
            sttm.setString(1,ten_hang);
            ResultSet rs=sttm.executeQuery();
            while(rs.next()){
                pr.setMa_sp(rs.getInt(1));
                pr.setTen_sp(rs.getString(2));
               
                pr.setGia_ban(rs.getInt(3));
                 pr.setSoluong(rs.getInt(4));
                return pr;
            }
                
         } catch (Exception e) {
                 System.out.println("Error roi ne"+e.toString());      
         }finally{
            try {
                sttm.close();
                conn.close();
            } catch (Exception e) {
               
            }
         }
         return null;// nếu k tìm thấy thì trả về null
     }

   */
}
