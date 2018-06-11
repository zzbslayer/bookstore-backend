create table books
	(
        bookid         integer NOT NULL AUTO_INCREMENT,
        bookname	   varchar(70) NOT NULL,
	    author	    varchar(40) NOT NULL,
	    lang	    varchar(20) NOT NULL,
        price       numeric(7,2) NOT NULL,
        year        numeric(4,0) NOT NULL,
        count       numeric(5,0) NOT NULL,
        imgsrc  varchar(500) NOT NULL,
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
        userid          integer NOT NULL AUTO_INCREMENT,
        username	    varchar(20) NOT NULL UNIQUE,
	    pw		        varchar(64) NOT NULL,
	    email		    varchar(50) NOT NULL UNIQUE,
        phone           varchar(20) NOT NULL UNIQUE,
        avatar          varchar(50000),
        rolename        varchar(20) NOT NULL,
        status          varchar(20) NOT NULL,
	    primary key (userid)
	);

