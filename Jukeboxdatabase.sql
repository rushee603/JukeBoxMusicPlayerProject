create database jukebox;
use jukebox;
-- --------------------------------------------- users table ------------------------------------------------------
create table users
(
 userid int not null primary key,
 username varchar (30) not null,
 mobileno bigint not null,
 passwords bigint not null
  
);
select * from users;
-- ----------------------------------------------- Song table -----------------------------------------------------
create table songs
(
songid varchar(20) not null primary key ,
songname varchar(30) not null,
artistname varchar (30) not null,
genres varchar (30) not null,
duration varchar(30) not null,
songpath varchar(80) not null

);
-- --------------------------------------------- postcast table ----------------------------------------------

create table Podcast
(
    podcastid varchar(20) not null primary key,
    podcastname varchar (40) not null,
    artistname  varchar(30) not null,
	duration varchar(30) not null,
	potcastpath varchar(200) not null

);
-- ------------------------------------------- playlist table ----------------------------------------------
create table playlist
(
   playlistid  varchar(30) not null primary key,
   playlistname varchar(50) not null, 
   userid  int not null,
  
	foreign key(userid) references users(userid) on update cascade on delete cascade
);
-- -------------------------------------- playlistdetails table ------------------------------------------------
create table playlistdetail
(
	playlistid varchar(30) not null,
  
   songpodcastid varchar(50) , 
   
   foreign key(playlistid) references playlist(playlistid) on update cascade on delete cascade,
   foreign key(songpodcastid) references songs(songid) on update cascade on delete cascade,
foreign key(songpodcastid) references podcast(podcastid) on update cascade on delete cascade
);

drop table playlistdetails;
-- ------------------------------------------- podcast -----------------------------------------------------------------------------------------------------------------
insert into podcast  values('P130','Podcast1','Sandeep_Maheshwari','00:03:23','F:\\NIIT Study Materials\\Course 6\\Jukeboxproject\\JukeboxNewProject\\src\\podcast1.wav');
insert into podcast  values('P131','Podcast2','Robbert_Kiosakki','00:05:36','F:\\NIIT Study Materials\\Course 6\\Jukeboxproject\\JukeboxNewProject\src\\podcast2.wav');
insert into podcast  values('P132','Podcast3','Lores Bishnoi','00:04:30','F:\\NIIT Study Materials\\Course 6\\Jukeboxproject\\JukeboxNewProject\\src\\podcast3.wav');
insert into podcast  values('P133','Podcast4','Sadhguru','00:04:00','F:\\NIIT Study Materials\\Course 6\\Jukeboxproject\\JukeboxNewProject\src\\podcast2.wav');
-- ------------------------------------------------------- songs ----------------------------------------------------------------------------------------------------------------
insert into songs  values('S144','Shoorveer','Rapperiya B','Motivetional','00:03:24','F:\\NIIT Study Materials\\Course 6\\Jukeboxproject\\JukeboxNewProject\\src\\Shoorveer.wav');
insert into songs  values('S145','Cheap Thrills','SIA','Dance','00:03:30','F:\\NIIT Study Materials\\Course 6\\Jukeboxproject\\JukeboxNewProject\\src\\Cheap Thrills.wav');
insert into songs  values('S146','Gods_Plan','Drake','Dance','00:06:40','F:\\NIIT Study Materials\\Course 6\\Jukeboxproject\\JukeboxNewProject\\src\\Drake_-_Gods_Plan_Olagist.co_.wav');
insert into songs  values('S148','Options','','Morning_vibe','00:04:12','F:\\NIIT Study Materials\\Course 6\\Jukeboxproject\\JukeboxNewProject\\src\\Pitbull-Ft.-Stephen-Marley-Options-_www.SongsLover.com_.wav');
-- ----------------------------------------- display tables --------------------------------------------------------
use jukebox;
-- ------------------------------------------------------------------------------------------------------------------
select * from users;
select * from songs;
select * from podcast;
select * from playlist;
select * from playlistdetail;
--  --------------------------------------------------------------------------------------------------------------------


