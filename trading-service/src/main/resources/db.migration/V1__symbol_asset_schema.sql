DROP DATABASE IF EXISTS exchange_db;
CREATE DATABASE exchange_db;

-- keeps last known sequence that database is consistent to
-- CREATE TABLE exchange.global_state (
--     state_seq                 BIGINT NOT NULL
-- );

-- assets and currencies
CREATE TABLE exchange_db.asset (
   id                    BIGINT AUTO_INCREMENT,
   code                  VARCHAR(32) NOT NULL,
   name                  VARCHAR(64) NOT NULL,
   scale                 SMALLINT NOT NULL,
   state                 VARCHAR(100) NOT NULL,
   asset_state_seq       BIGINT NOT NULL,
   primary key (id)
);

-- symbols
CREATE TABLE exchange_db.symbol (
    id                   BIGINT AUTO_INCREMENT,
    code                 VARCHAR(32) NOT NULL,
    name                 VARCHAR(64) NOT NULL,
    type                 SMALLINT NOT NULL,
    base_asset_id        SMALLINT NOT NULL,
    quote_asset_id       SMALLINT NOT NULL,
    lot_size             DECIMAL(18,8) NOT NULL,
    step_size            DECIMAL(18,8) NOT NULL,
    taker_fee            DECIMAL(18,8) NOT NULL,
    maker_fee            DECIMAL(18,8) NOT NULL,
    margin_buy           DECIMAL(18,8) NOT NULL,
    price_high_limit     DECIMAL(18,8) NOT NULL,
    state                SMALLINT NOT NULL
    PRIMARY KEY (id)
);

