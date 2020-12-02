INSERT INTO users VALUES ('user','$2a$10$itoKSZKhDILW9mGYkhFQR.pxBuf8YIE/pUutAHvsDxUAfF7KXHlG.','UserPerson','UserPL',1);

INSERT INTO users VALUES ('admin', '$2a$10$kIvj3GVD71KgmTQ3gUBwu.CwyFppYBsgTPVo89xkxvYX77/l9OTda', 'Admin', 'Baba', '1');

INSERT INTO authorities VALUES ('user','USER');

INSERT INTO authorities VALUES ('admin', 'USER');

INSERT INTO groups VALUES (1, 'ADMIN_GROUP');

INSERT INTO group_authorities VALUES (1, 'ADMIN');

INSERT INTO group_members VALUES (1, 'admin', 1);