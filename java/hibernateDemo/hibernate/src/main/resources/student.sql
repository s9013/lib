--班级表
create table grade
(
	gid int primary key,
	gname varchar(20) not null,
	gdesc varchar(50)
);
--学生表
create table student
(
	sid int primary key,
	sname varchar(20) not null,
	sex char(2),
	gid int
);
--外键
alter table student add constraint fk_student_gid foreign key(gid) references grade(gid);

--插入数据
insert into grade(gname,gdesc) values("Java","Java基础班");
insert into grade(gname,gdesc) values("javascript","js强化班");

insert into student(sname,sex,gid) values("Jay","男",1);
insert into student(sname,sex,gid) values("Mike","男",1);
insert into student(sname,sex,gid) values("Mike","男",2);

