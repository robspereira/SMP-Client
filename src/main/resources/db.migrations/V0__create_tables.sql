CREATE TABLE CLIENT {
    CLIENT_ID NUMBER NOT NULL IDENTITY,
    CNPJ VARCHAR2(30) NOT NULL,
    CLIENT_NAME VARCHAR2(120) NOT NULL,
    CONTACT_EMAIL VARCHAR2(80) NOT NULL,

}

CREATE TABLE ADDRESS {
    ADDRESS_ID NUMBER NOT NULL IDENTITY,
    STATE VARCHAR2(2) NOT NULL,
    CITY VARCHAR2(80),
    STREET VARCHAR2(30),
    NUMBER VARCHAR2(15)

}

ALTER TABLE ADDRESS {
    ADD CONSTRAINT FK_CLIENT_ID
    FOREIGN KEY (CLIENT_ID)
    REFERENCES CLIENT;
}