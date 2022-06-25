/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JDBCHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class ThongKeDAO {

    private List<Object[]> getListofArray(String sql, String[] cols, Object...args){
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JDBCHelper.query(sql, args);
            while(rs.next()){
            Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i]=rs.getObject(cols[i]);                  
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    } 
    public List<Object[]> getBangDiem(Integer makh) {
        String sql = "{call sp_BangDiem(?)}";
        String[] cols = {"Manh", "Hoten", "Diem"};
        return this.getListofArray(sql, cols,makh);

    }
    public List<Object[]> getLuongNguoiHoc() {
        String sql = "{call  sp_ThongKeNguoiHoc}";
        String[] cols = {"Nam", "Soluong", "DauTien","CuoiCung"};
        return this.getListofArray(sql, cols);

    }
    public List<Object[]> getDiemChuyenDe(){
        String sql = "{CALL sp_ThongKeDiem}";
        String[] cols = {"chuyende","sohv","thapnhat","caonhat","trungbinh"};
        return getListofArray(sql, cols);
    }
     public List<Object[]> getDoanhThu(int nam) {
        String sql = "{call sp_ThongKeDoanhThu(?)}";
        String[] cols = {"ChuyenDe", "soKH","SoHV" ,"DoanhThu","ThapNhat","CaoNhat","TrungBinh"};
        return this.getListofArray(sql, cols,nam);
    }
    
}