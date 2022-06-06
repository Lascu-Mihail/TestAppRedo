-- parola1
insert into user (id,name,password,username)
values (1, 'Mihai', '$2a$10$SoH3pawKCTAlMjDA5GKPpOU3bFodACbndY6x4l49Z1WzfochfTT2O', 'Jansky');

-- parola1
insert into user (id,name,password,username)
values (2, 'Mircea', '$2a$10$S15Amt33/pn/pG1khxH2T.RyCtqnP5o87tl.irvPDdAy7nO5i75AS', 'Mircea');

-- love
insert into user (id,name,password,username)
values (3, 'Gabi', '$2a$10$4pWDP/awmmmJHeXNndeYpeWLmdm9BFF5h5QtTlMP6Ezt0A0.oJpAm', 'Gaby');


insert into role values(1,'ADMIN'),(2,'USER'),(3,'MANAGER');
insert into user_roles values (1,2),(2,1),(3,3);

insert into county values(county.csv);