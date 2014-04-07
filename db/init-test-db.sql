--Fill tables    
INSERT INTO client(id, balance, advance, role, name, email, advised, create_date)
    VALUES (0, 0.1, 0.0, 0, 'Typical Admin', 'TypicalAdmin@epam.com', False, now());

INSERT INTO client(id, balance, advance, role, name, email, advised, create_date)
    VALUES (1, 0.1, 0.0, 1, 'Typical Client', 'TypicalClient@epam.com', False, now());    