USE [wallet_digital]
GO

/****** Object:  Table [dbo].[client]    Script Date: 4/9/2024 6:07:11 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[client](
    [document_number] [varchar](50) NOT NULL,
    [phone_number] [varchar](50) NOT NULL,
    [name] [varchar](50) NOT NULL,
    [email] [varchar](50) NOT NULL,
    [wallet_id] [uniqueidentifier] NOT NULL,
    CONSTRAINT [PK_client] PRIMARY KEY CLUSTERED
(
    [document_number] ASC,
[phone_number] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO

ALTER TABLE [dbo].[client]  WITH CHECK ADD  CONSTRAINT [FK_client_wallet1] FOREIGN KEY([wallet_id])
    REFERENCES [dbo].[wallet] ([id])
    GO

ALTER TABLE [dbo].[client] CHECK CONSTRAINT [FK_client_wallet1]
    GO


