﻿create database Quiz_Practice
GO
use Quiz_Practice
GO

CREATE TABLE [user] (
	id integer identity(1,1) NOT NULL,
	account varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	role_id integer NOT NULL,
  CONSTRAINT [PK_USER] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [role] (
	id integer identity(1,1) NOT NULL,
	name varchar(10) NOT NULL,
	created datetime NOT NULL,
  CONSTRAINT [PK_ROLE] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [dimension] (
	id integer identity(1,1) NOT NULL,
	name varchar(20) NOT NULL,
	type varchar(20) NOT NULL,
	description text NOT NULL,
  CONSTRAINT [PK_DIMENSION] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [subject] (
	id integer identity(1,1) NOT NULL,
	dimension_id integer NOT NULL,
	name varchar(20) NOT NULL,
	category varchar(20) NOT NULL,
	status bit NOT NULL,
	description text NOT NULL,
  CONSTRAINT [PK_SUBJECT] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [price_package] (
	id integer identity(1,1) NOT NULL,
	duration integer NOT NULL,
	price money NOT NULL,
	sale decimal NOT NULL,
	status bit NOT NULL,
  CONSTRAINT [PK_PRICE_PACKAGE] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [registration] (
	id integer identity(1,1) NOT NULL,
	subject_id integer NOT NULL,
	price_package_id integer NOT NULL,
	user_id integer NOT NULL,
	created datetime NOT NULL,
  CONSTRAINT [PK_REGISTRATION] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [exam] (
	id integer identity(1,1) NOT NULL,
	name varchar(255) NOT NULL,
	subject_id integer NOT NULL,
	user_id integer NOT NULL,
	[level] varchar NOT NULL,
	duration time NOT NULL,
	pass_rate decimal NOT NULL,
	number_of_question integer NOT NULL,
	created datetime NOT NULL,
  CONSTRAINT [PK_EXAM] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [lesson] (
	id integer identity(1,1) NOT NULL,
	subject_id integer NOT NULL,
	name varchar(20) NOT NULL,
	type varchar(20) NOT NULL,
	topic varchar(20) NOT NULL,
  CONSTRAINT [PK_LESSON] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [question] (
	id integer identity(1,1) NOT NULL,
	subject_id integer NOT NULL,
	content text NOT NULL,
	option_a varchar(255) NOT NULL,
	option_b varchar(255) NOT NULL,
	option_c varchar(255) NOT NULL,
	option_d varchar(255) NOT NULL,
	answer varchar(255) NOT NULL,
	created datetime NOT NULL,
	modified datetime NOT NULL,
  CONSTRAINT [PK_QUESTION] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [result] (
	exam_id integer NOT NULL,
	score decimal NOT NULL,
	created datetime NOT NULL,
  CONSTRAINT [PK_RESULT] PRIMARY KEY CLUSTERED
  (
  [exam_id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [user_profile] (
	user_id integer NOT NULL,
	avatar varchar(255),
	full_name nvarchar(255) NOT NULL,
	gender bit NOT NULL,
	dob date NOT NULL,
	phone_number varchar(20) NOT NULL,
	created datetime NOT NULL,
	modified datetime NOT NULL,
  CONSTRAINT [PK_USER_PROFILE] PRIMARY KEY CLUSTERED
  (
  [user_id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [blog] (
	id integer identity(1,1) NOT NULL,
	thumbnail varchar(255) NOT NULL,
	author_id integer NOT NULL,
	title varchar(255) NOT NULL,
	category varchar(20) NOT NULL,
	flag varchar(255),
	[status] bit NOT NULL,
	content text NOT NULL,
	created datetime NOT NULL,
	modified datetime NOT NULL,
  CONSTRAINT [PK_BLOG] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [slider] (
	id integer identity(1,1) NOT NULL,
	publisher_id integer NOT NULL,
	title varchar(255) NOT NULL,
	[image] varchar(255) NOT NULL,
	backlink varchar(255) NOT NULL,
	status bit NOT NULL,
  CONSTRAINT [PK_SLIDER] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF),
  FOREIGN KEY(publisher_id) REFERENCES [user](id),
)
GO
ALTER TABLE [user] WITH CHECK ADD CONSTRAINT [user_fk0] FOREIGN KEY ([role_id]) REFERENCES [role]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [user] CHECK CONSTRAINT [user_fk0]
GO
ALTER TABLE [user_profile] WITH CHECK ADD CONSTRAINT [user_profile_fk0] FOREIGN KEY ([user_id]) REFERENCES [user]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [user_profile] CHECK CONSTRAINT [user_profile_fk0]
GO



ALTER TABLE [subject] WITH CHECK ADD CONSTRAINT [subject_fk0] FOREIGN KEY ([dimension_id]) REFERENCES [dimension]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [subject] CHECK CONSTRAINT [subject_fk0]
GO


ALTER TABLE [registration] WITH CHECK ADD CONSTRAINT [registration_fk0] FOREIGN KEY ([subject_id]) REFERENCES [subject]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [registration] CHECK CONSTRAINT [registration_fk0]
GO
ALTER TABLE [registration] WITH CHECK ADD CONSTRAINT [registration_fk1] FOREIGN KEY ([price_package_id]) REFERENCES [price_package]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [registration] CHECK CONSTRAINT [registration_fk1]
GO
ALTER TABLE [registration] WITH CHECK ADD CONSTRAINT [registration_fk2] FOREIGN KEY ([user_id]) REFERENCES [user]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [registration] CHECK CONSTRAINT [registration_fk2]
GO

ALTER TABLE [exam] WITH CHECK ADD CONSTRAINT [exam_fk0] FOREIGN KEY ([user_id]) REFERENCES [user]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [exam] CHECK CONSTRAINT [exam_fk0]
GO

ALTER TABLE [exam] WITH CHECK ADD CONSTRAINT [exam_fk1] FOREIGN KEY ([subject_id]) REFERENCES [subject]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [exam] CHECK CONSTRAINT [exam_fk1]
GO

ALTER TABLE [lesson] WITH CHECK ADD CONSTRAINT [lesson_fk0] FOREIGN KEY ([subject_id]) REFERENCES [subject]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [lesson] CHECK CONSTRAINT [lesson_fk0]
GO

ALTER TABLE [question] WITH CHECK ADD CONSTRAINT [question_fk0] FOREIGN KEY ([subject_id]) REFERENCES [subject]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [question] CHECK CONSTRAINT [question_fk0]
GO

ALTER TABLE [result] WITH CHECK ADD CONSTRAINT [result_fk0] FOREIGN KEY ([exam_id]) REFERENCES [exam]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [result] CHECK CONSTRAINT [result_fk0]
GO


ALTER TABLE [blog] WITH CHECK ADD CONSTRAINT [blog_fk0] FOREIGN KEY ([author_id]) REFERENCES [user]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [blog] CHECK CONSTRAINT [blog_fk0]
GO


INSERT INTO role(name, created)
VALUES ('Guest', GETDATE()),
	   ('Customer', GETDATE()),
	   ('Marketing', GETDATE()),
       ('Sale', GETDATE()),
       ('Expert', GETDATE()),
       ('Admin', GETDATE()); 
GO

INSERT INTO [user](account, password, role_id)
VALUES ('dungnpnhe171417@fpt.edu.vn', 123, 2),
	   ('dungnpn28@gmail.com', 123, 4),
	   ('namdungnty@gmail.com', 123, 6),
       ('nguyenminhdai203@gmail.com', 123, 5),
       ('vuhieu2003hp@gmail.com', 123, 3),
       ('builanviet@gmail.com', 123, 6);

GO

INSERT INTO [user_profile]([user_id], full_name, gender, dob, phone_number, created, modified)
VALUES (1, 'Nguyễn Phạm Nam Dũng', '1', '2003-10-28', '0375470304' , GETDATE() , GETDATE()),
	   (2, 'Nguyễn Thị Dũng', '0', '1989-10-03', '0434574455' , GETDATE() , GETDATE()),
	   (3, 'Phạm Thị Thoại', '1', '1999-09-22', '0999999999' , GETDATE() , GETDATE()),
	   (4, 'Nguyễn Minh Đại', '1', '2001-09-08', '0111111111' , GETDATE() , GETDATE()),
	   (5, 'Vũ Ngọc Hiếu', '1', '2004-01-01', '0111111112' , GETDATE() , GETDATE()),
       (6, 'Bùi Lân Việt', '0', '2003-08-11', '06473835648' , GETDATE() , GETDATE());

GO

INSERT INTO [dimension]([name], [type], description)
VALUES ('Math', 'Subject', 'Mathematics is the study of numbers, shapes and patterns. The word comes from the Greek word "μάθημα" (máthema), meaning "science, knowledge, or learning", and is sometimes shortened to maths (in England, Australia, Ireland, and New Zealand) or math (in the United States and Canada). The short words are often used for arithmetic, geometry or simple algebra by students and their schools. Math can be studied at college and university. Students in many countries study almost the same subjects in high school. Some subjects, like calculus, have been invented because people needed them for more advanced subjects. Other subjects were part of the science of mathematics for hundreds of years but became important during the 1900s. These include statistics, computer science and mathematical physics. Some people study math because it is their hobby. Other people need math for their work, as part of another subject.'),
	   ('Physics', 'Subject', 'Physics is the study of matter and energy and how they interact with each other. Physics tries to answer main questions which include how did the universe begin? How will the universe change in the future? How does the Sun keep on shining? What are matter and energy made of?'),
	   ('Chemistry', 'Subject', 'Chemistry is the study of matter and the changes it undergoes. Here you can browse chemistry videos, articles, and exercises by topic. We keep the library up-to-date, so you may find new or improved material here over time.'),
       ('Biology', 'Subject', 'Biology is the study of life. It is concerned with studying microbes, classifying organisms and investigating different species and their interactions with each other and the natural environment. Biology is a broad subject that can be subdivided into many different topics, giving students a large choice of concentration areas.'),
       ('English', 'Subject', 'English is a West Germanic language first spoken in early medieval England which eventually became the leading language of international discourse in today is world. It is named after the Angles, one of the ancient Germanic peoples that migrated to the area of Great Britain that later took their name, England. Both names derive from Anglia, a peninsula on the Baltic Sea. English is most closely related to Frisian and Low Saxon, while its vocabulary has been significantly influenced by other Germanic languages, particularly Old Norse (a North Germanic language), as well as Latin and French.');

GO

INSERT INTO [subject](dimension_id, [name], category, [status], [description])
VALUES(1, 'C#', 'Programming', '1', 'C# is a general-purpose, multi-paradigm programming language encompassing strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented (class-based), and component-oriented programming disciplines.'),
	  (2, 'Java', 'Programming', '1', 'Java is a general-purpose computer-programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible.'),
      (3, 'Python', 'Programming', '1', 'Python is an interpreted, high-level, general-purpose programming language. Created by Guido van Rossum and first released in 1991, Python has a design philosophy that emphasizes code readability, notably using significant whitespace.'),
      (4, 'C++', 'Programming', '1', 'C++ is a general-purpose programming language created by Bjarne Stroustrup as an extension of the C programming language, or "C with Classes".'),
      (5, 'C', 'Programming', '1', 'C is a general-purpose, procedural computer programming language supporting structured programming, lexical variable scope, and recursion, with a static type system. By design, C provides constructs that map efficiently to typical machine instructions, and has found lasting use in applications previously coded in assembly language.');

GO
INSERT INTO [question](subject_id, content, option_a, option_b, option_c, option_d, answer, created, modified)
VALUES (1, 'What is the capital of Vietnam?', 'Ha Noi', 'Ho Chi Minh', 'Da Nang', 'Hai Phong', 'Ha Noi', GETDATE(), GETDATE()),
	   (2, 'What is the capital of USA?', 'New York', 'Washington DC', 'Los Angeles', 'Chicago', 'Washington DC', GETDATE(), GETDATE()),
	   (3, 'What is the capital of Japan?', 'Tokyo', 'Osaka', 'Kyoto', 'Yokohama', 'Tokyo', GETDATE(), GETDATE()),
	   (4, 'What is the capital of China?', 'Beijing', 'Shanghai', 'Hong Kong', 'Shenzhen', 'Beijing', GETDATE(), GETDATE()),
	   (5, 'What is the capital of Thailand?', 'Bangkok', 'Phuket', 'Pattaya', 'Chiang Mai', 'Bangkok', GETDATE(), GETDATE());
GO
INSERT INTO price_package (duration, price, sale, status)
VALUES ('1', 100000, 0, '1'),
	   ('7', 200000, 0.4, '0'),
	   ('30', 300000, 0, '1'),
	   ('90', 400000, 0, '1'),
	   ('360', 500000, 0, '1')
GO
INSERT INTO registration (subject_id, price_package_id, user_id, created) 
VALUES (1, 1, 1, GETDATE()), 
	   (2, 2, 2, GETDATE()), 
	   (3, 3, 3, GETDATE()), 
	   (4, 4, 4, GETDATE()), 
	   (5, 5, 5, GETDATE());
GO
INSERT INTO lesson (subject_id, name, type, topic)
VALUES (1, 'Lesson 1', 'Video', 'Topic 1'),
	   (2, 'Lesson 2', 'Video', 'Topic 2'),
	   (3, 'Lesson 3', 'Video', 'Topic 3'),
	   (4, 'Lesson 4', 'Video', 'Topic 4'), 
	   (5, 'Lesson 5', 'Video', 'Topic 5');


INSERT INTO blog (thumbnail, author_id, title, category, flag, [status], content, created, modified)
VALUES ('https://assets.bizclikmedia.net/900/936356725b9d4aa5c02cec9f3dcb2b2c:f40875c49b56bb5c6c82f9bd80564ced/gettyimages-1399581170.webp',1, 'What’s next for the metaverse?', 'IT', 'T', 1, 'Partha Ghosh, Head of Consulting at Infosys, explores how businesses are still intrigued by the potential of the metaverse across multiple industries
There has been much hype about metaverse in the last few years. So much so that metaverse technologies featured in Gartner’s 2022 Hype Cycle. To be sure, this was with a 10-year outlook.

Admittedly, metaverse is still at a nascent stage. For one, metaverse doesn’t exist as a single entity like, say, the Internet. Today, metaverse comprises a series of multiple emerging technologies. This makes it difficult for businesses to identify the viability of investments and understand the challenges that come with adoption. Some believe the Metaverse bubble has burst; or at-least the excitement has diminished. Indeed, search traffic for the word ‘Metaverse’ has significantly decreased since last year. 

Even with the ‘conditions apply’ caveat in its Hype Cycle, Gartner acknowledges that metaverse technologies provide innovative opportunities for businesses. According to the analyst, at least 25 per cent of people are predicted to spend at least an hour daily in a metaverse for either entertainment or work.

Understanding the potential before embracing metaverse
There are several current and potential use cases to seek inspiration from. While it appears that the metaverse lends itself to industries such as fashion, beauty, travel, or gaming, nothing could be further from the truth. The metaverse promises to bring together technologies to create a virtual environment that can help companies achieve efficiency and intelligence while working remotely. 

The metaverse is already transforming traditional processes in manufacturing, and corporate/employee training. For instance, BMW has leveraged Nvidia, to replicate its factory building, assembly equipment and also employees. Physically devices or machines can be put under different stress conditions by creating their digital twins. This virtual metaverse makes it possible for companies to reduce planning times and improve flexibility and precision.

Metaverse is all about immersive experiences powered by experiential technology. How we apply its capabilities is a play of our creativity and imagination. By 2024, there are predictions of over 34 million VR headsets installed around the world, potentially meaning that even public companies and government organizations might begin to implement VR headsets into their services, so you can expect to see them installed in numerous places.

Gaming platforms such as Roblox offering metaverse elements are highly popular among gamers. Today, it enjoys 214.10 million monthly active users as of February 2023. Clarks, the footwear giant, has made its first entrance into the metaverse to offer an immersive experience, the Cicaverse experience that celebrates its unisex sneaker style, the Cica.

Last summer, conjoined twins in Brazil were separated with the help of virtual reality. The digital map of the twins’ shared cranium made it possible for medical teams in Britain and Brazil to rehearse for the procedure from their own countries through VR before executing it on ground. Surgeries like these have paved the way for metaverse technologies to make a difference in healthcare.

Beyond the corporate world, metaverse can also help farmers test out different harvesting strategies and monitor crop growth and yield. Using precision agriculture on a metaverse platform can potentially help farmers make better decisions on planting and harvesting.

Similarly, real estate in the metaverse has been on the rise. According to a research report, the global demand for metaverse real estate is expected to reach $3,600 million in 2025, up from $358 million in 2020. Metaverse real estate has also ushered in a new era of ecommerce with fashion brands such as Nike and Gucci investing in virtual spaces.

Creating an effective Metaverse strategy
Metaverse strategy will vary from industry to industry. What works for manufacturing will not work for fashion, obviously. It is therefore crucial to find a partner who isn’t just technically sound but also brings in domain expertise. 

On one hand, even governments are jumping onto the metaverse bandwagon but there is cautious optimism on the outlook and strategies.  

The government of UAE has published a Dubai Metaverse Strategy to turn Dubai into one of the world’s top 10 metaverse economies as well as a global hub for the metaverse community. The European Commission is seeking feedback on its proposals to develop rules to manage virtual worlds and has called for more regulatory scrutiny of the metaverse, to mitigate the risk of having a small number of big players becoming future gatekeepers of virtual worlds.

The calculated approach will not just help businesses address challenges such as cybersecurity in metaverse, but also bring in fresh perspective on what the business can do for its customers in the metaverse.

When businesses partner with experienced enterprise integrators and software firms that themselves maintain partnerships with major metaverse, Web3, and hyperscaler services, they can gain confidence in the ability to develop and deploy dependable, secure, and scalable metaverse solutions.

Partha Ghosh heads consulting across Europe for Digital Experience at Infosys and is based out of London. He has nearly three decades of experience across Online and Omni-channel Commerce, Retail, Banking domains and BPM and Enterprise Application Integration; delivering mission-critical business outcomes.  

Partha is passionate about business and technology innovations and building high performance organizations and teams, having worked extensively in core product development and global consulting organizations. He has been a Business and Solution Advisor to multiple global System Integrators and retailers in the omni-channel commerce space. ', GETDATE(), GETDATE())
;

	select full_name from [user_profile] where user_id = 13;

	
USE master;
GO
ALTER DATABASE Quiz_Practice 
SET SINGLE_USER 
WITH ROLLBACK IMMEDIATE;
GO
DROP DATABASE Quiz_Practice;

select id from [user] where account = 'argentorium@gmail.com'

insert into [user_profile] values(15,NULL,'Thinh','1','1999-10-10','0764871490',GETDATE(),GETDATE());