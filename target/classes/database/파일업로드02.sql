drop table attach_file02; -- 자식테이블 삭제
drop table board_file02; -- 부모테이블 삭제 
drop sequence bno_file02_seq; -- board시퀀스 삭제


create sequence bno_file02_seq; 
create table board_file02(
    bno number(10) primary key,
    title varchar2(500) not null, 
    content varchar2(400) not null, 
    writer varchar2(50) not null, 
    attachFileCnt number(5) default 0 
);

create table attach_file02(
    bno number(10), 
    filePath varchar2(500) not null,
    fileName varchar2(100) not null, 
    fileType varchar2(20) not null,
    constraint fk_attach_file02 foreign key(bno)
    references board_file02(bno)
);

select * from board_file02; 
select * from attach_file02;

select count(*) as cnt from attach_file02 where bno=1;  
