CREATE DATABASE genshin_food;
USE genshin_food;

CREATE TABLE food (
	idFood INT PRIMARY KEY,
    nameFood VARCHAR(50),
    decriptionFood VARCHAR(1000),
    priceFood INT,
    countryFood VARCHAR(50),
    imgFood VARCHAR(2000)
    );
    
DELIMITER //
CREATE PROCEDURE selectAllFood()

BEGIN 
	SELECT * FROM food;
END //
DELIMITER ;

INSERT INTO food VALUES(1, "Northern Apple Stew", "A dish with braised meat and apples. The meat is juicy in the extreme, and no matter how much of it you eat, you still want more. The way every breath you take is tinged with the flavor of apples reminds you of nothing so much as lying in an apple orchard.", 1000, "Mondstadt", "https://s3.us-east-1.amazonaws.com/gamewith-en/article_tools/genshin-impact/gacha/r_i_42.png");


DELIMITER //
CREATE PROCEDURE addNewFood(
	IN id_Food INT,
    IN name_Food VARCHAR(50),
    IN decription_Food VARCHAR(1000),
    IN price_Food INT,
    IN country_Food VARCHAR(50),
    IN img_Food VARCHAR(2000)
    )
BEGIN
	INSERT INTO food VALUES(id_Food, name_Food, decription_Food, price_Food, country_Food, img_Food);
END //
DELIMITER ;    

SELECT * FROM food;

CALL addNewFood(2, "Pile 'Em Up", "A rich, meaty dish. Originally a Mondstadt dish made of steaks, potatoes, and cheese, it has since become synonymous with Ludi Harpastum.", 4000, "Mondstadt", "https://i.redd.it/ddqrfg5vfhh61.jpg");

DELIMITER //
CREATE PROCEDURE selectById(
	IN id_Food INT
    )
BEGIN 
	SELECT * FROM food WHERE idFood = id_Food;
END //
DELIMITER ;

DELIMITER $$ 
CREATE PROCEDURE deleteFood(
	IN id_Food INT
    )
BEGIN 
	DELETE FROM food WHERE idFood = id_Food;
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE updateFood(
	IN id_Food INT,
    IN name_Food VARCHAR(50),
    IN decription_Food VARCHAR(1000),
    IN price_Food INT,
    IN country_Food VARCHAR(50),
    IN img_Food VARCHAR(2000)
)
 
BEGIN
	UPDATE food
    SET	nameFood = name_Food,
		decriptionFood = decription_Food,
		priceFood = price_Food,
        countryFood = country_Food,
        imgFood = img_Food
	WHERE idFood = id_Food;
END $$

DELIMITER ;

CREATE TABLE Cart(
	id_Cart INT PRIMARY KEY
    );
    
CREATE TABLE Cart_item(
	idFood INT,
    idCart INT,
    FOREIGN KEY (idFood)
    REFERENCES food(idFood),
    FOREIGN KEY (idCart)
    REFERENCES Cart(id_Cart)
);

INSERT INTO Cart VALUES(1);

INSERT INTO Cart VALUES(2);

INSERT INTO Cart_item(idFood, idCart) VALUES (1, 1);

SELECT fo.nameFood, fo.priceFood FROM Cart_item item
INNER JOIN Food fo ON fo.idFood = item.idFood;

SELECT ca.id_Cart, fo.idFood ,fo.nameFood, fo.priceFood FROM Cart ca
INNER JOIN Cart_item item ON ca.id_Cart = item.idCart
INNER JOIN Food fo ON fo.idFood = item.idFood;

DELIMITER //
CREATE PROCEDURE addToCart(
    IN id_Food INT
    )
BEGIN 
	INSERT INTO Cart_item(idFood) VALUES(id_Food);
END //
DELIMITER ;

CALL addToCart(1, 2);
CALL addToCart(1, 3);

DELETE FROM cart;

DELETE FROM cart_item;

DELIMITER //
CREATE PROCEDURE selectCart(
	IN id_Cart int,
    IN id_Food int
    )

BEGIN
	SELECT ca.id_Cart, fo.idFood ,fo.nameFood, fo.priceFood FROM Cart ca
	INNER JOIN Cart_item item ON ca.id_Cart = item.idCart
	INNER JOIN Food fo ON fo.idFood = item.idFood
    WHERE ca.id_Cart = id_Cart;
END //
DELIMITER ;

CALL selectCart(2);

SELECT * FROM cart WHERE id_Cart = 2;


CREATE TABLE orderFood(
	idOrder INT PRIMARY KEY,
    dateOrder VARCHAR(50),
    addressOrder VARCHAR(50),
    total INT,
    statusOrder bit
    );
    
CREATE TABLE orderDetail(
	idOrder INT,
    idFood INT,
    quantity int,
    FOREIGN KEY(idOrder)
    REFERENCES orderFood(idOrder),
    FOREIGN KEY(idFood)
    REFERENCES Food(idFood)
);   

DELIMITER //
CREATE PROCEDURE addNewOrder(
	in id_Order INT,
    in date_Order VARCHAR(50),
    in address_Order VARCHAR(50),
    in total_Order INT,
    in status_Order bit
    )
BEGIN 
	insert into orderFood(idOrder, dateOrder, addressOrder, total, statusOrder)
    values (id_Order, date_Order, address_Order, total_Order, status_Order);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE addOrderDetail(
	in id_Order int,
    in id_Cart int
	)
BEGIN 
	insert into orderDetail(id_Order, id_Cart)
    values (id_Order, id_Cart);
END //
DELIMITER ;

select * from cart;

call selectCart(3);

delete from cart_item where idCart = 3;

insert into cart values(3);

select * from cart_item where idCart = 1;

DELETE FROM cart_item where idCart = 2;

DELIMITER //
CREATE PROCEDURE addOrderDetail(
	in id_Order int,
    in id_Food int,
    in quantity_Order int
    )
begin
	insert into orderDetail(idOrder, idFood, quantity)
    values(id_Order, id_Food, quantity_Order);
end //
DELIMITER ;
	
select * from orderfood;  

select * from orderDetail where idOrder = 1;  

DELIMITER //
create procedure getAllOrder()
begin 
	select * from orderfood;
end //
DELIMITER ;

delimiter //
create procedure getOderDetail(
	in id_Order int)
begin
	select fo.nameFood AS TenSP, fo.priceFood as GiaSP, odetail.quantity as SoLuong FROM orderFood od
    inner join orderdetail odetail on odetail.idOrder = od.idOrder
    inner join food fo on odetail.idFood = fo.idFood
    where od.idOrder = id_Order;
end //
delimiter ;

delimiter //
create procedure getOrderById(
	in id_Order int)
begin
	select * from orderfood where idOrder = id_Order;
end //
delimiter ;

delimiter //
create procedure getFoodById(
	in id_Food int)
begin 
	select * from food where idFood = id_Food;
end //
delimiter ;
    
delimiter //
create procedure getOderDetail1(
	in id_Order int)
begin
	select fo.nameFood AS TenSP, fo.priceFood as GiaSP, odetail.quantity as SoLuong FROM orderFood od
    inner join orderdetail odetail on odetail.idOrder = od.idOrder
    inner join food fo on odetail.idFood = fo.idFood
    where od.idOrder = id_Order;
end //
delimiter ;
    
CALL getOrderDetail(2);