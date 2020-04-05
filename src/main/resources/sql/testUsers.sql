INSERT INTO users (id,username,last_name,email,pass,enabled)
values(
 1,'Anton','Yakubovych','asd@asd.com','asd',true
);

INSERT INTO  target (id, email, name, surname,pass)
values(
          1,'asd@asd.com', 'Anton', 'Yakubovych', 'asd'
      );

INSERT INTO  target (id, email, name, surname,pass)
values(
          2,'zzz@zzz.com', 'Anastasia', 'Borovets','zzz'
      );

INSERT INTO user_target (user_id,target_id)
values (
        1,1
       );

INSERT INTO user_target (user_id,target_id)
values (
           1,2
       );

INSERT Into authorities(email,authority)
values(
1,'ROLE_USER'
);