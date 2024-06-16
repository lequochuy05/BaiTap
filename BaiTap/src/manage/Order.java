package manage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Order {
	private String maDonhang;
	private Date ngayDatHang;
	private Date ngayGiaoHang;
	private String tenKhachHang;
	private String diaChi;
	private ArrayList<Product> danhSachSanPhamTrongDonHang;
	private ArrayList<Product> khoSanPham = new ArrayList<Product>();

	
	Scanner sc = new Scanner(System.in);
	
	public Order(String maDonhang, Date ngayDatHang, Date ngayGiaoHang, String tenKhachHang, String diaChi,
			ArrayList<Product> danhSachSanPhamTrongDonHang) {
		this.maDonhang = maDonhang;
		this.ngayDatHang = ngayDatHang;
		this.ngayGiaoHang = ngayGiaoHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.danhSachSanPhamTrongDonHang = danhSachSanPhamTrongDonHang;
	}

	public Order() {
		this.danhSachSanPhamTrongDonHang = new ArrayList<Product>();
	}
	public String getMaDonhang() {
		return maDonhang;
	}

	public void setMaDonhang(String maDonhang) {
		this.maDonhang = maDonhang;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public Date getNgayGiaoHang() {
		return ngayGiaoHang;
	}

	public void setNgayGiaoHang(Date ngayGiaoHang) {
		this.ngayGiaoHang = ngayGiaoHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public ArrayList<Product> getDanhSachSanPhamTrongDonHang() {
		return danhSachSanPhamTrongDonHang;
	}

	public void setDanhSachSanPhamTrongDonHang(ArrayList<Product> danhSachSanPhamTrongDonHang) {
		this.danhSachSanPhamTrongDonHang = danhSachSanPhamTrongDonHang;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String ngayDatHangFormat = dateFormat.format(ngayDatHang);
		String ngayGiaoHangFormat = dateFormat.format(ngayGiaoHang);
		return "Order [maDonhang=" + maDonhang + ", ngayDatHang=" + ngayDatHangFormat + ", ngayGiaoHang=" + ngayGiaoHangFormat
				+ ", tenKhachHang=" + tenKhachHang + ", diaChi=" + diaChi + ", danhSachSanPhamTrongDonHang="
				+ danhSachSanPhamTrongDonHang + "]";
	}

	public void themSanPhamVaokho() {
		System.out.println("Nhập mã sản phẩm : ");
		String maSanPham = sc.nextLine();
		System.out.println("Nhập tên sản phẩm : ");
		String tenSanPham = sc.nextLine();
		System.out.println("Nhập giá bán : ");
		int giaBan = sc.nextInt();
		System.out.println("Nhập số lượng : ");
		int soLuong = sc.nextInt();
		
		
		Product product = new Product(maSanPham, tenSanPham, giaBan, soLuong);
		khoSanPham.add(product);
	}
	public void suaSanPhamThemVaoKho() {
		System.out.println("Nhập mã sản phẩm cần sửa : ");
		String maSanPham = sc.nextLine();
		khoSanPham.forEach(product->{
			if(product.getMaSanPham().equals(maSanPham)) {
				System.out.println("Nhập tên sản phẩm : ");
				String tenSanPham = sc.nextLine();
				System.out.println("Nhập giá bán : ");
				int giaBan = sc.nextInt();
				System.out.println("Nhập số lượng : ");
				int soLuong = sc.nextInt();
				
				Product productSua = new Product(maSanPham, tenSanPham, giaBan, soLuong);
				khoSanPham.remove(productSua);
				khoSanPham.add(productSua);
				return;
			}
		});
		System.out.println("Mã sản phẩm vừa nhập không tồn tại ! ");
	}
	public void xoaSanPhamThemVaoKho() {
		System.out.println("Nhập mã sản phẩm cần xóa : ");
		String maSanPhamCanXoa = sc.nextLine();
		khoSanPham.forEach(product->{
			if(product.getMaSanPham().equals(maSanPhamCanXoa)) {
				khoSanPham.remove(product);
				return;
			}
		});
		System.out.println("Mã sản phẩm vừa nhập không tồn tại ! ");
	}
}
