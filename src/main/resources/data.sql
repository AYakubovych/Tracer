INSERT INTO users (username,last_name,email,pass,enabled)
values(
 'Anton','Yakubovych','asd@asd.com','asd',true
);

INSERT Into authorities(email,authority)
values(
'asd@asd.com','ROLE_USER'
);