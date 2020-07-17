CREATE TABLE currency_exchange(
    id INTEGER PRIMARY KEY,
    currency_code TEXT NOT NULL,
    currency_name TEXT NOT NULL,
    currency_symbol TEXT NOT NULL,
    rate FLOAT,
    date timestamp(2) /* parameter is the fractional seconds precision */
);

/*
I think Chris we should use about 10 currencies, now just inserting initial
 data, going from one currency to same currency
 update: Chris told us which currencies to use, so mmay need to revise
 also: the rate is the conversion to US dollar, rate is from input currency
 to US dollar
 */
INSERT INTO currency_exchange
    (id, currency_code, currency_name, currency_symbol,  rate, "date")
    VALUES ("1", "USD", "US DOLLAR", "$", 1.0, '2020-07-12 14:05:04.777');

INSERT INTO currency_exchange
    (id, currency_code, currency_name, currency_symbol, rate, "date")
    VALUES ("2", "EUR", "EURO", "€", 1.14, '2020-07-12 14:06:07.777');

INSERT INTO currency_exchange
    (id, currency_code, currency_name, currency_symbol, rate, "date")
    VALUES ("3", "JPY", "YEN", "¥", 1.0, '2020-07-12 17:43:09.777');

INSERT INTO currency_exchange
    (id, currency_code, currency_name, currency_symbol, rate, "date")
    VALUES ("4", "GBP", "POUND", "£", 1.26, '2020-07-12 17:44:10.777');

INSERT INTO currency_exchange
    (id, currency_code, currency_name, currency_symbol, rate, "date")
    VALUES ("5", "CAD", "CANADIAN DOLLAR", "$", 0.74, '2020-07-12 17:46:12.777');

INSERT INTO currency_exchange
    (id, currency_code, currency_name, currency_symbol, rate, "date")
    VALUES ("6", "AUD", "AUSTRALIAN DOLLAR", "$", 0.70, '2020-07-12 17:47:13.777');

INSERT INTO currency_exchange
    (id, currency_code, currency_name, currency_symbol, rate, "date")
    VALUES ("7", "PEN", "PERUVIAN SOL", "S/", 0.29, '2020-07-12 17:48:15.777');

INSERT INTO currency_exchange
    (id, currency_code, currency_name, currency_symbol, rate, "date")
    VALUES ("8", "MXN", "PESOS", "$", 0.045, '2020-07-12 17:49:15.777');


INSERT INTO currency_exchange
    (id, currency_code, currency_name, currency_symbol, rate, "date")
    VALUES ("9", "ZAR", "SOUTH AFRICAN RAND", "R", 0.060, '2020-07-12 17:50:15.777');


INSERT INTO currency_exchange
    (id, currency_code, currency_name, currency_symbol, rate, "date")
    VALUES ("10", "RUB", "RUSSIAN RUBLE", "₽", 0.014, '2020-07-12 17:51:15.777');

SELECT * FROM currency_exchange;
