insert into user(username, password) values ('admin', '$2a$10$XQrPm4GW2oZYIEvyyiTNPeH.IlKi5ZOa5gJirLXTx/FX2qyOU1WE6');
insert into authority(name, description) values ('ADMIN', 'Role admin');
insert into user_authority(id_user, id_authority) values (1,1);
