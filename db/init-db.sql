-- Delete all tables
DROP TABLE IF EXISTS menu CASCADE;
DROP TABLE IF EXISTS dish_type CASCADE;
DROP TABLE IF EXISTS menu_details CASCADE;
DROP TABLE IF EXISTS image CASCADE;
DROP TABLE IF EXISTS client CASCADE;
DROP TABLE IF EXISTS request CASCADE; 
DROP TABLE IF EXISTS request_details CASCADE;
DROP TABLE IF EXISTS request_group CASCADE;
DROP TABLE IF EXISTS notification CASCADE;
DROP TABLE IF EXISTS operation CASCADE;
DROP TABLE IF EXISTS transaction CASCADE;
DROP VIEW IF EXISTS ext_request_view CASCADE;
DROP VIEW IF EXISTS ext_group_request_view CASCADE;

-- Delete sequences
DROP SEQUENCE IF EXISTS request_group_seq;
DROP SEQUENCE IF EXISTS notification_seq;
DROP SEQUENCE IF EXISTS menu_seq;
DROP SEQUENCE IF EXISTS menu_details_seq;
DROP SEQUENCE IF EXISTS image_seq;
DROP SEQUENCE IF EXISTS transaction_seq;
DROP SEQUENCE IF EXISTS request_seq;
DROP SEQUENCE IF EXISTS request_details_seq;
DROP SEQUENCE IF EXISTS operation_seq;

-- Create tables
CREATE TABLE menu (
  id              numeric       primary key,
  name            varchar(70)  NOT NULL,
  status          numeric(1,0)  NOT NULL,
  create_date     timestamp     NOT NULL,
  menu_on_date    timestamp     NOT NULL,
  reception_from  timestamp     NOT NULL,
  reception_to    timestamp     NOT NULL,
  delivery_from   timestamp     NOT NULL,
  delivery_to     timestamp     NOT NULL,
  CHECK (status in (0,1,2,3))
);
COMMENT ON TABLE menu IS 'Таблица для хранения меню';
COMMENT ON COLUMN menu.name IS 'Название меню';
COMMENT ON COLUMN menu.status IS 'Состояние меню: 0-черновик, 1-опубликовано, 2-заблокировано, 3-удалено';
COMMENT ON COLUMN menu.create_date IS 'Дата создания меню меню';
COMMENT ON COLUMN menu.menu_on_date IS 'Дата, на которую действительно меню';
COMMENT ON COLUMN menu.reception_from IS 'Дата начала приёма заказов';
COMMENT ON COLUMN menu.reception_to IS 'Дата окончания приёма заказов';
COMMENT ON COLUMN menu.delivery_from IS 'Дата начала доставки заказов';
COMMENT ON COLUMN menu.delivery_to IS 'Дата окончания доставки заказов';

CREATE TABLE dish_type (
  id    numeric       primary key,
  text  varchar(50)  NOT NULL
);
COMMENT ON TABLE dish_type IS 'Таблица для хранения типов блюд';
COMMENT ON COLUMN dish_type.text IS 'Тип блюда';
INSERT INTO dish_type (id, text) VALUES (0, 'Первые блюда');
INSERT INTO dish_type (id, text) VALUES (1, 'Вторые блюда');
INSERT INTO dish_type (id, text) VALUES (2, 'Салаты');
INSERT INTO dish_type (id, text) VALUES (3, 'Десерты');
INSERT INTO dish_type (id, text) VALUES (4, 'Напитки');
INSERT INTO dish_type (id, text) VALUES (5, 'Разное');

CREATE TABLE image (
	id              numeric    primary key,
	create_date     timestamp  NOT NULL,
	content         bytea      NOT NULL      
);
COMMENT ON TABLE image IS 'Таблица для хранения изображений';
COMMENT ON COLUMN image.content IS 'Картинка - изображение блюда';
COMMENT ON COLUMN image.create_date IS 'Дата записи изображения в БД';

CREATE TABLE menu_details (
  id              numeric          primary key,
  menu_id         numeric          NOT NULL,
  alive           boolean          NOT NULL  default TRUE,
  chief_choice    boolean          NOT NULL  default FALSE,
  dish_type_id    numeric          NOT NULL,
  dish_name       varchar(50)     NOT NULL,
  price           numeric(10,2)    NOT NULL,
  weight          numeric(4,0)     NOT NULL,
  max_count       numeric(3,0)     NOT NULL,
  structure       varchar(250)     NOT NULL,
  image_id        numeric				   ,		  	
  url             varchar(1024)    ,
  CONSTRAINT fk_menu_details_menu FOREIGN KEY (menu_id) REFERENCES menu (id),   
  CONSTRAINT fk_menu_details_image FOREIGN KEY (image_id) REFERENCES image (id),
  CONSTRAINT fk_menu_details_dish_type FOREIGN KEY (dish_type_id) REFERENCES dish_type (id)
);
COMMENT ON TABLE menu_details IS 'Таблица для хранения блюд';
COMMENT ON COLUMN menu_details.menu_id IS 'ID меню';
COMMENT ON COLUMN menu_details.chief_choice IS 'Является ли блюдом от шеф-повара';
COMMENT ON COLUMN menu_details.alive IS 'True, если блюдо актуально, False - если удалено';
COMMENT ON COLUMN menu_details.dish_type_id IS 'ID типа блюда';
COMMENT ON COLUMN menu_details.dish_name IS 'Название блюда';
COMMENT ON COLUMN menu_details.price IS 'Цена блюда';
COMMENT ON COLUMN menu_details.weight IS 'Вес блюда';
COMMENT ON COLUMN menu_details.max_count IS 'Максимальное кол-во блюд';
COMMENT ON COLUMN menu_details.structure IS 'Состав блюд';
COMMENT ON COLUMN menu_details.image_id IS 'Ссылка на изображение блюда';
COMMENT ON COLUMN menu_details.url IS 'Ссылка в интернет на описание блюда';

CREATE TABLE client (
  id              numeric  		primary key,
  role		      numeric(1,0)  NOT NULL default 1,
  name       	  varchar(200)  NOT NULL,
  email     	  varchar(100)  NOT NULL,
  advised   	  boolean       NOT NULL default FALSE,
  create_date 	  timestamp     NOT NULL,
  balance    	  numeric(10,2) NOT NULL,
  advance 		  numeric(10,2) NOT NULL default 0.0
  CHECK (role in (0,1))
);
COMMENT ON TABLE client IS 'Таблица для хранения информации о пользователях';
COMMENT ON COLUMN client.id IS 'Уникальный идентификатор';
COMMENT ON COLUMN client.role IS 'Роль пользователя: 0-администратор, 1-клиент';
COMMENT ON COLUMN client.name IS 'Имя пользователя';
COMMENT ON COLUMN client.email IS 'E-Mail адрес пользователя';
COMMENT ON COLUMN client.advised IS 'Подписка на рассылку уведомлений на почту';
COMMENT ON COLUMN client.balance IS 'Баланс счёта';
COMMENT ON COLUMN client.advance IS 'Аванс за заказ';
COMMENT ON COLUMN client.create_date IS 'Дата создания записи пользователя';

CREATE TABLE request_group (
  id          numeric          primary key,
  create_date timestamp        NOT NULL,
  status      numeric(1,0)     NOT NULL,
  CHECK (status in (0,1,2,3,4))
);
COMMENT ON TABLE request_group IS 'Таблица для хранения групп заказов';
COMMENT ON COLUMN request_group.create_date IS 'Дата создания заказа';
COMMENT ON COLUMN request_group.status IS 'Состояние группы: 0-черновик, 1-в обработке, 2-принят, 3-доставлен, 4-закрыт';

CREATE TABLE request (
  id         numeric    primary key,
  client_id  numeric    NOT NULL,
  create_date timestamp NOT NULL,
  delivery_date timestamp NOT NULL,
  status     numeric(1,0) NOT NULL,
  cost		 numeric(10,2) NOT NULL DEFAULT 0.0,
  group_id   numeric,    
  CONSTRAINT fk_request_client FOREIGN KEY (client_id) REFERENCES client (id),
  CONSTRAINT fk_request_group FOREIGN KEY (group_id) REFERENCES request_group (id),
  CHECK (status in (0,1,2,3,4,5))
);
COMMENT ON TABLE request IS 'Таблица для хранения заказов';
COMMENT ON COLUMN request.client_id IS 'ID пользователя';
COMMENT ON COLUMN request.create_date IS 'Дата создания заказа';
COMMENT ON COLUMN request.delivery_date IS 'Ориентировочная дата доставки';
COMMENT ON COLUMN request.status IS 'Состояние заказа: 0-в обработке, 1-оплачен, 2-принят, 3-выполнен, 4-удалён, 5-отклонён';
COMMENT ON COLUMN request.cost IS 'Суммарная стоимость заказа';
COMMENT ON COLUMN request.group_id IS 'ID группы заказов';

CREATE TABLE request_details (
  id               numeric  primary key,
  count            numeric(3,0)  NOT NULL,
  request_id       numeric  NOT NULL,
  menu_details_id  numeric  NOT NULL,
  CONSTRAINT fk_request_details_request FOREIGN KEY (request_id) REFERENCES request (id),
  CONSTRAINT fk_request_details_menu_details FOREIGN KEY (menu_details_id) REFERENCES menu_details (id)
);
COMMENT ON TABLE request_details IS 'Таблица для хранения заказанных блюд';
COMMENT ON COLUMN request_details.count IS 'Кол-во порций блюда';
COMMENT ON COLUMN request_details.request_id IS 'ID заказа';
COMMENT ON COLUMN request_details.menu_details_id IS 'ID меню';

CREATE TABLE notification (
  id           numeric       primary key,
  create_date  timestamp     NOT NULL,
  sender       varchar(100)  NOT NULL,
  email        varchar(100)  NOT NULL,
  text         varchar(1024) NOT NULL
);
COMMENT ON TABLE notification IS 'Таблица для ведения истории отправки уведомлений на почту';
COMMENT ON COLUMN notification.create_date IS 'Дата отправки уведомления';
COMMENT ON COLUMN notification.sender IS 'Имя отправителя';
COMMENT ON COLUMN notification.email IS 'E-Mail адрес пользователя';
COMMENT ON COLUMN notification.text IS 'Текст сообщения';

CREATE TABLE transaction (
  id               numeric        primary key,
  client_id       numeric        NOT NULL,
  create_date      timestamp      NOT NULL,
  operator_name    varchar(100)   NOT NULL,
  balance          numeric(10,2)  NOT NULL,
  amount           numeric(10,2)  NOT NULL,
  transaction_type numeric(1,0)   NOT NULL, 
  CONSTRAINT fk_transaction_client FOREIGN KEY (client_id) REFERENCES client (id),
  CHECK (transaction_type in (0,1,2,3))
);
COMMENT ON TABLE transaction IS 'Таблица для ведения истории изменения баланса лицевого счёта';
COMMENT ON COLUMN transaction.create_date IS 'Дата совершения операции';
COMMENT ON COLUMN transaction.amount IS 'Сумма операции';
COMMENT ON COLUMN transaction.operator_name IS 'Имя оператора, производившего операцию';
COMMENT ON COLUMN transaction.balance IS 'Состояние баланса до совершения операции';
COMMENT ON COLUMN transaction.transaction_type IS 'Тип операции: 0-внесения средств на счет, 1-вывод остатка, 2-оплата заказа, 3-возврат средст по отмененному или удаленному заказу';

CREATE TABLE operation (
  id           numeric        primary key,
  create_date  timestamp      NOT NULL,
  user_name    varchar(100)   NOT NULL,
  change_type  numeric(1,0)   NOT NULL,
  text         varchar(1024)  NOT NULL,
  CHECK (change_type in (0,1,2))
);
COMMENT ON TABLE operation IS 'Таблица для ведения истории операций с меню, запросами игруппами запросов';
COMMENT ON COLUMN operation.create_date IS 'Дата совершения операции';
COMMENT ON COLUMN operation.user_name IS 'Имя пользователя, совершившего операцию';
COMMENT ON COLUMN operation.change_type IS 'Тип операции. 0 - меню, 1 - заказы, 2 - группы заказов';
COMMENT ON COLUMN operation.text IS 'Описание операции';

-- Create helper view to append some columns to request 
CREATE VIEW ext_request_view (id, client_id, create_date, status, group_id, cost, delivery_date, menu_name) AS
select r.id AS id, r.client_id AS client_id, r.create_date AS create_date,
 r.status AS status, r.group_id AS group_id, r.cost AS cost, r.delivery_date AS delivery_date,
m.name AS menu_name
from request r, menu m
		WHERE exists( select 1 from  request_details rd, menu_details md
			       where r.id = rd.request_id
			         and rd.menu_details_id = md.id
			         and md.menu_id = m.id);

-- Create helper view to append some columns to requestgroup 
CREATE VIEW ext_group_request_view (id, create_date, status, menu_id) AS
select rg.id AS id, rg.create_date AS create_date, rg.status  AS status, m.id AS menu_id from request_group rg, menu m
		WHERE exists( select 1 from request r, request_details rd, menu_details md
			       where r.id = rd.request_id
			         and rd.menu_details_id = md.id
			         and md.menu_id = m.id
			         and rg.id = r.group_id);

-- Create sequences
CREATE SEQUENCE operation_seq INCREMENT 1 MINVALUE 0 NO MAXVALUE START 0 CACHE 1;
CREATE SEQUENCE menu_seq INCREMENT 1 MINVALUE 0 NO MAXVALUE START 0 CACHE 1;
CREATE SEQUENCE menu_details_seq INCREMENT 1 MINVALUE 0 NO MAXVALUE START 0 CACHE 1;
CREATE SEQUENCE image_seq INCREMENT 1 MINVALUE 0 NO MAXVALUE START 0 CACHE 1;
CREATE SEQUENCE notification_seq INCREMENT 1 MINVALUE 0 NO MAXVALUE START 0 CACHE 1;
CREATE SEQUENCE request_details_seq INCREMENT 1 MINVALUE 0 NO MAXVALUE START 0 CACHE 1;
CREATE SEQUENCE request_group_seq INCREMENT 1 MINVALUE 0 NO MAXVALUE START 0 CACHE 1;
CREATE SEQUENCE transaction_seq INCREMENT 1 MINVALUE 0 NO MAXVALUE START 0 CACHE 1;
CREATE SEQUENCE request_seq INCREMENT 1 MINVALUE 0 NO MAXVALUE START 0 CACHE 1;

-- Add grants
GRANT ALL PRIVILEGES ON database epam_feel TO epam_feel_app WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO epam_feel_app WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO epam_feel_app WITH GRANT OPTION;