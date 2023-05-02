# Trading Service
거래 서비스

## 주문 플로우
1. Symbol 생성
  - symbol이란 거래 종목을 의미
  - symbol 생성 이후부터 orderbook 조회 가능
2. 유저 생성
3. 유저의 잔액 추가
4. 주문
  - bid : 매수
  - ask : 매도

## 매수/매도 시나리오
1. 유저1 - 1000에 2개 매수
```json
{
"userId" : "1",
"price" : "1000",
"size" : "2",
"action" : "BID",
"orderType" : "GTC",
"symbol" : "DOLLAR_XBT"
}
```
- 유저 1이 가진 XBT가 2000이 빠짐
- 달러 : 100000, 비트 : 98000

2. 유저2 - 1100에 3개 매도
```json
{
"userId" : "2",
"price" : "1100",
"size" : "3",
"action" : "ASK",
"orderType" : "GTC",
"symbol" : "DOLLAR_XBT"
}
```
- 유저 2가 가진 DOLLAR가 300이 빠짐
달러 : 499700, 비트 : 200000

3. 유저1 - 1100에 2개 매수
```json
{
"userId" : "1",
"price" : "1100",
"size" : "2",
"action" : "BID",
"orderType" : "GTC",
"symbol" : "DOLLAR_XBT"
}
```
- 주문 체결
  - 유저2 - 달러 : 499700, 비트 : 202200
  - 유저1 - 달러 : 100200, 비트 : 95800
- 주문이 체결되면 매수자에겐 달러가, 매도자에겐 비트가 들어감