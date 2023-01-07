CREATE TABLE FP_Appointment (  
    appointmentID INT PRIMARY KEY,
    customerID INT NOT NULL,
    FOREIGN KEY (customerID) REFERENCES FP_Customers(customerID),
    barberID INT NOT NULL,
    FOREIGN KEY (barberID) REFERENCES FP_Barber(barberID),
    checkinDateTime TIMESTAMP NOT NULL
);