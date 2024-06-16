package manage;

public class Product implements IProduct {
	private String maSanPham;
	private String tenSanPham;
	private int giaTien;
	private int soLuong;

	public Product(String maSanPham, String tenSanPham, int giaTien, int soLuong) {
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.giaTien = giaTien;
		this.soLuong = soLuong;
	}
	

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public int getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "Product [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", giaTien=" + giaTien + ", soLuong="
				+ soLuong + "]";
	}

	
	@Override
	public double giaBanToiNguoiDung(double giaBan) {
		double giaBanToiNguoiDung = giaBan*0.1*getSoLuong();
		return giaBanToiNguoiDung;
	}

}
