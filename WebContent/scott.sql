-------------- board
drop table board;
create table board(
  pk number primary key,
  fk_category number,
  id varchar2(40) not null,
  name varchar2(20) not null,
  title varchar2(60) not null,
  content varchar2(4000) not null,
  created date not null,
  replied date,
  replies number,
  is_valid varchar2(5)
);
drop sequence seq_board;
create sequence seq_board;
insert into board values(seq_board.nextval,1,'������','manager','�ڹ� ī�װ� ���Դϴ�','�ڹٰ� ���� �������', sysdate, sysdate, 0, 'true');
insert into board values(seq_board.nextval,1,'������','lhi','��','�߸�����׿�', sysdate, sysdate, 0, 'true');
insert into board values(seq_board.nextval,2,'������','manager','�ȵ���̵� ī�װ� ���Դϴ�','�ȵ�� �����', sysdate, sysdate, 0, 'true');
select * from board;
commit;
------------------- cafe
drop table cafe;
create table cafe(
  pk number primary key,
  manager_id varchar2(40) not null,
  organization_uri varchar2(60),
  detail varchar2(1000),
  name varchar2(60) not null unique,
  uri varchar2(60) not null unique,
  search_words varchar2(60),
  is_search varchar2(5) not null,
  is_valid varchar2(5) not null,
  is_organization varchar2(5) not null,
  join_rule number
);
drop sequence seq_cafe;
create sequence seq_cafe;
insert into cafe values(seq_cafe.nextval, 'dongsung', 'dongsung.org', '�󼼼���...', '�����п�', 'dongsung.org', '����|�п�|�ڹ�', 'true', 'true', 'true', 1);
insert into cafe values(seq_cafe.nextval, '3yobaby', '', '������ : ������', '�ڹٽ��͵�', 'khtcafe.cafe', '�ڹ�|��|�ȵ���̵�', 'true', 'true', 'false', 1);
select * from cafe;
commit;

--------------------- category
drop table category;
create table category(
  pk number primary key,
  cafe_uri varchar2(60) not null,
  name varchar2(60) not null,
  type varchar2(60) not null,
  created date not null,
  replied date not null
);
drop sequence seq_category;
create sequence seq_category;
insert into category values(seq_category.nextval, 'dongsung.org', '�ڹ� ī�װ�', 'default', sysdate, sysdate);
insert into category values(seq_category.nextval, 'dongsung.org', '�ȵ���̵�', 'default', sysdate, sysdate);
select * from category;
commit;

drop table member;
create table member(
  pk number primary key,
  id varchar2(40),
  pass varchar2(60),
  name varchar2(40),
  email varchar2(40),
  tel varchar2(20),
  joined date 
);
drop sequence seq_member;
create sequence seq_member;
insert into member values(seq_member.nextval, 'tester', '1234','�׽���','test@test.com', '010-1111-1111', sysdate);
insert into member values(seq_member.nextval, 'lee', '1234','������','lee@han.il', '116', sysdate);
insert into member values(seq_member.nextval, '3yobaby', '1234', '������','minionofdiablo@nate.com','010-6688-2199', sysdate);
select * from member;
commit;

drop table member_joined_cafe;
create table member_joined_cafe(
  pk number primary key,
  member_id varchar2(20),
  manager_id varchar2(20),
  cafe_uri varchar2(60),
  member_type number
);
drop sequence seq_member_joined_cafe;
create sequence seq_member_joined_cafe;
insert into member_joined_cafe values(seq_member_joined_cafe.nextval, '3yobaby', 'dongsung' , 'dongsung.org', 1);
insert into member_joined_cafe values(seq_member_joined_cafe.nextval, '3yobaby', '3yobaby' , 'khtcafe.cafe', 1);
select * from member_joined_cafe;
commit;