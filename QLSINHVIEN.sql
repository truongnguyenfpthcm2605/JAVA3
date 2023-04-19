CREATE DATABASE QLSINHVIEN
GO
USE QLSINHVIEN
GO

CREATE TABLE STUDENTS
(	
	Masv nvarchar(10) not null primary key,
	Hoten nvarchar(30) ,
	Email nvarchar(30),
	SoDT nvarchar(10),
	GioiTinh bit,
	Diachi nvarchar(100)
)
insert into STUDENTS values
(N'SV001',N'Nguyễn Văn Trường',N'truongnguyen@fpt.edu.vn',N'023425785',1,N'Tháp Mười,Đồng Tháp'),
(N'SV002',N'Võ Văn Hậu',N'hauvan@fpt.edu.vn',N'565425785',1,N'Băng cốc, Thái Lan'),
(N'SV003',N'Võ Thị My',N'myvo@fpt.edu.vn',N'023434585',0,N'Quận 12, TP.HCM'),
(N'SV004',N'Hồ Văn Nam',N'namho@fpt.edu.vn',N'023335785',1,N'Bến Lức,Long An'),
(N'SV005',N'Huỳnh Thị Nga',N'nganguynh@fpt.edu.vn',N'122345785',0,N'Quận 1 , TP.HCM'),
(N'SV006',N'Nguyễn Minh Nghĩa',N'minhnghia@fpt.edu.vn',N'3323425785',1,N'Trường Xuân,Đồng Tháp'),
(N'SV007',N'Mai Thị Ngọc',N'maingoc@fpt.edu.vn',N'1113425785',0,N'Quận 1 , TP.HCM'),
(N'SV008',N'Nguyễn Chí Thành',N'chithanh@fpt.edu.vn',N'024342785',1,N'Năm căn, Cà Mau'),
(N'SV009',N'Nguyễn Thị Thùy Trang',N'thuytrang@fpt.edu.vn',N'023434385',0,N'Mỹ Tho ,Tiềng Giang'),
(N'SV010',N'Nguyễn Văn Hiếu',N'hieunguyen@fpt.edu.vn',N'0243525785',1,N'Quận 9, TP.HCM')

select * from STUDENTS
update STUDENTS set Hoten =?, Email = ?,SoDT = ?,GioiTinh =?,Diachi =? where Masv = ?