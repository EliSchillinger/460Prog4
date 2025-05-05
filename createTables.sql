CREATE TABLE MEMBER (
    memID               INTEGER CONSTRAINT pk_member PRIMARY KEY,
    firstName           VARCHAR2(50) NOT NULL,
    lastName            VARCHAR2(50) NOT NULL,
    phone               VARCHAR2(20),
    email               VARCHAR2(100),
    emergencyContact    VARCHAR2(150)
);

CREATE TABLE EMPLOYEE (
    empID       INTEGER CONSTRAINT pk_employee PRIMARY KEY,
    name        VARCHAR2(100) NOT NULL,
    phone       VARCHAR2(20),
    salary      NUMBER(10, 2)
);

CREATE TABLE LESSON (
    lessonID    INTEGER CONSTRAINT pk_lesson PRIMARY KEY,
    "date"      DATE NOT NULL,
    "time"      VARCHAR2(5),
    empID       INTEGER NOT NULL,
    "level"     VARCHAR2(50),
    CONSTRAINT fk_lesson_employee FOREIGN KEY (empID) REFERENCES EMPLOYEE(empID)
);

CREATE TABLE PASS (
    passNo          VARCHAR2(50) CONSTRAINT pk_pass PRIMARY KEY,
    memID           INTEGER NOT NULL,
    type            VARCHAR2(50),
    remainingUses   INTEGER,
    totalUses       INTEGER,
    purchaseTime    TIMESTAMP,
    expDate         DATE,
    price           NUMBER(8, 2),
    isActive        NUMBER(1) DEFAULT 1 CHECK (isActive IN (0, 1)),
    CONSTRAINT fk_pass_member FOREIGN KEY (memID) REFERENCES MEMBER(memID)
);

CREATE TABLE LESSON_LOG (
    orderID             INTEGER CONSTRAINT pk_lesson_log PRIMARY KEY,
    lessonID            INTEGER NOT NULL,
    passNo              VARCHAR2(50) NOT NULL,
    lessonsPurchased    INTEGER,
    lessonsRemaining    INTEGER,
    CONSTRAINT fk_lessonlog_lesson FOREIGN KEY (lessonID) REFERENCES LESSON(lessonID),
    CONSTRAINT fk_lessonlog_pass FOREIGN KEY (passNo) REFERENCES PASS(passNo)
);

CREATE TABLE TRAIL (
    trailID     INTEGER CONSTRAINT pk_trail PRIMARY KEY,
    category    VARCHAR2(50),
    name        VARCHAR2(100) NOT NULL,
    "start"     VARCHAR2(100),
    "end"       VARCHAR2(100),
    "level"     VARCHAR2(50),
    status      VARCHAR2(20)
);

CREATE TABLE LIFT (
    liftID      INTEGER CONSTRAINT pk_lift PRIMARY KEY,
    trailID     INTEGER,
    name        VARCHAR2(100) NOT NULL,
    "open"      VARCHAR2(5),
    "close"     VARCHAR2(5),
    "level"     VARCHAR2(50),
    status      VARCHAR2(20),
    CONSTRAINT fk_lift_trail FOREIGN KEY (trailID) REFERENCES TRAIL(trailID)
);

CREATE TABLE LIFT_LOG (
    xactID      INTEGER CONSTRAINT pk_lift_log PRIMARY KEY,
    liftID      INTEGER NOT NULL,
    passNo      VARCHAR2(50) NOT NULL,
    scanTime    TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT fk_liftlog_lift FOREIGN KEY (liftID) REFERENCES LIFT(liftID),
    CONSTRAINT fk_liftlog_pass FOREIGN KEY (passNo) REFERENCES PASS(passNo)
);

CREATE TABLE INVENTORY (
    eID             INTEGER CONSTRAINT pk_inventory PRIMARY KEY,
    type            VARCHAR2(50) NOT NULL,
    "size"          VARCHAR2(20),
    isActive        NUMBER(1) DEFAULT 1 CHECK (isActive IN (0, 1)),
    isAvailable     NUMBER(1) DEFAULT 1 CHECK (isAvailable IN (0, 1)),
    CONSTRAINT uq_inventory_item UNIQUE (type, "size", eID)
);

CREATE TABLE RENTAL_LOG (
    rentalID        INTEGER CONSTRAINT pk_rental_log PRIMARY KEY,
    passNo          VARCHAR2(50) NOT NULL,
    rentalTime      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    returnTime      TIMESTAMP NULL,
    isReturned      NUMBER(1) DEFAULT 0 CHECK (isReturned IN (0, 1)),
    eID             INTEGER NOT NULL,
    CONSTRAINT fk_rentallog_pass FOREIGN KEY (passNo) REFERENCES PASS(passNo),
    CONSTRAINT fk_rentallog_inventory FOREIGN KEY (eID) REFERENCES INVENTORY(eID)
);

COMMIT;