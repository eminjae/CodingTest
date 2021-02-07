//SELECT B SPACE_CNT, COUNT(*) USER_CNT
//        FROM (SELECT HOST_ID , COUNT(HOST_ID) B
//        FROM PLACES
//        GROUP BY HOST_ID) T1
//        WHERE T1.B = 3
//
//        UNION ALL
//
//        SELECT B SPACE_CNT, COUNT(*) USER_CNT
//        FROM (SELECT HOST_ID , COUNT(HOST_ID) B
//        FROM PLACES
//        GROUP BY HOST_ID) T1
//        WHERE T1.B = 2
//
//        UNION ALL
//
//        SELECT B SPACE_CNT, COUNT(*) USER_CNT
//        FROM (SELECT HOST_ID , COUNT(HOST_ID) B
//        FROM PLACES
//        GROUP BY HOST_ID) T1
//        WHERE T1.B = 1;