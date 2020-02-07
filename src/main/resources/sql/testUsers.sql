INSERT INTO  child (id, name, pass)
values(
          1,'asd@asd.com', 'asd'
      );

INSERT INTO users (id,username,last_name,email,pass,enabled,child_id)
values(
 1,'Anton','Yakubovych','asd@asd.com','asd',true,1
);

INSERT Into authorities(email,authority)
values(
1,'ROLE_USER'
);