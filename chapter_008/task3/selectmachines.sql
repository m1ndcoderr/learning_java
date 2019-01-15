SELECT m.manufacturer,
e.manufacturer, e.type, e.appointment, e.price,
t.manufacturer, t.type, t.price,
g.manufacturer, g.type, g.price FROM machines AS m

LEFT OUTER JOIN engines AS e ON m.en_id = e.id;
LEFT OUTER JOIN transmission AS t ON m.trans_id = t.id;
LEFT OUTER JOIN gearboxes AS g ON m.gb_id = g.id;