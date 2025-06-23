CREATE TABLE IF NOT EXISTS timeslot (
                                        id BIGSERIAL PRIMARY KEY,
                                        mode VARCHAR(50) NOT NULL,
    date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL
    );

CREATE TABLE IF NOT EXISTS delivery (
                                        id BIGSERIAL PRIMARY KEY,
                                        timeslot_id BIGINT NOT NULL,
                                        client VARCHAR(255) NOT NULL,
    FOREIGN KEY (timeslot_id) REFERENCES timeslot(id)
    );
