insert into books values (1, "The Witcher", "Andrzej Sapkowski", "Polish", 196.00, 1993, 123, "https://images-na.ssl-images-amazon.com/images/I/51fIWZgE3-L._SY484_BO1,204,203,200_.jpg");
insert into books values (2, "Inu to Hasami wa Tsukaiyo", "Shunsuke Sarai Tetsuhiro Nabeshima", "Japanese", 21.30, 2011, 34, "https://images-cn.ssl-images-amazon.com/images/I/51caLYMFqhL._SX337_BO1,204,203,200_.jpg");
insert into books values (3, "Watashi ga Motenai no wa Do Kangaete mo Omaera ga Warui", "Nico Tanigawa", "Japanese", 34.30, 2013, 432, "https://gd1.alicdn.com/imgextra/i1/0/TB1HMC0cukJL1JjSZFmXXcw0XXa_!!0-item_pic.jpg_400x400.jpg");
insert into books values (4, "Ore no Kanojo to Osananajimi ga Shyuraba Sugiru", "Yuji Yuji", "Japanese", 55.60, 2011, 32, "https://images-na.ssl-images-amazon.com/images/I/51I6rw416jL._AC_US320_FMwebp_QL65_.jpg");
insert into books values (5, "The Devil is a Part-Timer!", "Satoshi Wagahara", "Japanese", 71.00, 2011, 73, "https://images-na.ssl-images-amazon.com/images/I/51n+hrNYTYL._AC_US436_QL65_.jpg");
insert into books values (6, "Overlord", "Satoshi Oshio", "Japanese", 74.00, 2012, 62, "https://images-na.ssl-images-amazon.com/images/I/51VUcYynY+L._AC_SR320,436_QL65_.jpg");
insert into books values (7, "A Certain Magical Index", "Kazuma Kamachi", "Japanese", 30.00, 2004, 103, "https://images-na.ssl-images-amazon.com/images/I/51MPxZvR5hL._AC_US436_QL65_.jpg");
insert into books values (8, "A Certain Scientific Railgun", "Kazuma Kamachi", "Japanese", 30.00, 2007, 114, "https://images-na.ssl-images-amazon.com/images/I/512eq6LtkWL._AC_US436_FMwebp_QL65_.jpg");

insert into users values (1,"zzbslayer","$2a$10$1grydO953yDbgV5JBvv8YOKX1t9WM1fKF0OY/hRJQEt2tm4ik0jtC","zzbslayer@sjtu.edu.cn","18016410637","null");
insert into users values (2,"dd","$2a$10$vRL53GtKQe0pwkCQoFP1kOYEAyXd3mPLR6AaIHWqlwvaaRKtylQbK","dd@sjtu.edu.cn","18811212312","null");

insert into roles values (1,"zzbslayer","ADMIN");
insert into roles values (2,"zzbslayer","USER");
insert into roles values (3,"dd","USER");

insert into userstatus values (1,"dd","NORMAL");

insert into addresses values (1, "zzbslayer", "Shanghai Minghang District Shanghai Jiao Tong University Dormitory X13", "Jiansi Wang", "18016410637");
insert into addresses values (2, "zzbslayer", "Shanghai Minghang District East China Normal University ", "Evan Song", "18022222222");

insert into carts values (1,"zzbslayer",1,1);
insert into carts values (2,"zzbslayer",2,2);
insert into carts values (3,"zzbslayer",4,5);
insert into carts values (4,"zzbslayer",6,2);
insert into carts values (5,"zzbslayer",8,3);

insert into category values (1,1,"Fantasy");
insert into category values (2,2,"Comedy");
insert into category values (3,3,"Kuuki Kei");
insert into category values (4,3,"Cringe Comedy");
insert into category values (5,3,"Black Comedy");
insert into category values (6,4,"Harem");
insert into category values (7,4,"Romantic Comedy");
insert into category values (8,4,"Kuuki Kei");
insert into category values (9,5,"Action");
insert into category values (10,5,"Comedy");
insert into category values (11,5,"Fantasy");
insert into category values (12,6,"Fantasy");
insert into category values (13,7,"Action");
insert into category values (14,7,"Comedy Drama");
insert into category values (15,7,"Science Fantasy");
insert into category values (16,8,"Action");
insert into category values (17,8,"Comedy Drama");
insert into category values (18,8,"Science Fantasy");

insert into userorder values (1,1,"zzbslayer");
insert into userorder values (2,2,"zzbslayer");

insert into orderbooks values (1,1,1, "The Witcher", "Andrzej Sapkowski", "Polish", 196.00, 1993, 1, "https://images-na.ssl-images-amazon.com/images/I/51fIWZgE3-L._SY484_BO1,204,203,200_.jpg");
insert into orderbooks values (2,1,2, "Inu to Hasami wa Tsukaiyo", "Shunsuke Sarai Tetsuhiro Nabeshima", "Japanese", 21.30, 2011, 3, "https://images-cn.ssl-images-amazon.com/images/I/51caLYMFqhL._SX337_BO1,204,203,200_.jpg");
insert into orderbooks values (3,2,3, "Watashi ga Motenai no wa Do Kangaete mo Omaera ga Warui", "Nico Tanigawa", "Japanese", 34.30, 2013, 2, "https://gd1.alicdn.com/imgextra/i1/0/TB1HMC0cukJL1JjSZFmXXcw0XXa_!!0-item_pic.jpg_400x400.jpg");
insert into orderbooks values (4,2,7, "A Certain Magical Index", "Kazuma Kamachi", "Japanese", 30.00, 2004, 1, "https://images-na.ssl-images-amazon.com/images/I/51MPxZvR5hL._AC_US436_QL65_.jpg");

