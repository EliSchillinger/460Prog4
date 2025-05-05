SET SERVEROUTPUT ON;

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE RENTAL_LOG';
   Dbms_Output.Put_Line('Table RENTAL_LOG dropped.');
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE = -942 THEN
         Dbms_Output.Put_Line('Table RENTAL_LOG does not exist.');
      ELSE
         RAISE;
      END IF;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE LIFT_LOG';
   Dbms_Output.Put_Line('Table LIFT_LOG dropped.');
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE = -942 THEN
         Dbms_Output.Put_Line('Table LIFT_LOG does not exist.');
      ELSE
         RAISE;
      END IF;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE LESSON_LOG';
   Dbms_Output.Put_Line('Table LESSON_LOG dropped.');
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE = -942 THEN
         Dbms_Output.Put_Line('Table LESSON_LOG does not exist.');
      ELSE
         RAISE;
      END IF;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE PASS';
   Dbms_Output.Put_Line('Table PASS dropped.');
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE = -942 THEN
         Dbms_Output.Put_Line('Table PASS does not exist.');
      ELSE
         RAISE;
      END IF;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE LESSON';
   Dbms_Output.Put_Line('Table LESSON dropped.');
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE = -942 THEN
         Dbms_Output.Put_Line('Table LESSON does not exist.');
      ELSE
         RAISE;
      END IF;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE LIFT';
   Dbms_Output.Put_Line('Table LIFT dropped.');
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE = -942 THEN
         Dbms_Output.Put_Line('Table LIFT does not exist.');
      ELSE
         RAISE;
      END IF;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE INVENTORY';
   Dbms_Output.Put_Line('Table INVENTORY dropped.');
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE = -942 THEN
         Dbms_Output.Put_Line('Table INVENTORY does not exist.');
      ELSE
         RAISE;
      END IF;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE MEMBER';
   Dbms_Output.Put_Line('Table MEMBER dropped.');
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE = -942 THEN
         Dbms_Output.Put_Line('Table MEMBER does not exist.');
      ELSE
         RAISE;
      END IF;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE EMPLOYEE';
   Dbms_Output.Put_Line('Table EMPLOYEE dropped.');
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE = -942 THEN
         Dbms_Output.Put_Line('Table EMPLOYEE does not exist.');
      ELSE
         RAISE;
      END IF;
END;
/

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE TRAIL';
   Dbms_Output.Put_Line('Table TRAIL dropped.');
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE = -942 THEN
         Dbms_Output.Put_Line('Table TRAIL does not exist.');
      ELSE
         RAISE;
      END IF;
END;
/

COMMIT;

Dbms_Output.Put_Line('All specified tables dropped (if they existed).');