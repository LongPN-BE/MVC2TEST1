Create database MVC2TEST1
USE MVC2TEST1
GO
Create table registration(
username nvarchar(20) not null PRIMARY KEY,
password nvarchar(30) not null ,
lastname nvarchar(50) not null ,
isAdmin  bit)
GO
Create table tbl_Mobile(
mobileID nvarchar(10) PRIMARY KEY,
mobilename nvarchar(50) not null,
ProductDescription nvarchar(255) not null, 
Price decimal not null)
GO
Create table tbl_Checkout(
checkoutID int not null,
mobileID nvarchar(10) not null,
quantity int not null,
times DATETIME not null
CONSTRAINT fk_id_mobile
  FOREIGN KEY (mobileID)
  REFERENCES tbl_Mobile (mobileID)
 )


---------------------------------------------------------------------
INSERT INTO registration values ('user' , '123', 'User', 0)
INSERT INTO registration values ('admin' , '123', 'ADMIN', 1)
INSERT INTO registration values ('manager' , '123', 'MANAGER', 1)

INSERT INTO tbl_Mobile (mobileID,mobilename,ProductDescription,Price) Values ('MBI01','Iphone 7 Plus','Description for MBI01','129')
INSERT INTO tbl_Mobile (mobileID,mobilename,ProductDescription,Price) Values ('MBI02','Samsung M51','Description for MBI02','229')
INSERT INTO tbl_Mobile (mobileID,mobilename,ProductDescription,Price) Values ('MBI03','Xiaomi Note 9','Description for MBI03','159')
INSERT INTO tbl_Mobile (mobileID,mobilename,ProductDescription,Price) Values ('MBI04','Iphone 8 Plus','Description for MBI04','229')
INSERT INTO tbl_Mobile (mobileID,mobilename,ProductDescription,Price) Values ('MBI05','Horno 8x','Description for MBI05','119')

---------------------------------------------------------------------------

select * from registration
select * from tbl_Mobile
select * from tbl_Checkout

/*update*/
update registration 
set isAdmin = '1' , lastname = 'ADMIN'
where username = 'admin'

update registration set password = '123', lastname = 'ADMIN', isAdmin = '1'  Where username = 'admin'

Select mobileID,mobilename,ProductDescription,Price
From tbl_Mobile
where mobilename like '% %'

SELECT TOP 1 checkoutID FROM tbl_Checkout ORDER BY checkoutID DESC

insert into tbl_Checkout(checkoutID,mobileID,quantity,times) values(0,'MBI05',1,GETDATE() )
insert into tbl_Checkout(checkoutID,mobileID,quantity,times) values(1,'MBI04',1, GETDATE() )

