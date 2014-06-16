-------------- board
drop table board;
create table board(
  pk number primary key,
  fk_category number,
  fk_board number,
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
insert into board values(seq_board.nextval,1,seq_board.nextval,'dongsung','관리자','자바 카테고리 글입니다','자바가 제일 쉬웠어요', sysdate, sysdate, 1, 'true');
insert into board values(seq_board.nextval,1,seq_board.nextval,'lhi','이한일','와','잘만들었네요', sysdate, sysdate, 0, 'true');
insert into board values(seq_board.nextval,2,seq_board.nextval,'dongsung','관리자','안드로이드 카테고리 글입니다','안드는 어려워', sysdate, sysdate, 0, 'true');
insert into board values(seq_board.nextval,1,1,'dongsung','관리자','re : 자바 카테고리 글입니다','답글', sysdate, sysdate, 0, 'true');
select * from board where fk_category=1 order by fk_board desc, pk asc;
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
  join_rule number,
  created date not null
);
drop sequence seq_cafe;
create sequence seq_cafe;
insert into cafe values(seq_cafe.nextval, 'dongsung', 'dongsung.org', '상세설명...', '동성학원', 'dongsung.org', '동성|학원|자바', 'true', 'true', 'true', 1, sysdate);
insert into cafe values(seq_cafe.nextval, '3yobaby', '', '만든이 : 김희택', '자바스터디', 'khtcafe.cafe', '자바|웹|안드로이드', 'true', 'true', 'false', 1, sysdate);
select * from cafe;
commit;

--------------------- category
drop table category;
create table category(
  pk number primary key,
  cafe_uri varchar2(60) not null,
  name varchar2(60) not null,
  type varchar2(10) not null,
  visibility varchar2(10) not null,
  created date not null,
  replied date not null
);
drop sequence seq_category;
create sequence seq_category;
insert into category values(seq_category.nextval, 'dongsung.org', '자바 카테고리', 'default', 'all', sysdate, sysdate);
insert into category values(seq_category.nextval, 'dongsung.org', '안드로이드', 'default', 'all', sysdate, sysdate);
select * from category;
commit;
-------------------------------member
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
insert into member values(seq_member.nextval, 'tester', '1234','테스터','test@test.com', '010-1111-1111', sysdate);
insert into member values(seq_member.nextval, 'lee', '1234','이한일','lee@han.il', '116', sysdate);
insert into member values(seq_member.nextval, '3yobaby', '1234', '김희택','minionofdiablo@nate.com','010-6688-2199', sysdate);
insert into member values(seq_member.nextval, 'dongsung', '1234', '동성학원장','','051-', sysdate);
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
insert into member_joined_cafe values(seq_member_joined_cafe.nextval, 'dongsung', 'dongsung' , 'dongsung.org', 4);
delete from member_joined_cafe where member_id='dongsung' and manager_id != 'dongsung';
select * from member_joined_cafe;
commit;