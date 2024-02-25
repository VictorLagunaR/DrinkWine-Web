create database drinkWine;

create table users(
    idUser INT NOT NULL primary key auto_increment,
    name VARCHAR() NOT NULL,
    email VARCHAR(80) NOT NULL,
    password VARCHAR() NOT NULL,
    gender CHAR(1) NOT NULL CHECK (gender IN ('M', 'F', 'N')),
    UNIQUE(email)
);

create table cart(
    idCart int not null primary key auto_increment,
    idUser int not null,
    CONSTRAINT fk_user_id
    FOREIGN KEY (idUser) 
    REFERENCES users (idUser)
);

create table categories(
    idCategory int not null primary key auto_increment,
    name varchar() not null,
    image varchar() not null
);

create table countries(
    idCountry int not null primary key auto_increment,
    name varchar() not null,
    image varchar() not null
);

create table wines(
    idWine int not null primary key,
    idCategory varchar() not null,
    idCountry varchar() not null,
    year int not null,
    description varchar() not null,
    value decimal(6,2) not null,
    image varchar() not null,
    CONSTRAINT fk_category_id
    FOREIGN KEY (idCategory) 
    REFERENCES users (idCategory),
    CONSTRAINT fk_country_id
    FOREIGN KEY (idCountry) 
    REFERENCES users (idCountry),
);

create table itemsCart(
    idItems int not null primary key auto_increment,
    idCart int not null,
    itemValue decimal(6,2) not null,
    quantity int not null,
    CONSTRAINT fk_cart_id
    FOREIGN KEY (idCart) 
    REFERENCES users (idCart),
);

create table purchases(
    idPurchase int not null auto_increment,
    method varchar() not null,
    totalValue decimal(6,2),
    purchaseData data not null, 
);