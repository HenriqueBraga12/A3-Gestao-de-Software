#!/bin/bash

# Configurações FTP
FTP_SERVER="joaobsjunior.com.br"
FTP_USER="aluno-ftp"
FTP_PASS="a1b2c3d4@"
FTP_DIR="A3-Gestao-de-Software"

# Diretório local dos relatórios gerados pelo JaCoCo
LOCAL_DIR="target/site/jacoco/"

# Verifica se o diretório de relatórios existe
if [ -d "$LOCAL_DIR" ]; then
  # Comando para enviar os relatórios para o servidor FTP
  cd "$LOCAL_DIR" 
 ftp -n "$FTP_SERVER" <<END_SCRIPT
quote USER "$FTP_USER"
quote PASS "$FTP_PASS"
mkdir "$FTP_DIR"
cd "$FTP_DIR"
lcd $LOCAL_DIR
mput *
quit
END_SCRIPT
else
  echo "Diretório de relatórios não encontrado: $LOCAL_DIR"
  exit 1
fi
