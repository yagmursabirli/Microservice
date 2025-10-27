-- src/main/resources/data.sql içeriği
INSERT INTO PRODUCT (id, name, price) VALUES (1, 'Gözlük', 250.0);
INSERT INTO PRODUCT (id, name, price) VALUES (2, 'Klavye', 750.0);
ALTER SEQUENCE PRODUCT_SEQ RESTART WITH 3; -- Eğer Sequence kullanıyorsanız, ID'nin devam etmesini sağlar.