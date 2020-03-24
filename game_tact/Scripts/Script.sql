create or replace FUNCTION izbrisiStrategijo(sid integer)
RETURNS void AS
$$
begin
	DELETE from komentarji WHERE strategija_id = sid;
   DELETE from strategije s where id=sid;
END;
$$
LANGUAGE 'plpgsql'