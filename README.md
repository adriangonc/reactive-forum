<h1 align="center"> Reactive forum </h1>
<p align="center"> POC API Kotlin para estudo de tecnologias como. Eventos kafka, Reativo, REST, NoSql etc. </p>

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge)

# Stack
- Kotlin
- Spring WebFlux
- JPA
- Cache
- Spring security
- Docker

# Swagger
http://localhost:8080/webjars/swagger-ui/index.html#/

# Dockerfile
- Construir: "docker build -t forum -f Dockerfile ."
- Executar: "docker run -p 3080:8080 forum"

# Deploy Heroku
###Criar app: 
heroku create
###Add app git: 
heroku git:remote -a <appName> ex: 'vast-plains-39497'

###Login heroku register: 
heroku container:login
###Push container 'deve ser executado no diretório do dockerfile': 
heroku container:push web
###Release 
heroku container:release web