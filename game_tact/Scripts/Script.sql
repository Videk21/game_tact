create or replace FUNCTION izbrisiStrategijo(sid integer)
RETURNS void AS
$$
BEGIN
   DELETE from strategije s where id=sid;
END;
$$
LANGUAGE 'plpgsql'