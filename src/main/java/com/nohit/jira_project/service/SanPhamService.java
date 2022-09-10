package com.nohit.jira_project.service;

import java.util.*;

import com.nohit.jira_project.model.*;

public interface SanPhamService {
    public List<SanPham> getDsSanPham();

    public List<SanPham> getDsSanPham(String phanLoai);

    public List<SanPham> getDsSanPhamInProductPage(String tieuchi);

    public SanPham getSanPham(int id);

    public SanPham getSanPhamByName(String name);

    public void saveSanPham(SanPham sanPham);

    public void deleteSanPham(int id);

    // Methods to sort in Product Controller
    public List<SanPham> getDsSanPhamTonKho();

    public List<SanPham> getDsSanPhamTopSale();

    public List<SanPham> getDsSanPhamNewest();

    public List<SanPham> getDsSanPhamAscendingPrice();

    public List<SanPham> getDsSanPhamDescendingPrice();

    public List<SanPham> getDsSanPhamAscendingDiscount();

    public List<SanPham> getDsSanPhamDescendingDiscount();
}
