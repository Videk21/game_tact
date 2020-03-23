create or replace FUNCTION dodajKomentar(uid integer,opis varchar(100))
RETURNS void AS
$$
BEGIN
	insert into komentarji (opis,uporabnik_id ,time) values (opis, uid, CURRENT_TIMESTAMP);
END;
$$
LANGUAGE 'plpgsql';