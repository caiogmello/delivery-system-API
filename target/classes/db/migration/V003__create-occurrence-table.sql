CREATE TABLE occurrence (
   id SERIAL PRIMARY KEY,
   delivery_id BIGINT NOT NULL,
   description TEXT NOT NULL,
   register_date TIMESTAMP NOT NULL
);

ALTER TABLE occurrence ADD CONSTRAINT
    fk_delivery_occurrence FOREIGN KEY (delivery_id)
        REFERENCES delivery(id);