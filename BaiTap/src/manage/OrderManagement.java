package manage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderManagement {
	private ArrayList<Order> danhSachCacDonHang;
	private ArrayList<Product> danhSachSanPhamTrongDonHang = new ArrayList<Product>();

	Scanner sc = new Scanner(System.in);

	public OrderManagement(ArrayList<Order> danhSachCacDonHang) {
		this.danhSachCacDonHang = danhSachCacDonHang;
	}

	public OrderManagement() {
		this.danhSachCacDonHang = new ArrayList<Order>();
	}

	public void themDonHang() {
		System.out.println("Nhập mã đơn hàng : ");
		String maDonHang = sc.nextLine();
		System.out.println("Nhập ngày đặt hàng : ");
		String ngayDatHangString = sc.nextLine();
		System.out.println("Nhập ngày giao hàng : ");
		String ngayGiaoHangString = sc.nextLine();

		try {
			SimpleDateFormat ngayFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date ngayDatHang = ngayFormat.parse(ngayDatHangString);
			Date ngayGiaoHang = ngayFormat.parse(ngayGiaoHangString);
			System.out.println("Nhập tên khách hàng : ");
			String tenKhachHang = sc.nextLine();
			System.out.println("Nhập địa chỉ : ");
			String diaChi = sc.nextLine();
			int luaChon = 0;
			do {
				System.out.println("Nhập mã sản phẩm : ");
				String maSanPham = sc.nextLine();
				System.out.println("Nhập tên sản phẩm : ");
				String tenSanPham = sc.nextLine();
				System.out.println("Nhập giá sản phẩm : ");
				int giaSanPham = sc.nextInt();
				System.out.println("Nhập số lượng : ");
				int soLuong = sc.nextInt();
				System.out.println("Bạn có muốn nhập sản phẩm trong đơn hàng không ?");
				System.out.println("Nhập 1 để tt | 0 để thoát ");
				luaChon = sc.nextInt();
				sc.nextLine();
				Product product = new Product(maSanPham, tenSanPham, giaSanPham, soLuong);

				danhSachSanPhamTrongDonHang.add(product);
			} while (luaChon != 0);
			Order order = new Order(maDonHang, ngayDatHang, ngayGiaoHang, tenKhachHang, diaChi,
					danhSachSanPhamTrongDonHang);
			danhSachCacDonHang.add(order);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void suaDoiDonHang() {
		System.out.println("Nhập mã đơn hàng cần sửa đổi : ");
		String maDonHang = sc.nextLine();
		danhSachCacDonHang.forEach(order -> {
			if (order.getMaDonhang().equals(maDonHang)) {
				System.out.println("Nhập ngày đặt hàng : ");
				String ngayDatHangString = sc.nextLine();
				System.out.println("Nhập ngày giao hàng : ");
				String ngayGiaoHangString = sc.nextLine();

				try {
					SimpleDateFormat ngayFormat = new SimpleDateFormat("dd-MM-yyyy");
					Date ngayDatHang = ngayFormat.parse(ngayDatHangString);
					Date ngayGiaoHang = ngayFormat.parse(ngayGiaoHangString);
					System.out.println("Nhập tên khách hàng : ");
					String tenKhachHang = sc.nextLine();
					System.out.println("Nhập địa chỉ : ");
					String diaChi = sc.nextLine();
					int luaChon = 0;
					do {
						System.out.println("Nhập mã sản phẩm : ");
						String maSanPham = sc.nextLine();
						System.out.println("Nhập tên sản phẩm : ");
						String tenSanPham = sc.nextLine();
						System.out.println("Nhập giá sản phẩm : ");
						int giaSanPham = sc.nextInt();
						System.out.println("Nhập số lượng : ");
						int soLuong = sc.nextInt();
						System.out.println("Bạn có muốn nhập sản phẩm trong đơn hàng không ?");
						System.out.println("Nhập 1 để tt | 0 để thoát ");
						luaChon = sc.nextInt();
						Product product = new Product(maSanPham, tenSanPham, giaSanPham, soLuong);

						danhSachSanPhamTrongDonHang.add(product);
					} while (luaChon != 0);
					Order orderSuaDoi = new Order(maDonHang, ngayDatHang, ngayGiaoHang, tenKhachHang, diaChi,
							danhSachSanPhamTrongDonHang);
					danhSachCacDonHang.remove(order);
					danhSachCacDonHang.add(orderSuaDoi);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				return;
			}

		});
		System.out.println("Mã đơn hàng bạn cần tìm không tồn tại!");
	}

	public void xoaDonHang() {
		System.out.println("Nhập mã đơn hàng cần xóa : ");
		String maDonHangCanXoa = sc.nextLine();
		danhSachCacDonHang.forEach(order -> {
			if (order.getMaDonhang().equals(maDonHangCanXoa)) {
				danhSachCacDonHang.remove(order);
				return;
			}
		});
		System.out.println("Mã đơn hàng bạn cần tìm không tồn tại!");
	}

	public void ghiFile(File file) {
		try {
			OutputStream os = new FileOutputStream(file);
			PrintWriter pw = new PrintWriter(os);
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			danhSachCacDonHang.forEach(order->{
				pw.println("Mã đơn hàng : "+order.getMaDonhang());
				pw.println("Ngày đăt hàng : "+dateFormat.format(order.getNgayDatHang()));
				pw.println("Ngày giao hàng : "+dateFormat.format(order.getNgayGiaoHang()));
				pw.println("Tên khách hàng : "+order.getTenKhachHang());
				pw.println("Địa chỉ : "+order.getDiaChi());
				danhSachSanPhamTrongDonHang.forEach(product->{
					pw.println("Mã sản phẩm trong đơn hàng : "+product.getMaSanPham());
					pw.println("Tên sản phẩm trong đơn hàng : "+product.getTenSanPham());
					pw.println("Giá tiền sản phẩm : "+product.getGiaTien());
					pw.println("Số lượng : "+product.getSoLuong());
					
				});
			});
//			for (Order order : danhSachCacDonHang) {
//				pw.println("Mã đơn hàng : " + order.getMaDonhang());
//				pw.println("Ngày đăt hàng : " + order.getNgayDatHang());
//				pw.println("Ngày giao hàng : " + order.getNgayGiaoHang());
//				pw.println("Tên khách hàng : " + order.getTenKhachHang());
//				pw.println("Địa chỉ : " + order.getDiaChi());
//				for (Product product : danhSachSanPhamTrongDonHang) {
//					pw.println("Mã sản phẩm trong đơn hàng : " + product.getMaSanPham());
//					pw.println("Tên sản phẩm trong đơn hàng : " + product.getTenSanPham());
//					pw.println("Giá tiền sản phẩm : " + product.getGiaTien());
//					pw.println("Số lượng : " + product.getSoLuong());
//				}
//			}
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void docFile(File file) {
		try {
			List<String> allFile = Files.readAllLines(file.toPath());
			allFile.forEach(lines -> System.out.println(lines));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void timKiemDonHangTheoMaDonHang(String maDonHang) {
		danhSachCacDonHang.forEach(order -> {
			if (order.getMaDonhang().equals(maDonHang)) {
				System.out.println("Đơn hàng cần tìm: ");
				System.out.println(order);
				return;
			}
		});
		System.out.println("Đơn hàng cần tìm không tồn tại !");
	}

	public void timKiemDonHangTheoTenKh(String tenKhachHang) {
		danhSachCacDonHang.forEach(order -> {
			if (order.getTenKhachHang().equals(tenKhachHang)) {
				System.out.println("Đơn hàng cần tìm : ");
				System.out.println(order);
				return;
			}
		});
		System.out.println("Đơn hàng cần tìm không tồn tại !");
	}

	public void timKiemDonHangTheoNgayDh(Date ngayDatHang) {
		danhSachCacDonHang.forEach(order -> {
			if (order.getNgayDatHang().equals(ngayDatHang)) {
				System.out.println("Đơn hàng cần tìm : ");
				System.out.println(order);
				return;
			}
		});
		System.out.println("Đơn hàng cần tìm không tồn tại !");
	}

	public void timKiemDonHangTheoNgayGh(Date ngayGiaoHang) {
		danhSachCacDonHang.forEach(order -> {
			if (order.getNgayDatHang().equals(ngayGiaoHang)) {
				System.out.println("Đơn hàng cần tìm : ");
				System.out.println(order);
				return;
			}
		});
		System.out.println("Đơn hàng cần tìm không tồn tại !");
	}

	public void sapXepTheoNgayDatHang() {
		danhSachCacDonHang.stream().sorted(Comparator.comparing(Order::getNgayDatHang)).forEach(System.out::println);
	}

	public void hienThiTatCa() {
		danhSachCacDonHang.forEach(order -> System.out.println(order));
	}

	public void tongTienPhaiTra() {
		double tongTien =0;
//		danhSachSanPhamTrongDonHang.forEach(product -> {
////			System.out.println(product.giaBanToiNguoiDung(product.getGiaTien()));
//			tongTien += product.giaBanToiNguoiDung(product.getGiaTien());
//		});
		for(Product product : danhSachSanPhamTrongDonHang) {
			tongTien += product.giaBanToiNguoiDung(product.getGiaTien());
		}
	System.out.println(tongTien);
	}
}

