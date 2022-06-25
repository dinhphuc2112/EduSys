/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.HocVien;
import Helper.JDBCHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public class HocVienDAO extends EduSysDAO<HocVien, Integer>{
     String INSERT_SQL = "INSERT INTO hocvien(makh,manh,diem) \n"
            + " values(?,?,?)";
    String UPDATE_SQL = "UPDATE  hocvien set diem=? where mahv=?;";
    String DELETE_SQL = "DELETE  from hocvien where mahv=?";
    String SELECTT_ALL_SQL = "SELECT *FROM hocvien";
    String SELECT_BY_ID_SQL = "SELECT  *from hocvien where mahv=?";

    public List<HocVien> selectByKhoaHoc(int makh) {
        String sql = "SELECT * FROM hocvien WHERE makh=? ";
        return this.selectBySql(sql, makh);

    }

    @Override
    public void insert(HocVien entity) {
        JDBCHelper.update(INSERT_SQL, entity.getMaKH(), entity.getMaNH(), entity.getDiem());
    }

    @Override
    public void update(HocVien entity) {
        JDBCHelper.update(UPDATE_SQL, entity.getDiem(),entity.getMaHV());
    }

    @Override
    public void delete(Integer id) {
        JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<HocVien> selectAll() {
        return this.selectBySql(SELECTT_ALL_SQL);
    }

    @Override
    public HocVien selectById(Integer id) {
        List<HocVien> list = selectBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<HocVien> selectBySql(String sql, Object... args) {
        List<HocVien> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                HocVien entity = new HocVien();
                entity.setMaHV(rs.getInt("mahv"));
                entity.setMaKH(rs.getInt("makh"));
                entity.setMaNH(rs.getString("manh"));
                entity.setDiem(rs.getDouble("diem"));
                list.add(entity);

            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
