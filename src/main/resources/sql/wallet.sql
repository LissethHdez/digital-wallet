USE [wallet_digital]
GO

/****** Object:  Table [dbo].[wallet]    Script Date: 4/9/2024 6:08:14 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[wallet](
    [id] [uniqueidentifier] NOT NULL,
    [current_value] [decimal](12, 2) NOT NULL,
    CONSTRAINT [PK_wallet] PRIMARY KEY CLUSTERED
(
[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]
    GO

ALTER TABLE [dbo].[wallet] ADD  CONSTRAINT [DF_wallet_id]  DEFAULT (newid()) FOR [id]
    GO

ALTER TABLE [dbo].[wallet] ADD  CONSTRAINT [DF_wallet_current_value]  DEFAULT ((0.00)) FOR [current_value]
    GO


