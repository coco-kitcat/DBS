CREATE SCHEMA family_calendar AUTHORIZATION ysj;

CREATE TABLE family_calendar.User
(
    id text PRIMARY KEY,
    name text,
    nickname text,
    password text,
    email text,
    phoneNumber text
);
CREATE TABLE family_calendar.reminder_setting
(
    user_id text REFERENCES family_calendar.User(id),
    method text,
    whenToRemind timestamp
);
CREATE TABLE family_calendar.Event
(
    id integer PRIMARY KEY,
    hostId text,
    name text,
    type text,
    mandatory boolean,
    startAt timestamp,
    endAt timestamp
);
CREATE TABLE family_calendar.User_Event
(
    user_id text REFERENCES family_calendar.User(id),
    event_id integer REFERENCES family_calendar.Event(id),
    event_host text,
    private boolean,
    participate boolean,
    remind boolean
);