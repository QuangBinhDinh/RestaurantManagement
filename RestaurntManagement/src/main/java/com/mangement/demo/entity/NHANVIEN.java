package com.mangement.demo.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

@Entity
public class NHANVIEN {
	 @Id
	 @Column(name = "MANV")
     private String maNV;
	 
	 @JsonIgnore
	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "chuc_vu", referencedColumnName = "ten_chucvu")
	 private CHUCVU job;
	 
	 
	public CHUCVU getJob() {
		return job;
	}

	public void setJob(CHUCVU job) {
		this.job = job;
	}

	@Column(name = "hoten")
	 private String hoten;
	 
	 @Column(name = "ngaysinh")
	 private String ngaysinh;
	 
	 @Column(name = "diachi")
	 private String diachi;
	 
	 @Column(name = "sdt")
	 private long phone;
	 
	 @Column(name = "email")
	 private String email;
	 
	 @Column(name = "tk_nganhang")
	 private long tk_nganhang;
	 
	 
	 public String getMaNV() {
			return maNV;
		}

		public void setMaNV(String maNV) {
			this.maNV = maNV;
		}

		public String getHoten() {
			return hoten;
		}

		public void setHoten(String hoten) {
			this.hoten = hoten;
		}

		public String getNgaysinh() {
			return ngaysinh;
		}

		public void setNgaysinh(String ngaysinh) {
			this.ngaysinh = ngaysinh;
		}

		public String getDiachi() {
			return diachi;
		}

		public void setDiachi(String diachi) {
			this.diachi = diachi;
		}

		public long getPhone() {
			return phone;
		}

		public void setPhone(long phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public long getTk_nganhang() {
			return tk_nganhang;
		}

		public void setTk_nganhang(long tk_nganhang) {
			this.tk_nganhang = tk_nganhang;
		}

     
}
