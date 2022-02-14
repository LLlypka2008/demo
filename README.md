# demo
0.0.1 version
сервис состоит из 5 контроллеров
DefaultController - дефолтный конроллер с ссылкой для перехода к BuyerController
BuyerController - контроллер модели Buyer, модель сохраняется в файл TemporaryModelStorage
SellerController - контроллер модели Seller, модель  так-же сохраняется в файл TemporaryModelStorage
BidController - контроллер модели Bid, модель сохраняется в файл TemporaryModelStorage, после с помошью ConservationService сохраняется в БД
SuccesfullyController - контроллер для перехода к последней viev
у каждого контроллера свой viev
схема бд создается плагином flyway
тесты практически не сделаны. не успел разобраться с темой.
докер файл не сделан.
