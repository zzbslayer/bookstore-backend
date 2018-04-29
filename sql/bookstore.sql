create table books
	(
        bookid         integer NOT NULL AUTO_INCREMENT,
        bookname		varchar(70) NOT NULL,
	    author		varchar(40) NOT NULL,
	    lang		varchar(20) NOT NULL,
        price      numeric(7,2) NOT NULL,
        year       numeric(4,0) NOT NULL,
        count      numeric(5,0) NOT NULL,
        imgsrc  varchar(500) NOT NULL,
        sales   integer NOT NULL,
	    primary key (bookid)
	);

create table category
    (
        categoryid     integer NOT NULL AUTO_INCREMENT,
        bookid         integer NOT NULL,
        category       varchar(30) NOT NULL,
        primary key (categoryid, bookid),
        foreign key (bookid) references books (bookid)
            on delete cascade
    );

create table users
	(
        userid     integer NOT NULL AUTO_INCREMENT,
        username		varchar(20) NOT NULL UNIQUE,
	    pw		varchar(64) NOT NULL,
	    email		varchar(50) NOT NULL UNIQUE,
        phone      varchar(20) NOT NULL UNIQUE,
        avatar    varchar(50000),
	    primary key (userid)
	);

create table roles
    (
        roleid  integer NOT NULL AUTO_INCREMENT,
        username  varchar(20) NOT NULL,
        rolename       varchar(10) NOT NULL,
        primary key (roleid, username),
        foreign key (username) references users (username)
            on delete cascade
    );

create table userstatus
    (
        statusid    integer NOT NULL AUTO_INCREMENT,
        username    varchar(20) NOT NULL UNIQUE,
        user_status varchar(10) NOT NULL,
        primary key (statusid, username),
        foreign key (username) references users (username)
            on delete cascade
    );

create table addresses
    (
        addressid   integer NOT NULL AUTO_INCREMENT,
        username    varchar(20) NOT NULL,
        shippingaddress varchar(500) NOT NULL,
        recipient   varchar(40) NOT NULL,
        phone       varchar(11) NOT NULL,
        primary key (addressid, username),
        foreign key (username) references users (username)
            on delete cascade
    );

create table carts
    (
        cartid  integer NOT NULL AUTO_INCREMENT,
        username  varchar(20) NOT NULL,
        bookid  integer NOT NULL,
        count  integer NOT NULL,
        primary key (cartid, username, bookid),
        foreign key (username) references users (username)
            on delete cascade,
        foreign key (bookid) references books (bookid)
            on delete cascade
    );

create table userorder
    (
        orderid integer NOT NULL AUTO_INCREMENT,
        addressid   integer NOT NULL,
        username varchar(20) NOT NULL,
        date varchar(35) NOT NULL,
        primary key (orderid, username, addressid),
        foreign key (addressid) references addresses (addressid)
            on delete cascade,
        foreign key (username) references users (username)
            on delete cascade
    );

create table orderbooks
    (
        obid    integer NOT NULL AUTO_INCREMENT,
        orderid integer NOT NULL,
        bookid      integer NOT NULL,
        bookname	varchar(70) NOT NULL,
        author		varchar(40) NOT NULL,
        lang		varchar(20) NOT NULL,
        price      numeric(7,2) NOT NULL,
        year       numeric(4,0) NOT NULL,
        amount     numeric(5,0) NOT NULL,
        imgsrc  varchar(500) NOT NULL,
        primary key (obid, orderid, bookid),
        foreign key (orderid) references userorder (orderid)
            on delete cascade
    );

