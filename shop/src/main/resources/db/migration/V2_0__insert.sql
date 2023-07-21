INSERT INTO product_category (description, name) VALUES ( 'new kitchen supplies', 'kitchen');

INSERT INTO product (price, weight, product_category, description, image_url, name) VALUES (5, 2, (select id from product_category where name ='kitchen' limit 1), 'a nice one', 'www.google.com', 'spoon');