package com.nohit.jira_project.model;

import java.util.*;

import javax.persistence.*;

import lombok.*;

import static javax.persistence.GenerationType.*;

@Entity(name = "khach_hang")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class KhachHang {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private int idKH;

    @NonNull
    @Column(name = "thu_dien_tu")
    private String email;

    @NonNull
    @Column(name = "mat_khau")
    private String matKhau;

    @NonNull
    @Column(name = "ho_ten")
    private String hoTen;

    @NonNull
    @Column(name = "hinh_anh")
    private String avatar;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "xa_phuong")
    private String xaPhuong;

    @Column(name = "quan_huyen")
    private String quanHuyen;

    @Column(name = "tinh_thanh")
    private String tinhThanh;

    @Column(name = "vai_tro")
    private String vaiTro;

    @OneToMany(mappedBy = "idKH")
    private List<KhachHang> khachHangs;
}