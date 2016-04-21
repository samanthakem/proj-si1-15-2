# Projeto de Sistemas de Informação I - 2015.2
Repositório para o projeto da disciplina Sistemas de Informação I do curso de Ciência da Computação na Universidade Federal de Campina Grande.

## Integrantes
 - Aline Costa
 - Gustavo Oliveira
 - Rafaella Chaves
 - Samantha Monteiro
 - Stênio Araújo

## Caronae

Sistema que permite que estudantes da UFCG possam requisitar e oferecer carona para outros estudantes da UFCG.

## Instalação

1. Você precisa de git instalado em sua máquina.
 - Vá ao site https://git-scm.com/book/en/v2/Getting-Started-Installing-Git que você encontrará o passo-a-passo de como instalar.

2. Uma vez que você estiver com git em sua máquina, clone o repositório do projeto.

```bash
git clone https://github.com/samanthakem/proj-si1-15-2.git
``` 

3. Você também precisará do play framework instalado em sua máquina.

 - Ver tutorial em: https://www.playframework.com/documentation/1.2/guide1#aInstallingthePlayframeworka

4. Instale o node.js em sua máquina.

 - Vá ao site nodejs.org que você encontrará informações de como instalar o mesmo de acordo com o sistema operacional instalado em sua máquina.

5. Com o node.js em sua máquina, execute o sequinte comando no terminal:

```bash
npm install -g grunt-cli yo bower ruby-dev
``` 

6. Com o ruby instalado, agora você poderá instalar compass:

- Ver tutorial em: http://compass-style.org/install/

7. Agora, vá na pasta client e instale as dependencias através dos seguintes comandos:

```bash
npm install 
```

```bash
bower install
```

8. Por último, rode a aplicação:

```bash
grunt serve
```
