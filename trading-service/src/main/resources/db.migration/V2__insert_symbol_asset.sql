INSERT INTO exchange_db.asset (code, name, scale, state) VALUES ('XBTC', '비트코인', 8, 'ACTIVE');
INSERT INTO exchange_db.asset (code, name, scale, state) VALUES ('USDT', 'USD테더', 2, 'ACTIVE');

INSERT INTO exchange_db.symbol (code, name, type, base_asset_id, quote_asset_id, lot_size, step_size, taker_fee, maker_fee, margin_buy,
                                price_high_limit, state, state_seq)
VALUES ('XBTC_USDT', 'XBTC/USDT', 'CURRENCY_EXCHANGE_PAIR', 1, 2, 0.1, 0.01, 0.08, 0.03, 0, 0, 'ACTIVE');
