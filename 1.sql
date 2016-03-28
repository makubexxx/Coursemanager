
//ѡ�α�
create table choicecourse (
  choiceid                  integer auto_increment not null deafut,
  courseid                  integer,
  coursename                varchar(50) not null,
  coursedate                varchar(50) not null,
  userid                    integer,
  start_date                timestamp NULL,
  constraint pk_choicecourse primary key (choiceid))ENGINE=InnoDB DEFAULT CHARSET=gbk; 
  
  //�γ̹���
create table coursenotice (
  noticeid                  integer auto_increment not null,
  courseid                  integer(50) not null,
  noticetitle               varchar(50) not null,
  noticecontext             longtext NULL,
  byuser                    varchar(50) not null,
  userid                    integer,
  pushda_date               timestamp NULL,
  constraint pk_coursenotice primary key (noticeid))ENGINE=InnoDB DEFAULT CHARSET=gbk; 

  
  //�γ̱�����
  create table coursedetail (
  courseid                  integer  not null,
  course_noid               integer(50) not null,
  coursename                varchar(50) not null,
  coursecredit              integer,
  studytimes                integer,
  teachername               varchar(255),
  teacheremail              varchar(255),
  targetbook                varchar(255),
  bibliography              varchar(255),
  teachmodel                varchar(255),
  course_description        longtext NULL,
  coursecanlendar           longtext NULL,
  constraint pk_coursedetail primary key (courseid))ENGINE=InnoDB DEFAULT CHARSET=gbk; 
  
  
  //�γ��ļ�
  
  create table coursedocument (
  coursedocumentid          integer auto_increment not null,
  coursedocumenttitile      varchar(50) not null,
  coursedocument_description varchar(50) not null,
  belongcourseid            varchar(255),
  documentsize              float,
  uploadtime                datetime,
  doucumenturl              varchar(255),
  constraint pk_coursedocument primary key (coursedocumentid)) ENGINE=InnoDB DEFAULT CHARSET=gbk; 
;


//�γ���Դ

create table teachresource (
  teachresourceid           integer auto_increment not null,
  belongcourseid            varchar(50),
  linkname                  varchar(150),
  linkurl                    varchar(150),
  teachresourcedescription  varchar(150),
  constraint pk_teachresource primary key (teachresourceid)) ENGINE=InnoDB DEFAULT CHARSET=gbk; 
  
  
  
  
  
  
  //�γ�����
  
create table coursediscuss (
  coursediscussid           integer auto_increment not null,
  coursediscusstitile       varchar(50) not null,
  belongcourseid            integer,
  bycreate                  varchar(255),
  onclick                   integer,
  response                  integer,
  pushtime                  datetime,
  constraint pk_coursediscuss primary key (coursediscussid)) ENGINE=InnoDB DEFAULT CHARSET=gbk; 
  alter table coursediscuss add column coursediscusscontent varchar(255) not null after coursediscusstitile;
  
  
  //�γ����ۻظ�
  
  
  create table Coursereply (
  coursereplyid             integer auto_increment not null,
  belongcoursediscussid     varchar(255),
  replyuser                 varchar(255),
  reply_content             TEXT,
  reply_date                timestamp NULL,
  constraint pk_Coursereply primary key (coursereplyid)) ENGINE=InnoDB DEFAULT CHARSET=gbk; 
  


//��ҵ�б�

create table courserwork (
  courseworkid              integer auto_increment not null,
  belongcourseid            varchar(255),
  courseworktitle           varchar(255),
  coursework_content        TEXT,
  start_date                timestamp NULL,
  end_date                  timestamp NULL,
  statue                    integer,
  constraint pk_Coursereply primary key (courseworkid)) ENGINE=InnoDB DEFAULT CHARSET=gbk; 
   alter table courserwork add column userid integer not null after belongcourseid;
   alter table courserwork add column attachment  varchar(255) not null after statue;
   alter table courserwork add column  score integer not null after attachment;
