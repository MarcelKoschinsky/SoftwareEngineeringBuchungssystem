# SoftwareEngineeringBuchungssystem
![GUI](https://user-images.githubusercontent.com/95693312/182212209-083fcf57-a596-4f56-8519-e67c11142059.jpg) <br>
In seinem derzeitigen Zustand ist das System in der Lage Räume zu bestimmten Zeiten, an bestimmten Tagen zu buchen und zu stornieren. Der Eingabe von Zeiträumen liegt  die untenstehende Tabelle zugrunde, wobei der erste Parameter einen halbstündigen Time-Slot und der zweite Parameter einen Wochentag darstellt.

Zur Verfügung stehen Räume mit den Nummern 101-120 (bzw. 101-105 + 110 mit RaumPersistenceDummy).
Um einen Raum zu buchen muss ein Name gewählt werden, der in der Buchung hinterlegt werden soll. Als Passwort dient der Platzhalter „1234“.
Anschließend wird eine Raumnummer angegeben und ein Zeitraum gewählt.

Mit dem Klicken des Buchen-Knopfes wird die Buchung ausgeführt. Der Versuch eine weitere Buchung zu diesem Zeitpunkt zu tätigen führt zu einer Fehlermeldung.
Der Stornieren-Knopf funktionert genauso.

Zum Beenden des Programmes kann der Abbrechen-Knopf gedrückt werden.


|   |           | 0 | 1 | 2 | 3 | 4 | 5 | 6 |
|---|-----------|---|---|---|---|---|---|---|
|   |           | Mo| Di| Mi| Do| Fr| Sa| So|
| 0 |08:00-08:30||||||||
| 1 |08:30-09:00||||||||
| 2 |09:00-09:30||||||||
| 3 |09:30-10:00||||||||
| 4 |10:00-10:30||||||||
| 5 |10:30-11:00||||||||
| 6 |11:00-11:30||||||||
| 7 |11:30-12:00||||||||
| 8 |12:00-12:30||||||||
| 9 |12:30-13:00||||||||
|10 |13:00-13:30||||||||
|11 |13:30-14:00||||||||
|12 |14:00-14:30||||||||
|13 |14:30-15:00||||||||
|14 |15:00-15:30||||||||
|15 |15:30-16:00||||||||
|16 |16:00-16:30||||||||
|17 |16:30-17:00||||||||
