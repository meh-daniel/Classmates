CREATE TABLE Classmates
(
Id INTEGER PRIMARY KEY,
Name TEXT NOT NULL,
Surname TEXT NOT NULL,
Patronymic TEXT NULL,
DateTimeInsert TEXT NOT NULL
);

INSERT INTO Classmates ("id", "Name", "Surname", "Patronymic", "DateTimeInsert")
VALUES
(1, "daniel", "galkin", "dmit", "13:13 07-12-2021"),
(2, "grisha", "galkin", "dit", "13:18 07-12-2021"),
(3, "murka", "galkin", "met", "13:32 07-12-2021");