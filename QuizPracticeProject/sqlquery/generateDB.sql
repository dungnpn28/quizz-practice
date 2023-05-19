create database Quiz_Practice
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
	modified datetime NOT NULL,
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
	status varchar(10) NOT NULL,
	description varchar NOT NULL,
  CONSTRAINT [PK_SUBJECT] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [price_package] (
	id integer identity(1,1) NOT NULL,
	duration time NOT NULL,
	price money NOT NULL,
	sale decimal NOT NULL,
	status varchar(10) NOT NULL,
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
	user_id integer NOT NULL,
	exam_id integer NOT NULL,
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
	id integer identity(1,1) NOT NULL,
	user_id integer NOT NULL,
	exam_id integer NOT NULL,
	score decimal NOT NULL,
	created datetime NOT NULL,
  CONSTRAINT [PK_RESULT] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [user_profile] (
	id integer identity(1,1) NOT NULL,
	user_id integer NOT NULL,
	avatar varchar(255),
	full_name nvarchar(255) NOT NULL,
	gender varchar(6) NOT NULL,
	dob date NOT NULL,
	phone_number varchar(20) NOT NULL,
	created datetime NOT NULL,
	modified datetime NOT NULL,
  CONSTRAINT [PK_USER_PROFILE] PRIMARY KEY CLUSTERED
  (
  [id] ASC
  ) WITH (IGNORE_DUP_KEY = OFF)

)
GO
CREATE TABLE [blog] (
	id integer identity(1,1) NOT NULL,
	thumbnail varchar(255) NOT NULL,
	author_id integer NOT NULL,
	title varchar(255) NOT NULL,
	category nvarchar(20) NOT NULL,
	flag nvarchar NOT NULL,
	[status] varchar(20) NOT NULL,
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
	title varchar NOT NULL,
	[image] varchar NOT NULL,
	backlink varchar NOT NULL,
	status varchar NOT NULL,
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
ALTER TABLE [user_profile] WITH CHECK ADD CONSTRAINT [user_fk1] FOREIGN KEY ([user_id]) REFERENCES [user]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [user] CHECK CONSTRAINT [user_fk1]
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
ALTER TABLE [exam] WITH CHECK ADD CONSTRAINT [exam_fk1] FOREIGN KEY ([exam_id]) REFERENCES [exam]([id])
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

ALTER TABLE [result] WITH CHECK ADD CONSTRAINT [result_fk0] FOREIGN KEY ([user_id]) REFERENCES [user]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [result] CHECK CONSTRAINT [result_fk0]
GO
ALTER TABLE [result] WITH CHECK ADD CONSTRAINT [result_fk1] FOREIGN KEY ([exam_id]) REFERENCES [exam]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [result] CHECK CONSTRAINT [result_fk1]
GO


ALTER TABLE [blog] WITH CHECK ADD CONSTRAINT [blog_fk0] FOREIGN KEY ([author_id]) REFERENCES [user]([id])
ON UPDATE CASCADE
GO
ALTER TABLE [blog] CHECK CONSTRAINT [blog_fk0]
GO


