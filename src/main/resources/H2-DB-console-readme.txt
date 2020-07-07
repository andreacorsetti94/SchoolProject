se nel file "/src/main/resources/application.properties" è presente la configurazione:

spring.h2.console.enabled=true

quando fai partire l'applicazione puoi aprire la console h2 tramite cui poter vedere il database a questo link:
http://localhost:8080/h2-console

Ricorda che il JDBC URL è il seguente: jdbc:h2:mem:testdb




A ogni startup dell'applicazione vengono eseguite le insert presenti in "data.sql". Quindi se inserisci un record
x, chiudi l'app e la riapri, quando la riapri il record X non sarà presente, ma ci saranno solo i record inseriti
tramite data.sql