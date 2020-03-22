INSERT INTO users (id,username,last_name,email,pass,enabled)
values(
 1,'Anton','Yakubovych','asd@asd.com','asd',true
);

INSERT INTO  child (id, name, pass)
values(
          1,'asd@asd.com', 'asd'
      );

INSERT INTO  child (id, name, pass)
values(
          2,'zzz@zzz.com', 'zzz'
      );

INSERT INTO user_child (user_id,child_id)
values (
        1,1
       );

INSERT INTO user_child (user_id,child_id)
values (
           1,2
       );

INSERT Into authorities(email,authority)
values(
1,'ROLE_USER'
);