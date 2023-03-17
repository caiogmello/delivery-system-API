CREATE TABLE delivery(
    id SERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    fee DECIMAL(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL,
    order_date TIMESTAMP NOT NULL,
    checkout_date TIMESTAMP,

    recipient_name VARCHAR(60) NOT NULL,
    recipient_street VARCHAR(255) NOT NULL,
    recipient_number VARCHAR(30) NOT NULL,
    recipient_complement VARCHAR(60) NOT NULL,
    recipient_hood VARCHAR(30) NOT NULL
);

ALTER TABLE delivery ADD CONSTRAINT
    fk_delivery_customer FOREIGN KEY (customer_id)
    REFERENCES customer(id) ;