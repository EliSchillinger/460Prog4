SET DEFINE OFF;

-- MEMBER Data
INSERT INTO MEMBER (memID, firstName, lastName, phone, email, emergencyContact) VALUES (1, 'Alice', 'Smith', '555-1234', 'alice.smith@email.com', 'Bob Smith 555-1111');
INSERT INTO MEMBER (memID, firstName, lastName, phone, email, emergencyContact) VALUES (2, 'Bob', 'Johnson', '555-5678', 'bob.j@email.com', 'Carol Johnson 555-2222');
INSERT INTO MEMBER (memID, firstName, lastName, phone, email, emergencyContact) VALUES (3, 'Charlie', 'Williams', '555-9101', 'charlie.w@email.com', 'Dana Williams 555-3333');
INSERT INTO MEMBER (memID, firstName, lastName, phone, email, emergencyContact) VALUES (4, 'Diana', 'Brown', '555-1121', 'diana.b@email.com', 'Evan Brown 555-4444');
INSERT INTO MEMBER (memID, firstName, lastName, phone, email, emergencyContact) VALUES (5, 'Ethan', 'Jones', '555-3141', 'ethan.j@email.com', 'Fiona Jones 555-5555');
INSERT INTO MEMBER (memID, firstName, lastName, phone, email, emergencyContact) VALUES (6, 'Fiona', 'Garcia', '555-5161', 'fiona.g@email.com', 'Gary Garcia 555-6666');
INSERT INTO MEMBER (memID, firstName, lastName, phone, email, emergencyContact) VALUES (7, 'George', 'Miller', '555-7181', 'george.m@email.com', 'Helen Miller 555-7777');
INSERT INTO MEMBER (memID, firstName, lastName, phone, email, emergencyContact) VALUES (8, 'Hannah', 'Davis', '555-9202', 'hannah.d@email.com', 'Ian Davis 555-8888');
INSERT INTO MEMBER (memID, firstName, lastName, phone, email, emergencyContact) VALUES (9, 'Ian', 'Rodriguez', '555-1222', 'ian.r@email.com', 'Jane Rodriguez 555-9999');
INSERT INTO MEMBER (memID, firstName, lastName, phone, email, emergencyContact) VALUES (10, 'Jane', 'Martinez', '555-3242', 'jane.m@email.com', 'Kyle Martinez 555-0000');
INSERT INTO MEMBER (memID, firstName, lastName, phone, email, emergencyContact) VALUES (11, 'Kyle', 'Hernandez', '555-5262', 'kyle.h@email.com', 'Laura Hernandez 555-1010');
INSERT INTO MEMBER (memID, firstName, lastName, phone, email, emergencyContact) VALUES (12, 'Laura', 'Lopez', '555-7282', 'laura.l@email.com', 'Mike Lopez 555-2020');
INSERT INTO MEMBER (memID, firstName, lastName, phone, email, emergencyContact) VALUES (13, 'Mike', 'Gonzalez', '555-9303', 'mike.g@email.com', 'Nora Gonzalez 555-3030');
INSERT INTO MEMBER (memID, firstName, lastName, phone, email, emergencyContact) VALUES (14, 'Nora', 'Wilson', '555-1323', 'nora.w@email.com', 'Oliver Wilson 555-4040');
INSERT INTO MEMBER (memID, firstName, lastName, phone, email, emergencyContact) VALUES (15, 'Oliver', 'Anderson', '555-3343', 'oliver.a@email.com', 'Pam Anderson 555-5050');
COMMIT;

-- EMPLOYEE Data
INSERT INTO EMPLOYEE (empID, name, phone, salary) VALUES (101, 'Peter Jones', '555-0101', 60000);
INSERT INTO EMPLOYEE (empID, name, phone, salary) VALUES (102, 'Quinn Davis', '555-0202', 55000);
INSERT INTO EMPLOYEE (empID, name, phone, salary) VALUES (103, 'Rachel Green', '555-0303', 52000);
INSERT INTO EMPLOYEE (empID, name, phone, salary) VALUES (104, 'Sam Adams', '555-0404', 70000);
INSERT INTO EMPLOYEE (empID, name, phone, salary) VALUES (105, 'Tina White', '555-0505', 48000);
INSERT INTO EMPLOYEE (empID, name, phone, salary) VALUES (106, 'Uma Thurman', '555-0606', 53000);
INSERT INTO EMPLOYEE (empID, name, phone, salary) VALUES (107, 'Victor Black', '555-0707', 54000);
INSERT INTO EMPLOYEE (empID, name, phone, salary) VALUES (108, 'Wendy Blue', '555-0808', 51000);
INSERT INTO EMPLOYEE (empID, name, phone, salary) VALUES (109, 'Xavier Red', '555-0909', 49000);
INSERT INTO EMPLOYEE (empID, name, phone, salary) VALUES (110, 'Yara Yellow', '555-1010', 56000);
INSERT INTO EMPLOYEE (empID, name, phone, salary) VALUES (111, 'Zack Zebra', '555-1111', 50000);
COMMIT;

-- TRAIL Data
INSERT INTO TRAIL (trailID, category, name, "start", "end", "level", status) VALUES (201, 'Alpine', 'Bunny Hill', 'Base Area', 'Mid Station', 'Beginner', 'Open');
INSERT INTO TRAIL (trailID, category, name, "start", "end", "level", status) VALUES (202, 'Alpine', 'Easy Street', 'Top of Chair 1', 'Base Area', 'Beginner', 'Open');
INSERT INTO TRAIL (trailID, category, name, "start", "end", "level", status) VALUES (203, 'Alpine', 'Blue Ridge Run', 'Top of Chair 2', 'Mid Station', 'Intermediate', 'Open');
INSERT INTO TRAIL (trailID, category, name, "start", "end", "level", status) VALUES (204, 'Alpine', 'Horizon', 'Summit', 'Base Area', 'Intermediate', 'Closed');
INSERT INTO TRAIL (trailID, category, name, "start", "end", "level", status) VALUES (205, 'Alpine', 'Black Diamond', 'Summit', 'Mid Station', 'Expert', 'Open');
INSERT INTO TRAIL (trailID, category, name, "start", "end", "level", status) VALUES (206, 'Alpine', 'The Chute', 'Summit', 'Ridge Line', 'Expert', 'Closed');
INSERT INTO TRAIL (trailID, category, name, "start", "end", "level", status) VALUES (207, 'Terrain Park', 'Jib Junction', 'Mid Station', 'Base Area', 'Intermediate', 'Open');
INSERT INTO TRAIL (trailID, category, name, "start", "end", "level", status) VALUES (208, 'Alpine', 'Ridge Runner', 'Top of Chair 3', 'Base Area', 'Intermediate', 'Open');
INSERT INTO TRAIL (trailID, category, name, "start", "end", "level", status) VALUES (209, 'Alpine', 'Powder Peak', 'Summit', 'Base Area', 'Expert', 'Open');
INSERT INTO TRAIL (trailID, category, name, "start", "end", "level", status) VALUES (210, 'Glades', 'Whispering Pines', 'Top of Chair 2', 'Mid Station', 'Expert', 'Open');
INSERT INTO TRAIL (trailID, category, name, "start", "end", "level", status) VALUES (211, 'Nordic', 'Meadow Loop', 'Nordic Center', 'Nordic Center', 'Beginner', 'Open');
INSERT INTO TRAIL (trailID, category, name, "start", "end", "level", status) VALUES (212, 'Alpine', 'Snowflake Alley', 'Top of Chair 1', 'Base Area', 'Beginner', 'Open');
COMMIT;

-- LIFT Data
INSERT INTO LIFT (liftID, trailID, name, "open", "close", "level", status) VALUES (301, 202, 'Chair 1 (Beginner)', '09:00', '16:00', 'Base', 'Operating');
INSERT INTO LIFT (liftID, trailID, name, "open", "close", "level", status) VALUES (302, 203, 'Chair 2 (Intermediate)', '08:30', '16:30', 'Base', 'Operating');
INSERT INTO LIFT (liftID, trailID, name, "open", "close", "level", status) VALUES (303, 208, 'Chair 3 (Ridge)', '08:30', '16:00', 'Mid-mountain', 'Operating');
INSERT INTO LIFT (liftID, trailID, name, "open", "close", "level", status) VALUES (304, 205, 'Summit Gondola', '08:00', '16:30', 'Base', 'Operating');
INSERT INTO LIFT (liftID, trailID, name, "open", "close", "level", status) VALUES (305, 201, 'Magic Carpet', '09:00', '15:30', 'Base', 'Operating');
INSERT INTO LIFT (liftID, trailID, name, "open", "close", "level", status) VALUES (306, NULL, 'Surface Lift (Park)', '10:00', '15:00', 'Mid-mountain', 'Hold');
INSERT INTO LIFT (liftID, trailID, name, "open", "close", "level", status) VALUES (307, 210, 'Chair 4 (Glades)', '09:00', '15:30', 'Mid-mountain', 'Closed');
INSERT INTO LIFT (liftID, trailID, name, "open", "close", "level", status) VALUES (308, NULL, 'T-Bar Express', '08:30', '16:00', 'Mid-mountain', 'Operating');
INSERT INTO LIFT (liftID, trailID, name, "open", "close", "level", status) VALUES (309, 209, 'Chair 5 (Peak)', '08:00', '16:00', 'Base', 'Operating');
INSERT INTO LIFT (liftID, trailID, name, "open", "close", "level", status) VALUES (310, NULL, 'Nordic Access Lift', '09:30', '15:00', 'Base', 'Operating');
COMMIT;

-- INVENTORY Data
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (401, 'Skis', '165cm', 1, 1);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (402, 'Skis', '175cm', 1, 1);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (403, 'Skis', '155cm', 1, 0);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (404, 'Snowboard', '150cm', 1, 1);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (405, 'Snowboard', '158cm', 1, 1);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (406, 'Snowboard', '145cm', 1, 0);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (407, 'Ski Boots', '26.5', 1, 1);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (408, 'Ski Boots', '27.5', 1, 0);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (409, 'Ski Boots', '24.5', 1, 1);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (410, 'Snowboard Boots', '10', 1, 1);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (411, 'Snowboard Boots', '9', 1, 1);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (412, 'Helmet', 'M', 1, 1);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (413, 'Helmet', 'L', 1, 0);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (414, 'Helmet', 'S', 1, 1);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (415, 'Ski Poles', '120cm', 1, 1);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (416, 'Ski Poles', '115cm', 1, 0);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (417, 'Ski Poles', '125cm', 1, 1);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (418, 'Skis', '165cm', 1, 1);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (419, 'Snowboard', '158cm', 0, 0);
INSERT INTO INVENTORY (eID, type, "size", isActive, isAvailable) VALUES (420, 'Helmet', 'M', 1, 1);
COMMIT;

-- PASS Data
INSERT INTO PASS (passNo, memID, type, remainingUses, totalUses, purchaseTime, expDate, price, isActive) VALUES ('P-0001', 1, 'Season', NULL, NULL, TO_TIMESTAMP('2023-10-15 09:30:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-04-30', 'YYYY-MM-DD'), 899.00, 1);
INSERT INTO PASS (passNo, memID, type, remainingUses, totalUses, purchaseTime, expDate, price, isActive) VALUES ('P-0002', 2, 'Day', 1, 1, TO_TIMESTAMP('2024-01-20 08:15:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-01-20', 'YYYY-MM-DD'), 120.00, 1);
INSERT INTO PASS (passNo, memID, type, remainingUses, totalUses, purchaseTime, expDate, price, isActive) VALUES ('P-0003', 3, '5-Lesson Pack', 4, 5, TO_TIMESTAMP('2023-11-01 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-04-30', 'YYYY-MM-DD'), 450.00, 1);
INSERT INTO PASS (passNo, memID, type, remainingUses, totalUses, purchaseTime, expDate, price, isActive) VALUES ('P-0004', 4, '10-Use', 8, 10, TO_TIMESTAMP('2023-11-10 14:20:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-04-30', 'YYYY-MM-DD'), 950.00, 1);
INSERT INTO PASS (passNo, memID, type, remainingUses, totalUses, purchaseTime, expDate, price, isActive) VALUES ('P-0005', 5, 'Season', NULL, NULL, TO_TIMESTAMP('2023-09-25 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-04-30', 'YYYY-MM-DD'), 850.00, 1);
INSERT INTO PASS (passNo, memID, type, remainingUses, totalUses, purchaseTime, expDate, price, isActive) VALUES ('P-0006', 6, 'Day', 0, 1, TO_TIMESTAMP('2024-01-15 09:05:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-01-15', 'YYYY-MM-DD'), 120.00, 0);
INSERT INTO PASS (passNo, memID, type, remainingUses, totalUses, purchaseTime, expDate, price, isActive) VALUES ('P-0007', 7, 'Midweek Season', NULL, NULL, TO_TIMESTAMP('2023-10-20 16:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-04-30', 'YYYY-MM-DD'), 599.00, 1);
INSERT INTO PASS (passNo, memID, type, remainingUses, totalUses, purchaseTime, expDate, price, isActive) VALUES ('P-0008', 8, '5-Lesson Pack', 5, 5, TO_TIMESTAMP('2024-01-05 13:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-04-30', 'YYYY-MM-DD'), 450.00, 1);
INSERT INTO PASS (passNo, memID, type, remainingUses, totalUses, purchaseTime, expDate, price, isActive) VALUES ('P-0009', 9, '10-Use', 10, 10, TO_TIMESTAMP('2023-12-15 10:10:10', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-04-30', 'YYYY-MM-DD'), 950.00, 1);
INSERT INTO PASS (passNo, memID, type, remainingUses, totalUses, purchaseTime, expDate, price, isActive) VALUES ('P-0010', 10, 'Season', NULL, NULL, TO_TIMESTAMP('2023-10-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-04-30', 'YYYY-MM-DD'), 899.00, 1);
INSERT INTO PASS (passNo, memID, type, remainingUses, totalUses, purchaseTime, expDate, price, isActive) VALUES ('P-0011', 1, 'Day', 1, 1, TO_TIMESTAMP('2024-01-21 08:30:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-01-21', 'YYYY-MM-DD'), 125.00, 1);
INSERT INTO PASS (passNo, memID, type, remainingUses, totalUses, purchaseTime, expDate, price, isActive) VALUES ('P-0012', 11, 'Season', NULL, NULL, TO_TIMESTAMP('2023-11-05 15:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-04-30', 'YYYY-MM-DD'), 899.00, 1);
INSERT INTO PASS (passNo, memID, type, remainingUses, totalUses, purchaseTime, expDate, price, isActive) VALUES ('P-0013', 12, '10-Use', 7, 10, TO_TIMESTAMP('2023-12-01 09:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-04-30', 'YYYY-MM-DD'), 950.00, 1);
INSERT INTO PASS (passNo, memID, type, remainingUses, totalUses, purchaseTime, expDate, price, isActive) VALUES ('P-0014', 13, 'Day', 1, 1, TO_TIMESTAMP('2024-01-22 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-01-22', 'YYYY-MM-DD'), 125.00, 1);
INSERT INTO PASS (passNo, memID, type, remainingUses, totalUses, purchaseTime, expDate, price, isActive) VALUES ('P-0015', 14, 'Midweek Season', NULL, NULL, TO_TIMESTAMP('2023-10-25 11:45:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2024-04-30', 'YYYY-MM-DD'), 599.00, 1);
COMMIT;

-- LESSON Data
INSERT INTO LESSON (lessonID, "date", "time", empID, "level") VALUES (501, TO_DATE('2024-01-25', 'YYYY-MM-DD'), '10:00', 102, 'Beginner');
INSERT INTO LESSON (lessonID, "date", "time", empID, "level") VALUES (502, TO_DATE('2024-01-25', 'YYYY-MM-DD'), '13:00', 103, 'Intermediate');
INSERT INTO LESSON (lessonID, "date", "time", empID, "level") VALUES (503, TO_DATE('2024-01-26', 'YYYY-MM-DD'), '09:00', 106, 'Advanced');
INSERT INTO LESSON (lessonID, "date", "time", empID, "level") VALUES (504, TO_DATE('2024-01-26', 'YYYY-MM-DD'), '10:00', 108, 'Beginner Snowboard');
INSERT INTO LESSON (lessonID, "date", "time", empID, "level") VALUES (505, TO_DATE('2024-01-27', 'YYYY-MM-DD'), '11:00', 110, 'Intermediate Ski');
INSERT INTO LESSON (lessonID, "date", "time", empID, "level") VALUES (506, TO_DATE('2024-01-27', 'YYYY-MM-DD'), '14:00', 102, 'Kids Club');
INSERT INTO LESSON (lessonID, "date", "time", empID, "level") VALUES (507, TO_DATE('2024-01-28', 'YYYY-MM-DD'), '10:00', 103, 'Beginner');
INSERT INTO LESSON (lessonID, "date", "time", empID, "level") VALUES (508, TO_DATE('2024-01-28', 'YYYY-MM-DD'), '13:00', 106, 'Intermediate');
INSERT INTO LESSON (lessonID, "date", "time", empID, "level") VALUES (509, TO_DATE('2024-01-29', 'YYYY-MM-DD'), '09:00', 108, 'Advanced Snowboard');
INSERT INTO LESSON (lessonID, "date", "time", empID, "level") VALUES (510, TO_DATE('2024-01-29', 'YYYY-MM-DD'), '10:00', 110, 'Beginner Ski');
INSERT INTO LESSON (lessonID, "date", "time", empID, "level") VALUES (511, TO_DATE('2024-01-30', 'YYYY-MM-DD'), '11:00', 102, 'Intermediate Snowboard');
INSERT INTO LESSON (lessonID, "date", "time", empID, "level") VALUES (512, TO_DATE('2024-01-30', 'YYYY-MM-DD'), '14:00', 103, 'Kids Club');
COMMIT;

-- LESSON_LOG Data
INSERT INTO LESSON_LOG (orderID, lessonID, passNo, lessonsPurchased, lessonsRemaining) VALUES (601, 501, 'P-0003', 1, 3);
INSERT INTO LESSON_LOG (orderID, lessonID, passNo, lessonsPurchased, lessonsRemaining) VALUES (602, 504, 'P-0008', 1, 4);
INSERT INTO LESSON_LOG (orderID, lessonID, passNo, lessonsPurchased, lessonsRemaining) VALUES (603, 502, 'P-0003', 1, 2);
INSERT INTO LESSON_LOG (orderID, lessonID, passNo, lessonsPurchased, lessonsRemaining) VALUES (604, 507, 'P-0008', 1, 3);
INSERT INTO LESSON_LOG (orderID, lessonID, passNo, lessonsPurchased, lessonsRemaining) VALUES (605, 505, 'P-0003', 1, 1);
INSERT INTO LESSON_LOG (orderID, lessonID, passNo, lessonsPurchased, lessonsRemaining) VALUES (606, 508, 'P-0008', 1, 2);
INSERT INTO LESSON_LOG (orderID, lessonID, passNo, lessonsPurchased, lessonsRemaining) VALUES (607, 510, 'P-0003', 1, 0);
INSERT INTO LESSON_LOG (orderID, lessonID, passNo, lessonsPurchased, lessonsRemaining) VALUES (608, 511, 'P-0008', 1, 1);
INSERT INTO LESSON_LOG (orderID, lessonID, passNo, lessonsPurchased, lessonsRemaining) VALUES (609, 503, 'P-0009', 1, 9);
INSERT INTO LESSON_LOG (orderID, lessonID, passNo, lessonsPurchased, lessonsRemaining) VALUES (610, 506, 'P-0010', 1, NULL);
INSERT INTO LESSON_LOG (orderID, lessonID, passNo, lessonsPurchased, lessonsRemaining) VALUES (611, 512, 'P-0008', 1, 0);
COMMIT;

-- LIFT_LOG Data
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (701, 301, 'P-0001', TO_TIMESTAMP('2024-01-21 09:05:10', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (702, 302, 'P-0002', TO_TIMESTAMP('2024-01-20 08:40:15', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (703, 304, 'P-0004', TO_TIMESTAMP('2024-01-21 09:15:30', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (704, 301, 'P-0005', TO_TIMESTAMP('2024-01-21 09:20:05', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (705, 302, 'P-0007', TO_TIMESTAMP('2024-01-22 08:55:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (706, 303, 'P-0009', TO_TIMESTAMP('2024-01-21 10:30:45', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (707, 304, 'P-0010', TO_TIMESTAMP('2024-01-21 11:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (708, 301, 'P-0011', TO_TIMESTAMP('2024-01-21 09:10:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (709, 302, 'P-0001', TO_TIMESTAMP('2024-01-21 10:15:20', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (710, 303, 'P-0004', TO_TIMESTAMP('2024-01-21 11:45:55', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (711, 304, 'P-0005', TO_TIMESTAMP('2024-01-21 13:05:10', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (712, 301, 'P-0012', TO_TIMESTAMP('2024-01-22 09:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (713, 302, 'P-0013', TO_TIMESTAMP('2024-01-22 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (714, 308, 'P-0014', TO_TIMESTAMP('2024-01-22 08:35:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (715, 304, 'P-0015', TO_TIMESTAMP('2024-01-22 09:10:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (716, 302, 'P-0001', TO_TIMESTAMP('2024-01-22 10:05:10', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (717, 303, 'P-0004', TO_TIMESTAMP('2024-01-22 11:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (718, 304, 'P-0009', TO_TIMESTAMP('2024-01-22 12:15:30', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (719, 301, 'P-0010', TO_TIMESTAMP('2024-01-22 13:30:45', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO LIFT_LOG (xactID, liftID, passNo, scanTime) VALUES (720, 305, 'P-0001', TO_TIMESTAMP('2024-01-22 14:00:00', 'YYYY-MM-DD HH24:MI:SS'));
COMMIT;

-- RENTAL_LOG Data
INSERT INTO RENTAL_LOG (rentalID, passNo, rentalTime, returnTime, isReturned, eID) VALUES (801, 'P-0001', TO_TIMESTAMP('2024-01-21 08:45:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 0, 403);
INSERT INTO RENTAL_LOG (rentalID, passNo, rentalTime, returnTime, isReturned, eID) VALUES (802, 'P-0004', TO_TIMESTAMP('2024-01-21 09:00:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 0, 406);
INSERT INTO RENTAL_LOG (rentalID, passNo, rentalTime, returnTime, isReturned, eID) VALUES (803, 'P-0005', TO_TIMESTAMP('2024-01-21 09:10:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 0, 408);
INSERT INTO RENTAL_LOG (rentalID, passNo, rentalTime, returnTime, isReturned, eID) VALUES (804, 'P-0009', TO_TIMESTAMP('2024-01-21 09:12:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 0, 413);
INSERT INTO RENTAL_LOG (rentalID, passNo, rentalTime, returnTime, isReturned, eID) VALUES (805, 'P-0010', TO_TIMESTAMP('2024-01-21 09:18:00', 'YYYY-MM-DD HH24:MI:SS'), NULL, 0, 416);
INSERT INTO RENTAL_LOG (rentalID, passNo, rentalTime, returnTime, isReturned, eID) VALUES (806, 'P-0002', TO_TIMESTAMP('2024-01-20 08:30:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-01-20 16:30:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 401);
INSERT INTO RENTAL_LOG (rentalID, passNo, rentalTime, returnTime, isReturned, eID) VALUES (807, 'P-0006', TO_TIMESTAMP('2024-01-15 09:15:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-01-15 17:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 404);
INSERT INTO RENTAL_LOG (rentalID, passNo, rentalTime, returnTime, isReturned, eID) VALUES (808, 'P-0007', TO_TIMESTAMP('2024-01-18 09:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-01-18 16:45:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 407);
INSERT INTO RENTAL_LOG (rentalID, passNo, rentalTime, returnTime, isReturned, eID) VALUES (809, 'P-0011', TO_TIMESTAMP('2024-01-21 08:50:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-01-21 16:55:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 410);
INSERT INTO RENTAL_LOG (rentalID, passNo, rentalTime, returnTime, isReturned, eID) VALUES (810, 'P-0012', TO_TIMESTAMP('2024-01-19 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-01-19 16:30:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 412);
INSERT INTO RENTAL_LOG (rentalID, passNo, rentalTime, returnTime, isReturned, eID) VALUES (811, 'P-0013', TO_TIMESTAMP('2024-01-20 10:30:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-01-20 17:15:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 415);
INSERT INTO RENTAL_LOG (rentalID, passNo, rentalTime, returnTime, isReturned, eID) VALUES (812, 'P-0014', TO_TIMESTAMP('2024-01-22 08:10:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-01-22 16:40:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 418);
INSERT INTO RENTAL_LOG (rentalID, passNo, rentalTime, returnTime, isReturned, eID) VALUES (813, 'P-0015', TO_TIMESTAMP('2024-01-22 08:55:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-01-22 17:05:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 420);
INSERT INTO RENTAL_LOG (rentalID, passNo, rentalTime, returnTime, isReturned, eID) VALUES (814, 'P-0001', TO_TIMESTAMP('2024-01-14 09:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-01-14 16:30:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 402);
INSERT INTO RENTAL_LOG (rentalID, passNo, rentalTime, returnTime, isReturned, eID) VALUES (815, 'P-0004', TO_TIMESTAMP('2024-01-10 09:30:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-01-10 17:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 405);
COMMIT;

SET DEFINE ON;
