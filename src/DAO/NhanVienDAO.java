/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.NhanVien;
import Helper.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class NhanVienDAO extends EduSysDAO<NhanVien, String> {

    String INSERT_SQL = "INSERT INTO nhanvien (manv,matkhau,hoten,vaitro) values(?,?,?,?)";
    String UPDATE_SQL = "UPDATE  nhanvien set matkhau=?,hoten=?,vaitro=? where manv=?";
    String DELETE_SQL = "DELETE  from nhanvien where manv=?";
    String SELECTT_ALL_SQL = "SELECT *FROM NHANVIEN";
    String SELECT_BY_ID_SQL = "SELECT  *from nhanvien where manv=?";

    @Override
    public void insert(NhanVien entity) {

        JDBCHelper.update(INSERT_SQL, entity.getMaNV(), entity.getMatKhau(), entity.getHoTen(), entity.getVaiTro());
    }

    @Override
    public void update(NhanVien entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getMatKhau(), entity.getHoTen(), entity.getVaiTro(), entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(SELECTT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("manv"));

                entity.setMatKhau(rs.getString("matkhau"));
                entity.setHoTen(rs.getString("hoten"));
                entity.setVaiTro(rs.getBoolean("vaitro"));
                list.add(entity);

            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

}
