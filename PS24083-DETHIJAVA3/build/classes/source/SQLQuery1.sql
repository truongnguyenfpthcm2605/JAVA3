create database store
go
use store
go
create table manager
(
	maHoadon varchar(10) primary key,
	maHang varchar(10) not null,
	tenHang nvarchar(30),
	ngaymua date,
	soluong int,
	dongia float,
	thanhtien float

)
go
insert into manager values(?,?,?,?,?,?,?)
update manager set maHang =?, tenHang =?,ngaymua=?,soluong = ?,dongia= ?,thanhtien = ? where maHoadon =?