
drop table if exists team;
create table team(team_code varchar(100),team_name varchar(100),primary key(team_code));

insert into  team(team_code,team_name) 
values('CSK','Chennai Super Kings'),
('SRH','Sunrisers Hyderbad'),
('PBKS','Punjab Kings'),
('LSG','Lucknow Super Giants')


drop table if exists player;
CREATE TABLE public.player (
	pid serial NOT NULL,
	name varchar(100) NOT NULL,
	role varchar(100) NOT NULL,
	price float NOT NULL,
	country varchar(100) NOT NULL,
	team varchar(100) NULL,
	CONSTRAINT player_pkey PRIMARY KEY (pid),
	CONSTRAINT player_team_fkey FOREIGN KEY (team) REFERENCES team(team_code)
);


INSERT INTO player ("name","role",price,country,team) VALUES
	 ('MSDhoni','WK-Batsman',120000000,'India','CSK'),
	 ('RuturajGaikwad','Batsman',60000000,'India','CSK'),
	 ('RobinUthappa','Batsman',20000000,'India','CSK'),
	 ('AmbatiRayudu','WK-Batsman',67500000,'India','CSK'),
	 ('DevonConway','Batsman',10000000,'New Zealand','CSK'),
	 ('SubhranshuSenapati','Batsman',2000000,'India','CSK'),
	 ('HariNishaanth','Batsman',2000000,'India','CSK'),
	 ('NJagadeesan','WK-Batsman',2000000,'India','CSK'),
	 ('DeepakChahar','Bowler',140000000,'India','CSK'),
	 ('KMAsif','Bowler',2000000,'India','CSK');
INSERT INTO player ("name","role",price,country,team) VALUES
	 ('TusharDeshpande','Bowler',2000000,'India','CSK'),
	 ('MaheeshTheekshana','Bowler',7000000,'Sri Lanka','CSK'),
	 ('SimranjeetSingh','Bowler',2000000,'India','CSK'),
	 ('AdamMilne','Bowler',19000000,'New Zealand','CSK'),
	 ('MukeshChoudhary','Bowler',2000000,'India','CSK'),
	 ('PrashantSolanki','Bowler',12000000,'India','CSK'),
	 ('MitchellSantner','Bowler',19000000,'New Zealand','CSK'),
	 ('RajvardhanHangargekar','Bowler',15000000,'India','CSK'),
	 ('RavindraJadeja','All-rounder',160000000,'India','CSK'),
	 ('MoeenAli','All-rounder',80000000,'England','CSK');
INSERT INTO player ("name","role",price,country,team) VALUES
	 ('DwayneBravo','All-rounder',44000000,'West Indies','CSK'),
	 ('ShivamDube','All-rounder',40000000,'India','CSK'),
	 ('DwainePretorius','All-rounder',5000000,'South Africa','CSK'),
	 ('BhagathVarma','All-rounder',2000000,'India','CSK'),
	 ('ChrisJordan','All-rounder',36000000,'England','CSK'),
	 ('MananVohra','Batsman',2000000,'India','LSG'),
	 ('EvinLewis','Batsman',20000000,'West Indies','LSG'),
	 ('ManishPandey','Batsman',46000000,'India','LSG'),
	 ('KLRahul','WK-Batsman',170000000,'India','LSG'),
	 ('QuintondeKock','WK-Batsman',67500000,'South Africa','LSG');
INSERT INTO player ("name","role",price,country,team) VALUES
	 ('RaviBishnoi','Bowler',40000000,'India','LSG'),
	 ('DushmanthaChameera','Bowler',20000000,'Sri Lanka','LSG'),
	 ('ShahbazNadeem','Bowler',5000000,'India','LSG'),
	 ('MohsinKhan','Bowler',2000000,'India','LSG'),
	 ('MayankYadav','Bowler',2000000,'India','LSG'),
	 ('AnkitRajpoot','Bowler',5000000,'India','LSG'),
	 ('AveshKhan','Bowler',100000000,'India','LSG'),
	 ('MarkWood','Bowler',75000000,'England','LSG'),
	 ('MarcusStoinis','All-rounder',92000000,'Australia','LSG'),
	 ('KyleMayers','All-rounder',5000000,'West Indies','LSG');
INSERT INTO player ("name","role",price,country,team) VALUES
	 ('KaranSharma','All-rounder',2000000,'India','LSG'),
	 ('KGowtham','All-rounder',9000000,'India','LSG'),
	 ('AyushBadoni','All-rounder',2000000,'India','LSG'),
	 ('DeepakHooda','All-rounder',57500000,'India','LSG'),
	 ('KrunalPandya','All-rounder',82500000,'India','LSG'),
	 ('JasonHolder','All-rounder',87500000,'West Indies','LSG'),
	 ('MayankAgarwal','Batsman',120000000,'India','PBKS'),
	 ('PrerakMankad','Batsman',2000000,'India','PBKS'),
	 ('BhanukaRajapaksa','Batsman',5000000,'Sri Lanka','PBKS'),
	 ('ShahrukhKhan','Batsman',90000000,'India','PBKS');
INSERT INTO player ("name","role",price,country,team) VALUES
	 ('ShikharDhawan','Batsman',82500000,'India','PBKS'),
	 ('PrabhsimranSingh','WK-Batsman',6000000,'India','PBKS'),
	 ('JiteshSharma','WK-Batsman',2000000,'India','PBKS'),
	 ('JonnyBairstow','WK-Batsman',67500000,'England','PBKS'),
	 ('ArshdeepSingh','Bowler',40000000,'India','PBKS'),
	 ('WrittickChatterjee','Bowler',2000000,'India','PBKS'),
	 ('OdeanSmith','Bowler',60000000,'West Indies','PBKS'),
	 ('SandeepSharma','Bowler',5000000,'India','PBKS'),
	 ('RajBawa','Bowler',20000000,'India','PBKS'),
	 ('NathanEllis','Bowler',7500000,'Australia','PBKS');
INSERT INTO player ("name","role",price,country,team) VALUES
	 ('VaibhavArora','Bowler',20000000,'India','PBKS'),
	 ('IshanPorel','Bowler',2500000,'India','PBKS'),
	 ('HarpreetBrar','Bowler',38000000,'India','PBKS'),
	 ('RahulChahar','Bowler',52500000,'India','PBKS'),
	 ('KagisoRabada','Bowler',92500000,'South Africa','PBKS'),
	 ('BennyHowell','All-rounder',4000000,'England','PBKS'),
	 ('BaltejSingh','All-rounder',2000000,'India','PBKS'),
	 ('AnshPatel','All-rounder',2000000,'India','PBKS'),
	 ('LiamLivingstone','All-rounder',115000000,'England','PBKS'),
	 ('RishiDhawan','All-rounder',5500000,'India','PBKS');
INSERT INTO player ("name","role",price,country,team) VALUES
	 ('AtharvaTaide','All-rounder',2000000,'India','PBKS'),
	 ('KaneWilliamson','Batsman',140000000,'New Zealand','SRH'),
	 ('AidenMarkram','Batsman',26000000,'South Africa','SRH'),
	 ('ShashankSingh','Batsman',2000000,'India','SRH'),
	 ('RSamarth','Batsman',2000000,'India','SRH'),
	 ('RahulTripathi','Batsman',85000000,'India','SRH'),
	 ('PriyamGarg','Batsman',2000000,'India','SRH'),
	 ('GlennPhillips','WK-Batsman',15000000,'New Zealand','SRH'),
	 ('VishnuVinod','WK-Batsman',5000000,'India','SRH'),
	 ('NicholasPooran','WK-Batsman',107500000,'West Indies','SRH');
INSERT INTO player ("name","role",price,country,team) VALUES
	 ('UmranMalik','Bowler',40000000,'India','SRH'),
	 ('SaurabhDubey','Bowler',2000000,'India','SRH'),
	 ('RomarioShepherd','Bowler',77500000,'West Indies','SRH'),
	 ('FazalHaqFarooqi','Bowler',5000000,'Afghanistan','SRH'),
	 ('JSuchith','Bowler',2000000,'India','SRH'),
	 ('ShreyasGopal','Bowler',7500000,'India','SRH'),
	 ('KartikTyagi','Bowler',40000000,'India','SRH'),
	 ('TNatarajan','Bowler',40000000,'India','SRH'),
	 ('BhuvneshwarKumar','Bowler',42000000,'India','SRH'),
	 ('AbdulSamad','All-rounder',40000000,'India','SRH');
INSERT INTO player ("name","role",price,country,team) VALUES
	 ('MarcoJansen','All-rounder',42000000,'South Africa','SRH'),
	 ('SeanAbbott','All-rounder',24000000,'Australia','SRH'),
	 ('AbhishekSharma','All-rounder',65000000,'India','SRH'),
	 ('WashingtonSundar','All-rounder',87500000,'India','SRH');
	 
select * from player;