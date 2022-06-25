/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.KhoaHoc;
import Helper.JDBCHelper;
import Entity.NguoiHoc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class NguoiHocDAO extends EduSysDAO<NguoiHoc, String> {

    String INSERT_SQL = "insert into nguoihoc values(?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE  nguoihoc set hoten=?,ngaysinh=?,gioitinh=?,dienthoai=?,"
            + "email=?,ghichu=?,manv=?,ngaydk=? where manh=?;";
    String DELETE_SQL = "DELETE  from nguoihoc where manh=?";
    String SELECTT_ALL_SQL = "SELECT *FROM nguoihoc";
    String SELECT_BY_ID_SQL = "SELECT  *from nguoihoc where manh=?";

    public List<NguoiHoc> selectByKeyword(String keyword) {
        String sql = "Select * from nguoihoc where hoten like ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

    public List<NguoiHoc> selectNotlnCourse(int makh, String keyword) {
        String sql = "SELECT * FROM nguoihoc "
                + "WHERE hoten like ? AND "
                + "manh not in (select manh from hocvien where makh=?) ";
        return this.selectBySql(sql, "%" + keyword + "%", makh);

    }
    
    
    @Override
    public void insert(NguoiHoc entity) {
        JDBCHelper.update(INSERT_SQL, entity.getMaNH(), entity.getHoTen(), entity.getNgaySinh(),
                entity.isGioiTinh(), entity.getDienThoai(), entity.getEmail(),
                entity.getGhiChu(), entity.getMaNV(), entity.getNgayDK());
    }

    @Override
    public void update(NguoiHoc entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getHoTen(), entity.getNgaySinh(), entity.isGioiTinh(), entity.getDienThoai(), entity.getEmail(), entity.getGhiChu(), entity.getMaNV(), entity.getNgayDK(), entity.getMaNH());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NguoiHoc> selectAll() {
        return this.selectBySql(SELECTT_ALL_SQL);
    }

    @Override
    public NguoiHoc selectById(String id) {
        List<NguoiHoc> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;

        }
        return list.get(0);

    }

    @Override
    protected List<NguoiHoc> selectBySql(String sql, Object... args) {
        List<NguoiHoc> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                NguoiHoc entity = new NguoiHoc();
                entity.setMaNH(rs.getString("MaNH"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setDienThoai(rs.getString("DienThoai"));
                entity.setEmail(rs.getString("Email"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setNgayDK(rs.getDate("NgayDK"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
