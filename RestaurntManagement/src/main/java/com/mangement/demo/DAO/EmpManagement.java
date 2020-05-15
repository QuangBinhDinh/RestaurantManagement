package com.mangement.demo.DAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mangement.demo.entity.NHANVIEN;
import java.util.*;
@Repository
public interface EmpManagement extends JpaRepository<NHANVIEN, String> {
	 @Query(value = "select * from NHANVIEN where hoten = :name ", nativeQuery= true)
     public List<NHANVIEN> findByName(@Param("name") String name);
	 
	 @Query(value = "select * from NHANVIEN where tk = :username ", nativeQuery= true)
     public List<NHANVIEN> findByUserName(@Param("username") String name);
	 
	 @Modifying
	 @Query(value = "update NHANVIEN set hoten= :hoten, ngaysinh= to_date(:ngaysinh,'DD-MON-YY'), diachi= :diachi,"
	 		+ "sdt= :sdt, email= :email, tk_nganhang= :nganhang where tk= :username" , nativeQuery=true)
	 public void updateEmpByUserame(@Param("hoten") String hoten, @Param("ngaysinh") String ns, @Param("diachi") String dc,
			 @Param("sdt") long sdt, @Param("nganhang") long tknh, @Param("username") String user);
}
