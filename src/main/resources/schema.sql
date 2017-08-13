DROP TABLE IF EXISTS `stock`;
DROP TABLE IF EXISTS `trade`;
DROP TABLE IF EXISTS `account`;

CREATE TABLE IF NOT EXISTS `stock` (
    `symbol`        VARCHAR(50)     NOT NULL PRIMARY KEY,
    `value`         DECIMAL(65,2)   NOT NULL,
    `volume`        INT             NOT NULL
);

CREATE TABLE IF NOT EXISTS `account` (
    `username`      VARCHAR(50)     NOT NULL PRIMARY KEY,
    `credits`       DECIMAL(65,2)   NOT NULL
);

CREATE TABLE IF NOT EXISTS `account_stock` (
    `username`      VARCHAR(50)     NOT NULL,
    `stock_symbol`  VARCHAR(50)     NOT NULL,
    `volume`        INT             NOT NULL,

    PRIMARY KEY (username, stock_symbol)
);

CREATE TABLE IF NOT EXISTS `trade` (
    `trade_id`      BIGINT          NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `username`      VARCHAR(50)     NOT NULL,
    `stock_symbol`  VARCHAR(50)     NOT NULL,
    `volume`        INT             NOT NULL,
    `trade_type`    VARCHAR(50)     NOT NULL
);