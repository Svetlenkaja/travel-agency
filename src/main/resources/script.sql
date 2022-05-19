CREATE DATABASE `travel_agency`;

CREATE TABLE `travel_agency`.`role` (
                        `ID` int NOT NULL AUTO_INCREMENT,
                        `NAME` varchar(100) NOT NULL,
                        PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `travel_agency`.`role` (
                        `ID` int NOT NULL AUTO_INCREMENT,
                        `NAME` varchar(100) NOT NULL,
                        PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('1', '1', 'Константы системы');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('1', '2', 'Роли пользователей');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('2', '1', 'Администратор');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('2', '2', 'Менеджер');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('2', '3', 'Клиент');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('1', '3', 'Типы туров');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('3', '1', 'Отдых');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('3', '2', 'Экскурссия');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('3', '3', 'Оздоровление');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('1', '4', 'Тип транспорта');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('4', '1', 'Самолет');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('4', '2', 'Поезд');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('4', '3', 'Автобус');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('4', '4', 'Лайнер');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('1', '5', 'Тип питания');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('5', '1', 'Room only');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('5', '2', 'Bed & breakfast');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('5', '3', 'Half board');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('5', '4', 'Full board');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('5', '5', 'All inclusive');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('5', '6', 'Ultra all inclusive');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('1', '6', 'Статус тура');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('6', '1', 'Активный');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('6', '2', 'Забронирован');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('6', '3', 'Оплачен');
INSERT INTO `travel_agency`.`classifier` (`type`, `code`, `name`) VALUES ('6', '4', 'Аннулирован');