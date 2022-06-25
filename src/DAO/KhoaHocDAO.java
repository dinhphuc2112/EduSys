/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*;
import Entity.KhoaHoc;
import Entity.NhanVien;
import Helper.JDBCHelper;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public class KhoaHocDAO extends EduSysDAO<KhoaHoc, Integer>{
    String INSERT_SQL = "INSERT INTO khoahoc(macd,hocphi,thoiluong,ngaykg,ghichu,manv,ngaytao) "
            + "values(?,?,?,?,?,?,?)";

    String UPDATE_SQL = "UPDATE  khoahoc set ngaykg=? ,ghichu=? where makh=?"; 
    String DELETE_SQL = "DELETE  from khoahoc where makh=?";
    String SELECTT_ALL_SQL = "SELECT *FROM khoahoc";
    String SELECT_BY_ID_SQL = "SELECT  *from khoahoc where makh=?";

    public List<KhoaHoc> selectByChuyenDe(String macd) {
        String sql = "select * from khoahoc where macd =? ";
        return this.selectBySql(sql, macd);

    }

    @Override
    public void insert(KhoaHoc entity) {
        JDBCHelper.update(INSERT_SQL, entity.getMaCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getNgayKG(),
                entity.getGhiChu(), entity.getMaNV(), entity.getNgayTao());
    }

    @Override
    public void update(KhoaHoc entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getNgayKG(), entity.getGhiChu(), entity.getMaKH()); 
    }

    @Override
    public void delete(Integer id) {
        JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<KhoaHoc> selectAll() {
        return this.selectBySql(SELECTT_ALL_SQL);
    }

    @Override
    public KhoaHoc selectById(Integer id) {
        List<KhoaHoc> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<KhoaHoc> selectBySql(String sql, Object... args) {

        List<KhoaHoc> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                KhoaHoc entity = new KhoaHoc();
                entity.setMaKH(rs.getInt("makh"));
                entity.setMaCD(rs.getString("macd"));
                entity.setHocPhi(rs.getDouble("hocphi"));
                entity.setThoiLuong(rs.getInt("thoiluong"));
                entity.setNgayKG(rs.getDate("ngaykg"));
                entity.setGhiChu(rs.getString("ghichu"));
                entity.setMaNV(rs.getString("manv"));
                entity.setNgayTao(rs.getDate("ngaytao"));
                list.add(entity);

            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }
    public List<Integer> selectYear(){
        String sql = "select distinct year(ngayKG) Year from KhoaHoc order by Year DESC";
        List<Integer> list = new ArrayList<>();
        try{
            ResultSet rs = JDBCHelper.query(sql);
            while(rs.next()){
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        }catch(SQLException ex){
            throw new RuntimeException();
        }
    }
    
}
