Zaimplementowane zasady gry:

Poker 5-kartowy dobierany, w którym po rozpoczęciu rozgrywki każdy gracz dostaje 5 kart,
Następnie rozpoczyna się faza wymiany kart gdzie każdy gracz decyduje jakie karty w talii chce wymienić,
Po tej fazie następuje faza weryfikacji rąk graczy gdzie określana jest wartość ręki gracza oraz jego najwyższej karty.
Punkty za figury przyznawane są następująco:
Poker - 1000
Kareta - 900
Full - 800
Kolor - 700
Strit - 600
Trójka - 500
Dwie pary - 400
Para - 300
Wysoka karta - 200
W przypadku remisu punktów wygrywa gracz z wyższą najwyższą kartą.
Punkty za karty przyznawane są następująco:
As - 60
Król - 55
Dama - 50
Walet - 45
10 - 40
9 - 35
8 - 30
7 - 25
6 - 20
5 - 15
4 - 10
3 - 5
2 - 0
Punkty za kolor przyznawane są następująco:
Pik - 3
Kier - 2
Karo - 1
Trefl - 0

Sposób uruchomienia:

W pierwszej kolejności należy zbudować projekt za pomocą polecenia mvn clean install
Następnie uruchamiamy aplikację z terminala.
Najpierw uruchamiamy server. Będąc w katalogu głównym projektu należy użyć polecenia: java -jar poker-server/target/poker-server-1.0-SNAPSHOT-jar-with-dependencies.jar x
Gdzie x symbolizuje liczbę graczy, którzy będą wzięli udział w rozgrywce.
W przypadku złego formatu liczby graczy, serwer przyjmie domyślną wartość 4.

Następnie uruchamiamy klientów. Będąc w katalogu głównym projektu należy użyć polecenia: java -jar poker-client/target/poker-client-1.0-SNAPSHOT-jar-with-dependencies.jar x
Gdzie x symbolizuje port, do którego chcemy się połączyć. Domyślnie serwer nasłuchuje na porcie 8000.

Serwer jest odpowiedzialny za prowadzenie rozgrywki, komunikuje się z graczami, odbiera i przetwarza ich wiadomości.

Możliwe komunikaty:

- "Starting server" - komunikat informujący o rozpoczęciu działania serwera
- "Server started" - komunikat informujący o poprawnym uruchomieniu serwera
- "Choose your cards to discard..." - komunikat informujący o możliwości wymiany kart
- "Waiting for players..." - komunikat informujący o oczekiwaniu na graczy
- "Connection error" - komunikat informujący o błędzie połączenia
- "Wrong number of players..." - komunikat informujący o błędzie w liczbie graczy
- " [x/y] players connected" - komunikat informujący o liczbie graczy, którzy dołączyli do rozgrywki
- "Sending cards..." - komunikat informujący o wysyłaniu kart do graczy
- "Sent cards to player..." - komunikat informujący o wysłaniu kart do gracza
- "No cards were exchanged" - komunikat informujący o tym, że gracz nie wymienił kart
- "Game over" - when one of the players has left the game
- "Starting client..." - komunikat informujący o rozpoczęciu działania klienta
- "Connected to server" - komunikat informujący o dołączeniu do serwera
- "Cards sent to server" - komunikat informujący o wysłaniu kart do serwera
- "If you want to play another round ..." - pytanie o chęć kolejnej rozgrywki
