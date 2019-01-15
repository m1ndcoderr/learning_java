SELECT g.manufacturer, g.type, g.price FROM machines AS m

RIGHT OUTER JOIN gearboxes AS g ON m.gb_id = g.id WHERE m.gb_id is null;