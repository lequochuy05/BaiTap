package manage;

import java.io.File;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		OrderManagement danhSachDonHang = new OrderManagement();
//	Order danhSachSanPham = new Order();
		Order danhSachSanPhamTrongKho = new Order();

		Scanner sc = new Scanner(System.in);
		int luaChon;
		do {
			System.out.println("Nhập sản phẩm vào kho : ");
			System.out.println("2. sửa sản phẩm trong kho : ");
			System.out.println("3. xóa sản phẩm trong kho : ");
			System.out.println(" 4. nhập đơn hàng ");
			System.out.println("5. sửa đơn hàng ");
			System.out.println("6. xóa đơn hàng ");
			System.out.println("7. lưu đơn hàng vào file ");
			System.out.println("8. hiển thị tất cả các đơn hàng");
			System.out.println("9. Đọc dữ liệu đơn hàng từ file ");
			System.out.println("Nhập lựa chọn : ");
			luaChon = sc.nextInt();

			if (luaChon == 1) {
				danhSachSanPhamTrongKho.themSanPhamVaokho();
			} else if (luaChon == 2) {
				danhSachSanPhamTrongKho.suaSanPhamThemVaoKho();
			} else if (luaChon == 3) {
				danhSachSanPhamTrongKho.xoaSanPhamThemVaoKho();
			} else if (luaChon == 4) {
				sc.nextLine();
				danhSachDonHang.themDonHang();
			} else if (luaChon == 5) {
				danhSachDonHang.suaDoiDonHang();
			} else if (luaChon == 6) {
				danhSachDonHang.xoaDonHang();
			} else if (luaChon == 7) {
				sc.nextLine();
				System.out.println("Nhập file ");
				String fileString = sc.nextLine();
				File file = new File(fileString);

				danhSachDonHang.ghiFile(file);
				;
			} else if (luaChon == 8) {
				danhSachDonHang.hienThiTatCa();
			} else if (luaChon == 9) {
				sc.nextLine();
				System.out.println("Nhập file : ");
				String fileString = sc.nextLine();
				File file = new File(fileString);
				danhSachDonHang.docFile(file);
			} else if (luaChon == 10) {
				danhSachDonHang.tongTienPhaiTra();
			}
		} while (luaChon != 0);

	}
}
