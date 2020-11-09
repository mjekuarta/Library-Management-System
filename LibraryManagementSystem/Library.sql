USE [master]
GO

/****** Object:  Database [Library] ******/
CREATE DATABASE [Library]
USE [Library]
GO



/****** Object:  Table [dbo].[Personi]  ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Libri](
[LibriID] [int] IDENTITY(1,1) NOT NULL,
[TitulliLibrit] [varchar](150) NOT NULL,
[PunetoriID][int] null,
[AutoriID][int] null,
[KlientiID][int] null,
[KategoriaID][int] null,
[PublikuesiID][int] null,
[Path] [varchar] (150) NOT NULL,
 CONSTRAINT [PK_Libri] PRIMARY KEY CLUSTERED
(
[LibriID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY =
OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO





CREATE TABLE [dbo].[Kategoria](
[KategoriaID] [int] IDENTITY(1,1) NOT NULL,
[EmriKategorise] [varchar](150) NOT NULL,
[LibriID][int] null,
[AutoriID] [int] null,
 CONSTRAINT [PK_Kategoria] PRIMARY KEY CLUSTERED
(
[KategoriaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY =
OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO




CREATE TABLE [dbo].[Publikuesi](
[PublikuesiID] [int] IDENTITY(1,1) NOT NULL,
[EmriPublikuesit] [varchar](150) NOT NULL,
[AutoriID][int] null,
[LibriID] [int] null,
 CONSTRAINT [PK_Publikuesi] PRIMARY KEY CLUSTERED
(
[PublikuesiID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY =
OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO




CREATE TABLE [dbo].[Autori](
[AutoriID] [int] IDENTITY(1,1) NOT NULL,
[EmriAutorit] [varchar](150) NOT NULL,
[MbiemriAutorit] [varchar] (150) NOT NULL,
[LibriID] [int] null,
[PublikuesiID] [int] null,
[KategoriaID] [int] null,
 CONSTRAINT [PK_Autori] PRIMARY KEY CLUSTERED
(
[AutoriID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY =
OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Klienti](
[KlientiID] [int] IDENTITY(1,1) NOT NULL,
[EmriKlientit] [varchar](150) NOT NULL,
[NumriTelefonitKlientit] [int] NOT NULL,
[EmailiKlientit] [varchar] (150) NOT NULL,
[LibriID] [int] null,
[PunetoriID] [int] null,
[DataLindjes] [date] NOT NULL,

 CONSTRAINT [PK_Klienti] PRIMARY KEY CLUSTERED
(
[KlientiID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY =
OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO



INSERT [dbo].[Libri] ([TitulliLibrit]) VALUES (N'Lulet e veres')
INSERT [dbo].[Libri] ([TitulliLibrit]) VALUES (N'The Shining')
INSERT [dbo].[Libri] ([TitulliLibrit]) VALUES (N'1984')
INSERT [dbo].[Libri] ([TitulliLibrit]) VALUES (N'Algorithms and Data Structures')
INSERT [dbo].[Libri] ([TitulliLibrit]) VALUES (N'Tom Sawyer')
INSERT [dbo].[Libri] ([TitulliLibrit]) VALUES (N'Becoming')
INSERT [dbo].[Libri] ([TitulliLibrit]) VALUES (N'The Glass Hotel')
INSERT [dbo].[Libri] ([TitulliLibrit]) VALUES (N'Death in her hands')
INSERT [dbo].[Libri] ([TitulliLibrit]) VALUES (N'Untamed')
INSERT [dbo].[Libri] ([TitulliLibrit]) VALUES (N'Why we can not sleep')
INSERT [dbo].[Libri] ([TitulliLibrit]) VALUES (N'Perfect tunes')

SET IDENTITY_INSERT [dbo].[Libri] OFF


INSERT [dbo].[Kategoria] ([EmriKategorise])
VALUES (N'Komedi')
INSERT [dbo].[Kategoria] ([EmriKategorise])
VALUES (N'Biografi')
INSERT [dbo].[Kategoria] ([EmriKategorise])
VALUES (N'Horror')
INSERT [dbo].[Kategoria] ([EmriKategorise])
VALUES (N'Romance')
INSERT [dbo].[Kategoria] ([EmriKategorise])
VALUES (N'Politike')
INSERT [dbo].[Kategoria] ([EmriKategorise])
VALUES (N'Akademik')
INSERT [dbo].[Kategoria] ([EmriKategorise])
VALUES (N'Histori')
INSERT [dbo].[Kategoria] ([EmriKategorise])
VALUES (N'Shkence')
SET IDENTITY_INSERT [dbo].[Kategoria] OFF

INSERT [dbo].[Publikuesi] ([EmriPublikuesit]) VALUES (N'Wiley')
INSERT [dbo].[Publikuesi] ([EmriPublikuesit]) VALUES (N'Dukagjini')
INSERT [dbo].[Publikuesi] ([EmriPublikuesit]) VALUES (N'Pearson')
INSERT [dbo].[Publikuesi] ([EmriPublikuesit]) VALUES (N'Harper Collins')
INSERT [dbo].[Publikuesi] ([EmriPublikuesit]) VALUES (N'Macmillan')
INSERT [dbo].[Publikuesi] ([EmriPublikuesit]) VALUES (N'Simon and Schuster')
INSERT [dbo].[Publikuesi] ([EmriPublikuesit]) VALUES (N'Hachette')
INSERT [dbo].[Publikuesi] ([EmriPublikuesit]) VALUES (N'Random House')
SET IDENTITY_INSERT [dbo].[Publikuesi] OFF


INSERT [dbo].[Punetori] ([EmriPunetorit], [Passwordi],
[EmailiPunetorit]) VALUES (N'Arta', N'123456',
N'am44339@ubt-uni.net')
INSERT [dbo].[Punetori] ([EmriPunetorit], [Passwordi],
[EmailiPunetorit]) VALUES (N'Enes', N'enes123',
N'ep44660@ubt-uni.net')
INSERT [dbo].[Punetori] ([EmriPunetorit], [Passwordi],
[EmailiPunetorit]) VALUES (N'Shuajb', N'098765',
N'sq44635@ubt-uni.net')
INSERT [dbo].[Punetori] ([EmriPunetorit], [Passwordi],
[EmailiPunetorit]) VALUES (N'Era', N'era123',
N'era@gmail.com')
INSERT [dbo].[Punetori] ([EmriPunetorit], [Passwordi],
[EmailiPunetorit]) VALUES (N'Jon', N'jon125',
N'jon@gmail.com')
INSERT [dbo].[Punetori] ([EmriPunetorit], [Passwordi],
[EmailiPunetorit]) VALUES (N'Atlant', N'114455',
N'as@ubt-uni.net')
SET IDENTITY_INSERT [dbo].[Punetori] OFF

INSERT [dbo].[Autori] ([EmriAutorit], [MbiemriAutorit]
) VALUES (N'Sami', N'Frasheri')
INSERT [dbo].[Autori] ([EmriAutorit], [MbiemriAutorit]) VALUES (N'Haruki', N'Murakami')
INSERT [dbo].[Autori] ([EmriAutorit], [MbiemriAutorit]) VALUES (N'Stephen', N'King')
INSERT [dbo].[Autori] ([EmriAutorit], [MbiemriAutorit]) VALUES (N'Robert', N'Sedgewick')
INSERT [dbo].[Autori] ([EmriAutorit], [MbiemriAutorit]) VALUES (N'JK', N'Rowling')
INSERT [dbo].[Autori] ([EmriAutorit], [MbiemriAutorit]) VALUES (N'Virginia', N'Woolf')
INSERT [dbo].[Autori] ([EmriAutorit], [MbiemriAutorit]) VALUES (N'Irene', N'Adler')
INSERT [dbo].[Autori] ([EmriAutorit], [MbiemriAutorit]) VALUES (N'Ernest', N'Hemingway')
INSERT [dbo].[Autori] ([EmriAutorit], [MbiemriAutorit]) VALUES (N'Robert', N'Sedgewick')
INSERT [dbo].[Autori] ([EmriAutorit], [MbiemriAutorit]) VALUES (N'Pablo', N'Neruda')
INSERT [dbo].[Autori] ([EmriAutorit], [MbiemriAutorit]) VALUES (N'William', N'Shakespeare')
INSERT [dbo].[Autori] ([EmriAutorit], [MbiemriAutorit]) VALUES (N'Michelle', N'Obama')
INSERT [dbo].[Autori] ([EmriAutorit], [MbiemriAutorit]) VALUES (N'William', N'Faulkner')

SET IDENTITY_INSERT [dbo].[Autori] OFF


INSERT [dbo].[Klienti] ([EmriKlientit], [NumriTelefonitKlientit],
[EmailiKlientit],  [PunetoriID], [DataLindjes]) VALUES (N'Vesa', 1598564, N'vesa.morina@ubt-uni.net',
null, CAST(N'1995-07-03' AS Date))
INSERT [dbo].[Klienti] ([EmriKlientit], [NumriTelefonitKlientit],
[EmailiKlientit],  [PunetoriID], [DataLindjes]) VALUES (N'Blerim', 1738423, N'blerim.zylfiu@ubt-uni.net',
null, CAST(N'1998-05-01' AS Date))
INSERT [dbo].[Klienti] ([EmriKlientit], [NumriTelefonitKlientit],
[EmailiKlientit],  [PunetoriID], [DataLindjes]) VALUES (N'Lavdim', 1329474, N'lavdim.menxhiqi@ubt-uni.net',
null, CAST(N'1997-04-05' AS Date))
INSERT [dbo].[Klienti] ([EmriKlientit], [NumriTelefonitKlientit],
[EmailiKlientit],  [PunetoriID], [DataLindjes]) VALUES (N'Medina', 1145687, N'medina.shamolli@ubt-uni.net',
null, CAST(N'1997-04-05' AS Date))
INSERT [dbo].[Klienti] ([EmriKlientit], [NumriTelefonitKlientit],
[EmailiKlientit],  [PunetoriID], [DataLindjes]) VALUES (N'Valdrin', 1236457, N'valdrin.haxhiu@ubt-uni.net',
null, CAST(N'1997-04-05' AS Date))
INSERT [dbo].[Klienti] ([EmriKlientit], [NumriTelefonitKlientit],
[EmailiKlientit],  [PunetoriID], [DataLindjes]) VALUES (N'Betim', 1145698, N'betim.gashi@ubt-uni.net',
null, CAST(N'1997-04-05' AS Date))
SET IDENTITY_INSERT [dbo].[Klienti] OFF


ALTER TABLE [dbo].[Libri]  WITH CHECK ADD  CONSTRAINT
[FK_Publikuesi_Libri] FOREIGN KEY([PublikuesiID])
REFERENCES [dbo].[Publikuesi] ([PublikuesiID])
GO
ALTER TABLE [dbo].[Libri] CHECK CONSTRAINT [FK_Publikuesi_Libri]
GO

-----------------libri-----------------------
ALTER TABLE [dbo].[Libri]  WITH CHECK ADD  CONSTRAINT
[FK_Klienti_Libri] FOREIGN KEY([KlientiID])
REFERENCES [dbo].[Klienti] ([KlientiID])
GO
ALTER TABLE [dbo].[Libri] CHECK CONSTRAINT [FK_Klienti_Libri]
GO

ALTER TABLE [dbo].[Libri]  WITH CHECK ADD  CONSTRAINT
[FK_Punetori_Libri] FOREIGN KEY([PunetoriID])
REFERENCES [dbo].[Punetori] ([PunetoriID])
GO
ALTER TABLE [dbo].[Libri] CHECK CONSTRAINT [FK_Punetori_Libri]
GO


-----------------libri---------------------------------------------------------------------------------------------------------------------
ALTER TABLE [dbo].[Libri]  WITH CHECK ADD  CONSTRAINT
[FK_Autori_Libri] FOREIGN KEY([AutoriID])
REFERENCES [dbo].[Autori] ([AutoriID])
GO
ALTER TABLE [dbo].[Libri] CHECK CONSTRAINT [FK_Autori_Libri]
GO


ALTER TABLE [dbo].[Kategoria]  WITH CHECK ADD  CONSTRAINT
[FK_Autori_Kategoria] FOREIGN KEY([AutoriID])
REFERENCES [dbo].[Autori] ([AutoriID])
GO
ALTER TABLE [dbo].[Kategoria] CHECK CONSTRAINT [FK_Autori_Kategoria]
GO





-------------------------- kategoria autori------------------------
ALTER TABLE [dbo].[Klienti]  WITH CHECK ADD  CONSTRAINT
[FK_Punetori_Klienti] FOREIGN KEY([PunetoriID])
REFERENCES [dbo].[Punetori] ([PunetoriID])
GO
ALTER TABLE [dbo].[Klienti] CHECK CONSTRAINT [FK_Punetori_Klienti]
GO





------------------------------------------------------------

ALTER TABLE [dbo].[Autori]  WITH CHECK ADD  CONSTRAINT
[FK_Publikuesi_Autori] FOREIGN KEY([PublikuesiID])
REFERENCES [dbo].[Publikuesi] ([PublikuesiID])
GO
ALTER TABLE [dbo].[Autori] CHECK CONSTRAINT [FK_Publikuesi_Autori]
GO

---------------------------------------------------------------------------------------
USE Library

CREATE TABLE [dbo].[Punetori](
[PunetoriID] [int] IDENTITY(1,1) NOT NULL,
[EmriPunetorit] [varchar](150) NOT NULL,
[Passwordi] [varchar] (60) NOT NULL,
[EmailiPunetorit] [varchar] (150) NOT NULL,
[LibriID] [int] null,
[KlientiID] [int] null,


 CONSTRAINT [PK_Punetori] PRIMARY KEY CLUSTERED
(
[PunetoriID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY =
OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO



CREATE TABLE [dbo].[Perdoruesi](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [varchar](50) NULL,
	[Password] [varchar](550) NULL,
	[RoliID] [int] NULL,
 CONSTRAINT [PK_Perdoruesi] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Roli](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Emertimi] [varchar](50) NULL,
 CONSTRAINT [PK_Roli] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

INSERT [dbo].[Perdoruesi] ([Username], [Password], [RoliID]) VALUES (N'arta.mjeku', N'123456', 1)
INSERT [dbo].[Perdoruesi] ([Username], [Password], [RoliID]) VALUES (N'enes.pireva', N'1122233', 1)
INSERT [dbo].[Perdoruesi] ([Username], [Password], [RoliID]) VALUES (N'shuajb.qerimi', N'098765', 2)
INSERT [dbo].[Perdoruesi] ([Username], [Password], [RoliID]) VALUES (N'user', N'user', 2)
INSERT [dbo].[Perdoruesi] ([Username], [Password], [RoliID]) VALUES (N'am44339', N'123456', 1)

INSERT [dbo].[Roli] ([Emertimi]) VALUES (N'Admini')
INSERT [dbo].[Roli] ([Emertimi]) VALUES (N'Useri')

ALTER TABLE [dbo].[Perdoruesi]  WITH CHECK ADD  CONSTRAINT [FK_Perdoruesi_Roli] FOREIGN KEY([RoliID])
REFERENCES [dbo].[Roli] ([ID])
GO
ALTER TABLE [dbo].[Perdoruesi] CHECK CONSTRAINT [FK_Perdoruesi_Roli]
GO

