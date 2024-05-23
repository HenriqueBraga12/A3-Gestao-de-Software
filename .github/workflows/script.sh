#!/bin/bash

# Configurações FTP
FTP_SERVER="joaobsjunior.com.br"
FTP_USER="aluno-ftp"
FTP_PASS="a1b2c3d4@"
FTP_DIR="A3-Gestao-de-Software"

# Diretório local dos relatórios gerados pelo JaCoCo
LOCAL_DIR="/projetoA3/target/site/jacoco/"

# Comando para gerar os relatórios com o JaCoCo
./gradlew jacocoTestReport  # Substitua pelo comando correto para gerar os relatórios

# Comando para enviar os relatórios para o servidor FTP
cd "$LOCAL_DIR" || exit
ftp -n "$FTP_SERVER" <<END_SCRIPT
quote USER "$FTP_USER"
quote PASS "$FTP_PASS"
mkdir "$FTP_DIR"
cd "$FTP_DIR"
mput *
quit
END_SCRIPT