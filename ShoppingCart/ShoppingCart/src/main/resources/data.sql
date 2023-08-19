DROP TABLE IF EXISTS ShoppingCartEntry;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS shopping_cart;

CREATE TABLE `product`(
    `id` INT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `price` INT
);

CREATE TABLE `shopping_cart`(
    `cart_id` INT PRIMARY KEY
);

CREATE TABLE `Shopping_Cart_Entry` (
    `id` INT PRIMARY KEY,
    `cart_id` INT,
    `product_id` INT,
    FOREIGN KEY (cart_id) REFERENCES shopping_cart(cart_id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

INSERT INTO `product` (`id`, `name`, `price`) VALUES (1, 'Cherry Ice cream', 5);
INSERT INTO `product` (`id`, `name`, `price`) VALUES (2, 'Pizza', 10);
INSERT INTO `shopping_cart` (`cart_id`) VALUES(1);