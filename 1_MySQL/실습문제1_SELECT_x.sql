-- sakila, 정렬은 결과 화면대로

-- 1. actor 테이블에서 first_name이 A로 시작하는 배우들만 조회 
SELECT *
FROM actor
WHERE first_name LIKE 'A%';

-- 2. film 테이블에서 rating이 PG면서 영화 제목(title)에 GO가 포함되는 영화 제목 조회
SELECT title
FROM film
WHERE rating = 'PG'
    AND title LIKE '%GO%';

-- 3. film 테이블에서 film_id가 7 이하면서 4, 6은 아닌 film_id, title 조회
SELECT film_id, title
FROM film
WHERE film_id <= 7 and film_id != 4 and film_id != 6;

-- 4. film 테이블에서 가격(replacement_cost)은 10 이상 15 이하이면서 
-- special_features 중 Trailers가 포함되어 있는 영화 제목(title)만 조회 
SELECT  title
FROM film
WHERE replacement_cost between 10 and 15 
	and special_features LIKE "%Trailers%";

-- 5. address 테이블에서 거리(district)가 A로 시작하는 주소(addre"ss)만 앞에 숫자 제외 주소만 10개 조회 

-- 6. customer 테이블에서 id가 6인 사람부터 10명 cumstomer_id 조회

-- 7. actor 테이블에서 first_name이 J로 시작하는 사람의 last_name의 글자수 조회 (공백 X, 정렬은 글자수가 많은 사람 순으로)

-- 8. film 테이블에서 description에서 of 이전 문장만 중복 없이 10개만 추출해서 조회

-- 9. film 테이블에서 replacement_cost 최소 비용과 최대 비용 조회