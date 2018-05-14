create database bookstore character set UTF8;
use bookstore;
/*类型表*/
CREATE TABLE TYPES(
  id VARCHAR(32) PRIMARY KEY,
  NAME VARCHAR(50),
  des VARCHAR(200)
);
/*图书表*/
CREATE TABLE books(
	id VARCHAR(32) PRIMARY KEY,
	NAME VARCHAR(50),
	price NUMERIC(10,2),
	auth VARCHAR(30),
	img VARCHAR(100),
	rebate NUMERIC(3,2),/*最多3位，小位为2*/
	stock INT,			/*存量*/
	publisher VARCHAR(100),/*出版社*/
	publishdate VARCHAR(19),
	pages INT,
	size INT,
	printtimes INT,
	versions INT,
	brief TEXT,
	content TEXT,
	onlinetime varchar(19)/*上架时间*/
);
/*关联表*/
create table booktype(
   bookid varchar(32) not null,
   typeid varchar(32) not null,
   CONSTRAINT btpk primary key(bookid,typeid),
   constraint btfk1 foreign key(bookid) references books(id),
   constraint btfk2 foreign key(typeid) references types(id)
);
/*第二天*/
/*创建users表*/
create table users(
  id varchar(32) primary key,
  name varchar(30),
  pwd varchar(32),
  mail varchar(100)
);

/**
订单表
*/
create table orders(
  id varchar(11) primary key,
  addr varchar(500),/*这个字段不是对address表的引用，是addres表的copy，王健，中国，12333*/
  money numeric(10,2),
  stat  char(1),/*0：未发货，1：已发货，2：交易完成，3：退货*/
  uid varchar(32),
  ctime varchar(19),
  constraint order_fk foreign key(uid) references users(id)
);
/**
订单明细，记录此订单所买入的是什么书，以及是什么价格,几本
*/
create table orderline(
    id varchar(32) primary key,
    bookid varchar(32),
    cont int,
    price numeric(10,2),
    orderid varchar(11),
    constraint ol_fk1 foreign key(bookid) references books(id),
    constraint ol_fk2 foreign key(orderid) references orders(id)
);
/**
地址表
*/
create table address(
   id varchar(32) primary key,
   addr varchar(100),/*地址,中国*/
   name varchar(40),
   tel varchar(30),
   uid varchar(32), 
   dft char(1), /*是否是默认收货地址*/
   constraint addr_fk1 foreign key(uid) references users(id)
);


