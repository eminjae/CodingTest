//-- 코드를 입력하세요
//        SELECT HOUR(CREATED_AT) time, COUNT(HOUR(CREATED_AT)) cnt
//        FROM CARD_USAGES
//        WHERE CATEGORY = '0'
//        GROUP BY HOUR(CREATED_AT)
//        HAVING time >= 10 AND time <=15
//        ORDER BY TIME ASC